package com.testapp.ramboostergfxtool.vipgfx.a;

import android.net.Uri;
import android.provider.DocumentsContract;
import android.view.View;
import android.view.View.OnClickListener;

import com.testapp.ramboostergfxtool.vipgfx.util.SketchwareUtil;
import com.testapp.ramboostergfxtool.vipgfx.stringfog.xor.StringFogImpl;
import java.io.FileNotFoundException;

class d implements OnClickListener {
    final a A;

    d(a var1) {
        this.A = var1;
    }

    public void onClick(View var1) {
        BgmiActivity.I(a.bgm(this.A), Uri.parse(BgmiActivity.B(a.bgm(this.A)).getString(StringFogImpl.decrypt("ER0UaHsBCwBidBERFHJtBx0="), "").concat(BgmiActivity.C(a.bgm(this.A)).concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81AlU0JBlJUT07NEJMOj8ZHxZkenYDCWNgfx0WJTUt")).replace(StringFogImpl.decrypt("eg=="), StringFogImpl.decrypt("cGYA")))));

        try {
            DocumentsContract.deleteDocument(a.bgm(this.A).getApplicationContext().getContentResolver(), BgmiActivity.J(a.bgm(this.A)));
            SketchwareUtil.showMessage(a.bgm(this.A).getApplicationContext(), StringFogImpl.decrypt("Ax0NaHYRHWZpfRkREmh8"));
        } catch (FileNotFoundException var2) {
        } catch (Exception var3) {
            BgmiActivity.Q(a.bgm(this.A), BgmiActivity.F(a.bgm(this.A)));
        }

    }
}
