package com.example.nat.myapplication.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends android.support.v4.app.Fragment {
    public Context mContext;
    public Activity mActivity;
    public View mRootView;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
