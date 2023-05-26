package com.testapp.ramboostergfxtool.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.testapp.ramboostergfxtool.R
import com.testapp.ramboostergfxtool.activity.WhitelistActivity
import com.testapp.ramboostergfxtool.util.AppList
import com.testapp.ramboostergfxtool.util.AppSelectInfo
import com.testapp.ramboostergfxtool.util.ContactList

class WhitelistAdapter<T>(
    private var data: List<T>,
    private val onAppClicked: ((String, Boolean) -> Unit)? = null,
    private val onContactClicked: ((ContactList) -> Unit)? = null,
    private val type: String
) : RecyclerView.Adapter<WhitelistAdapter.WhiteListViewHolder>() {

    class WhiteListViewHolder(val view: View) : ViewHolder(view) {
        val imageIcon: ImageView by lazy { view.findViewById(R.id.image_icon) }
        val imgAddApp: ImageView by lazy { view.findViewById(R.id.img_add_app) }
        val textAppName: TextView by lazy { view.findViewById(R.id.text_app_name) }
        val addAppLayoutContent: RelativeLayout by lazy { view.findViewById(R.id.add_app_layout_content) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WhiteListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_white_app, parent, false)
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: WhiteListViewHolder, position: Int) {
        when (type) {
            WhitelistActivity.KEY_CLEAR_BACKGROUND_WHITELIST -> {
                (data[position] as AppSelectInfo).let { app ->
                    holder.apply {
                        imageIcon.setImageDrawable(app.myAppInfo.drawable)
                        textAppName.text = app.myAppInfo.charSequence
                        imgAddApp.setImageResource(if (app.aBoolean) R.drawable.ic_switch_button_on else R.drawable.ic_switch_button_off)
                        addAppLayoutContent.setOnClickListener {
                            app.aBoolean = app.aBoolean.not()
                            imgAddApp.setImageResource(if (app.aBoolean) R.drawable.ic_switch_button_on else R.drawable.ic_switch_button_off)
                            onAppClicked?.invoke(app.myAppInfo.string, app.aBoolean)
                        }
                    }
                }
            }
            WhitelistActivity.KEY_REJECT_CALL_WHITELIST -> {
                (data[position] as ContactList).let { contact ->
                    holder.apply {
                        imageIcon.setImageResource(R.drawable.ic_user)
                        textAppName.text = contact.name
                        imgAddApp.setImageResource(if (contact.isAdded) R.drawable.ic_switch_button_on else R.drawable.ic_switch_button_off)
                        addAppLayoutContent.setOnClickListener {
                            contact.isAdded = contact.isAdded.not()
                            imgAddApp.setImageResource(if (contact.isAdded) R.drawable.ic_switch_button_on else R.drawable.ic_switch_button_off)
                            onContactClicked?.invoke(contact)
                        }
                    }
                }
            }
            WhitelistActivity.KEY_NOTIFICATION_BLOCKING_WHITELIST -> {
                (data[position] as AppList).let { app ->
                    holder.apply {
                        imageIcon.setImageDrawable(app.icon)
                        textAppName.text = app.name
                        imgAddApp.setImageResource(if (app.isAdded) R.drawable.ic_switch_button_on else R.drawable.ic_switch_button_off)
                        addAppLayoutContent.setOnClickListener {
                            app.isAdded = app.isAdded.not()
                            imgAddApp.setImageResource(if (app.isAdded) R.drawable.ic_switch_button_on else R.drawable.ic_switch_button_off)
                            onAppClicked?.invoke(app.pkgName, app.isAdded)
                        }
                    }
                }
            }
        }
    }

    fun updateData(data: List<T>) {
        this.data = data
        notifyDataSetChanged()
    }
}