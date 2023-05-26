package com.testapp.ramboostergfxtool.activity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.adapter.AddGameAdapter;
import com.testapp.ramboostergfxtool.ads.AdControlHelp;
import com.testapp.ramboostergfxtool.bean.GameItem;
import com.testapp.ramboostergfxtool.data.GameDatabase;
import com.testapp.ramboostergfxtool.util.GameItemComporator;
import com.testapp.ramboostergfxtool.util.Utils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class AddGameActivity extends AppCompatActivity {
    private ArrayList<GameItem> t;
    private ListView u;
    private RelativeLayout v;
    private GameDatabase w;
    private AddGameAdapter x;
    private AsyncTask<Void, Void, Void> y;
    private AdControlHelp adControlHelp;

    private static class a extends AsyncTask<Void, Void, Void> {
        private final WeakReference<AddGameActivity> a;

        public a(AddGameActivity addGameActivity) {
            this.a = new WeakReference<>(addGameActivity);
        }



        @Override
        public Void doInBackground(Void... voidArr) {
            String str;
            ApplicationInfo applicationInfo;
            AddGameActivity addGameActivity = this.a.get();
            if (addGameActivity != null && !addGameActivity.isFinishing()) {
                addGameActivity.w = new GameDatabase(addGameActivity);
                ArrayList<String> allRecords = addGameActivity.w.getAllRecords();
                ArrayList arrayList = new ArrayList(Utils.getSystemPackages());
                for (PackageInfo packageInfo : addGameActivity.getPackageManager().getInstalledPackages(0)) {
                    if (isCancelled()) {
                        break;
                    } else if (packageInfo != null && (str = packageInfo.packageName) != null && !str.equals("") && !arrayList.contains(packageInfo.packageName) && (applicationInfo = Utils.getApplicationInfo(addGameActivity, packageInfo.packageName)) != null && Utils.isUserApp(applicationInfo) && !Objects.equals(packageInfo.packageName, addGameActivity.getPackageName())) {
                        ArrayList arrayList2 = addGameActivity.t;
                        String appName = Utils.getAppName(addGameActivity, packageInfo.packageName);
                        String str2 = packageInfo.packageName;
                        GameItem gameItem = new GameItem(appName, str2, Utils.getAppIcon(addGameActivity, str2));
                        gameItem.setAdded(allRecords.contains(packageInfo.packageName));
                        arrayList2.add(gameItem);
                    }
                }
                if (addGameActivity.t.size() > 0) {
                    Collections.sort(addGameActivity.t, GameItemComporator.comporator);
                    addGameActivity.x = new AddGameAdapter(addGameActivity, R.layout.item_add_game_row, addGameActivity.t, addGameActivity.w);
                }
            }
            return null;
        }
        @Override
        public void onPostExecute(Void r3) {
            AddGameActivity addGameActivity = this.a.get();
            if (addGameActivity != null && !addGameActivity.isFinishing()) {
                if (addGameActivity.t.size() > 0) {
                    addGameActivity.u.setAdapter((ListAdapter) addGameActivity.x);
                }
                addGameActivity.v.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPreExecute() {
            AddGameActivity addGameActivity = this.a.get();
            if (addGameActivity != null && !addGameActivity.isFinishing()) {
                addGameActivity.t = new ArrayList();
            }
        }
    }



    public  void Exit(View view) {
        onBackPressed();
    }

    private void stopTast() {
        AsyncTask<Void, Void, Void> asyncTask = this.y;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopTast();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
            toolbar.setTitle(getString(R.string.add_app));
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left_white);
        }
        toolbar.setNavigationOnClickListener(view -> Exit(view));
        this.u = (ListView) findViewById(R.id.listView);
        this.v = (RelativeLayout) findViewById(R.id.rlProgress);
        AsyncTask<Void, Void, Void> asyncTask = this.y;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        a aVar = new a(this);
        this.y = aVar;
        aVar.execute(new Void[0]);

        //load ads
        this.adControlHelp = AdControlHelp.getInstance(this);
        adControlHelp.loadBanner(this, findViewById(R.id.banner));
    }
}
