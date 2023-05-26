package com.testapp.ramboostergfxtool.local;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.testapp.ramboostergfxtool.local.dao.GameDao;
import com.testapp.ramboostergfxtool.local.dao.SettingsDao;
import com.testapp.ramboostergfxtool.local.entity.AppModel;
import com.testapp.ramboostergfxtool.local.entity.NotifyApp;
import com.testapp.ramboostergfxtool.local.entity.NotifyContacts;
import com.testapp.ramboostergfxtool.local.entity.RejectApp;
import com.testapp.ramboostergfxtool.local.entity.Settings;

@Database(entities = {AppModel.class, Settings.class, NotifyApp.class, NotifyContacts.class, RejectApp.class}, version = 1)
public abstract class GameDatabase extends RoomDatabase {
    private static GameDatabase appDb;

    public abstract GameDao getGameDao();

    public abstract SettingsDao getSettingsDao();

    public static GameDatabase getInstance(Context context) {
        if (appDb == null) {
            appDb = buildDatabaseInstance(context);
        }
        return appDb;
    }

    private static GameDatabase buildDatabaseInstance(Context context) {
        return (GameDatabase) Room.databaseBuilder(context, GameDatabase.class, "settings.db").allowMainThreadQueries().build();
    }

    public void cleanUp() {
        appDb = null;
    }

    public void upSert(AppModel appModel) {
        if (getGameDao().getItemById(appModel.getPkgName()).size() == 0) {
            getGameDao().insert(appModel);
        } else {
            getGameDao().update(appModel.getPkgName(), appModel.isAdd());
        }
    }

    public void upSertGame(String str, boolean z) {
        if (getGameDao().getItemById(str).size() != 0) {
            getGameDao().updateGameMode(str, z);
        }
    }

    public void upSert(Settings settings) {
        if (getSettingsDao().getItemById(settings.getPkgName()).size() == 0) {
            getSettingsDao().insert(settings);
        } else {
            getSettingsDao().update(
                    settings.getWifi(), settings.isBrightness(), settings.getBrightnessValue(),
                    settings.isRingtone(), settings.getRingtoneValue(), settings.isMedia(),
                    settings.getMediaValue(), settings.isAutoReject(),
                    settings.isNotify(), settings.isClearApps(), settings.isGameMode(), settings.getPkgName());
        }
    }

    public void upSertNotifyApp(NotifyApp notifyApp) {
        if (getSettingsDao().getNotifyAppItemByIdDub(notifyApp.getPkgName(), notifyApp.getSrcPkgName()).size() == 0) {
            getSettingsDao().insert(notifyApp);
        }
    }

    public void upSertRejectyApp(RejectApp rejectApp) {
        if (getSettingsDao().getRejectItemByIdDub(rejectApp.getContactName(), rejectApp.getSrcPkgName()).size() == 0) {
            getSettingsDao().insert(rejectApp);
        }
    }

    public void upSertNotifyContact(NotifyContacts notifyContacts) {
        if (getSettingsDao().getNotifyContactItemByIdDub(notifyContacts.getId()).size() == 0) {
            getSettingsDao().insert(notifyContacts);
        }
    }

    public void upSertWifi(Settings settings) {
        if (getSettingsDao().getItemById(settings.getPkgName()).size() == 0) {
            getSettingsDao().insert(settings);
        } else {
            getSettingsDao().updateWifi(settings.getPkgName(), settings.getWifi());
        }
    }

    public void upSertBrightness(Settings settings) {
        if (getSettingsDao().getItemById(settings.getPkgName()).size() == 0) {
            getSettingsDao().insert(settings);
        } else {
            getSettingsDao().updateBrightness(settings.isBrightness(), settings.getBrightnessValue(), settings.getPkgName());
        }
    }

    public void upSertRingtone(Settings settings) {
        if (getSettingsDao().getItemById(settings.getPkgName()).size() == 0) {
            getSettingsDao().insert(settings);
        } else {
            getSettingsDao().updateRingtone(settings.isRingtone(), settings.getRingtoneValue(), settings.getPkgName());
        }
    }

    public void upSertMedia(Settings settings) {
        if (getSettingsDao().getItemById(settings.getPkgName()).size() == 0) {
            getSettingsDao().insert(settings);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(settings.getMediaValue());
        sb.append("---");
        sb.append(settings.isMedia());
        Log.e("--->DB", sb.toString());
        getSettingsDao().updateMedia(settings.isMedia(), settings.getMediaValue(), settings.getPkgName());
    }

    public void upSertRejectCalls(Settings settings) {
        if (getSettingsDao().getItemById(settings.getPkgName()).size() == 0) {
            getSettingsDao().insert(settings);
        } else {
            getSettingsDao().updateRejectCalls(settings.isAutoReject(), settings.getPkgName());
        }
    }

    public void upSertNotify(Settings settings) {
        if (getSettingsDao().getItemById(settings.getPkgName()).size() == 0) {
            getSettingsDao().insert(settings);
        } else {
            getSettingsDao().updateNotify(settings.isNotify(), settings.getPkgName());
        }
    }

    public void upSertClearApps(Settings settings) {
        if (getSettingsDao().getItemById(settings.getPkgName()).size() == 0) {
            getSettingsDao().insert(settings);
        } else {
            getSettingsDao().updateClearApps(settings.isClearApps(), settings.getPkgName());
        }
    }

    public void upSertGameMode(Settings settings) {
        if (getSettingsDao().getItemById(settings.getPkgName()).size() == 0) {
            getSettingsDao().insert(settings);
        } else {
            getSettingsDao().updateGameMode(settings.isGameMode(), settings.getPkgName());
        }
    }
}
