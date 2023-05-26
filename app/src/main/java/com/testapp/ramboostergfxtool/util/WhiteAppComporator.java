package com.testapp.ramboostergfxtool.util;

import java.util.Comparator;


public final class WhiteAppComporator implements Comparator {
    static final Comparator comporator = new WhiteAppComporator();

    private WhiteAppComporator() {
    }

    @Override
    public int compare(Object obj, Object obj2) {
        return ((AppSelectInfo) obj).myAppInfo.charSequence.toString().compareTo(((AppSelectInfo) obj2).myAppInfo.charSequence.toString());
    }
}
