package com.testapp.ramboostergfxtool.ads;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.testapp.ramboostergfxtool.R;

import java.util.Arrays;

public class InterstitialAdShow {
    public static InterstitialAd sInterstitialAd;
    Activity activity;

    public interface AdCloseListener {
        void onAdClosed();
    }

    private InterstitialAdShow(Activity activity) {
        this.activity = activity;
    }

    public static InterstitialAdShow getInstance(Activity activity) {
        return new InterstitialAdShow(activity);
    }

    public static void populateUnifiedNativeAdView(NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }
        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }
        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        nativeAd.getMediaContent().getVideoController().setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            @Override
            public void onVideoStart() {
                Log.d("MyApp", "Video Started");
            }

            @Override
            public void onVideoPlay() {
                Log.d("MyApp", "Video Played");
            }

            @Override
            public void onVideoPause() {
                Log.d("MyApp", "Video Paused");
            }

            @Override
            public void onVideoEnd() {
                Log.d("MyApp", "Video Ended");
            }

            @Override
            public void onVideoMute(boolean isMuted) {
                Log.d("MyApp", "Video Muted");
            }
        });
        adView.setNativeAd(nativeAd);
    }

    public void loadNative(final Activity activity, final LinearLayout adsframeLayout) {
        RequestConfiguration configuration = new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("B3CCB7925386F17AA54D87FB714D70C3")).build();
        MobileAds.setRequestConfiguration(configuration);
        MobileAds.initialize(activity, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        VideoOptions videoOptions = new VideoOptions.Builder().setStartMuted(false).build();
        NativeAdOptions adOptions = new NativeAdOptions.Builder().setVideoOptions(videoOptions).build();
        AdLoader.Builder builder = new AdLoader.Builder(activity, activity.getResources().getString(R.string.ads_native)).withNativeAdOptions(adOptions);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(NativeAd unifiedNativeAd) {
                if (unifiedNativeAd == null) {
                    return;
                }
                if (activity.isDestroyed()) {
                    unifiedNativeAd.destroy();
                    return;
                }
                NativeAdView adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.item_admob_native_setting, (ViewGroup) null);
                InterstitialAdShow.populateUnifiedNativeAdView(unifiedNativeAd, adView);
                adsframeLayout.removeAllViews();
                adsframeLayout.addView(adView);
            }
        });
        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        }).build();
        AdRequest adRequest = new AdRequest.Builder().build();
        adLoader.loadAd(adRequest);
    }

    public void loadInterstitialAd(Activity activity) {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(activity, activity.getResources().getString(R.string.ads_instritial), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(InterstitialAd interstitialAd) {
                InterstitialAdShow.sInterstitialAd = interstitialAd;
                Log.e("aaaaaaaaa", "onAdLoaded.");
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e("aaaaaaaaa", loadAdError.getMessage());
                InterstitialAdShow.sInterstitialAd = null;
            }
        });
    }

    public void showInterstitialAd(final Activity activity, final AdCloseListener onClose) {
        InterstitialAd interstitialAd = sInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    InterstitialAdShow.this.loadInterstitialAd(activity);
                    Log.e("aaaaaaaaa", "The ad was dismissed.");
                    onClose.onAdClosed();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    InterstitialAdShow.this.loadInterstitialAd(activity);
                    Log.e("aaaaaaaaa", "The ad failed to show.");
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    Log.e("aaaaaaaaa", "The ad was shown.");
                }
            });
            interstitialAd.show(activity);
            return;
        }
        onClose.onAdClosed();
        loadInterstitialAd(activity);
    }
}