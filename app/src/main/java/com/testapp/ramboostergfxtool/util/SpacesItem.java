package com.testapp.ramboostergfxtool.util;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.testapp.ramboostergfxtool.MyApp;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SpacesItem {
    public static final String TAG = "Utils";

    public static int intV(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int gWidth(Context context) {
        return mRect(context).width();
    }

    public static Rect mRect(Context context) {
        DisplayMetrics displayMetrics = metric(context);
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static DisplayMetrics metric(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public static long valR() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    String trim = str.split(" ")[0].trim();
                    Log.d(TAG, "memTotal: " + trim);
                    return Long.parseLong(trim);
                } else if (readLine.contains("MemTotal")) {
                    str = readLine.split(":")[1].trim();
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
            return 0;
        }
    }

    public static long appInf(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static boolean isPref() {
        return PreferenceManager.getDefaultSharedPreferences(MyApp.getMyApp()).getBoolean(Utils.KEY_AUTO_BOOST, false) && Utils.m703a(MyApp.getMyApp());
    }

    public static void listLog(List<String> list, String str) {
        MyLog.name2(TAG, "excludePkg = " + str);
        List<MyAppInfo> myAppInfos = AppWhiteList.getInstance().m692c();
        HashMap hashMap = new HashMap();
        if (myAppInfos != null && myAppInfos.size() > 0) {
            for (MyAppInfo myAppInfo : myAppInfos) {
                MyLog.name2(TAG, "white pkg = " + myAppInfo.string);
                hashMap.put(myAppInfo.string, myAppInfo.string);
            }
        }
        for (String str2 : list) {
            if (str2 != null) {
                if (str2.contains("com.testapp.") || str2.contains("com.android.") || TextUtils.equals(AbstractSpiCall.ANDROID_CLIENT_TYPE, str2) || ((!TextUtils.isEmpty(str) && str2.contains(str)) || hashMap.containsKey(str2))) {
                    MyLog.name2(TAG, "not kill app = " + str2);
                } else {
                    MyLog.name2(TAG, "kill app = " + str2);
                    ((ActivityManager) MyApp.getMyApp().getSystemService(Context.ACTIVITY_SERVICE)).killBackgroundProcesses(str2);
                }
            }
        }
    }
}
