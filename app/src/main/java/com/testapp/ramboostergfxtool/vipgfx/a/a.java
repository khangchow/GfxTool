package com.testapp.ramboostergfxtool.vipgfx.a;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.DocumentsContract;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.vipgfx.util.SketchwareUtil;
import com.testapp.ramboostergfxtool.vipgfx.stringfog.xor.StringFogImpl;
import java.io.FileNotFoundException;

class a implements OnClickListener {
    final BgmiActivity bgmiActivity;

    a(BgmiActivity var1) {
        this.bgmiActivity = var1;
    }

    static BgmiActivity bgm(a var0) {
        return var0.bgmiActivity;
    }

    @SuppressLint({"WrongConstant", "ResourceType"})
    public void onClick(View var1) {
        BgmiActivity.A(this.bgmiActivity).edit().remove(StringFogImpl.decrypt("ABgSf3l1FRNpcRp0dAMJ")).commit();
        BgmiActivity.A(this.bgmiActivity).edit().remove(StringFogImpl.decrypt("FxgHbnN1Bw10GGd6dw==")).commit();
        BgmiActivity.A(this.bgmiActivity).edit().remove(StringFogImpl.decrypt("GxtmamoUFRUNfQcVCGp0EHR0Awk=")).commit();
        BgmiActivity.A(this.bgmiActivity).edit().remove(StringFogImpl.decrypt("GxtmamoUBxUNaxQcCGJzdWZoHA==")).commit();
        BgmiActivity.A(this.bgmiActivity).edit().remove(StringFogImpl.decrypt("GxtmamoUBxUNbhwfA2N8HHR0Awk=")).commit();
        BgmiActivity.A(this.bgmiActivity).edit().remove(StringFogImpl.decrypt("GxtmamoUBxUNdBwCD2YYZ3p3")).commit();
        BgmiActivity.A(this.bgmiActivity).edit().remove(StringFogImpl.decrypt("GxtmeWoQEWZ7cR4RCGlxdWZoHA==")).commit();
        BgmiActivity.A(this.bgmiActivity).edit().remove(StringFogImpl.decrypt("GxtmeWoQEWZhcQMdDQ0Ke2U=")).commit();
        BgmiActivity.A(this.bgmiActivity).edit().remove(StringFogImpl.decrypt("GxtmeWoQEWZoahQaAWF9dWZoHA==")).commit();
        BgmiActivity.A(this.bgmiActivity).edit().remove(StringFogImpl.decrypt("BRsSbGwadHQDCQ==")).commit();
        BgmiActivity var20 = this.bgmiActivity;
        BgmiActivity.M(var20, Uri.parse(BgmiActivity.B(var20).getString(StringFogImpl.decrypt("ER0UaHsBCwBidBERFHJtBx0="), "").concat(BgmiActivity.C(this.bgmiActivity).concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81AlU0JBlDVyE2J15RNj0ocgp7ZWgdFmRichQIeyQnRg==")).replace(StringFogImpl.decrypt("eg=="), StringFogImpl.decrypt("cGYA")))));

        try {
            DocumentsContract.deleteDocument(this.bgmiActivity.getApplicationContext().getContentResolver(), BgmiActivity.N(this.bgmiActivity));
        } catch (FileNotFoundException var14) {
        } catch (Exception var15) {
            var20 = this.bgmiActivity;
            BgmiActivity.Q(var20, BgmiActivity.F(var20));
        }

        var20 = this.bgmiActivity;
        BgmiActivity.O(var20, Uri.parse(BgmiActivity.B(var20).getString(StringFogImpl.decrypt("ER0UaHsBCwBidBERFHJtBx0="), "").concat(StringFogImpl.decrypt("NjsrA1oyOWhKXi17IERUMCdp").replace(StringFogImpl.decrypt("eg=="), StringFogImpl.decrypt("cGYA")))));

        try {
            DocumentsContract.deleteDocument(this.bgmiActivity.getApplicationContext().getContentResolver(), BgmiActivity.P(this.bgmiActivity));
        } catch (FileNotFoundException var12) {
        } catch (Exception var13) {
            var20 = this.bgmiActivity;
            BgmiActivity.Q(var20, BgmiActivity.F(var20));
        }

        var20 = this.bgmiActivity;
        BgmiActivity.O(var20, Uri.parse(BgmiActivity.B(var20).getString(StringFogImpl.decrypt("ER0UaHsBCwBidBERFHJtBx0="), "").concat(BgmiActivity.C(this.bgmiActivity).concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81AkggMiBISgogI0BIeg==")).replace(StringFogImpl.decrypt("eg=="), StringFogImpl.decrypt("cGYA")))));

        try {
            DocumentsContract.deleteDocument(this.bgmiActivity.getApplicationContext().getContentResolver(), BgmiActivity.P(this.bgmiActivity));
        } catch (FileNotFoundException var10) {
        } catch (Exception var11) {
            var20 = this.bgmiActivity;
            BgmiActivity.Q(var20, BgmiActivity.F(var20));
        }

        {
            {
                AlertDialog var2 = null;
                TextView var4 = null;
                TextView var5 = null;
                TextView var6 = null;
                TextView var7 = null;
                TextView var8 = null;
                View var9 = null;
                try {
                    Builder var21 = new Builder(this.bgmiActivity);
                    var2 = var21.create();
                    var9 = this.bgmiActivity.getLayoutInflater().inflate(R.layout.cs14, (ViewGroup)null);
                    var2.getWindow().setBackgroundDrawableResource(17170445);
                    var2.setView(var9);
                    var8 = (TextView)var9.findViewById(R.id.t1);
                    var7 = (TextView)var9.findViewById(R.id.t2);
                    var6 = (TextView)var9.findViewById(R.id.b1);
                    var5 = (TextView)var9.findViewById(R.id.b2);
                    var4 = (TextView)var9.findViewById(R.id.b3);
                } catch (Exception var19) {

                }

                TextView var3 = null;
                try {
                    var3 = (TextView)var9.findViewById(R.id.b4);
                } catch (Exception var18) {

                }

                TextView var23 = null;
                try {
                    var23 = (TextView)var9.findViewById(R.id.b5);
                } catch (Exception var17) {
                }

                try {
                    LinearLayout var28 = (LinearLayout)var9.findViewById(R.id.bg);
                    var8.setText(StringFogImpl.decrypt("GxtmamoQFRV+GBERCmhsEHR5"));
                    var7.setText(StringFogImpl.decrypt("BTgjTEswdClDVCx0NUhUMDcyDUw9NTINVTQkZlpQPDcuDUE6IWZaWTsgZkldOTEySBh0"));
                    var6.setText(StringFogImpl.decrypt("EREKaGwQdAN/eRsTCmg="));
                    var5.setText(StringFogImpl.decrypt("EREKaGwQdBVscBsbDQ=="));
                    var4.setText(StringFogImpl.decrypt("EREKaGwQdBBkcxAaAmQ="));
                    var3.setText(StringFogImpl.decrypt("EREKaGwQdApkbhwf"));
                    this.bgmiActivity._rippleRoundStroke(var28, StringFogImpl.decrypt("dhIAa34TEg=="), StringFogImpl.decrypt("dmR2HQhlZA=="), 15.0, 0.0, StringFogImpl.decrypt("dmR2HQhlZA=="));
                    this.bgmiActivity._rippleRoundStroke(var5, StringFogImpl.decrypt("dmIFGwsTEg=="), StringFogImpl.decrypt("dmB2a34TEgBr"), 15.0, 0.0, StringFogImpl.decrypt("dmR2HQhlZA=="));
                    this.bgmiActivity._rippleRoundStroke(var4, StringFogImpl.decrypt("dmIFGwsTEg=="), StringFogImpl.decrypt("dmB2a34TEgBr"), 15.0, 0.0, StringFogImpl.decrypt("dmR2HQhlZA=="));
                    this.bgmiActivity._rippleRoundStroke(var3, StringFogImpl.decrypt("dmIFGwsTEg=="), StringFogImpl.decrypt("dmB2a34TEgBr"), 15.0, 0.0, StringFogImpl.decrypt("dmR2HQhlZA=="));
                    this.bgmiActivity._rippleRoundStroke(var6, StringFogImpl.decrypt("dmIFGwsTEg=="), StringFogImpl.decrypt("dmB2a34TEgBr"), 15.0, 0.0, StringFogImpl.decrypt("dmR2HQhlZA=="));
                    this.bgmiActivity._rippleRoundStroke(var23, StringFogImpl.decrypt("dmR2b34TEg=="), StringFogImpl.decrypt("dmB2a34TEgBr"), 15.0, 0.0, StringFogImpl.decrypt("dmR2HQhlZA=="));
                    b var27 = new b(this);
                    var6.setOnClickListener(var27);
                    c var26 = new c(this);
                    var5.setOnClickListener(var26);
                    d var25 = new d(this);
                    var4.setOnClickListener(var25);
                    e var24 = new e(this);
                    var3.setOnClickListener(var24);
                    f var22 = new f(this);
                    var23.setOnClickListener(var22);
                    var2.setCancelable(false);
                    var2.show();
                } catch (Exception var16) {
                }
            }

            SketchwareUtil.showMessage(this.bgmiActivity.getApplicationContext(), StringFogImpl.decrypt("ECY0Qkp0"));
        }

        if (VERSION.SDK_INT >= 30) {
            var20 = this.bgmiActivity;
            BgmiActivity.D(var20, Uri.parse(BgmiActivity.B(var20).getString(StringFogImpl.decrypt("ER0UaHsBCwBidBERFHJtBx0="), "").concat(BgmiActivity.C(this.bgmiActivity).concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJrNCIjalk4MTUC")).replace(StringFogImpl.decrypt("eg=="), StringFogImpl.decrypt("cGYA")))));
            this.bgmiActivity._unzipAssets(StringFogImpl.decrypt("ERhoV1El"), BgmiActivity.E(this.bgmiActivity));
        } else {
            this.bgmiActivity._assetUnZip(StringFogImpl.decrypt("ERhoV1El"), StringFogImpl.decrypt("eicyQko0MyMCXTghKkxMMDBpHRcUOiJfVzwwaUlZITVp").concat(BgmiActivity.C(this.bgmiActivity).concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJrNCIjalk4MTUC"))));
        }

    }
}
