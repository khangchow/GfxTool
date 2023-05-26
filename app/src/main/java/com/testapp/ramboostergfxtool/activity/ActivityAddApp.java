package com.testapp.ramboostergfxtool.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.adapter.ListAppAdapter;
import com.testapp.ramboostergfxtool.ads.AdControlHelp;
import com.testapp.ramboostergfxtool.util.AppSelectInfo;
import com.testapp.ramboostergfxtool.util.LoadingDialog;
import com.testapp.ramboostergfxtool.util.PrefHelper;

import java.util.ArrayList;
import java.util.List;

public class ActivityAddApp extends AppCompatActivity {
    private static final String TAG = "ActivityAddApp";
    private List<AppSelectInfo> appSelectInfoList = new ArrayList();
    private ListAppAdapter listAppAdapter;
    private LoadingDialog loadingDialog;
    private RecyclerView recyclerView;


    
    public class taskApp extends AsyncTask<Void, Void, List<AppSelectInfo>> {
        final ActivityAddApp activityAddApp;

        public taskApp(ActivityAddApp activityAddApp2) {
            this.activityAddApp = activityAddApp2;
        }

        @Override
        public List<AppSelectInfo> doInBackground(Void... voidArr) {
            try {
                return PrefHelper.getInstance().mListInfo();
            } catch (Exception unused) {
                return null;
            }
        }

        @Override
        public void onPostExecute(List<AppSelectInfo> list) {
            super.onPostExecute( list);
            if (list != null) {
                this.activityAddApp.appSelectInfoList.clear();
                this.activityAddApp.appSelectInfoList.addAll(list);
                this.activityAddApp.listAppAdapter.setNewData(this.activityAddApp.appSelectInfoList);
            }
            this.activityAddApp.loadingDialog.mDialog();
        }

        @Override
        public void onPreExecute() {
            super.onPreExecute();
            this.activityAddApp.loadingDialog.intSh();
        }
    }
    AdControlHelp adControlHelp;
    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_app);
        intView();
        AdControlHelp adControlHelp = AdControlHelp.getInstance(this);
        this.adControlHelp = adControlHelp;
        adControlHelp.loadBanner(this, findViewById(R.id.banner));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.add_app));
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
    }

    private void intView() {
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.listAppAdapter = new ListAppAdapter(this.appSelectInfoList);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.listAppAdapter);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.header_view_height));
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.listAppAdapter.setHeaderView(view);
        this.listAppAdapter.setOnItemChildClickListener(new itemSelect(this));

        this.loadingDialog = new LoadingDialog(this, getString(R.string.loading1));
        new taskApp(this).execute(new Void[0]);
    }


    public final class itemSelect implements BaseQuickAdapter.OnItemChildClickListener {
        private final ActivityAddApp activityAddApp;

        itemSelect(ActivityAddApp activityAddApp) {
            this.activityAddApp = activityAddApp;
        }

        @Override 
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
            this.activityAddApp.SelectGame(baseQuickAdapter, view, i);
        }
    }

    
    public final void SelectGame(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        if (view.getId() == R.id.layout_add_root) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_add_app);
            AppSelectInfo appSelectInfo = this.appSelectInfoList.get(i);
            appSelectInfo.aBoolean = !appSelectInfo.aBoolean;
            if (appSelectInfo.aBoolean) {
                imageView.setImageResource(R.drawable.ic_check_circle);
                PrefHelper.getInstance().putKeyDef(appSelectInfo.myAppInfo.string);
            } else {
                imageView.setImageResource(R.drawable.ic_uncheck_circle);
                PrefHelper.getInstance().putAppString(appSelectInfo.myAppInfo.string);
            }
            setResult(-1);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
