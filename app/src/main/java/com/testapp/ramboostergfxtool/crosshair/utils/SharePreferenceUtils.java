
package com.testapp.ramboostergfxtool.crosshair.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharePreferenceUtils {
    private static final String SHARE_NAME = "CrossHair";
    private Editor editor;
    private SharedPreferences preferences;

    public SharePreferenceUtils(Context var1) {
        this.preferences = var1.getSharedPreferences("CrossHair", 0);
        this.editor = this.preferences.edit();
    }

    public boolean getBooleanValue(String var1, boolean var2) {
        return this.preferences.getBoolean(var1, var2);
    }

    public int getIntValue(String var1, int var2) {
        return this.preferences.getInt(var1, var2);
    }

    public String getStringValue(String var1, String var2) {
        return this.preferences.getString(var1, var2);
    }

    public void setBooleanValue(String var1, boolean var2) {
        this.editor.putBoolean(var1, var2);
        this.editor.commit();
    }

    public void setIntValue(String var1, int var2) {
        this.editor.putInt(var1, var2);
        this.editor.commit();
    }

    public void setStringValue(String var1, String var2) {
        this.editor.putString(var1, var2);
        this.editor.commit();
    }
}
