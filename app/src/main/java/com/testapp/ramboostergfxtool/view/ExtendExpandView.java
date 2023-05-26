package com.testapp.ramboostergfxtool.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;

import androidx.core.content.ContextCompat;

import com.testapp.ramboostergfxtool.R;


@SuppressLint("AppCompatCustomView")
public class ExtendExpandView extends CheckBox {
    private Drawable cbDrawableOff;
    private Drawable cbDrawableOn;

    public ExtendExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public ExtendExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public ExtendExpandView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        this.cbDrawableOn = ContextCompat.getDrawable(context, R.drawable.ic_expand_less_white_24dp);
        this.cbDrawableOff = ContextCompat.getDrawable(context, R.drawable.ic_expand_more_white_24dp);
        this.cbDrawableOn.setColorFilter(getResources().getColor(R.color.ex_view), Mode.SRC_ATOP);
        this.cbDrawableOff.setColorFilter(getResources().getColor(R.color.ex_view), Mode.SRC_ATOP);
        setButtonDrawable(this.cbDrawableOn);
        setChecked(false);
    }

    public void setChecked(boolean z) {
        if (z) {
            setButtonDrawable(this.cbDrawableOn);
        } else {
            setButtonDrawable(this.cbDrawableOff);
        }
        super.setChecked(z);
    }
}
