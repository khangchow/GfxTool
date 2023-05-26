package com.testapp.ramboostergfxtool.strings;

public class Second {
    private static long loSecond(int i, String[] strArr, long j) {
        return (((long) strArr[i / 8191].charAt(i % 8191)) << 32) ^ Third.maS(j);
    }

    public static String strMb(long j, String[] strArr) {
        long val = Third.maS(Third.mc(4294967295L & j));
        long val3 = Third.maS(val);
        int i = (int) (((j >>> 32) ^ ((val >>> 32) & 65535)) ^ ((val3 >>> 16) & -65536));
        long val2 = loSecond(i, strArr, val3);
        int i2 = (int) ((val2 >>> 32) & 65535);
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            val2 = loSecond(i + i3 + 1, strArr, val2);
            cArr[i3] = (char) ((int) ((val2 >>> 32) & 65535));
        }
        return new String(cArr);
    }
}
