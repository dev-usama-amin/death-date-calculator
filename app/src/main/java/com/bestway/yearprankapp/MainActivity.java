package com.bestway.yearprankapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuyenmonkey.mkloader.MKLoader;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView msg;
    private ImageView retry,imageView;
    private MKLoader mkLoader;
    private Handler handler = new Handler();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change status bar color
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        msg = findViewById(R.id.textView3);
        retry = findViewById(R.id.button2);
        mkLoader = findViewById(R.id.loader);
        imageView = findViewById(R.id.imageView);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FirstTwoQuestions.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mkLoader.setVisibility(View.GONE);
                retry.setVisibility(View.VISIBLE);
                msg.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                generateRondom();
            }
        },2500);

    }

    private void generateRondom(){

        Random random = new Random();
        int low = 20;
        int high = 40;
        int result = random.nextInt(high-low) + low;
        msg.setText("You will live \n"+result+" years more");

    }
}
