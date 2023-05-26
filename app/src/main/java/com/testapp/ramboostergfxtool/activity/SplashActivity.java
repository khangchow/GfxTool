package com.testapp.ramboostergfxtool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.ads.AdControl;
import com.testapp.ramboostergfxtool.ads.AdControlHelp;


public class SplashActivity extends AppCompatActivity {
    AdControl adControl;
    AdControlHelp adControlHelp;
    Handler handler = new Handler();
    public boolean isStill_startMainActivity = true;
    Runnable runnable;

    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(512, 512);
        this.adControl = AdControl.getInstance(this);
        this.adControlHelp = AdControlHelp.getInstance(this);
        Runnable runnable = new Runnable() {
            @Override
            public final void run() {
                SplashActivity.this.mSplashStart();
            }
        };
        this.runnable = runnable;
        this.handler.postDelayed(runnable, 8000L);
        AdControlHelp.FireBaseListener fireBaseListener = new AdControlHelp.FireBaseListener() {
            @Override
            public void addOnCompleteListener() {
                SplashActivity.this.adControlHelp.mobileAdsInitialize(SplashActivity.this, new AdControlHelp.MobileAdsInitialize() {
                    @Override
                    public void onInitialized() {
                        if (SplashActivity.this.isStill_startMainActivity) {
                            SplashActivity.this.startMainActivity();
                            SplashActivity.this.finish();
                        }
                    }
                });
            }
        };
        if (this.adControlHelp.is_reload_firebase()) {
            Log.v("firebase_ads", "reload Firebase: True");
            this.adControlHelp.getAdControlFromFireBase(fireBaseListener);
            return;
        }
        Log.v("firebase_ads", "reload Firebase: False");
        fireBaseListener.addOnCompleteListener();
    }

    public void mSplashStart() {
        this.isStill_startMainActivity = false;
        startMainActivity();
        finish();
    }

    @Override
    public void onDestroy() {
        Log.v("test", "On Destroy");
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.runnable);
        }
        super.onDestroy();
    }

    @Override
    public void finish() {
        Log.v("test", "On Finish");
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.runnable);
        }
        super.finish();
    }
}
