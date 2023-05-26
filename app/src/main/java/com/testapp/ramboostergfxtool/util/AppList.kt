package com.testapp.ramboostergfxtool.util

import android.graphics.drawable.Drawable

data class AppList(
    val icon: Drawable,
    var isAdded: Boolean = false,
    val name: String,
    val pkgName: String
)
