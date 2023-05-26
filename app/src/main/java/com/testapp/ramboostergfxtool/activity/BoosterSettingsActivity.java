package com.testapp.ramboostergfxtool.activity;

import android.annotation.SuppressLint;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.testapp.ramboostergfxtool.MyApp;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.ads.AdControlHelp;
import com.testapp.ramboostergfxtool.ads.InterstitialAdShow;
import com.testapp.ramboostergfxtool.local.GameDatabase;
import com.testapp.ramboostergfxtool.local.entity.Settings;
import com.testapp.ramboostergfxtool.services.GameModeService;
import com.testapp.ramboostergfxtool.util.SettingsModeUtils;

import java.lang.reflect.Field;

public class BoosterSettingsActivity extends AppCompatActivity {
    private LinearLayout llClearBackgroundWhiteList;
    private LinearLayout llRejectCallsWhiteList;
    private LinearLayout llNotificationBlockingWhiteList;
    private ImageView ivAutoBoost;
    private ImageView ivRejectCalls;
    private ImageView ivNotificationBlocking;
    private ImageView ivUsingWifi;
    private ImageView ivDisableAutoWifi;
    private ImageView ivDisableAutoBrightness;
    private SeekBar sbBrightness;
    private SeekBar sbRingtone;
    private SeekBar sbMedia;
    private ImageView ivRingtone;
    private ImageView ivMedia;
    private ImageView ivGameModeSettings;
    private SharedPreferences preferences;
    AdControlHelp adControlHelp;
    private Settings globalSettings;
    private GameDatabase gameDatabase;
    private FrameLayout flDisableGameMode;
    private TextView tvBrightness;
    private TextView tvRingtoneVolume;
    private TextView tvMediaVolume;
    private @SuppressLint("WrongConstant") AudioManager audioManager;
    final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    final String CALL_PHONE = "android.permission.CALL_PHONE";
    final String ANSWER_PHONE_CALLS = "android.permission.ANSWER_PHONE_CALLS";
    final String[] PHONE_PERMISSIONS = new String[]{READ_PHONE_STATE, CALL_PHONE, ANSWER_PHONE_CALLS};
    private static final int CALL_SCREENING_REQUEST_CODE = 1;
    private static final int CONTACTS_REQUEST_CODE = 2;
    private static final int PHONE_REQUEST_CODE = 3;
    private static final String READ_CONTACTS_PERMISSION = "android.permission.READ_CONTACTS";
    private static final String WRITE_CONTACTS_PERMISSION = "android.permission.WRITE_CONTACTS";
    private static final String[] CONTACTS_PERMISSIONS = new String[]{READ_CONTACTS_PERMISSION, WRITE_CONTACTS_PERMISSION};

    public void requestRole() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            RoleManager roleManager = (RoleManager) getSystemService(ROLE_SERVICE);
            Intent intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_CALL_SCREENING);
            startActivityForResult(intent, CALL_SCREENING_REQUEST_CODE);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CALL_SCREENING_REQUEST_CODE:
                break;
            default:
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CONTACTS_REQUEST_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (!isHavePermissions(PHONE_PERMISSIONS)) {
                        askPermission(PHONE_PERMISSIONS, PHONE_REQUEST_CODE);
                    }
                }
                break;
            case PHONE_REQUEST_CODE:
                break;
            default:
        }
    }

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_booster_settings);
        intView();
        AdControlHelp adControlHelp = AdControlHelp.getInstance(this);
        this.adControlHelp = adControlHelp;
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        adControlHelp.loadBanner(this, findViewById(R.id.banner));
        gameDatabase = GameDatabase.getInstance(this);
        if (gameDatabase.getSettingsDao().getItemById(MyApp.getContext().getPackageName()).size() > 0) {
            globalSettings = gameDatabase.getSettingsDao().getItemById(MyApp.getContext().getPackageName()).get(0);
        } else {
            globalSettings = new Settings();
            globalSettings.setBrightnessValue(android.provider.Settings.System.getInt(getContentResolver(), "screen_brightness", -1));
            globalSettings.setRingtoneValue(audioManager.getStreamVolume(AudioManager.STREAM_RING));
            globalSettings.setMediaValue(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            globalSettings.setPkgName(MyApp.getContext().getPackageName());
            gameDatabase.upSert(globalSettings);
        }
        initGameModeView();
        initClearBackgroundAppView();
        initRejectCallsView();
        initNotificationBlockingView();
        initUsingWifiView();
        initDisableAutoBrightnessView();
        initChangeRingtoneVolumeView();
        initChangeMediaVolumeView();
    }

    private void intView() {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.header_view_height));
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.booster_settings_activity_tittle));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left_white);
        toolbar.setNavigationOnClickListener(new navBack(this));
    }

    private void initGameModeView() {
        flDisableGameMode = findViewById(R.id.fl_disable_game_mode);
        ivGameModeSettings = findViewById(R.id.game_mode_switch_button);
        flDisableGameMode.setClickable(true);
        flDisableGameMode.setFocusableInTouchMode(true);
        flDisableGameMode.setFocusable(true);
        ivGameModeSettings.setImageResource(globalSettings.isGameMode() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
        if (globalSettings.isGameMode()) {
            flDisableGameMode.setVisibility(View.INVISIBLE);
        } else {
            flDisableGameMode.setVisibility(View.VISIBLE);
        }
        ivGameModeSettings.setOnClickListener(v -> InterstitialAdShow.getInstance(BoosterSettingsActivity.this).showInterstitialAd(BoosterSettingsActivity.this, () -> {
            globalSettings.setGameMode(!globalSettings.isGameMode());
            ivGameModeSettings.setImageResource(globalSettings.isGameMode() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
            globalSettings.setPkgName(MyApp.getContext().getPackageName());
            gameDatabase.upSertGameMode(globalSettings);
            preferences.edit().putBoolean(getString(R.string.game_mode_title), globalSettings.isGameMode()).apply();
            if (globalSettings.isGameMode()) {
                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean(GameModeService.KEY_GAME_MODE_ENABLED, true).apply();
                flDisableGameMode.setVisibility(View.INVISIBLE);
                checkSystemWritePermission();
            } else {
                PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean(GameModeService.KEY_GAME_MODE_ENABLED, false).apply();
                flDisableGameMode.setVisibility(View.VISIBLE);
            }
        }));
    }

    private void initUsingWifiView() {
        ivUsingWifi = findViewById(R.id.using_wifi_switch_button);
        ivUsingWifi.setImageResource(globalSettings.getWifi() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
        ivUsingWifi.setOnClickListener(v -> InterstitialAdShow.getInstance(BoosterSettingsActivity.this).showInterstitialAd(BoosterSettingsActivity.this, () -> {
            globalSettings.setWifi(!globalSettings.getWifi());
            ivUsingWifi.setImageResource(globalSettings.getWifi() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
            globalSettings.setPkgName(MyApp.getContext().getPackageName());
            gameDatabase.upSertWifi(globalSettings);
        }));
    }

//    private void initDisableAutoWifiView() {
//        ivDisableAutoWifi = findViewById(R.id.disable_auto_wifi_switch_button);
//        ivUsingWifi.setImageResource(globalSettings.getWifi() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
//        ivUsingWifi.setOnClickListener(v -> InterstitialAdShow.getInstance(BoosterSettingsActivity.this).showInterstitialAd(BoosterSettingsActivity.this, () -> {
//            globalSettings.setWifi(!globalSettings.getWifi());
//            ivUsingWifi.setImageResource(globalSettings.getWifi() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
//            globalSettings.setPkgName(MyApp.getContext().getPackageName());
//            gameDatabase.upSertWifi(globalSettings);
//        }));
//    }

    private void initClearBackgroundAppView() {
        ivAutoBoost = (ImageView) findViewById(R.id.auto_boost_switch_button);
        llClearBackgroundWhiteList = findViewById(R.id.ll_clear_background_whitelist);
        llClearBackgroundWhiteList.setOnClickListener((view) -> startActivity(WhitelistActivity.Companion.getIntent(WhitelistActivity.KEY_CLEAR_BACKGROUND_WHITELIST, this)));
        ivAutoBoost.setImageResource(globalSettings.isClearApps() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
        ivAutoBoost.setOnClickListener(v -> InterstitialAdShow.getInstance(BoosterSettingsActivity.this).showInterstitialAd(BoosterSettingsActivity.this, () -> {
            globalSettings.setClearApps(!globalSettings.isClearApps());
            ivAutoBoost.setImageResource(globalSettings.isClearApps() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
            globalSettings.setPkgName(MyApp.getContext().getPackageName());
            gameDatabase.upSertClearApps(globalSettings);
        }));
    }

    private int calculateValueByPercentage(int maxValue, int currentPercentage) {
        return currentPercentage * maxValue / 100;
    }

    private int calculatePercentageByValue(int maxValue, int currentValue) {
        return currentValue * 100 / maxValue;
    }

    private void checkSystemWritePermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (android.provider.Settings.System.canWrite(this)) {
                return;
            }
            openAndroidPermissionsMenu();
        }
    }

    @SuppressLint("WrongConstant")
    private void openAndroidPermissionsMenu() {
        if (Build.VERSION.SDK_INT >= 23) {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            StringBuilder sb = new StringBuilder();
            sb.append("package:");
            sb.append(getPackageName());
            intent.setData(Uri.parse(sb.toString()));
            intent.setFlags(268468224);
            startActivityForResult(intent, 102);
        }
    }

    public int getMaxBrightness() {
        int defaultValue = 0;
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        if(powerManager != null) {
            Field[] fields = powerManager.getClass().getDeclaredFields();
            for (Field field: fields) {

                //https://android.googlesource.com/platform/frameworks/base/+/refs/heads/master/core/java/android/os/PowerManager.java

                if(field.getName().equals("BRIGHTNESS_ON")) {
                    field.setAccessible(true);
                    try {
                        return (int) field.get(powerManager);
                    } catch (Exception e) {
                        return defaultValue;
                    }
                }
            }
        }
        return defaultValue;
    }

    private void initDisableAutoBrightnessView() {
        int max = getMaxBrightness();
        ivDisableAutoBrightness = findViewById(R.id.disable_auto_brightness_switch_button);
        sbBrightness = findViewById(R.id.sb_brightness);
        tvBrightness = findViewById(R.id.tv_brightness);
        ivDisableAutoBrightness.setImageResource(globalSettings.isBrightness() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
        int value = globalSettings.getBrightnessValue();
        int percentage = calculatePercentageByValue(max, value);
        sbBrightness.setProgress(percentage);
        tvBrightness.setText(getString(R.string.setting_value, String.valueOf(percentage)));
        ivDisableAutoBrightness.setOnClickListener(v -> InterstitialAdShow.getInstance(BoosterSettingsActivity.this).showInterstitialAd(BoosterSettingsActivity.this, () -> {
            globalSettings.setBrightness(!globalSettings.isBrightness());
            ivDisableAutoBrightness.setImageResource(globalSettings.isBrightness() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
            globalSettings.setPkgName(MyApp.getContext().getPackageName());
            gameDatabase.upSertBrightness(globalSettings);
        }));
        sbBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                int value = calculateValueByPercentage(255, i);
                globalSettings.setBrightnessValue(value);
                gameDatabase.upSertBrightness(globalSettings);
                tvBrightness.setText(getString(R.string.setting_value, String.valueOf(calculatePercentageByValue(max, value))));
                android.provider.Settings.System.putInt(getContentResolver(), "screen_brightness", value);
            }
        });
    }

    private void initChangeRingtoneVolumeView() {
        int max = audioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
        ivRingtone = findViewById(R.id.change_ringtone_volume_switch_button);
        sbRingtone = findViewById(R.id.sb_ringtone_volume);
        tvRingtoneVolume = findViewById(R.id.tv_ringtone_volume);
        ivRingtone.setImageResource(globalSettings.isRingtone() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
        int value = globalSettings.getRingtoneValue();
        int percentage = calculatePercentageByValue(max, value);
        sbRingtone.setProgress(percentage);
        tvRingtoneVolume.setText(getString(R.string.setting_value, String.valueOf(percentage)));
        ivRingtone.setOnClickListener(v -> InterstitialAdShow.getInstance(BoosterSettingsActivity.this).showInterstitialAd(BoosterSettingsActivity.this, () -> {
            globalSettings.setRingtone(!globalSettings.isRingtone());
            ivRingtone.setImageResource(globalSettings.isRingtone() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
            globalSettings.setPkgName(MyApp.getContext().getPackageName());
            gameDatabase.upSertRingtone(globalSettings);
        }));
        sbRingtone.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                int value = calculateValueByPercentage(max, i);
                globalSettings.setRingtoneValue(value);
                gameDatabase.upSertRingtone(globalSettings);
                tvRingtoneVolume.setText(getString(R.string.setting_value, String.valueOf(calculatePercentageByValue(max, value))));
                audioManager.setStreamVolume(2, value, 0);
            }
        });
    }

    private void initChangeMediaVolumeView() {
        @SuppressLint("WrongConstant") AudioManager audioManager = (AudioManager) getSystemService("audio");
        int max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        ivMedia = findViewById(R.id.change_media_volume_switch_button);
        sbMedia = findViewById(R.id.sb_media_volume);
        tvMediaVolume = findViewById(R.id.tv_media_volume);
        ivMedia.setImageResource(globalSettings.isMedia() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
        int value = globalSettings.getMediaValue();
        int percentage = calculatePercentageByValue(max, value);
        sbMedia.setProgress(percentage);
        tvMediaVolume.setText(getString(R.string.setting_value, String.valueOf(percentage)));
        ivMedia.setOnClickListener(v -> InterstitialAdShow.getInstance(BoosterSettingsActivity.this).showInterstitialAd(BoosterSettingsActivity.this, () -> {
            globalSettings.setMedia(!globalSettings.isMedia());
            ivMedia.setImageResource(globalSettings.isMedia() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
            globalSettings.setPkgName(MyApp.getContext().getPackageName());
            gameDatabase.upSertMedia(globalSettings);
        }));
        sbMedia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                int value = calculateValueByPercentage(max, i);
                globalSettings.setMediaValue(value);
                gameDatabase.upSertMedia(globalSettings);
                tvMediaVolume.setText(getString(R.string.setting_value, String.valueOf(calculatePercentageByValue(max, value))));
                audioManager.setStreamVolume(3, value, 0);
            }
        });
    }

    private void initNotificationBlockingView() {
        llNotificationBlockingWhiteList = findViewById(R.id.ll_notify_blocking_whitelist);
        llNotificationBlockingWhiteList.setOnClickListener((view) -> startActivity(WhitelistActivity.Companion.getIntent(WhitelistActivity.KEY_NOTIFICATION_BLOCKING_WHITELIST, this)));
        ivNotificationBlocking = findViewById(R.id.notify_blocking_switch_button);
        ivNotificationBlocking.setImageResource(globalSettings.isNotify() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
        ivNotificationBlocking.setOnClickListener(v -> InterstitialAdShow.getInstance(BoosterSettingsActivity.this).showInterstitialAd(BoosterSettingsActivity.this, () -> {
            globalSettings.setNotify(!globalSettings.isNotify());
            ivNotificationBlocking.setImageResource(globalSettings.isNotify() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
            globalSettings.setPkgName(MyApp.getContext().getPackageName());
            gameDatabase.upSertNotify(globalSettings);
            if (globalSettings.isNotify()) {
                if (!android.provider.Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners").contains(
                        MyApp.getContext().getPackageName())) {
                    startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                }
            }
        }));
    }

    private boolean isHavePermissions(String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String permission: permissions) {
                if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    private void askPermission(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    private void initRejectCallsView() {
        llRejectCallsWhiteList = findViewById(R.id.ll_reject_calls_whitelist);
        llRejectCallsWhiteList.setOnClickListener((view) -> startActivity(WhitelistActivity.Companion.getIntent(WhitelistActivity.KEY_REJECT_CALL_WHITELIST, this)));
        ivRejectCalls = findViewById(R.id.reject_calls_switch_button);
        ivRejectCalls.setImageResource(globalSettings.isAutoReject() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
        ivRejectCalls.setOnClickListener(v -> InterstitialAdShow.getInstance(BoosterSettingsActivity.this).showInterstitialAd(BoosterSettingsActivity.this, () -> {
            if (!globalSettings.isAutoReject()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getString(R.string.hide_truecaller));
                builder.setMessage(getString(R.string.trueCaller_msg));
                builder.setCancelable(false).setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss());
                builder.create().show();
            }
            globalSettings.setAutoReject(!globalSettings.isAutoReject());
            if (globalSettings.isAutoReject()) {
                if (!isHavePermissions(CONTACTS_PERMISSIONS)) {
                    askPermission(CONTACTS_PERMISSIONS, CONTACTS_REQUEST_CODE);
                } else if (!isHavePermissions(PHONE_PERMISSIONS)) {
                    askPermission(PHONE_PERMISSIONS, PHONE_REQUEST_CODE);
                }
                requestRole();
            }
            ivRejectCalls.setImageResource(globalSettings.isAutoReject() ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
            globalSettings.setPkgName(MyApp.getContext().getPackageName());
            gameDatabase.upSertRejectCalls(globalSettings);
        }));
    }

    public class navBack implements View.OnClickListener {
        final BoosterSettingsActivity boosterSettingsActivity;

        navBack(BoosterSettingsActivity boosterSettingsActivity) {
            this.boosterSettingsActivity = boosterSettingsActivity;
        }

        @Override
        public void onClick(View view) {
            this.boosterSettingsActivity.finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        SettingsModeUtils.INSTANCE.applySettings(GameModeService.NORMAL_MODE);
        super.onDestroy();
    }
}
