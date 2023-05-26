package com.testapp.ramboostergfxtool

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testapp.ramboostergfxtool.activity.WhitelistActivity
import com.testapp.ramboostergfxtool.usecase.WhitelistUseCase
import com.testapp.ramboostergfxtool.util.AppList
import com.testapp.ramboostergfxtool.util.AppSelectInfo
import com.testapp.ramboostergfxtool.util.ContactList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WhitelistViewModel : ViewModel() {
    private val _clearBackgroundWhiteList = MutableLiveData<List<AppSelectInfo>>()
    val clearBackgroundWhiteList = _clearBackgroundWhiteList
    private val _rejectCallsWhiteList = MutableLiveData<List<ContactList>>()
    val rejectCallsWhiteList = _rejectCallsWhiteList
    private val _notificationBlockingWhiteList = MutableLiveData<List<AppList>>()
    val notificationBlockingWhiteList = _notificationBlockingWhiteList
    private lateinit var type: String

    fun initData(whiteListType: String) {
        type = whiteListType
        when (whiteListType) {
            WhitelistActivity.KEY_CLEAR_BACKGROUND_WHITELIST -> {
                getClearBackgroundWhiteList()
            }
            WhitelistActivity.KEY_REJECT_CALL_WHITELIST -> {
                getRejectCallsWhiteList()
            }
            WhitelistActivity.KEY_NOTIFICATION_BLOCKING_WHITELIST -> {
                getNotificationBlockingWhiteList()
            }
        }
    }

    fun updateWhiteListApp(pkgName: String, isAdd: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            when (type) {
                WhitelistActivity.KEY_CLEAR_BACKGROUND_WHITELIST -> {
                    if (isAdd) WhitelistUseCase.addClearBackgroundApp(pkgName)
                    else WhitelistUseCase.removeClearBackgroundApp(pkgName)
                }
                WhitelistActivity.KEY_NOTIFICATION_BLOCKING_WHITELIST -> {
                    if (isAdd) WhitelistUseCase.addNotificationBlockingWhitelistApp(pkgName)
                    else WhitelistUseCase.removeNotificationBlockingWhitelistApp(pkgName)
                }
            }
        }
    }

    private fun getClearBackgroundWhiteList() {
        viewModelScope.launch(Dispatchers.IO) {
            _clearBackgroundWhiteList.postValue(WhitelistUseCase.getClearBackgroundWhitelist())
        }
    }

    fun updateRejectCallWhiteListContact(contact: ContactList) {
        viewModelScope.launch(Dispatchers.IO) {
            if (contact.isAdded) WhitelistUseCase.addRejectCallsWhitelistContact(contact)
            else WhitelistUseCase.removeRejectCallsWhitelistContact(contact)
        }
    }

    private fun getNotificationBlockingWhiteList() {
        viewModelScope.launch(Dispatchers.IO) {
            _notificationBlockingWhiteList.postValue(WhitelistUseCase.getNotificationBlockingWhitelist())
        }
    }

    private fun getRejectCallsWhiteList() {
        viewModelScope.launch(Dispatchers.IO) {
            _rejectCallsWhiteList.postValue(WhitelistUseCase.getRejectCallsWhitelist())
        }
    }
}