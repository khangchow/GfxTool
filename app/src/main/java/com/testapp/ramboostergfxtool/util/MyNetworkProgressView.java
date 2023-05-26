package com.testapp.ramboostergfxtool.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.testapp.ramboostergfxtool.R;

public class MyNetworkProgressView extends LinearLayout {
    private static final String TAG = "NetworkProgressView";
    private LinearLayout linearLayout;
    private Context context;
    private int val;

    public MyNetworkProgressView(Context context) {
        this(context, null);
    }

    public MyNetworkProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        infView();
    }

    private void infView() {
        this.linearLayout = (LinearLayout) LayoutInflater.from(this.context).inflate(R.layout.network_view_layout, this).findViewById(R.id.network_view);
        this.val = this.linearLayout.getChildCount();
    }

    public void setDelayTime(long j) {
        MyLog.name2(TAG, "delayTime = " + j);
        colorR();
        if (j != -1) {
            int i = 0;
            if (j <= 40) {
                while (i < 8) {
                    chanIv(i, R.drawable.network_shape_green);
                    i++;
                }
            } else if (j <= 80) {
                while (i < 7) {
                    chanIv(i, R.drawable.network_shape_green);
                    i++;
                }
            } else if (j <= 120) {
                while (i < 6) {
                    chanIv(i, R.drawable.network_shape_yellow);
                    i++;
                }
            } else if (j <= 160) {
                while (i < 5) {
                    chanIv(i, R.drawable.network_shape_yellow);
                    i++;
                }
            } else if (j <= 200) {
                while (i < 4) {
                    chanIv(i, R.drawable.network_shape_red);
                    i++;
                }
            } else if (j <= 240) {
                while (i < 3) {
                    chanIv(i, R.drawable.network_shape_red);
                    i++;
                }
            } else if (j <= 280) {
                while (i < 2) {
                    chanIv(i, R.drawable.network_shape_red);
                    i++;
                }
            } else {
                chanIv(0, R.drawable.network_shape_red);
            }
        }
    }

    public void colorR() {
        for (int i = 0; i < this.val; i++) {
            chanIv(i, R.drawable.network_shape_gray);
        }
    }

    private void chanIv(int i, int i2) {
        ((ImageView) this.linearLayout.getChildAt(i)).setImageResource(i2);
    }
}
