package com.nyver.android.learnnewwords.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.inject.Inject;
import com.nyver.android.learnnewwords.R;
import com.nyver.android.learnnewwords.adapter.DictionaryArrayAdapter;
import com.nyver.android.learnnewwords.model.DictionaryRepository;

/**
 * Dictionaries fragment
 */
public class DictionariesFragment extends ProgressRoboFragment
{
    @Inject
    DictionaryRepository repository;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        final View view = inflater.inflate(R.layout.fragment_dictionaries, container, false);

        setContentLoading(true);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                DictionaryArrayAdapter adapter = new DictionaryArrayAdapter(
                        getActivity(),
                        R.layout.fragment_dictionaries_list_line,
                        repository.get(getActivity().getApplicationContext())
                );

                ListView dictionariesListView = (ListView) view.findViewById(R.id.listView);
                dictionariesListView.setAdapter(adapter);

                setContentLoading(false);
            }
        });

        return view;
    }
}
