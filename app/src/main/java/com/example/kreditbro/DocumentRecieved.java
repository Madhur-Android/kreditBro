package com.example.kreditbro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DocumentRecieved extends AppCompatActivity {

    ImageView img_countDown;
    TextView txt_second;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_recieved);

        img_countDown = findViewById(R.id.img_countDown);
        txt_second = findViewById(R.id.txt_second);

        Glide.with(this).asGif().load(R.drawable.tenor).into(img_countDown);


        new CountDownTimer(9000, 1000) {
            @Override
            public void onTick(long l) {

                txt_second.setText("Time remaining :"+l/1000);
            }

            @Override
            public void onFinish() {

                startActivity(new Intent(getApplicationContext(),PackageAssigned.class));
            }
        }.start();

    }
}