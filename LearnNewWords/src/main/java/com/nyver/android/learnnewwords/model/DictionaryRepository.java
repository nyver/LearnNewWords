package com.nyver.android.learnnewwords.model;

import android.content.Context;

import com.google.inject.Inject;
import com.nyver.android.learnnewwords.util.DictionaryExternalStorage;

import java.io.File;

/**
 * Dictionaries repository
 */
public class DictionaryRepository implements Repository<Dictionary>
{
    @Override
    public Dictionary[] get(Context context) {
        File[] files = DictionaryExternalStorage.getDictionaries(context);

        Dictionary[] dictionaries = new Dictionary[files.length];

        int i = 0;
        for(File file: files) {
            dictionaries[i] = new Dictionary(file.getName(), file.getAbsolutePath());
            i++;
        }

        return dictionaries;
    }
}
