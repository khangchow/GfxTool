package com.testapp.ramboostergfxtool.util

data class ContactList(
    val id: String,
    val name: String,
    val phoneNumber: String,
    var isAdded: Boolean = false
)