package com.sumauto.diary.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public class BaseFragment extends Fragment {
    FragmentCallback callback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() instanceof FragmentCallback){
            setCallback((FragmentCallback) getActivity());
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (callback!=null){
            callback.onFragmentViewCreated(this, view);
        }
    }



    public FragmentCallback getCallback() {
        return callback;
    }

    public void setCallback(FragmentCallback callback) {
        this.callback = callback;
    }
}
