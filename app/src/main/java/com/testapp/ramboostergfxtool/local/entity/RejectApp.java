package com.testapp.ramboostergfxtool.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class RejectApp implements Serializable {
    @ColumnInfo(name = "contactName")
    private String contactName;
    @PrimaryKey(autoGenerate = true)

    /* renamed from: id */
    private int id;
    @ColumnInfo(name = "srcPkgName")
    private String srcPkgName;

    public RejectApp(String contactName, String srcPkgName) {
        this.contactName = contactName;

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
}
