package com.example.assets;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private ImageView mIvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIvImage = (ImageView)findViewById(R.id.iv_image);

        Button btnShowImage1 = (Button)findViewById(R.id.btn_show_image1);
        btnShowImage1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                AssetManager assetManager = getAssets();
                try {
                    InputStream is = assetManager.open("android-logo.png");
                    Drawable dr = Drawable.createFromStream(is, "my image");
                    mIvImage.setImageDrawable(dr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });

        Button btnShowImage2 = (Button)findViewById(R.id.btn_show_image2);
        btnShowImage2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                AssetManager assetManager = getAssets();
                String[] list = null;
                try {
                    list = assetManager.list("/assets");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (list != null) {
                    for (String path : list) {
                        Log.d(TAG, "list : " + path);
                    }
                }
                return false;
            }
        });

    }
}
