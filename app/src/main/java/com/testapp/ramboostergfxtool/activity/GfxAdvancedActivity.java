package com.testapp.ramboostergfxtool.activity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.multidex.BuildConfig;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.adapter.TabLayoutAdapter;
import com.testapp.ramboostergfxtool.ads.AdControlHelp;

import java.util.ArrayList;

public class GfxAdvancedActivity extends AppCompatActivity {
    private int WRITE_PERMISSION = 3;
    private TabLayoutAdapter myAdapter;
    private ViewPager viewPager;
    public class OnDismissButtonClick implements DialogInterface.OnClickListener {
        final GfxAdvancedActivity gfxAdvancedActivity;
        OnDismissButtonClick(GfxAdvancedActivity gfxAdvancedActivity2) {
            this.gfxAdvancedActivity = gfxAdvancedActivity2;
        }
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            this.gfxAdvancedActivity.finish();
            Log.w("GFX Tool", "Required permissions were denied!");
        }
    }
    public class OnAskAgainButtonClick implements DialogInterface.OnClickListener {
        final GfxAdvancedActivity gfxAdvancedActivity;
        OnAskAgainButtonClick(GfxAdvancedActivity gfxAdvancedActivity2) {
            this.gfxAdvancedActivity = gfxAdvancedActivity2;
        }
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            this.gfxAdvancedActivity.askForPermission();
        }
    }
    @TargetApi(23)
    private void askForPermission() {
        if (!getApplicationContext().getPackageName().equals(BuildConfig.APPLICATION_ID)) {
            finish();
        }
        int checkSelfPermission = checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        ArrayList arrayList = new ArrayList();
        if (checkSelfPermission != 0) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!arrayList.isEmpty()) {
            requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), this.WRITE_PERMISSION);
        }
    }

    @TargetApi(23)
    private boolean isGranted() {
        return checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED;
    }

    @TargetApi(23)
    private void showPermissionAlert() {
        boolean z;
        String string = getString(R.string.perm_unknown);
        if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != PackageManager.PERMISSION_GRANTED) {
            Log.e("GFX Tool", "Storage permission not granted!");
            z = true;
        } else {
            z = false;
        }
        if (z) {
            string = getString(R.string.perm_storage);
        }
        new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.denied_title)).setMessage(string).setPositiveButton(getResources().getString(R.string.ask_again), new OnAskAgainButtonClick(this)).setNegativeButton(getResources().getString(R.string.dismiss), new OnDismissButtonClick(this)).show();
    }
    AdControlHelp adControlHelp;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gfx_advanced);
        if (Build.VERSION.SDK_INT >= 23 && !isGranted()) {
            askForPermission();
        }
        this.myAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        this.viewPager = (ViewPager) findViewById(R.id.container);
        this.viewPager.setAdapter(this.myAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        this.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                GfxAdvancedActivity.this.viewPager.setCurrentItem(tab.getPosition());
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.gfx_tools_advanced));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.base_color));
        }
        AdControlHelp adControlHelp = AdControlHelp.getInstance(this);
        this.adControlHelp = adControlHelp;
        adControlHelp.loadBanner(this, findViewById(R.id.banner));

    }

    @Override
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (isGranted()) {
            Log.i("GFX Tool", "All required permissions were granted");
        } else if (shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
            showPermissionAlert();
        } else {
            Toast.makeText(this, getString(R.string.perm_toast), Toast.LENGTH_LONG).show();
        }
    }


}
