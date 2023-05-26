package com.testapp.ramboostergfxtool.util;

import android.graphics.drawable.Drawable;

public class MyAppInfo {
    public boolean aBoolean;
    public boolean aBoolean1 = false;
    public int anInt;
    public CharSequence charSequence;
    public Drawable drawable;
    public String string;
    public String string1;
    public String string2;
    public String string3;
    public String string4;

    public String toString() {
        return "AppInfo{packageName='" + this.string + '\'' + ", path='" + this.string1 + '\'' + ", pathOutside='" + this.string2 + '\'' + ", fastOpen=" + this.aBoolean + ", icon=" + this.drawable + ", name=" + this.charSequence + ", cloneCount=" + this.anInt + ", isAd= " + this.aBoolean1 + ", appUrl= " + this.string3 + ", logoUrl= " + this.string4 + '}';
    }
}
