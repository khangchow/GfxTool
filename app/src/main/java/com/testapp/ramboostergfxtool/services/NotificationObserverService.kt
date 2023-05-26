package com.testapp.ramboostergfxtool.services

import android.preference.PreferenceManager
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.testapp.ramboostergfxtool.MyApp
import com.testapp.ramboostergfxtool.R
import com.testapp.ramboostergfxtool.local.GameDatabase
import com.testapp.ramboostergfxtool.usecase.WhitelistUseCase

class NotificationObserverService : NotificationListenerService() {
    companion object {
        var instance: NotificationObserverService? = null

        fun getActiveNotifications(): Array<StatusBarNotification> = if (instance != null) instance!!.activeNotifications else emptyArray()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean(
                MyApp.getContext().getString(
                    R.string.notify_access
                ), false
            )
        ) {
            GameDatabase.getInstance(this).settingsDao.getNotifyAppItemById(MyApp.getContext().packageName)
                .let { whitelist ->
                    activeNotifications.forEach {
                        if (WhitelistUseCase.isNotifyAppExisted(it.packageName, whitelist).not()) {
                            cancelNotification(it.key)
                        }
                    }
                }
        }
    }
}