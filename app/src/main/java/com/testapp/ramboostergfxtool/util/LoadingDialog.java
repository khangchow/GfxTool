package com.testapp.ramboostergfxtool.util;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.testapp.ramboostergfxtool.R;

public class LoadingDialog {
    CircularView circularView;
    Dialog dialog;

    public LoadingDialog(Context context, String str) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.loading_dialog_view, (ViewGroup) null);
        this.circularView = (CircularView) inflate.findViewById(R.id.circularring);
        ((TextView) inflate.findViewById(R.id.loading_text)).setText(str);
        this.dialog = new Dialog(context, R.style.loading_app_dialog);
        this.dialog.setCancelable(false);
        this.dialog.setContentView((LinearLayout) inflate.findViewById(R.id.dialog_view), new LinearLayout.LayoutParams(-1, -1));
    }

    public void isCancel(boolean z) {
        this.dialog.setCancelable(z);
    }

    public void intSh() {
        this.dialog.show();
        this.circularView.intV();
    }

    public void mDialog() {
        Dialog dialog = this.dialog;
        if (dialog != null && dialog.isShowing()) {
            try {
                this.circularView.doClearAnimation();
                this.dialog.dismiss();
            } catch (Exception unused) {
            }
        }
    }
}
