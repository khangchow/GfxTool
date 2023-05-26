package com.testapp.ramboostergfxtool.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.testapp.ramboostergfxtool.R;


public class AdmobHelp {
    private static AdControl adControl;
    private static Context context;
    private static AdmobHelp instance;
    AdManagerInterstitialAdLoadCallback adListenerEmpty = new AdManagerInterstitialAdLoadCallback() {
        @Override
        public void onAdLoaded(AdManagerInterstitialAd adManagerInterstitialAd) {
            AdmobHelp.this.mAdManagerInterstitialAd = adManagerInterstitialAd;
            AdmobHelp.this.canShowInterstitialAd = true;
            Log.v("ads", "Ads Loaded");
        }
    };
    private boolean canShowInterstitialAd = false;
    private AdManagerInterstitialAd mAdManagerInterstitialAd;

    public static AdmobHelp getInstance(Context context2) {
        context = context2;
        adControl = AdControl.getInstance(context2);
        if (instance == null) {
            instance = new AdmobHelp();
        }
        return instance;
    }

    public void loadInterstitialAd(final Activity activity, final AdControlHelp.AdCloseListener adCloseListener, final AdControlHelp.AdLoadedListener adLoadedListener, final String str, final boolean z) {
        Log.v("ads", "Call ads");
        adControl.isStillShowAds = true;
        AdManagerInterstitialAdLoadCallback adManagerInterstitialAdLoadCallback = new AdManagerInterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(AdManagerInterstitialAd adManagerInterstitialAd) {
                AdmobHelp.this.mAdManagerInterstitialAd = adManagerInterstitialAd;
                AdmobHelp.this.canShowInterstitialAd = true;
                Log.v("ads", "Ads Loaded");
                AdControlHelp.AdLoadedListener adLoadedListener2 = adLoadedListener;
                if (adLoadedListener2 != null) {
                    adLoadedListener2.onAdLoaded();
                }
                if (z && AdmobHelp.adControl.isStillShowAds) {
                    AdmobHelp.this.showInterstitialAd(activity, adCloseListener, str);
                }
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                AdControlHelp.AdCloseListener adCloseListener2;
                AdmobHelp.this.canShowInterstitialAd = false;
                Log.v("ads", "ads Fail");
                if (z && AdmobHelp.adControl.isStillShowAds && (adCloseListener2 = adCloseListener) != null) {
                    adCloseListener2.onAdClosed();
                }
            }
        };
        if (!this.canShowInterstitialAd) {
            loadInterstitialAd(activity, str, adManagerInterstitialAdLoadCallback);
            return;
        }
        if (adLoadedListener != null) {
            adLoadedListener.onAdLoaded();
        }
        if (z) {
            showInterstitialAd(activity, adCloseListener, str);
        }
    }

    public void showInterstitialAd(final Activity activity, final AdControlHelp.AdCloseListener adCloseListener, final String str) {
        Log.v("ads", "Ads Call show ads");
        if (this.canShowInterstitialAd) {
            this.canShowInterstitialAd = false;
            this.mAdManagerInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    Log.v("ads", "ads closed");
                    AdControlHelp.AdCloseListener adCloseListener2 = adCloseListener;
                    if (adCloseListener2 != null) {
                        adCloseListener2.onAdClosed();
                    }
                    AdmobHelp admobHelp = AdmobHelp.this;
                    admobHelp.loadInterstitialAd(activity, str, admobHelp.adListenerEmpty);
                }
            });
            this.mAdManagerInterstitialAd.show(activity);
        } else if (adCloseListener != null) {
            adCloseListener.onAdClosed();
        }
    }

    public void loadInterstitialAd(Activity activity, String str, AdManagerInterstitialAdLoadCallback adManagerInterstitialAdLoadCallback) {
        Log.v("ads", "ads get Request");
        if (this.canShowInterstitialAd) {
            return;
        }
        AdManagerInterstitialAd.load(activity, str, new AdManagerAdRequest.Builder().build(), adManagerInterstitialAdLoadCallback);
    }

    public void loadBanner(Activity activity, View view, String str) {
        final ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) view.findViewById(R.id.shimmer_container);
        shimmerFrameLayout.setVisibility(View.VISIBLE);
        shimmerFrameLayout.startShimmer();
        AdView adView = new AdView(view.getContext());
        adView.setAdSize(getAdSize(activity));
        adView.setAdUnitId(str);
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.admob_adplaceholder);
        frameLayout.setVisibility(View.GONE);
        frameLayout.removeAllViews();
        frameLayout.addView(adView);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                frameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAdLoaded() {
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);
            }
        });
        adView.loadAd(new AdRequest.Builder().build());
    }

    public void loadNative(final Activity activity, LinearLayout linearLayout, String str, final int i, final boolean z, boolean z2) {
        Log.v("ads", "is_native_banner: " + z);
        ViewGroup viewGroup = null;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) activity.getLayoutInflater().inflate(R.layout.load_native, viewGroup);
        if (z) {
            shimmerFrameLayout = (ShimmerFrameLayout) activity.getLayoutInflater().inflate(R.layout.load_banner, viewGroup);
        }
        linearLayout.addView(shimmerFrameLayout);
        final ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) linearLayout.findViewById(R.id.shimmer_container);
        final FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(R.id.admob_adplaceholder);
        frameLayout.setVisibility(View.GONE);
        shimmerFrameLayout2.setVisibility(View.VISIBLE);
        shimmerFrameLayout2.startShimmer();
        AdLoader.Builder builder = new AdLoader.Builder(context, str);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(NativeAd nativeAd) {
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(i, (ViewGroup) null);
                AdmobHelp.this.populateNativeAdView(nativeAd, nativeAdView, z);
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdView);
                frameLayout.setVisibility(View.VISIBLE);
                shimmerFrameLayout2.stopShimmer();
                shimmerFrameLayout2.setVisibility(View.GONE);
            }
        });
        builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(false).build()).build());
        builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                shimmerFrameLayout2.stopShimmer();
                shimmerFrameLayout2.setVisibility(View.GONE);
            }
        }).build().loadAd(new AdRequest.Builder().build());
    }

    public void populateNativeAdView(NativeAd nativeAd, NativeAdView nativeAdView, boolean z) {
        if (!z) {
            nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.ad_media));
        }
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));
        nativeAdView.setPriceView(nativeAdView.findViewById(R.id.ad_price));
        nativeAdView.setStarRatingView(nativeAdView.findViewById(R.id.ad_stars));
        nativeAdView.setStoreView(nativeAdView.findViewById(R.id.ad_store));
        nativeAdView.setAdvertiserView(nativeAdView.findViewById(R.id.ad_advertiser));
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd.getHeadline());
        if (!z) {
            nativeAdView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        }
        if (nativeAd.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            nativeAdView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            nativeAdView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) nativeAdView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            nativeAdView.getIconView().setBackground(context.getResources().getDrawable(R.drawable.ic_test_ad));
        } else {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getPrice() == null) {
            nativeAdView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            nativeAdView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) nativeAdView.getPriceView()).setText(nativeAd.getPrice());
        }
        if (nativeAd.getStore() == null) {
            nativeAdView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            nativeAdView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) nativeAdView.getStoreView()).setText(nativeAd.getStore());
        }
        if (nativeAd.getStarRating() == null) {
            nativeAdView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) nativeAdView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            nativeAdView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getAdvertiser() == null) {
            nativeAdView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) nativeAdView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            nativeAdView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        nativeAdView.setNativeAd(nativeAd);
    }

    private AdSize getAdSize(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, (int) (displayMetrics.widthPixels / displayMetrics.density));
    }
}
