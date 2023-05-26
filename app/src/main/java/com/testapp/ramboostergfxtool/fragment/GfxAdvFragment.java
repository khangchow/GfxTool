package com.testapp.ramboostergfxtool.fragment;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.strings.First;
import com.testapp.ramboostergfxtool.view.ExtendExpandView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class GfxAdvFragment extends Fragment implements View.OnClickListener {
    private Button applySettingsButton;
    private RadioButton chinaVersionRadio;
    private Boolean isVersion1;
    private final Boolean isVersion2;
    private final Boolean isVersion3;
    private Boolean isVersion4;
    private int val1 = 1;
    private String strV1;
    private String strV2;
    private String strV3;
    private String strV4;
    private String strV5;
    private String strV6;
    private String strV7;
    private String spinResolution;
    private Boolean isVersionSelected;
    private LinearLayout layoutAntiAliasing;
    private LinearLayout layoutColorFormat;
    private LinearLayout layoutDetailQuality;
    private LinearLayout layoutFPS;
    private LinearLayout layoutFpsChina;
    private LinearLayout layoutGraphics;
    private LinearLayout layoutGraphicsLite;
    private LinearLayout layoutLightEffects;
    private LinearLayout layoutMovingShadows;
    private LinearLayout layoutSound;
    private LinearLayout layoutStyles;
    private LinearLayout layoutTextureQuality;
    private LinearLayout layoutWaterReflection;
    private RadioButton liteVersionRadio;
    private RadioButton playVersionRadio;
    private SharedPreferences preferences;
    private RadioButton southKoreaVersionRadio;
    private Spinner spinnerAntiAliasing;
    private Spinner spinnerColorFormat;
    private Spinner spinnerControls;
    private Spinner spinnerDetailMode;
    private Spinner spinnerEffectsQuality;
    private Spinner spinnerFoliage;
    private Spinner spinnerFps;
    private Spinner spinnerFpsChina;
    private Spinner spinnerGPU;
    private Spinner spinnerGraphics;
    private Spinner spinnerGraphicsAPI;
    private Spinner spinnerGraphicsLite;
    private Spinner spinnerLODDistance;
    private Spinner spinnerLightEffects;
    private Spinner spinnerMovingShadows;
    private Spinner spinnerRenderingQuality;
    private Spinner spinnerResolution;
    private Spinner spinnerShadows;
    private Spinner spinnerShadowsDistance;
    private Spinner spinnerSound;
    private Spinner spinnerSpawn;
    private Spinner spinnerStyles;
    private Spinner spinnerTextureQuality;
    private Spinner spinnerWaterReflection;
    private RadioButton taiwanVersionRadio;
    private int totalClicks = 0;
    private RadioButton vietnamVersionRadio;
    private LinearLayout lrUselessVersion;
    private ExtendExpandView listVersionDown;
    private ExpandableRelativeLayout expandableUselessVersion;
    private Dialog dialogAccept;

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.lrUselessVersion:
                expandableUselessVersion.toggle();
                expandableUselessVersion.setListener(new ExpandableLayoutListener() {
                    @Override
                    public void onAnimationStart() {
                    }

                    @Override
                    public void onAnimationEnd() {
                    }

                    @Override
                    public void onPreOpen() {


                    }

                    @Override
                    public void onPreClose() {

                    }

                    @Override
                    public void onOpened() {

                        listVersionDown.setChecked(true);
                    }

                    @Override
                    public void onClosed() {

                        listVersionDown.setChecked(false);
                    }
                });

                break;
        }
    }

    class onRenderingQualityChange implements AdapterView.OnItemSelectedListener {
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        onRenderingQualityChange() {
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            int selectedItemPosition = GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition();
            if (selectedItemPosition != 0) {
                if (selectedItemPosition == 1) {
                    GfxAdvFragment.this.spinnerShadows.setEnabled(true);
                    GfxAdvFragment.this.spinnerShadows.setClickable(true);
                    if (GfxAdvFragment.this.spinnerShadows.getSelectedItemPosition() != 0) {
                        GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(true);
                        GfxAdvFragment.this.spinnerShadowsDistance.setClickable(true);
                        if (GfxAdvFragment.this.spinnerGraphics.getSelectedItemPosition() <= 3) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (selectedItemPosition == 2) {
                    GfxAdvFragment.this.spinnerShadows.setEnabled(true);
                    GfxAdvFragment.this.spinnerShadows.setClickable(true);
                    if (GfxAdvFragment.this.spinnerShadows.getSelectedItemPosition() != 0) {
                        GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(true);
                        GfxAdvFragment.this.spinnerShadowsDistance.setClickable(true);
                        if (GfxAdvFragment.this.spinnerGraphics.getSelectedItemPosition() <= 3) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                GfxAdvFragment.this.spinnerMovingShadows.setEnabled(true);
                GfxAdvFragment.this.spinnerMovingShadows.setClickable(true);
                return;
            }
            GfxAdvFragment.this.spinnerShadows.setSelection(0);
            GfxAdvFragment.this.spinnerShadows.setEnabled(false);
            GfxAdvFragment.this.spinnerShadows.setClickable(false);
            GfxAdvFragment.this.spinnerShadowsDistance.setSelection(0);
            GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(false);
            GfxAdvFragment.this.spinnerShadowsDistance.setClickable(false);
            GfxAdvFragment.this.spinnerMovingShadows.setSelection(0);
            GfxAdvFragment.this.spinnerMovingShadows.setEnabled(false);
            GfxAdvFragment.this.spinnerMovingShadows.setClickable(false);
        }
    }

    class onShadowsChange implements AdapterView.OnItemSelectedListener {
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        onShadowsChange() {
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            int selectedItemPosition = GfxAdvFragment.this.spinnerShadows.getSelectedItemPosition();
            if (selectedItemPosition == 0) {
                GfxAdvFragment.this.spinnerShadowsDistance.setSelection(0);
                GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(false);
                GfxAdvFragment.this.spinnerShadowsDistance.setClickable(false);
            } else if (selectedItemPosition != 1) {
                if (selectedItemPosition != 2) {
                    if (selectedItemPosition != 3) {
                        if (selectedItemPosition != 4) {
                            if (selectedItemPosition == 5 && GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition() != 0) {
                                GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(true);
                                GfxAdvFragment.this.spinnerShadowsDistance.setClickable(true);
                                if (GfxAdvFragment.this.spinnerGraphics.getSelectedItemPosition() <= 3) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition() != 0) {
                            GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(true);
                            GfxAdvFragment.this.spinnerShadowsDistance.setClickable(true);
                            if (GfxAdvFragment.this.spinnerGraphics.getSelectedItemPosition() <= 3) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition() != 0) {
                        GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(true);
                        GfxAdvFragment.this.spinnerShadowsDistance.setClickable(true);
                        if (GfxAdvFragment.this.spinnerGraphics.getSelectedItemPosition() <= 3) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition() != 0) {
                    GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(true);
                    GfxAdvFragment.this.spinnerShadowsDistance.setClickable(true);
                    if (GfxAdvFragment.this.spinnerGraphics.getSelectedItemPosition() <= 3) {
                        return;
                    }
                } else {
                    return;
                }
                GfxAdvFragment.this.spinnerMovingShadows.setEnabled(true);
                GfxAdvFragment.this.spinnerMovingShadows.setClickable(true);
                return;
            } else if (GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition() != 0) {
                GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(true);
                GfxAdvFragment.this.spinnerShadowsDistance.setClickable(true);
                if (GfxAdvFragment.this.spinnerGraphics.getSelectedItemPosition() <= 3) {
                    return;
                }
            } else {
                return;
            }
            GfxAdvFragment.this.spinnerMovingShadows.setSelection(0);
            GfxAdvFragment.this.spinnerMovingShadows.setEnabled(false);
            GfxAdvFragment.this.spinnerMovingShadows.setClickable(false);
        }
    }

    class onPlayVersionSelect implements View.OnClickListener {
        onPlayVersionSelect() {
        }

        public void onClick(View view) {
            GfxAdvFragment.this.gameVersionSelect(1);
        }
    }

    class onChinaVersionSelect implements View.OnClickListener {
        onChinaVersionSelect() {
        }

        public void onClick(View view) {
            GfxAdvFragment.this.gameVersionSelect(2);
        }
    }

    class onSouthKoreaVersionSelect implements View.OnClickListener {
        onSouthKoreaVersionSelect() {
        }

        public void onClick(View view) {
            GfxAdvFragment.this.gameVersionSelect(3);
        }
    }

    class onVietnamVersionSelect implements View.OnClickListener {
        onVietnamVersionSelect() {
        }

        public void onClick(View view) {
            GfxAdvFragment.this.gameVersionSelect(4);
        }
    }

    class onTaiwanVersionSelect implements View.OnClickListener {
        onTaiwanVersionSelect() {
        }

        public void onClick(View view) {
            GfxAdvFragment.this.gameVersionSelect(5);
        }
    }

    class onLiteVersionSelect implements View.OnClickListener {
        onLiteVersionSelect() {
        }

        public void onClick(View view) {
            GfxAdvFragment.this.gameVersionSelect(6);
        }
    }

    class onApplySettingsClick implements View.OnClickListener {
        onApplySettingsClick() {
        }

        @Override
        public void onClick(View view) {
            Button appCompatButton;
            String str;
            Button appCompatButton2;
            String str2;
            String str3 = First.seco(-16533190106998L);
            if (!GfxAdvFragment.this.isVersionSelected.booleanValue()) {
                Toast.makeText(GfxAdvFragment.this.getActivity(), First.seco(-13780116070262L), Toast.LENGTH_SHORT).show();
            } else if (GfxAdvFragment.this.totalClicks == 1) {
                if (GfxAdvFragment.this.val1 == 2) {
                    str3 = First.seco(-16606204551030L);
                }
                if (GfxAdvFragment.this.val1 == 3) {
                    str3 = First.seco(-16979866705782L);
                }
                if (GfxAdvFragment.this.val1 == 4) {
                    str3 = First.seco(-16799478079350L);
                }
                if (GfxAdvFragment.this.val1 == 5) {
                    str3 = First.seco(-16855312654198L);
                }
                if (GfxAdvFragment.this.val1 == 6) {
                    str3 = First.seco(-13900375154550L);
                }
                if (GfxAdvFragment.this.val1 == 7) {
                    str3 = First.seco(-13999159402358L);
                }

                Intent launchIntentForPackage = GfxAdvFragment.this.getActivity().getPackageManager().getLaunchIntentForPackage(str3);
                if (launchIntentForPackage != null) {
                    ((ActivityManager) GfxAdvFragment.this.getActivity().getSystemService(Context.ACTIVITY_SERVICE)).killBackgroundProcesses(str3);
                    GfxAdvFragment.this.startActivity(launchIntentForPackage);
                }


                Toast.makeText(getActivity(), "Please install PUBG Mobile or chose your installed version ", Toast.LENGTH_LONG).show();
                GfxAdvFragment.this.getActivity().finish();
            } else if (GfxAdvFragment.this.isVersion1.booleanValue() || !GfxAdvFragment.this.isVersion2.booleanValue()) {
                GfxAdvFragment.this.inputFile();
                DialogLayoutAccept(view);
                GfxAdvFragment.this.totalClicks = 1;
                if (GfxAdvFragment.this.isVersion3.booleanValue()) {
                    appCompatButton = GfxAdvFragment.this.applySettingsButton;
                    str = GfxAdvFragment.this.getString(R.string.open_file_manager);

                } else {
                    GfxAdvFragment.this.inputFile();
                    GfxAdvFragment.this.setupGfx();
                    appCompatButton = GfxAdvFragment.this.applySettingsButton;
                    str = GfxAdvFragment.this.getString(R.string.run_game);

                }
                appCompatButton.setText(str);
                GfxAdvFragment.this.setButtonOnApplySettings();
            } else {
                if (GfxAdvFragment.this.isVersion3.booleanValue()) {
                    DialogLayoutAccept(view);
                    appCompatButton2 = GfxAdvFragment.this.applySettingsButton;
                    str2 = GfxAdvFragment.this.getString(R.string.open_file_manager);
                } else {
                    GfxAdvFragment.this.inputFile();
                    GfxAdvFragment.this.setupGfx();
                    appCompatButton2 = GfxAdvFragment.this.applySettingsButton;
                    str2 = GfxAdvFragment.this.getString(R.string.run_game);
                }
                appCompatButton2.setText(str2);
                GfxAdvFragment.this.setButtonOnApplySettings();
                GfxAdvFragment.this.totalClicks = 1;
            }
            GfxAdvFragment.this.editPreferenceValues();
        }
    }

    class onGraphicsSelectorChange implements AdapterView.OnItemSelectedListener {
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        onGraphicsSelectorChange() {
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            int selectedItemPosition = GfxAdvFragment.this.spinnerGraphics.getSelectedItemPosition();
            if (selectedItemPosition != 0) {
                if (selectedItemPosition != 1) {
                    if (selectedItemPosition != 2) {
                        if (selectedItemPosition != 3) {
                            if (selectedItemPosition != 4) {
                                return;
                            }
                            if (GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition() != 0) {
                                GfxAdvFragment.this.spinnerShadows.setEnabled(true);
                                GfxAdvFragment.this.spinnerShadows.setClickable(true);
                            }
                        } else if (GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition() != 0) {
                            GfxAdvFragment.this.spinnerShadows.setEnabled(true);
                            GfxAdvFragment.this.spinnerShadows.setClickable(true);
                        }
                    } else if (GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition() != 0) {
                        GfxAdvFragment.this.spinnerShadows.setEnabled(true);
                        GfxAdvFragment.this.spinnerShadows.setClickable(true);
                    }
                    GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(true);
                    GfxAdvFragment.this.spinnerShadowsDistance.setClickable(true);
                    GfxAdvFragment.this.spinnerMovingShadows.setEnabled(true);
                    GfxAdvFragment.this.spinnerMovingShadows.setClickable(true);
                } else {
                    if (GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition() != 0) {
                        GfxAdvFragment.this.spinnerShadows.setEnabled(true);
                        GfxAdvFragment.this.spinnerShadows.setClickable(true);
                        if (GfxAdvFragment.this.spinnerShadows.getSelectedItemPosition() != 0) {
                            GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(true);
                            GfxAdvFragment.this.spinnerShadowsDistance.setClickable(true);
                        }
                    }
                    GfxAdvFragment.this.spinnerMovingShadows.setSelection(0);
                    GfxAdvFragment.this.spinnerMovingShadows.setEnabled(false);
                    GfxAdvFragment.this.spinnerMovingShadows.setClickable(false);
                }
                GfxAdvFragment.this.spinnerDetailMode.setEnabled(true);
                GfxAdvFragment.this.spinnerDetailMode.setClickable(true);
            } else {
                if (GfxAdvFragment.this.spinnerRenderingQuality.getSelectedItemPosition() != 0) {
                    GfxAdvFragment.this.spinnerShadows.setEnabled(true);
                    GfxAdvFragment.this.spinnerShadows.setClickable(true);
                    if (GfxAdvFragment.this.spinnerShadows.getSelectedItemPosition() != 0) {
                        GfxAdvFragment.this.spinnerShadowsDistance.setEnabled(true);
                        GfxAdvFragment.this.spinnerShadowsDistance.setClickable(true);
                    }
                }
                GfxAdvFragment.this.spinnerDetailMode.setEnabled(true);
                GfxAdvFragment.this.spinnerDetailMode.setClickable(true);
                GfxAdvFragment.this.spinnerMovingShadows.setSelection(0);
                GfxAdvFragment.this.spinnerMovingShadows.setEnabled(false);
                GfxAdvFragment.this.spinnerMovingShadows.setClickable(false);
            }
            GfxAdvFragment.this.spinnerTextureQuality.setEnabled(true);
            GfxAdvFragment.this.spinnerTextureQuality.setClickable(true);
        }
    }

    static {
        First.seco(-80532497784694L);
        First.seco(-87434510229366L);
        First.seco(-87516114607990L);
        First.seco(-87842532122486L);
        First.seco(-87859711991670L);
        First.seco(-87941316370294L);
        First.seco(-87726568005494L);
        First.seco(-87812467351414L);
        First.seco(-87082322911094L);
        First.seco(-87103797747574L);
        First.seco(-86897639317366L);
        First.seco(-86957768859510L);
        First.seco(-86983538663286L);
        First.seco(-87318546112374L);
        First.seco(-87344315916150L);
        First.seco(-87151042387830L);
        First.seco(-87202581995382L);
        First.seco(-87241236701046L);
        First.seco(-84286299201398L);
        First.seco(-84367903580022L);
        First.seco(-84144565280630L);
        First.seco(-84183219986294L);
        First.seco(-84565472075638L);
        First.seco(-84647076454262L);
        First.seco(-84449507958646L);
        First.seco(-84518227435382L);
        First.seco(-83749428289398L);
        First.seco(-83813852798838L);
        First.seco(-83586219532150L);
        First.seco(-83633464172406L);
        First.seco(-127794317909878L);
        First.seco(-136504511586166L);
        First.seco(-110854966894454L);
        First.seco(-118972455083894L);
        First.seco(-22120942559094L);
        First.seco(-31587050479478L);
        First.seco(-8617565380470L);
    }

    public GfxAdvFragment() {
        Boolean bool = Boolean.FALSE;
        this.isVersion2 = bool;
        this.isVersion3 = bool;
    }

    private void mAntiAliSo() {
        long j;
        String str = First.seco(-189796465794934L);
        String str1 = First.seco(-190161538015094L);
        String str3 = First.seco(-189994034290550L);
        String str4 = First.seco(-190071343701878L);
        String str5 = First.seco(-189293954621302L);
        int selectedItemPosition = this.spinnerAntiAliasing.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            mFileIn(str, First.seco(-189358379130742L));
            mFileIn(str1, First.seco(-189384148934518L));
            mFileIn(str3, First.seco(-189126450896758L));
            mFileIn(str4, First.seco(-189117860962166L));
            j = -189143630765942L;
        } else if (selectedItemPosition == 1) {
            mFileIn(str, First.seco(-189135040831350L));
            mFileIn(str1, First.seco(-189160810635126L));
            mFileIn(str3, First.seco(-189177990504310L));
            mFileIn(str4, First.seco(-189195170373494L));
            j = -189212350242678L;
        } else if (selectedItemPosition == 2) {
            mFileIn(str, First.seco(-189203760308086L));
            mFileIn(str1, First.seco(-189229530111862L));
            mFileIn(str3, First.seco(-189246709981046L));
            mFileIn(str4, First.seco(-189538767757174L));
            j = -189555947626358L;
        } else {
            return;
        }
        mFileIn(str5, First.seco(j));
    }

    private void mLODD() {
        long j;
        String str = First.seco(-186596715159414L);
        int selectedItemPosition = this.spinnerLODDistance.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -186858708164470L;
        } else if (selectedItemPosition == 2) {
            j = -186897362870134L;
        } else if (selectedItemPosition == 3) {
            j = -186901657837430L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }


    private void mSeLod() {
        long j;
        String str = First.seco(-186665434636150L);
        int selectedItemPosition = this.spinnerLODDistance.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -185986829803382L;
        } else if (selectedItemPosition == 2) {
            j = -186004009672566L;
        } else if (selectedItemPosition == 3) {
            j = -186021189541750L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void moveSh() {
        long j;
        String str = First.seco(-175962376134518L);
        int selectedItemPosition = this.spinnerMovingShadows.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            j = -176224369139574L;
        } else if (selectedItemPosition == 1) {
            j = -176245843976054L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void mSetEf() {
        long j;
        String str = First.seco(-186218758037366L);
        int selectedItemPosition = this.spinnerEffectsQuality.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -191866640031606L;
        } else if (selectedItemPosition == 2) {
            j = -191888114868086L;
        } else if (selectedItemPosition == 3) {
            j = -191909589704566L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void mSEff() {
        long j;
        String str = First.seco(-191931064541046L);
        int selectedItemPosition = this.spinnerEffectsQuality.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -191986899115894L;
        } else if (selectedItemPosition == 2) {
            j = -192287546826614L;
        } else if (selectedItemPosition == 3) {
            j = -192278956892022L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void mFRend() {
        long j;
        String str = First.seco(-185754901569398L);
        int selectedItemPosition = this.spinnerRenderingQuality.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            j = -184865843339126L;
        } else if (selectedItemPosition == 1) {
            j = -184887318175606L;
        } else if (selectedItemPosition == 2) {
            j = -184874433273718L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void mRenderQV() {
        long j;
        String str = First.seco(-184895908110198L);
        int selectedItemPosition = this.spinnerRenderingQuality.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            j = -184724109418358L;
        } else if (selectedItemPosition == 1) {
            j = -184749879222134L;
        } else if (selectedItemPosition == 2) {
            j = -184741289287542L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void sResolution() {
        String str;
        String str1 = First.seco(-187279614959478L);
        switch (this.spinnerResolution.getSelectedItemPosition()) {
            case 0:
                str = this.spinResolution;
                break;
            case 1:
                str = First.seco(-188623939723126L);
                break;
            case 2:
                str = First.seco(-188654004494198L);
                break;
            case 3:
                str = First.seco(-188993306910582L);
                break;
            case 4:
                str = First.seco(-189023371681654L);
                break;
            case 5:
                str = First.seco(-189044846518134L);
                break;
            case 6:
                str = First.seco(-189074911289206L);
                break;
            case 7:
                str = First.seco(-189104976060278L);
                break;
            case 8:
                str = First.seco(-188860162924406L);
                break;
            case 9:
                str = First.seco(-188924587433846L);
                break;
            case 10:
                str = First.seco(-188954652204918L);
                break;
            default:
                return;
        }
        mFileIn(str1, str);
    }

    private void valRes1() {
        String str;
        String str1 = First.seco(-188160083255158L);
        switch (this.spinnerResolution.getSelectedItemPosition()) {
            case 0:
                str = this.spinResolution;
                break;
            case 1:
                str = First.seco(-188280342339446L);
                break;
            case 2:
                str = First.seco(-188018349334390L);
                break;
            case 3:
                str = First.seco(-188065593974646L);
                break;
            case 4:
                str = First.seco(-188078478876534L);
                break;
            case 5:
                str = First.seco(-188069888941942L);
                break;
            case 6:
                str = First.seco(-188117133582198L);
                break;
            case 7:
                str = First.seco(-188130018484086L);
                break;
            case 8:
                str = First.seco(-188142903385974L);
                break;
            case 9:
                str = First.seco(-188430666194806L);
                break;
            case 10:
                str = First.seco(-188477910835062L);
                break;
            default:
                return;
        }
        mFileIn(str1, str);
    }

    private void mGFAss1(String str, String str2) {
        File file = new File(askP());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            InputStream open = getActivity().getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void secoS() {
        long j;
        String str = First.seco(-178470637035382L);
        String str2 = First.seco(-180021120229238L);
        String str3 = First.seco(-179879386308470L);
        String str4 = First.seco(-180098429640566L);
        int selectedItemPosition = this.spinnerShadows.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            mFileIn(str, First.seco(-179278090887030L));
            mFileIn(str2, First.seco(-179299565723510L));
            mFileIn(str3, First.seco(-179321040559990L));
            j = -179308155658102L;
        } else if (selectedItemPosition == 1) {
            mFileIn(str, First.seco(-179329630494582L));
            mFileIn(str2, First.seco(-179351105331062L));
            mFileIn(str3, First.seco(-179647458074486L));
            j = -179651753041782L;
        } else if (selectedItemPosition == 2) {
            mFileIn(str, First.seco(-179673227878262L));
            mFileIn(str2, First.seco(-179694702714742L));
            mFileIn(str3, First.seco(-179716177551222L));
            j = -179720472518518L;
        } else if (selectedItemPosition == 3) {
            mFileIn(str, First.seco(-179741947354998L));
            mFileIn(str2, First.seco(-179763422191478L));
            mFileIn(str3, First.seco(-179510019121014L));
            j = -179514314088310L;
        } else if (selectedItemPosition == 4) {
            mFileIn(str, First.seco(-179535788924790L));
            mFileIn(str2, First.seco(-179557263761270L));
            mFileIn(str3, First.seco(-179578738597750L));
            j = -179608803368822L;
        } else if (selectedItemPosition == 5) {
            mFileIn(str, First.seco(-179630278205302L));
            mFileIn(str2, First.seco(-179617393303414L));
            mFileIn(str3, First.seco(-176615211163510L));
            j = -176645275934582L;
        } else {
            return;
        }
        mFileIn(str4, First.seco(j));
    }

    private String askP() {
        return Environment.getExternalStorageDirectory().getPath() + this.strV3;
    }

    private void sShadow() {
        long j;
        String str1 = First.seco(-176232959074166L);
        int selectedItemPosition = this.spinnerShadowsDistance.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            j = -177817802006390L;
        } else if (selectedItemPosition == 1) {
            j = -177581578805110L;
        } else if (selectedItemPosition == 2) {
            j = -177620233510774L;
        } else if (selectedItemPosition == 3) {
            j = -177624528478070L;
        } else if (selectedItemPosition == 4) {
            j = -177688952987510L;
        } else {
            return;
        }
        mFileIn(str1, First.seco(j));
    }

    private String askP2() {
        return Environment.getExternalStorageDirectory().getPath() + this.strV2;
    }

    private void sShaDist() {
        long j;
        String str = First.seco(-177693247954806L);
        int selectedItemPosition = this.spinnerShadowsDistance.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            j = -178071205076854L;
        } else if (selectedItemPosition == 1) {
            j = -178088384946038L;
        } else if (selectedItemPosition == 2) {
            j = -178105564815222L;
        } else if (selectedItemPosition == 3) {
            j = -177847866777462L;
        } else if (selectedItemPosition == 4) {
            j = -177895111417718L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private String askP4() {
        return Environment.getExternalStorageDirectory().getPath() + this.strV5;
    }

    private void sSpinSh() {
        long j;
        String str1 = First.seco(-176666750771062L);
        String str2 = First.seco(-176477772210038L);
        String str3 = First.seco(-176542196719478L);
        String str4 = First.seco(-176941628678006L);
        int selectedItemPosition = this.spinnerShadows.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            mFileIn(str1, First.seco(-176804189724534L));
            mFileIn(str2, First.seco(-176829959528310L));
            mFileIn(str3, First.seco(-176821369593718L));
            j = -176847139397494L;
        } else if (selectedItemPosition == 1) {
            mFileIn(str1, First.seco(-176838549462902L));
            mFileIn(str2, First.seco(-176864319266678L));
            mFileIn(str3, First.seco(-176855729332086L));
            j = -176872909201270L;
        } else if (selectedItemPosition == 2) {
            mFileIn(str1, First.seco(-176074045284214L));
            mFileIn(str2, First.seco(-176065455349622L));
            mFileIn(str3, First.seco(-176091225153398L));
            j = -176108405022582L;
        } else if (selectedItemPosition == 3) {
            mFileIn(str1, First.seco(-176099815087990L));
            mFileIn(str2, First.seco(-176125584891766L));
            mFileIn(str3, First.seco(-176116994957174L));
            j = -176134174826358L;
        } else if (selectedItemPosition == 4) {
            mFileIn(str1, First.seco(-176159944630134L));
            mFileIn(str2, First.seco(-176151354695542L));
            mFileIn(str3, First.seco(-176177124499318L));
            j = -176190009401206L;
        } else if (selectedItemPosition == 5) {
            mFileIn(str1, First.seco(-176181419466614L));
            mFileIn(str2, First.seco(-175932311363446L));
            mFileIn(str3, First.seco(-175923721428854L));
            j = -175970966069110L;
        } else {
            return;
        }
        mFileIn(str4, First.seco(j));
    }

    private String askP6() {
        return Environment.getExternalStorageDirectory().getPath() + this.strV1;
    }

    private void sSound() {
        long j;
        int i;
        int selectedItemPosition = this.spinnerSound.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -187369809272694L;
        } else if (selectedItemPosition == 2) {
            j = -187399874043766L;
        } else if (selectedItemPosition == 3) {
            nameAss(First.seco((!new File(mSaV2()).exists() || !((i = this.val1) == 1 || i == 3 || i == 4 || i == 5 || i == 6)) ? -187219485417334L : -187464298553206L));
            if (this.val1 == 2) {
                j = -187249550188406L;
            } else {
                return;
            }
        } else {
            return;
        }
        nameAss(First.seco(j));
    }

    private String askP5() {
        return Environment.getExternalStorageDirectory().getPath() + this.strV4;
    }

    private void spinSpa() {
        long j;
        String str = First.seco(-184767059091318L);
        int selectedItemPosition = this.spinnerSpawn.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -185243800461174L;
        } else if (selectedItemPosition == 2) {
            j = -185007577259894L;
        } else if (selectedItemPosition == 3) {
            j = -185037642030966L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private String askPV1() {
        return Environment.getExternalStorageDirectory().getPath() + this.strV6;
    }

    private void mSSp() {
        long j;
        String str = First.seco(-185076296736630L);
        int selectedItemPosition = this.spinnerSpawn.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -186549470519158L;
        } else if (selectedItemPosition == 2) {
            j = -186566650388342L;
        } else if (selectedItemPosition == 3) {
            j = -186579535290230L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private String mSaV2() {
        return Environment.getExternalStorageDirectory().getPath() + this.strV7;
    }

    private void sSpinStyle() {
        long j;
        String str = First.seco(-188490795736950L);
        String str1 = First.seco(-188374831619958L);
        int selectedItemPosition = this.spinnerStyles.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            mFileIn(str, First.seco(-185449958891382L));
            j = -185471433727862L;
        } else if (selectedItemPosition == 1) {
            mFileIn(str, First.seco(-185458548825974L));
            j = -185480023662454L;
        } else if (selectedItemPosition == 2) {
            mFileIn(str, First.seco(-185501498498934L));
            j = -185522973335414L;
        } else if (selectedItemPosition == 3) {
            mFileIn(str, First.seco(-185510088433526L));
            j = -185531563270006L;
        } else if (selectedItemPosition == 4) {
            mFileIn(str, First.seco(-185278160199542L));
            j = -185299635036022L;
        } else {
            return;
        }
        mFileIn(str1, First.seco(j));
    }

    private void nameAss(String str) {
        try {
            InputStream open = getActivity().getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(askP5());
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sTQual() {
        long j;
        String str = First.seco(-191570287288182L);
        int selectedItemPosition = this.spinnerTextureQuality.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -191729201078134L;
        } else if (selectedItemPosition == 2) {
            j = -191767855783798L;
        } else if (selectedItemPosition == 3) {
            j = -191806510489462L;
        } else if (selectedItemPosition == 4) {
            j = -191845165195126L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void intShow() {
        this.layoutGraphics.setVisibility(View.VISIBLE);
        this.layoutGraphicsLite.setVisibility(View.GONE);
        this.layoutStyles.setVisibility(View.VISIBLE);
        this.layoutMovingShadows.setVisibility(View.VISIBLE);
        this.layoutTextureQuality.setVisibility(View.VISIBLE);
        this.layoutColorFormat.setVisibility(View.VISIBLE);
        this.layoutDetailQuality.setVisibility(View.VISIBLE);
        this.layoutLightEffects.setVisibility(View.VISIBLE);
        this.layoutSound.setVisibility(View.VISIBLE);
        this.layoutWaterReflection.setVisibility(View.VISIBLE);
    }

    private void selectPosi() {
        if (this.spinnerWaterReflection.getSelectedItemPosition() == 1) {
            if (this.spinnerSound.getSelectedItemPosition() == 1 && this.spinnerGraphics.getSelectedItemPosition() == 7) {
                nameAss(First.seco(-192970446626678L));
            }
            if (this.spinnerSound.getSelectedItemPosition() == 2 && this.spinnerGraphics.getSelectedItemPosition() == 7) {
                nameAss(First.seco(-193000511397750L));
            }
            if (this.spinnerSound.getSelectedItemPosition() == 3 && this.spinnerGraphics.getSelectedItemPosition() == 7) {
                nameAss(First.seco(-193064935907190L));
            }
        }
    }
    private void inputFile() {
        try {
            InputStream open = getActivity().getAssets().open(First.seco(-88078755323766L));
            FileOutputStream fileOutputStream = new FileOutputStream(askPV1());
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void spinCont() {
        Boolean bool;
        int selectedItemPosition = this.spinnerControls.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            bool = Boolean.FALSE;
        } else if (selectedItemPosition == 1) {
            bool = Boolean.TRUE;
        } else {
            return;
        }
        this.isVersion4 = bool;
    }

    private void indexLast(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(askP2());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str3 = new String(bArr);
            if (str3.contains(str)) {
                int indexOf = str3.indexOf(str);
                int lastIndexOf = str3.substring(indexOf, str.length() + indexOf + 6).lastIndexOf(First.seco(-95272825544566L)) + indexOf;
                String substring = str3.substring(indexOf, lastIndexOf);
                String substring2 = str3.substring(0, lastIndexOf);
                String substring3 = str3.substring(lastIndexOf);
                String replace = substring2.replace(substring, str + str2 + First.seco(-95294300381046L));
                FileOutputStream fileOutputStream = new FileOutputStream(askP2());
                fileOutputStream.write((replace + substring3).getBytes());
                fileInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void gameVersionSelect(int i) {
        resetLayout();
        switch (i) {
            case 1:
                this.playVersionRadio.setChecked(true);
                this.chinaVersionRadio.setChecked(false);
                this.southKoreaVersionRadio.setChecked(false);
                this.vietnamVersionRadio.setChecked(false);
                this.liteVersionRadio.setChecked(false);
                this.taiwanVersionRadio.setChecked(false);
                this.strV1 = First.seco(-92734499872630L);
                this.strV2 = First.seco(-94327932739446L);
                this.strV3 = First.seco(-93954270584694L);
                this.strV4 = First.seco(-99550612971382L);
                this.strV5 = First.seco(-98970792386422L);
                this.strV6 = First.seco(-100809038389110L);
                this.strV7 = First.seco(-101002311917430L);
                this.val1 = 1;
                this.layoutFPS.setVisibility(View.VISIBLE);
                this.layoutFpsChina.setVisibility(View.GONE);
                if (Build.VERSION.SDK_INT <= 24) {
                    this.spinnerGraphicsAPI.setSelection(1);
                    this.spinnerGraphicsAPI.setEnabled(false);
                    this.spinnerGraphicsAPI.setClickable(false);
                }
                intShow();
                this.isVersionSelected = Boolean.TRUE;
                if (this.isVersion1.booleanValue() || !this.isVersion2.booleanValue()) {
                    return;
                }
                return;
            case 2:
                this.playVersionRadio.setChecked(false);
                this.chinaVersionRadio.setChecked(true);
                this.southKoreaVersionRadio.setChecked(false);
                this.vietnamVersionRadio.setChecked(false);
                this.liteVersionRadio.setChecked(false);
                this.taiwanVersionRadio.setChecked(false);
                this.strV1 = First.seco(-100443966168950L);
                this.strV2 = First.seco(-97699482066806L);
                this.strV3 = First.seco(-97076711808886L);
                this.strV4 = First.seco(-98884893040502L);
                this.strV5 = First.seco(-98330842259318L);
                this.strV6 = First.seco(-104318026669942L);
                this.strV7 = First.seco(-103781155757942L);
                this.val1 = 2;
                this.layoutFPS.setVisibility(View.GONE);
                this.layoutFpsChina.setVisibility(View.VISIBLE);
                if (Build.VERSION.SDK_INT <= 24) {
                    this.spinnerGraphicsAPI.setSelection(1);
                    this.spinnerGraphicsAPI.setEnabled(false);
                    this.spinnerGraphicsAPI.setClickable(false);
                }
                intShow();
                this.isVersionSelected = Boolean.TRUE;
                if (this.isVersion1.booleanValue() || !this.isVersion2.booleanValue()) {
                    return;
                }
                return;
            case 3:
                this.playVersionRadio.setChecked(false);
                this.chinaVersionRadio.setChecked(false);
                this.southKoreaVersionRadio.setChecked(true);
                this.vietnamVersionRadio.setChecked(false);
                this.liteVersionRadio.setChecked(false);
                this.taiwanVersionRadio.setChecked(false);
                this.strV1 = First.seco(-105447603068790L);
                this.strV2 = First.seco(-104588609609590L);
                this.strV3 = First.seco(-101728161390454L);
                this.strV4 = First.seco(-101298664660854L);
                this.strV5 = First.seco(-101564952633206L);
                this.strV6 = First.seco(-103115435827062L);
                this.strV7 = First.seco(-102539910209398L);
                this.val1 = 3;
                this.layoutFPS.setVisibility(View.VISIBLE);
                this.layoutFpsChina.setVisibility(View.GONE);
                if (Build.VERSION.SDK_INT <= 24) {
                    this.spinnerGraphicsAPI.setSelection(1);
                    this.spinnerGraphicsAPI.setEnabled(false);
                    this.spinnerGraphicsAPI.setClickable(false);
                }
                intShow();
                this.isVersionSelected = Boolean.TRUE;
                if (this.isVersion1.booleanValue() || !this.isVersion2.booleanValue()) {
                    return;
                }
                return;
            case 4:
                this.playVersionRadio.setChecked(false);
                this.chinaVersionRadio.setChecked(false);
                this.southKoreaVersionRadio.setChecked(false);
                this.vietnamVersionRadio.setChecked(true);
                this.liteVersionRadio.setChecked(false);
                this.taiwanVersionRadio.setChecked(false);
                this.strV1 = First.seco(-73656255143798L);
                this.strV2 = First.seco(-73067844624246L);
                this.strV3 = First.seco(-74635507687286L);
                this.strV4 = First.seco(-73926838083446L);
                this.strV5 = First.seco(-71165174112118L);
                this.strV6 = First.seco(-70546698821494L);
                this.strV7 = First.seco(-72165901492086L);
                this.val1 = 4;
                this.layoutFPS.setVisibility(View.VISIBLE);
                this.layoutFpsChina.setVisibility(View.GONE);
                if (Build.VERSION.SDK_INT <= 24) {
                    this.spinnerGraphicsAPI.setSelection(1);
                    this.spinnerGraphicsAPI.setEnabled(false);
                    this.spinnerGraphicsAPI.setClickable(false);
                }
                intShow();
                this.isVersionSelected = Boolean.TRUE;
                if (this.isVersion1.booleanValue() || !this.isVersion2.booleanValue()) {
                    return;
                }
                return;
            case 5:
                this.playVersionRadio.setChecked(false);
                this.chinaVersionRadio.setChecked(false);
                this.southKoreaVersionRadio.setChecked(false);
                this.vietnamVersionRadio.setChecked(false);
                this.taiwanVersionRadio.setChecked(true);
                this.liteVersionRadio.setChecked(false);
                this.strV1 = First.seco(-82211829997430L);
                this.strV2 = First.seco(-81906887319414L);
                this.strV3 = First.seco(-83448780578678L);
                this.strV4 = First.seco(-82473823002486L);
                this.strV5 = First.seco(-79961267134326L);
                this.strV6 = First.seco(-79351381778294L);
                this.strV7 = First.seco(-79570425110390L);
                this.val1 = 5;
                this.layoutFPS.setVisibility(View.VISIBLE);
                this.layoutFpsChina.setVisibility(View.GONE);
                if (Build.VERSION.SDK_INT <= 24) {
                    this.spinnerGraphicsAPI.setSelection(1);
                    this.spinnerGraphicsAPI.setEnabled(false);
                    this.spinnerGraphicsAPI.setClickable(false);
                }
                intShow();
                this.isVersionSelected = Boolean.TRUE;
                if (this.isVersion1.booleanValue() || !this.isVersion2.booleanValue()) {
                    return;
                }
                return;
            case 6:
                this.playVersionRadio.setChecked(false);
                this.chinaVersionRadio.setChecked(false);
                this.southKoreaVersionRadio.setChecked(false);
                this.vietnamVersionRadio.setChecked(false);
                this.taiwanVersionRadio.setChecked(false);
                this.liteVersionRadio.setChecked(true);
                this.strV1 = First.seco(-74940450365302L);
                this.strV4 = First.seco(-76585422839670L);
                this.strV5 = First.seco(-76813056106358L);
                this.strV6 = First.seco(-76194580815734L);
                this.val1 = 6;
                this.layoutFPS.setVisibility(View.VISIBLE);
                this.layoutFpsChina.setVisibility(View.GONE);
                this.isVersionSelected = Boolean.TRUE;
                this.layoutGraphics.setVisibility(View.GONE);
                this.layoutGraphicsLite.setVisibility(View.VISIBLE);
                this.spinnerGraphicsAPI.setEnabled(true);
                this.spinnerGraphicsAPI.setClickable(true);
                this.layoutStyles.setVisibility(View.GONE);
                this.layoutMovingShadows.setVisibility(View.GONE);
                this.layoutTextureQuality.setVisibility(View.GONE);
                this.layoutColorFormat.setVisibility(View.GONE);
                this.layoutDetailQuality.setVisibility(View.GONE);
                this.layoutLightEffects.setVisibility(View.GONE);
                this.layoutSound.setVisibility(View.GONE);
                this.layoutWaterReflection.setVisibility(View.GONE);
                return;
            default:
                return;
        }
    }

    private void mFileIn(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(askP6());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str3 = new String(bArr);
            String str4 = First.seco(-89435964989302L) + str;
            if (str3.contains(str4)) {
                int indexOf = str3.indexOf(str4);
                int lastIndexOf = str3.substring(indexOf, indexOf + 80).lastIndexOf(First.seco(-89470324727670L)) + indexOf;
                String substring = str3.substring(indexOf, lastIndexOf);
                String substring2 = str3.substring(0, lastIndexOf);
                String substring3 = str3.substring(lastIndexOf);
                String replace = substring2.replace(substring, str4 + str2 + First.seco(-95247055740790L));
                FileOutputStream fileOutputStream = new FileOutputStream(askP6());
                fileOutputStream.write((replace + substring3).getBytes());
                fileInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setButtonOnApplySettings() {
        this.applySettingsButton.setBackgroundResource(R.drawable.btn_main_adv);
    }

    private void mFApl(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(askP6());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str2 = new String(bArr);
            if (str2.contains(First.seco(-88383698001782L))) {
                String substring = str2.substring(str2.indexOf(First.seco(-88422352707446L)), str2.indexOf(First.seco(-88495367151478L)));
                substring.trim();
                FileOutputStream fileOutputStream = new FileOutputStream(askP6());
                fileOutputStream.write((str + First.seco(-88345043296118L) + substring).getBytes());
                fileInputStream.close();
                fileOutputStream.close();
            } else {
                str2.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mFAsk(str);
    }




    private void mIndSeco(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(askP6());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str2 = new String(bArr);
            if (str2.contains(First.seco(-89934181195638L))) {
                String substring = str2.substring(str2.indexOf(First.seco(-89938476162934L)), str2.indexOf(First.seco(-89221216624502L)));
                substring.trim();
                FileOutputStream fileOutputStream = new FileOutputStream(askP6());
                fileOutputStream.write((str + First.seco(-89070892769142L) + substring).getBytes());
                fileInputStream.close();
                fileOutputStream.close();
            } else {
                str2.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mFAsk6(str);
    }

    private void mFAsk(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(askP6());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str2 = new String(bArr);
            if (str2.contains(First.seco(-88370813099894L))) {
                String substring = str2.substring(str2.indexOf(First.seco(-89749497601910L)));
                substring.trim();
                String str6 = First.seco(-89856871784310L);
                if (substring.contains(str6)) {
                    int indexOf = substring.indexOf(str6);
                    String substring2 = substring.substring(indexOf, substring.substring(indexOf, indexOf + 120).lastIndexOf(First.seco(-90140339625846L)) + indexOf);
                    if (substring2.contains(str6)) {
                        this.spinResolution = substring2.replace(str6, First.seco(-90144634593142L)).replaceAll(First.seco(-89899821457270L), First.seco(-89891231522678L)).replaceAll(First.seco(-89886936555382L), First.seco(-89912706359158L));
                    }
                }
                FileOutputStream fileOutputStream = new FileOutputStream(askP6());
                fileOutputStream.write((str + First.seco(-89908411391862L) + substring).getBytes());
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            str2.trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mFAsk6(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(askP6());
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str2 = new String(bArr);
            if (str2.contains(First.seco(-89062302834550L))) {
                String substring = str2.substring(str2.indexOf(First.seco(-89100957540214L)));
                substring.trim();
                String str4 = First.seco(-89483209629558L);
                if (substring.contains(str4)) {
                    int indexOf = substring.indexOf(str4);
                    String substring2 = substring.substring(indexOf, substring.substring(indexOf, indexOf + 120).lastIndexOf(First.seco(-89367245512566L)) + indexOf);
                    if (substring2.contains(str4)) {
                        this.spinResolution = substring2.replace(str4, First.seco(-89371540479862L)).replaceAll(First.seco(-89401605250934L), First.seco(-89393015316342L)).replaceAll(First.seco(-89388720349046L), First.seco(-89414490152822L));
                    }
                }
                FileOutputStream fileOutputStream = new FileOutputStream(askP6());
                fileOutputStream.write((str + First.seco(-89410195185526L) + substring).getBytes());
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            str2.trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setupGfx() {
        int i = this.val1;
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
            spinCont();
            mSGR();
            int i2 = this.val1;
            if (i2 == 1 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6) {
                mInVal();
            } else {
                mFPSC();
            }
            sResolution();
            secoS();
            sShadow();
            moveSh();
            mSecoF();
            sSpinStyle();
            mFRend();
            mSeMod1();
            sTQual();
            spinSpa();
            mLODD();
            mSeFol1();
            mSetEf();
            mSeCoFt();
            sSound();
            selectPosi();
        } else if (i == 7) {
            spinCont();
            mGf();
            mInVal();
            valRes1();
            sSpinSh();
            sShaDist();
            mAntiAliSo();
            mRenderQV();
            mSSp();
            mSeLod();
            mSelFol2();
            mSEff();
        }
    }

    private void mSeCoFt() {
        long j;
        String str = First.seco(-191849460162422L);
        int selectedItemPosition = this.spinnerColorFormat.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -193202374860662L;
        } else if (selectedItemPosition == 2) {
            j = -193206669827958L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void mSeMod1() {
        long j;
        String str = First.seco(-192240302186358L);
        int selectedItemPosition = this.spinnerDetailMode.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -191505862778742L;
        } else if (selectedItemPosition == 2) {
            j = -191527337615222L;
        } else if (selectedItemPosition == 3) {
            j = -191548812451702L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void mSeFol1() {
        long j;
        String str = First.seco(-186038369410934L);
        int selectedItemPosition = this.spinnerFoliage.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -186231642939254L;
        } else if (selectedItemPosition == 2) {
            j = -186270297644918L;
        } else if (selectedItemPosition == 3) {
            j = -186308952350582L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void mSelFol2() {
        long j;
        String str = First.seco(-186347607056246L);
        int selectedItemPosition = this.spinnerFoliage.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            j = -186167218429814L;
        } else if (selectedItemPosition == 2) {
            j = -186184398298998L;
        } else if (selectedItemPosition == 3) {
            j = -186201578168182L;
        } else {
            return;
        }
        mFileIn(str, First.seco(j));
    }

    private void mInVal() {
        long j;
        String str = First.seco(-189547357691766L);
        String str2 = First.seco(-189633257037686L);
        String str3 = First.seco(-189444278476662L);
        String str4 = First.seco(-190904567357302L);
        String str5 = First.seco(-191020531474294L);
        String str6 = First.seco(-190831552913270L);
        String str7 = First.seco(-191183740231542L);
        String str8 = First.seco(-191269639577462L);
        String str9 = First.seco(-191080661016438L);
        String str10 = First.seco(-191162265395062L);
        String str11 = First.seco(-190238847426422L);
        String str12 = First.seco(-190689818992502L);
        String str13 = First.seco(-190582444810102L);
        int selectedItemPosition = this.spinnerFps.getSelectedItemPosition();
        if (selectedItemPosition == 1) {
            int i = this.val1;
            if (i == 1 || i == 3 || i == 4 || i == 5 || i == 6) {
                indexLast(str, First.seco(-90977858248566L));
                indexLast(str2, First.seco(-90724455178102L));
                indexLast(str3, First.seco(-90711570276214L));
                indexLast(str4, First.seco(-90733045112694L));
                indexLast(str5, First.seco(-90754519949174L));
                indexLast(str6, First.seco(-90775994785654L));
                mFileIn(str10, First.seco(-90763109883766L));
                mFileIn(str11, First.seco(-90810354524022L));
                mFileIn(str12, First.seco(-90823239425910L));
                mFileIn(str13, First.seco(-90836124327798L));
                if (!this.isVersion4.booleanValue()) {
                    j = -91123887136630L;
                } else {
                    return;
                }
            } else if (i == 7) {
                mFileIn(str7, First.seco(-91171131776886L));
                mFileIn(str8, First.seco(-91158246874998L));
                mFileIn(str9, First.seco(-91179721711478L));
                if (!this.isVersion4.booleanValue()) {
                    j = -91201196547958L;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (selectedItemPosition == 2) {
            int i2 = this.val1;
            if (i2 == 1 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6) {
                indexLast(str, First.seco(-91222671384438L));
                indexLast(str2, First.seco(-91209786482550L));
                indexLast(str3, First.seco(-91231261319030L));
                indexLast(str4, First.seco(-91252736155510L));
                indexLast(str5, First.seco(-90999333085046L));
                indexLast(str6, First.seco(-90986448183158L));
                mFileIn(str10, First.seco(-91007923019638L));
                mFileIn(str11, First.seco(-91020807921526L));
                mFileIn(str12, First.seco(-91068052561782L));
                mFileIn(str13, First.seco(-91080937463670L));
                if (!this.isVersion4.booleanValue()) {
                    j = -91093822365558L;
                } else {
                    return;
                }
            } else if (i2 == 7) {
                mFileIn(str7, First.seco(-91106707267446L));
                mFileIn(str8, First.seco(-90303548383094L));
                mFileIn(str9, First.seco(-90325023219574L));
                if (!this.isVersion4.booleanValue()) {
                    j = -90346498056054L;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (selectedItemPosition == 3) {
            int i3 = this.val1;
            if (i3 == 1 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
                indexLast(str, First.seco(-90333613154166L));
                indexLast(str2, First.seco(-90355087990646L));
                indexLast(str3, First.seco(-90376562827126L));
                indexLast(str4, First.seco(-90398037663606L));
                indexLast(str5, First.seco(-90385152761718L));
                indexLast(str6, First.seco(-90406627598198L));
                mFileIn(str10, First.seco(-90428102434678L));
                mFileIn(str11, First.seco(-90166109429622L));
                mFileIn(str12, First.seco(-90178994331510L));
                mFileIn(str13, First.seco(-90226238971766L));
                if (!this.isVersion4.booleanValue()) {
                    j = -90239123873654L;
                } else {
                    return;
                }
            } else if (i3 == 7) {
                mFileIn(str7, First.seco(-90252008775542L));
                mFileIn(str8, First.seco(-90273483612022L));
                mFileIn(str9, First.seco(-90294958448502L));
                if (!this.isVersion4.booleanValue()) {
                    j = -90282073546614L;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (selectedItemPosition == 4) {
            int i4 = this.val1;
            if (i4 == 1 || i4 == 3 || i4 == 4 || i4 == 5 || i4 == 6) {
                indexLast(str, First.seco(-90578426290038L));
                indexLast(str2, First.seco(-90599901126518L));
                indexLast(str3, First.seco(-90621375962998L));
                indexLast(str4, First.seco(-90608491061110L));
                indexLast(str5, First.seco(-90629965897590L));
                indexLast(str6, First.seco(-90651440734070L));
                mFileIn(str10, First.seco(-90672915570550L));
                mFileIn(str11, First.seco(-90660030668662L));
                mFileIn(str12, First.seco(-90681505505142L));
                mFileIn(str13, First.seco(-90702980341622L));
                if (!this.isVersion4.booleanValue()) {
                    j = -90449577271158L;
                } else {
                    return;
                }
            } else if (i4 == 7) {
                mFileIn(str7, First.seco(-90462462173046L));
                mFileIn(str8, First.seco(-90483937009526L));
                mFileIn(str9, First.seco(-90471052107638L));
                if (!this.isVersion4.booleanValue()) {
                    j = -90492526944118L;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            return;
        }
        mGFAss1(First.seco(j), askP4());
    }

    private void mFPSC() {
        long j;
        String str = First.seco(-90514001780598L);
        String str2 = First.seco(-91974290661238L);
        String str3 = First.seco(-92060190007158L);
        String str4 = First.seco(-91871211446134L);
        String str5 = First.seco(-92227693731702L);
        String str6 = First.seco(-92313593077622L);
        String str7 = First.seco(-92150384320374L);
        String str8 = First.seco(-91467484520310L);
        String str9 = First.seco(-91368700272502L);
        String str10 = First.seco(-91536203997046L);
        int selectedItemPosition = this.spinnerFpsChina.getSelectedItemPosition();
        if (selectedItemPosition != 1) {
            if (selectedItemPosition != 2) {
                if (selectedItemPosition != 3) {
                    if (selectedItemPosition != 4) {
                        if (selectedItemPosition == 5 && this.val1 == 2) {
                            mFileIn(str7, First.seco(-88005740879734L));
                            mFileIn(str8, First.seco(-88027215716214L));
                            mFileIn(str9, First.seco(-88014330814326L));
                            mFileIn(str10, First.seco(-88035805650806L));
                            if (!this.isVersion4.booleanValue()) {
                                j = -88057280487286L;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (this.val1 == 2) {
                        indexLast(str, First.seco(-88147474800502L));
                        indexLast(str2, First.seco(-88134589898614L));
                        indexLast(str3, First.seco(-88156064735094L));
                        indexLast(str4, First.seco(-88177539571574L));
                        indexLast(str5, First.seco(-88199014408054L));
                        indexLast(str6, First.seco(-88186129506166L));
                        mFileIn(str7, First.seco(-88207604342646L));
                        mFileIn(str8, First.seco(-88229079179126L));
                        mFileIn(str9, First.seco(-87975676108662L));
                        mFileIn(str10, First.seco(-87962791206774L));
                        if (!this.isVersion4.booleanValue()) {
                            j = -87984266043254L;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (this.val1 == 2) {
                    indexLast(str, First.seco(-89049417932662L));
                    indexLast(str2, First.seco(-88796014862198L));
                    indexLast(str3, First.seco(-88817489698678L));
                    indexLast(str4, First.seco(-88804604796790L));
                    indexLast(str5, First.seco(-88826079633270L));
                    indexLast(str6, First.seco(-88847554469750L));
                    mFileIn(str7, First.seco(-88869029306230L));
                    mFileIn(str8, First.seco(-88881914208118L));
                    mFileIn(str9, First.seco(-88894799110006L));
                    mFileIn(str10, First.seco(-88907684011894L));
                    if (!this.isVersion4.booleanValue()) {
                        j = -88130294931318L;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (this.val1 == 2) {
                indexLast(str, First.seco(-88611331268470L));
                indexLast(str2, First.seco(-88598446366582L));
                indexLast(str3, First.seco(-88619921203062L));
                indexLast(str4, First.seco(-88641396039542L));
                indexLast(str5, First.seco(-88937748782966L));
                indexLast(str6, First.seco(-88924863881078L));
                mFileIn(str7, First.seco(-88946338717558L));
                mFileIn(str8, First.seco(-88959223619446L));
                mFileIn(str9, First.seco(-89006468259702L));
                mFileIn(str10, First.seco(-89019353161590L));
                if (!this.isVersion4.booleanValue()) {
                    j = -89032238063478L;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (this.val1 == 2) {
            indexLast(str, First.seco(-88688640679798L));
            indexLast(str2, First.seco(-88710115516278L));
            indexLast(str3, First.seco(-88731590352758L));
            indexLast(str4, First.seco(-88718705450870L));
            indexLast(str5, First.seco(-88740180287350L));
            indexLast(str6, First.seco(-88761655123830L));
            mFileIn(str7, First.seco(-88783129960310L));
            mFileIn(str8, First.seco(-88521136955254L));
            mFileIn(str9, First.seco(-88534021857142L));
            mFileIn(str10, First.seco(-88546906759030L));
            if (!this.isVersion4.booleanValue()) {
                j = -88594151399286L;
            } else {
                return;
            }
        } else {
            return;
        }
        mGFAss1(First.seco(j), askP4());
    }

    private void mSGR() {
        long j;
        int selectedItemPosition = this.spinnerGraphics.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            int i = this.val1;
            if (i == 1 || i == 3 || i == 4 || i == 5 || i == 6) {
                j = -228730344333174L;
            } else if (i == 2) {
                j = -237672466243446L;
            } else {
                return;
            }
        } else if (selectedItemPosition == 1) {
            int i2 = this.val1;
            if (i2 == 1 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6) {
                j = -212014331617142L;
            } else if (i2 == 2) {
                j = -220999403200374L;
            } else {
                return;
            }
        } else if (selectedItemPosition == 2) {
            int i3 = this.val1;
            if (i3 == 1 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
                j = -264893968965494L;
            } else if (i3 == 2) {
                j = -273329284734838L;
            } else {
                return;
            }
        } else if (selectedItemPosition == 3) {
            int i4 = this.val1;
            if (i4 == 1 || i4 == 3 || i4 == 4 || i4 == 5 || i4 == 6) {
                j = -246855106322294L;
            } else if (i4 == 2) {
                j = -256072106139510L;
            } else {
                return;
            }
        } else if (selectedItemPosition == 4) {
            int i5 = this.val1;
            if (i5 == 1 || i5 == 3 || i5 == 4 || i5 == 5) {
                j = -159220593614710L;
            } else if (i5 == 2) {
                j = -167338081804150L;
            } else if (i5 == 6) {
                j = -140855313457014L;
            } else {
                return;
            }
        } else {
            return;
        }
        mFApl(First.seco(j));
    }

    private void mGf() {
        long j;
        int selectedItemPosition = this.spinnerGraphicsLite.getSelectedItemPosition();
        if (selectedItemPosition != 0) {
            if (selectedItemPosition != 1) {
                if (selectedItemPosition == 2 && this.val1 == 7) {
                    j = -205838168645494L;
                } else {
                    return;
                }
            } else if (this.val1 == 7) {
                j = -194173037469558L;
            } else {
                return;
            }
        } else if (this.val1 == 7) {
            j = -150072313274230L;
        } else {
            return;
        }
        mIndSeco(First.seco(j));
    }

    private void mSecoF() {
        long j;
        String str = First.seco(-193095000678262L);
        String str2 = First.seco(-193245324533622L);
        String str3 = First.seco(-192674093883254L);
        String str4 = First.seco(-192523770027894L);
        String str5 = First.seco(-192897432182646L);
        int selectedItemPosition = this.spinnerAntiAliasing.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            mFileIn(str, First.seco(-192790058000246L));
            mFileIn(str2, First.seco(-192777173098358L));
            mFileIn(str3, First.seco(-192815827804022L));
            mFileIn(str4, First.seco(-189813645664118L));
            j = -189835120500598L;
        } else if (selectedItemPosition == 1) {
            mFileIn(str, First.seco(-189822235598710L));
            mFileIn(str2, First.seco(-189843710435190L));
            mFileIn(str3, First.seco(-189882365140854L));
            mFileIn(str4, First.seco(-189921019846518L));
            j = -189925314813814L;
        } else if (selectedItemPosition == 2) {
            mFileIn(str, First.seco(-189671911743350L));
            mFileIn(str2, First.seco(-189693386579830L));
            mFileIn(str3, First.seco(-189732041285494L));
            mFileIn(str4, First.seco(-189736336252790L));
            j = -189774990958454L;
        } else {
            return;
        }
        mFileIn(str5, First.seco(j));
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_gfx_advanced, viewGroup, false);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.preferences = getActivity().getSharedPreferences(First.seco(-230937957523318L), 0);
        Boolean bool = Boolean.FALSE;
        this.isVersionSelected = bool;
        this.isVersion4 = bool;
        this.isVersion1 = bool;
        if (this.preferences.contains(First.seco(-230989497130870L))) {
            this.isVersion1 = Boolean.valueOf(this.preferences.getBoolean(First.seco(-231006677000054L), false));
        }
        this.applySettingsButton = (Button)view.findViewById(R.id.accept);
        this.applySettingsButton.setEnabled(false);
        this.layoutGraphics = (LinearLayout) view.findViewById(R.id.layout_graphics);
        this.layoutGraphicsLite = (LinearLayout) view.findViewById(R.id.layout_graphics_lite);
        this.layoutFPS = (LinearLayout) view.findViewById(R.id.layout_fps);
        this.layoutFpsChina = (LinearLayout) view.findViewById(R.id.layout_fps_china);
        this.layoutAntiAliasing = (LinearLayout) view.findViewById(R.id.layoutAntiAliasing);
        this.layoutStyles = (LinearLayout) view.findViewById(R.id.layoutStyles);
        this.layoutMovingShadows = (LinearLayout) view.findViewById(R.id.layoutMovingShadows);
        this.layoutTextureQuality = (LinearLayout) view.findViewById(R.id.layoutTextureQuality);
        this.layoutColorFormat = (LinearLayout) view.findViewById(R.id.layoutColorFormat);
        this.layoutDetailQuality = (LinearLayout) view.findViewById(R.id.layoutDetailMode);
        this.layoutLightEffects = (LinearLayout) view.findViewById(R.id.layoutLightEffects);
        this.layoutSound = (LinearLayout) view.findViewById(R.id.layoutSoundQuality);
        this.layoutWaterReflection = (LinearLayout) view.findViewById(R.id.layoutWaterReflection);
        this.spinnerResolution = (Spinner) view.findViewById(R.id.spinnerResolution);
        this.spinnerGraphicsLite = (Spinner) view.findViewById(R.id.spinnerGraphicsLite);
        this.spinnerFps = (Spinner) view.findViewById(R.id.spinnerFps);
        this.spinnerFpsChina = (Spinner) view.findViewById(R.id.spinnerFpsChina);
        this.spinnerAntiAliasing = (Spinner) view.findViewById(R.id.spinnerMSAA);
        this.spinnerLightEffects = (Spinner) view.findViewById(R.id.spinnerBl);
        this.spinnerRenderingQuality = (Spinner) view.findViewById(R.id.spinnerRe);
        this.spinnerDetailMode = (Spinner) view.findViewById(R.id.spinnerDetailMode);
        this.spinnerTextureQuality = (Spinner) view.findViewById(R.id.spinnerTextureQuality);
        this.spinnerSpawn = (Spinner) view.findViewById(R.id.spinnerImprovementEffects);
        this.spinnerLODDistance = (Spinner) view.findViewById(R.id.spinnerObjectsDistance);
        this.spinnerFoliage = (Spinner) view.findViewById(R.id.spinnerFoliageDistance);
        this.spinnerEffectsQuality = (Spinner) view.findViewById(R.id.spinnerEffectsQuality);
        this.spinnerColorFormat = (Spinner) view.findViewById(R.id.spinnerColorFormat);
        this.spinnerWaterReflection = (Spinner) view.findViewById(R.id.spinnerWater);
        this.spinnerShadows = (Spinner) view.findViewById(R.id.spinnerShadows);
        this.spinnerShadowsDistance = (Spinner) view.findViewById(R.id.spinnerShadowsDistance);
        this.spinnerMovingShadows = (Spinner) view.findViewById(R.id.spinnerMovingShadows);
        this.spinnerGraphics = (Spinner) view.findViewById(R.id.spinnerGraphics);
        this.spinnerStyles = (Spinner) view.findViewById(R.id.spinnerStyles);
        this.spinnerControls = (Spinner) view.findViewById(R.id.spinnerControls);
        this.spinnerGPU = (Spinner) view.findViewById(R.id.spinnerGPU);
        this.spinnerGraphicsAPI = (Spinner) view.findViewById(R.id.spinnerGraphicsAPI);
        this.spinnerSound = (Spinner) view.findViewById(R.id.spinnerSound);
        this.playVersionRadio = (RadioButton) view.findViewById(R.id.google_play);
        this.chinaVersionRadio = (RadioButton) view.findViewById(R.id.china);
        this.southKoreaVersionRadio = (RadioButton) view.findViewById(R.id.kr);
        this.vietnamVersionRadio = (RadioButton) view.findViewById(R.id.vn);
        this.taiwanVersionRadio = (RadioButton) view.findViewById(R.id.tw);
        this.liteVersionRadio = (RadioButton) view.findViewById(R.id.lite);
        this.lrUselessVersion = view.findViewById(R.id.lrUselessVersion);
        this.listVersionDown = view.findViewById(R.id.listVersionDown);
        this.expandableUselessVersion = view.findViewById(R.id.expandableUselessVersion);
        this.lrUselessVersion.setOnClickListener(this);

        setSpin(this.spinnerResolution, R.array.resolution_adv);
        setSpin(this.spinnerGraphics, R.array.presets_adv);
        setSpin(this.spinnerGraphicsLite, R.array.presets_lite);
        setSpin(this.spinnerFps, R.array.fps_adv);
        setSpin(this.spinnerFpsChina, R.array.fps_china);
        setSpin(this.spinnerLightEffects, R.array.bl);
        setSpin(spinnerAntiAliasing, R.array.aa);
        setSpin(this.spinnerStyles, R.array.styles);
        setSpin(spinnerRenderingQuality, R.array.re);
        setSpin(this.spinnerShadows, R.array.shadows_adv);
        setSpin(this.spinnerShadowsDistance, R.array.shadows_distance);
        setSpin(this.spinnerResolution, R.array.resolution_adv);
        setSpin(this.spinnerMovingShadows, R.array.moving_shadows);
        setSpin(this.spinnerTextureQuality, R.array.texture_quality);
        setSpin(this.spinnerEffectsQuality, R.array.effects_quality);
        setSpin(spinnerSpawn, R.array.improvement_effects);
        setSpin(spinnerLODDistance, R.array.object_lod_distance);
        setSpin(spinnerFoliage, R.array.foliage_lod_distance);
        setSpin(this.spinnerColorFormat, R.array.color_format);
        setSpin(this.spinnerDetailMode, R.array.detail_mode);
        setSpin(this.spinnerGraphicsAPI, R.array.graphics_api);
        setSpin(this.spinnerGPU, R.array.gpu);
        setSpin(this.spinnerSound, R.array.sound_quality);
        setSpin(spinnerWaterReflection, R.array.water_reflection);
        setSpin(this.spinnerControls, R.array.controls);


        this.applySettingsButton.setEnabled(true);
        this.applySettingsButton.setOnClickListener(new onApplySettingsClick());
        this.spinnerGraphics.setOnItemSelectedListener(new onGraphicsSelectorChange());
        this.spinnerRenderingQuality.setOnItemSelectedListener(new onRenderingQualityChange());
        this.spinnerShadows.setOnItemSelectedListener(new onShadowsChange());
        this.playVersionRadio.setOnClickListener(new onPlayVersionSelect());
        this.chinaVersionRadio.setOnClickListener(new onChinaVersionSelect());
        this.southKoreaVersionRadio.setOnClickListener(new onSouthKoreaVersionSelect());
        this.vietnamVersionRadio.setOnClickListener(new onVietnamVersionSelect());
        this.taiwanVersionRadio.setOnClickListener(new onTaiwanVersionSelect());
        this.liteVersionRadio.setOnClickListener(new onLiteVersionSelect());

        setPreferenceValues();
        inputFile();
    }

    public void editPreferenceValues() {
        boolean z;
        String str;
        try {
            SharedPreferences.Editor edit = this.preferences.edit();
            edit.putInt(First.seco(-95332955086710L), this.spinnerResolution.getSelectedItemPosition());
            edit.putInt(First.seco(-95152566460278L), this.spinnerGraphicsLite.getSelectedItemPosition());
            edit.putInt(First.seco(-95238465806198L), this.spinnerGraphics.getSelectedItemPosition());
            edit.putInt(First.seco(-95573473255286L), this.spinnerFps.getSelectedItemPosition());
            edit.putInt(First.seco(-95629307830134L), this.spinnerFpsChina.getSelectedItemPosition());
            edit.putInt(First.seco(-95423149399926L), this.spinnerAntiAliasing.getSelectedItemPosition());
            edit.putInt(First.seco(-95474689007478L), this.spinnerLightEffects.getSelectedItemPosition());
            edit.putInt(First.seco(-94710184828790L), this.spinnerRenderingQuality.getSelectedItemPosition());
            edit.putInt(First.seco(-94735954632566L), this.spinnerDetailMode.getSelectedItemPosition());
            edit.putInt(First.seco(-94796084174710L), this.spinnerTextureQuality.getSelectedItemPosition());
            edit.putInt(First.seco(-94821853978486L), this.spinnerSpawn.getSelectedItemPosition());
            edit.putInt(First.seco(-94594220711798L), this.spinnerLODDistance.getSelectedItemPosition());
            edit.putInt(First.seco(-94645760319350L), this.spinnerFoliage.getSelectedItemPosition());
            edit.putInt(First.seco(-94993652670326L), this.spinnerEffectsQuality.getSelectedItemPosition());
            edit.putInt(First.seco(-95062372147062L), this.spinnerColorFormat.getSelectedItemPosition());
            edit.putInt(First.seco(-94834738880374L), this.spinnerStyles.getSelectedItemPosition());
            edit.putInt(First.seco(-94912048291702L), this.spinnerShadows.getSelectedItemPosition());
            edit.putInt(First.seco(-96359452270454L), this.spinnerShadowsDistance.getSelectedItemPosition());
            edit.putInt(First.seco(-96432466714486L), this.spinnerMovingShadows.getSelectedItemPosition());
            edit.putInt(First.seco(-96273552924534L), this.spinnerControls.getSelectedItemPosition());
            edit.putInt(First.seco(-96342272401270L), this.spinnerGPU.getSelectedItemPosition());
            edit.putInt(First.seco(-96638625144694L), this.spinnerGraphicsAPI.getSelectedItemPosition());
            edit.putInt(First.seco(-96737409392502L), this.spinnerSound.getSelectedItemPosition());
            edit.putInt(First.seco(-96509776125814L), this.spinnerWaterReflection.getSelectedItemPosition());
            if (this.isVersion1.booleanValue()) {
                str = First.seco(-96557020766070L);
                z = true;
            } else {
                str = First.seco(-96574200635254L);
                z = false;
            }
            edit.putBoolean(str, z);
            edit.apply();
        } catch (Exception unused) {
        }
    }

    public void setPreferenceValues() {
        if (this.preferences.contains(First.seco(-96591380504438L))) {
            this.spinnerResolution.setSelection(this.preferences.getInt(First.seco(-95861236064118L), 0));
            this.spinnerGraphicsLite.setSelection(this.preferences.getInt(First.seco(-95693732339574L), 0));
            this.spinnerGraphics.setSelection(this.preferences.getInt(First.seco(-95779631685494L), 0));
            this.spinnerFps.setSelection(this.preferences.getInt(First.seco(-96148998872950L), 0));
            this.spinnerFpsChina.setSelection(this.preferences.getInt(First.seco(-96204833447798L), 0));
            this.spinnerAntiAliasing.setSelection(this.preferences.getInt(First.seco(-95998675017590L), 0));
            this.spinnerLightEffects.setSelection(this.preferences.getInt(First.seco(-96050214625142L), 0));
            this.spinnerRenderingQuality.setSelection(this.preferences.getInt(First.seco(-93052327452534L), 0));
            this.spinnerDetailMode.setSelection(this.preferences.getInt(First.seco(-93112456994678L), 0));
            this.spinnerTextureQuality.setSelection(this.preferences.getInt(First.seco(-93138226798454L), 0));
            this.spinnerSpawn.setSelection(this.preferences.getInt(First.seco(-92923478433654L), 0));
            this.spinnerLODDistance.setSelection(this.preferences.getInt(First.seco(-92970723073910L), 0));
            this.spinnerFoliage.setSelection(this.preferences.getInt(First.seco(-93022262681462L), 0));
            this.spinnerEffectsQuality.setSelection(this.preferences.getInt(First.seco(-93370155032438L), 0));
            this.spinnerColorFormat.setSelection(this.preferences.getInt(First.seco(-93438874509174L), 0));
            this.spinnerShadows.setSelection(this.preferences.getInt(First.seco(-93211241242486L), 0));
            this.spinnerShadowsDistance.setSelection(this.preferences.getInt(First.seco(-93284255686518L), 0));
            this.spinnerMovingShadows.setSelection(this.preferences.getInt(First.seco(-92532636409718L), 0));
            this.spinnerStyles.setSelection(this.preferences.getInt(First.seco(-92373722619766L), 0));
            this.spinnerControls.setSelection(this.preferences.getInt(First.seco(-92416672292726L), 0));
            this.spinnerGPU.setSelection(this.preferences.getInt(First.seco(-92485391769462L), 0));
            this.spinnerGraphicsAPI.setSelection(this.preferences.getInt(First.seco(-92816104251254L), 0));
            this.spinnerSound.setSelection(this.preferences.getInt(First.seco(-92880528760694L), 0));
            this.spinnerWaterReflection.setSelection(this.preferences.getInt(First.seco(-92652895494006L), 0));
        }
    }

    @SuppressLint("WrongConstant")
    public void resetLayout() {
        this.spinnerGraphics.setEnabled(true);
        this.spinnerGraphics.setClickable(true);
        this.spinnerGraphicsAPI.setEnabled(true);
        this.spinnerGraphicsAPI.setClickable(true);
        this.layoutAntiAliasing.setVisibility(View.VISIBLE);
        this.layoutStyles.setVisibility(View.VISIBLE);
        this.layoutMovingShadows.setVisibility(View.VISIBLE);
        this.layoutTextureQuality.setVisibility(View.VISIBLE);
        this.spinnerColorFormat.setVisibility(View.VISIBLE);
        this.spinnerDetailMode.setVisibility(View.VISIBLE);
        this.layoutLightEffects.setVisibility(View.VISIBLE);
        this.spinnerSound.setVisibility(View.VISIBLE);
        this.layoutWaterReflection.setVisibility(View.VISIBLE);
        this.spinnerControls.setVisibility(View.VISIBLE);
        this.layoutGraphics.setVisibility(View.VISIBLE);
        this.layoutGraphicsLite.setVisibility(View.GONE);
        this.layoutColorFormat.setVisibility(View.VISIBLE);
        this.layoutDetailQuality.setVisibility(View.VISIBLE);
        this.layoutFPS.setVisibility(View.VISIBLE);
        this.layoutFpsChina.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void setSpin(Spinner spinner, int i) {
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(getActivity(), i, R.layout.spinner_item);
        createFromResource.setDropDownViewResource(R.layout.layout_spinner_style);
        spinner.setAdapter((SpinnerAdapter) createFromResource);
        spinner.setPopupBackgroundResource(R.drawable.spinner_background);
    }

    public void DialogLayoutAccept(View view) {
         dialogAccept = new Dialog(getActivity());
        dialogAccept.setContentView(R.layout.dialog_gfx_adv);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) dialogAccept.findViewById(R.id.lottieAcceptAdv);
        final TextView textView = (TextView) dialogAccept.findViewById(R.id.tvAccept);
        textView.setText(R.string.accept_run);
        lottieAnimationView.playAnimation();
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                GfxAdvFragment.this.setButtonOnApplySettings();
                textView.setText(R.string.done);
                dialogAccept.dismiss();
            }
        });
        dialogAccept.show();

    }



}
