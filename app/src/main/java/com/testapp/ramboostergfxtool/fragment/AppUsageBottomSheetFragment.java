package com.testapp.ramboostergfxtool.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.event.GuideEvent;

import org.greenrobot.eventbus.EventBus;

public class AppUsageBottomSheetFragment extends BottomSheetDialogFragment {

    class ask implements View.OnClickListener {
        ask() {
        }

        @Override
        public void onClick(View view) {
            try {
                AppUsageBottomSheetFragment.this.startActivityForResult(new Intent("android.settings.USAGE_ACCESS_SETTINGS"), 100);
                EventBus.getDefault().post(new GuideEvent(true));
            } catch (Exception unused) {
                Toast.makeText(AppUsageBottomSheetFragment.this.getContext(), "Permission not available in your phone", Toast.LENGTH_SHORT).show();
            }
            AppUsageBottomSheetFragment.this.dismiss();
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_app_usage_bottom_sheet, (ViewGroup) null);
        ((Button) inflate.findViewById(R.id.btnAllow)).setOnClickListener(new ask());
        return inflate;
    }
}
