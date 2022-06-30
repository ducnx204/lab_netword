package com.example.android_netword.view.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.android_netword.R;
import com.example.android_netword.controller.base.Base_Activity;
import com.example.android_netword.databinding.ActivityLab1Binding;
import com.example.android_netword.view.BaiTap.Lab1Bai4Activity;
import com.example.android_netword.view.BaiTap.lab1_AsyncTask;
import com.example.android_netword.view.BaiTap.lab1_Splashscreen;
import com.example.android_netword.view.BaiTap.lab1_Splashscreen_phan2;
import com.example.android_netword.view.BaiTap.lab1_bai1;

public class lab1 extends Base_Activity {
    private ActivityLab1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);binding = ActivityLab1Binding.inflate(getLayoutInflater());View view = binding.getRoot();setContentView(view);
        binding.btnbai1.setOnClickListener(view1 -> { navigate(lab1_bai1.class); });
        binding.btnbai2.setOnClickListener(view1 -> { navigate(lab1_Splashscreen.class); });
        binding.btnbai3.setOnClickListener(view1 -> { navigate(lab1_AsyncTask.class); });
        binding.btnbai4.setOnClickListener(view1 -> { navigate(Lab1Bai4Activity.class); });
    }
}