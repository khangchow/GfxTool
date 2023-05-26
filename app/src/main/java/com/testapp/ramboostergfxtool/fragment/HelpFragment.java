package com.testapp.ramboostergfxtool.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.testapp.ramboostergfxtool.R;

public class HelpFragment extends Fragment {
    private Button privacyPolicyButton;
    private ImageView shareApp;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_help, viewGroup, false);
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);


    }
}
