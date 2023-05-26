package com.testapp.ramboostergfxtool.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class NotifyContacts implements Serializable {
    @ColumnInfo(name = "contactName")
    private String contactName;
    @PrimaryKey
    /* renamed from: id */
    private int id;
    @ColumnInfo(name = "srcPkgName")
    private String srcPkgName;
    @ColumnInfo(name = "phoneNumber")
    private String phoneNumber;

    public NotifyContacts(int id, String contactName,  String srcPkgName, String phoneNumber) {
        this.id = id;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.srcPkgName = srcPkgName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getSrcPkgName() {
        return this.srcPkgName;
    }

    public void setSrcPkgName(String srcPkgName) {
        this.srcPkgName = srcPkgName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
