package com.testapp.ramboostergfxtool.crosshair.common;

import com.testapp.ramboostergfxtool.R;
import java.util.ArrayList;
import java.util.List;

public class Const {
    public static final String KEY_ACTION_IS_SHOW = "IS_SHOW";
    public static final String KEY_ACTION_IS_UPDATE = "IS_UPDATE";
    public static final String KEY_INTENT_COLOR = "COLOR";
    public static final String KEY_INTENT_CROSS_HAIR = "CROSS_HAIR";
    public static final String KEY_INTENT_SIZE = "SIZE";
    public static final String KEY_SHARE_COLOR = "color";
    public static final String KEY_SHARE_CROSS_HAIR = "cross_hair";
    public static final String KEY_SHARE_OPCACITY = "opacity";
    public static final String KEY_SHARE_POSITION_X = "position_x";
    public static final String KEY_SHARE_POSITION_Y = "position_y";
    public static final String KEY_SHARE_SIZE = "size";

    public static List<Integer> createListCrossHair() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_01));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_02));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_03));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_04));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_05));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_06));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_07));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_08));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_09));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_10));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_11));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_12));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_13));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_14));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_15));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_16));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_17));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_18));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_19));
        arrayList.add(Integer.valueOf((int) R.drawable.ic_chr_20));
        return arrayList;
    }
}
