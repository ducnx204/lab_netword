package com.example.android_netword.view.BaiTap;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_netword.R;
import com.example.android_netword.controller.Asy.LoadImageTask;
import com.example.android_netword.controller.inter.Listener;

public class lab1_AsyncTask extends AppCompatActivity implements View.OnClickListener, Listener {
    TextView tvMessage_ASY;
    Button  btnLoad_ASY;
    ImageView imgAndroid_ASY;
    String  url = "https://scontent.fdad3-4.fna.fbcdn.net/v/t39.30808-6/290857119_1448467285670439_1836955826640836429_n.jpg?stp=cp1_dst-jpg&_nc_cat=101&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=hAqkOu3Rh9EAX-ExEb1&tn=i-d0w8DGO0Rodu7M&_nc_ht=scontent.fdad3-4.fna&oh=00_AT_9d9fGlJLWLqOYjgsWSuzqpQenbjnNpeuQGI28qlEk9Q&oe=62C050FB";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_async_task);
        tvMessage_ASY=  findViewById(R.id.tvMessage_ASY);
        btnLoad_ASY = findViewById(R.id.btnLoad_ASY);
        imgAndroid_ASY = findViewById(R.id.imgAndroid_ASY);
        btnLoad_ASY.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg) {
        switch (arg.getId()){

            case R.id.btnLoad_ASY:
            new LoadImageTask(this,this).execute(url);
            break;
        }
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imgAndroid_ASY.setImageBitmap(bitmap);
        tvMessage_ASY.setText("Tai thanh cong");
    }

    @Override
    public void onError() {
        tvMessage_ASY.setText("Tai That Bai");

    }
}