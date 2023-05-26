package com.testapp.ramboostergfxtool.util;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.testapp.ramboostergfxtool.MyApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PrefHelper {
    private static PrefHelper prefHelper = null;
    private static final String prefKey = "KEY_APP_ADD_LIST";
    public static final String prefName = "com.testapp.xbooster.appmanager";
    private String[] stringArrays = {"com.dts.freefireth", "com.mobile.legends", "com.firsttouchgames.dls3", "catch_.me_.if_.you_.can_", "jp.konami.pesam", "com.axlebolt.standoff2", "com.roblox.client", "com.ea.gp.fifamobile", "com.titan.cd.gb", "com.tencent.iglite", "com.supercell.brawlstars", "com.mojang.minecraftpe", "com.criticalforceentertainment.criticalops", "com.oqqolcgkyihzx", "com.rockstargames.gtasa", "com.gameloft.android.ANMP.GloftM5HM", "com.netease.mrzhna", "com.garena.game.kgth", "com.netease.ko", "com.bypass.freefirg", "com.pubg.krmobile", "com.pubg.krmobile", "com.epsxe.ePSXe", "com.gamedevltd.modernstrike", "com.garena.game.fctw", "com.uxm", "com.ForgeGames.SpecialForcesGroup2", "com.garena.game.kgvn", "com.vng.pubgmobile", "company.gamesx.guitarflash", "com.woaqmznthrgnv.g.winr", "org.ppsspp.ppssppgold", "com.robtopx.geometryjump", "com.blayzegames.iosfps", "com.nekki.shadowfight", "com.netease.chiji", "com.tencent.ig", "com.ea.games.r3_row", "com.titan.cda.gb", "com.gameloft.android.ANMP.GloftNOHM", "com.ea.game.fifa14_row", "com.nexon.bnb2", "com.tencent.tmgp.cfmnac", "io.va.exposed", "com.vectorunit.purple.googleplay", "net.wargaming.wot.blitz", "com.pixel.gun3d", "catch_.me1.if_.you_.can_", "com.pixel.gun3d", "com.ChillyRoom.DungeonShooter", "com.gameloft.android.ANMP.GloftAGHM", "com.junesoftware.maskgun", "com.lulu.lulubox", "com.skgames.trafficrider", "com.ngame.allstar.eu", "com.dvloper.granny", "com.herogame.gplay.hopelessland", "com.netease.lztgglobal", "com.kiloo.subwaysurf"};

    private PrefHelper() {
    }

    public static PrefHelper getInstance() {
        if (prefHelper == null) {
            prefHelper = new PrefHelper();
        }
        return prefHelper;
    }

    public List<AppSelectInfo> mListInfo() {
        List<String> list = listNm();
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            AppSelectInfo appSelectInfo = new AppSelectInfo();
            appSelectInfo.myAppInfo = getPackNm(str);
            appSelectInfo.aBoolean = checkAppInList(str);
            arrayList.add(appSelectInfo);
        }
        Collections.sort(arrayList, MyComparator.comp);
        return arrayList;
    }

    public List<String> listNm() {
        ArrayList arrayList = new ArrayList();
        String packageName = MyApp.getMyApp().getPackageName();
        PackageManager packageManager = MyApp.getMyApp().getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        for (PackageInfo packageInfo : installedPackages) {
            if (!packageName.equals(packageInfo.packageName) && !isPack(packageInfo)) {
                intent.setPackage(packageInfo.packageName);
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                    arrayList.add(packageInfo.packageName);
                }
            }
        }
        return arrayList;
    }

    public List<MyAppInfo> getAppL() {
        List<String> asList = Arrays.asList(MyApp.getMyApp().getSharedPreferences(prefName, 0).getString(prefKey, "").split(","));
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        PackageManager packageManager = MyApp.getMyApp().getPackageManager();
        for (String str : asList) {
            if (!TextUtils.equals(str, MyApp.getMyApp().getPackageName())) {
                MyAppInfo appInfo = getPackNm(str);
                if (appInfo == null) {
                    putAppString(str);
                } else {
                    intent.setPackage(str);
                    List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        arrayList.add(appInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    public MyAppInfo getPackNm(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = MyApp.getMyApp().getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        PackageManager packageManager = MyApp.getMyApp().getPackageManager();
        MyAppInfo myAppInfo = new MyAppInfo();
        myAppInfo.string = str;
        myAppInfo.drawable = applicationInfo.loadIcon(packageManager);
        myAppInfo.charSequence = applicationInfo.loadLabel(packageManager);
        return myAppInfo;
    }

    public void putKeyDef(String str) {
        SharedPreferences sharedPreferences = MyApp.getMyApp().getSharedPreferences(prefName, 0);
        String string = sharedPreferences.getString(prefKey, "");
        if (!Arrays.asList(string.split(",")).contains(str)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(prefKey, string + str + ",");
            edit.apply();
        }
    }

    public void putKeyGm() {
        SharedPreferences sharedPreferences = MyApp.getMyApp().getSharedPreferences(prefName, 0);
        if (TextUtils.isEmpty(sharedPreferences.getString(prefKey, ""))) {
            HashMap hashMap = new HashMap();
            String[] strArr = this.stringArrays;
            for (String str : strArr) {
                hashMap.put(str, str);
            }
            List<String> m681c = listNm();
            StringBuilder sb = new StringBuilder();
            for (String str2 : m681c) {
                if (hashMap.containsKey(str2)) {
                    sb.append(str2 + ",");
                }
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(prefKey, sb.toString());
                edit.apply();
            }
        }
    }

    public boolean checkAppInList(String str) {
        List asList = Arrays.asList(MyApp.getMyApp().getSharedPreferences(prefName, 0).getString(prefKey, "").split(","));
        for (int i = 0; i < asList.size(); i++) {
            if (!TextUtils.isEmpty(str) && ((String) asList.get(i)).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void putAppString(String str) {
        SharedPreferences sharedPreferences = MyApp.getMyApp().getSharedPreferences(prefName, 0);
        List asList = Arrays.asList(sharedPreferences.getString(prefKey, "").split(","));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < asList.size(); i++) {
            if (!((String) asList.get(i)).equals(str)) {
                sb.append((String) asList.get(i));
                sb.append(",");
            }
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(prefKey, sb.toString());
        edit.apply();
    }

    public void mLtApp(List<MyAppInfo> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).string);
            sb.append(",");
        }
        SharedPreferences.Editor edit = MyApp.getMyApp().getSharedPreferences(prefName, 0).edit();
        edit.putString(prefKey, sb.toString());
        edit.apply();
    }

    public static boolean isPack(PackageInfo packageInfo) {
        return (packageInfo.applicationInfo.flags & 1) != 0;
    }

    public boolean isPutN(String str) {
        SharedPreferences sharedPreferences = MyApp.getMyApp().getSharedPreferences(prefName, 0);
        return sharedPreferences.getBoolean("KEY_PACKAGE_WHITELIST97" + str, false);
    }

    public void putApp(String str, boolean z) {
        SharedPreferences.Editor edit = MyApp.getMyApp().getSharedPreferences(prefName, 0).edit();
        edit.putBoolean("KEY_PACKAGE_WHITELIST97" + str, z);
        edit.apply();
    }

    public boolean isPackGm(String str) {
        SharedPreferences sharedPreferences = MyApp.getMyApp().getSharedPreferences(prefName, 0);
        return sharedPreferences.getBoolean("KEY_PACKAGE_GAME858" + str, false);
    }

    public void isPutPref(String str, boolean z) {
        SharedPreferences.Editor edit = MyApp.getMyApp().getSharedPreferences(prefName, 0).edit();
        edit.putBoolean("KEY_PACKAGE_GAME858" + str, z);
        edit.apply();
    }

    public void setIntName(String str, int i) {
        SharedPreferences.Editor edit = MyApp.getMyApp().getSharedPreferences(prefName, 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public int getIntName(String str) {
        return MyApp.getMyApp().getSharedPreferences(prefName, 0).getInt(str, 0);
    }

    public void setBooleanName(String str, boolean z) {
        SharedPreferences.Editor edit = MyApp.getMyApp().getSharedPreferences(prefName, 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public boolean getBooleanName(String str) {
        return MyApp.getMyApp().getSharedPreferences(prefName, 0).getBoolean(str, false);
    }
}
