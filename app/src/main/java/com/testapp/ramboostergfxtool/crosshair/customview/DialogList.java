package com.testapp.ramboostergfxtool.crosshair.customview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;

import com.testapp.ramboostergfxtool.R;
import com.testapp.ramboostergfxtool.crosshair.adapter.CrossHairAdapter;
import com.testapp.ramboostergfxtool.crosshair.interfaces.ItemListDialogClick;
import java.util.List;

public class DialogList extends Dialog {
    private List<Integer> arrList;
    private GridView grvCrossHair;
    private ItemListDialogClick itemListDialogClick;

    public DialogList(@NonNull Context context, List<Integer> list, ItemListDialogClick itemListDialogClick2) {
        super(context, R.style.DialogColor);
        this.arrList = list;
        this.itemListDialogClick = itemListDialogClick2;
    }
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.layout_dialog_list);
        this.grvCrossHair = (GridView) findViewById(R.id.grvCrossHair);
        this.grvCrossHair.setAdapter((ListAdapter) new CrossHairAdapter(getContext(), this.arrList));
        this.grvCrossHair.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                DialogList.this.dismiss();
                DialogList.this.itemListDialogClick.onItemClick(i);
            }
        });
    }
}
