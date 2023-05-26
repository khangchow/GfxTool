package com.testapp.ramboostergfxtool.vipgfx.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.CycleInterpolator;
import android.widget.LinearLayout;


public class AnimationLinearLayout extends LinearLayout {
  public a cU;
  public AnimatorSet dU;

  public interface a {
    void onClick();
  }

  public AnimationLinearLayout(Context context) {
    super(context);
  }
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    if (i != 0) {
      if (i != 1) {
        if (i != 3)
          return true;
      } else {
        a a1 = this.cU;
        if (a1 != null)
          a1.onClick();
      }
      this.dU.cancel();
      setEndAnimator();
    } else {
      setStartAnimator();
    }
    return true;
  }

  public void setEndAnimator() {
    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 0.96f, 1.0f);
    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 0.96f, 1.0f);
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.setInterpolator(new CycleInterpolator(0.25f));
    animatorSet.playTogether(ofFloat, ofFloat2);
    animatorSet.setDuration(264L);
    animatorSet.start();
    animatorSet.addListener(new com.testapp.ramboostergfxtool.vipgfx.view.a(this, animatorSet));
  }

  public void setOnAnimationClickListener(a aVar) {
    this.cU = aVar;
  }

  public void setStartAnimator() {
    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 1.0f, 0.96f);
    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 1.0f, 0.96f);
    this.dU = new AnimatorSet();
    this.dU.setInterpolator(new CycleInterpolator(0.25f));
    this.dU.playTogether(ofFloat, ofFloat2);
    this.dU.setDuration(264L);
    this.dU.start();
  }

  public AnimationLinearLayout(Context context, AttributeSet attributeSet) {
    super(context, attributeSet);
  }

  public AnimationLinearLayout(Context context, AttributeSet attributeSet, int i2) {
    super(context, attributeSet, i2);
  }
}
