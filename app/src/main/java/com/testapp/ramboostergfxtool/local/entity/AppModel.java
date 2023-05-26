package com.testapp.ramboostergfxtool.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class AppModel implements Serializable {
    @PrimaryKey(autoGenerate = true)

    /* renamed from: id */
    private int id;
    @ColumnInfo(name = "isAdd")
    private boolean isAdd;
    @ColumnInfo(name = "isGameMode")
    private boolean isGameMode;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "pkgName")
    private String pkgName;




    public AppModel(boolean isAdd, boolean isGameMode, String name, String pkgName) {

        this.isAdd = isAdd;
        this.isGameMode = isGameMode;
        this.name = name;
        this.pkgName = pkgName;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAdd() {
        return this.isAdd;
    }

    public void setAdd(boolean isAdd) {
        this.isAdd = isAdd;
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

    public boolean isGameMode() {
        return this.isGameMode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGameMode(boolean isGameMode) {
        this.isGameMode = isGameMode;
    }
}
