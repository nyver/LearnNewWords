package com.nyver.android.learnnewwords.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nyver.android.learnnewwords.R;
import com.nyver.android.learnnewwords.adapter.DictionaryArrayAdapter;
import com.nyver.android.learnnewwords.model.Dictionary;

import roboguice.fragment.RoboFragment;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Dictionaries fragment
 */
public class DictionariesFragment extends RoboFragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Dictionary dictionary = new Dictionary("name", "description");

        DictionaryArrayAdapter adapter = new DictionaryArrayAdapter(
                this.getActivity(),
                R.layout.dictionaries_list_line,
                new Dictionary[] {dictionary, dictionary, dictionary, dictionary, dictionary, dictionary, dictionary, dictionary}
        );

        View view = inflater.inflate(R.layout.fragment_dirctionaries, container, false);

        ListView dictionariesListView = (ListView) view.findViewById(R.id.dictionariesListView);
        dictionariesListView.setAdapter(adapter);

        return view;
    }
}
