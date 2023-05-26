package com.testapp.ramboostergfxtool.vipgfx.activity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.vipgfx.a.BgmiActivity;
import com.testapp.ramboostergfxtool.vipgfx.stringfog.xor.StringFogImpl;
import com.testapp.ramboostergfxtool.vipgfx.util.FileUtil;
import com.testapp.ramboostergfxtool.vipgfx.util.RequestNetwork;
import com.testapp.ramboostergfxtool.vipgfx.util.RequestNetwork.RequestListener;
import com.testapp.ramboostergfxtool.vipgfx.util.SketchwareUtil;
import com.testapp.ramboostergfxtool.vipgfx.util.Utils;
import com.testapp.ramboostergfxtool.vipgfx.view.AnimationLinearLayout;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeVipActivity extends AppCompatActivity {
    private static final int NEW_FOLDER_REQUEST_CODE = 43;
    private double PermissionNumber = 0.0d;
    private RequestNetwork RequestNet;
    private SharedPreferences UCSP;
    private String Update;
    public HashMap<String, Object> UpdatifyMap;
    public SharedPreferences VER;
    private RequestListener _RequestNet_request_listener;
    private Timer _timer = new Timer();
    private String app_version;
    private String assetFilename;
    private String assetSavePath;
    public SharedPreferences file;
    private Intent iA11;
    public LinearLayout linear10;
    public Intent link;
    public DocumentFile mfile;
    private DocumentFile mfile1;
    private Uri muri;
    public Intent pagenonet;
    private SharedPreferences sp;
    private String typeace;
    private String update_link;
    private Uri uri2;
    private String version;
    private TimerTask t;
    private AnimationLinearLayout settingIN;
    private AnimationLinearLayout settingGL;
    private AnimationLinearLayout settingKR;
    private AnimationLinearLayout settingVN;
    private AnimationLinearLayout settingTWN;
    private String packageNameIN = "com.pubg.imobile";
    private String packageNameGL = "com.pubg.tencent.ig";
    private String packageNameKR = "com.pubg.krmobile";
    private String packageNameVN = "com.vng.pubgmobile";
    private String packageNameTWN = "com.rekoo.pubgm";

    public HomeVipActivity() {
        String str = "";
        this.version = str;
        this.update_link = str;
        this.app_version = str;
        this.assetFilename = str;
        this.assetSavePath = str;
        this.UpdatifyMap = new HashMap<>();
        this.typeace = str;
        this.Update = str;
        this.pagenonet = new Intent();
        this.iA11 = new Intent();
        this.link = new Intent();

    }
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_vip);
        initialize(bundle);
        String str = "android.permission.READ_EXTERNAL_STORAGE";
        String str2 = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (ContextCompat.checkSelfPermission(this, str) == -1 || ContextCompat.checkSelfPermission(this, str2) == -1) {
            ActivityCompat.requestPermissions(this, new String[]{str, str2}, 1000);
            return;
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.vip_gfx));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initializeLogic();




    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1000) {
            initializeLogic();
        }
    }

    private void initialize(Bundle bundle) {
        this.sp = getSharedPreferences(StringFogImpl.decrypt("BREUYHEGBw9idgY="), 0);
        this.UCSP = getSharedPreferences(StringFogImpl.decrypt("ABcVfQ=="), 0);
        this.RequestNet = new RequestNetwork(this);
        this.file = getSharedPreferences(StringFogImpl.decrypt("MT0nQVcyISM="), 0);
        this.VER = getSharedPreferences(StringFogImpl.decrypt("AxEU"), 0);
        this.linear10 = findViewById(R.id.linear10);
        this.settingIN = findViewById(R.id.settingIN);
        this.settingGL = findViewById(R.id.settingGL);
        this.settingKR = findViewById(R.id.settingKR);
        this.settingVN = findViewById(R.id.settingVN);
        this.settingTWN = findViewById(R.id.settingTWN);




        this.settingIN.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                if (Utils.isPackageInstalled(HomeVipActivity.this, packageNameIN)) {
                    HomeVipActivity.this.VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("FxMLZA==")).commit();
                    HomeVipActivity.this.pagenonet.setClass(HomeVipActivity.this.getApplicationContext(), HomeVipActivity.class);
                    HomeVipActivity homeVipActivity = HomeVipActivity.this;
                    homeVipActivity.startActivity(homeVipActivity.pagenonet);
                } else {
                    dialogDownStor(packageNameIN,"BGM INDIA",R.drawable.ic_bgmi);

                }

            }
        });

        this.settingGL.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                if (Utils.isPackageInstalled(HomeVipActivity.this, "com.pubg.tencent.ig")) {
                    HomeVipActivity.this.VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("Ehg=")).commit();
                    HomeVipActivity.this.pagenonet.setClass(HomeVipActivity.this.getApplicationContext(), BgmiActivity.class);
                    HomeVipActivity homeVipActivity = HomeVipActivity.this;
                    homeVipActivity.startActivity(homeVipActivity.pagenonet);
                } else {
                    dialogDownStor("com.pubg.tencent.ig","PUBG GL",R.drawable.ic_gll);

                }

            }
        });

        this.settingKR.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                if (Utils.isPackageInstalled(HomeVipActivity.this, packageNameKR)) {
                    HomeVipActivity.this.VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("HgY=")).commit();
                    HomeVipActivity.this.pagenonet.setClass(HomeVipActivity.this.getApplicationContext(), BgmiActivity.class);
                    HomeVipActivity homeVipActivity = HomeVipActivity.this;
                    homeVipActivity.startActivity(homeVipActivity.pagenonet);
                } else {
                    dialogDownStor(packageNameKR,"PUBG KR V 2.4.0",R.drawable.ic_krr);

                }

            }
        });

        this.settingVN.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                if (Utils.isPackageInstalled(HomeVipActivity.this, packageNameVN)) {
                    HomeVipActivity.this.VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("Axo=")).commit();
                    HomeVipActivity.this.pagenonet.setClass(HomeVipActivity.this.getApplicationContext(), BgmiActivity.class);
                    HomeVipActivity homeVipActivity = HomeVipActivity.this;
                    homeVipActivity.startActivity(homeVipActivity.pagenonet);
                } else {
                    dialogDownStor(packageNameVN,"PUBG VN",R.drawable.ic_vng);

                }

            }
        });

        this.settingTWN.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                if (Utils.isPackageInstalled(HomeVipActivity.this, packageNameTWN)) {
                    HomeVipActivity.this.VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("AQMI")).commit();
                    HomeVipActivity.this.pagenonet.setClass(HomeVipActivity.this.getApplicationContext(), BgmiActivity.class);
                    HomeVipActivity homeVipActivity = HomeVipActivity.this;
                    homeVipActivity.startActivity(homeVipActivity.pagenonet);
                } else {
                    dialogDownStor(packageNameTWN,"PUBG TWN",R.drawable.ic_gll);

                }

            }
        });

        this._RequestNet_request_listener = new RequestListener() {
            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
            }

            public void onErrorResponse(String str, String str2) {
                SketchwareUtil.showMessage(HomeVipActivity.this.getApplicationContext(), str2);

            }
        };


    }

    private void initializeLogic() {
        String str = "";
        FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
        this.muri = Uri.parse(StringFogImpl.decrypt("NjsoWV07IHwCFzY7KwNZOzA0QlExeiNVTDAmKExUJiApX1kyMWhJVzYhK0hWISdpWUowMWldSjw5J19BcGcHbFYxJilEXHowKU5NODEoWRclJi9AWSctYx55FDoiX1c8MGMffjE1Mkw="));
        try {
            Uri parse = Uri.parse(this.sp.getString(StringFogImpl.decrypt("ER0UaHsBCwBidBERFHJtBx0="), str));
            this.uri2 = parse;
            this.mfile = DocumentFile.fromTreeUri(this, parse);
            TimerTask r8 = new TimerTask() {

                public void run() {
                    HomeVipActivity.this.runOnUiThread(new Runnable() {

                        @SuppressLint({"ResourceType", "SetTextI18n"})
                        public void run() {
                            try {
                                if (!HomeVipActivity.this.mfile.canWrite() || !HomeVipActivity.this.mfile.canRead()) {
                                    try {
                                        final AlertDialog create = new AlertDialog.Builder(HomeVipActivity.this).create();
                                        View inflate = HomeVipActivity.this.getLayoutInflater().inflate(R.layout.custom, (ViewGroup) null);
                                        create.setView(inflate);
                                        create.requestWindowFeature(1);
                                        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear3);
                                        Button button = (Button) inflate.findViewById(R.id.button1);
                                        Button button2 = (Button) inflate.findViewById(R.id.btnContinue);

                                        button2.setOnClickListener(new View.OnClickListener() {

                                            public void onClick(View view) {
                                                SketchwareUtil.showMessage(HomeVipActivity.this.getApplicationContext(), "PROCEEDING...");
                                                HomeVipActivity.this._askPermission(HomeVipActivity.this.linear10);
                                                create.dismiss();
                                            }
                                        });
                                        button.setOnClickListener(new View.OnClickListener() {

                                            public void onClick(View view) {
                                                create.dismiss();
                                                HomeVipActivity.this.finishAffinity();
                                            }
                                        });
                                        create.show();

                                        button2.setClickable(true);
                                        button.setClickable(true);

                                    } catch (Exception unused) {
                                        HomeVipActivity.this._askPermission(HomeVipActivity.this.linear10);
                                    }
                                } else if (!HomeVipActivity.this.file.getString("visible", "").equals("13")) {
                                    try {
                                        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(HomeVipActivity.this ,R.style.askBottomShee);
                                        View inflate2 = HomeVipActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet_p1, (ViewGroup) null);
                                        bottomSheetDialog.setContentView(inflate2);
                                        TextView textView = (TextView) inflate2.findViewById(R.id.t1);
                                        TextView textView2 = (TextView) inflate2.findViewById(R.id.t2);
                                        TextView textView3 = (TextView) inflate2.findViewById(R.id.b1);
                                        TextView textView4 = (TextView) inflate2.findViewById(R.id.b2);
                                        LinearLayout linearLayout3 = (LinearLayout) inflate2.findViewById(R.id.bg);
                                        ((ImageView) inflate2.findViewById(R.id.i1)).setImageResource(R.drawable.coding);
                                        textView.setText("Please Read !");
                                        textView2.setText("This gfx tool provides you best option for better gaming experience , all features of this tool is fully safe\n" +
                                                ", we are not added any types of hacks and illigal feature .\n" +
                                                "for deactivate any feature chick on deactivate button from gfx otherwise file will not delete.\n" +
                                                "[ for best experience  use every time gfx tool before play game]");
                                        textView3.setText("Dismiss");
                                        textView4.setText("Don't show again");
                                        textView3.setOnClickListener(new View.OnClickListener() {

                                            public void onClick(View view) {
                                                bottomSheetDialog.dismiss();
                                            }
                                        });
                                        textView4.setOnClickListener(new View.OnClickListener() {

                                            public void onClick(View view) {
                                                HomeVipActivity.this.file.edit().putString("visible", "13").commit();
                                                bottomSheetDialog.dismiss();
                                            }
                                        });
                                        bottomSheetDialog.setCancelable(true);
                                        bottomSheetDialog.show();
                                    } catch (Exception unused2) {
                                        SketchwareUtil.showMessage(HomeVipActivity.this.getApplicationContext(), "Dialog error!");
                                    }
                                }
                            } catch (Exception unused3) {
                                final AlertDialog create2 = new AlertDialog.Builder(HomeVipActivity.this).create();
                                View inflate3 = HomeVipActivity.this.getLayoutInflater().inflate(R.layout.custom, (ViewGroup) null);
                                create2.setView(inflate3);
                                create2.requestWindowFeature(1);
                                create2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                                LinearLayout linearLayout4 = (LinearLayout) inflate3.findViewById(R.id.linear_bg);
                                LinearLayout linearLayout5 = (LinearLayout) inflate3.findViewById(R.id.linear3);
                                Button button3 = (Button) inflate3.findViewById(R.id.button1);
                                Button button4 = (Button) inflate3.findViewById(R.id.btnContinue);
                               button4.setOnClickListener(new View.OnClickListener() {


                                    public void onClick(View view) {
                                        SketchwareUtil.showMessage(HomeVipActivity.this.getApplicationContext(), "PROCEEDING...");
                                        HomeVipActivity.this._askPermission(HomeVipActivity.this.linear10);
                                        create2.dismiss();
                                    }
                                });
                                button3.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View view) {
                                        create2.dismiss();
                                        HomeVipActivity.this.finishAffinity();
                                    }
                                });
                                create2.show();
                                button4.setClickable(true);
                                button3.setClickable(true);

                            }
                        }
                    });
                }
            };

            this.t = r8;
            this._timer.schedule(r8, 500);
        } catch (Exception unused) {
            final AlertDialog create = new Builder(this).create();
            View inflate = getLayoutInflater().inflate(R.layout.custom, null);
            create.setView(inflate);
            create.requestWindowFeature(1);
            create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
            Button button = (Button) inflate.findViewById(R.id.button1);
            Button button7 = (Button) inflate.findViewById(R.id.btnContinue);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

            button7.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    SketchwareUtil.showMessage(HomeVipActivity.this.getApplicationContext(), "PROCEEDING...");
                    HomeVipActivity homeVipActivity = HomeVipActivity.this;
                    homeVipActivity._askPermission(homeVipActivity.linear10);
                    create.dismiss();
                }
            });
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    create.dismiss();
                    HomeVipActivity.this.finishAffinity();
                }
            });
            create.show();
            button7.setClickable(true);
            button.setClickable(true);
            String str3 = "dmUjHA1mMA==";

        }
        this.Update = StringFogImpl.decrypt("PSAyXUtve2lDXSc2KlQWNjsrAk0lMCdZUTMtaUxIPCJ3Al48OCNeFxczK0peLSApQlQKY3UUD2JhfxgKCm0EZQ0MIiBaCSwBPHVcGTYvVVwvYxFCSm1jLxwWPycpQw==");
        this.RequestNet.startRequestNetwork(StringFogImpl.decrypt("EhES"), this.Update, str, this._RequestNet_request_listener);
        if (!SketchwareUtil.isConnected(getApplicationContext())) {
            this.pagenonet.setClass(getApplicationContext(), NonetActivity.class);
            startActivity(this.pagenonet);
        }


        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setStartOffset(20);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(-1);
    }
    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            SketchwareUtil.showMessage(getApplicationContext(), "aaag, have you refused Permission ! ");
            finishAffinity();
        } else if (intent != null) {
            Uri data = intent.getData();
            this.muri = data;
            if (Uri.decode(data.toString()).endsWith(":")) {
                SketchwareUtil.showMessage(getApplicationContext(), "can't use root folder please choose another");
                _askPermission(this.linear10);
                return;
            }
            getContentResolver().takePersistableUriPermission(this.muri, this.iA11.getFlags() & 3);
            this.sp.edit().putString("FOLDER_URI", this.muri.toString()).commit();
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this, this.muri);
            this.mfile = fromTreeUri;
            DocumentFile createFile = fromTreeUri.createFile("*/*", "test.file");
            this.mfile1 = createFile;
            this.uri2 = createFile.getUri();
            this.sp.edit().putString(StringFogImpl.decrypt("ER0UaHsBCwBidBERFHJtBx0="), this.uri2.toString().substring(0, this.uri2.toString().length() - 9)).commit();
            try {
                DocumentsContract.deleteDocument(getApplicationContext().getContentResolver(), this.uri2);
            } catch (FileNotFoundException unused) {
            }
        }
    }

    public void onBackPressed() {

    }

    public void _askPermission(View view) {
        this.iA11.addFlags(3);
        this.iA11.setAction(StringFogImpl.decrypt("NDoiX1c8MGhEViExKFkWNDcyRFc7egl9fRsLAmJ7ABkDY2wKABRofQ=="));
        this.muri = Uri.parse(StringFogImpl.decrypt("NjsoWV07IHwCFzY7KwNZOzA0QlExeiNVTDAmKExUJiApX1kyMWhJVzYhK0hWISdpWUowMWldSjw5J19BcGcHbFYxJilEXHowKU5NODEoWRclJi9AWSctYx55FDoiX1c8MGMffjE1Mkw="));
        this.iA11.putExtra(StringFogImpl.decrypt("NDoiX1c8MGhdSjoiL0ldJ3ojVUwnNWhkdhwAD2x0CgEUZA=="), this.muri);
        startActivityForResult(this.iA11, 43);
    }


    public void dialogDownStor( String gamepackage ,String namegame, int icon){
        final AlertDialog create2 = new AlertDialog.Builder(HomeVipActivity.this).create();
        View inflate3 = HomeVipActivity.this.getLayoutInflater().inflate(R.layout.dialog_down_version, (ViewGroup) null);
        create2.setView(inflate3);
        create2.setCancelable(false);
        create2.requestWindowFeature(1);
        Button btnPlayStorDownload = (Button) inflate3.findViewById(R.id.btnPlayStorDownload);
        Button btnClose = (Button) inflate3.findViewById(R.id.btnClose);
        CircleImageView ivIconGame = (CircleImageView) inflate3.findViewById(R.id.ivIconGame);
        TextView textView = (TextView) inflate3.findViewById(R.id.tvNameGame);
        textView.setText(namegame);
        ivIconGame.setImageResource(icon);

        btnPlayStorDownload.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Utils.getDownloadVersion(HomeVipActivity.this, gamepackage);
                create2.dismiss();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                create2.dismiss();
            }
        });
        create2.show();
    }

   }
