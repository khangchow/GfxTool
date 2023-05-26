package com.testapp.ramboostergfxtool.activity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.ads.AdControlHelp;
import com.testapp.ramboostergfxtool.ads.InterstitialAdShow;
import com.testapp.ramboostergfxtool.util.GfxUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class PubgGFXActivity extends AppCompatActivity {
    private static final String TAG = "sp_gfx_config_name";
    private LottieAnimationView animButton;
    private int backCount = 0;
    private boolean aBoolean = false;
    private String UserCustom = "x/Android/data/com.vng.pubgmobile/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini";
    private String active = "x/Android/data/com.vng.pubgmobile/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/SaveGames/Active.sav";
    private String shadow = "x/Android/data/com.vng.pubgmobile/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Logs/ShadowTrackerExtra.log";
    private Spinner spinnerGraphics;
    private Spinner spinnerFps;
    private Spinner spinnerShadows;
    private Spinner spinnerPresets;
    private Spinner spinnerStyles;
    private Spinner spinnerMSAA;
    private Spinner spinnerBl;
    private Spinner spinnerRe;
    private Spinner spinnerGPU;
    private Spinner spinnerControls;
    private SharedPreferences preferences;
    private boolean f2513s = false;
    private String gamePackage = "xcom.vng.pubgmobile";
    private boolean isBack = false;
    private Spinner spinnerVersion;

    class C04121 implements AdapterView.OnItemSelectedListener {
        final PubgGFXActivity f577a;

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        C04121(PubgGFXActivity pubgGFXActivity) {
            this.f577a = pubgGFXActivity;
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            switch (this.f577a.spinnerPresets.getSelectedItemPosition()) {
                case 0:
                    this.f577a.spinnerShadows.setEnabled(false);
                    this.f577a.spinnerShadows.setClickable(false);
                    this.f577a.spinnerMSAA.setEnabled(false);
                    this.f577a.spinnerMSAA.setClickable(false);
                    this.f577a.spinnerShadows.setAlpha(0.3f);
                    this.f577a.spinnerMSAA.setAlpha(0.3f);
                    this.f577a.spinnerShadows.setSelection(0);
                    this.f577a.spinnerMSAA.setSelection(0);
                    this.f577a.spinnerRe.setSelection(0);
                    this.f577a.spinnerBl.setSelection(0);
                    return;
                case 1:
                    this.f577a.spinnerShadows.setEnabled(false);
                    this.f577a.spinnerShadows.setClickable(false);
                    this.f577a.spinnerMSAA.setEnabled(true);
                    this.f577a.spinnerMSAA.setClickable(true);
                    this.f577a.spinnerShadows.setAlpha(0.3f);
                    this.f577a.spinnerMSAA.setAlpha(1.0f);
                    this.f577a.spinnerRe.setSelection(1);
                    this.f577a.spinnerBl.setSelection(0);
                    return;
                case 2:
                    this.f577a.spinnerShadows.setEnabled(true);
                    this.f577a.spinnerShadows.setClickable(true);
                    this.f577a.spinnerMSAA.setEnabled(true);
                    this.f577a.spinnerMSAA.setClickable(true);
                    this.f577a.spinnerShadows.setAlpha(1.0f);
                    this.f577a.spinnerMSAA.setAlpha(1.0f);
                    this.f577a.spinnerRe.setSelection(0);
                    this.f577a.spinnerBl.setSelection(0);
                    return;
                case 3:
                    this.f577a.spinnerShadows.setEnabled(true);
                    this.f577a.spinnerShadows.setClickable(true);
                    this.f577a.spinnerMSAA.setEnabled(true);
                    this.f577a.spinnerMSAA.setClickable(true);
                    this.f577a.spinnerShadows.setAlpha(1.0f);
                    this.f577a.spinnerMSAA.setAlpha(1.0f);
                    this.f577a.spinnerRe.setSelection(1);
                    this.f577a.spinnerBl.setSelection(0);
                    return;
                case 4:
                case 5:
                case 6:
                    this.f577a.spinnerShadows.setEnabled(true);
                    this.f577a.spinnerShadows.setClickable(true);
                    this.f577a.spinnerMSAA.setEnabled(true);
                    this.f577a.spinnerMSAA.setClickable(true);
                    this.f577a.spinnerShadows.setAlpha(1.0f);
                    this.f577a.spinnerMSAA.setAlpha(1.0f);
                    this.f577a.spinnerRe.setSelection(2);
                    this.f577a.spinnerBl.setSelection(1);
                    return;
                default:
                    return;
            }
        }
    }

    class ContinueClick implements View.OnClickListener {
        final PubgGFXActivity pubgGFXActivity;

        ContinueClick(PubgGFXActivity pubgGFXActivity2) {
            this.pubgGFXActivity = pubgGFXActivity2;
        }

        @SuppressLint("WrongConstant")
        public void onClick(View view) {
            if (!this.pubgGFXActivity.f2513s) {
                if (!this.pubgGFXActivity.aBoolean) {
                    this.pubgGFXActivity.f2513s = true;
                }
                this.pubgGFXActivity.animButton.playAnimation();
                this.pubgGFXActivity.eventRunGame();
                return;
            }
            Intent launchIntentForPackage = this.pubgGFXActivity.getPackageManager().getLaunchIntentForPackage(PubgGFXActivity.this.gamePackage);
            if (launchIntentForPackage != null) {
                ((ActivityManager) this.pubgGFXActivity.getSystemService("activity")).killBackgroundProcesses(PubgGFXActivity.this.gamePackage);
                this.pubgGFXActivity.startActivity(launchIntentForPackage);
                return;
            }
            Toast.makeText(this.pubgGFXActivity, "Please install PUBG Mobile or chose your installed version ", 1).show();
        }
    }

    class ButtonAnimation implements Animator.AnimatorListener {
        final PubgGFXActivity pubgGFXActivity;

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        ButtonAnimation(PubgGFXActivity pubgGFXActivity2) {
            this.pubgGFXActivity = pubgGFXActivity2;
        }

        public void onAnimationStart(Animator animator) {
            this.pubgGFXActivity.animButton.setEnabled(false);
            this.pubgGFXActivity.animButton.setClickable(false);
        }

        public void onAnimationEnd(Animator animator) {
            this.pubgGFXActivity.animButton.setEnabled(true);
            this.pubgGFXActivity.animButton.setClickable(true);
        }
    }

    class C04155 implements View.OnClickListener {
        final PubgGFXActivity f580a;

        C04155(PubgGFXActivity pubgGFXActivity) {
            this.f580a = pubgGFXActivity;
        }

        public void onClick(View view) {
            this.f580a.finish();
        }
    }

    
    public class C04166 implements Runnable {
        final PubgGFXActivity pubgGFXActivity;

        C04166(PubgGFXActivity pubgGFXActivity2) {
            this.pubgGFXActivity = pubgGFXActivity2;
        }

        public void run() {
            this.pubgGFXActivity.spinnerBl.setSelection(this.pubgGFXActivity.preferences.getInt("lightEffectsSpinner", 0));
            this.pubgGFXActivity.spinnerRe.setSelection(this.pubgGFXActivity.preferences.getInt("renderingQualitySpinner", 0));
            this.pubgGFXActivity.spinnerGPU.setSelection(this.pubgGFXActivity.preferences.getInt("gpuSpinner", 0));
            this.pubgGFXActivity.spinnerVersion.setSelection(this.pubgGFXActivity.preferences.getInt("versionSpinner", 0));
        }
    }

    
    
    private void eventRunGame() {
        getVersion();
        sentPref();
        SelectPres();
        sFps();
        selectGraph();
        selectSha();
        selectMsaa();
        selectedItem();
        selectRe();
        selectBl();
        getAssLog();
    }

    private void getVersion() {
        int selectedItemPosition = this.spinnerVersion.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            this.UserCustom = "/Android/data/com.tencent.ig/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini";
            this.active = "/Android/data/com.tencent.ig/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/SaveGames/Active.sav";
            this.shadow = "/Android/data/com.tencent.ig/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Logs/ShadowTrackerExtra.log";
            this.gamePackage = "com.tencent.ig";
        } else if (selectedItemPosition == 1) {
            this.UserCustom = "/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini";
            this.active = "/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/SaveGames/Active.sav";
            this.shadow = "/Android/data/com.tencent.tmgp.pubgmhd/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Logs/ShadowTrackerExtra.log";
            this.gamePackage = "com.tencent.tmgp.pubgmhd";
        } else if (selectedItemPosition == 2) {
            this.UserCustom = "/Android/data/com.pubg.krmobile/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini";
            this.active = "/Android/data/com.pubg.krmobile/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/SaveGames/Active.sav";
            this.shadow = "/Android/data/com.pubg.krmobile/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Logs/ShadowTrackerExtra.log";
            this.gamePackage = "com.pubg.krmobile";
        } else if (selectedItemPosition == 3) {
            this.UserCustom = "/Android/data/com.vng.pubgmobile/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini";
            this.active = "/Android/data/com.vng.pubgmobile/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/SaveGames/Active.sav";
            this.shadow = "/Android/data/com.vng.pubgmobile/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Logs/ShadowTrackerExtra.log";
            this.gamePackage = "com.vng.pubgmobile";
        } else if (selectedItemPosition == 4) {
            this.UserCustom = "/Android/data/com.rekoo.pubgm/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini";
            this.active = "/Android/data/com.rekoo.pubgm/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/SaveGames/Active.sav";
            this.shadow = "/Android/data/com.rekoo.pubgm/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Logs/ShadowTrackerExtra.log";
            this.gamePackage = "com.rekoo.pubgm";
        } else if (selectedItemPosition == 5) {
            this.UserCustom = "/Android/data/com.tencent.iglite/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Config/Android/UserCustom.ini";
            this.active = "/Android/data/com.tencent.iglite/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/SaveGames/Active.sav";
            this.shadow = "/Android/data/com.tencent.iglite/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Logs/ShadowTrackerExtra.log";
            this.gamePackage = "com.tencent.iglite";
        }
    }

    private String shadowAsk() {
        return Environment.getExternalStorageDirectory().getPath() + this.shadow;
    }

    private void getAssLog() {
        try {
            InputStream open = getAssets().open("what.log");
            FileOutputStream fileOutputStream = new FileOutputStream(shadowAsk());
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void selectedItem() {
        int i;
        int selectedItemPosition = this.spinnerStyles.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            i = 62;
        } else if (selectedItemPosition == 1) {
            i = 63;
        } else if (selectedItemPosition == 2) {
            i = 64;
        } else if (selectedItemPosition == 3) {
            i = 65;
        } else if (selectedItemPosition == 4) {
            i = 66;
        } else {
            return;
        }
        indexF("0B572C0A1C0B313D2B2A1C0D0D10171E44", GfxUtil.m728a(i));
    }

    private void selectBl() {
        int i;
        String m728a = GfxUtil.m728a(67);
        int selectedItemPosition = this.spinnerBl.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            i = 68;
        } else if (selectedItemPosition == 1) {
            i = 69;
        } else if (selectedItemPosition == 2) {
            i = 70;
        } else if (selectedItemPosition == 3) {
            i = 71;
        } else {
            return;
        }
        indexF(m728a, GfxUtil.m728a(i));
    }

    private void selectRe() {
        int i;
        String m728a = GfxUtil.m728a(88);
        int selectedItemPosition = this.spinnerRe.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            i = 89;
        } else if (selectedItemPosition == 1) {
            i = 90;
        } else if (selectedItemPosition == 2) {
            i = 91;
        } else {
            return;
        }
        indexF(m728a, GfxUtil.m728a(i));
    }

    private void selectMsaa() {
        int i;
        String m728a = GfxUtil.m728a(92);
        String m728a2 = GfxUtil.m728a(93);
        String m728a3 = GfxUtil.m728a(94);
        String m728a4 = GfxUtil.m728a(95);
        int selectedItemPosition = this.spinnerMSAA.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            indexF(m728a, GfxUtil.m728a(96));
            indexF(m728a2, GfxUtil.m728a(97));
            indexF(m728a3, GfxUtil.m728a(98));
            i = 99;
        } else if (selectedItemPosition == 1) {
            indexF(m728a, GfxUtil.m728a(100));
            indexF(m728a2, GfxUtil.m728a(101));
            indexF(m728a3, GfxUtil.m728a(102));
            i = 103;
        } else if (selectedItemPosition == 2) {
            indexF(m728a, GfxUtil.m728a(104));
            indexF(m728a2, GfxUtil.m728a(105));
            indexF(m728a3, GfxUtil.m728a(106));
            i = 107;
        } else {
            return;
        }
        indexF(m728a4, GfxUtil.m728a(i));
    }

    private void selectSha() {
        String m728a = GfxUtil.m728a(27);
        String m728a2 = GfxUtil.m728a(28);
        String m728a3 = GfxUtil.m728a(29);
        String m728a4 = GfxUtil.m728a(30);
        String m728a5 = GfxUtil.m728a(31);
        GfxUtil.m728a(32);
        GfxUtil.m728a(33);
        if (this.spinnerShadows.getSelectedItemPosition() == 1) {
            indexF(m728a, GfxUtil.m728a(34));
            indexF(m728a2, GfxUtil.m728a(35));
            indexF(m728a3, GfxUtil.m728a(36));
            indexF(m728a4, GfxUtil.m728a(37));
            indexF(m728a5, GfxUtil.m728a(38));
        }
    }

    private void selectGraph() {
        int i;
        String m728a = GfxUtil.m728a(54);
        int selectedItemPosition = this.spinnerGraphics.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            i = 55;
        } else if (selectedItemPosition == 1) {
            i = 56;
        } else if (selectedItemPosition == 2) {
            i = 57;
        } else if (selectedItemPosition == 3) {
            i = 58;
        } else if (selectedItemPosition == 4) {
            i = 59;
        } else if (selectedItemPosition == 5) {
            i = 60;
        } else {
            return;
        }
        indexF(m728a, GfxUtil.m728a(i));
    }

    private void sentPref() {
        SharedPreferences.Editor edit = this.preferences.edit();
        edit.putInt("resolutionSpinner", this.spinnerGraphics.getSelectedItemPosition());
        edit.putInt("fpsSpinner", this.spinnerFps.getSelectedItemPosition());
        edit.putInt("antiAliasingSpinner", this.spinnerMSAA.getSelectedItemPosition());
        edit.putInt("lightEffectsSpinner", this.spinnerBl.getSelectedItemPosition());
        edit.putInt("renderingQualitySpinner", this.spinnerRe.getSelectedItemPosition());
        edit.putInt("shadowsSpinner", this.spinnerShadows.getSelectedItemPosition());
        edit.putInt("graphicsSpinner", this.spinnerPresets.getSelectedItemPosition());
        edit.putInt("stylesSpinner", this.spinnerStyles.getSelectedItemPosition());
        edit.putInt("gpuSpinner", this.spinnerGPU.getSelectedItemPosition());
        edit.putInt("versionSpinner", this.spinnerVersion.getSelectedItemPosition());
        edit.apply();
    }

    private void SelectPres() {
        int i;
        switch (this.spinnerPresets.getSelectedItemPosition()) {
            case 0:
                i = 20;
                break;
            case 1:
                i = 21;
                break;
            case 2:
                i = 22;
                break;
            case 3:
                i = 23;
                break;
            case 4:
                i = 24;
                break;
            case 5:
                i = 25;
                break;
            case 6:
                i = 26;
                break;
            default:
                return;
        }
        FileString(GfxUtil.m728a(i));
    }

    public void FileString(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(userCustom());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str2 = new String(bArr);
            if (str2.contains("+CVars")) {
                String substring = str2.substring(str2.indexOf("[BackUp DeviceProfile]"), str2.indexOf("[UserCustom DeviceProfile]"));
                substring.trim();
                FileOutputStream fileOutputStream = new FileOutputStream(userCustom());
                fileOutputStream.write((str + GfxUtil.m728a(202) + substring).getBytes());
                fileInputStream.close();
                fileOutputStream.close();
            } else {
                str2.trim();
            }
        } catch (Throwable unused) {
        }
        nameFile(str);
    }

    private String userCustom() {
        return Environment.getExternalStorageDirectory().getPath() + this.UserCustom;
    }

    public void nameFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(userCustom());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str2 = new String(bArr);
            if (str2.contains("+CVars")) {
                String substring = str2.substring(str2.indexOf("[BackUp DeviceProfile]"));
                substring.trim();
                FileOutputStream fileOutputStream = new FileOutputStream(userCustom());
                fileOutputStream.write((str + GfxUtil.m728a(205) + substring).getBytes());
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            str2.trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sFps() {
        String m728a = GfxUtil.m728a(124);
        String m728a2 = GfxUtil.m728a(125);
        String m728a3 = GfxUtil.m728a(126);
        String m728a4 = GfxUtil.m728a(127);
        String m728a5 = GfxUtil.m728a(128);
        int selectedItemPosition = this.spinnerFps.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            indexF(m728a5, GfxUtil.m728a(129));
            indexF(m728a, GfxUtil.m728a(130));
            indexF(m728a2, GfxUtil.m728a(131));
            indexF(m728a3, GfxUtil.m728a(132));
            indexF(m728a4, GfxUtil.m728a(133));
        } else if (selectedItemPosition == 2) {
            indexF(m728a5, GfxUtil.m728a(152));
            indexF(m728a, GfxUtil.m728a(153));
            indexF(m728a2, GfxUtil.m728a(154));
            indexF(m728a3, GfxUtil.m728a(155));
            indexF(m728a4, GfxUtil.m728a(156));
        } else if (selectedItemPosition == 3) {
            indexF(m728a5, GfxUtil.m728a(175));
            indexF(m728a, GfxUtil.m728a(176));
            indexF(m728a2, GfxUtil.m728a(177));
            indexF(m728a3, GfxUtil.m728a(178));
            indexF(m728a4, GfxUtil.m728a(179));
        }
    }

    public void indexF(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(userCustom());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str3 = new String(bArr);
            String str4 = GfxUtil.m728a(206) + str;
            if (str3.contains(str4)) {
                int indexOf = str3.indexOf(str4);
                int lastIndexOf = str3.substring(indexOf, indexOf + 80).lastIndexOf(GfxUtil.m728a(207)) + indexOf;
                String substring = str3.substring(indexOf, lastIndexOf);
                String substring2 = str3.substring(0, lastIndexOf);
                String substring3 = str3.substring(lastIndexOf);
                String replace = substring2.replace(substring, str4 + str2 + GfxUtil.m728a(208));
                FileOutputStream fileOutputStream = new FileOutputStream(userCustom());
                fileOutputStream.write((replace + substring3).getBytes());
                fileInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    AdControlHelp adControlHelp;

    @Override 
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pubg_tool);
        AdControlHelp adControlHelp = AdControlHelp.getInstance(this);
        this.adControlHelp = adControlHelp;
        adControlHelp.loadBanner(this, findViewById(R.id.banner));

        new StringBuilder();
        this.animButton = (LottieAnimationView) findViewById(R.id.lottie_accept);
        this.animButton.setAnimation(R.raw.accept_btn);
        animButton.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
            @Override
            public void onCompositionLoaded(LottieComposition composition) {
                animButton.setComposition(composition);
            }
        });

        this.animButton.setOnClickListener(new ContinueClick(this));
        this.animButton.addAnimatorListener(new ButtonAnimation(this));
        this.preferences = getSharedPreferences(TAG, 0);
        this.spinnerGraphics = (Spinner) findViewById(R.id.spinnerGraphics);
        this.spinnerFps = (Spinner) findViewById(R.id.spinnerFps);
        this.spinnerMSAA = (Spinner) findViewById(R.id.spinnerMSAA);
        this.spinnerBl = (Spinner) findViewById(R.id.spinnerBl);
        this.spinnerRe = (Spinner) findViewById(R.id.spinnerRe);
        this.spinnerShadows = (Spinner) findViewById(R.id.spinnerShadows);
        this.spinnerPresets = (Spinner) findViewById(R.id.spinnerPresets);
        this.spinnerStyles = (Spinner) findViewById(R.id.spinnerStyles);
        this.spinnerControls = (Spinner) findViewById(R.id.spinnerControls);
        this.spinnerGPU = (Spinner) findViewById(R.id.spinnerGPU);
        this.spinnerVersion = (Spinner) findViewById(R.id.spinnerVersion);
        styleIconSpinner(this.spinnerGraphics, R.array.resolution);
        styleIconSpinner(this.spinnerFps, R.array.fps);
        styleIconSpinner(this.spinnerMSAA, R.array.aa);
        styleIconSpinner(this.spinnerBl, R.array.bl);
        styleIconSpinner(this.spinnerRe, R.array.re);
        styleIconSpinner(this.spinnerShadows, R.array.shadows);
        styleIconSpinner(this.spinnerPresets, R.array.presets);
        styleIconSpinner(this.spinnerStyles, R.array.styles);
        styleIconSpinner(this.spinnerControls, R.array.controls);
        styleIconSpinner(this.spinnerGPU, R.array.gpu);
        styleIconSpinner(this.spinnerVersion, R.array.game_version);
        setSpinnerClick(this.spinnerGraphics);
        setSpinnerClick(this.spinnerFps);
        setSpinnerClick(this.spinnerMSAA);
        setSpinnerClick(this.spinnerBl);
        setSpinnerClick(this.spinnerRe);
        setSpinnerClick(this.spinnerShadows);
        setSpinnerClick(this.spinnerPresets);
        setSpinnerClick(this.spinnerStyles);
        setSpinnerClick(this.spinnerControls);
        setSpinnerClick(this.spinnerGPU);
        setSpinnerClick(this.spinnerVersion);
        this.spinnerPresets.setOnItemSelectedListener(new C04121(this));
        getAssLog();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle((CharSequence) getString(R.string.gfx_tool));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left_white);
        toolbar.setNavigationOnClickListener(new C04155(this));
        actionPref();


        InterstitialAdShow.getInstance(PubgGFXActivity.this).showInterstitialAd(PubgGFXActivity.this, new  InterstitialAdShow.AdCloseListener() {
            @Override
            public void onAdClosed() {

                if (PubgGFXActivity.this.isBack) {
                    PubgGFXActivity.this.finish();
                    return;
                }
                Intent launchIntentForPackage = PubgGFXActivity.this.getPackageManager().getLaunchIntentForPackage(PubgGFXActivity.this.gamePackage);
                if (launchIntentForPackage != null) {
                    ((ActivityManager) PubgGFXActivity.this.getSystemService(Context.ACTIVITY_SERVICE)).killBackgroundProcesses(PubgGFXActivity.this.gamePackage);
                    PubgGFXActivity.this.startActivity(launchIntentForPackage);
                    return;
                }
                Toast.makeText(PubgGFXActivity.this, "Please install PUBG Mobile or chose your installed version ", Toast.LENGTH_LONG).show();

            }
        });
    }
    private void actionPref() {
        this.spinnerPresets.setSelection(this.preferences.getInt("graphicsSpinner", 0));
        this.spinnerGraphics.setSelection(this.preferences.getInt("resolutionSpinner", 0));
        this.spinnerFps.setSelection(this.preferences.getInt("fpsSpinner", 0));
        this.spinnerShadows.setSelection(this.preferences.getInt("shadowsSpinner", 0));
        this.spinnerStyles.setSelection(this.preferences.getInt("stylesSpinner", 0));
        this.spinnerMSAA.setSelection(this.preferences.getInt("antiAliasingSpinner", 0));
        this.spinnerVersion.setSelection(this.preferences.getInt("versionSpinner", 0));
        this.spinnerPresets.postDelayed(new C04166(this), 500);
    }

    private void styleIconSpinner(Spinner spinner, int i) {
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(this, i, R.layout.spinner_item);
        createFromResource.setDropDownViewResource(R.layout.layout_spinner_style);
        spinner.setAdapter((SpinnerAdapter) createFromResource);
        spinner.setPopupBackgroundResource(R.drawable.spinner_background);
    }

    private String ask() {
        return Environment.getExternalStorageDirectory().getPath() + this.active;
    }

    public void setSpinnerClick(Spinner spinner) {
        spinner.setOnItemSelectedListener(new SpinnerChangeListener(this));
    }

    
    public class SpinnerChangeListener implements AdapterView.OnItemSelectedListener {
        final PubgGFXActivity pubgGFXActivity;

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        public SpinnerChangeListener(PubgGFXActivity pubgGFXActivity2) {
            this.pubgGFXActivity = pubgGFXActivity2;
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.pubgGFXActivity.f2513s = false;
            this.pubgGFXActivity.animButton.setProgress(0.0f);
        }
    }

    @Override
    public void onBackPressed() {
        this.isBack = true;
        super.onBackPressed();
    }
}
