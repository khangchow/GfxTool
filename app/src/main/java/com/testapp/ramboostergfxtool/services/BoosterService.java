package com.testapp.ramboostergfxtool.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.MyApp;
import com.testapp.ramboostergfxtool.util.Utils;
import com.testapp.ramboostergfxtool.util.SpacesItem;
import com.testapp.ramboostergfxtool.util.MyLog;
import com.testapp.ramboostergfxtool.util.PrefHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoosterService extends Service {
    public static final String TAG = "BoosterService";
    public static final String NAME_29 = "18";
    public static final String GAME_2 = "18 Game";
    public static final String GAME_CHANNEL = "18 Game Channel";
    private Handler handler;
    private HandlerThread handlerThread;
    private MyBroadcastReceiver myBroadcastReceiver;
    private NotificationChannel notificationChannel;
    private NotificationManager notificationManager;
    private ArrayList<String> stringArrayList = new ArrayList<>();

    @Nullable
    public IBinder onBind(Intent intent) {
        MyLog.name2(TAG, "onBind");
        return null;
    }

    private class MyBroadcastReceiver extends BroadcastReceiver {
        final BoosterService boosterService;

        private MyBroadcastReceiver(BoosterService boosterService2) {
            this.boosterService = boosterService2;
        }
        @Override
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED")) {
                if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                    this.boosterService.stringArrayList.add(intent.getData().getSchemeSpecificPart());
                }
            } else if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                this.boosterService.stringArrayList.remove(intent.getData().getSchemeSpecificPart());
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyLog.name2(TAG, "onCreate");
        NotChannel();
        new MyAsyntask(this).execute(new Void[0]);
        if (this.myBroadcastReceiver == null) {
            this.myBroadcastReceiver = new MyBroadcastReceiver(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.myBroadcastReceiver, intentFilter);
        AutoBo();
    }

    private void NotChannel() {
        int i2 = Build.VERSION.SDK_INT;
        NotificationCompat.Builder builder;

        if (i2 >= 26) {
            notificationChannel = NotManager().getNotificationChannel("channel_id_3");
            if (notificationChannel == null) {
                NotificationChannel notificationChannel2 = new NotificationChannel("channel_id_3", getString(R.string.app_name), NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel2.enableVibration(false);
                notificationChannel2.setSound(null, null);
                this.notificationManager.createNotificationChannel(notificationChannel2);
            }
        }

        if (i2 >= 26) {
            builder = new NotificationCompat.Builder(this, "channel_id_3");
        } else {
            builder = new NotificationCompat.Builder(this);
        }
        builder.setSmallIcon(R.drawable.ic_notiy_speed);
        builder.setContentTitle(getResources().getString(R.string.notification_tip));
        if (Build.VERSION.SDK_INT >= 26) {
            this.notificationChannel = new NotificationChannel(NAME_29, GAME_2, NotificationManager.IMPORTANCE_DEFAULT);
            this.notificationChannel.setDescription(GAME_CHANNEL);
            NotManager().createNotificationChannel(this.notificationChannel);
            builder.setChannelId(NAME_29);
        }

        if (i2 >= 31) {
            builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        }
        try {
            startForeground(1001, builder.build());
        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    private NotificationManager NotManager() {
        if (this.notificationManager == null) {
            this.notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return this.notificationManager;
    }

    private void AutoBo() {
        if (this.handlerThread == null) {
            this.handlerThread = new HandlerThread("AutoBoost");
            this.handlerThread.start();
        }
        if (this.handler == null) {
            this.handler = new Handler(this.handlerThread.getLooper()) {
                final BoosterService f529a = BoosterService.this;

                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what != 1) {
                        MyLog.name3(BoosterService.TAG, "mWorkerHandler Unhandled msg:" + message.what);
                        return;
                    }
                    MyLog.name2(BoosterService.TAG, "MEG_DELAY_CHECK");
                    if (!SpacesItem.isPref()) {
                        this.f529a.handler.removeMessages(1);
                        return;
                    }
                    int val = (int) ((SpacesItem.appInf(this.f529a) * 100) / SpacesItem.valR());
                    MyLog.name2(BoosterService.TAG, "startAutoBoost = " + val);
                    int i = 80;
                    if (MyApp.getMyApp().checkFileExist()) {
                        i = 25;
                    }
                    if (val > i) {
                        String str = Utils.getUtil().requst();
                        if (!TextUtils.isEmpty(str)) {
                            SpacesItem.listLog(this.f529a.stringArrayList, str);
                        }
                    }
                    this.f529a.handler.removeMessages(1);
                    sendEmptyMessageDelayed(1, 10000);
                }
            };
        }
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 10000);
        MyLog.name2(TAG, "msg delay_time");
    }

    private class MyAsyntask extends AsyncTask<Void, Void, List<String>> {
        final BoosterService boosterService;

        public MyAsyntask(BoosterService boosterService2) {
            this.boosterService = boosterService2;
        }

        @Override
        public List<String> doInBackground(Void... voidArr) {
            try {
                return PrefHelper.getInstance().listNm();
            } catch (Exception unused) {
                return null;
            }
        }

        @Override
        public void onPostExecute(List<String> list) {
            super.onPostExecute( list);
            if (list != null) {
                this.boosterService.stringArrayList.clear();
                this.boosterService.stringArrayList.addAll(list);
            }
        }

        @Override
        public void onPreExecute() {
            super.onPreExecute();
        }
    }
    @Override
    public int onStartCommand(Intent intent, int i, int i2) {
        MyLog.name2(TAG, "onStartCommand");
        AutoBo();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyBroadcastReceiver myBroadcastReceiver2 = this.myBroadcastReceiver;
        if (myBroadcastReceiver2 != null) {
            unregisterReceiver(myBroadcastReceiver2);
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeMessages(1);
            this.handler = null;
        }
    }
}
