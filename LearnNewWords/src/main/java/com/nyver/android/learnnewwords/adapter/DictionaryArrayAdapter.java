package com.nyver.android.learnnewwords.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nyver.android.learnnewwords.R;
import com.nyver.android.learnnewwords.model.Dictionary;

/**
 * Class for fetch dictionaries
 */
public class DictionaryArrayAdapter extends ArrayAdapter<Dictionary>
{
    private Context context;
    private int resource;
    private Dictionary[] objects;

    public DictionaryArrayAdapter(Context context, int resource, Dictionary[] objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.fragment_dictionaries_list_line, parent, false);
        TextView nameTextView = (TextView) rowView.findViewById(R.id.dictionaryName);

        Dictionary dictionary = objects[position];
        nameTextView.setText(dictionary.getName());

        return rowView;
    }
}
