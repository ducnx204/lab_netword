package com.example.android_netword;
import android.os.Bundle;
import android.view.View;

import com.example.android_netword.controller.base.Base_Activity;
import com.example.android_netword.databinding.ActivityMainBinding;
import com.example.android_netword.view.Activity.lab1;

public class MainActivity extends Base_Activity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);binding = ActivityMainBinding.inflate(getLayoutInflater());View view = binding.getRoot();setContentView(view);
        binding.btnlab1.setOnClickListener(view1 -> {
            navigate(lab1.class);
            finish();
        });

    }
}