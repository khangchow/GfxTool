package com.testapp.ramboostergfxtool.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.testapp.ramboostergfxtool.util.SpacesItem;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int spaces1 = 0; 
    private int spaces2 = 0;

    public SpacesItemDecoration(Context context, int i) {
        this.spaces2 = i;
        this.spaces1 = ((SpacesItem.gWidth(context) - (SpacesItem.intV(context, 20.0f) * 2)) / 4) - SpacesItem.intV(context, 60.0f);
    }

    @Override
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            int spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view) - this.spaces2;
            if (childAdapterPosition >= 0 && recyclerView.getChildAdapterPosition(view) != recyclerView.getAdapter().getItemCount() - 1) {
                int i = childAdapterPosition % spanCount;
                if (i == 0) {
                    rect.left = 0;
                } else if (i == 1) {
                    rect.left = this.spaces1 / 3;
                } else if (i == 2) {
                    rect.left = (this.spaces1 * 2) / 3;
                } else if (i == 3) {
                    rect.left = this.spaces1;
                }
                rect.right = this.spaces1 - rect.left;
            }
        }
    }
}
