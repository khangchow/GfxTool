package com.testapp.ramboostergfxtool.ads;

import android.content.Context;
import android.content.SharedPreferences;

import com.testapp.ramboostergfxtool.util.SharePreferenceConstant;

import java.util.Calendar;

public class AdControl {
    public static boolean _isTestAds = true;
    private static AdControl instance;
    private SharedPreferences.Editor editor;
    private SharedPreferences pre;
    public boolean isStillShowAds = true;
    private int version = 1;

    public AdControl(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SharePreferenceConstant.KEY_DATA, Context.MODE_MULTI_PROCESS);
        this.pre = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public static AdControl getInstance(Context context) {
        if (instance == null) {
            instance = new AdControl(context);
        }
        return instance;
    }

    public boolean isInit() {
        return this.pre.getBoolean("isInit", false);
    }

    public void isInit(boolean z) {
        this.editor.putBoolean("isInit", z);
        this.editor.commit();
    }

    public long limit_showads() {
        return this.pre.getLong("limit_showads", 0L);
    }

    public void limit_showads(int i) {
        this.editor.putLong("limit_showads", i * 60 * 1000);
        this.editor.commit();
    }

    public String admob_full() {
        return this.pre.getString("admob_full", "");
    }

    public void admob_full(String str) {
        this.editor.putString("admob_full", str);
        this.editor.commit();
    }

    public String admob_native() {
        return this.pre.getString("admob_native", "");
    }

    public void admob_native(String str) {
        this.editor.putString("admob_native", str);
        this.editor.commit();
    }

    public String admob_native_setting() {
        return this.pre.getString("admob_native_setting", "");
    }

    public void admob_native_setting(String str) {
        this.editor.putString("admob_native_setting", str);
        this.editor.commit();
    }

    public String admob_native_banner() {
        return this.pre.getString("admob_native_banner", "");
    }

    public void admob_native_main(String str) {
        this.editor.putString("admob_native_main", str);
        this.editor.commit();
    }

    public String admob_native_main() {
        return this.pre.getString("admob_native_main", "");
    }

    public void admob_native_banner(String str) {
        this.editor.putString("admob_native_banner", str);
        this.editor.commit();
    }

    public String admob_native_rate_app() {
        return this.pre.getString("admob_native_rate_app", "");
    }

    public void admob_native_rate_app(String str) {
        this.editor.putString("admob_native_rate_app", str);
        this.editor.commit();
    }

    public String admob_banner() {
        return this.pre.getString("admob_banner", "");
    }

    public void admob_banner(String str) {
        this.editor.putString("admob_banner", str);
        this.editor.commit();
    }

    public boolean isUpdate() {
        return this.pre.getBoolean("isUpdate", false);
    }

    public void isUpdate(int i) {
        this.editor.putBoolean("isUpdate", i != this.version);
        this.editor.commit();
    }

    public Boolean remove_ads() {
        return Boolean.valueOf(this.pre.getBoolean("remove_ads", false));
    }

    public int old_date() {
        return this.pre.getInt("old_date", -1);
    }

    public void old_date(int i) {
        if (i == -1) {
            i = Calendar.getInstance().get(5);
        }
        this.editor.putInt("old_date", i);
        this.editor.commit();
    }

    public long getLastTimeShowAds() {
        return this.pre.getLong("lastTimeShowAds", 0L);
    }

    public void setLastTimeShowAds() {
        this.editor.putLong("lastTimeShowAds", System.currentTimeMillis());
        this.editor.commit();
    }
}
