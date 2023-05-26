package com.testapp.ramboostergfxtool.services

import android.os.Build
import android.preference.PreferenceManager
import android.telecom.Call
import android.telecom.CallScreeningService
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import com.testapp.ramboostergfxtool.MyApp
import com.testapp.ramboostergfxtool.R
import com.testapp.ramboostergfxtool.local.GameDatabase

@RequiresApi(Build.VERSION_CODES.N)
class RejectIncomingCallService : CallScreeningService() {
    private val context by lazy { MyApp.getContext() }
    private val gameDatabase by lazy { GameDatabase.getInstance(context) }
    private val telephonyManager by lazy { getSystemService(TelephonyManager::class.java) }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onScreenCall(callDetails: Call.Details) {
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(R.string.auto_reject), false)) {
            val number: Phonenumber.PhoneNumber
            try {
                number = PhoneNumberUtil.getInstance().parse(
                    callDetails.handle?.schemeSpecificPart,
                    telephonyManager?.networkCountryIso?.uppercase(),
                )
            } catch (exc: NumberParseException) {
                return
            }
            StringBuilder().apply {
                for (i in 1..number.numberOfLeadingZeros) append(0)
                append(number.nationalNumber)
                if (gameDatabase.settingsDao.getNotifyContactItemByPhoneNumber(this.toString()).isNotEmpty()) {
                    respondAllow(callDetails)
                } else {
                    respondNotAllow(callDetails)
                }
            }
        }
    }

    private fun respondAllow(callDetails: Call.Details) =
        respondToCall(callDetails, CallResponse.Builder().build())

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun respondNotAllow(callDetails: Call.Details) {
        respondToCall(
            callDetails,
            CallResponse.Builder()
                .setDisallowCall(true)
                .setRejectCall(true)
                .setSilenceCall(true)
                .setSkipCallLog(false)
                .setSkipNotification(true)
                .build(),
        )
    }
}