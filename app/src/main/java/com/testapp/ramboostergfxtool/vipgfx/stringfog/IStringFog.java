package com.testapp.ramboostergfxtool.vipgfx.stringfog;

public interface IStringFog {
    String decrypt(String str, String str2);

    String encrypt(String str, String str2);

    boolean overflow(String str, String str2);
}
