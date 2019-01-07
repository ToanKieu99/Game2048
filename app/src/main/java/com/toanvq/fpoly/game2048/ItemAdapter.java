package com.toanvq.fpoly.game2048;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Integer> {
    private Context context;
    private ArrayList<Integer> arr;


    public ItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Integer> objects) {
        super(context, resource,objects);
        this.context = context;
        this.arr = new ArrayList<>(objects);

    }

    @Override
    public void notifyDataSetChanged() {
        arr = DataGame.getDataGame().getArrSo();
        super.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item,null);

        }
        if (arr.size() > 0 ){
            Item i = convertView.findViewById(R.id.txtItem);
            i.setTett(arr.get(position));
        }
        return convertView;
    }
}
