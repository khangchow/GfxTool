package com.testapp.ramboostergfxtool.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.util.AppSelectInfo;
import java.util.List;

public class ListAppAdapter extends BaseQuickAdapter<AppSelectInfo, BaseViewHolder> {
    public ListAppAdapter(@Nullable List<AppSelectInfo> list) {
        super(R.layout.item_add_app, list);
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
        baseViewHolder.setImageResource(R.id.img_add_app, appSelectInfo.aBoolean ? R.drawable.ic_check_circle : R.drawable.ic_uncheck_circle);
        if (baseViewHolder.getAdapterPosition() == (this.mData.size() - 1) + getHeaderLayoutCount()) {
            baseViewHolder.setVisible(R.id.view_line_full, true);
            baseViewHolder.setVisible(R.id.view_line_short, false);
            baseViewHolder.setVisible(R.id.top_view_line_full, false);
        } else if (baseViewHolder.getAdapterPosition() == 0) {
            baseViewHolder.setVisible(R.id.view_line_full, false);
            baseViewHolder.setVisible(R.id.view_line_short, true);
            baseViewHolder.setVisible(R.id.top_view_line_full, true);
        } else {
            baseViewHolder.setVisible(R.id.view_line_full, false);
            baseViewHolder.setVisible(R.id.view_line_short, true);
            baseViewHolder.setVisible(R.id.top_view_line_full, false);
        }
    }
}
