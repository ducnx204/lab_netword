package com.example.android_netword.view.BaiTap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.android_netword.R;
import com.example.android_netword.controller.base.Base_Activity;
import com.example.android_netword.databinding.ActivityLab1Bai1Binding;
import com.example.android_netword.databinding.ActivityLab1SplashscreenBinding;

public class lab1_Splashscreen extends Base_Activity {
    private ActivityLab1SplashscreenBinding binding;
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLab1SplashscreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();setContentView(view);

        new Handler().postDelayed(() -> {
            navigate(lab1_Splashscreen_phan2.class);
            finish();
        },SPLASH_TIME_OUT);
    }
}