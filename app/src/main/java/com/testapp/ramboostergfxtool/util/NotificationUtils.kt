package com.testapp.ramboostergfxtool.util

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.testapp.ramboostergfxtool.MyApp
import com.testapp.ramboostergfxtool.R
import com.testapp.ramboostergfxtool.activity.MainActivity
import com.testapp.ramboostergfxtool.services.GameModeService

object NotificationUtils {
    fun createNotification(
        context: Context,
        collapsedViews: RemoteViews,
        expandedViews: RemoteViews
    ) =
        NotificationCompat.Builder(context, GameModeService.CHANNEL_ID)
            .setWhen(System.currentTimeMillis())
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setForegroundServiceBehavior(NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE)
            .setSmallIcon(R.drawable.logo)
            .setContentIntent(getPendingIntent())
            .setSound(null)
            .setAutoCancel(false)
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setCustomContentView(collapsedViews)
            .setCustomBigContentView(expandedViews)
            .build()

    fun getPendingIntentFlag() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE
        else PendingIntent.FLAG_UPDATE_CURRENT

    private fun getPendingIntent() = PendingIntent.getActivity(
        MyApp.getContext(),
        0,
        Intent(MyApp.getContext(), MainActivity::class.java),
        getPendingIntentFlag()
    )
}