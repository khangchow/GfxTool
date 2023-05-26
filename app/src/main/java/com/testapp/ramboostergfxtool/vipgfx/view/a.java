package com.testapp.ramboostergfxtool.vipgfx.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;


public class a extends AnimatorListenerAdapter {
  public final AnimatorSet Ia;
  public final AnimationLinearLayout this$0;

  public a(AnimationLinearLayout animationLinearLayout, AnimatorSet animatorSet) {
    this.this$0 = animationLinearLayout;
    this.Ia = animatorSet;
  }

  public void onAnimationEnd(Animator animator, boolean z) {
    this.Ia.cancel();
  }

  public void onAnimationStart(Animator animator, boolean z) {
  }
}
