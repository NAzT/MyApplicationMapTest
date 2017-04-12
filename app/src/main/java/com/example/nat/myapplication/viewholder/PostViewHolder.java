package com.example.nat.myapplication.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nat.myapplication.R;

import models.EnviSensorModel;


public class PostViewHolder extends RecyclerView.ViewHolder {

    public TextView humidView;
    public TextView tempView;
    public ImageView starView;

    public PostViewHolder(View itemView) {
        super(itemView);

        humidView = (TextView) itemView.findViewById(R.id.sensor_humid);
        tempView = (TextView) itemView.findViewById(R.id.sensor_temp);
    }

    public void bindToPost(EnviSensorModel post, View.OnClickListener starClickListener) {
        humidView.setText(post.humid);
        tempView.setText(post.temp);
//        starView.setOnClickListener(starClickListener);
    }
}
