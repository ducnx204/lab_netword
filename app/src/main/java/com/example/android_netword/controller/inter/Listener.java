package com.example.android_netword.controller.inter;

import android.graphics.Bitmap;

public interface Listener {
    void onImageLoaded(Bitmap bitmap);
    void onError();
}
