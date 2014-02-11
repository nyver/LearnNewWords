package com.nyver.android.learnnewwords.model;

import android.content.SharedPreferences;

/**
 * Settings class
 *
 * @author Yuri Novitsky
 */
public class Settings
{
    public static final String SETTING_CURRENT_DICTIONARY = "currentDictionary";

    protected SharedPreferences preferences;

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public String getCurrentDictionary()
    {
        return preferences.getString(SETTING_CURRENT_DICTIONARY, "");
    }

    public boolean setCurrentDictionary(String name)
    {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(SETTING_CURRENT_DICTIONARY, name);
        return editor.commit();
    }

}
