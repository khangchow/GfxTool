package com.testapp.ramboostergfxtool.strings;

public class Third {
    private static short mbShort(short s, int i) {
        return (short) ((s << i) | (s >>> (32 - i)));
    }

    public static long mc(long j) {
        long j2 = (j ^ (j >>> 33)) * 7109453100751455733L;
        return ((j2 ^ (j2 >>> 28)) * -3808689974395783757L) >>> 32;
    }

    public static long maS(long j) {
        short s = (short) ((int) (j & 65535));
        short s2 = (short) ((int) ((j >>> 16) & 65535));
        short s3 = (short) (s2 ^ s);
        return ((long) ((short) (((short) (mbShort(s, 13) ^ s3)) ^ (s3 << 5)))) | ((((long) mbShort(s3, 10)) | (((long) ((short) (mbShort((short) (s2 + s), 9) + s))) << 16)) << 16);
    }
}
