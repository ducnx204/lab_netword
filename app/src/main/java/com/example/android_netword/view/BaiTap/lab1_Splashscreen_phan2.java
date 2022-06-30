package com.example.android_netword.view.BaiTap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_netword.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class lab1_Splashscreen_phan2 extends AppCompatActivity implements View.OnClickListener {
    private  ImageView imgAndroid_ex2;
    private Button btnLoad_ex2;
    private TextView tvMessage_ex2;
    private String  url = "https://scontent.fdad3-4.fna.fbcdn.net/v/t39.30808-6/290857119_1448467285670439_1836955826640836429_n.jpg?stp=cp1_dst-jpg&_nc_cat=101&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=hAqkOu3Rh9EAX-ExEb1&tn=i-d0w8DGO0Rodu7M&_nc_ht=scontent.fdad3-4.fna&oh=00_AT_9d9fGlJLWLqOYjgsWSuzqpQenbjnNpeuQGI28qlEk9Q&oe=62C050FB";
    private Bitmap  bitmap = null;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_splashscreen_phan2);
        imgAndroid_ex2 = findViewById(R.id.imgAndroid_ex2);
        btnLoad_ex2 = findViewById(R.id.btnLoad_ex2);
        tvMessage_ex2 = findViewById(R.id.tvMessage_ex2);
        btnLoad_ex2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        progressDialog = ProgressDialog.show(lab1_Splashscreen_phan2.this,"","dowload...");

        Runnable post = () -> {
            bitmap = dowloadBitmap(url);
            Message msg = messageHandler.obtainMessage();
            Bundle bundle = new Bundle();
            String thMessage = "Da dowload thanh cong";
            bundle.putString("message",thMessage);
            msg.setData(bundle);
            messageHandler.sendMessage(msg);
        };
        Thread th = new Thread(post);
        th.start();

    }
    private Handler messageHandler = new Handler(){
        public void handlerMessage(Message msg){
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message  = bundle.getString("message");
            tvMessage_ex2.setText(message);
            imgAndroid_ex2.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };


    private Bitmap dowloadBitmap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
             Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;

        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}