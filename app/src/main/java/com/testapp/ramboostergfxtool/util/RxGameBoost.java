package com.testapp.ramboostergfxtool.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.testapp.ramboostergfxtool.rx.DisposableManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxGameBoost {
    public static  class rx implements ObservableOnSubscribe {
        public final  Context a;
        public final  String b;

        public rx(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override
        public final void subscribe(ObservableEmitter observableEmitter) {
            RxGameBoost.a(this.a, this.b, observableEmitter);
        }
    }
    static  void a(Context context, String str, ObservableEmitter observableEmitter) {
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        if (!observableEmitter.isDisposed()) {
            ArrayList arrayList = new ArrayList(Utils.getSystemPackages());
            @SuppressLint("WrongConstant") ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (Build.VERSION.SDK_INT < 21) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (observableEmitter.isDisposed()) {
                        break;
                    } else if (!arrayList.contains(runningAppProcessInfo.processName) && !str.equals(runningAppProcessInfo.processName) && (applicationInfo = Utils.getApplicationInfo(context, runningAppProcessInfo.processName)) != null && Utils.isUserApp(applicationInfo)) {
                        try {
                            activityManager.killBackgroundProcesses(runningAppProcessInfo.processName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (Utils.hasUsagePermission(context)) {
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                long timeInMillis2 = Calendar.getInstance().getTimeInMillis() - TimeUnit.HOURS.toMillis(1);
                @SuppressLint("WrongConstant") UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
                Objects.requireNonNull(usageStatsManager);
                List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(0, timeInMillis2, timeInMillis);
                if (queryUsageStats != null && !queryUsageStats.isEmpty()) {
                    for (UsageStats usageStats : queryUsageStats) {
                        if (observableEmitter.isDisposed()) {
                            break;
                        } else if (usageStats != null && !arrayList.contains(usageStats.getPackageName()) && !str.equals(usageStats.getPackageName()) && (applicationInfo2 = Utils.getApplicationInfo(context, usageStats.getPackageName())) != null && Utils.isUserApp(applicationInfo2)) {
                            try {
                                activityManager.killBackgroundProcesses(usageStats.getPackageName());
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        if (!observableEmitter.isDisposed()) {
            observableEmitter.onComplete();
        }
    }

    public void startGameBoost(Context context, String str) {
        DisposableManager.add(Observable.create(new rx(context, str)).subscribeOn(Schedulers.io()).subscribe());


}}
