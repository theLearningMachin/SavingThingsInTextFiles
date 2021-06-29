package com.egovictoria.savingthingsintextfiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.ArrayList;

public class DictionaryAdapter extends ArrayAdapter {

    private ArrayList<String> theList;
    private Context context;
    private int resource;

    public DictionaryAdapter(@NonNull Context acontext, int aresource, @NonNull ArrayList<String> objects) {
        super(acontext, aresource, objects);

        theList = objects;
        context = acontext;
        resource = aresource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.dictionary_list_adapter, null);

            holder = new ViewHolder();

            holder.tag = convertView.findViewById(R.id.dictListAdapterKeyTextView);
            holder.details = convertView.findViewById(R.id.dictListAdapterDetailsTextView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String nameTag = theList.get(position);
        holder.tag.setText(nameTag);
        holder.details.setText(AppConstants.dict.getItem(nameTag));

        return convertView;
    }

    private static class ViewHolder {
        TextView tag, details;
    }
}
