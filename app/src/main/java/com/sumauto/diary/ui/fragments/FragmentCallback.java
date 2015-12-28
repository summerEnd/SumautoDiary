package com.sumauto.diary.ui.fragments;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Lincoln on 2015/12/28.
 * Fragment Callback
 */
public interface FragmentCallback {
    /**
     * Called after the fragment created its view
     * @param fragment calling fragment
     * @param view the created view
     */
    void onFragmentViewCreated(Fragment fragment, View view);
}
