package com.testapp.ramboostergfxtool.vipgfx.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.activity.MainActivity;
import com.testapp.ramboostergfxtool.vipgfx.util.RequestNetwork;
import com.testapp.ramboostergfxtool.vipgfx.util.RequestNetwork.RequestListener;
import com.testapp.ramboostergfxtool.vipgfx.util.SketchwareUtil;
import com.testapp.ramboostergfxtool.vipgfx.stringfog.xor.StringFogImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class NonetActivity extends AppCompatActivity {
    private RequestListener _n_request_listener;
    private Timer _timer = new Timer();
    public Intent i = new Intent();
    private ImageView imageview1;
    private LinearLayout linear1;
    private RequestNetwork n;
    public TimerTask t;
    private TextView textview2;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_nonet);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.n = new RequestNetwork(this);
        this._n_request_listener = new RequestListener() {
            public void onErrorResponse(String str, String str2) {
            }

            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
            }
        };
    }

    private void initializeLogic() {
        TimerTask r3 = new TimerTask() {
            public void run() {
                NonetActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        if (SketchwareUtil.isConnected(NonetActivity.this.getApplicationContext())) {
                            NonetActivity.this.t.cancel();
                            NonetActivity.this.i.setClass(NonetActivity.this.getApplicationContext(), HomeVipActivity.class);
                            NonetActivity.this.startActivity(NonetActivity.this.i);
                        }
                    }
                });
            }
        };
        this.t = r3;
        this._timer.scheduleAtFixedRate(r3, 50, 500);
    }

    public void onBackPressed() {
        finishAffinity();
    }


    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i2, int i3) {
        return new Random().nextInt((i3 - i2) + 1) + i2;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i2 = 0; i2 < checkedItemPositions.size(); i2++) {
            if (checkedItemPositions.valueAt(i2)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i2)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i2) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) i2, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
