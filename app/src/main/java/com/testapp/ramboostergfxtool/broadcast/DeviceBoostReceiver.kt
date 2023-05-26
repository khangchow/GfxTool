package com.testapp.ramboostergfxtool.broadcast

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.testapp.ramboostergfxtool.services.GameModeService

class DeviceBoostReceiver : BroadcastReceiver() {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context, intent: Intent) {
        context.startService(Intent(context, GameModeService::class.java))
    }
}