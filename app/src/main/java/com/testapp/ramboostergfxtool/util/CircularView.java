package com.testapp.ramboostergfxtool.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.internal.view.SupportMenu;

public class CircularView extends View {
    private float float1;
    private float float2;
    private float float3;
    private Paint paint;
    private RectF rectF;
    ValueAnimator valueAnimator;

    
    public class MyAnimatorUpdateListenner implements ValueAnimator.AnimatorUpdateListener {
        final CircularView circularView;

        MyAnimatorUpdateListenner(CircularView circularView2) {
            this.circularView = circularView2;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.circularView.float3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
            this.circularView.invalidate();
        }
    }

    
    public class MyAnimatorListennerAdapter extends AnimatorListenerAdapter {
        final CircularView f657a;

        MyAnimatorListennerAdapter(CircularView circularView) {
            this.f657a = circularView;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    public CircularView(Context context) {
        this(context, null);
        drawView();
    }

    public CircularView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        drawView();
    }

    public CircularView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.float1 = 0.0f;
        this.float2 = 4.0f;
        this.float3 = 0.0f;
        this.rectF = new RectF();
        drawView();
    }

    
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.float1 = (float) getMeasuredHeight();
        } else {
            this.float1 = (float) getMeasuredWidth();
        }
    }

    
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setColor(Color.argb(100, 255, 255, 255));
        float f = this.float1;
        canvas.drawCircle(f / 2.0f, f / 2.0f, (f / 2.0f) - this.float2, this.paint);
        this.paint.setColor(-1);
        RectF rectF2 = this.rectF;
        float f2 = this.float2;
        float f3 = this.float1;
        rectF2.set(f2, f2, f3 - f2, f3 - f2);
        canvas.drawArc(this.rectF, this.float3, 100.0f, false, this.paint);
    }

    private void drawView() {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(SupportMenu.CATEGORY_MASK);
        this.paint.setStrokeWidth(8.0f);
    }

    public void intV() {
        doClearAnimation();
        setUpAnimator(0.0f, 1.0f, 1000);
    }

    public void doClearAnimation() {
        if (this.valueAnimator != null) {
            clearAnimation();
            this.valueAnimator.setRepeatCount(1);
            this.valueAnimator.cancel();
            this.valueAnimator.end();
        }
    }

    private ValueAnimator setUpAnimator(float f, float f2, long j) {
        this.valueAnimator = ValueAnimator.ofFloat(f, f2);
        this.valueAnimator.setDuration(j);
        this.valueAnimator.setInterpolator(new LinearInterpolator());
        this.valueAnimator.setRepeatCount(-1);
        this.valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        this.valueAnimator.addUpdateListener(new MyAnimatorUpdateListenner(this));
        this.valueAnimator.addListener(new MyAnimatorListennerAdapter(this));
        if (!this.valueAnimator.isRunning()) {
            this.valueAnimator.start();
        }
        return this.valueAnimator;
    }
}
