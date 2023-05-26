package com.testapp.ramboostergfxtool.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.testapp.ramboostergfxtool.services.GameModeService

class ChangeModeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        context.startService(Intent(context, GameModeService::class.java).apply {
            if (intent.hasExtra(GameModeService.KEY_SELECTED_MODE)) {
                putExtra(GameModeService.KEY_SELECTED_MODE, intent.getIntExtra(GameModeService.KEY_SELECTED_MODE, 1))
            }
            if (intent.hasExtra(GameModeService.KEY_ROLLBACK_SETTINGS)) {
                putExtra(GameModeService.KEY_ROLLBACK_SETTINGS, intent.getBooleanExtra(GameModeService.KEY_ROLLBACK_SETTINGS, false))
            }
        })
    }
}