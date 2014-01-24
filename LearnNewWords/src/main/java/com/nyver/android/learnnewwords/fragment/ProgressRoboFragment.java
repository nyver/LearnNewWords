package com.nyver.android.learnnewwords.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.nyver.android.learnnewwords.R;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

/**
 * Progress Robo Fragment class
 */
public class ProgressRoboFragment extends RoboFragment
{
    private boolean isContentLoading = false;

    private @InjectView(R.id.progress) ProgressBar progressBar;
    private @InjectView(R.id.listView) ListView listView;

    public void setContentLoading(boolean isContentLoading)
    {
        this.isContentLoading = isContentLoading;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showContent(this.isContentLoading);
    }

    public void showContent(boolean isContentLoading)
    {
        if (isContentLoading) {
            listView.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out));
            progressBar.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in));

            listView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in));
            listView.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out));

            listView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        this.isContentLoading = false;
        super.onDestroyView();
    }
}
