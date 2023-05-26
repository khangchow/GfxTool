package com.testapp.ramboostergfxtool.vipgfx.stringfog.xor;

import android.util.Base64;
import com.testapp.ramboostergfxtool.vipgfx.stringfog.IStringFog;
import java.io.UnsupportedEncodingException;

public final class StringFogImpl implements IStringFog {
    public static final String CHARSET_NAME_UTF_8 = "UTF-8";

    public static String decrypt(String str) {
        return new StringFogImpl().decrypt(str, "UTF-8");
    }

    public String encrypt(String str, String str2) {
        try {
            return new String(Base64.encode(xor(str.getBytes("UTF-8"), str2), 2));
        } catch (UnsupportedEncodingException unused) {
            return new String(Base64.encode(xor(str.getBytes(), str2), 2));
        }
    }

    public String decrypt(String str, String str2) {
        try {
            return new String(xor(Base64.decode(str, 2), str2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(xor(Base64.decode(str, 2), str2));
        }
    }

    public boolean overflow(String str, String str2) {
        return str != null && (str.length() * 4) / 3 >= 65535;
    }

    private static byte[] xor(byte[] bArr, String str) {
        int length = bArr.length;
        int length2 = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (i2 >= length2) {
                i2 = 0;
            }
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i2));
            i++;
            i2++;
        }
        return bArr;
    }
}
