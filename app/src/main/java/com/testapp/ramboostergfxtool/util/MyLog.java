package com.testapp.ramboostergfxtool.util;

import android.util.Log;

public class MyLog {
    public static boolean isLog = true;

    public static void name1(String str, String str2) {
        if (isLog) {
            Log.i(str, str2);
        }
    }

    public static void name2(String str, String str2) {
        if (isLog) {
            Log.d(str, str2);
        }
    }

    public static void name3(String str, String str2) {
        if (isLog) {
            Log.w(str, str2);
        }
    }



}
