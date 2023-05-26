package com.testapp.ramboostergfxtool.vipgfx.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat.Builder;

import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.vipgfx.activity.HomeVipActivity;
import com.testapp.ramboostergfxtool.vipgfx.stringfog.xor.StringFogImpl;

public class foregroundService extends Service {
    public static final String CHANNEL_ID = StringFogImpl.decrypt("OyEkblA0OihIVA==");
    public static Context context;

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        context = this;
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int i, int i2) {
        String stringExtra = intent.getStringExtra(StringFogImpl.decrypt("PDo2WEwQLDJfWQ=="));
        createNotificationChannel();
        startForeground(69693, new Builder((Context) this, CHANNEL_ID).setContentTitle(StringFogImpl.decrypt("Ez0qSBg8J2ZJVyI6KkJZMT0oSg==")).setContentText(stringExtra).setSmallIcon((int) R.drawable.logo).setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, HomeVipActivity.class), 0)).build());
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void createNotificationChannel() {
        if (VERSION.SDK_INT >= 26) {
            String str = CHANNEL_ID;
            String decrypt = StringFogImpl.decrypt("MTE1Tko8JDJEVzs=");
            NotificationChannel notificationChannel = new NotificationChannel(str, str, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(decrypt);
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }
}
