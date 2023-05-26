package com.testapp.ramboostergfxtool.usecase

import android.content.ContentResolver
import android.provider.ContactsContract
import com.testapp.ramboostergfxtool.MyApp
import com.testapp.ramboostergfxtool.local.GameDatabase
import com.testapp.ramboostergfxtool.local.entity.NotifyApp
import com.testapp.ramboostergfxtool.local.entity.NotifyContacts
import com.testapp.ramboostergfxtool.util.*
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


object WhitelistUseCase {
    private val appWhiteList by lazy { AppWhiteList.getInstance() }
    private val gameDatabase by lazy { GameDatabase.getInstance(MyApp.getContext()) }
    private val context by lazy { MyApp.getContext() }

    suspend fun getClearBackgroundWhitelist(): List<AppSelectInfo> = suspendCoroutine { it.resume(appWhiteList.whiteListApp) }

    suspend fun addClearBackgroundApp(app: String) {
        suspendCoroutine<Nothing> { appWhiteList.setAppWhite(app) }
    }

    suspend fun removeClearBackgroundApp(app: String) {
        suspendCoroutine<Nothing> {  appWhiteList.mListPref(app) }
    }

    suspend fun getRejectCallsWhitelist(): List<ContactList> = suspendCoroutine { continuation ->
        val ctx = MyApp.getContext()
        val list: MutableList<ContactList> = ArrayList()
        val contentResolver: ContentResolver = ctx.contentResolver
        contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)?.let { cursor ->
            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id: String =
                        cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                    if (cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                        contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            arrayOf(id),
                            null
                        )?.let { cursorInfo ->
                            while (cursorInfo.moveToNext()) {
                                list.add(
                                    ContactList(
                                        id,
                                        cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)),
                                        cursorInfo.getString(cursorInfo.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).replace(" ", ""),
                                        isContactExisted(id, gameDatabase.settingsDao.allNotifyContacts)
                                    )
                                )
                            }
                            cursorInfo.close()
                        }
                    }
                }
                cursor.close()
            }
        }
        continuation.resume(list.sortedWith(compareBy { it.name }).distinctBy { it.id })
    }

    suspend fun addRejectCallsWhitelistContact(contact: ContactList) {
        suspendCoroutine<Nothing> {
            gameDatabase.upSertNotifyContact(
                NotifyContacts(
                    contact.id.toInt(),
                    contact.name,
                    context.packageName,
                    contact.phoneNumber
                )
            )
        }
    }

    suspend fun removeRejectCallsWhitelistContact(contact: ContactList) {
        suspendCoroutine<Nothing> {
            gameDatabase.settingsDao.deleteNotifyContact(contact.id.toInt(), context.packageName)
        }
    }

    private fun isContactExisted(id: String, contacts: List<NotifyContacts>) = contacts.firstOrNull { it.id.toString() == id } != null


    suspend fun getNotificationBlockingWhitelist(): List<AppList> = suspendCoroutine { continuation ->
        val apps = mutableListOf<AppList>()
        gameDatabase.settingsDao.getNotifyAppItemById(context.packageName).let { local ->
            context.packageManager.getInstalledPackages(0).forEach {
                if (!PrefHelper.isPack(it) && context.packageName != it.packageName) {
                    it.applicationInfo.packageName.let { pkgName ->
                        apps.add(
                            AppList(
                                it.applicationInfo.loadIcon(context.packageManager),
                                isNotifyAppExisted(pkgName, local),
                                it.applicationInfo.loadLabel(context.packageManager).toString(),
                                pkgName
                            )
                        )
                    }
                }
            }
        }
        continuation.resume(apps.sortedWith(compareBy { it.name }))
    }

    suspend fun addNotificationBlockingWhitelistApp(pkgName: String) {
        suspendCoroutine<Nothing> {
            gameDatabase.upSertNotifyApp(NotifyApp(pkgName, context.packageName))
        }
    }

    suspend fun removeNotificationBlockingWhitelistApp(pkgName: String) {
        suspendCoroutine<Nothing> {
            gameDatabase.settingsDao.deleteNotifyApp(pkgName, context.packageName)
        }
    }

    fun isNotifyAppExisted(pkgName: String, apps: List<NotifyApp>) =
        apps.firstOrNull { it.pkgName == pkgName } != null
}