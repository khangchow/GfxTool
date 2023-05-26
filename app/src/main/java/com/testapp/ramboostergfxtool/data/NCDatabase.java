package com.testapp.ramboostergfxtool.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class NCDatabase {
    public static final String COLUMN_ALLOW_NOTIFICATION_ALLOWED = "allowed";
    public static final String COLUMN_ALLOW_NOTIFICATION_PACKAGENAME = "packagename";
    public static final String COLUMN_NOTIFICATION_DATETIME = "datetime";
    public static final String COLUMN_NOTIFICATION_ID = "id";
    public static final String COLUMN_NOTIFICATION_KEY = "nkey";
    public static final String COLUMN_NOTIFICATION_NOTIFICATION_ID = "notificationid";
    public static final String COLUMN_NOTIFICATION_PACKAGENAME = "packagename";
    public static final String COLUMN_NOTIFICATION_SUBTEXT = "subtitle";
    public static final String COLUMN_NOTIFICATION_TITLE = "title";
    public static final String TABLE_ALLOW_NOTIFICATION = "tbl_allow_notification";
    public static final String TABLE_NOTIFICATION = "tbl_notification";
    private static NCDatabase d;
    private static sqlData e;
    private final String a = NCDatabase.class.getSimpleName();
    private SQLiteDatabase b = null;
    private AtomicInteger c = new AtomicInteger();

    private static class sqlData extends SQLiteOpenHelper {
        sqlData(Context context) {
            super(context, "NSManager.db", (SQLiteDatabase.CursorFactory) null, 2);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table tbl_notification(id integer primary key autoincrement, notificationid integer, packagename text, title text, subtitle text, datetime text, nkey text)");
            sQLiteDatabase.execSQL("create table tbl_allow_notification(id integer primary key autoincrement, packagename text, allowed integer)");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i == 1) {
                sQLiteDatabase.execSQL("ALTER TABLE tbl_notification ADD COLUMN nkey TEXT;");
            }
        }
    }

    public NCDatabase(Context context) {
        try {
            e = new sqlData(context.getApplicationContext());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized NCDatabase getInstance(Context context) {
        NCDatabase nCDatabase;
        synchronized (NCDatabase.class) {
            if (d == null) {
                d = new NCDatabase(context);
            }
            nCDatabase = d;
        }
        return nCDatabase;
    }

    public synchronized void closeDatabase() {
        if (this.c.decrementAndGet() == 0) {
            try {
                if (this.b.inTransaction()) {
                    this.b.endTransaction();
                }
                if (this.b.isOpen()) {
                    this.b.close();
                }
                this.b = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String str = this.a;
        Log.e(str, "Database counter " + this.c.get());
    }

    public void deleteAllRecords(String str) {
        try {
            this.b.delete(str, null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void deleteRecord(String str, String str2, String str3) {
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            sQLiteDatabase.delete(str, str2 + "=?", new String[]{str3});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Map<String, Integer> getAllNotificationPackage(String str) {
        HashMap hashMap = new HashMap();
        try {
            Cursor query = this.b.query(str, new String[]{"packagename", COLUMN_ALLOW_NOTIFICATION_ALLOWED}, null, null, null, null, null);
            if (query.moveToFirst()) {
                do {
                    hashMap.put(query.getString(0), Integer.valueOf(query.getInt(1)));
                } while (query.moveToNext());
            }
            query.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }



    public long getTotalRowsCount(String str) {
        try {
            return DatabaseUtils.queryNumEntries(this.b, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public void insertRecord(String str, ContentValues contentValues) {
        try {
            this.b.insert(str, null, contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean isNotificationBlocked(String str) {
        boolean z = false;
        try {
            String[] strArr = {COLUMN_ALLOW_NOTIFICATION_ALLOWED};
            Cursor query = this.b.query(TABLE_ALLOW_NOTIFICATION, strArr, "packagename=?", new String[]{str}, null, null, null);
            if (query.moveToFirst() && query.getInt(0) == 1) {
                z = true;
            }
            query.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return z;
    }

    public boolean isRecordExits(String str, String str2, String str3) {
        boolean z = false;
        try {
            Cursor rawQuery = this.b.rawQuery("SELECT * FROM " + str + " WHERE " + str2 + "= '" + str3 + "'", null);
            z = rawQuery.moveToFirst();
            rawQuery.close();
            return z;
        } catch (Exception e2) {
            e2.printStackTrace();
            return z;
        }
    }

    public synchronized void openDatabase() {
        SQLiteDatabase sQLiteDatabase;
        if (this.c.incrementAndGet() == 1 && ((sQLiteDatabase = this.b) == null || !sQLiteDatabase.isOpen())) {
            this.b = e.getWritableDatabase();
        }
        String str = this.a;
        Log.e(str, "Database counter " + this.c.get());
    }

    public void updateRecord(String str, String str2, long j, String str3, String str4) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Long.valueOf(j));
            SQLiteDatabase sQLiteDatabase = this.b;
            sQLiteDatabase.update(str, contentValues, str3 + "=?", new String[]{str4});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
