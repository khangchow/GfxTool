package com.testapp.ramboostergfxtool.util;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.testapp.ramboostergfxtool.MyApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppWhiteList {
    private static AppWhiteList appWhiteList = null;
    private static final String KEY_APP_WHITE_LIST = "KEY_APP_WHITE_LIST";

    private AppWhiteList() {
    }

    public static AppWhiteList getInstance() {
        if (appWhiteList == null) {
            appWhiteList = new AppWhiteList();
        }
        return appWhiteList;
    }

    public List<AppSelectInfo> getWhiteListApp() {
        List<String> m681c = PrefHelper.getInstance().listNm();
        ArrayList arrayList = new ArrayList();
        for (String str : m681c) {
            AppSelectInfo appSelectInfo = new AppSelectInfo();
            appSelectInfo.myAppInfo = PrefHelper.getInstance().getPackNm(str);
            appSelectInfo.aBoolean = isListApp(str);
            arrayList.add(appSelectInfo);
        }
        Collections.sort(arrayList, WhiteAppComporator.comporator);
        return arrayList;
    }

    public List<MyAppInfo> m692c() {
        List<String> asList = Arrays.asList(MyApp.getMyApp().getSharedPreferences(PrefHelper.prefName, 0).getString(KEY_APP_WHITE_LIST, "").split(","));
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        PackageManager packageManager = MyApp.getMyApp().getPackageManager();
        for (String str : asList) {
            if (!TextUtils.equals(str, MyApp.getMyApp().getPackageName())) {
                MyAppInfo m677a = PrefHelper.getInstance().getPackNm(str);
                if (m677a == null) {
                    mListPref(str);
                } else {
                    intent.setPackage(str);
                    List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        arrayList.add(m677a);
                    }
                }
            }
        }
        return arrayList;
    }

    public void setAppWhite(String str) {
        SharedPreferences sharedPreferences = MyApp.getMyApp().getSharedPreferences(PrefHelper.prefName, 0);
        String string = sharedPreferences.getString(KEY_APP_WHITE_LIST, "");
        if (!Arrays.asList(string.split(",")).contains(str)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(KEY_APP_WHITE_LIST, string + str + ",");
            edit.apply();
        }
    }

    public boolean isListApp(String str) {
        List asList = Arrays.asList(MyApp.getMyApp().getSharedPreferences(PrefHelper.prefName, 0).getString(KEY_APP_WHITE_LIST, "").split(","));
        for (int i = 0; i < asList.size(); i++) {
            if (!TextUtils.isEmpty(str) && ((String) asList.get(i)).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void mListPref(String str) {
        SharedPreferences sharedPreferences = MyApp.getMyApp().getSharedPreferences(PrefHelper.prefName, 0);
        List asList = Arrays.asList(sharedPreferences.getString(KEY_APP_WHITE_LIST, "").split(","));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < asList.size(); i++) {
            if (!((String) asList.get(i)).equals(str)) {
                sb.append((String) asList.get(i));
                sb.append(",");
            }
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(KEY_APP_WHITE_LIST, sb.toString());
        edit.apply();
    }

}
