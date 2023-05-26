package com.testapp.ramboostergfxtool.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.testapp.ramboostergfxtool.local.entity.AppModel;

import java.util.List;

@Dao
public interface GameDao {
    @Query("DELETE FROM appmodel WHERE pkgName = :itemName")
    void delete(String itemName);

    @Delete
    void delete(AppModel... appModelArr);

    @Query("SELECT * FROM appmodel game")
    List<AppModel> getAll();

    @Query("SELECT * from appmodel WHERE pkgName= :itemName")
    List<AppModel> getItemById(String itemName);

    @Insert(onConflict = 1)
    void insert(AppModel appModel);

    @Query("UPDATE appmodel SET isAdd = :isAdd WHERE pkgName = :foodDB")
    void update(String isAdd, boolean foodDB);

    @Query("UPDATE appmodel SET isGameMode = :isGameMode WHERE pkgName = :foodDB")
    void updateGameMode(String isGameMode, boolean foodDB);
}
