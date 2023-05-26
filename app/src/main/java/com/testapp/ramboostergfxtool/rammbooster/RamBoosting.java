package com.testapp.ramboostergfxtool.rammbooster;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import com.testapp.ramboostergfxtool.util.PrefHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RamBoosting {
    public static float RamBoosting(Context context) {
        if (context == null) {
            return Float.intBitsToFloat(1);
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryInfo(memoryInfo);
        return (float) memoryInfo.availMem;
    }

    public static String covertS(long j) {
        if (j <= 0) {
            return "0";
        }
        double d = (double) j;
        int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        StringBuilder sb = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.#");
        double pow = Math.pow(1024.0d, (double) log10);
        Double.isNaN(d);
        sb.append(decimalFormat.format(d / pow));
        sb.append(" ");
        sb.append(new String[]{"B", "KB", "MB", "GB", "TB"}[log10]);
        return sb.toString();
    }

    public static boolean isPack(PackageInfo packageInfo) {
        return (packageInfo.applicationInfo.flags & 1) != 0;
    }

    public static boolean isBat(Context context) {
        if (Build.VERSION.SDK_INT >= 21 && ((AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE)).checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static ArrayList<RammBoosterInstalledPackage> mListPack(Context context) {
        ArrayList<RammBoosterInstalledPackage> arrayList = new ArrayList<>();
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            if (!packageInfo.packageName.equals(context.getPackageName())) {
                String charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
                String str = packageInfo.packageName;
                arrayList.add(new RammBoosterInstalledPackage(context, str, charSequence, null, PrefHelper.getInstance().isPutN(str), isPack(packageInfo), PrefHelper.getInstance().isPackGm(str)));
            }
        }
        return arrayList;
    }

    public static void ramBo(String str, ActivityManager activityManager, boolean z) {
        ramFor(str, activityManager);
        if (!z) {
            try {
                appIgnore(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void ramFor(String str, ActivityManager activityManager) {
        if ((Build.MANUFACTURER == null || !Build.MANUFACTURER.contains("LGE")) && str != null && activityManager != null) {
            try {
                activityManager.killBackgroundProcesses(str);
            } catch (Exception e) {
                e.printStackTrace();
                activityManager.restartPackage(str);
            }
        }
    }

    public static void appIgnore(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                getProcessN("cmd appops set " + str + " RUN_IN_BACKGROUND ignore");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void getProcessN(String str) {

        try {
            java.lang.Process exec = Runtime.getRuntime().exec(str);
            while (new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine() != null) {
            }
            exec.waitFor();
        } catch (IOException | InterruptedException unused) {
        }
    }


}
