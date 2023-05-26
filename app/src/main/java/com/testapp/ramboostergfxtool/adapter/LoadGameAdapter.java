package com.testapp.ramboostergfxtool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.activity.MainActivity;
import com.testapp.ramboostergfxtool.bean.GameItem;
import java.util.List;
import java.util.Objects;

public class LoadGameAdapter extends ArrayAdapter<GameItem> {
    private MainActivity mainActivity;
    private int anInt;

    private class ViewHolder {
        ImageView ivAppIcon;
        TextView tvAppName;
        String mName;

        private ViewHolder(LoadGameAdapter loadGameAdapter) {
        }
    }

    public LoadGameAdapter(Context context, int i, List<GameItem> list) {
        super(context, i, list);
        this.mainActivity = (MainActivity) context;
        this.anInt = i;
    }

    @NonNull
    public View getView(int i, View view, @NonNull ViewGroup viewGroup) {
        ViewHolder bVar;
        GameItem gameItem = (GameItem) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.mainActivity).inflate(this.anInt, (ViewGroup) null);
            bVar = new ViewHolder(this);
            bVar.ivAppIcon = (ImageView) view.findViewById(R.id.ivAppIcon);
            bVar.tvAppName = (TextView) view.findViewById(R.id.tvAppName);
            view.setTag(bVar);
        } else {
            bVar = (ViewHolder) view.getTag();
        }
        ImageView imageView = bVar.ivAppIcon;
        Objects.requireNonNull(gameItem);
        imageView.setImageDrawable(gameItem.getAppIcon());
        bVar.tvAppName.setText(gameItem.getAppName());
        bVar.mName = gameItem.getPackageName();
        return view;
    }
}
