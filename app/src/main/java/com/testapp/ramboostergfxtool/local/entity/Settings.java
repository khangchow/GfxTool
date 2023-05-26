package com.testapp.ramboostergfxtool.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Settings implements Serializable {
    @ColumnInfo(name = "brightness_value")
    private int brightnessValue;
    private boolean gameMode;
    @PrimaryKey(autoGenerate = true)

    /* renamed from: id */
    private int id;
    @ColumnInfo(name = "is_auto_reject")
    private boolean isAutoReject;
    @ColumnInfo(name = "is_brightness")
    private boolean isBrightness;
    @ColumnInfo(name = "is_clear_apps")
    private boolean isClearApps;
    @ColumnInfo(name = "is_media")
    private boolean isMedia;
    @ColumnInfo(name = "is_notify")
    private boolean isNotify;
    @ColumnInfo(name = "is_ringtone")
    private boolean isRingtone;
    @ColumnInfo(name = "media_value")
    private int mediaValue;
    @ColumnInfo(name = "pkgName")
    private String pkgName;
    @ColumnInfo(name = "ringtone_value")
    private int ringtoneValue;
    @ColumnInfo(name = "wifi")
    private boolean wifi;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public boolean getWifi() {
        return this.wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isBrightness() {
        return this.isBrightness;
    }

    public void setBrightness(boolean isBrightness) {
        this.isBrightness = isBrightness;
    }

    public int getBrightnessValue() {
        return this.brightnessValue;
    }

    public void setBrightnessValue(int i) {
        this.brightnessValue = i;
    }

    public boolean isRingtone() {
        return this.isRingtone;
    }

    public void setRingtone(boolean isRingtone) {
        this.isRingtone = isRingtone;
    }

    public int getRingtoneValue() {
        return this.ringtoneValue;
    }

    public void setRingtoneValue(int i) {
        this.ringtoneValue = i;
    }

    public boolean isMedia() {
        return this.isMedia;
    }

    public void setMedia(boolean isMedia) {
        this.isMedia = isMedia;
    }

    public int getMediaValue() {
        return this.mediaValue;
    }

    public void setMediaValue(int i) {
        this.mediaValue = i;
    }

    public boolean isAutoReject() {
        return this.isAutoReject;
    }

    public void setAutoReject(boolean isAutoReject) {
        this.isAutoReject = isAutoReject;
    }

    public boolean isNotify() {
        return this.isNotify;
    }

    public void setNotify(boolean isNotify) {
        this.isNotify = isNotify;
    }

    public boolean isClearApps() {
        return this.isClearApps;
    }

    public void setClearApps(boolean isClearApps) {
        this.isClearApps = isClearApps;
    }

    public boolean isGameMode() {
        return this.gameMode;
    }

    public void setGameMode(boolean gameMode) {
        this.gameMode = gameMode;
    }
}
