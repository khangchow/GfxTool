package com.testapp.ramboostergfxtool.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class ExpandableHeightGridView extends GridView {
    private boolean a = false;

    public ExpandableHeightGridView(Context context) {
        super(context);
    }

    private boolean a() {
        return this.a;
    }

    public void onMeasure(int i, int i2) {
        if (a()) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, MeasureSpec.AT_MOST));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setExpanded(boolean z) {
        this.a = z;
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
