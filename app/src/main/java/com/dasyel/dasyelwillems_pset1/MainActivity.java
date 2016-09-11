package com.dasyel.dasyelwillems_pset1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private HashMap<Integer, Integer> hm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hm = new HashMap<>();
        hm.put(R.id.checkBox_arms, R.id.image_arms);
        hm.put(R.id.checkBox_ears, R.id.image_ears);
        hm.put(R.id.checkBox_eyebrows, R.id.image_eyebrows);
        hm.put(R.id.checkBox_eyes, R.id.image_eyes);
        hm.put(R.id.checkBox_glasses, R.id.image_glasses);
        hm.put(R.id.checkBox_hat, R.id.image_hat);
        hm.put(R.id.checkBox_mouth, R.id.image_mouth);
        hm.put(R.id.checkBox_mustache, R.id.image_mustache);
        hm.put(R.id.checkBox_nose, R.id.image_nose);
        hm.put(R.id.checkBox_shoes, R.id.image_shoes);

        for(Integer check_id: hm.keySet()){
            CheckBox cb = (CheckBox) findViewById(check_id);
            cb.setOnClickListener(this);
            if(cb.isChecked()){
                ImageView im = (ImageView) findViewById(hm.get(check_id));
                im.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        for(Integer check_id: hm.keySet()){
            CheckBox cb = (CheckBox) findViewById(check_id);
            if(cb.isChecked()){
                ImageView im = (ImageView) findViewById(hm.get(check_id));
                im.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(hm.containsKey(v.getId())) {
            CheckBox check = (CheckBox) v;
            ImageView image = (ImageView) findViewById(hm.get(v.getId()));
            if(check.isChecked()) {
                image.setVisibility(View.VISIBLE);
            } else {
                image.setVisibility(View.INVISIBLE);
            }
        }
    }
}
