package com.testapp.ramboostergfxtool.util;

import android.os.Handler;
import android.text.TextUtils;

public class netInterface {

    public interface mInterface {
        void mLogInterface(long j);
    }

    public static void intV(final String str, final mInterface mInterface) {
        final Handler handler = new Handler();
        final long currentTimeMillis = System.currentTimeMillis();
        new Thread(new Runnable() {


            public void run() {
                String str = null;
                try {
                    str = Utils.URLConnect(str);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                String str1 = str;
                handler.post(new Runnable() {
                    public void run() {
                        if (TextUtils.isEmpty(str1)) {
                            mInterface.mLogInterface(-1);
                        } else {
                            mInterface.mLogInterface(System.currentTimeMillis() - currentTimeMillis);
                        }
                    }
                });
            }
        }).start();
    }
}
