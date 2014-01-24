package com.nyver.android.learnnewwords.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nyver.android.learnnewwords.R;
import com.nyver.android.learnnewwords.adapter.DictionaryArrayAdapter;
import com.nyver.android.learnnewwords.model.Dictionary;

/**
 * Dictionaries fragment
 */
public class DictionariesFragment extends ProgressRoboFragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Dictionary dictionary = new Dictionary("name", "description");

        setContentLoading(true);

        DictionaryArrayAdapter adapter = new DictionaryArrayAdapter(
                this.getActivity(),
                R.layout.fragment_dictionaries_list_line,
                new Dictionary[] {dictionary, dictionary, dictionary, dictionary, dictionary, dictionary, dictionary, dictionary}
        );

        View view = inflater.inflate(R.layout.fragment_dictionaries, container, false);

        ListView dictionariesListView = (ListView) view.findViewById(R.id.listView);
        dictionariesListView.setAdapter(adapter);

        return view;
    }
}
