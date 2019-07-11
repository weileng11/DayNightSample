package com.yanzhenjie.daynight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btn_auto).setOnClickListener(this);
        findViewById(R.id.btn_day).setOnClickListener(this);
        findViewById(R.id.btn_night).setOnClickListener(this);
        findViewById(R.id.fab).setOnClickListener(this);

        mImageView= (ImageView) findViewById(R.id.iv_test);
        if(BuildConfig.FLAVOR.equals("project1")){
            mImageView.setImageResource(R.drawable.ic_main_devce_gateway);
        }else if(BuildConfig.FLAVOR.equals("project2")){
            mImageView.setImageResource(R.drawable.ic_main_device_add);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_auto: {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
                recreate();
                break;
            }
            case R.id.btn_day: {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
                break;
            }
            case R.id.btn_night: {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
                break;
            }
        }
    }
}