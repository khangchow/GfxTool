package com.testapp.ramboostergfxtool.services

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.preference.PreferenceManager
import android.widget.RemoteViews
import com.rvalerio.fgchecker.AppChecker
import com.testapp.ramboostergfxtool.MyApp
import com.testapp.ramboostergfxtool.R
import com.testapp.ramboostergfxtool.activity.MainActivity
import com.testapp.ramboostergfxtool.broadcast.ChangeModeReceiver
import com.testapp.ramboostergfxtool.broadcast.ClearJunkNotificationsReceiver
import com.testapp.ramboostergfxtool.util.NotificationUtils
import com.testapp.ramboostergfxtool.util.SettingsModeUtils

class GameModeService : Service() {
    private var isAppStarting = true
    private var currentMode = NORMAL_MODE
    private val preferences by lazy { PreferenceManager.getDefaultSharedPreferences(this@GameModeService) }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (currentMode == NORMAL_MODE || currentMode == SILENT_MODE) SettingsModeUtils.saveDefaultSettings()
        intent?.apply {
            when {
                hasExtra(KEY_ROLLBACK_SETTINGS) && getBooleanExtra(
                    KEY_ROLLBACK_SETTINGS,
                    false
                ) -> {
                    currentMode = preferences.getInt(KEY_CURRENT_MODE, 1)
                }
                hasExtra(KEY_SERVICE_CALLED_BY_SYSTEM)
                        && getBooleanExtra(KEY_SERVICE_CALLED_BY_SYSTEM, false)
                        && preferences.getBoolean(KEY_GAME_MODE_ENABLED, false) -> {
                    preferences.edit().putInt(KEY_CURRENT_MODE, currentMode).apply()
                    if (hasExtra(SELECTED_APP)) {
                        checkBoostedAppForegroundStatusToRollbackSettings(
                            this.getStringExtra(
                                SELECTED_APP
                            )
                        )
                    }
                    currentMode = GAME_MODE
                }
                hasExtra(KEY_SELECTED_MODE) -> {
                    currentMode = getIntExtra(KEY_SELECTED_MODE, 1)
                }
            }
        }
        sendNotification()
        return START_STICKY
    }

    private fun checkBoostedAppForegroundStatusToRollbackSettings(selectedApp: String?) {
        if (selectedApp == null) return
        AppChecker().apply {
            whenAny {
                if (!it.equals(selectedApp)) {
                    if (!isAppStarting) {
                        sendBroadcast(
                            Intent(
                                this@GameModeService,
                                ChangeModeReceiver::class.java
                            ).apply {
                                putExtra(KEY_ROLLBACK_SETTINGS, true)
                            })
                        this.stop()
                        isAppStarting = true
                    }
                } else {
                    isAppStarting = false
                }
            }.timeout(1000).start(this@GameModeService)
        }
    }

    private fun sendNotification() {
        startForeground(
            1, NotificationUtils.createNotification(
                this,
                RemoteViews(packageName, R.layout.layout_collapsed_remote_views).apply {
                    when (currentMode) {
                        NORMAL_MODE -> {
                            setInt(
                                R.id.iv_normal_mode,
                                "setBackgroundResource",
                                R.color.active_mode
                            )
                            setInt(
                                R.id.iv_game_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                            setInt(
                                R.id.iv_silent_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                        }
                        GAME_MODE -> {
                            setInt(
                                R.id.iv_normal_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                            setInt(R.id.iv_game_mode, "setBackgroundResource", R.color.active_mode)
                            setInt(
                                R.id.iv_silent_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                        }
                        SILENT_MODE -> {
                            setInt(
                                R.id.iv_normal_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                            setInt(
                                R.id.iv_game_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                            setInt(
                                R.id.iv_silent_mode,
                                "setBackgroundResource",
                                R.color.active_mode
                            )
                        }
                    }
                    setOnClickPendingIntent(
                        R.id.iv_normal_mode,
                        getChangeModePendingIntent(NORMAL_MODE)
                    )
                    setOnClickPendingIntent(
                        R.id.iv_game_mode,
                        getChangeModePendingIntent(GAME_MODE)
                    )
                    setOnClickPendingIntent(
                        R.id.iv_silent_mode,
                        getChangeModePendingIntent(SILENT_MODE)
                    )
                    if (!android.provider.Settings.Secure.getString(contentResolver, "enabled_notification_listeners").contains(
                            MyApp.getContext().packageName)) {
                        setOnClickPendingIntent(
                            R.id.iv_clear_junk_notifications,
                            getAskReadNotificationPermissionPendingIntent()
                        )
                    } else {
                        setOnClickPendingIntent(
                            R.id.iv_clear_junk_notifications,
                            getClearJunkNotificationsPendingIntent()
                        )
                    }
                    setOnClickPendingIntent(
                        R.id.iv_boost,
                        getBoostPendingIntent()
                    )
                },
                RemoteViews(packageName, R.layout.layout_expanded_remote_views).apply {
                    when (currentMode) {
                        NORMAL_MODE -> {
                            setInt(
                                R.id.ll_normal_mode,
                                "setBackgroundResource",
                                R.color.active_mode
                            )
                            setInt(
                                R.id.ll_game_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                            setInt(
                                R.id.ll_silent_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                        }
                        GAME_MODE -> {
                            setInt(
                                R.id.ll_normal_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                            setInt(R.id.ll_game_mode, "setBackgroundResource", R.color.active_mode)
                            setInt(
                                R.id.ll_silent_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                        }
                        SILENT_MODE -> {
                            setInt(
                                R.id.ll_normal_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                            setInt(
                                R.id.ll_game_mode,
                                "setBackgroundResource",
                                R.color.inactive_mode
                            )
                            setInt(
                                R.id.ll_silent_mode,
                                "setBackgroundResource",
                                R.color.active_mode
                            )
                        }
                    }
                    setOnClickPendingIntent(
                        R.id.ll_normal_mode,
                        getChangeModePendingIntent(NORMAL_MODE)
                    )
                    setOnClickPendingIntent(
                        R.id.ll_game_mode,
                        getChangeModePendingIntent(GAME_MODE)
                    )
                    setOnClickPendingIntent(
                        R.id.ll_silent_mode,
                        getChangeModePendingIntent(SILENT_MODE)
                    )
                    if (!android.provider.Settings.Secure.getString(contentResolver, "enabled_notification_listeners").contains(
                            MyApp.getContext().packageName)) {
                        setOnClickPendingIntent(
                            R.id.ll_clear_junk_noti,
                            getAskReadNotificationPermissionPendingIntent()
                        )
                    } else {
                        setOnClickPendingIntent(
                            R.id.ll_clear_junk_noti,
                            getClearJunkNotificationsPendingIntent()
                        )
                    }
                    setOnClickPendingIntent(
                        R.id.ll_boost,
                        getBoostPendingIntent()
                    )
                })
        )
        SettingsModeUtils.applySettings(currentMode)
    }

    private fun getChangeModePendingIntent(selectedMode: Int) = PendingIntent.getBroadcast(
        this.applicationContext,
        selectedMode,
        Intent(this, ChangeModeReceiver::class.java).apply {
            putExtra(KEY_SELECTED_MODE, selectedMode)
        },
        NotificationUtils.getPendingIntentFlag()
    )

    private fun getClearJunkNotificationsPendingIntent() = PendingIntent.getBroadcast(
        this.applicationContext,
        CLEAR_JUNK_NOTIFICATIONS,
        Intent(this, ClearJunkNotificationsReceiver::class.java),
        NotificationUtils.getPendingIntentFlag()
    )

    private fun getAskReadNotificationPermissionPendingIntent() = PendingIntent.getActivity(
        this.applicationContext,
        ASK_READ_NOTIFICATION_PERMISSION,
        Intent(this, MainActivity::class.java).apply {
            putExtra(KEY_ASK_READ_NOTIFICATION_PERMISSION, true)
        },
        NotificationUtils.getPendingIntentFlag()
    )

    private fun getBoostPendingIntent() = PendingIntent.getActivity(
        this.applicationContext,
        BOOST,
        Intent(this, MainActivity::class.java).apply {
            putExtra(KEY_BOOSTED_FROM_NOTI_SERVICE, true)
        },
        NotificationUtils.getPendingIntentFlag()
    )

    override fun onBind(p0: Intent?): IBinder? = null

    companion object {
        const val CHANNEL_ID = "GAME_MODE_ID"
        const val CHANNEL_NAME = "GAME_MODE"
        const val SELECTED_APP = "SELECTED_APP"
        const val KEY_ROLLBACK_SETTINGS = "KEY_ROLLBACK_SETTINGS"
        const val KEY_SERVICE_CALLED_BY_SYSTEM = "KEY_SERVICE_CALLED_BY_SYSTEM"
        const val KEY_GAME_MODE_ENABLED = "KEY_GAME_MODE_ENABLED"
        const val KEY_CURRENT_MODE = "KEY_CURRENT_MODE"
        const val KEY_SELECTED_MODE = "KEY_SELECTED_MODE"
        const val KEY_BOOSTED_FROM_NOTI_SERVICE = "KEY_BOOSTED_FROM_NOTI_SERVICE"
        const val KEY_ASK_READ_NOTIFICATION_PERMISSION = "KEY_ASK_READ_NOTIFICATION_PERMISSION"
        const val NORMAL_MODE = 1
        const val GAME_MODE = 2
        const val SILENT_MODE = 3
        const val BOOST = 4
        const val CLEAR_JUNK_NOTIFICATIONS = 5
        const val ASK_READ_NOTIFICATION_PERMISSION = 6
    }
}