package com.example.features;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ndkdemo.MainActivity;
import com.example.pfddemo.BaseSplitActivity;

public class TestActivity extends BaseSplitActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onTest(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }

}