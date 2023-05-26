package com.testapp.ramboostergfxtool.util;

import com.testapp.ramboostergfxtool.bean.GameItem;

import java.util.Comparator;


public final class GameItemComporator implements Comparator {
    public static final Comparator comporator = new GameItemComporator();

    private GameItemComporator() {
    }

    @Override
    public int compare(Object obj, Object obj2) {
        return ((GameItem) obj).getAppName().compareTo(((GameItem) obj2).getAppName());
    }
}
