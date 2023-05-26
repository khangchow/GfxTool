package com.testapp.ramboostergfxtool.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.testapp.ramboostergfxtool.local.GameDatabase
import com.testapp.ramboostergfxtool.services.NotificationObserverService
import com.testapp.ramboostergfxtool.usecase.WhitelistUseCase

class ClearJunkNotificationsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            GameDatabase.getInstance(context).settingsDao.getNotifyAppItemById(context.packageName)
                .let { whitelist ->
                    NotificationObserverService.getActiveNotifications().forEach {
                        if (WhitelistUseCase.isNotifyAppExisted(it.packageName, whitelist).not()) {
                            NotificationObserverService.instance?.cancelNotification(it.key)
                        }
                    }
                }
        }
    }
}