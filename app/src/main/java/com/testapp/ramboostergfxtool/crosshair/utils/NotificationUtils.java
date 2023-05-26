package com.testapp.ramboostergfxtool.crosshair.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.activity.GfxAdvancedActivity;

public class NotificationUtils {
    private static final String CHANNEL_ID = "CHANNEL_ID_CH";
    private static final String CHANNEL_NAME = "CHANNEL_NAME_CH";
    private static final int NOTIFICATION_ID = 1;
    private NotificationCompat.Builder builder;
    private Context context;
    private NotificationManager notificationManager;

    public NotificationUtils(Context context2) {
        this.context = context2;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) this.context.getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT));
        }
    }

    public void showNotification() {
        createNotificationChannel();
        Intent intent = new Intent(this.context, GfxAdvancedActivity.class);
        intent.addFlags(Intent.FLAG_GRANT_PREFIX_URI_PERMISSION);
        PendingIntent activity = PendingIntent.getActivity(this.context, 0, intent, PendingIntent.FLAG_IMMUTABLE|PendingIntent.FLAG_CANCEL_CURRENT);
        this.builder = new NotificationCompat.Builder(this.context, CHANNEL_ID);
        this.builder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        this.builder.setSmallIcon(R.drawable.ic_chr_13);
        this.builder.setOngoing(true);
        this.builder.setContentTitle(this.context.getResources().getString(R.string.notification_title));
        this.builder.setContentText(this.context.getResources().getString(R.string.notification_content));
        this.builder.setContentIntent(activity);
        this.builder.build();
        this.notificationManager = (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);
        this.notificationManager.notify(1, this.builder.build());
    }

    public void dismissNotification() {
        NotificationManager notificationManager2 = this.notificationManager;
        if (notificationManager2 != null) {
            notificationManager2.cancel(1);
        }
    }
}
