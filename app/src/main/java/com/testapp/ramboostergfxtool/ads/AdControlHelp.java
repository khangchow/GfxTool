package com.testapp.ramboostergfxtool.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.testapp.ramboostergfxtool.R;

import java.util.Calendar;
import java.util.Map;

public class AdControlHelp {
    private static AdControl adControl;
    private static AdmobHelp admobHelp;
    private static Context context;
    private static AdControlHelp instance;

    public interface AdCloseListener {
        void onAdClosed();
    }

    public interface AdLoadedListener {
        void onAdLoaded();
    }

    public interface FireBaseListener {
        void addOnCompleteListener();
    }

    public interface MobileAdsInitialize {
        void onInitialized();
    }

    public static AdControlHelp getInstance(Context context2) {
        context = context2;
        adControl = AdControl.getInstance(context2);
        if (instance == null) {
            instance = new AdControlHelp();
        }
        return instance;
    }

    public void mobileAdsInitialize(Activity activity, final MobileAdsInitialize mobileAdsInitialize) {
        MobileAds.initialize(activity, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Map<String, AdapterStatus> adapterStatusMap = initializationStatus.getAdapterStatusMap();
                for (String str : adapterStatusMap.keySet()) {
                    AdapterStatus adapterStatus = adapterStatusMap.get(str);
                    Log.d("MyApp", String.format("Adapter name: %s, Description: %s, Latency: %d", str, adapterStatus.getDescription(), Integer.valueOf(adapterStatus.getLatency())));
                }
                MobileAdsInitialize mobileAdsInitialize2 = mobileAdsInitialize;
                if (mobileAdsInitialize2 != null) {
                    mobileAdsInitialize2.onInitialized();
                }
            }
        });
    }

    public boolean is_reload_firebase() {
        if (adControl.remove_ads().booleanValue()) {
            return false;
        }
        return (!AdControl._isTestAds && adControl.old_date() == Calendar.getInstance().get(5) && adControl.isInit()) ? false : true;
    }

    private AdControlHelp() {
    }

    public boolean checkShowadsTimeSpan() {
        return System.currentTimeMillis() - adControl.getLastTimeShowAds() > adControl.limit_showads();
    }

    private String getRealAdmob(String str) {
        String[] split = context.getResources().getString(R.string.id_admob).split("~");
        String stringBuffer = new StringBuffer(str).reverse().toString();
        return split[0] + "/" + stringBuffer;
    }

    public void getAdControlFromFireBase(FireBaseListener fireBaseListener) {
        AdControl adControl2 = AdControl.getInstance(context);

        String string = context.getString(R.string.ads_banner);
        String string2 = context.getString(R.string.ads_native);
        String string3 = context.getString(R.string.ads_native);
        String string4 = context.getString(R.string.ads_instritial);
        adControl2.isInit(true);
        adControl2.admob_full(string4);
        adControl2.admob_native(string2);
        adControl2.admob_native_setting(string2);
        adControl2.admob_native_rate_app(string2);
        adControl2.admob_native_banner(string3);
        adControl2.admob_native_main(string2);
        adControl2.admob_banner(string);
        adControl2.isUpdate(1);
        adControl2.limit_showads(1);
        adControl2.old_date(-1);
    }

    public void loadNative(Activity activity, LinearLayout linearLayout, int i, boolean z, boolean z2, String str) {
        if (adControl.remove_ads().booleanValue()) {
            return;
        }
        AdmobHelp admobHelp2 = AdmobHelp.getInstance(context);
        admobHelp = admobHelp2;
        admobHelp2.loadNative(activity, linearLayout, str, i, z2, z);
    }

    public void loadBanner(Activity activity, View view) {
        if (adControl.remove_ads().booleanValue()) {
            return;
        }
        AdmobHelp admobHelp2 = AdmobHelp.getInstance(context);
        admobHelp = admobHelp2;
        admobHelp2.loadBanner(activity, view, adControl.admob_banner());
    }

    public void loadInterstitialAd(Activity activity, AdCloseListener adCloseListener, AdLoadedListener adLoadedListener, boolean z) {
        Log.v("ads", "Call ads");
        if (adControl.remove_ads().booleanValue()) {
            if (!z || adCloseListener == null) {
                return;
            }
            adCloseListener.onAdClosed();
            return;
        }
        if (z) {
            if (!checkShowadsTimeSpan()) {
                if (adCloseListener != null) {
                    adCloseListener.onAdClosed();
                    return;
                }
                return;
            }
            adControl.setLastTimeShowAds();
        }
        AdmobHelp admobHelp2 = AdmobHelp.getInstance(context);
        admobHelp = admobHelp2;
        admobHelp2.loadInterstitialAd(activity, adCloseListener, adLoadedListener, adControl.admob_full(), z);
    }

    public void showInterstitialAd(Activity activity, AdCloseListener adCloseListener) {
        if (adControl.remove_ads().booleanValue()) {
            if (adCloseListener != null) {
                adCloseListener.onAdClosed();
            }
        } else if (!checkShowadsTimeSpan()) {
            if (adCloseListener != null) {
                adCloseListener.onAdClosed();
            }
        } else {
            adControl.setLastTimeShowAds();
            AdmobHelp admobHelp2 = AdmobHelp.getInstance(context);
            admobHelp = admobHelp2;
            admobHelp2.showInterstitialAd(activity, adCloseListener, adControl.admob_full());
        }
    }


}
