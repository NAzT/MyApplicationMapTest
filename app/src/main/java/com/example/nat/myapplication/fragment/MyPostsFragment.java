package com.example.nat.myapplication.fragment;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import models.EnviSensorModel;

public class MyPostsFragment extends PostListFragment {

    public MyPostsFragment() {

    }

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        databaseReference = databaseReference.child("envisensor").child("chula").child("sensor");
        databaseReference.addValueEventListener(new ValueEventListener() {
            public static final String TAG = "MyPostsFragment";

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                Log.d(TAG, "onDataChange: " + children);
                while (children.iterator().hasNext()) {
                    DataSnapshot ds = children.iterator().next();
                    EnviSensorModel sensor = ds.getValue(EnviSensorModel.class);
                    sensor.id = ds.getKey();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return databaseReference;
    }
}