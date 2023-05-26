package com.testapp.ramboostergfxtool.vipgfx.a;

import android.net.Uri;
import android.provider.DocumentsContract;
import android.view.View;
import android.view.View.OnClickListener;

import com.testapp.ramboostergfxtool.vipgfx.util.SketchwareUtil;
import com.testapp.ramboostergfxtool.vipgfx.stringfog.xor.StringFogImpl;
import java.io.FileNotFoundException;

class b implements OnClickListener {
    final a A;

    b(a var1) {
        this.A = var1;
    }

    @Override
    public void onClick(View var1) {
        BgmiActivity.G(a.bgm(this.A), Uri.parse(BgmiActivity.B(a.bgm(this.A)).getString(StringFogImpl.decrypt("ER0UaHsBCwBidBERFHJtBx0="), "").concat(BgmiActivity.C(a.bgm(this.A)).concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81Alo0JyNySDQmMhxnZ3p3Awh7ZXAZAWV6NkxT")).replace(StringFogImpl.decrypt("eg=="), StringFogImpl.decrypt("cGYA")))));

        try {
            DocumentsContract.deleteDocument(a.bgm(this.A).getApplicationContext().getContentResolver(), BgmiActivity.H(a.bgm(this.A)));
            SketchwareUtil.showMessage(a.bgm(this.A).getApplicationContext(), StringFogImpl.decrypt("EAYHY38ZEWZpfRkREmh8"));
        } catch (FileNotFoundException var2) {
        } catch (Exception var3) {
            BgmiActivity.Q(a.bgm(this.A), BgmiActivity.F(a.bgm(this.A)));
        }

    }
}
