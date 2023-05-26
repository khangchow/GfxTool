package com.testapp.ramboostergfxtool.rammbooster;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class RammBoosterInstalledPackage {
    public String strN1 = "";
    public String strPack = "";
    public Drawable mIcon;
    public boolean isSys;
    public Context context;

    public void isSisApp(boolean z) {
    }

    public boolean isRamBo() {
        return false;
    }

    public void mob(boolean z) {
    }

    public boolean mob2() {
        return false;
    }

    public void moc() {
    }

    public RammBoosterInstalledPackage(Context context, String str, String str2, Drawable drawable, boolean z, boolean z2, boolean z3) {
        this.context = context;
        this.strPack = str;
        this.strN1 = str2;
        this.mIcon = drawable;
        isSisApp(z);
        this.isSys = z2;
        mob(z3);
    }
}
