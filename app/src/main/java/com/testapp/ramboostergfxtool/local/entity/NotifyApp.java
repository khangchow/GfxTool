package com.testapp.ramboostergfxtool.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class NotifyApp implements Serializable {
    @PrimaryKey(autoGenerate = true)

    /* renamed from: id */
    private int id;
    @ColumnInfo(name = "pkgName")
    private String pkgName;
    @ColumnInfo(name = "srcPkgName")
    private String srcPkgName;

    public NotifyApp( String pkgName, String srcPkgName) {

        this.pkgName = pkgName;
        this.srcPkgName = srcPkgName;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getSrcPkgName() {
        return this.srcPkgName;
    }

    public void setSrcPkgName(String srcPkgName) {
        this.srcPkgName = srcPkgName;
    }
}
