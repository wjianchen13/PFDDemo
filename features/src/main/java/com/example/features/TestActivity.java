package com.example.features;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pfddemo.BaseSplitActivity;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;

public class TestActivity extends BaseSplitActivity {

    private SplitInstallManager manager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        manager = SplitInstallManagerFactory.create(this);
    }
    
    private void onTest(View v) {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), "com.xxx.xxx.XXXActivity");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(listener);
    }

    @Override
    protected void onPause() {
        manager.unregisterListener(listener);
        super.onPause();
    }

    private final SplitInstallStateUpdatedListener listener = state -> {
        switch (state.status()) {
            case SplitInstallSessionStatus.DOWNLOADING: {
                // 正在下载
            }
            break;
            case SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION: {
                // 需要用户确认
            }
            break;
            case SplitInstallSessionStatus.INSTALLED: {
                // 安装模块成功
            }
            break;
            case SplitInstallSessionStatus.INSTALLING: {
                // 正在安装
            }
            break;
            case SplitInstallSessionStatus.FAILED: {
                // 下载模块失败
            }
            break;
            default:
                break;
        }
    };
    
}