package com.testapp.ramboostergfxtool.util

import android.app.ActivityManager
import android.media.AudioManager
import android.net.wifi.WifiManager
import android.preference.PreferenceManager
import com.testapp.ramboostergfxtool.MyApp
import com.testapp.ramboostergfxtool.R
import com.testapp.ramboostergfxtool.local.GameDatabase
import com.testapp.ramboostergfxtool.local.entity.Settings
import com.testapp.ramboostergfxtool.services.GameModeService

object SettingsModeUtils {
    private const val DEFAULT_SETTINGS = "DEFAULT_SETTINGS"
    private var currentMode = GameModeService.NORMAL_MODE

    fun saveDefaultSettings() {
        GameDatabase.getInstance(MyApp.getContext()).settingsDao.getItemById(
            DEFAULT_SETTINGS
        ).apply {
            GameDatabase.getInstance(MyApp.getContext())
                .upSert((if (size > 0) this[0] else Settings()).apply {
                    pkgName = DEFAULT_SETTINGS
                    isGameMode = false
                    isClearApps = false
                    wifi = checkWifiOnAndConnected()
                    isBrightness =
                        android.provider.Settings.System.getInt(
                            MyApp.getContext().contentResolver,
                            android.provider.Settings.System.SCREEN_BRIGHTNESS,  /* default value */
                            0
                        ) == android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
                    brightnessValue =
                        android.provider.Settings.System.getInt(
                            MyApp.getContext().contentResolver,
                            "screen_brightness",
                            -1
                        )
                    if (currentMode == GameModeService.NORMAL_MODE) {
                        (MyApp.getContext().getSystemService("audio") as AudioManager).let {
                            ringtoneValue = it.getStreamVolume(2)
                            mediaValue = it.getStreamVolume(3)
                        }
                    }
                    isRingtone = false
                    isMedia = false
                    isAutoReject = false
                    isNotify = false
                })
        }
    }

    private fun checkWifiOnAndConnected() =
        (MyApp.getContext().getSystemService("wifi") as WifiManager).run {
            !(isWifiEnabled.not() || connectionInfo.networkId == -1)
        }

    fun applySettings(mode: Int) {
        currentMode = mode
        when (mode) {
            GameModeService.NORMAL_MODE, GameModeService.SILENT_MODE -> {
                GameDatabase.getInstance(MyApp.getContext()).settingsDao.getItemById(
                    DEFAULT_SETTINGS
                ).apply {
                    if (size > 0) {
                        this[0].let { settings ->
                            (MyApp.getContext().applicationContext.getSystemService("wifi") as WifiManager).isWifiEnabled =
                                settings.wifi
                            if (settings.isBrightness) {
                                android.provider.Settings.System.putInt(
                                    MyApp.getContext().contentResolver,
                                    android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE,
                                    android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
                                )
                            } else {
                                android.provider.Settings.System.putInt(
                                    MyApp.getContext().contentResolver,
                                    android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE,
                                    android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL
                                )
                            }
                            android.provider.Settings.System.putInt(
                                MyApp.getContext().contentResolver,
                                "screen_brightness",
                                settings.brightnessValue
                            )
                            (MyApp.getContext().getSystemService("audio") as AudioManager).let {
                                if (mode == GameModeService.NORMAL_MODE) {
                                    it.setStreamVolume(2, settings.ringtoneValue, 0)
                                    it.setStreamVolume(3, settings.mediaValue, 0)
                                } else {
                                    it.setStreamVolume(2, 0, 0)
                                    it.setStreamVolume(3, 0, 0)
                                }
                            }
                            PreferenceManager.getDefaultSharedPreferences(MyApp.getContext()).edit()
                                .apply {
                                    putBoolean(
                                        MyApp.getContext().getString(R.string.notify_access),
                                        settings.isNotify
                                    )
                                    putBoolean(
                                        MyApp.getContext().getString(R.string.auto_reject),
                                        settings.isAutoReject
                                    )
                                    apply()
                                }
                        }
                    }
                }
            }
            GameModeService.GAME_MODE -> {
                GameDatabase.getInstance(MyApp.getContext()).settingsDao.getItemById(MyApp.getContext().packageName)
                    .apply {
                        if (size > 0) this[0].let { settings ->
                            if (settings.isGameMode) {
                                (MyApp.getContext().applicationContext.getSystemService("wifi") as WifiManager).isWifiEnabled =
                                    settings.wifi
                                if (settings.isBrightness) {
                                    android.provider.Settings.System.putInt(
                                        MyApp.getContext().contentResolver,
                                        android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE,
                                        android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
                                    )
                                } else {
                                    android.provider.Settings.System.putInt(
                                        MyApp.getContext().contentResolver,
                                        android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE,
                                        android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL
                                    )
                                }
                                android.provider.Settings.System.putInt(
                                    MyApp.getContext().contentResolver,
                                    "screen_brightness",
                                    settings.brightnessValue
                                )
                                (MyApp.getContext().getSystemService("audio") as AudioManager).let {
                                    if (settings.isRingtone) {
                                        it.setStreamVolume(2, settings.ringtoneValue, 0)
                                    }
                                    if (settings.isMedia) {
                                        it.setStreamVolume(3, settings.mediaValue, 0)
                                    }
                                }
                                if (settings.isClearApps) {
                                    (MyApp.getContext()
                                        .getSystemService("activity") as ActivityManager).let {
                                        it.runningAppProcesses.forEach { applicationInfo ->
                                            if (applicationInfo.pid != android.os.Process.myPid() && !AppWhiteList.getInstance()
                                                    .isListApp(applicationInfo.processName)
                                            ) {
                                                android.os.Process.killProcess(applicationInfo.pid)
                                                it.killBackgroundProcesses(applicationInfo.processName)
                                            }
                                        }
                                    }
                                }
                                PreferenceManager.getDefaultSharedPreferences(MyApp.getContext())
                                    .edit().apply {
                                        putBoolean(
                                            MyApp.getContext().getString(R.string.notify_access),
                                            settings.isNotify
                                        )
                                        putString(
                                            MyApp.getContext().getString(R.string.choosen_app),
                                            settings.pkgName
                                        )
                                        putBoolean(
                                            MyApp.getContext().getString(R.string.auto_reject),
                                            settings.isAutoReject
                                        )
                                        apply()
                                    }
                            }
                        }
                    }
            }
        }
    }
}