package com.example.nat.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.nat.myapplication.OnMapAndViewReadyListener;
import com.example.nat.myapplication.fragment.AboutFragment;
import com.example.nat.myapplication.fragment.FirstFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by nat on 4/10/2017 AD.
 */

public class MyPagerAdapter extends FragmentPagerAdapter implements OnMapAndViewReadyListener.OnGlobalLayoutAndMapReadyListener, OnMapReadyCallback {
    private static final String TAG = "MyPagerAdapter";
    private static int NUM_ITEMS = 3;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
//        SupportMapFragment mapFragment =
//                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        switch (position) {
            case 0:
                SupportMapFragment mapFragment = SupportMapFragment.newInstance();
                mapFragment.getMapAsync(this);
                return mapFragment;
            case 1:
                return FirstFragment.newInstance("A", "B");
            case 2:
                return AboutFragment.newInstance("A", "B");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady: ");
        Log.d(TAG, String.valueOf(googleMap));
        GoogleMap mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
