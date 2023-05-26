package com.testapp.ramboostergfxtool.util;

import java.util.Comparator;


public final class MyComparator implements Comparator {
    static final Comparator comp = new MyComparator();

    private MyComparator() {
    }

    @Override
    public int compare(Object obj, Object obj2) {
        return ((AppSelectInfo) obj2).myAppInfo.charSequence.toString().compareTo(((AppSelectInfo) obj).myAppInfo.charSequence.toString());
    }
}
