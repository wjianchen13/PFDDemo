package com.example.ndkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.features.R;
import com.example.pfddemo.MyApplication;
import com.google.android.play.core.splitinstall.SplitInstallHelper;


public class MainActivity extends AppCompatActivity {

    private TextView tvTest;

    static {
//        System.loadLibrary("ndkdemo");
        SplitInstallHelper.loadLibrary(MyApplication.getInstance(), "ndkdemo");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tvTest = findViewById(R.id.tv_test);
    }

    public void onTest(View v) {
        tvTest.setText(stringFromJNI());
    }


    public native String stringFromJNI();
}