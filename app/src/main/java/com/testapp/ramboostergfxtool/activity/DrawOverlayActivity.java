package com.testapp.ramboostergfxtool.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.util.Utils;

public class DrawOverlayActivity extends Activity {
    private TextView tvEnable;
    private boolean aBoolean;

    class mRunnable implements Runnable {
        final DrawOverlayActivity f556a;

        mRunnable(DrawOverlayActivity drawOverlayActivity) {
            this.f556a = drawOverlayActivity;
        }

        @Override
        public void run() {
            this.f556a.setResult(-1);
            this.f556a.finish();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_permission_request);
        ((TextView) findViewById(R.id.textview_title)).setText(R.string.usagestats_permission_request);
        this.tvEnable = (TextView) findViewById(R.id.button_enable_overlay);
        this.tvEnable.setOnClickListener(new actionEnable(this));
    }

    
    public final void intView(View view) {
        this.aBoolean = true;
        Utils.askUSAGE(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!this.aBoolean) {
            return;
        }
        if (Utils.m703a(this)) {
            Toast.makeText(getApplicationContext(), (int) R.string.usagestats_granted, 0).show();
            new Handler().post(new mRunnable(this));
            return;
        }
        finish();
    }

    final class actionEnable implements View.OnClickListener {
        private final DrawOverlayActivity drawOverlayActivity;

        actionEnable(DrawOverlayActivity drawOverlayActivity) {
            this.drawOverlayActivity = drawOverlayActivity;
        }
        @Override
        public void onClick(View view) {
            this.drawOverlayActivity.intView(view);
        }
    }
}
