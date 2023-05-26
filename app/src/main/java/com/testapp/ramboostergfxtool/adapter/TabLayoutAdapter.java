package com.testapp.ramboostergfxtool.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.testapp.ramboostergfxtool.fragment.CrossHairFragment;
import com.testapp.ramboostergfxtool.fragment.HelpFragment;
import com.testapp.ramboostergfxtool.fragment.GfxAdvFragment;

public class TabLayoutAdapter extends FragmentPagerAdapter {
    @Override
    public int getCount() {
        return 3;
    }


    public TabLayoutAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new GfxAdvFragment();
            case 1:
                return new CrossHairFragment();
            case 2:
                return new HelpFragment();
            default:
                return null;
        }
    }
}
