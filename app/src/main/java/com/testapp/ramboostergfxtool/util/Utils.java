package com.testapp.ramboostergfxtool.util;

import android.accounts.NetworkErrorException;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.multidex.BuildConfig;

import com.testapp.ramboostergfxtool.MyApp;
import com.testapp.ramboostergfxtool.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class Utils {
    private static final String PERMISSION_UTIL = "PermissionUtils";
    public static final String KEY_AUTO_BOOST = "KEY_AUTO_BOOST";
    public static final String PACK_STAT_HELPER = "PackageStateHelper";
    private static final String PLAY_STORE_LINK = "https://play.google.com/store/apps/details?id=";
    private static final String text = "Check out " + ", the free app for GFX Tools and Game Booster" ;
    public static Context context;
    private static Utils mUtil = new Utils();

    public static Utils getUtil() {
        return mUtil;
    }

   
    private String appProcess() {
        if (((KeyguardManager) MyApp.getMyApp().getSystemService(Context.KEYGUARD_SERVICE)).inKeyguardRestrictedInputMode()) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) MyApp.getMyApp().getSystemService(Context.ACTIVITY_SERVICE)).getRunningAppProcesses()) {
            MyLog.name1(PACK_STAT_HELPER, "info.processName:" + runningAppProcessInfo.processName);
            boolean z = (runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200) ? false : true;
            MyLog.name1(PACK_STAT_HELPER, "processName:" + runningAppProcessInfo.processName + " isBackground:" + z);
            if (!z) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    @RequiresApi(api = 21)
    public static String getPackageStats() {
        UsageStatsManager usageStatsManager = (UsageStatsManager) MyApp.getMyApp().getSystemService(Context.USAGE_STATS_SERVICE);
        if (usageStatsManager == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(0, currentTimeMillis - 30000, currentTimeMillis);
        if (queryUsageStats == null) {
            return null;
        }
        TreeMap treeMap = new TreeMap();
        for (UsageStats usageStats : queryUsageStats) {
            treeMap.put(Long.valueOf(usageStats.getLastTimeUsed()), usageStats);
        }
        if (treeMap.size() == 0) {
            return null;
        }
        String packageName = ((UsageStats) treeMap.get(treeMap.lastKey())).getPackageName();
        MyLog.name2(PACK_STAT_HELPER, "Top activity package name = " + packageName);
        return packageName;
    }

    public String requst() {
        if (Build.VERSION.SDK_INT >= 21) {
            return getPackageStats();
        }
        return appProcess();
    }

    public static boolean m703a(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            return ((AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE)).checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public static void askUSAGE(Activity activity) {
        try {
            activity.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
        } catch (Throwable th) {
            Log.w(PERMISSION_UTIL, th);
            Toast.makeText(activity, (int) R.string.please_enable_usage_access, Toast.LENGTH_SHORT).show();
        }
    }

    public static String URLConnect(String paramString) {
        URLConnection v1 = null;
        try {

            URL uRL = new URL(paramString);
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(10000);
                int i = httpURLConnection.getResponseCode();
                if (i == 200) {
                    String str = Reader(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    return str;
                }

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("response status is ");
                stringBuilder.append(i);
                NetworkErrorException networkErrorException = new NetworkErrorException();
                throw networkErrorException;
            } catch (Exception exception) {
                if (httpURLConnection != null)
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable throwable1) {
                        if (paramString != null)
                            httpURLConnection.disconnect();
                        throw throwable1;
                    }
                return null;
            } catch (Throwable throwable1) {
                HttpURLConnection httpURLConnection1 = httpURLConnection;
                if(httpURLConnection1 != null) {
                    ((HttpURLConnection)httpURLConnection1).disconnect();
                }
            }
        } catch (Throwable throwable) {
            throwable = null;
        }

        if(v1 != null) {
            ((HttpURLConnection)v1).disconnect();
        }
        return null;
    }
    private static String Reader(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                byteArrayOutputStream.close();
                return byteArrayOutputStream2;
            }
        }
    }

    public static void geShareApp(Context context, String appid){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,PLAY_STORE_LINK+appid+text );
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

    @TargetApi(21)
    public static boolean hasUsagePermission(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        Objects.requireNonNull(appOpsManager);
        return appOpsManager.checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
    }
    public static List<String> getSystemPackages() {
        return Arrays.asList("system", "com.android.phone", "com.android.settings", "android.process.acore", BuildConfig.APPLICATION_ID);
    }
    public static ApplicationInfo getApplicationInfo(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0|PackageManager.MATCH_DEFAULT_ONLY);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean isUserApp(ApplicationInfo applicationInfo) {
        try {
            return (applicationInfo.flags & 1) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Drawable getAppIcon(Context context, String str) {
        try {
            Drawable applicationIcon = context.getPackageManager().getApplicationIcon(str);
            if (applicationIcon == null) {
                return ContextCompat.getDrawable(context, R.drawable.ic_app_default);
            }
            return applicationIcon;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return ContextCompat.getDrawable(context, R.drawable.ic_app_default);
        }
    }

    public static String getAppName(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        String string = context.getString(R.string.unknown);
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return (String) packageManager.getApplicationLabel(applicationInfo);
            }
            return string;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return string;
        }
    }

    public static boolean isPackageInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
