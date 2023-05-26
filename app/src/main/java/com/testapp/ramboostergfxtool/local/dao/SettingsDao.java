package com.testapp.ramboostergfxtool.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.testapp.ramboostergfxtool.local.entity.NotifyApp;
import com.testapp.ramboostergfxtool.local.entity.NotifyContacts;
import com.testapp.ramboostergfxtool.local.entity.RejectApp;
import com.testapp.ramboostergfxtool.local.entity.Settings;

import java.util.List;

@Dao
public interface SettingsDao {
    @Query("DELETE FROM settings WHERE pkgName = :itemName")
    void delete(String itemName);

    @Delete
    void delete(Settings... settingsArr);

    @Query("DELETE FROM notifyapp WHERE srcPkgName = :itemName")
    void deleteNA(String itemName);

    @Query("DELETE FROM notifycontacts WHERE srcPkgName = :itemName")
    void deleteNC(String itemName);

    @Query("DELETE FROM notifyapp WHERE pkgName = :itemName AND  srcPkgName=:pkgName")
    void deleteNotifyApp(String itemName, String pkgName);

    @Query("DELETE FROM notifycontacts WHERE id = :id AND  srcPkgName=:pkgName")
    void deleteNotifyContact(int id, String pkgName);

    @Query("DELETE FROM rejectapp WHERE srcPkgName = :itemName")
    void deleteReject(String itemName);

    @Query("DELETE FROM rejectapp WHERE contactName = :itemName AND  srcPkgName=:pkgName")
    void deleteRejectApp(String itemName, String pkgName);

    @Query("SELECT * FROM settings settings")
    List<Settings> getAll();

    @Query("SELECT * FROM notifyapp notifyapp")
    List<NotifyApp> getAllNotifyApps();

    @Query("SELECT * FROM notifycontacts notifycontact")
    List<NotifyContacts> getAllNotifyContacts();

    @Query("SELECT * FROM rejectapp rejectapp")
    List<RejectApp> getAllRejectApps();

    @Query("SELECT * from settings WHERE pkgName= :itemName")
    List<Settings> getItemById(String itemName);

    @Query("SELECT * from notifyapp WHERE srcPkgName= :itemName")
    List<NotifyApp> getNotifyAppItemById(String itemName);

    @Query("SELECT * from notifyapp WHERE pkgName= :itemName AND  srcPkgName=:pkgName")
    List<NotifyApp> getNotifyAppItemByIdDub(String itemName, String pkgName);

    @Query("SELECT * from notifycontacts WHERE srcPkgName= :itemName")
    List<NotifyContacts> getNotifyContactItemById(String itemName);

    @Query("SELECT * from notifycontacts WHERE id = :id")
    List<NotifyContacts> getNotifyContactItemByIdDub(int id);

    @Query("SELECT * from notifycontacts WHERE phoneNumber = :phoneNumber")
    List<NotifyContacts> getNotifyContactItemByPhoneNumber(String phoneNumber);

    @Query("SELECT * from rejectapp WHERE srcPkgName= :itemName")
    List<RejectApp> getRejectItemById(String itemName);

    @Query("SELECT * from rejectapp WHERE contactName= :itemName AND  srcPkgName=:pkgName")
    List<RejectApp> getRejectItemByIdDub(String itemName, String pkgName);

    @Insert(onConflict = 1)
    void insert(NotifyApp notifyApp);

    @Insert(onConflict = 1)
    void insert(NotifyContacts notifyContacts);

    @Insert(onConflict = 1)
    void insert(RejectApp rejectApp);

    @Insert(onConflict = 1)
    void insert(Settings settings);

    @Query("UPDATE settings SET wifi = :wifi , is_brightness=:isBrightness , brightness_value=:brightnessValue , is_ringtone=:isRingtone , ringtone_value=:ringtoneValue , is_media=:isMedia , media_value=:mediaValue , is_auto_reject=:isAutoReject , is_notify=:isNotify , is_clear_apps=:isClearApps,gameMode=:gameMode WHERE pkgName = :pkgName")
    void update(boolean wifi, boolean isBrightness, int brightnessValue , boolean isRingtone,  int ringtoneValue, boolean isMedia, int mediaValue, boolean isAutoReject, boolean isNotify, boolean isClearApps, boolean gameMode, String pkgName);

    @Query("UPDATE settings SET is_brightness = :isBrightness , brightness_value=:brightness  WHERE pkgName = :pkgName")
    void updateBrightness(boolean isBrightness, int brightness, String pkgName);

    @Query("UPDATE settings SET is_clear_apps = :isClearApps WHERE pkgName = :pkgName")
    void updateClearApps(boolean isClearApps, String pkgName);

    @Query("UPDATE settings SET gameMode = :gameMode WHERE pkgName = :pkgName")
    void updateGameMode(boolean gameMode, String pkgName);

    @Query("UPDATE settings SET is_media = :isMedia , media_value=:media  WHERE pkgName = :pkgName")
    void updateMedia(boolean isMedia, int media, String pkgName);

    @Query("UPDATE settings SET is_notify = :isNotify WHERE pkgName = :pkgName")
    void updateNotify(boolean isNotify, String pkgName);

    @Query("UPDATE settings SET is_auto_reject = :isRejectCalls WHERE pkgName = :pkgName")
    void updateRejectCalls(boolean isRejectCalls, String pkgName);

    @Query("UPDATE settings SET is_ringtone = :isRingtone , ringtone_value=:ringtone  WHERE pkgName = :pkgName")
    void updateRingtone(boolean isRingtone, int ringtone, String pkgName);

    @Query("UPDATE settings SET wifi = :wifi  WHERE pkgName = :pkgName")
    void updateWifi(String pkgName, boolean wifi);
}
