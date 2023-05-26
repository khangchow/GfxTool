package com.testapp.ramboostergfxtool.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.util.MyAppInfo;
import java.util.List;

public class GridAppAdapter extends BaseQuickAdapter<MyAppInfo, BaseViewHolder> {
    public GridAppAdapter(@Nullable List<MyAppInfo> list) {
        super(R.layout.item_game_boost, list);
    }

    
    @Override
    public View getItemView(int i, ViewGroup viewGroup) {
        return super.getItemView(i, viewGroup);
    }

    
    public void convert(BaseViewHolder baseViewHolder, MyAppInfo myAppInfo) {
        onBaseView(baseViewHolder, myAppInfo);
    }

    
    public void onBaseView(BaseViewHolder baseViewHolder, MyAppInfo myAppInfo) {
        baseViewHolder.setImageDrawable(R.id.image_icon, myAppInfo.drawable);
        baseViewHolder.setText(R.id.text_app_name, myAppInfo.charSequence);
        baseViewHolder.addOnClickListener(R.id.layout_root_app);
    }
}
