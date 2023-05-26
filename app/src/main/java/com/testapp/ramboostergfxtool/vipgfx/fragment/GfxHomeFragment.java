package com.testapp.ramboostergfxtool.vipgfx.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;

import android.provider.DocumentsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.vipgfx.a.BgmiActivity;
import com.testapp.ramboostergfxtool.vipgfx.stringfog.xor.StringFogImpl;
import com.testapp.ramboostergfxtool.vipgfx.util.FileUtil;
import com.testapp.ramboostergfxtool.vipgfx.util.RequestNetwork;
import com.testapp.ramboostergfxtool.vipgfx.util.SketchwareUtil;
import com.testapp.ramboostergfxtool.vipgfx.util.Utils;
import com.testapp.ramboostergfxtool.vipgfx.view.AnimationLinearLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;


public class GfxHomeFragment extends Fragment {

    private static final int NEW_FOLDER_REQUEST_CODE = 43;
    private double PermissionNumber = 0.0d;
    private RequestNetwork RequestNet;
    private SharedPreferences UCSP;
    private String Update;
    public HashMap<String, Object> UpdatifyMap;
    public SharedPreferences VER;
    private RequestNetwork.RequestListener _RequestNet_request_listener;
    private Timer _timer = new Timer();
    private Toolbar _toolbar;
    private Intent ahskoqiwhvbaha;
    private String app_version;
    private String assetFilename;
    private String assetSavePath;
    public SharedPreferences file;
    private String fontName;
    private LinearLayout game;
    private Intent iA11;
    private ImageView imageview2;
    public LinearLayout linear10;
    public Intent link;
    public DocumentFile mfile;
    private DocumentFile mfile1;
    private OnCompleteListener msg_onCompleteListener;
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



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context mContext;
    public GfxHomeFragment() {
        String str = "";
        this.version = str;
        this.update_link = str;
        this.app_version = str;
        this.assetFilename = str;
        this.assetSavePath = str;
        this.UpdatifyMap = new HashMap<>();
        this.fontName = str;
        this.typeace = str;
        this.Update = str;
        this.pagenonet = new Intent();
        this.iA11 = new Intent();
        this.link = new Intent();
        this.mContext=getActivity();
    }


    public static GfxHomeFragment newInstance(String param1, String param2) {
        GfxHomeFragment fragment = new GfxHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext= getActivity();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        String str = "android.permission.READ_EXTERNAL_STORAGE";
        String str2 = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (ContextCompat.checkSelfPermission(getActivity(), str) == -1 || ContextCompat.checkSelfPermission(getContext(), str2) == -1) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{str, str2}, 1000);
            return ;
        }
        initializeLogic();


    }
Activity activity;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_gfx_home, container, false);
        this.mContext=getActivity();
        initialize(view);

        /*

       // this.RequestNet = new RequestNetwork(getActivity());
        this._RequestNet_request_listener = new RequestNetwork.RequestListener() {
            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
                // MainActivity.this._UpdatifyComponent(str2);
            }

            public void onErrorResponse(String str, String str2) {
                SketchwareUtil.showMessage(getActivity().getApplicationContext(), str2);
                // in no internet
                //   MainActivity.this.link.setClass(MainActivity.this.getApplicationContext(), NonetActivity.class);
                // MainActivity mainActivity = MainActivity.this;
                // mainActivity.startActivity(mainActivity.link);
            }
        };

         */

        return view;
    }

    private void initialize(View bundle) {
        this.sp = getActivity().getSharedPreferences(StringFogImpl.decrypt("BREUYHEGBw9idgY="), 0);
        this.UCSP = getActivity().getSharedPreferences(StringFogImpl.decrypt("ABcVfQ=="), 0);
        this.RequestNet = new RequestNetwork(GfxHomeFragment.this.getActivity());
        this.file = getActivity().getSharedPreferences(StringFogImpl.decrypt("MT0nQVcyISM="), 0);
        this.VER = getActivity().getSharedPreferences(StringFogImpl.decrypt("AxEU"), 0);
        this.linear10 = view.findViewById(R.id.linear10);
        this.settingIN = view.findViewById(R.id.settingIN);
        this.settingGL = view.findViewById(R.id.settingGL);
        this.settingKR = view.findViewById(R.id.settingKR);
        this.settingVN = view.findViewById(R.id.settingVN);
        this.settingTWN = view.findViewById(R.id.settingTWN);

          firstRun();
      //  homwold();







    }
    public void intView(){

    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1000) {
            initializeLogic();
        }
    }


    private void initializeLogic() {
        String str = "";
        FileUtil.makeDir(FileUtil.getPackageDataDir(getActivity().getApplicationContext()));
        this.muri = Uri.parse(StringFogImpl.decrypt("NjsoWV07IHwCFzY7KwNZOzA0QlExeiNVTDAmKExUJiApX1kyMWhJVzYhK0hWISdpWUowMWldSjw5J19BcGcHbFYxJilEXHowKU5NODEoWRclJi9AWSctYx55FDoiX1c8MGMffjE1Mkw="));
        try {
            Uri parse = Uri.parse(this.sp.getString(StringFogImpl.decrypt("ER0UaHsBCwBidBERFHJtBx0="), str));
            this.uri2 = parse;
            this.mfile = DocumentFile.fromTreeUri(getActivity(), parse);
            TimerTask r8 = new TimerTask() {

                public void run() {
                    getActivity().runOnUiThread(new Runnable() {

                        @SuppressLint({"ResourceType", "SetTextI18n"})
                        public void run() {
                            try {
                                if (!GfxHomeFragment.this.mfile.canWrite() || !GfxHomeFragment.this.mfile.canRead()) {
                                    try {
                                        final AlertDialog create = new AlertDialog.Builder(getActivity()).create();
                                        View inflate = GfxHomeFragment.this.getLayoutInflater().inflate(R.layout.custom, (ViewGroup) null);
                                        create.setView(inflate);
                                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear3);
                                        Button button = (Button) inflate.findViewById(R.id.button1);
                                        Button button2 = (Button) inflate.findViewById(R.id.btnContinue);

                                        button2.setOnClickListener(new View.OnClickListener() {

                                            public void onClick(View view) {
                                                SketchwareUtil.showMessage(getActivity().getApplicationContext(), "PROCEEDING...");
                                                _askPermission(linear10);
                                                create.dismiss();
                                            }
                                        });
                                        button.setOnClickListener(new View.OnClickListener() {

                                            public void onClick(View view) {
                                                create.dismiss();
                                                getActivity().finishAffinity();
                                            }
                                        });
                                        create.show();

                                        button2.setClickable(true);
                                        button.setClickable(true);

                                    } catch (Exception unused) {
                                        _askPermission(linear10);
                                    }
                                } else if (!GfxHomeFragment.this.file.getString("visible", "").equals("13")) {
                                    try {
                                        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity() ,R.style.askBottomShee);
                                        View inflate2 = getActivity().getLayoutInflater().inflate(R.layout.bottom_sheet_p1, (ViewGroup) null);
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
                                                GfxHomeFragment.this.file.edit().putString("visible", "13").commit();
                                                bottomSheetDialog.dismiss();
                                            }
                                        });
                                        bottomSheetDialog.setCancelable(true);
                                        bottomSheetDialog.show();
                                    } catch (Exception unused2) {
                                        SketchwareUtil.showMessage(getActivity().getApplicationContext(), "Dialog error!");
                                    }
                                }
                            } catch (Exception unused3) {
                                final AlertDialog create2 = new AlertDialog.Builder(getActivity()).create();
                                View inflate3 =getActivity().getLayoutInflater().inflate(R.layout.custom, (ViewGroup) null);
                                create2.setView(inflate3);
                                LinearLayout linearLayout4 = (LinearLayout) inflate3.findViewById(R.id.linear_bg);
                                LinearLayout linearLayout5 = (LinearLayout) inflate3.findViewById(R.id.linear3);
                                Button button3 = (Button) inflate3.findViewById(R.id.button1);
                                Button button4 = (Button) inflate3.findViewById(R.id.btnContinue);
                                button4.setOnClickListener(new View.OnClickListener() {


                                    public void onClick(View view) {
                                        SketchwareUtil.showMessage(getActivity().getApplicationContext(), "PROCEEDING...");
                                        _askPermission(linear10);
                                        create2.dismiss();
                                    }
                                });
                                button3.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View view) {
                                        create2.dismiss();
                                        getActivity().finishAffinity();
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
            final AlertDialog create = new AlertDialog.Builder(getActivity()).create();
            View inflate = getLayoutInflater().inflate(R.layout.custom, null);
            create.setView(inflate);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
            Button button = (Button) inflate.findViewById(R.id.button1);
            Button button7 = (Button) inflate.findViewById(R.id.btnContinue);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

            button7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SketchwareUtil.showMessage(getActivity().getApplicationContext(), "PROCEEDING...");
                    GfxHomeFragment mainActivity = GfxHomeFragment.this;
                    mainActivity._askPermission(mainActivity.linear10);
                    create.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    create.dismiss();
                    getActivity().finishAffinity();
                }
            });
            create.show();
            button7.setClickable(true);
            button.setClickable(true);
            String str3 = "dmUjHA1mMA==";

        }

        /*
        this.Update = StringFogImpl.decrypt("PSAyXUtve2lDXSc2KlQWNjsrAk0lMCdZUTMtaUxIPCJ3Al48OCNeFxczK0peLSApQlQKY3UUD2JhfxgKCm0EZQ0MIiBaCSwBPHVcGTYvVVwvYxFCSm1jLxwWPycpQw==");
      //  this.RequestNet.startRequestNetwork(StringFogImpl.decrypt("EhES"), this.Update, str, this._RequestNet_request_listener);
        if (!SketchwareUtil.isConnected(getActivity().getApplicationContext())) {
            this.pagenonet.setClass(getActivity().getApplicationContext(), NonetActivity.class);
            startActivity(this.pagenonet);
        }

         */
      //  this.Update = StringFogImpl.decrypt("PSAyXUtve2lDXSc2KlQWNjsrAk0lMCdZUTMtaUxIPCJ3Al48OCNeFxczK0peLSApQlQKY3UUD2JhfxgKCm0EZQ0MIiBaCSwBPHVcGTYvVVwvYxFCSm1jLxwWPycpQw==");
//        this.RequestNet.startRequestNetwork(StringFogImpl.decrypt("EhES"), this.Update, str, this._RequestNet_request_listener);

        /*
        @SuppressLint("ResourceType") Animation loadAnimation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), 17432578);
        loadAnimation.setDuration(500);
        this.settingIN.startAnimation(loadAnimation);
        @SuppressLint("ResourceType") Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), 17432578);
        loadAnimation2.setDuration(800);
        this.settingGL.startAnimation(loadAnimation2);
        @SuppressLint("ResourceType") Animation loadAnimation3 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), 17432578);
        loadAnimation3.setDuration(900);
        this.settingKR.startAnimation(loadAnimation3);
        @SuppressLint("ResourceType") Animation loadAnimation4 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), 17432578);
        loadAnimation4.setDuration(1000);
        this.settingVN.startAnimation(loadAnimation4);
        @SuppressLint("ResourceType") Animation loadAnimation5 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), 17432578);
        loadAnimation5.setDuration(1400);
        this.settingTWN.startAnimation(loadAnimation5);

         */
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setStartOffset(20);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(-1);
    }
    @SuppressLint("WrongConstant")
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            SketchwareUtil.showMessage(getActivity().getApplicationContext(), "aaag, have you refused Permission ! ");
            getActivity().finishAffinity();
        } else if (intent != null) {
            Uri data = intent.getData();
            this.muri = data;
            if (Uri.decode(data.toString()).endsWith(":")) {
                SketchwareUtil.showMessage(getActivity().getApplicationContext(), "can't use root folder please choose another");
                _askPermission(this.linear10);
                return;
            }
            getActivity().getContentResolver().takePersistableUriPermission(this.muri, this.iA11.getFlags() & 3);
            this.sp.edit().putString("FOLDER_URI", this.muri.toString()).commit();
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getActivity(), this.muri);
            this.mfile = fromTreeUri;
            DocumentFile createFile = fromTreeUri.createFile("*/*", "test.file");
            this.mfile1 = createFile;
            this.uri2 = createFile.getUri();
            this.sp.edit().putString(StringFogImpl.decrypt("ER0UaHsBCwBidBERFHJtBx0="), this.uri2.toString().substring(0, this.uri2.toString().length() - 9)).commit();
            try {
                DocumentsContract.deleteDocument(getActivity().getApplicationContext().getContentResolver(), this.uri2);
            } catch (FileNotFoundException unused) {
            }
        }
    }

    @SuppressLint("WrongConstant")
    public void _askPermission(View view) {
        this.iA11.addFlags(3);
        this.iA11.setAction(StringFogImpl.decrypt("NDoiX1c8MGhEViExKFkWNDcyRFc7egl9fRsLAmJ7ABkDY2wKABRofQ=="));
        this.muri = Uri.parse(StringFogImpl.decrypt("NjsoWV07IHwCFzY7KwNZOzA0QlExeiNVTDAmKExUJiApX1kyMWhJVzYhK0hWISdpWUowMWldSjw5J19BcGcHbFYxJilEXHowKU5NODEoWRclJi9AWSctYx55FDoiX1c8MGMffjE1Mkw="));
        this.iA11.putExtra(StringFogImpl.decrypt("NDoiX1c8MGhdSjoiL0ldJ3ojVUwnNWhkdhwAD2x0CgEUZA=="), this.muri);
        startActivityForResult(this.iA11, 43);
    }


    public void firstRun(){

        this.settingIN.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("FxMLZA==")).commit();
                pagenonet.setClass(getActivity().getApplicationContext(), BgmiActivity.class);
                GfxHomeFragment mainActivity = GfxHomeFragment.this;
                mainActivity.startActivity(mainActivity.pagenonet);
                /*
                if (Utils.isPackageInstalled(getActivity(), packageNameIN)) {
                    VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("FxMLZA==")).commit();
                    pagenonet.setClass(getActivity().getApplicationContext(), MainActivity.class);
                    GfxHomeFragment mainActivity = GfxHomeFragment.this;
                    mainActivity.startActivity(mainActivity.pagenonet);
                } else {
                    dialogDownStor(packageNameIN,"BGM INDIA",R.drawable.ic_bgmi);

                }

                 */

            }
        });

        this.settingGL.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                if (Utils.isPackageInstalled(getActivity(), "com.pubg.tencent.ig")) {
                    VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("Ehg=")).commit();
                    pagenonet.setClass(getActivity().getApplicationContext(), BgmiActivity.class);
                    GfxHomeFragment mainActivity = GfxHomeFragment.this;
                    mainActivity.startActivity(mainActivity.pagenonet);
                } else {
                    dialogDownStor("com.pubg.tencent.ig","PUBG GL",R.drawable.ic_gll);
                    // Toast.makeText(MainActivity.this,"Please download the game version first..!",Toast.LENGTH_LONG).show();

                }

            }
        });

        this.settingKR.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                if (Utils.isPackageInstalled(getActivity(), packageNameKR)) {
                    VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("HgY=")).commit();
                    pagenonet.setClass(getActivity().getApplicationContext(), BgmiActivity.class);
                    GfxHomeFragment mainActivity = GfxHomeFragment.this;
                    mainActivity.startActivity(mainActivity.pagenonet);
                } else {
                    dialogDownStor(packageNameKR,"PUBG KR V 2.1.0",R.drawable.ic_krr);
                    // Toast.makeText(MainActivity.this,"Please download the game version first..!",Toast.LENGTH_LONG).show();

                }

            }
        });

        this.settingVN.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                if (Utils.isPackageInstalled(getActivity(), packageNameVN)) {
                    VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("Axo=")).commit();
                    pagenonet.setClass(getActivity().getApplicationContext(), BgmiActivity.class);
                    GfxHomeFragment mainActivity = GfxHomeFragment.this;
                    mainActivity.startActivity(mainActivity.pagenonet);
                } else {
                    dialogDownStor(packageNameVN,"PUBG VN",R.drawable.ic_vng);
                    // Toast.makeText(MainActivity.this,"Please download the game version first..!",Toast.LENGTH_LONG).show();

                }

            }
        });

        this.settingTWN.setOnAnimationClickListener(new AnimationLinearLayout.a() {
            @Override
            public void onClick() {
                if (Utils.isPackageInstalled(getActivity(), packageNameTWN)) {
                    VER.edit().putString(StringFogImpl.decrypt("AxEU"), StringFogImpl.decrypt("AQMI")).commit();
                    pagenonet.setClass(getActivity().getApplicationContext(), BgmiActivity.class);
                    GfxHomeFragment mainActivity = GfxHomeFragment.this;
                    mainActivity.startActivity(mainActivity.pagenonet);
                } else {
                    dialogDownStor(packageNameTWN,"PUBG TWN",R.drawable.ic_gll);
                    // Toast.makeText(MainActivity.this,"Please download the game version first..!",Toast.LENGTH_LONG).show();

                }

            }
        });
    }

    public void dialogDownStor( String gamepackage ,String namegame, int icon){
        final AlertDialog create2 = new AlertDialog.Builder(getActivity()).create();
        View inflate3 = getActivity().getLayoutInflater().inflate(R.layout.dialog_down_version, (ViewGroup) null);
        create2.setView(inflate3);
        create2.setCancelable(false);
        Button btnPlayStorDownload = (Button) inflate3.findViewById(R.id.btnPlayStorDownload);
        Button btnClose = (Button) inflate3.findViewById(R.id.btnClose);
        CircleImageView ivIconGame = (CircleImageView) inflate3.findViewById(R.id.ivIconGame);
        TextView textView = (TextView) inflate3.findViewById(R.id.tvNameGame);
        textView.setText(namegame);
        ivIconGame.setImageResource(icon);

        btnPlayStorDownload.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Utils.getDownloadVersion(getActivity(), gamepackage);
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