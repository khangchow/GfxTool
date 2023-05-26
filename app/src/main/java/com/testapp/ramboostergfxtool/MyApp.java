package com.testapp.ramboostergfxtool;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.testapp.ramboostergfxtool.services.GameModeService;
import com.testapp.ramboostergfxtool.util.PrefHelper;

import java.io.File;

public class MyApp extends MultiDexApplication {
    private static Context context;
    private static MyApp myApp;
    public File file;


    public boolean checkFileExist() {
        File file2 = this.file;
        if (file2 == null) {
            return false;
        }
        return file2.exists();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            MultiDex.install(this);
        } catch (Exception e) {

        }
        myApp = this;
        PrefHelper.getInstance().putKeyGm();
        context = getApplicationContext();
        createChannelNotification();
    }

    public static MyApp getMyApp() {
        return myApp;
    }

    public static Context getContext() {
        return context;
    }

    private void createChannelNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    GameModeService.CHANNEL_ID,
                    GameModeService.CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationChannel.setSound(null, null);
            getSystemService(NotificationManager.class).createNotificationChannel(notificationChannel);
        }
    }
}
