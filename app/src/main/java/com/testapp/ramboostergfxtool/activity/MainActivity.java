package com.testapp.ramboostergfxtool.activity;

import android.Manifest;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.gms.ads.AdLoader;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.moos.library.CircleProgressView;
import com.moos.library.HorizontalProgressView;
import com.stepstone.apprating.AppRatingDialog;
import com.stepstone.apprating.listener.RatingDialogListener;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.adapter.AddGameAdapter;
import com.testapp.ramboostergfxtool.adapter.GridAppAdapter;
import com.testapp.ramboostergfxtool.adapter.LoadGameAdapter;
import com.testapp.ramboostergfxtool.adapter.SpacesItemDecoration;
import com.testapp.ramboostergfxtool.ads.AdControl;
import com.testapp.ramboostergfxtool.ads.AdControlHelp;
import com.testapp.ramboostergfxtool.ads.InterstitialAdShow;
import com.testapp.ramboostergfxtool.bean.GameItem;
import com.testapp.ramboostergfxtool.data.GameDatabase;
import com.testapp.ramboostergfxtool.fragment.AppUsageBottomSheetFragment;
import com.testapp.ramboostergfxtool.rammbooster.RamBoosting;
import com.testapp.ramboostergfxtool.rammbooster.RammBoosterInstalledPackage;
import com.testapp.ramboostergfxtool.rx.DisposableManager;
import com.testapp.ramboostergfxtool.services.BoosterService;
import com.testapp.ramboostergfxtool.services.GameModeService;
import com.testapp.ramboostergfxtool.util.CpuInfo;
import com.testapp.ramboostergfxtool.util.CpuInfoM;
import com.testapp.ramboostergfxtool.util.GameItemComporator;
import com.testapp.ramboostergfxtool.util.MyAppInfo;
import com.testapp.ramboostergfxtool.util.MyNetworkProgressView;
import com.testapp.ramboostergfxtool.util.PrefHelper;
import com.testapp.ramboostergfxtool.util.RxGameBoost;
import com.testapp.ramboostergfxtool.util.SharePreferenceUtilsAds;
import com.testapp.ramboostergfxtool.util.SpacesItem;
import com.testapp.ramboostergfxtool.util.Utils;
import com.testapp.ramboostergfxtool.util.drawableApp;
import com.testapp.ramboostergfxtool.util.netInterface;
import com.testapp.ramboostergfxtool.vipgfx.activity.HomeVipActivity;
import com.testapp.ramboostergfxtool.vipgfx.view.AnimationLinearLayout;
import com.testapp.ramboostergfxtool.widget.ExpandableHeightGridView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

import io.fabric.sdk.android.services.events.EventsFilesManager;
import me.piruin.quickaction.ActionItem;
import me.piruin.quickaction.QuickAction;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements RatingDialogListener, View.OnClickListener {
    public static final String IS_VOTED = "com.testapp.is_voted";
    private static final String TAG = "MainActivity";
    private static final String ACTION_BAT = "android.intent.action.BATTERY_CHANGED";
    private ArrayList<RammBoosterInstalledPackage> boosterInstalledPackageArrayList;
    private Button btnRamBooster;
    private Handler cpuHandler;
    private CpuInfoM cpuInfoM;
    private CircleProgressView cpuProgress;
    private CpuRunnable cpuRunnable = new CpuRunnable(this);
    private TextView cpuText;
    private long upL;
    private final Handler handler = new Handler();
    private ArrayList<String> listLog = new ArrayList<>();
    private boostReceiver bootRev;
    private boolean isZ;
    private mReceiver mReceiver = null;
    private Runnable mUpProgress = new runUpdatProgress(this);
    private List<MyAppInfo> arrayList = new ArrayList();
    private RecyclerView itemDecoration;
    private GridAppAdapter gridAppAdapter;
    private ImageView ivFooter;
    private TextView tvAppName;
    LinearLayout lrHeader;
    LinearLayout lrFooter;
    private LinearLayout lr_network_tip;
    private HorizontalProgressView horizontalProgressView;
    private MyNetworkProgressView myNetworkProgressView;
    private TextView tvTemp;
    private TextView tvNet;
    private TextView tv_network_tip;
    private LottieAnimationView animationView;
    private FrameLayout fmAnimBack;
    private TextView tvBoostT;
    private SharedPreferences preferences;
    private BatteryInfoBroadcastReceiver broadcastReceiver = null;
    private DecimalFormat decimalFormat;
    private int intTem;
    private LinearLayout gfx_app_item_layout;
    private LinearLayout gfx_app_advanced;
    private LinearLayout special_item_layout;
    private boolean isInstanceShow = false;
    private int isSpecialClick = 0;
    private Handler ramHandler;
    private CircleProgressView ramProgress;
    private TextView ramText;
    private LottieAnimationView animLottie;
    private LottieAnimationView rippleLottie;
    private LinearLayout rlAddGame;
    private GameItem A;
    private ExpandableHeightGridView B;
    private RelativeLayout D;
    private QuickAction E;
    private ImageView F;
    private NestedScrollView G;
    private boolean H = false;
    private boolean I = false;
    private AsyncTask<Void, Void, Void> J;
    private int K = 0;
    private AdLoader t;
    private GameDatabase v;
    private ArrayList<String> w;
    private List<GameItem> x;
    private LoadGameAdapter y;
    private int z;
    private Runnable r;
    private boolean b = false;
    private AnimationLinearLayout vipGfx;
    private com.testapp.ramboostergfxtool.local.GameDatabase settingsDatabase;

    private static class a extends AsyncTask<Void, Void, Void> {
        private WeakReference<MainActivity> a;

        public a(MainActivity gameBoostActivity) {
            this.a = new WeakReference<>(gameBoostActivity);
        }


        @Override
        public Void doInBackground(Void... voidArr) {
            MainActivity gameBoostActivity = this.a.get();
            if (gameBoostActivity != null && !gameBoostActivity.isFinishing()) {
                gameBoostActivity.v = new GameDatabase(gameBoostActivity);
                gameBoostActivity.w = gameBoostActivity.v.getAllRecords();
                if (gameBoostActivity.w != null && gameBoostActivity.w.size() > 0) {
                    Iterator it = gameBoostActivity.w.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (isCancelled()) {
                            break;
                        } else if (Utils.isPackageInstalled(gameBoostActivity, str)) {
                            gameBoostActivity.x.add(new GameItem(Utils.getAppName(gameBoostActivity, str), str, Utils.getAppIcon(gameBoostActivity, str)));
                        } else {
                            gameBoostActivity.v.deleteRecord(str);
                        }
                    }
                }
                Collections.sort(gameBoostActivity.x, GameItemComporator.comporator);
                gameBoostActivity.y = new LoadGameAdapter(gameBoostActivity, R.layout.item_game_boost_grid, gameBoostActivity.x);
            }
            return null;
        }

        @Override
        public void onPostExecute(Void r4) {
            MainActivity gameBoostActivity = this.a.get();
            if (gameBoostActivity != null && !gameBoostActivity.isFinishing()) {
                if (gameBoostActivity.w == null || gameBoostActivity.w.size() <= 0) {
                    View findViewById = gameBoostActivity.findViewById(R.id.tvEmpty);
                    findViewById.setVisibility(View.VISIBLE);
                    gameBoostActivity.B.setEmptyView(findViewById);
                }
                gameBoostActivity.B.setAdapter((ListAdapter) gameBoostActivity.y);
                gameBoostActivity.B.setExpanded(true);
                gameBoostActivity.B.setFocusable(false);
            }
        }


        @Override
        public void onPreExecute() {
            MainActivity gameBoostActivity = this.a.get();
            if (gameBoostActivity != null && !gameBoostActivity.isFinishing()) {
                gameBoostActivity.x = new ArrayList();
            }
        }
    }

    public void D(TextView textView) {
        textView.setText(this.K + "%");
    }


    public void F(Intent intent) {
        startActivity(intent);
        this.G.setVisibility(View.VISIBLE);
        this.D.setVisibility(View.GONE);
    }

    public void H(TextView textView, Intent intent) {
        int i = 0;
        while (true) {
            this.K = i;
            if (this.K <= 100) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.K <= 100) {
                    runOnUiThread(() -> D(textView));
                }
                i = this.K + 1;
            } else {
                if (intent == null) {
                    finishAndRemoveTask();
                    return;
                }
                runOnUiThread(() -> F(intent));
                return;
            }
        }
    }

    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    checkSystemWritePermission();
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // feature requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                }
            });

    private void checkSystemWritePermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (android.provider.Settings.System.canWrite(this)) {
                startService(new Intent(this, GameModeService.class));
                askPer();
                return;
            }
            openAndroidPermissionsMenu();
        }
    }

    @SuppressLint("WrongConstant")
    private void openAndroidPermissionsMenu() {
        if (Build.VERSION.SDK_INT >= 23) {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            StringBuilder sb = new StringBuilder();
            sb.append("package:");
            sb.append(getPackageName());
            intent.setData(Uri.parse(sb.toString()));
            intent.setFlags(268468224);
            startActivityForResult(intent, 102);
        }
    }

    private void checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.POST_NOTIFICATIONS) ==
                    PackageManager.PERMISSION_GRANTED) {
                checkSystemWritePermission();
                // You can use the API that requires the permission.
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                // In an educational UI, explain to the user why your app requires this
                // permission for a specific feature to behave as expected, and what
                // features are disabled if it's declined. In this UI, include a
                // "cancel" or "no thanks" button that lets the user continue
                // using your app without granting the permission.
            } else {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    requestPermissionLauncher.launch(
                            Manifest.permission.POST_NOTIFICATIONS);
                }
            }
        }
    }
    @SuppressLint({"WrongConstant", "ShowToast"})
    private void M() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.A.getPackageName());
        if (launchIntentForPackage == null) {
            Toast.makeText(this, getString(R.string.no_ui), 0).show();
            this.G.setVisibility(View.VISIBLE);
            this.D.setVisibility(View.GONE);
            return;
        }
        RxGameBoost rxGameBoost = new RxGameBoost();
        s();
        rxGameBoost.startGameBoost(this, this.A.getPackageName());
        this.r = () -> H((TextView) findViewById(R.id.tvProgress), launchIntentForPackage);
        new Thread(r).start();
    }


    private void P() {
        AsyncTask<Void, Void, Void> asyncTask = this.J;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
    }


    private Context s() {
        return this;
    }


    private void t() {
        this.F = (ImageView) findViewById(R.id.ivGameAnimation);
        ActionItem actionItem = new ActionItem(1, getString(R.string.remove_game));
        QuickAction quickAction = new QuickAction(this, 0);
        this.E = quickAction;
        quickAction.setColorRes(R.color.light_white);
        this.E.setTextColorRes(R.color.base_color);
        this.E.setTextColor(Color.parseColor("#727272"));
        this.E.addActionItem(actionItem);
        this.E.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {
            @Override
            public void onItemClick(ActionItem item) {
                v(item);
            }
        });
        this.D = (RelativeLayout) findViewById(R.id.rlAnimationGame);
        this.G = (NestedScrollView) findViewById(R.id.nsMainView);
        this.animLottie = findViewById(R.id.animLottie);
        this.rippleLottie = findViewById(R.id.rippleLottie);
        ExpandableHeightGridView expandableHeightGridView = (ExpandableHeightGridView) findViewById(R.id.gridViewGame);
        this.B = expandableHeightGridView;
        expandableHeightGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return x(adapterView, view, i, l);
            }
        });
        this.B.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                z(adapterView, view, i, l);

            }
        });
        ViewCompat.setNestedScrollingEnabled(this.B, true);

    }


    public void v(ActionItem actionItem) {
        this.v.deleteRecord(this.x.get(this.z).getPackageName());
        this.x.remove(this.z);
        this.y.notifyDataSetChanged();
    }


    public boolean x(AdapterView adapterView, View view, int i, long j) {
        if (this.H) {
            return false;
        }
        this.H = true;
        this.z = i;
        this.E.show(view);
        return false;
    }

    public void z(AdapterView adapterView, View view, int i, long j) {
        if (!this.H) {
            GameItem gameItem = this.x.get(i);
            this.A = gameItem;
            this.F.setImageDrawable(gameItem.getAppIcon());
            this.G.setVisibility(View.GONE);
            this.D.setVisibility(View.VISIBLE);
            this.E.dismiss();
            this.animLottie.playAnimation();
            this.rippleLottie.playAnimation();
            Intent intent = new Intent(this, GameModeService.class);
            intent.putExtra(GameModeService.KEY_SERVICE_CALLED_BY_SYSTEM, true);
            intent.putExtra(GameModeService.SELECTED_APP, this.A.getPackageName());
            startService(intent);
            M();
        }
        this.H = false;
    }


    private void rvNet() {
    }

    private void rvNetInfo() {
    }

    @Override
    public void onNegativeButtonClicked() {
    }

    AdControlHelp adControlHelp;
    Context context;
    private AdControl adControl;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        if (getIntent().hasExtra(GameModeService.KEY_ASK_READ_NOTIFICATION_PERMISSION) && getIntent().getBooleanExtra(GameModeService.KEY_ASK_READ_NOTIFICATION_PERMISSION, false)) {
            startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
            finish();
            return;
        }
        if (getIntent().hasExtra(GameModeService.KEY_BOOSTED_FROM_NOTI_SERVICE) && getIntent().getBooleanExtra(GameModeService.KEY_BOOSTED_FROM_NOTI_SERVICE, false)) {
            playBoostRamAnimation();
            return;
        }
        this.context = MainActivity.this;
        this.adControlHelp = AdControlHelp.getInstance(this);
        this.adControl = AdControl.getInstance(this.context);
        this.adControlHelp.loadNative(this, (LinearLayout) findViewById(R.id.native_ads_control_holder), R.layout.item_admob_native_setting, false, false, this.adControl.admob_native_main());

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        updateUsageAuto();
                    }
                });
            }

            ;
        }, 1000, 1000);
        this.decimalFormat = new DecimalFormat();
        this.decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
        this.decimalFormat.setGroupingUsed(false);
        this.decimalFormat.setMaximumFractionDigits(1);
        this.decimalFormat.setMinimumFractionDigits(0);
        this.preferences = getSharedPreferences("main_sp", 0);
        this.boosterInstalledPackageArrayList = RamBoosting.mListPack(this);
        this.cpuInfoM = new CpuInfoM();
        this.cpuHandler = new Handler();
        this.ramHandler = new Handler();
        PrefHelper.getInstance().putApp("com.google.android.gms", true);
        PrefHelper.getInstance().putApp("com.android.chrome", true);
        checkNotificationPermission();
        t();
        AsyncTask<Void, Void, Void> asyncTask = this.J;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        a aVar = new a(this);
        this.J = aVar;
        aVar.execute(new Void[0]);

        InterstitialAdShow.getInstance(MainActivity.this).showInterstitialAd(MainActivity.this, new InterstitialAdShow.AdCloseListener() {
            @Override
            public void onAdClosed() {
                if (MainActivity.this.isSpecialClick == 1) {
                    MainActivity.this.isSpecialClick = 0;
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.startActivity(new Intent(mainActivity, SpecialCharacterActivity.class));
                } else if (MainActivity.this.isSpecialClick == 2) {
                    MainActivity.this.isSpecialClick = 0;
                    MainActivity mainActivity2 = MainActivity.this;
                    mainActivity2.startActivity(new Intent(mainActivity2, PubgGFXActivity.class));
                }
            }
        });
        this.vipGfx = findViewById(R.id.vip_app_item_layout);
        this.vipGfx.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                startActivity(new Intent(MainActivity.this, HomeVipActivity.class));
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle((CharSequence) getString(R.string.app_name));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        ImageView ivEditSelectedApp = findViewById(R.id.iv_edit_selected_app);
        ivEditSelectedApp.setOnClickListener(this);

        if (Build.VERSION.SDK_INT > 28) {
            findViewById(R.id.lrCpuMain).setVisibility(View.GONE);
        }
    }

    private void playBoostRamAnimation() {
        this.D = (RelativeLayout) findViewById(R.id.rlAnimationGame);
        this.animLottie = findViewById(R.id.animLottie);
        this.rippleLottie = findViewById(R.id.rippleLottie);
        D.setVisibility(View.VISIBLE);
        animLottie.playAnimation();
        rippleLottie.playAnimation();
        RxGameBoost rxGameBoost = new RxGameBoost();
        rxGameBoost.startGameBoost(this, this.getPackageName());
        this.r = () -> H((TextView) findViewById(R.id.tvProgress), null);
        new Thread(r).start();
    }

    private boolean askES(Context context) {
        return EasyPermissions.hasPermissions(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    private void titleAsk() {
        EasyPermissions.requestPermissions(this, getString(R.string.permission_storage_message), 1001, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    private boolean getAsk() {
        if (Build.VERSION.SDK_INT < 23 || askES(this)) {
            return true;
        }
        titleAsk();
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mymenu = getMenuInflater();
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_settings:
                startActivity(new Intent(this, BoosterSettingsActivity.class));
                break;
            case R.id.menu_share:
                Utils.geShareApp(MainActivity.this, getPackageName());
                break;
            case R.id.menu_review:
                MainActivity.this.showMaterialRatingDialog();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNeutralButtonClicked() {
        PrefHelper.getInstance().setBooleanName(IS_VOTED, true);
    }


    @Override
    public void onPositiveButtonClicked(int i, String str) {
        if (i < 5) {
            Toast.makeText(this, "Thank you", Toast.LENGTH_SHORT).show();
            return;
        }
        PrefHelper.getInstance().setBooleanName(IS_VOTED, true);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

    public static Map<String, String> getCPUInfo() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
        HashMap hashMap = new HashMap();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split(":");
                if (split.length > 1) {
                    String replace = split[0].trim().replace(" ", EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                    if (replace.equals("model_name")) {
                        replace = "cpu_model";
                    }
                    String trim = split[1].trim();
                    if (replace.equals("cpu_model")) {
                        trim = trim.replaceAll("\\s+", " ");
                    }
                    hashMap.put(replace, trim);
                }
            } else {
                bufferedReader.close();
                return hashMap;
            }
        }
    }



    private void o() {
        startActivity(new Intent(this, AddGameActivity.class));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.iv_edit_selected_app:
                if (bottomAsk()) {
                    o();
                }
                break;
            case R.id.lr_network_tip:
                dialogNetTip();
                break;
            case R.id.gfx_app_item_layout:
                InterstitialAdShow.getInstance(MainActivity.this).showInterstitialAd(MainActivity.this, new InterstitialAdShow.AdCloseListener() {

                    @Override
                    public void onAdClosed() {
                        if (bottomAsk() && getAsk()) {
                            startActivity(new Intent(MainActivity.this, PubgGFXActivity.class));
                            return;
                        }
                    }
                });
                break;
            case R.id.gfx_app_advanced:
                InterstitialAdShow.getInstance(MainActivity.this).showInterstitialAd(MainActivity.this, new InterstitialAdShow.AdCloseListener() {

                    @Override
                    public void onAdClosed() {

                        startActivity(new Intent(MainActivity.this, GfxAdvancedActivity.class));
                    }
                });
                break;

            case R.id.special_item_layout:

                InterstitialAdShow.getInstance(MainActivity.this).showInterstitialAd(MainActivity.this, new InterstitialAdShow.AdCloseListener() {
                    @Override
                    public void onAdClosed() {

                        startActivity(new Intent(MainActivity.this, SpecialCharacterActivity.class));

                    }
                });

                break;
            default:
                break;
        }
    }

    public class BatteryInfoBroadcastReceiver extends BroadcastReceiver {
        final MainActivity mainActivity;

        public BatteryInfoBroadcastReceiver(MainActivity mainActivity2) {
            this.mainActivity = mainActivity2;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (MainActivity.ACTION_BAT.equals(intent.getAction())) {
                intent.getIntExtra("scale", -1);
                this.mainActivity.intTem = intent.getIntExtra("temperature", -1) / 10;
                this.mainActivity.setColorProgress();
            }
        }
    }


    private void setColorProgress() {
        int i;
        if (this.horizontalProgressView != null && (i = this.intTem) > 0) {
            int i2 = R.color.state_red_color;
            if (i < 30) {
                i2 = R.color.state_green_color;
            } else if (i < 60) {
                i2 = R.color.state_yellow_color;
            }
            this.horizontalProgressView.setStartColor(getResources().getColor(i2));
            this.horizontalProgressView.setEndColor(getResources().getColor(i2));
            this.horizontalProgressView.setProgress((float) this.intTem);
            TextView textView = this.tvTemp;
            textView.setText(this.intTem + "℃");
        }
    }

    private int getNumCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {

                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }



    public class boostReceiver extends BroadcastReceiver {
        final MainActivity mainActivity;

        private boostReceiver(MainActivity mainActivity2) {
            this.mainActivity = mainActivity2;
        }

        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED")) {
                if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                    this.mainActivity.listLog.add(intent.getData().getSchemeSpecificPart());
                }
            } else if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                this.mainActivity.listLog.remove(intent.getData().getSchemeSpecificPart());
            }
        }
    }


    public class mReceiver extends BroadcastReceiver {
        final MainActivity mainActivity;

        private mReceiver(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }

        public void onReceive(Context context, Intent intent) {
            this.mainActivity.rvNetInfo();
        }
    }

    class runUpdatProgress implements Runnable {
        final MainActivity mainActivity;

        class interfUp implements netInterface.mInterface {
            final runUpdatProgress progress;

            interfUp(runUpdatProgress updatProgress) {
                this.progress = updatProgress;
            }

            @Override
            public void mLogInterface(long j) {
                this.progress.mainActivity.upL = j;
                this.progress.mainActivity.mConnectF();
                if (this.progress.mainActivity.isZ) {
                    this.progress.mainActivity.handler.postDelayed(this.progress.mainActivity.mUpProgress, 3000);
                }
            }
        }

        runUpdatProgress(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }

        public void run() {
            netInterface.intV("https://www.google.com/", new interfUp(this));
            MainActivity.this.ramProgress();
            MainActivity.this.cpuProgress();
        }
    }


    private void mConnectF() {
        TextView textView = this.tvNet;
        if (textView != null) {
            long j = this.upL;
            if (j != 0) {
                if (j == -1) {
                    textView.setText(getResources().getString(R.string.connection_failed));
                } else {
                    textView.setText(this.upL + "ms");
                }
                this.myNetworkProgressView.setDelayTime(this.upL);
            }
        }
    }

    private void viewGameHome() {
        this.itemDecoration = (RecyclerView) findViewById(R.id.recycler_view);
        this.gridAppAdapter = new GridAppAdapter(this.arrayList);
        this.itemDecoration.setLayoutManager(new GridLayoutManager(this, 4));
        this.itemDecoration.setAdapter(this.gridAppAdapter);
        this.itemDecoration.addItemDecoration(new SpacesItemDecoration(this, 0));
        this.lrHeader = findViewById(R.id.lrHeader);
        this.lrFooter = findViewById(R.id.lrFooter);
        this.gridAppAdapter.setOnItemChildClickListener(new OnItemGame(this));
        helAddGame();
        this.ivFooter = (ImageView) findViewById(R.id.icon_gfx_footer);
        this.tvAppName = (TextView) findViewById(R.id.gfx_app_name);
        MyAppInfo packNm = PrefHelper.getInstance().getPackNm("com.tencent.ig");
        if (packNm != null) {
            this.tvAppName.setText(packNm.charSequence);
            this.ivFooter.setImageDrawable(packNm.drawable);
        }
        this.gfx_app_item_layout = findViewById(R.id.gfx_app_item_layout);
        this.gfx_app_advanced = findViewById(R.id.gfx_app_advanced);
        this.special_item_layout = findViewById(R.id.special_item_layout);
        this.gfx_app_item_layout.setOnClickListener(this);
        this.gfx_app_advanced.setOnClickListener(this);
        this.special_item_layout.setOnClickListener(this);
        this.fmAnimBack = (FrameLayout) findViewById(R.id.lottie_background);
        this.tvBoostT = (TextView) findViewById(R.id.boosting_textview);
        this.animationView = (LottieAnimationView) findViewById(R.id.lottie_loading);

        this.animationView.setAnimation(R.raw.rocket_flyaway);
        this.animationView.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
            @Override
            public void onCompositionLoaded(LottieComposition composition) {
                MainActivity.this.animationView.setComposition(composition);
            }
        });
        if (getNetworkInfo(this)) {
            rvNetInfo();
        } else {
            iFilter();
        }
        rvNet();
        this.broadcastReceiver = new BatteryInfoBroadcastReceiver(this);
        registerReceiver(this.broadcastReceiver, new IntentFilter(ACTION_BAT));
        intView();
        if (SpacesItem.isPref()) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    ContextCompat.startForegroundService(this, new Intent(this, BoosterService.class));

                } else {
                    startService(new Intent(this, BoosterService.class));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        new mAsync(this).execute(new Void[0]);
        if (this.bootRev == null) {
            this.bootRev = new boostReceiver(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.bootRev, intentFilter);
    }

    private boolean bottomAsk() {
        if (Build.VERSION.SDK_INT < 21 || Utils.hasUsagePermission(this)) {
            return true;
        }
        AppUsageBottomSheetFragment appUsageBottomSheetFragment = new AppUsageBottomSheetFragment();
        FragmentActivity activity = this;
        Objects.requireNonNull(activity);
        appUsageBottomSheetFragment.show(activity.getSupportFragmentManager(), appUsageBottomSheetFragment.getTag());
        return false;
    }


    public final class OnItemGame implements BaseQuickAdapter.OnItemChildClickListener {
        private final MainActivity f1725a;

        OnItemGame(MainActivity mainActivity) {
            this.f1725a = mainActivity;
        }

        @Override
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
            this.f1725a.gRootView(baseQuickAdapter, view, i);
        }
    }


    public final void gRootView(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        if (view.getId() == R.id.layout_root_app) {
            if (bottomAsk()) {
                resultInfo(this.arrayList.get(i));
            }

        }
    }

    public void resultInfo(MyAppInfo myAppInfo) {
        if (myAppInfo instanceof drawableApp) {
            startActivityForResult(new Intent(this, ActivityAddApp.class), 1);
        } else {
            rBoost(myAppInfo);
        }
    }


    private void rBoost(final MyAppInfo myAppInfo) {
        this.tvBoostT.setText(String.format(getResources().getString(R.string.boosting_app), myAppInfo.charSequence));
        this.tvBoostT.setAlpha(0.0f);
        this.fmAnimBack.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(280);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setRepeatCount(0);
        this.fmAnimBack.startAnimation(alphaAnimation);
        this.fmAnimBack.postDelayed(new startAnimator(this), 280);
        this.fmAnimBack.postDelayed(new startAnimatorEnd(this), 1900);
        this.animationView.addAnimatorListener(new Animator.AnimatorListener() {

            final MainActivity mainActivity = MainActivity.this;

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }

            @Override
            public void onAnimationStart(Animator animator) {
                SpacesItem.listLog(this.mainActivity.listLog, myAppInfo.string);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Intent launchIntentForPackage = this.mainActivity.getPackageManager().getLaunchIntentForPackage(myAppInfo.string);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                    this.mainActivity.startActivity(launchIntentForPackage);
                    this.mainActivity.finish();
                    System.runFinalization();
                    Runtime.getRuntime().gc();
                    System.gc();
                }
            }
        });
        this.animationView.playAnimation();
    }

    public class startAnimator implements Runnable {
        final MainActivity mainActivity;

        startAnimator(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }

        public void run() {
            this.mainActivity.tvBoostT.setAlpha(1.0f);
            this.mainActivity.tvBoostT.clearAnimation();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
            alphaAnimation.setDuration(320);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setRepeatCount(0);
            this.mainActivity.tvBoostT.startAnimation(alphaAnimation);
        }
    }

    public class startAnimatorEnd implements Runnable {
        final MainActivity mainActivity;

        startAnimatorEnd(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }

        public void run() {
            this.mainActivity.tvBoostT.clearAnimation();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
            alphaAnimation.setDuration(300);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setRepeatCount(0);
            this.mainActivity.tvBoostT.startAnimation(alphaAnimation);
        }
    }


    public void helAddGame() {
        List<MyAppInfo> infos = PrefHelper.getInstance().getAppL();
        this.arrayList.clear();
        if (infos != null || infos.size() > 0) {
            this.arrayList.addAll(infos);
        }
        this.arrayList.add(new drawableApp(ContextCompat.getDrawable(this, R.drawable.ic_add_game)));
        this.gridAppAdapter.setNewData(this.arrayList);
    }

    public boolean getNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    private void iFilter() {
        this.mReceiver = new mReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.mReceiver, intentFilter);
    }

    private void intView() {
        this.ramProgress = (CircleProgressView) this.findViewById(R.id.storage_progressView_circle);
        this.cpuProgress = (CircleProgressView) this.findViewById(R.id.cpu_progressView_circle);
        this.horizontalProgressView = (HorizontalProgressView) this.findViewById(R.id.temperature_progressView_horizontal);
        this.myNetworkProgressView = (MyNetworkProgressView) this.findViewById(R.id.network_progress);
        this.ramText = (TextView) this.findViewById(R.id.storage_text);
        this.cpuText = (TextView) this.findViewById(R.id.cpu_text);
        this.tvTemp = (TextView) this.findViewById(R.id.temperature_text);
        this.tvNet = (TextView) this.findViewById(R.id.network_text);
        this.tv_network_tip = (TextView) this.findViewById(R.id.tv_network_tip);
        this.lr_network_tip = (LinearLayout) this.findViewById(R.id.lr_network_tip);
        this.lr_network_tip.setOnClickListener(this);

        ramProgress();
        setColorProgress();
        mConnectF();
        this.btnRamBooster = (Button) this.findViewById(R.id.boost_ram_button);
        this.btnRamBooster.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MainActivity mainActivity = MainActivity.this;
                new RamBoostTask(mainActivity).execute(new Void[0]);
            }
        });
    }


    private void dialogNetTip() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.network_speed));
        builder.setMessage(getString(R.string.network_speed_explain));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }


    private void ramProgress() {
        if (this.ramProgress != null) {
            long spH = SpacesItem.valR();
            long spW = SpacesItem.appInf(this);
            String format = this.decimalFormat.format((((double) spH) / 1024.0d) / 1024.0d);
            String format2 = this.decimalFormat.format((((double) spW) / 1024.0d) / 1024.0d);
            TextView textView = this.ramText;
            textView.setText(format2 + "G / " + format + "G");
            int i = 100 - ((int) ((spW * 100) / spH));
            int i2 = R.color.state_red_color;
            if (i < 40) {
                i2 = R.color.state_green_color;
            } else if (i < 70) {
                i2 = R.color.state_yellow_color;
            }
            this.ramProgress.setStartColor(getResources().getColor(i2));
            this.ramProgress.setEndColor(getResources().getColor(i2));
            this.ramProgress.setProgress((float) i);
        }
    }

    private void updateUsageAuto() {
        cpuProgress();
    }


    private void cpuProgress() {
        if (Build.VERSION.SDK_INT >= 26) {
            if (this.cpuProgress != null) {
                long usage = CpuInfo.getCpuUsageFromFreq();
                int i = R.color.state_red_color;
                if (usage < 40) {
                    i = R.color.state_green_color;
                } else if (usage < 70) {
                    i = R.color.state_yellow_color;
                }
                this.cpuProgress.setStartColor(getResources().getColor(i));
                this.cpuProgress.setEndColor(getResources().getColor(i));
                this.cpuProgress.setProgress((float) usage);
                TextView textView = this.cpuText;
                textView.setText("Loaded " + usage + "%");
            }
        } else {
            if (this.cpuProgress != null) {
                long usage = this.cpuInfoM.getUsage();
                int i = R.color.state_red_color;
                if (usage < 40) {
                    i = R.color.state_green_color;
                } else if (usage < 70) {
                    i = R.color.state_yellow_color;
                }
                this.cpuProgress.setStartColor(getResources().getColor(i));
                this.cpuProgress.setEndColor(getResources().getColor(i));
                this.cpuProgress.setProgress((float) usage);
                TextView textView = this.cpuText;
                textView.setText("Loaded " + usage + "%");
            }
        }
    }

    public class mAsync extends AsyncTask<Void, Void, List<String>> {
        final MainActivity mainActivity;

        private mAsync(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }


        public List<String> m648a(Void... voidArr) {
            try {
                return PrefHelper.getInstance().listNm();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }


        public void listPE(List<String> list) {
            super.onPostExecute(list);
            if (list != null) {
                this.mainActivity.listLog.clear();
                this.mainActivity.listLog.addAll(list);
            }
        }

        @Override
        public List<String> doInBackground(Void... voidArr) {
            return m648a(voidArr);
        }


        @Override
        public void onPostExecute(List<String> list) {
            super.onPostExecute(list);
            listPE(list);
        }
    }

    private void askPer() {
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            viewGameHome();
        } else {
            if (Build.VERSION.SDK_INT < 29) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                finish();
            } else {
                viewGameHome();
            }
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        this.isZ = false;
        this.handler.removeCallbacks(this.mUpProgress);
    }


    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            helAddGame();
        }
    }


    @Override
    public void onDestroy() {
        SharePreferenceUtilsAds.getInstance(this).setFlagAds(false);
        DisposableManager.dispose();
        super.onDestroy();
        upReceiv();
        BatteryInfoBroadcastReceiver batteryInfoBroadcastReceiver = this.broadcastReceiver;
        if (batteryInfoBroadcastReceiver != null) {
            unregisterReceiver(batteryInfoBroadcastReceiver);
        }
        boostReceiver boostReceiver = this.bootRev;
        if (boostReceiver != null) {
            unregisterReceiver(boostReceiver);
        }
    }

    private void upReceiv() {
        mReceiver mReceiver = this.mReceiver;
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
            this.mReceiver = null;
        }
    }

    class CpuRunnable implements Runnable {
        final MainActivity mainActivity;

        public CpuRunnable(MainActivity mainActivity2) {
            this.mainActivity = mainActivity2;
        }

        public void run() {
            MainActivity.this.cpuProgress();
            this.mainActivity.cpuHandler.postDelayed(this, 1000);
        }
    }



    public String boostRam(String str) {
        float szBoost = RamBoosting.RamBoosting(this);
        float f = 0.0f;
        for (int i = 0; i < this.boosterInstalledPackageArrayList.size(); i++) {
            RammBoosterInstalledPackage rammBoosterInstalledPackage = this.boosterInstalledPackageArrayList.get(i);
            if (!str.equals(rammBoosterInstalledPackage.strPack) && !rammBoosterInstalledPackage.strPack.equals(getPackageName()) && rammBoosterInstalledPackage != null && !rammBoosterInstalledPackage.isRamBo()) {
                RamBoosting.ramBo(rammBoosterInstalledPackage.strPack, (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE), rammBoosterInstalledPackage.isSys);
                float boostSize = RamBoosting.RamBoosting(this);
                if (boostSize > f) {
                    f = boostSize;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        float f2 = f - szBoost;
        if (f2 >= Float.intBitsToFloat(1)) {
            sb.append(getResources().getString(R.string.freed_up, RamBoosting.covertS((long) f2)));
        } else {
            sb.append(getResources().getString(R.string.freed_up, "0 MB"));
        }
        return sb.toString();
    }

    class RamBoostTask extends AsyncTask<Void, String, String> {
        final MainActivity mainActivity;

        public RamBoostTask(MainActivity mainActivity2) {
            this.mainActivity = mainActivity2;
        }

        @Override
        public String doInBackground(Void... voidArr) {
            MainActivity mainActivity2 = this.mainActivity;
            return mainActivity2.boostRam(mainActivity2.getPackageName());
        }


        @Override
        public void onPostExecute(String str) {
            super.onPostExecute(str);

            InterstitialAdShow.getInstance(MainActivity.this).showInterstitialAd(MainActivity.this, new InterstitialAdShow.AdCloseListener() {
                @Override
                public void onAdClosed() {
                    if (str != null && !str.isEmpty()) {
                        Toast.makeText(RamBoostTask.this.mainActivity, str, Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }




    public void showMaterialRatingDialog() {
        try {
            new AppRatingDialog.Builder().setPositiveButtonText("Submit").setNegativeButtonText("Cancel").setNeutralButtonText("Never").setNoteDescriptions(Arrays.asList(getString(R.string.very_bad), getString(R.string.not_good), getString(R.string.quit_ok), getString(R.string.very_good), getString(R.string.excellent))).setDefaultRating(0).setTitle(R.string.rate_this_application).setDescription(R.string.givefeedback).setCommentInputEnabled(true).setStarColor(R.color.state_yellow_color).setNoteDescriptionTextColor(R.color.state_gray_color).setTitleTextColor(R.color.titleTextColor).setDescriptionTextColor(R.color.state_gray_color).setHint(R.string.white_comment).setHintTextColor(R.color.state_gray_color).setCommentTextColor(R.color.state_gray_color).setCommentBackgroundColor(R.color.description_background).setWindowAnimation(R.style.MyDialogFadeAnimation).setCancelable(false).setCanceledOnTouchOutside(true).create(this).show();
        } catch (Exception unused) {
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        checkSystemWritePermission();
        ramProgress();
        this.isZ = true;
        this.handler.post(this.mUpProgress);
        if (this.y != null) {
            ArrayList<GameItem> arrayList = AddGameAdapter.addedData;
            if (arrayList != null) {
                Collections.sort(arrayList, GameItemComporator.comporator);
                this.y.clear();
                this.y.addAll(arrayList);
                this.y.notifyDataSetChanged();
                AddGameAdapter.addedData = null;
                if (arrayList.size() == 0) {
                    View findViewById = findViewById(R.id.tvEmpty);
                    findViewById.setVisibility(View.VISIBLE);
                    B.setEmptyView(findViewById);
                }
            }
        }
    }

    @SuppressLint({"ResourceType", "SetTextI18n"})
    @Override
    public void onBackPressed() {
        P();
        try {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.askBottomShee);
            View inflate = getLayoutInflater().inflate(R.layout.bottom_sheet_p2, null);
            bottomSheetDialog.setContentView(inflate);
            TextView textView = (TextView) inflate.findViewById(R.id.t1);
            TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
            TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
            TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
            textView.setText(R.string.wanna_quit);
            textView2.setText("are you suer wanna quit app ? please note this point, play game every time using our gfx tool \n for better experience .");
            textView4.setText(R.string.yes_quit);
            textView3.setText(R.string.no_stay);
            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bottomSheetDialog.dismiss();
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.this.finishAffinity();
                }
            });
            bottomSheetDialog.setCancelable(true);
            bottomSheetDialog.show();
        } catch (Exception unused) {
            finishAffinity();
        }
    }

}
