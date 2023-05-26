package com.testapp.ramboostergfxtool.activity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testapp.ramboostergfxtool.R
import com.testapp.ramboostergfxtool.WhitelistViewModel
import com.testapp.ramboostergfxtool.adapter.WhitelistAdapter
import com.testapp.ramboostergfxtool.ads.AdControlHelp
import com.testapp.ramboostergfxtool.util.AppList
import com.testapp.ramboostergfxtool.util.AppSelectInfo
import com.testapp.ramboostergfxtool.util.ContactList

class WhitelistActivity : AppCompatActivity() {
    private val whitelistType by lazy { intent.getStringExtra(KEY_WHITELIST) ?: "" }
    private val whitelistViewModel by lazy { ViewModelProvider(this)[WhitelistViewModel::class.java] }
    private lateinit var rvWhiteList: RecyclerView
    private lateinit var toolbar: Toolbar
    private lateinit var rlLoading: RelativeLayout
    private val readContactPermission = "android.permission.READ_CONTACTS"
    private val writeContactPermission = "android.permission.WRITE_CONTACTS"
    private val contactPermissions = arrayOf(
        readContactPermission, writeContactPermission
    )
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            if (it[readContactPermission] == true && it[writeContactPermission] == true) {
                getData()
            }
        }

    private fun isContactPermissionsGranted(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkSelfPermission(readContactPermission) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(writeContactPermission) == PackageManager.PERMISSION_GRANTED
        } else true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whitelist)
        initViews()
        setUpView()
        observeValues()
        if (isContactPermissionsGranted().not()) {
            requestPermissionLauncher.launch(contactPermissions)
        } else {
            getData()
        }
    }

    private fun getData() {
        whitelistViewModel.initData(whitelistType)
        rlLoading.visibility = View.VISIBLE
    }

    private fun initViews() {
        rvWhiteList = findViewById(R.id.rv_whitelist_item)
        rlLoading = findViewById(R.id.rl_loading)
        toolbar = findViewById<Toolbar?>(R.id.toolbar).also { setSupportActionBar(it) }
        AdControlHelp.getInstance(this).loadBanner(this, findViewById(R.id.banner_ads))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_left_white)
        }
        toolbar.setNavigationOnClickListener { this.finish() }
    }

    private fun setUpView() {
        rvWhiteList.apply {
            layoutManager = LinearLayoutManager(this@WhitelistActivity)
            when (whitelistType) {
                KEY_CLEAR_BACKGROUND_WHITELIST -> {
                    toolbar.title = getString(R.string.clear_background_whitelist)
                    adapter = WhitelistAdapter<AppSelectInfo>(emptyList(), onAppClicked = { pkgName, isAdd ->
                        whitelistViewModel.updateWhiteListApp(pkgName, isAdd)
                    }, type = whitelistType)
                }
                KEY_REJECT_CALL_WHITELIST -> {
                    toolbar.title = getString(R.string.reject_calls_whitelist)
                    adapter = WhitelistAdapter<ContactList>(emptyList(), onContactClicked =  { contact ->
                        whitelistViewModel.updateRejectCallWhiteListContact(contact)
                    }, type = whitelistType)
                }
                KEY_NOTIFICATION_BLOCKING_WHITELIST -> {
                    toolbar.title = getString(R.string.notification_blocking_whitelist)
                    adapter = WhitelistAdapter<AppSelectInfo>(emptyList(), onAppClicked = { pkgName, isAdd ->
                        whitelistViewModel.updateWhiteListApp(pkgName, isAdd)
                    }, type = whitelistType)
                }
            }
        }
    }

    private fun observeValues() {
        whitelistViewModel.apply {
            clearBackgroundWhiteList.observe(this@WhitelistActivity) {
                (rvWhiteList.adapter as WhitelistAdapter<AppSelectInfo>).updateData(it)
                rlLoading.visibility = View.INVISIBLE
            }
            rejectCallsWhiteList.observe(this@WhitelistActivity) {
                (rvWhiteList.adapter as WhitelistAdapter<ContactList>).updateData(it)
                rlLoading.visibility = View.INVISIBLE
            }
            notificationBlockingWhiteList.observe(this@WhitelistActivity) {
                (rvWhiteList.adapter as WhitelistAdapter<AppList>).updateData(it)
                rlLoading.visibility = View.INVISIBLE
            }
        }
    }

    companion object {
        const val KEY_REJECT_CALL_WHITELIST = "KEY_REJECT_CALL_WHITELIST"
        const val KEY_CLEAR_BACKGROUND_WHITELIST = "KEY_CLEAR_BACKGROUND_WHITELIST"
        const val KEY_NOTIFICATION_BLOCKING_WHITELIST = "KEY_NOTIFICATION_BLOCKING_WHITELIST"
        const val KEY_WHITELIST = "KEY_WHITELIST"

        fun getIntent(key: String, activity: Activity) = Intent(activity, WhitelistActivity::class.java).apply {
            putExtra(KEY_WHITELIST, key)
        }
    }
}