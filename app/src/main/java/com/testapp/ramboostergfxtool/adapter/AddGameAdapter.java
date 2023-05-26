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
import com.testapp.ramboostergfxtool.activity.AddGameActivity;
import com.testapp.ramboostergfxtool.bean.GameItem;
import com.testapp.ramboostergfxtool.data.GameDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddGameAdapter extends ArrayAdapter<GameItem> {
    public static ArrayList<GameItem> addedData;
    private List<GameItem> list;
    private AddGameActivity addGameActivity;
    private int anInt;
    private GameDatabase gameDatabase;

    private class ViewHolder {
        ImageView ivAppIcon;
        TextView tvAppName;
        String mName;
        ImageView ivSelect;

        private ViewHolder(AddGameAdapter addGameAdapter) {
        }
    }

    public AddGameAdapter(Context context, int i, List<GameItem> list, GameDatabase gameDatabase) {
        super(context, i, list);
        this.addGameActivity = (AddGameActivity) context;
        this.anInt = i;
        this.list = list;
        this.gameDatabase = gameDatabase;
        addedData = getAddedApps();
    }

    private ArrayList<GameItem> getAddedApps() {
        ArrayList<GameItem> results = new ArrayList<>();
        for (GameItem app: list) {
            if (app.isAdded()) {
                results.add(app);
            }
        }
        return results;
    }

    public  void getItemG(GameItem gameItem, int i, View view) {
        String packageName;
        try {
            if (gameItem.isAdded()) {
                if (addedData != null && (packageName = gameItem.getPackageName()) != null) {
                    if (!packageName.equals("")) {
                        if (!gameDatabase.isRecordExits(gameItem.getPackageName())) {
                            addedData.add(gameItem);
                            gameDatabase.insertRecord(gameItem.getPackageName());
                            notifyDataSetChanged();
                        }
                    }
                }
            } else {
                addedData.remove(gameItem);
                this.gameDatabase.deleteRecord(gameItem.getPackageName());
                notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    public View getView(int i, View view, @NonNull ViewGroup viewGroup) {
        ViewHolder bVar;
        GameItem gameItem = (GameItem) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.addGameActivity).inflate(this.anInt, (ViewGroup) null);
            bVar = new ViewHolder(this);
            bVar.ivAppIcon = (ImageView) view.findViewById(R.id.ivAppIcon);
            bVar.tvAppName = (TextView) view.findViewById(R.id.tvAppName);
            bVar.ivSelect = view.findViewById(R.id.iv_select);
            view.setTag(bVar);
        } else {
            bVar = (ViewHolder) view.getTag();
        }
        ImageView imageView = bVar.ivAppIcon;
        Objects.requireNonNull(gameItem);
        imageView.setImageDrawable(gameItem.getAppIcon());
        bVar.tvAppName.setText(gameItem.getAppName());
        bVar.mName = gameItem.getPackageName();
        bVar.ivSelect.setImageResource((gameItem.isAdded()) ? R.drawable.ic_check_circle : R.drawable.ic_uncheck_circle);
        bVar.ivSelect.setOnClickListener(view1 -> {
            gameItem.setAdded(!gameItem.isAdded());
            bVar.ivSelect.setImageResource((gameItem.isAdded()) ? R.drawable.ic_check_circle : R.drawable.ic_uncheck_circle);
            getItemG(gameItem, i, view1);
        });
        return view;
    }
}
