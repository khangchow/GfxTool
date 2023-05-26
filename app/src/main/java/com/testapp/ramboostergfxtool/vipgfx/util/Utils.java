package com.testapp.ramboostergfxtool.vipgfx.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

public class Utils {
    private static final String MARKET_DETAILS_ID = "market://details?id=";
    private static final String PLAY_STORE_LINK = "https://play.google.com/store/apps/details?id=";
    public static boolean isPackageInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void getDownloadVersion(Context context, String appId) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MARKET_DETAILS_ID + appId)));
        } catch (ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(PLAY_STORE_LINK + appId)));
        }
    }
}
