package com.example.android_netword.view.BaiTap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.android_netword.R;
import com.example.android_netword.controller.base.Base_Activity;
import com.example.android_netword.databinding.ActivityLab1Bai1Binding;
import com.example.android_netword.databinding.ActivityLab1Binding;

import java.io.IOException;
import java.net.URL;

public class lab1_bai1 extends Base_Activity implements View.OnClickListener{
    private ActivityLab1Bai1Binding binding;
    private Bitmap bitmap1 = null;
    String urlbitmap = "https://hinhanhdephd.com/wp-content/uploads/2015/12/hinh-anh-dep-girl-xinh-hinh-nen-dep-gai-xinh.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLab1Bai1Binding.inflate(getLayoutInflater());View view = binding.getRoot();setContentView(view);
        binding.btnLoad.setOnClickListener(this);
    }
        private Bitmap loadImageviewFromNetWord(String link){
            URL url;
            Bitmap bitmap = null;
            try {
                url = new URL(link);
                bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            }catch (IOException e){
                e.printStackTrace();
            }
            return bitmap;
        }





    @Override
    public void onClick(View view) {

        final Thread thread = new Thread(() -> {
            final Bitmap bitmap1 = loadImageviewFromNetWord(urlbitmap);
            binding.imgAndroid.post(() -> {
                binding.tvMessage.setText("Image Dowload");
                binding.imgAndroid.setImageBitmap(bitmap1);
            });
        });
        thread.start();
    }

}