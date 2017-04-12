package com.example.nat.myapplication.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.nat.myapplication.R;

import models.EnviSensorModel;


public class PostViewHolder extends RecyclerView.ViewHolder {

    public TextView humidView;
    public TextView tempView;
    public TextView pm1View;
    public TextView pm10View;
    public TextView pm25View;

    public PostViewHolder(View itemView) {
        super(itemView);

        humidView = (TextView) itemView.findViewById(R.id.sensor_humid);
        tempView = (TextView) itemView.findViewById(R.id.sensor_temp);
        pm1View = (TextView) itemView.findViewById(R.id.sensor_pm1);
        pm10View = (TextView) itemView.findViewById(R.id.sensor_pm10);
        pm25View = (TextView) itemView.findViewById(R.id.sensor_pm25);
    }

    public void bindToPost(EnviSensorModel post, View.OnClickListener starClickListener) {
        humidView.setText(post.humid);
        tempView.setText(post.temp);
        pm1View.setText(post.pm1);
        pm10View.setText(post.pm10);
        pm25View.setText(post.pm25);
//        starView.setOnClickListener(starClickListener);
    }
}
