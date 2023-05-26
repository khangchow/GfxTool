package com.testapp.ramboostergfxtool.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.ads.AdRequest;
import com.google.gson.Gson;
import com.testapp.ramboostergfxtool.ads.AdControl;

public class SharePreferenceUtilsAds {
    private static SharePreferenceUtilsAds instance;
    private SharedPreferences.Editor editor;
    private SharedPreferences pre;

    private SharePreferenceUtilsAds(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SharePreferenceConstant.KEY_DATA, Context.MODE_MULTI_PROCESS);
        this.pre = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public static SharePreferenceUtilsAds getInstance(Context context) {
        if (instance == null) {
            instance = new SharePreferenceUtilsAds(context);
        }
        return instance;
    }


    public boolean getFirstRun() {
        boolean z = this.pre.getBoolean("first_run_app", true);
        if (z) {
            this.editor.putBoolean("first_run_app", false);
            this.editor.commit();
        }
        return z;
    }



    public long getTimeIn() {
        return this.pre.getLong("TimeIn", 0L);
    }

    public void setTimeIn(long j) {
        this.editor.putLong("TimeIn", j);
        this.editor.commit();
    }

    public long getTimeOut() {
        return this.pre.getLong("TimeOut", 0L);
    }

    public void setTimeOut(long j) {
        this.editor.putLong("TimeOut", j);
        this.editor.commit();
    }

    public long getTime() {
        return this.pre.getLong("Time", 0L);
    }

    public void setTime(long j) {
        this.editor.putLong("Time", j);
        this.editor.commit();
    }

    public boolean getEnable() {
        return this.pre.getBoolean("Enable", false);
    }

    public long getChargeNormal() {
        return this.pre.getLong("ChargeNormal", 0L);
    }


    public void setChargeType(String str) {
        this.editor.putString("ChargeType", str);
        this.editor.commit();
    }

    public AdControl getAdmod() {
        String string = this.pre.getString("Admod", null);
        if (string == null) {
            return null;
        }
        return (AdControl) new Gson().fromJson(string, (Class) AdControl.class);
    }

    public void setAdmod(AdControl adControl) {
        this.editor.putString("Admod", new Gson().toJson(adControl));
        this.editor.commit();
    }

    public void setDayGetAdmod() {
        this.editor.putLong("dayGetAdmod", System.currentTimeMillis());
    }

    public Long getDayGetAdmod() {
        return Long.valueOf(this.pre.getLong("dayGetAdmod", 0L));
    }

    public long getLevelIn() {
        return this.pre.getLong("LevelIn", 0L);
    }



    public boolean getFlagAds() {
        return this.pre.getBoolean(AdRequest.LOGTAG, false);
    }

    public void setFlagAds(boolean z) {
        this.editor.putBoolean(AdRequest.LOGTAG, z);
        this.editor.commit();
    }


}