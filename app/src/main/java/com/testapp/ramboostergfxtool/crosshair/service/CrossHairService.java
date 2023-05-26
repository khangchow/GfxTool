package com.testapp.ramboostergfxtool.crosshair.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import android.view.WindowManager;
import android.widget.ImageView;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.crosshair.common.Const;
import com.testapp.ramboostergfxtool.crosshair.utils.SharePreferenceUtils;

public class CrossHairService extends Service {
    private ImageView imgCrossHair;
    private WindowManager.LayoutParams params;
    private SharePreferenceUtils sharePreferenceUtils;
    private WindowManager windowManager;

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @TargetApi(21)
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            int intValue = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_COLOR, SupportMenu.CATEGORY_MASK);
            int intValue2 = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_CROSS_HAIR, R.drawable.ic_chr_01);
            int intValue3 = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_SIZE, 100);
            int intValue4 = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_POSITION_X, 0);
            int intValue5 = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_POSITION_Y, 0);
            int intValue6 = this.sharePreferenceUtils.getIntValue(Const.KEY_SHARE_OPCACITY, 100);
            if (this.windowManager == null) {
                this.windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            }
            if (this.imgCrossHair == null) {
                this.imgCrossHair = new ImageView(this);
            }
            this.imgCrossHair.setImageResource(intValue2);
            this.imgCrossHair.setImageTintList(ColorStateList.valueOf(intValue));
            this.params = new WindowManager.LayoutParams(-2, -2, Build.VERSION.SDK_INT >= 26 ? 2038 : 2002, 8, -3);
            this.params.gravity = 17;
            this.params.alpha = ((float) intValue6) / 100.0f;
            this.params.width = intValue3;
            this.params.height = intValue3;
            this.params.x = intValue4;
            this.params.y = -intValue5;
            if (intent == null || intent.getAction() == null || !intent.getAction().equals(Const.KEY_ACTION_IS_UPDATE)) {
                this.windowManager.addView(this.imgCrossHair, this.params);
            } else {
                this.windowManager.updateViewLayout(this.imgCrossHair, this.params);
            }
            return super.onStartCommand(intent, i, i2);
        } catch (Exception unused) {
            return Service.START_STICKY_COMPATIBILITY;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.sharePreferenceUtils = new SharePreferenceUtils(this);
        new IntentFilter().addAction("android.intent.action.VIEW");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        ImageView imageView = this.imgCrossHair;
        if (imageView != null) {
            this.windowManager.removeView(imageView);
        }
    }
}
