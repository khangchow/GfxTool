package com.testapp.ramboostergfxtool.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class GameDatabase {
    public final String GAME_TABLE = "create table tblgame(id integer primary key autoincrement, packagename text not null);";
    private SQLiteDatabase a;
    private sql b;


    public class sql extends SQLiteOpenHelper {
        public sql(GameDatabase gameDatabase, Context context) {
            super(context, "GAMEBOOSTER.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table tblgame(id integer primary key autoincrement, packagename text not null);");
        }
        @Override
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onCreate(sQLiteDatabase);
        }
    }

    public GameDatabase(Context context) {
        try {
            this.b = new sql(this, context);
        } catch (Exception unused) {
        }
    }

    public void close() {
        try {
            this.b.close();
        } catch (Exception unused) {
        }
    }

    public boolean deleteRecord(String str) {
        open();
        SQLiteDatabase sQLiteDatabase = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("packagename='");
        sb.append(str);
        sb.append("'");
        boolean z = sQLiteDatabase.delete("tblgame", sb.toString(), null) > 0;
        close();
        return z;
    }

    public void deleteTable() {
        open();
        this.a.delete("tblgame", null, null);
        close();
    }

    public ArrayList<String> getAllRecords() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            open();
            Cursor query = this.a.query("tblgame", new String[]{NCDatabase.COLUMN_NOTIFICATION_ID, "packagename"}, null, null, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        arrayList.add(query.getString(1));
                    } catch (Exception unused) {
                    }
                } while (query.moveToNext());
            }
            query.close();
            close();
        } catch (Exception unused2) {
        }
        return arrayList;
    }

    public long insertRecord(String str) {
        open();
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", str);
        long insert = this.a.insert("tblgame", null, contentValues);
        close();
        return insert;
    }

    public boolean isRecordExits(String str) {
        open();
        Cursor rawQuery = this.a.rawQuery("SELECT * FROM tblgame WHERE packagename= '" + str + "'", null);
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        close();
        return moveToFirst;
    }

    public GameDatabase open() {
        try {
            this.a = this.b.getWritableDatabase();
        } catch (Exception unused) {
        }
        return this;
    }
}
