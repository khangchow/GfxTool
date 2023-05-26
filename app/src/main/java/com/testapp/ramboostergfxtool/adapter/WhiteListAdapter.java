package com.testapp.ramboostergfxtool.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.util.AppSelectInfo;
import java.util.List;

public class WhiteListAdapter extends BaseQuickAdapter<AppSelectInfo, BaseViewHolder> {
    public WhiteListAdapter(@Nullable List<AppSelectInfo> list) {
        super(R.layout.item_white_app, list);
    }

    
    @Override
    public View getItemView(int i, ViewGroup viewGroup) {
        return super.getItemView(i, viewGroup);
    }

    
    public void convert(BaseViewHolder baseViewHolder, AppSelectInfo appSelectInfo) {
        onBaseView(baseViewHolder, appSelectInfo);
    }

    
    public void onBaseView(BaseViewHolder baseViewHolder, AppSelectInfo appSelectInfo) {
        baseViewHolder.setVisible(R.id.add_app_layout_content, true);
        baseViewHolder.setImageDrawable(R.id.image_icon, appSelectInfo.myAppInfo.drawable);
        baseViewHolder.setText(R.id.text_app_name, appSelectInfo.myAppInfo.charSequence);
        baseViewHolder.addOnClickListener(R.id.layout_add_root);
        baseViewHolder.setImageResource(R.id.img_add_app, appSelectInfo.aBoolean ? R.drawable.ic_switch_button_on : R.drawable.ic_switch_button_off);
    }
}
