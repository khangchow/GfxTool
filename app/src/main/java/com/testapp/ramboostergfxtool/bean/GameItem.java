package com.testapp.ramboostergfxtool.bean;

import android.graphics.drawable.Drawable;

public class GameItem {
    private Drawable a;
    private String b;
    private String c;
    private Boolean isAdded;

    public GameItem(String str, String str2, Drawable drawable) {
        this.b = str;
        this.c = str2;
        this.a = drawable;
        this.isAdded = false;
    }

    public Drawable getAppIcon() {
        return this.a;
    }

    public String getAppName() {
        return this.b;
    }

    public String getPackageName() {
        return this.c;
    }

    public Boolean isAdded() {
        return isAdded;
    }

    public void setAdded(Boolean added) {
        isAdded = added;
    }
}
