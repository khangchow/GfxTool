package com.testapp.ramboostergfxtool.vipgfx.a;

import android.view.View;
import android.view.View.OnClickListener;

import com.testapp.ramboostergfxtool.vipgfx.activity.HomeVipActivity;

class f implements OnClickListener {
    final a A;

    f(a var1) {
        this.A = var1;
    }
    @Override
    public void onClick(View var1) {
        BgmiActivity.R(a.bgm(this.A)).setClass(a.bgm(this.A).getApplicationContext(), HomeVipActivity.class);
        a.bgm(this.A).startActivity(BgmiActivity.R(a.bgm(this.A)));
    }
}
