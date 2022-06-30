package com.example.android_netword.view.BaiTap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_netword.R;
import com.example.android_netword.controller.Asy.AsyncTaskRunner;

public class Lab1Bai4Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult;
    Button btn_RunASYTASK;
    EditText edt_ASYTASK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_bai4);
        tvResult = findViewById(R.id.tvResult);
        btn_RunASYTASK = findViewById(R.id.btn_RunASYTASK);
        edt_ASYTASK = findViewById(R.id.edt_ASYTASK);
        btn_RunASYTASK.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_RunASYTASK:
                AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this,tvResult,edt_ASYTASK);
                String sleepTime = edt_ASYTASK.getText().toString();
                asyncTaskRunner.execute(sleepTime);
                break;

        }
    }
}