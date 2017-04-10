package com.example.nat.myapplication.fragment;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nat.myapplication.R;
import com.example.nat.myapplication.protocol.ActivityInterface;
import com.example.nat.myapplication.protocol.OnFragmentInteractionListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyMapFragment extends BaseFragment implements ActivityInterface, OnMapReadyCallback {
    private GoogleMap mMap;
    private View mRootView;
    private Context mContext;


    public static final String TAG = MyMapFragment.class.getSimpleName();
    private OnFragmentInteractionListener mListener;
    private SupportMapFragment mapFragment;


    private ProgressDialog progressDialog;


    // TODO: Rename and change types and number of parameters
    public static MyMapFragment newInstance() {
        MyMapFragment fragment = new MyMapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public MyMapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_maps_marker, container, false);

        mRootView = v;

        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        try {
//            Field childFragmentManager = Fragment.class
//                    .getDeclaredField("mChildFragmentManager");
//            childFragmentManager.setAccessible(true);
//            childFragmentManager.set(this, null);
//        } catch (Exception e) {
////            throw new RuntimeException(e);
//        }
    }

    @Override
    public void onResume() {
        super.onResume();


//        mMap = mapFragment.getMap();
        Log.d(TAG, "onResume: ");
        // in case old play services
        if (mMap == null) return;

//        mMap.setMyLocationEnabled(true);


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                return false;
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
        FragmentManager fm = getFragmentManager();
        mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map, mapFragment).commit();
            mapFragment.getMapAsync(this);
        }

    }

    @Override
    public void onBindView() {

    }

    @Override
    public void onSetupAdapter() {

    }

    @Override
    public void onSetupEventListener() {

    }

    public void clearMap() {
        if (mMap != null)
            mMap.clear();
    }

    public void loadingMap(boolean show) {
        if (show)
            progressDialog = ProgressDialog.show(getActivity(), "", "กรุณารอสักครู่...");
        else
            progressDialog = null;
    }

    public void dismissLoadingMap() {
        if (progressDialog == null) return;
        progressDialog.dismiss();

    }

    public void onDestroyView() {
        super.onDestroyView();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = (fm.findFragmentById(R.id.map));
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady: ");
        mMap = googleMap;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//
//        try {
//            SupportMapFragment fm = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
//            if (mMap != null && fm.isResumed()) {
//                getFragmentManager().beginTransaction()
//                        .remove(fm).commit();
//                mMap = null;
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

}


