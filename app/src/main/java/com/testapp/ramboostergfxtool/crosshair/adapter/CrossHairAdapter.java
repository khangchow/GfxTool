package com.testapp.ramboostergfxtool.crosshair.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.testapp.ramboostergfxtool.R;
import java.util.List;

public class CrossHairAdapter extends BaseAdapter {
    private List<Integer> arrList;
    private Context context;

    public long getItemId(int i) {
        return (long) i;
    }

    public CrossHairAdapter(Context context2, List<Integer> list) {
        this.context = context2;
        this.arrList = list;
    }

    public int getCount() {
        return this.arrList.size();
    }

    public Object getItem(int i) {
        return this.arrList.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.item_cross_hair, viewGroup, false);
        }
        ((ImageView) view.findViewById(R.id.imgCrossHair)).setImageResource(this.arrList.get(i).intValue());
        return view;
    }
}
