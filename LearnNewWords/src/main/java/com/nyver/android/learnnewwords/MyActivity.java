package com.nyver.android.learnnewwords;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.inject.Inject;
import com.nyver.android.learnnewwords.fragment.NavigationDrawerFragment;
import com.nyver.android.learnnewwords.model.Settings;

import roboguice.activity.RoboActionBarActivity;

/**
 * My abstract activity
 *
 * @author Yuri Novitsky
 */
abstract public class MyActivity extends RoboActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks
{
    @Inject
    protected Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        settings.setPreferences(getPreferences(0));
    }

    public Settings getSettings()
    {
        return settings;
    }
}
