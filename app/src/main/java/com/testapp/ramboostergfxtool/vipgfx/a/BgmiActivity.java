package com.testapp.ramboostergfxtool.vipgfx.a;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.BounceInterpolator;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.vipgfx.activity.NonetActivity;
import com.testapp.ramboostergfxtool.vipgfx.service.foregroundService;
import com.testapp.ramboostergfxtool.vipgfx.util.FileUtil;
import com.testapp.ramboostergfxtool.vipgfx.util.RequestNetwork;
import com.testapp.ramboostergfxtool.vipgfx.util.RequestNetwork.RequestListener;
import com.testapp.ramboostergfxtool.vipgfx.util.SketchwareUtil;
import com.example.iosprogressbarforandroid.IOSProgressHUD;
import com.example.iosprogressbarforandroid.IOSProgressHUD.Style;
import com.testapp.ramboostergfxtool.vipgfx.stringfog.xor.StringFogImpl;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import org.apache.http.HttpStatus;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class BgmiActivity extends AppCompatActivity {
    public TimerTask t;
    public TimerTask t2;
    public String ADSS;
    public double Ads;
    public Builder D;
    public SharedPreferences DOWNLOAD;
    public String FILE_NAME;
    public IOSProgressHUD HUD;
    public String INSTAGRAM;
    public String Max;
    private String NO_USE;
    private DocumentFile New;
    private DocumentFile New2;
    public String No_loading;
    private TextView OverAllRamUse_Title;
    private double PermissionNumber = 0.0d;
    private SharedPreferences RATING;
    public String Telegram;
    private SharedPreferences UCSP;
    public HashMap<String, Object> UpdatifyMap;
    private SharedPreferences VER;
    public String YT;
    public String ZIPNAME;
    public RequestListener _net_request_listener;
    public Timer _timer = new Timer();
    private RequestListener _update_request_listener;
    private FrameLayout ads;
    private TimerTask adss;
    public boolean aBooleanDown;
    private MaterialButton btnActivate;
    private MaterialButton btnDeactivate;
    public MaterialButton btnStartGfx;
    private Calendar c;
    private View displayView;
    public String filename;
    private String fontName;
    private Button gone;
    public Intent i;
    private String id_inter;
    public Intent ihome;
    private ImageView imageview10;
    private ImageView imageview11;
    private ImageView imageview13;
    private ImageView imageview14;
    private ImageView imageview15;
    private ImageView imageview16;
    private ImageView imageview17;
    private ImageView imageview18;
    private ImageView imageview19;
    private ImageView imageview20;
    private ImageView imageview21;
    private ImageView imageview22;
    private ImageView imageview31;
    private ImageView imageview34;
    private ImageView imageview35;
    private ImageView imageview36;
    private ImageView imageview37;
    private ImageView imageview38;
    private ImageView imageview39;
    private ImageView imageview40;
    private ImageView imageview42;
    private ImageView imageview43;
    private ImageView imageview8;
    private ImageView imageview9;
    private ImageView imageview_Boost;
    public LayoutParams layoutParams;
    private LinearLayout linear18;
    private LinearLayout linear19;
    private LinearLayout linear50;
    private LinearLayout linear_boost_bg;
    public Intent link;
    public double mem_max;
    public double mem_usage;
    private DocumentFile mfile;
    private DocumentFile mfile1;
    private String mime;
    public double ms;
    public RequestNetwork net;
    private DocumentFile newFile;
    private ObjectAnimator o;
    private ObjectAnimator o1;
    public String ok;
    public String out;
    public String packageName;
    private String package_name;
    public String path;
    private String path1;
    public TimerTask ping;
    public String prolink;
    public String result;
    private Intent serviceIntent;
    public double size;
    public SharedPreferences sp;
    private Spinner spinner2;
    private Spinner spinner3;
    public boolean startConnect;
    public double sumCount;
    public RadioButton switch1;
    public RadioButton switch10;
    public RadioButton switch21;
    public RadioButton switch22;
    public RadioButton switch23;
    public RadioButton switch24;
    public RadioButton switch25;
    public RadioButton switch26;
    public RadioButton switch27;
    public RadioButton switch28;
    public RadioButton switch35;
    public RadioButton switch36;
    public RadioButton switch4;
    public RadioButton switch40;
    public RadioButton switch41;
    public RadioButton switch42;
    public RadioButton switch43;
    public RadioButton switch44;
    private RadioButton switch45;
    public RadioButton switch46;
    public RadioButton switch47;
    public RadioButton switch48;
    public RadioButton switch49;
    public RadioButton switch50;
    public RadioButton switch51;
    public RadioButton switch52;
    public RadioButton switch53;
    public RadioButton switch54;
    public RadioButton switch55;
    public RadioButton switch6;
    public TimerTask t3;
    private TextView textview19;
    private TextView textview21;
    private TextView textview24;
    private TextView tvVersionGame;
    private String typeace;
    private RequestNetwork update;
    private String updatify;
    public Uri uri1;
    public Uri uri10;
    public Uri uri2;
    public Uri uri3;
    public Uri uri4;
    public Uri uri5;
    public Uri uri6;
    public Uri uri9;
    public WindowManager windowManager;
    private String zipFileName;

    static SharedPreferences A(BgmiActivity var0) {
        return var0.DOWNLOAD;
    }
    static SharedPreferences B(BgmiActivity var0) {
        return var0.sp;
    }
    static String C(BgmiActivity var0) {
        return var0.packageName;
    }
    static void D(BgmiActivity var0, Uri var1) {
        var0.uri2 = var1;
    }
    static Uri E(BgmiActivity var0) {
        return var0.uri2;
    }
    static boolean F(BgmiActivity var0) {
        return var0.aBooleanDown;
    }
    static void G(BgmiActivity var0, Uri var1) {
        var0.uri1 = var1;
    }
    static Uri H(BgmiActivity var0) {
        return var0.uri1;
    }
    static void I(BgmiActivity var0, Uri var1) {
        var0.uri3 = var1;
    }
    static Uri J(BgmiActivity var0) {
        return var0.uri3;
    }
    static void K(BgmiActivity var0, Uri var1) {
        var0.uri4 = var1;
    }
    static Uri L(BgmiActivity var0) {
        return var0.uri4;
    }
    static void M(BgmiActivity var0, Uri var1) {
        var0.uri5 = var1;
    }
    static Uri N(BgmiActivity var0) {
        return var0.uri5;
    }
    static void O(BgmiActivity var0, Uri var1) {
        var0.uri6 = var1;
    }
    static Uri P(BgmiActivity var0) {
        return var0.uri6;
    }
    static void Q(BgmiActivity var0, boolean var1) {
        var0.aBooleanDown = var1;
    }
    static Intent R(BgmiActivity var0) {
        return var0.ihome;
    }

    private class DownloadTask extends AsyncTask<String, Integer, String> {
        private DownloadTask() {
        }

        DownloadTask(BgmiActivity bgmiActivity, DownloadTask downloadTask) {
            this();
        }

        public void onPreExecute() {
            try {
                BgmiActivity bgmiActivity = BgmiActivity.this;
                bgmiActivity.HUD = IOSProgressHUD.create(bgmiActivity).setStyle(Style.ANNULAR_DETERMINATE).setLabel(StringFogImpl.decrypt("BRgDbGsQdBFscQE=")).setCancellable(true).setMaxProgress(100).show();
                BgmiActivity.this.HUD.setCancellable(false);
                BgmiActivity.this._fore();
            } catch (Exception unused) {
                BgmiActivity.this.DOWNLOAD.edit().remove(BgmiActivity.this.ZIPNAME).commit();
                SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("EAYUYmp1GwgNfBoDCGF3FBAPY38="));
            }
        }

        public String doInBackground(String... strArr) {
            FileOutputStream fileOutputStream = null;
            String str = "";
            try {
                InputStream inputStream = null;
                BgmiActivity.this.filename = URLUtil.guessFileName(strArr[0], null, null);
                URLConnection openConnection = new URL(strArr[0]).openConnection();
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    httpURLConnection.setAllowUserInteraction(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestMethod(StringFogImpl.decrypt("EhES"));
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        BgmiActivity.this.size = (double) httpURLConnection.getContentLength();
                    } else {
                        BgmiActivity.this.result = StringFogImpl.decrypt("ATwjX111IydeGDQ6ZkhKJzs0");
                    }
                    BgmiActivity bgmiActivity = BgmiActivity.this;
                    bgmiActivity.path = FileUtil.getPackageDataDir(bgmiActivity.getApplicationContext()).concat("/".concat(BgmiActivity.this.ZIPNAME));
                    FileUtil.writeFile(BgmiActivity.this.path, str);
                    fileOutputStream = new FileOutputStream(new File(BgmiActivity.this.path));
                    BgmiActivity.this.sumCount = 0.0d;
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        BgmiActivity bgmiActivity2 = BgmiActivity.this;
                        bgmiActivity2.sumCount = bgmiActivity2.sumCount + ((double) read);
                        if (BgmiActivity.this.size > 0.0d) {
                            publishProgress(new Integer[]{Integer.valueOf((int) Math.round((BgmiActivity.this.sumCount * 100.0d) / BgmiActivity.this.size))});
                        }
                    }
                    fileOutputStream.close();
                    BgmiActivity.this.result = str;
                    inputStream.close();
                    return BgmiActivity.this.result;
                }
                throw new IOException(StringFogImpl.decrypt("AAYKDVEmdChCTHU1KA1wISA2DW0HGA=="));
            } catch (MalformedURLException e) {
                BgmiActivity.this.result = e.getMessage();
            } catch (IOException e2) {
                BgmiActivity.this.result = e2.getMessage();
            } catch (Exception e3) {
                BgmiActivity.this.result = e3.toString();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                throw th;
            }
            return str;
        }

        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            try {
                BgmiActivity.this.HUD.setProgress(numArr[numArr.length - 1].intValue());
                BgmiActivity.this.HUD.setDetailsLabel(String.valueOf((long) numArr[numArr.length - 1].intValue()).concat(StringFogImpl.decrypt("cHQCYm8bGAlsfA==")));
            } catch (Exception unused) {
                BgmiActivity.this.HUD.dismiss();
                SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("BQYJbn0GBw9jf3Q="));
            }
        }

        public void onPostExecute(String str) {
            try {
                SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("ERsRY3QaFQINexoZFmF9AREC"));
                BgmiActivity.this.HUD.dismiss();
                BgmiActivity.this._fore2();
                BgmiActivity.this.DOWNLOAD.edit().putString(BgmiActivity.this.ZIPNAME, "OK").commit();
            } catch (Exception unused) {
                BgmiActivity.this.DOWNLOAD.edit().remove(BgmiActivity.this.ZIPNAME).commit();
                SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("EAYUYmp1GwgNbRsOD30="));
            }
        }
    }

    private class FloatingOnTouchListener implements OnTouchListener {
        private int x;
        private int y;

        private FloatingOnTouchListener() {
        }

        FloatingOnTouchListener(BgmiActivity bgmiActivity, FloatingOnTouchListener floatingOnTouchListener) {
            this();
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.x = (int) motionEvent.getRawX();
                this.y = (int) motionEvent.getRawY();
            } else if (action == 2) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int i = rawX - this.x;
                int i2 = rawY - this.y;
                this.x = rawX;
                this.y = rawY;
                BgmiActivity.this.layoutParams.x += i;
                BgmiActivity.this.layoutParams.y += i2;
                BgmiActivity.this.windowManager.updateViewLayout(view, BgmiActivity.this.layoutParams);
            }
            return true;
        }
    }

    public void _extra() {
    }

    public BgmiActivity() {
        String str = "";
        this.mime = str;
        this.zipFileName = str;
        this.Max = str;
        this.fontName = str;
        this.typeace = str;
        this.packageName = str;
        this.ZIPNAME = str;
        this.aBooleanDown = false;
        this.FILE_NAME = str;
        this.filename = str;
        this.size = 0.0d;
        this.sumCount = 0.0d;
        this.result = str;
        this.path = str;
        this.path1 = str;
        this.UpdatifyMap = new HashMap<>();
        this.updatify = str;
        this.Telegram = str;
        this.INSTAGRAM = str;
        this.YT = str;
        this.id_inter = str;
        this.ok = str;
        this.prolink = str;
        this.No_loading = str;
        this.Ads = 0.0d;
        this.startConnect = false;
        this.ms = 0.0d;
        this.mem_usage = 0.0d;
        this.out = str;
        this.mem_max = 0.0d;
        this.ADSS = str;
        this.NO_USE = str;
        this.package_name = str;
        this.ihome = new Intent();
        this.link = new Intent();
        this.o = new ObjectAnimator();
        this.serviceIntent = new Intent();
        this.i = new Intent();
        this.o1 = new ObjectAnimator();
        this.c = Calendar.getInstance();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_vip_gfx);
        initialize(bundle);

        String str = "android.permission.READ_EXTERNAL_STORAGE";
        String str2 = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (ContextCompat.checkSelfPermission(this, str) == -1 || ContextCompat.checkSelfPermission(this, str2) == -1) {
            ActivityCompat.requestPermissions(this, new String[]{str, str2}, 1000);
            return;
        }
        initializeLogic();


    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1000) {
            initializeLogic();
        }
    }

    private void initialize(Bundle bundle) {

        initToolbar();
        this.linear50 = (LinearLayout) findViewById(R.id.linear50);
        this.tvVersionGame = (TextView) findViewById(R.id.tv_VersionGame);
        this.linear_boost_bg = (LinearLayout) findViewById(R.id.linear_boost_bg);
        this.imageview_Boost = (ImageView) findViewById(R.id.imageview_Boost);
        this.spinner2 = (Spinner) findViewById(R.id.spinner2);
        this.spinner3 = (Spinner) findViewById(R.id.spinner3);
        this.ads = (FrameLayout) findViewById(R.id.ads);
        this.switch24 = (RadioButton) findViewById(R.id.switch24);
        this.imageview8 = (ImageView) findViewById(R.id.imageview8);
        this.switch6 = (RadioButton) findViewById(R.id.switch6);
        this.imageview9 = (ImageView) findViewById(R.id.imageview9);
        this.switch23 = (RadioButton) findViewById(R.id.switch23);
        this.imageview10 = (ImageView) findViewById(R.id.imageview10);
        this.switch1 = (RadioButton) findViewById(R.id.switch1);
        this.imageview16 = (ImageView) findViewById(R.id.imageview16);
        this.switch40 = (RadioButton) findViewById(R.id.switch40);
        this.switch25 = (RadioButton) findViewById(R.id.switch25);
        this.imageview11 = (ImageView) findViewById(R.id.imageview11);
        this.switch26 = (RadioButton) findViewById(R.id.switch26);
        this.imageview13 = (ImageView) findViewById(R.id.imageview13);
        this.switch27 = (RadioButton) findViewById(R.id.switch27);
        this.imageview14 = (ImageView) findViewById(R.id.imageview14);
        this.switch28 = (RadioButton) findViewById(R.id.switch28);
        this.imageview15 = (ImageView) findViewById(R.id.imageview15);
        this.switch41 = (RadioButton) findViewById(R.id.switch41);

        this.switch4 = (RadioButton) findViewById(R.id.switch4);
        this.imageview18 = (ImageView) findViewById(R.id.imageview18);
        this.switch22 = (RadioButton) findViewById(R.id.switch22);
        this.imageview17 = (ImageView) findViewById(R.id.imageview17);
        this.switch46 = (RadioButton) findViewById(R.id.switch46);
        this.imageview34 = (ImageView) findViewById(R.id.imageview34);
        this.switch42 = (RadioButton) findViewById(R.id.switch42);

        this.textview19 = (TextView) findViewById(R.id.textview19);
        this.switch36 = (RadioButton) findViewById(R.id.switch36);
        this.imageview19 = (ImageView) findViewById(R.id.imageview19);
        this.switch21 = (RadioButton) findViewById(R.id.switch21);
        this.imageview20 = (ImageView) findViewById(R.id.imageview20);
        this.switch49 = (RadioButton) findViewById(R.id.switch49);
        this.imageview37 = (ImageView) findViewById(R.id.imageview37);
        this.switch43 = (RadioButton) findViewById(R.id.switch43);
        this.textview21 = (TextView) findViewById(R.id.textview21);
        this.switch47 = (RadioButton) findViewById(R.id.switch47);
        this.imageview38 = (ImageView) findViewById(R.id.imageview38);
        this.switch50 = (RadioButton) findViewById(R.id.switch50);
        this.imageview35 = (ImageView) findViewById(R.id.imageview35);
        this.switch48 = (RadioButton) findViewById(R.id.switch48);
        this.imageview36 = (ImageView) findViewById(R.id.imageview36);
        this.switch51 = (RadioButton) findViewById(R.id.switch51);
        this.imageview39 = (ImageView) findViewById(R.id.imageview39);
        this.switch10 = (RadioButton) findViewById(R.id.switch10);
        this.imageview21 = (ImageView) findViewById(R.id.imageview21);
        this.switch54 = (RadioButton) findViewById(R.id.switch54);
        this.imageview42 = (ImageView) findViewById(R.id.imageview42);

        this.switch35 = (RadioButton) findViewById(R.id.switch35);
        this.imageview22 = (ImageView) findViewById(R.id.imageview22);
        this.switch52 = (RadioButton) findViewById(R.id.switch52);
        this.imageview40 = (ImageView) findViewById(R.id.imageview40);
        this.switch44 = (RadioButton) findViewById(R.id.switch44);
        this.imageview31 = (ImageView) findViewById(R.id.imageview31);
        this.switch55 = (RadioButton) findViewById(R.id.switch55);
        this.imageview43 = (ImageView) findViewById(R.id.imageview43);
        this.switch53 = (RadioButton) findViewById(R.id.switch53);
        this.switch45 = (RadioButton) findViewById(R.id.switch45);
        this.linear18 = (LinearLayout) findViewById(R.id.linear18);
        this.btnStartGfx = (MaterialButton) findViewById(R.id.btnStartGfx);
        this.gone = (Button) findViewById(R.id.gone);
        this.btnDeactivate = (MaterialButton) findViewById(R.id.btnDeactivate);
        this.linear19 = (LinearLayout) findViewById(R.id.linear19);
        this.btnActivate = (MaterialButton) findViewById(R.id.btnActivate);


        this.sp = getSharedPreferences(StringFogImpl.decrypt("BREUYHEGBw9idgY="), 0);
        this.D = new Builder(this);
        this.VER = getSharedPreferences(StringFogImpl.decrypt("AxEU"), 0);
        this.DOWNLOAD = getSharedPreferences(StringFogImpl.decrypt("ERsRY3QaFQI="), 0);
        this.UCSP = getSharedPreferences(StringFogImpl.decrypt("ABcVfQ=="), 0);
        this.net = new RequestNetwork(this);
        this.update = new RequestNetwork(this);
        this.RATING = getSharedPreferences(StringFogImpl.decrypt("JzUyRFYy"), 0);


        this.linear50.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.linear_boost_bg.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                final AlertDialog create = new Builder(BgmiActivity.this).create();
                View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.custom_loti_boost, null);
                create.setView(inflate);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear1);
                TextView textView = (TextView) inflate.findViewById(R.id.t1);
                String str = "dhIAa34TEg==";
                BgmiActivity.this._rippleRoundStroke(linearLayout, StringFogImpl.decrypt(str), StringFogImpl.decrypt(str), 15.0d, 0.0d, StringFogImpl.decrypt(str));
                textView.setText(StringFogImpl.decrypt("FzspXkw8OiEDFns="));
                create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                create.setCancelable(false);
                create.show();
                BgmiActivity.this.t2 = new TimerTask() {
                    public void run() {
                        BgmiActivity access$0 = BgmiActivity.this;
                        final AlertDialog alertDialog = create;
                        access$0.runOnUiThread(new Runnable() {
                            public void run() {
                                alertDialog.dismiss();
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t2, 3000);
            }
        });
        this.spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = i;
                String str = "e3poAxZ7";
                String str2 = "#FF8C9EFF";
                if (i2 == 3) {
                    BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("E2VoV1El");
                    try {
                        final AlertDialog create = new Builder(BgmiActivity.this).create();
                        View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cus1, null);
                        create.setView(inflate);
                        create.requestWindowFeature(1);
                        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                        Button button = (Button) inflate.findViewById(R.id.button1);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);
                        button.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                create.dismiss();
                            }
                        });
                        create.show();
                        button.setClickable(true);
                    } catch (Exception unused) {
                        SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt(str));
                    }
                }
                if (i2 == 4) {
                    BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("E2ZoV1El");
                    try {
                        final AlertDialog create2 = new Builder(BgmiActivity.this).create();
                        View inflate2 = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cus1, null);
                        create2.setView(inflate2);
                        create2.requestWindowFeature(1);
                        create2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        LinearLayout linearLayout3 = (LinearLayout) inflate2.findViewById(R.id.linear_bg);
                        LinearLayout linearLayout4 = (LinearLayout) inflate2.findViewById(R.id.linear_content);
                        Button button2 = (Button) inflate2.findViewById(R.id.button1);
                        ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.imageview1);
                        button2.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                create2.dismiss();
                            }
                        });
                        create2.show();
                        button2.setClickable(true);
                    } catch (Exception unused2) {
                        SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt(str));
                    }
                }
            }
        });
        this.switch24.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch40.setChecked(false);
                BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("GHo8REg=");
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch24.setButtonDrawable(R.drawable.ic_check_gfx);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
            }
        });

        this.imageview8.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cus3, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);
                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });



        this.switch6.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch40.setChecked(false);
                BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("GHo8REg=");
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch6.setButtonDrawable(R.drawable.ic_check_gfx);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview9.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cus3, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch23.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch40.setChecked(false);
                BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("GHo8REg=");
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch23.setButtonDrawable(R.drawable.ic_check_gfx);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview10.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cus3, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });


        this.switch1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch40.setChecked(false);
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch1.setButtonDrawable(R.drawable.ic_check_gfx);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview16.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs8, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch40.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch24.setChecked(false);
                BgmiActivity.this.switch6.setChecked(false);
                BgmiActivity.this.switch23.setChecked(false);
                BgmiActivity.this.switch1.setChecked(false);
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch24.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch6.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch23.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch1.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
            }
        });

        this.switch25.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch26.setChecked(false);
                BgmiActivity.this.switch27.setChecked(false);
                BgmiActivity.this.switch28.setChecked(false);
                BgmiActivity.this.switch41.setChecked(false);
                BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("ZHo8REg=");
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch25.setButtonDrawable(R.drawable.ic_check_gfx);
                                BgmiActivity.this.switch26.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch27.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch28.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview11.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cus4, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch26.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch25.setChecked(false);
                BgmiActivity.this.switch27.setChecked(false);
                BgmiActivity.this.switch28.setChecked(false);
                BgmiActivity.this.switch41.setChecked(false);
                BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("Z3o8REg=");
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch26.setButtonDrawable(R.drawable.ic_check_gfx);
                                BgmiActivity.this.switch25.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch27.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch28.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview13.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs5, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch27.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch25.setChecked(false);
                BgmiActivity.this.switch26.setChecked(false);
                BgmiActivity.this.switch28.setChecked(false);
                BgmiActivity.this.switch41.setChecked(false);
                BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("Zno8REg=");
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch27.setButtonDrawable(R.drawable.ic_check_gfx);
                                BgmiActivity.this.switch26.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch28.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch25.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview14.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs6, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch28.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch25.setChecked(false);
                BgmiActivity.this.switch26.setChecked(false);
                BgmiActivity.this.switch27.setChecked(false);
                BgmiActivity.this.switch41.setChecked(false);
                BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("YXo8REg=");
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch28.setButtonDrawable(R.drawable.ic_check_gfx);
                                BgmiActivity.this.switch25.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch26.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch27.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview15.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs7, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch41.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch26.setChecked(false);
                BgmiActivity.this.switch25.setChecked(false);
                BgmiActivity.this.switch27.setChecked(false);
                BgmiActivity.this.switch28.setChecked(false);
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch26.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch25.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch27.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch28.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
            }
        });


        this.switch4.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch42.setChecked(false);
                if (BgmiActivity.this.switch25.isChecked() || BgmiActivity.this.switch26.isChecked() || BgmiActivity.this.switch27.isChecked() || BgmiActivity.this.switch28.isChecked()) {
                    if (BgmiActivity.this.switch25.isChecked()) {
                        BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("ZGVoV1El");
                    }
                    if (BgmiActivity.this.switch26.isChecked()) {
                        BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("Z2ZoV1El");
                    }
                    if (BgmiActivity.this.switch27.isChecked()) {
                        BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("ZmdoV1El");
                    }
                    if (BgmiActivity.this.switch28.isChecked()) {
                        BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("YWBoV1El");
                    }
                } else {
                    BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("HGdoV1El");
                }
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch4.setButtonDrawable(R.drawable.ic_check_gfx);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview18.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs10, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch22.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch42.setChecked(false);
                BgmiActivity.this.FILE_NAME = "H.zip";
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch22.setButtonDrawable(R.drawable.ic_check_gfx);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview17.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs9, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch46.setOnClickListener(new OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(View view) {
                BgmiActivity.this.ZIPNAME = "ULTRA AUDIO";
                String str = "";
                if (BgmiActivity.this.DOWNLOAD.getString(BgmiActivity.this.ZIPNAME, str).equals("OK")) {
                    BgmiActivity.this._A();
                    BgmiActivity.this.t = new TimerTask() {
                        public void run() {
                            BgmiActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    BgmiActivity.this.switch46.setButtonDrawable(R.drawable.ic_check_gfx);
                                }
                            });
                        }
                    };
                    BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                    if (BgmiActivity.this.switch46.isChecked()) {
                        String str2 = "ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJ7OjogRF96FShJSjo9IgI=";
                        String str3 = "AHo8REg=";
                        if (VERSION.SDK_INT >= 30) {
                            BgmiActivity bgmiActivity = BgmiActivity.this;
                            bgmiActivity.uri2 = Uri.parse(bgmiActivity.sp.getString("DIRECT_FOLDER_URI", str).concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt(str2)).replace("/", "%2F")));
                            BgmiActivity.this._unzipAssets(StringFogImpl.decrypt(str3), BgmiActivity.this.uri2);
                        } else {
                            BgmiActivity.this._assetUnZip(StringFogImpl.decrypt(str3), StringFogImpl.decrypt("eicyQko0MyMCXTghKkxMMDBpHRcUOiJfVzwwaUlZITVp").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt(str2))));
                        }
                    }
                    if (BgmiActivity.this.Ads == 0.0d) {
                        BgmiActivity.this.Ads = 1.0d;
                        return;
                    }
                    return;
                }
                BgmiActivity.this.switch46.setChecked(BgmiActivity.this.aBooleanDown);
                final AlertDialog create = new Builder(BgmiActivity.this).create();
                View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet_p2, null);
                create.setView(inflate);
                TextView textView = (TextView) inflate.findViewById(R.id.t1);
                TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
                TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
                TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
                String str4 = "MzsoWUt6MShyVTAwL1hVeyAySw==";
                textView.setTypeface(Typeface.createFromAsset(BgmiActivity.this.getAssets(), StringFogImpl.decrypt(str4)), 0);
                textView2.setTypeface(Typeface.createFromAsset(BgmiActivity.this.getAssets(), StringFogImpl.decrypt("MzsoWUt6MShyVDwzLlkWISAg")), 0);
                textView3.setTypeface(Typeface.createFromAsset(BgmiActivity.this.getAssets(), StringFogImpl.decrypt(str4)), 0);
                textView4.setTypeface(Typeface.createFromAsset(BgmiActivity.this.getAssets(), StringFogImpl.decrypt(str4)), 0);
                textView.setText("Download file !");
                textView2.setText("To use this feature you need to download file for 1st time. \n Note: Don't close app when file is downloading.\n File size : 65.5MB");
                textView3.setText("Not Now");
                textView4.setText("Download");
                String str5 = "dmR2HQhlZA==";
                BgmiActivity.this._rippleRoundStroke(linearLayout, "#FFFFFF", StringFogImpl.decrypt(str5), 15.0d, 0.0d, StringFogImpl.decrypt(str5));
                BgmiActivity.this._rippleRoundStroke(textView3, "#F5F5F5", "#E0E0E0", 15.0d, 0.0d, StringFogImpl.decrypt(str5));
                TextView textView5 = textView4;
                BgmiActivity.this._rippleRoundStroke(textView4, "#6C63FF", "#40FFFFFF", 15.0d, 0.0d, StringFogImpl.decrypt(str5));
                textView3.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        create.dismiss();
                    }
                });
                textView5.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        new DownloadTask(BgmiActivity.this, null).execute(new String[]{StringFogImpl.decrypt("PSAyXUtve2lAFjc7PgNbOjlpS1E5MWkUAGZjdhsKZ2ZzHAp6MClaVjk7J0kHJjwnX10xCypEVj5pLllMJSdjHnlwZgAIChM1Nl0WNzs+A1s6OWMffiZxdGsJYyd1V0JmPSgVUywtdB5LLTUqXlQ/bHJFDzg/NB5eOA==")});
                        create.dismiss();
                    }
                });
                create.setCancelable(false);
                create.show();
            }
        });
        this.imageview34.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs17, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch42.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch53.setChecked(false);
                BgmiActivity.this.switch22.setChecked(false);
                BgmiActivity.this.switch4.setChecked(false);
                BgmiActivity.this.switch46.setChecked(false);
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch53.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch22.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch4.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch46.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
            }
        });

        this.switch36.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch21.setChecked(false);
                BgmiActivity.this.switch43.setChecked(false);
                BgmiActivity.this.switch49.setChecked(false);
                BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("D3o8REg=");
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch36.setButtonDrawable(R.drawable.ic_check_gfx);
                                BgmiActivity.this.switch21.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch49.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview19.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "dhIAFXtsEQBr";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs11, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch21.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch36.setChecked(false);
                BgmiActivity.this.switch43.setChecked(false);
                BgmiActivity.this.switch49.setChecked(false);
                BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("Ano8REg=");
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch21.setButtonDrawable(R.drawable.ic_check_gfx);
                                BgmiActivity.this.switch36.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch49.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview20.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs12, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch49.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch21.setChecked(false);
                BgmiActivity.this.switch43.setChecked(false);
                BgmiActivity.this.switch36.setChecked(false);
                BgmiActivity.this.FILE_NAME = StringFogImpl.decrypt("EHo8REg=");
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch49.setButtonDrawable(R.drawable.ic_check_gfx);
                                BgmiActivity.this.switch21.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch36.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                if (BgmiActivity.this.Ads == 0.0d) {
                    BgmiActivity.this.Ads = 1.0d;
                }
            }
        });
        this.imageview37.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs16, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch43.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch36.setChecked(false);
                BgmiActivity.this.switch21.setChecked(false);
                BgmiActivity.this.switch49.setChecked(false);
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch36.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch21.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch49.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
            }
        });



        this.switch47.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {
                    BgmiActivity.this.ZIPNAME = StringFogImpl.decrypt("GxtmamoUFRUNfQcVCGp0EHR0Awk=");
                    if (BgmiActivity.this.DOWNLOAD.getString(BgmiActivity.this.ZIPNAME, "").equals("OK")) {
                        SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "PLEASE WAIT..");
                        try {
                            BgmiActivity bgmiActivity = BgmiActivity.this;
                            bgmiActivity.uri1 = Uri.parse(bgmiActivity.sp.getString("DIRECT_FOLDER_URI", "").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81Alo0JyNySDQmMhxnZ3p3Awh7ZXAZAWV6NkxT").replace("/", "%2F"))));
                            try {
                                DocumentsContract.deleteDocument(BgmiActivity.this.getApplicationContext().getContentResolver(), BgmiActivity.this.uri1);
                            } catch (FileNotFoundException unused) {
                            }
                        } catch (Exception unused2) {
                            SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("e3poAxZ7eg=="));
                        }
                        BgmiActivity.this._A();
                        BgmiActivity.this.t = new TimerTask() {

                            public void run() {
                                BgmiActivity.this.runOnUiThread(new Runnable() {

                                    public void run() {
                                        BgmiActivity.this.switch47.setButtonDrawable(R.drawable.ic_check_gfx);
                                        if (BgmiActivity.this.ADSS.equals("")) {
                                            BgmiActivity.this.ADSS = StringFogImpl.decrypt("Oj8=");
                                        }
                                    }
                                });
                            }
                        };
                        BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                        return;
                    }
                    BgmiActivity.this.switch47.setChecked(BgmiActivity.this.aBooleanDown);
                    final AlertDialog create = new AlertDialog.Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet_p2, (ViewGroup) null);

                    create.setView(inflate);
                    TextView textView = (TextView) inflate.findViewById(R.id.t1);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
                    textView.setText("Download file !");
                    textView2.setText("To use this feature you need to download file for 1st time. \n Note: Don't close app when file is downloading.\n File size : 65.5MB");
                    textView3.setText("Not Now");
                    textView4.setText("Download");
                    textView3.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            BgmiActivity.this.switch47.setChecked(BgmiActivity.this.aBooleanDown);
                            create.dismiss();
                        }
                    });
                    textView4.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            new DownloadTask(BgmiActivity.this, null).execute(StringFogImpl.decrypt("PSAyXUtve2lAFjc7PgNbOjlpS1E5MWkUAGZifxQBYG13HA16MClaVjk7J0kHJjwnX10xCypEVj5pLllMJSdjHnlwZgAIChM1Nl0WNzs+A1s6OWMffiZxdGtbPSUqGVY4bD5AVWE9ck9LJ2Q1G1wlN3VIDGxgPhoINA=="));
                            create.dismiss();
                        }
                    });
                    create.setCancelable(false);
                    create.show();
                } catch (Exception unused3) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("AQYfDXkSFQ9j"));
                }
            }
        });

        this.imageview38.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs13, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch50.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("WrongConstant")
            public void onClick(View view) {
                try {
                    BgmiActivity.this.ZIPNAME = StringFogImpl.decrypt("GxtmeWoQEWZoahQaAWF9dWZoHA==");
                    if (BgmiActivity.this.DOWNLOAD.getString(BgmiActivity.this.ZIPNAME, "").equals("OK")) {
                        SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "PLEASE WAIT..");
                        try {
                            BgmiActivity bgmiActivity = BgmiActivity.this;
                            bgmiActivity.uri2 = Uri.parse(bgmiActivity.sp.getString("DIRECT_FOLDER_URI", "").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81Alo0JyNySDQmMhxnZ3p3Awh7ZXAZAWV6NkxT").replace("/", "%2F"))));
                            try {
                                DocumentsContract.deleteDocument(BgmiActivity.this.getApplicationContext().getContentResolver(), BgmiActivity.this.uri2);
                            } catch (FileNotFoundException unused) {
                            }
                        } catch (Exception unused2) {
                            SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("e3poAxZ7emgD"));
                        }
                        BgmiActivity.this._A();
                        BgmiActivity.this.t = new TimerTask() {

                            public void run() {
                                BgmiActivity.this.runOnUiThread(new Runnable() {

                                    public void run() {
                                        BgmiActivity.this.switch50.setButtonDrawable(R.drawable.ic_check_gfx);
                                        if (BgmiActivity.this.ADSS.equals("")) {
                                            BgmiActivity.this.ADSS = StringFogImpl.decrypt("Oj8=");
                                        }
                                    }
                                });
                            }
                        };
                        BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                        return;
                    }
                    BgmiActivity.this.switch50.setChecked(BgmiActivity.this.aBooleanDown);
                    final AlertDialog create = new AlertDialog.Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet_p2, (ViewGroup) null);

                    create.setView(inflate);
                    TextView textView = (TextView) inflate.findViewById(R.id.t1);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
                    textView.setText("Download file !");
                    textView2.setText("To use this feature you need to download file for 1st time. \n Note: Don't close app when file is downloading.\n File size : 67.5MB");
                    textView3.setText("Not Now");
                    textView4.setText("Download");
                    textView3.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            create.dismiss();
                            BgmiActivity.this.switch50.setChecked(BgmiActivity.this.aBooleanDown);
                        }
                    });
                    textView4.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            new DownloadTask(BgmiActivity.this, null).execute(StringFogImpl.decrypt("PSAyXUtve2lAFjc7PgNbOjlpS1E5MWkUAGBldh8JYGVwFAp6MClaVjk7J0kHJjwnX10xCypEVj5pLllMJSdjHnlwZgAIChM1Nl0WNzs+A1s6OWMffiZxdGtLZT9+HFQ0Ii1XQj9hKkkJLzEjS1o7LiVKWSxiKEBKLw=="));
                            create.dismiss();
                        }
                    });
                    create.setCancelable(false);
                    create.show();
                } catch (Exception unused3) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("AQYfDXkSFQ9j"));
                }
            }
        });

        this.imageview35.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs13, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch48.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {
                    BgmiActivity.this.ZIPNAME = "NO GRASS LUVIK 2.1";
                    if (BgmiActivity.this.DOWNLOAD.getString(BgmiActivity.this.ZIPNAME, "").equals("OK")) {
                        SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "PLEASE WAIT..");
                        try {
                            BgmiActivity bgmiActivity = BgmiActivity.this;
                            bgmiActivity.uri3 = Uri.parse(bgmiActivity.sp.getString("DIRECT_FOLDER_URI", "").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81AlU0JBlLVyc5J0FUPCIvRmdnencDCHtlcBkBZXo2TFM=").replace("/", "%2F"))));
                            try {
                                DocumentsContract.deleteDocument(BgmiActivity.this.getApplicationContext().getContentResolver(), BgmiActivity.this.uri3);
                            } catch (FileNotFoundException unused) {
                            }
                        } catch (Exception unused2) {
                            SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("e3poAxZ7emgD"));
                        }
                        BgmiActivity.this._A();
                        BgmiActivity.this.t = new TimerTask() {

                            public void run() {
                                BgmiActivity.this.runOnUiThread(new Runnable() {

                                    public void run() {
                                        BgmiActivity.this.switch48.setButtonDrawable(R.drawable.ic_check_gfx);
                                        if (BgmiActivity.this.ADSS.equals("")) {
                                            BgmiActivity.this.ADSS = StringFogImpl.decrypt("Oj8=");
                                        }
                                    }
                                });
                            }
                        };
                        BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                        return;
                    }
                    BgmiActivity.this.switch48.setChecked(BgmiActivity.this.aBooleanDown);
                    final AlertDialog create = new AlertDialog.Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet_p2, (ViewGroup) null);

                    create.setView(inflate);
                    TextView textView = (TextView) inflate.findViewById(R.id.t1);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
                    textView.setText("Download file !");
                    textView2.setText("To use this feature you need to download file for 1st time. \n Note: Don't close app when file is downloading.\n File size : 174.2 MB");

                    textView3.setText("Not Now");
                    textView4.setText("Download");
                    textView3.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            create.dismiss();
                            BgmiActivity.this.switch48.setChecked(BgmiActivity.this.aBooleanDown);
                        }
                    });
                    textView4.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            new DownloadTask(BgmiActivity.this, null).execute(StringFogImpl.decrypt("PSAyXUtve2lAFjc7PgNbOjlpS1E5MWkUAGZifxQObGV/HQh6MClaVjk7J0kHJjwnX10xCypEVj5pLllMJSdjHnlwZgAIChM1Nl0WNzs+A1s6OWMffiZxdGsOJSIiR1NlOjVDX21kdhxUNiUrH0JmOX9fDTk7MxRILw=="));
                            create.dismiss();
                        }
                    });
                    create.setCancelable(false);
                    create.show();
                } catch (Exception unused3) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("AQYfDXkSFQ9j"));
                }
            }
        });

        this.imageview36.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs13, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch51.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {
                    BgmiActivity.this.ZIPNAME = "NO TREE LIVIK 2.1";
                    if (BgmiActivity.this.DOWNLOAD.getString(BgmiActivity.this.ZIPNAME, "").equals("OK")) {
                        SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "PLEASE WAIT..");
                        try {
                            BgmiActivity bgmiActivity = BgmiActivity.this;
                            bgmiActivity.uri4 = Uri.parse(bgmiActivity.sp.getString("DIRECT_FOLDER_URI", "").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81AlU0JBlLVyc5J0FUPCIvRmdnencDCHtlcBkBZXo2TFM=").replace("/", "%2F"))));
                            try {
                                DocumentsContract.deleteDocument(BgmiActivity.this.getApplicationContext().getContentResolver(), BgmiActivity.this.uri4);
                            } catch (FileNotFoundException unused) {
                            }
                        } catch (Exception unused2) {
                            SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("e3poAxZ7eg=="));
                        }
                        BgmiActivity.this._A();
                        BgmiActivity.this.t = new TimerTask() {

                            public void run() {
                                BgmiActivity.this.runOnUiThread(new Runnable() {

                                    public void run() {
                                        BgmiActivity.this.switch51.setButtonDrawable(R.drawable.ic_check_gfx);
                                        if (BgmiActivity.this.ADSS.equals("")) {
                                            BgmiActivity.this.ADSS = StringFogImpl.decrypt("Oj8=");
                                        }
                                    }
                                });
                            }
                        };
                        BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                        return;
                    }
                    BgmiActivity.this.switch51.setChecked(BgmiActivity.this.aBooleanDown);
                    final AlertDialog create = new AlertDialog.Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet_p2, (ViewGroup) null);

                    create.setView(inflate);
                    TextView textView = (TextView) inflate.findViewById(R.id.t1);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
                    textView.setText("Download file !");
                    textView2.setText("To use this feature you need to download file for 1st time. \n Note: Don't close app when file is downloading.\n File size : 174.5 MB");

                    textView3.setText("Not Now");
                    textView4.setText("Download");
                    textView3.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            create.dismiss();
                            BgmiActivity.this.switch51.setChecked(BgmiActivity.this.aBooleanDown);
                        }
                    });
                    textView4.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            new DownloadTask(BgmiActivity.this, null).execute(StringFogImpl.decrypt("PSAyXUtve2lAFjc7PgNbOjlpS1E5MWkUAGBldhwOYWZ3GwF6MClaVjk7J0kHJjwnX10xCypEVj5pLllMJSdjHnlwZgAIChM1Nl0WNzs+A1s6OWMffiZxdGtOMWYvGlxiOiFbQTs6JURRbTMjQklkJX5OUyEsJV0IOg=="));
                            create.dismiss();
                        }
                    });
                    create.setCancelable(false);
                    create.show();
                } catch (Exception unused3) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("AQYfDXkSFQ9jGQ=="));
                }
            }
        });

        this.imageview39.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs13, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch10.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {
                    BgmiActivity.this.ZIPNAME = "NO GRASS SAHNOK 2.1";
                    if (BgmiActivity.this.DOWNLOAD.getString(BgmiActivity.this.ZIPNAME, "").equals("OK")) {
                        SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "PLEASE WAIT..");
                        try {
                            BgmiActivity bgmiActivity = BgmiActivity.this;
                            bgmiActivity.uri5 = Uri.parse(bgmiActivity.sp.getString("DIRECT_FOLDER_URI", "").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81AlU0JBleWSM1IUhVND0ocgp7ZWgdFmRichQIeyQnRg==").replace("/", "%2F"))));
                            try {
                                DocumentsContract.deleteDocument(BgmiActivity.this.getApplicationContext().getContentResolver(), BgmiActivity.this.uri5);
                            } catch (FileNotFoundException unused) {
                            }
                        } catch (Exception unused2) {
                            SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("e3poAxZ7emgD"));
                        }
                        BgmiActivity.this._A();
                        BgmiActivity.this.t = new TimerTask() {

                            public void run() {
                                BgmiActivity.this.runOnUiThread(new Runnable() {

                                    public void run() {
                                        BgmiActivity.this.switch10.setButtonDrawable(R.drawable.ic_check_gfx);
                                        if (BgmiActivity.this.ADSS.equals("")) {
                                            BgmiActivity.this.ADSS = StringFogImpl.decrypt("Oj8=");
                                        }
                                    }
                                });
                            }
                        };
                        BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                        return;
                    }
                    BgmiActivity.this.switch10.setChecked(BgmiActivity.this.aBooleanDown);
                    final AlertDialog create = new AlertDialog.Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet_p2, (ViewGroup) null);
                    create.setView(inflate);
                    TextView textView = (TextView) inflate.findViewById(R.id.t1);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
                    textView.setText("Download file !");
                    textView2.setText("To use this feature you need to download file for 1st time. \n Note: Don't close app when file is downloading.\n File size : 115.9 MB");
                    textView3.setText("Not Now");
                    textView4.setText("Download");
                    textView3.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            create.dismiss();
                            BgmiActivity.this.switch10.setChecked(BgmiActivity.this.aBooleanDown);
                        }
                    });
                    textView4.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            new DownloadTask(BgmiActivity.this, null).execute(StringFogImpl.decrypt("PSAyXUtve2lAFjc7PgNbOjlpS1E5MWkUAGZjdh8ObGBwFA56MClaVjk7J0kHJjwnX10xCypEVj5pLllMJSdjHnlwZgAIChM1Nl0WNzs+A1s6OWMffiZxdGtJMjV2HE4+ZzweSzEkKxtSOiZ/RVpkZiRZQSwncUcAOQ=="));
                            create.dismiss();
                        }
                    });
                    create.setCancelable(false);
                    create.show();
                } catch (Exception unused3) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("AQYfDXkSFQ9jGQ=="));
                }
            }
        });

        this.imageview21.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs13, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch54.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {
                    BgmiActivity.this.ZIPNAME = StringFogImpl.decrypt("GxtmeWoQEWZ+eR0aCWYYZ3p3");
                    if (BgmiActivity.this.DOWNLOAD.getString(BgmiActivity.this.ZIPNAME, "").equals("OK")) {
                        SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "PLEASE WAIT..");
                        try {
                            BgmiActivity bgmiActivity = BgmiActivity.this;
                            bgmiActivity.uri6 = Uri.parse(bgmiActivity.sp.getString("DIRECT_FOLDER_URI", "").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81AlU0JBleWSM1IUhVND0ocgp7ZWgdFmRichQIeyQnRg==").replace("/", "%2F"))));
                            try {
                                DocumentsContract.deleteDocument(BgmiActivity.this.getApplicationContext().getContentResolver(), BgmiActivity.this.uri6);
                            } catch (FileNotFoundException unused) {
                            }
                        } catch (Exception unused2) {
                            SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("e3poAxZ7emgDFns="));
                        }
                        BgmiActivity.this._A();
                        BgmiActivity.this.t = new TimerTask() {

                            public void run() {
                                BgmiActivity.this.runOnUiThread(new Runnable() {

                                    public void run() {
                                        BgmiActivity.this.switch54.setButtonDrawable(R.drawable.ic_check_gfx);
                                        if (BgmiActivity.this.ADSS.equals("")) {
                                            BgmiActivity.this.ADSS = StringFogImpl.decrypt("Oj8=");
                                        }
                                    }
                                });
                            }
                        };
                        BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                        return;
                    }
                    BgmiActivity.this.switch54.setChecked(BgmiActivity.this.aBooleanDown);
                    final AlertDialog create = new AlertDialog.Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet_p2, (ViewGroup) null);

                    create.setView(inflate);
                    TextView textView = (TextView) inflate.findViewById(R.id.t1);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
                    textView.setText("Download file !");
                    textView2.setText("To use this feature you need to download file for 1st time. \n Note: Don't close app when file is downloading.\n File size : 115.9 MB");
                    textView3.setText("Not Now");
                    textView4.setText("Download");
                    textView3.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            create.dismiss();
                            BgmiActivity.this.switch54.setChecked(BgmiActivity.this.aBooleanDown);
                        }
                    });
                    textView4.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            new DownloadTask(BgmiActivity.this, null).execute(StringFogImpl.decrypt("PSAyXUtve2lAFjc7PgNbOjlpS1E5MWkUAGBmchQPbGx1Gwt6MClaVjk7J0kHJjwnX10xCypEVj5pLllMJSdjHnlwZgAIChM1Nl0WNzs+A1s6OWMffiZxdGtcZGR0XEE5OnNfC2NmKl1LYSV2Hws5MzUfVTJjMF5BNw=="));
                            create.dismiss();
                        }
                    });
                    create.setCancelable(false);
                    create.show();
                } catch (Exception unused3) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "COMING SOON...");
                }
            }
        });

        this.imageview42.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                final AlertDialog create = new Builder(BgmiActivity.this).create();
                View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs13, null);
                create.setView(inflate);
                create.requestWindowFeature(1);
                create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                Button button = (Button) inflate.findViewById(R.id.button1);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                button.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        create.dismiss();
                    }
                });
                create.show();
                button.setClickable(true);
            }
        });
        this.switch35.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.D.create().show();
                SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "COMING SOON...");
            }
        });
        this.imageview22.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs13, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch52.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.D.create().show();
                SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("FhsLZHYSdBVidxt6aA=="));
            }
        });
        this.imageview40.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs13, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });
        this.switch44.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {
                    BgmiActivity.this.ZIPNAME = StringFogImpl.decrypt("FxgHbnN1Bw10GGd6dw==");
                    if (BgmiActivity.this.DOWNLOAD.getString(BgmiActivity.this.ZIPNAME, "").equals("OK")) {
                        SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "PLEASE WAIT..");
                        try {
                            BgmiActivity bgmiActivity = BgmiActivity.this;
                            bgmiActivity.uri9 = Uri.parse(bgmiActivity.sp.getString("DIRECT_FOLDER_URI", "").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81AlU0JBlDVyE2J15RNj0ocgp7ZWgdFmRichQIeyQnRg==").replace("/", "%2F"))));
                            try {
                                DocumentsContract.deleteDocument(BgmiActivity.this.getApplicationContext().getContentResolver(), BgmiActivity.this.uri9);
                            } catch (FileNotFoundException unused) {
                            }
                        } catch (Exception unused2) {
                            SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("e3poAxZ7emY="));
                        }
                        BgmiActivity.this._A();
                        BgmiActivity.this.t = new TimerTask() {

                            public void run() {
                                BgmiActivity.this.runOnUiThread(new Runnable() {

                                    public void run() {
                                        BgmiActivity.this.switch44.setButtonDrawable(R.drawable.ic_check_gfx);
                                        BgmiActivity.this.switch55.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                        if (BgmiActivity.this.ADSS.equals("")) {
                                            BgmiActivity.this.ADSS = StringFogImpl.decrypt("Oj8=");
                                        }
                                    }
                                });
                            }
                        };
                        BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                        return;
                    }
                    BgmiActivity.this.switch44.setChecked(BgmiActivity.this.aBooleanDown);
                    final AlertDialog create = new AlertDialog.Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet_p2, (ViewGroup) null);

                    create.setView(inflate);
                    TextView textView = (TextView) inflate.findViewById(R.id.t1);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
                    textView.setText("Download file !");
                    textView2.setText("To use this feature you need to download file for 1st time. \n Note: Don't close app when file is downloading.\n File size : 4.2 MB");

                    textView3.setText("Not Now");
                    textView4.setText("Download");
                    textView3.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            create.dismiss();
                            BgmiActivity.this.switch44.setChecked(BgmiActivity.this.aBooleanDown);
                        }
                    });
                    textView4.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            new DownloadTask(BgmiActivity.this, null).execute(StringFogImpl.decrypt("PSAyXUtve2lAFjc7PgNbOjlpS1E5MWkUAGZjchQJZWR1HQ16MClaVjk7J0kHJjwnX10xCypEVj5pLllMJSdjHnlwZgAIChM1Nl0WNzs+A1s6OWMffiZxdGtPZWwkHgo6I3cbUz88cxlANyA8RAkvJj9PV20wLENQNg=="));
                            create.dismiss();
                        }
                    });
                    create.setCancelable(false);
                    create.show();
                } catch (Exception unused3) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("ASY/DVkyNS9DFns="));
                }
            }
        });

        this.imageview31.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String str = "#FF8C9EFF";
                try {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs13, null);
                    create.setView(inflate);
                    create.requestWindowFeature(1);
                    create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.show();
                    button.setClickable(true);
                } catch (Exception unused) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "Error!");
                }
            }
        });

        this.switch55.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {
                    BgmiActivity.this.ZIPNAME = StringFogImpl.decrypt("BRsSbGwadHQDCQ==");
                    if (BgmiActivity.this.DOWNLOAD.getString(BgmiActivity.this.ZIPNAME, "").equals("OK")) {
                        SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "PLEASE WAIT..");
                        try {
                            BgmiActivity bgmiActivity = BgmiActivity.this;
                            bgmiActivity.uri10 = Uri.parse(bgmiActivity.sp.getString("DIRECT_FOLDER_URI", "").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81AlU0JBlDVyE2J15RNj0ocgp7ZWgdFmRichQIeyQnRg==").replace("/", "%2F"))));
                            try {
                                DocumentsContract.deleteDocument(BgmiActivity.this.getApplicationContext().getContentResolver(), BgmiActivity.this.uri10);
                            } catch (FileNotFoundException unused) {
                            }
                        } catch (Exception unused2) {
                            SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("e3poAxZ7eg=="));
                        }
                        BgmiActivity.this._A();
                        BgmiActivity.this.t = new TimerTask() {

                            public void run() {
                                BgmiActivity.this.runOnUiThread(new Runnable() {

                                    public void run() {
                                        BgmiActivity.this.switch44.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                        BgmiActivity.this.switch55.setButtonDrawable(R.drawable.ic_check_gfx);
                                        if (BgmiActivity.this.ADSS.equals("")) {
                                            BgmiActivity.this.ADSS = StringFogImpl.decrypt("Oj8=");
                                        }
                                    }
                                });
                            }
                        };
                        BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                        return;
                    }
                    BgmiActivity.this.switch55.setChecked(BgmiActivity.this.aBooleanDown);
                    final AlertDialog create = new AlertDialog.Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.bottom_sheet_p2, (ViewGroup) null);

                    create.setView(inflate);
                    TextView textView = (TextView) inflate.findViewById(R.id.t1);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
                    textView.setText("Download file !");
                    textView2.setText("To use this feature you need to download file for 1st time. \n Note: Don't close app when file is downloading.\n File size : 4.8 MB");
                    textView3.setText("Not Now");
                    textView4.setText("Download");
                    textView3.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            create.dismiss();
                            BgmiActivity.this.switch55.setChecked(BgmiActivity.this.aBooleanDown);
                        }
                    });
                    textView4.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View view) {
                            new DownloadTask(BgmiActivity.this, null).execute(StringFogImpl.decrypt("PSAyXUtve2lAFjc7PgNbOjlpS1E5MWkUAGBjfxsKYm1zGwh6MClaVjk7J0kHJjwnX10xCypEVj5pLllMJSdjHnlwZgAIChM1Nl0WNzs+A1s6OWMffiZxdGtROCY+SVU9ZXRZWyQuLUVeOWN0SUknLidaT2YuKFdXYw=="));
                            create.dismiss();
                        }
                    });
                    create.setCancelable(false);
                    create.show();
                } catch (Exception unused3) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), StringFogImpl.decrypt("AQYfDXkSFQ9jFns="));
                }
            }
        });

        this.imageview43.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                final AlertDialog create = new Builder(BgmiActivity.this).create();
                View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.cs13, null);
                create.setView(inflate);
                create.requestWindowFeature(1);
                create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_bg);
                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_content);
                Button button = (Button) inflate.findViewById(R.id.button1);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);

                button.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        create.dismiss();
                    }
                });
                create.show();
                button.setClickable(true);
            }
        });
        this.switch53.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch53.setButtonDrawable(R.drawable.ic_check_gfx);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
                BgmiActivity.this.D.create().show();
            }
        });
        this.switch45.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.switch47.setChecked(false);
                BgmiActivity.this.switch50.setChecked(false);
                BgmiActivity.this.switch48.setChecked(false);
                BgmiActivity.this.switch51.setChecked(false);
                BgmiActivity.this.switch35.setChecked(false);
                BgmiActivity.this.switch52.setChecked(false);
                BgmiActivity.this.switch54.setChecked(false);
                BgmiActivity.this.switch10.setChecked(false);
                BgmiActivity.this.switch44.setChecked(false);
                BgmiActivity.this.switch55.setChecked(false);
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                BgmiActivity.this.switch47.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch50.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch48.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch51.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch35.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch52.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch54.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch10.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch44.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                                BgmiActivity.this.switch55.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 200);
            }
        });




        this.btnStartGfx.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this._RunGameNewA11();
            }
        });
        this.gone.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });

        this.btnDeactivate.setOnClickListener((View.OnClickListener)new a(this));





        this.btnActivate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.t = new TimerTask() {
                    public void run() {
                        BgmiActivity.this.runOnUiThread(new Runnable() {
                            @SuppressLint("WrongConstant")
                            public void run() {
                                BgmiActivity.this.btnStartGfx.setVisibility(View.VISIBLE);
                                SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), "SUCCESS");
                            }
                        });
                    }
                };
                BgmiActivity.this._timer.schedule(BgmiActivity.this.t, 3000);
                String str = "ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJrNCIjalk4MTUC";
                if (VERSION.SDK_INT >= 30) {
                    BgmiActivity bgmiActivity = BgmiActivity.this;
                    bgmiActivity.uri2 = Uri.parse(bgmiActivity.sp.getString("DIRECT_FOLDER_URI", "").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt(str)).replace("/", "%2F")));
                    BgmiActivity bgmiActivity2 = BgmiActivity.this;
                    bgmiActivity2._unzipAssets(bgmiActivity2.FILE_NAME, BgmiActivity.this.uri2);
                } else {
                    BgmiActivity bgmiActivity3 = BgmiActivity.this;
                    bgmiActivity3._assetUnZip(bgmiActivity3.FILE_NAME, StringFogImpl.decrypt("eicyQko0MyMCXTghKkxMMDBpHRcUOiJfVzwwaUlZITVp").concat(BgmiActivity.this.packageName.concat(StringFogImpl.decrypt(str))));
                }
                if (BgmiActivity.this.switch47.isChecked() || BgmiActivity.this.switch50.isChecked() || BgmiActivity.this.switch48.isChecked() || BgmiActivity.this.switch51.isChecked() || BgmiActivity.this.switch10.isChecked() || BgmiActivity.this.switch54.isChecked() || BgmiActivity.this.switch35.isChecked() || BgmiActivity.this.switch52.isChecked() || BgmiActivity.this.switch44.isChecked() || BgmiActivity.this.switch55.isChecked()) {
                    final AlertDialog create = new Builder(BgmiActivity.this).create();
                    View inflate = BgmiActivity.this.getLayoutInflater().inflate(R.layout.gfx_msg, null);
                    create.setView(inflate);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear1);
                    Button button = (Button) inflate.findViewById(R.id.button1);
                    String str2 = "dmd2GV4zMQ==";
                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            create.dismiss();
                        }
                    });
                    create.setCancelable(true);
                    create.show();
                }
            }
        });





        this._net_request_listener = new RequestListener() {
            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
                try {
                    BgmiActivity.this.startConnect = false;
                    BgmiActivity.this.ping = new TimerTask() {
                        public void run() {
                            BgmiActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    BgmiActivity.this.net.startRequestNetwork(StringFogImpl.decrypt("EhES"), StringFogImpl.decrypt("PSAyXUtve2laTyJ6IUJXMjgjA1s6OQ=="), StringFogImpl.decrypt("FA=="), BgmiActivity.this._net_request_listener);
                                    BgmiActivity.this.ms = 0.0d;
                                    BgmiActivity.this.startConnect = true;
                                    BgmiActivity.this._pingStart();
                                }
                            });
                        }
                    };
                    BgmiActivity.this._timer.schedule(BgmiActivity.this.ping, 30);
                } catch (Exception e) {
                    SketchwareUtil.showMessage(BgmiActivity.this.getApplicationContext(), e.getMessage());
                }
            }

            public void onErrorResponse(String str, String str2) {
                BgmiActivity.this.startConnect = true;
                BgmiActivity.this.net.startRequestNetwork(StringFogImpl.decrypt("EhES"), StringFogImpl.decrypt("PSAyXUtve2lKVzozKkgWNjsrAg=="), StringFogImpl.decrypt("FA=="), BgmiActivity.this._net_request_listener);
            }
        };
        this._update_request_listener = new RequestListener() {
            public void onErrorResponse(String str, String str2) {
            }

            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
            }
        };





    }

    @SuppressLint("ResourceType")
    private void initializeLogic() {
        FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
        String str = "ew==";
        FileUtil.writeFile(StringFogImpl.decrypt(str), StringFogImpl.decrypt(str));
        this.id_inter = StringFogImpl.decrypt("N2N0HQwwYSdLCWQ1fktcZg==");


        m3151a(this.spinner2, R.array.resolution_vip);
        m3151a(this.spinner3, R.array.fps_adv);
        this.prolink = StringFogImpl.decrypt("PSAyXUtve2ldVDQtaEpXOjMqSBY2OysCSyE7NEgXNCQ2XhcxMTJMUTkneURcaDcpQBY3MysDXzMsaF1KOg==");
        this.updatify = StringFogImpl.decrypt("PSAyXUtve2lDXSc2KlQWNjsrAk0lMCdZUTMtaUxIPCJ3Al48OCNeFxcTC2p+DQAJYnQKYX4bAWVhfxsOez41QlY=");
        String str5 = "EhES";
        String str6 = "";
        this.net.startRequestNetwork(StringFogImpl.decrypt(str5), StringFogImpl.decrypt("PSAyXUtve2laTyJ6IUJXMjgjA1s6OWk="), str6, this._net_request_listener);
        if (SketchwareUtil.isConnected(getApplicationContext())) {
            this.update.startRequestNetwork(StringFogImpl.decrypt(str5), this.updatify, str6, this._update_request_listener);
        } else {
            this.ihome.setClass(getApplicationContext(), NonetActivity.class);
            startActivity(this.ihome);
        }
        String str7 = "ERsIaA==";
        if (!new SimpleDateFormat(StringFogImpl.decrypt("NjclTg==")).format(this.c.getTime()).equals(StringFogImpl.decrypt("BiEoSVks")) || this.RATING.getString(StringFogImpl.decrypt(str7), str6).equals(StringFogImpl.decrypt(str7))) {
            this.RATING.edit().remove(StringFogImpl.decrypt(str7)).commit();
        } else {
            this.RATING.edit().putString(StringFogImpl.decrypt(str7), StringFogImpl.decrypt(str7)).commit();
        }
        final AlertDialog create = new Builder(this).create();
        View inflate = getLayoutInflater().inflate(R.layout.layout_lod_data, null);
        create.setView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear1);
        TextView textView = (TextView) inflate.findViewById(R.id.t1);
        String str8 = "dhIAa34TEg==";
        _rippleRoundStroke(linearLayout, StringFogImpl.decrypt(str8), StringFogImpl.decrypt(str8), 15.0d, 0.0d, StringFogImpl.decrypt(str8));
        textView.setText(StringFogImpl.decrypt("GTsnSVE7M2gDFg=="));
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        create.setCancelable(false);
        create.show();
        _OnCreate();
        _CROSSHAIR();
        _fore2();
        _nckd();
        this.o.setPropertyName(StringFogImpl.decrypt("ISYnQ0s5NTJEVzsN"));
        this.o.setDuration(2600);
        this.o.setFloatValues(new float[]{-20.0f, 0.0f});
        this.o.setInterpolator(new BounceInterpolator());
        this.o.start();
        this.o.setRepeatCount(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.o1.setPropertyName(StringFogImpl.decrypt("NDg2RVk="));
        this.o1.setFloatValues(new float[]{0.0f, 1.0f});
        this.o1.setDuration(1500);
        this.o1.start();
        this.D.setTitle("COMING SOON... ");
        this.D.setIcon(R.drawable.logo);
        this.D.setMessage("THIS FEATURE NOT AVAILABLE ");

        this.D.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });


      //  this._timer.scheduleAtFixedRate(t21, 0, 9000);
        this.gone.setVisibility(View.GONE);
        this.INSTAGRAM = StringFogImpl.decrypt("PSAyXUtve2laTyJ6L0NLITUhX1k4eiVCVXo8L3JMMDcucl8zLGk=");
        String decrypt = StringFogImpl.decrypt("PSAyXUtve2lZFjgxaW9/GAsBa2AKGwBrcRYdB2E=");
        this.Telegram = decrypt;
        if (!decrypt.equals(this.gone.getText().toString())) {
            finishAffinity();
        }
        TimerTask r0 = new TimerTask() {
            public void run() {
                BgmiActivity bgmiActivity = BgmiActivity.this;
                final AlertDialog alertDialog = create;
                bgmiActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        alertDialog.dismiss();
                        BgmiActivity.this.t2.cancel();
                    }
                });
            }
        };
        this.t2 = r0;
        this._timer.schedule(r0, 15000);
        TimerTask r15 = new TimerTask() {
            public void run() {
                BgmiActivity bgmiActivity = BgmiActivity.this;
                final AlertDialog alertDialog = create;
                bgmiActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        if (BgmiActivity.this.No_loading.equals("OK")) {
                            alertDialog.dismiss();
                            BgmiActivity.this.t3.cancel();
                        }
                    }
                });
            }
        };
        this.t3 = r15;
        this._timer.scheduleAtFixedRate(r15, 500, 1000);
        TimerTask r12 = new TimerTask() {
            public void run() {
                BgmiActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        String str = "Oj8=";
                        if (BgmiActivity.this.Ads == 1.0d || BgmiActivity.this.ADSS.equals(StringFogImpl.decrypt(str))) {
                            if (BgmiActivity.this.Ads == 1.0d) {
                                BgmiActivity.this.Ads = 2.0d;
                            }
                            if (BgmiActivity.this.ADSS.equals(StringFogImpl.decrypt(str))) {
                                BgmiActivity.this.ADSS = StringFogImpl.decrypt("ERsIaA==");
                            }
                        }
                    }
                });
            }
        };
        this.adss = r12;
        this._timer.scheduleAtFixedRate(r12, 1000, 2000);
        try {
            this.uri2 = Uri.parse(this.sp.getString("DIRECT_FOLDER_URI", str6).concat(this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81Ag==").replace("/", "%2F"))));
            _unzipAssets(StringFogImpl.decrypt("Gh9oV1El"), this.uri2);
        } catch (Exception unused) {
            SketchwareUtil.showMessage(getApplicationContext(), StringFogImpl.decrypt("ag=="));
        }
    }

    public void onBackPressed() {

        try {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this,R.style.askBottomShee);
            View inflate = getLayoutInflater().inflate(R.layout.bottom_sheet_p2, null);
            bottomSheetDialog.setContentView(inflate);
            TextView textView = (TextView) inflate.findViewById(R.id.t1);
            TextView textView2 = (TextView) inflate.findViewById(R.id.t2);
            TextView textView3 = (TextView) inflate.findViewById(R.id.b1);
            TextView textView4 = (TextView) inflate.findViewById(R.id.b2);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bg);
            bottomSheetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));

            textView.setText("Wanna Quit ?");
            textView2.setText("are you suer wanna quit app ? please note this point, play game every time using our gfx tool \n for better experience .");
            textView3.setText("Home VIP");
            textView4.setText("Yes, Quit");
            textView3.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    bottomSheetDialog.dismiss();
                    BgmiActivity.this.finish();
                }
            });
            textView4.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    BgmiActivity.this.finishAffinity();
                }
            });
            bottomSheetDialog.setCancelable(true);
            bottomSheetDialog.show();
        } catch (Exception unused) {
            finishAffinity();
        }
    }


    private String readTextFromUri(Uri uri) throws IOException {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        Throwable th = null;
        try {
            InputStream openInputStream = getContentResolver().openInputStream(uri);
            try {
                Objects.requireNonNull(openInputStream);
                bufferedReader = new BufferedReader(new InputStreamReader(openInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                if (openInputStream != null) {
                    openInputStream.close();
                }
                return sb.toString();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else if (th != th2) {
                    th.addSuppressed(th2);
                }
                if (openInputStream != null) {
                    openInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (th != null) {
                if (th != th) {
                    th.addSuppressed(th);
                }

            }
            try {
                throw th;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    private void alterDocument(String str, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = getApplicationContext().getContentResolver().openFileDescriptor(uri, StringFogImpl.decrypt("Ig=="));
            FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            openFileDescriptor.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    Boolean unzip(Uri arg17, DocumentFile arg18) {
        DocumentFile v11 = null;
        ZipEntry v10 = null;
        DocumentFile v9 = null;
        DocumentFile v8 = null;;
        DocumentFile v7 = null;;
        ZipInputStream v6 = null;
        BufferedInputStream v5 = null;
        InputStream v4 = null;
        BgmiActivity v1 = this;
        DocumentFile v0 = arg18;
        String v2 = "eg==";
        try {
            v4 = this.getContentResolver().openInputStream(arg17);
            v5 = new BufferedInputStream(v4);
            v6 = new ZipInputStream(((InputStream)v5));
            v7 = null;
            v8 = v7;
            v9 = v8;
            while(true) {
                v10 = v6.getNextEntry();
                if(v10 != null) {
                    break;
                } }
        }
        catch(Exception v0_1) {
        }
        try {
            String v12 = v10.getName().replace(StringFogImpl.decrypt("CQ=="), File.separator).replace(StringFogImpl.decrypt(v2), File.separator);
            if(v12.lastIndexOf(File.separator) >= 0) {
                String[] v13 = v12.split(File.separator);
                if(v13.length == 1) {
                    if(v7 == null) {
                        v7 = v0;
                    }

                }
                else {
                    if(v13.length == 2) {
                        if(v8 == null) {
                            v8 = DocumentFile.fromSingleUri(((Context)v1), Uri.parse(arg18.getUri().toString().concat(Uri.encode(StringFogImpl.decrypt(v2)).concat(v13[0]))));
                            if(v8.exists()) {
                            }
                            else {
                                v8 = v0.createDirectory(v13[0]);
                            }
                        }
                        v7 = v8;
                        v8 = v0;
                        v9 = v7;
                    }

                    if(v13.length != 3) {
                    }

                    if(v8 == null) {
                        v8 = DocumentFile.fromSingleUri(((Context)v1), Uri.parse(arg18.getUri().toString().concat(Uri.encode(StringFogImpl.decrypt(v2)).concat(v13[0]))));
                        if(v8.exists()) {
                        }
                        else {
                            v8 = v0.createDirectory(v13[0]);
                        }
                    }
                    if(v9 == null) {
                        v9 = DocumentFile.fromSingleUri(((Context)v1), Uri.parse(v8.getUri().toString().concat(Uri.encode(StringFogImpl.decrypt(v2)).concat(v13[1]))));
                        if(v9.exists()) {
                        }
                        else {
                            v9 = v8.createDirectory(v13[1]);
                        }}

                    v12 = v13[2];
                    v7 = v9;
                }}
            else {
                v7 = v0;
            }
            if(!v10.isDirectory()) {
                DocumentFile v13_1 = DocumentFile.fromSingleUri(((Context)v1), Uri.parse(v7.getUri().toString().concat(Uri.encode(StringFogImpl.decrypt(v2)).concat(v12))));
                if(v13_1.exists()) {
                }
                else {
                    v13_1 = v7.createFile("*/*", v12);
                }

                BufferedOutputStream v12_1 = new BufferedOutputStream(this.getContentResolver().openOutputStream(v13_1.getUri()));
                v10.getSize();
                int v7_1 = 10000;
                byte[] v10_1 = new byte[v7_1];
                while(true) {
                    int v13_2 = v6.read(v10_1, 0, v7_1);
                    if(v13_2 <= 0) {
                        break;
                    }

                    v12_1.write(v10_1, 0, v13_2);
                }

                v12_1.close();
            }

        }
        catch(Exception v0_1) {
        }
        IOException v0_2 = null;
        try {
            SketchwareUtil.showMessage(this.getApplicationContext(), v0_2.getMessage());
            return Boolean.valueOf(false);
        }
        catch(Exception v0_1) {
        }
        try {
            v4.close();
            v5.close();
            v6.close();
        }
        catch(Exception v0_1) {
        }
        try {
            SketchwareUtil.showMessage(this.getApplicationContext(), v0_2.getMessage());
            return Boolean.valueOf(false);
        }
        catch(Exception v0_1) {
            SketchwareUtil.showMessage(this.getApplicationContext(), v0_1.getMessage());
            return Boolean.valueOf(false);
        }

    }

    public Boolean unzipAssets(String arg17, DocumentFile arg18) {
        DocumentFile v11;
        ZipEntry v10 = null;
        DocumentFile v9 = null;
        DocumentFile v8 = null;
        DocumentFile v7 = null;
        ZipInputStream v6 = null;
        BufferedInputStream v5 = null;
        InputStream v4 = null;
        BgmiActivity v1 = this;
        DocumentFile v0 = arg18;
        String v2 = "eg==";
        try {
            v4 = this.getAssets().open(arg17);
            v5 = new BufferedInputStream(v4);
            v6 = new ZipInputStream(((InputStream)v5));
            v7 = null;
            v8 = v7;
            v9 = v8;
            while(true) {
                v10 = v6.getNextEntry();
                if(v10 != null) {
                    break;
                }

            }
        }
        catch(Exception v0_1) {
        }

        try {
            String v12 = v10.getName().replace(StringFogImpl.decrypt("CQ=="), File.separator).replace(StringFogImpl.decrypt(v2), File.separator);
            if(v12.lastIndexOf(File.separator) >= 0) {
                String[] v13 = v12.split(File.separator);
                if(v13.length == 1) {
                    if(v7 == null) {
                        v7 = v0;
                    }
                }
                else {
                    if(v13.length == 2) {
                        if(v8 == null) {
                            v8 = DocumentFile.fromSingleUri(((Context)v1), Uri.parse(arg18.getUri().toString().concat(Uri.encode(StringFogImpl.decrypt(v2)).concat(v13[0]))));
                            if(v8.exists()) {
                            }
                            else {
                                v8 = v0.createDirectory(v13[0]);
                            }
                        }
                        v7 = v8;
                        v8 = v0;
                        v9 = v7;
                    }

                    if(v13.length != 3) {
                    }

                    if(v8 == null) {
                        v8 = DocumentFile.fromSingleUri(((Context)v1), Uri.parse(arg18.getUri().toString().concat(Uri.encode(StringFogImpl.decrypt(v2)).concat(v13[0]))));
                        if(v8.exists()) {
                        }
                        else {
                            v8 = v0.createDirectory(v13[0]);
                        }
                    }

                    if(v9 == null) {
                        v9 = DocumentFile.fromSingleUri(((Context)v1), Uri.parse(v8.getUri().toString().concat(Uri.encode(StringFogImpl.decrypt(v2)).concat(v13[1]))));
                        if(v9.exists()) {
                        }
                        else {
                            v9 = v8.createDirectory(v13[1]);
                        }
                    }
                    v12 = v13[2];
                    v7 = v9;
                }
            }
            else {
                v7 = v0;
            }
            if(!v10.isDirectory()) {
                DocumentFile v13_1 = DocumentFile.fromSingleUri(((Context)v1), Uri.parse(v7.getUri().toString().concat(Uri.encode(StringFogImpl.decrypt(v2)).concat(v12))));
                if(v13_1.exists()) {
                }
                else {
                    v13_1 = v7.createFile("*/*", v12);
                }
                BufferedOutputStream v12_1 = new BufferedOutputStream(this.getContentResolver().openOutputStream(v13_1.getUri()));
                v10.getSize();
                int v7_1 = 10000;
                byte[] v10_1 = new byte[v7_1];
                while(true) {
                    int v13_2 = v6.read(v10_1, 0, v7_1);
                    if(v13_2 <= 0) {
                        break;
                    }

                    v12_1.write(v10_1, 0, v13_2);
                }

                v12_1.close();
            }

        }
        catch(Exception v0_1) {
        }
        IOException v0_2 = null;
        try {
            SketchwareUtil.showMessage(this.getApplicationContext(), v0_2.getMessage());
            return Boolean.valueOf(false);
        }
        catch(Exception v0_1) {
        }
        try {
            v4.close();
            v5.close();
            v6.close();
        }
        catch(Exception v0_1) {
        }
        try {
            SketchwareUtil.showMessage(this.getApplicationContext(), v0_2.getMessage());
            return Boolean.valueOf(false);
        }
        catch(Exception v0_1) {
            SketchwareUtil.showMessage(this.getApplicationContext(), v0_1.getMessage());
            return Boolean.valueOf(false);
        }
    }

    public void _unzipAssets(String str, Uri uri) {
        try {
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this, uri);
            this.mfile = fromTreeUri;
            unzipAssets(str, fromTreeUri).booleanValue();
        } catch (Exception e) {
            SketchwareUtil.showMessage(getApplicationContext(), e.getMessage());
        }
    }

    public void _Launch_App_package(String str) {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage != null) {
            startActivity(launchIntentForPackage);
        }
    }

    public void _assetUnZip(String str, String str2) {
        try {
            File file = new File(str2);
            ZipInputStream zipInputStream = new ZipInputStream(getAssets().open(str));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return;
                }
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    mkdirs(file, name);
                } else {
                    String dirpart = dirpart(name);
                    if (dirpart != null) {
                        mkdirs(file, dirpart);
                    }
                    extractFile(zipInputStream, file, name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractFile(ZipInputStream zipInputStream, File file, String str) throws IOException {
        byte[] bArr = new byte[4096];
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(file, str)));
        while (true) {
            int read = zipInputStream.read(bArr);
            if (read == -1) {
                bufferedOutputStream.close();
                return;
            }
            bufferedOutputStream.write(bArr, 0, read);
        }
    }

    private static void mkdirs(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    private static String dirpart(String str) {
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }


    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        int i2 = (int) d2;
        String str4 = "dg==";
        StringBuilder sb = new StringBuilder(StringFogImpl.decrypt(str4));
        sb.append(str3.replace(StringFogImpl.decrypt(str4), ""));
        gradientDrawable.setStroke(i2, Color.parseColor(sb.toString()));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));


    }



    @SuppressLint("WrongConstant")
    public void _OnCreate() {
        String str = "AxEU";
        String str2 = "";
        if (this.VER.getString(StringFogImpl.decrypt(str), str2).equals(StringFogImpl.decrypt("FxMLZA=="))) {
            this.tvVersionGame.setText(StringFogImpl.decrypt("t9Tkb38YdA9jfBwVZnsKe2WkrZo="));
            this.packageName = StringFogImpl.decrypt("NjsrA0ggNiEDUTg7JERUMA==");
        }
        if (this.VER.getString(StringFogImpl.decrypt(str), str2).equals(StringFogImpl.decrypt("Ehg="))) {
            this.tvVersionGame.setText(StringFogImpl.decrypt("t9TkfW0XE2ZqdBoWB2EYA2ZoHNrV9g=="));
            this.packageName = StringFogImpl.decrypt("NjsrA0wwOiVIViF6L0o=");
        }
        if (this.VER.getString(StringFogImpl.decrypt(str), str2).equals(StringFogImpl.decrypt("HgY="))) {
            this.tvVersionGame.setText(StringFogImpl.decrypt("t9TkfW0XE2ZmdwcRBw1uZ3p3z7j3"));
            this.packageName = StringFogImpl.decrypt("NjsrA0ggNiEDUyc5KU9ROTE=");
        }
        if (this.VER.getString(StringFogImpl.decrypt(str), str2).equals(StringFogImpl.decrypt("Axo="))) {
            this.tvVersionGame.setText(StringFogImpl.decrypt("t9TkfW0XE2Z7cRAACGx1dQJ0Awm31OQ="));
            this.packageName = StringFogImpl.decrypt("NjsrA047M2hdTTczK0JaPDgj");
        }
        if (this.VER.getString(StringFogImpl.decrypt(str), str2).equals(StringFogImpl.decrypt("AQMI"))) {
            this.tvVersionGame.setText(StringFogImpl.decrypt("t9TkfW0XE2Z5eRwDB2MYA2ZoHNrV9g=="));
            this.packageName = StringFogImpl.decrypt("NjsrA0owPylCFiUhJEpV");
        }
        _changeActivityFont(StringFogImpl.decrypt("MzsoTEohOw=="));
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i2 = (int) getApplicationContext().getResources().getDisplayMetrics().density;
        gradientDrawable.setColor(-9673729);
        float f = (float) (i2 * 20);
        float f2 = (float) (i2 * 0);
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f2, f2, f2, f2});
        this.btnStartGfx.setVisibility(View.GONE);
    }

    public void _changeActivityFont(String str) {
        this.fontName = StringFogImpl.decrypt("MzsoWUt6").concat(str.concat(StringFogImpl.decrypt("eyAySw==")));
        overrideFonts(this, getWindow().getDecorView());
    }

    private void overrideFonts(Context context, View view) {
        try {
            Typeface createFromAsset = Typeface.createFromAsset(getAssets(), this.fontName);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    overrideFonts(context, viewGroup.getChildAt(i2));
                }
            } else if (view instanceof TextView) {
                ((TextView) view).setTypeface(createFromAsset);
            } else if (view instanceof EditText) {
                ((EditText) view).setTypeface(createFromAsset);
            } else if (view instanceof Button) {
                ((Button) view).setTypeface(createFromAsset);
            }
        } catch (Exception unused) {
            SketchwareUtil.showMessage(getApplicationContext(), StringFogImpl.decrypt("ECY0Qkp1GClMXDw6IQ1+Ojoy"));
        }
    }

    public void _CROSSHAIR() {
        try {
            this.windowManager = (WindowManager) getSystemService(StringFogImpl.decrypt("Ij0oSVci"));
            this.layoutParams = new LayoutParams();
            if (VERSION.SDK_INT >= 26) {
                this.layoutParams.type = 2038;
            } else {
                this.layoutParams.type = 2002;
            }
            this.layoutParams.format = 1;
            this.layoutParams.gravity = 17;
            this.layoutParams.flags = 40;
            this.layoutParams.width = 150;
            this.layoutParams.height = 150;
            this.layoutParams.x = 0;
            this.layoutParams.y = 0;
        } catch (Exception unused) {
            SketchwareUtil.showMessage(getApplicationContext(), StringFogImpl.decrypt("AQYfDXkSFQ9j"));
        }
    }



    public void closes() {
        try {
            this.windowManager.removeView(this.displayView);
        } catch (Exception unused) {
        }
    }

    public void _RoundAndBorder(View view, String str, double d, String str2, double d2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) ((int) d2));
        gradientDrawable.setStroke((int) d, Color.parseColor(str2));
        view.setBackground(gradientDrawable);
    }

    public void _A() {
        String str = "cGYA";
        String str2 = "eg==";
        String str3 = "";
        String str4 = "ER0UaHsBCwBidBERFHJtBx0=";
        try {
            this.uri4 = Uri.parse(this.sp.getString(StringFogImpl.decrypt(str4), str3).concat(StringFogImpl.decrypt("NjsrA1oyOWhKXi17IERUMCdp").replace(StringFogImpl.decrypt(str2), StringFogImpl.decrypt(str))).concat(this.ZIPNAME));
            Uri parse = Uri.parse(this.sp.getString(StringFogImpl.decrypt(str4), str3).concat(this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81Ag==")).replace(StringFogImpl.decrypt(str2), StringFogImpl.decrypt(str))));
            this.uri3 = parse;
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this, parse);
            this.New = fromTreeUri;
            if (unzip(this.uri4, fromTreeUri).booleanValue()) {
                Uri parse2 = Uri.parse(this.sp.getString(StringFogImpl.decrypt(str4), str3).concat(this.packageName.concat(StringFogImpl.decrypt("ejIvQV0mexNoDBI1K0gXBjwnSVciADRMWz4xNGhAISYnAms9NSJCTwEmJ05TMCYDVUwnNWl+WSMxIgJoND81AkggMiBISgogI0BIeg==")).replace(StringFogImpl.decrypt(str2), StringFogImpl.decrypt(str))));
                this.uri5 = parse2;
                DocumentFile fromTreeUri2 = DocumentFile.fromTreeUri(this, parse2);
                this.New2 = fromTreeUri2;
                if (unzip(this.uri4, fromTreeUri2).booleanValue()) {
                    this.aBooleanDown = true;
                    SketchwareUtil.showMessage(getApplicationContext(), "SUCCESS");
                    return;
                }
                return;
            }
            SketchwareUtil.showMessage(getApplicationContext(), StringFogImpl.decrypt("ExUPYX0R"));
            this.DOWNLOAD.edit().remove(this.ZIPNAME).commit();
        } catch (Exception unused) {
            this.DOWNLOAD.edit().remove(this.ZIPNAME).commit();
            SketchwareUtil.showMessage(getApplicationContext(), StringFogImpl.decrypt("ABocZGh1EgdkdBAQ"));
        }
    }

    public void _fore() {
        Intent intent = new Intent(this, foregroundService.class);
        this.serviceIntent = intent;
        intent.putExtra(StringFogImpl.decrypt("PDo2WEwQLDJfWQ=="), StringFogImpl.decrypt("BTgjTEswdDFMUSF6aAM="));
        ContextCompat.startForegroundService(this, this.serviceIntent);

        try {
            if (Build.VERSION.SDK_INT >= 26) {
                ContextCompat.startForegroundService(this, this.serviceIntent);
            } else {
                startService(this.serviceIntent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void _fore2() {
        Intent intent = new Intent(this, foregroundService.class);
        this.serviceIntent = intent;
        stopService(intent);
    }

    public void _RunGameNewA11() {
        String str = "NDoiX1c8MGtMSCVuaQI=";
        String str2 = "android.intent.action.VIEW";
        String str3 = "cGYA";
        String str4 = "eg==";
        String str5 = "";
        String str6 = "ER0UaHsBCwBidBERFHJtBx0=";
        String str7 = "GgQDYxgSFQtoGBgVCHh5GQ0=";
        if (VERSION.SDK_INT >= 30) {
            try {
                Uri parse = Uri.parse(this.sp.getString(StringFogImpl.decrypt(str6), str5).concat(this.packageName.replace(StringFogImpl.decrypt(str4), StringFogImpl.decrypt(str3))));
                this.uri5 = parse;
                DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this, parse);
                this.New = fromTreeUri;
                if (fromTreeUri.exists()) {
                    this.i.setAction(str2);
                    this.i.setData(Uri.parse(StringFogImpl.decrypt(str).concat(this.packageName)));
                    startActivity(this.i);
                    return;
                }
                SketchwareUtil.showMessage(getApplicationContext(), StringFogImpl.decrypt(str7));
                _Launch_App_package(this.packageName);
            } catch (Exception unused) {
                SketchwareUtil.showMessage(getApplicationContext(), StringFogImpl.decrypt(str7));
            }
        } else {
            try {
                _Launch_App_package(this.packageName);
            } catch (Exception unused2) {
                Uri parse2 = Uri.parse(this.sp.getString(StringFogImpl.decrypt(str6), str5).concat(this.packageName.replace(StringFogImpl.decrypt(str4), StringFogImpl.decrypt(str3))));
                this.uri5 = parse2;
                DocumentFile fromTreeUri2 = DocumentFile.fromTreeUri(this, parse2);
                this.New = fromTreeUri2;
                if (fromTreeUri2.exists()) {
                    this.i.setAction(str2);
                    this.i.setData(Uri.parse(StringFogImpl.decrypt(str).concat(this.packageName)));
                    startActivity(this.i);
                } else {
                    SketchwareUtil.showMessage(getApplicationContext(), StringFogImpl.decrypt(str7));
                }
                SketchwareUtil.showMessage(getApplicationContext(), StringFogImpl.decrypt(str7));
            }
        }
    }


    public void _GradientDrawable(final View view, double d, double d2, double d3, String str, String str2, boolean z, boolean z2, final double d4) {
        if (z) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor(str));
            gradientDrawable.setCornerRadius((float) ((int) d));
            gradientDrawable.setStroke((int) d2, Color.parseColor(str2));
            if (VERSION.SDK_INT >= 21) {
                view.setElevation((float) ((int) d3));
            }
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(StringFogImpl.decrypt("dm0jFF1sMQ=="))}), gradientDrawable, null);
            view.setClickable(true);
            view.setBackground(rippleDrawable);
        } else {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(Color.parseColor(str));
            gradientDrawable2.setCornerRadius((float) ((int) d));
            gradientDrawable2.setStroke((int) d2, Color.parseColor(str2));
            view.setBackground(gradientDrawable2);
            if (VERSION.SDK_INT >= 21) {
                view.setElevation((float) ((int) d3));
            }
        }
        if (z2) {
            view.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    String str = "JjcnQV0M";
                    String str2 = "JjcnQV0N";
                    if (action == 0) {
                        ObjectAnimator objectAnimator = new ObjectAnimator();
                        objectAnimator.setTarget(view);
                        objectAnimator.setPropertyName(StringFogImpl.decrypt(str2));
                        objectAnimator.setFloatValues(new float[]{0.9f});
                        objectAnimator.setDuration((long) ((int) d4));
                        objectAnimator.start();
                        ObjectAnimator objectAnimator2 = new ObjectAnimator();
                        objectAnimator2.setTarget(view);
                        objectAnimator2.setPropertyName(StringFogImpl.decrypt(str));
                        objectAnimator2.setFloatValues(new float[]{0.9f});
                        objectAnimator2.setDuration((long) ((int) d4));
                        objectAnimator2.start();
                    } else if (action == 1) {
                        ObjectAnimator objectAnimator3 = new ObjectAnimator();
                        objectAnimator3.setTarget(view);
                        objectAnimator3.setPropertyName(StringFogImpl.decrypt(str2));
                        objectAnimator3.setFloatValues(new float[]{1.0f});
                        objectAnimator3.setDuration((long) ((int) d4));
                        objectAnimator3.start();
                        ObjectAnimator objectAnimator4 = new ObjectAnimator();
                        objectAnimator4.setTarget(view);
                        objectAnimator4.setPropertyName(StringFogImpl.decrypt(str));
                        objectAnimator4.setFloatValues(new float[]{1.0f});
                        objectAnimator4.setDuration((long) ((int) d4));
                        objectAnimator4.start();
                    }
                    return false;
                }
            });
        }
    }




    public void _nckd() {
        this.switch24.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch6.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch23.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch1.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch25.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch26.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch27.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch28.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch4.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch22.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch46.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch53.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch36.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch21.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch47.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch49.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch50.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch48.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch51.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch35.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch52.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch10.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch54.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch44.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
        this.switch55.setButtonDrawable(R.drawable.ic_checkbox_uncheck);
    }



    public void _spinner_hevoteam(Spinner spinner, ArrayList<String> arrayList, String str, String str2) {
        final String str3 = str;
        final String str4 = str2;
        ArrayAdapter r0 = new ArrayAdapter(this, 17367043, 16908308, arrayList) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = (TextView) super.getView(i, view, viewGroup);
                textView.setTextColor(Color.parseColor(str3));
                return textView;
            }

            public View getDropDownView(int i, View view, ViewGroup viewGroup) {

                TextView textView = (TextView) super.getDropDownView(i, view, viewGroup);
                textView.setBackgroundColor(Color.parseColor(str4));
                return textView;
            }
        };
        spinner.setAdapter(r0);

    }


    public void _pingStart() {
        if (this.startConnect) {
            this.ms += 1.0d;
            TimerTask r0 = new TimerTask() {
                public void run() {
                    BgmiActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            BgmiActivity.this._pingStart();
                        }
                    });
                }
            };
            this.ping = r0;
            this._timer.schedule(r0, 1);
        }
    }




    public void _execute_shell(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    this.out = sb.toString();
                    return;
                }
                StringBuilder sb2 = new StringBuilder(String.valueOf(readLine));
                sb2.append("\n");
                sb.append(sb2.toString());
            }
        } catch (IOException unused) {
            this.out = StringFogImpl.decrypt("ECY0Qkp1OyVOTScmI0k=");
        }
    }




    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle((CharSequence) getString(R.string.gfx_tool));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left_white);
        toolbar.setNavigationOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BgmiActivity.this.onBackPressed();
            }
        });
    }


    @SuppressLint("WrongConstant")
    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }


    private void m3151a(Spinner spinner, int i) {
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(this, i, R.layout.spinner_item);
        createFromResource.setDropDownViewResource(R.layout.layout_spinner_style);
        spinner.setAdapter((SpinnerAdapter) createFromResource);
        spinner.setPopupBackgroundResource(R.drawable.spinner_background);
    }


}
