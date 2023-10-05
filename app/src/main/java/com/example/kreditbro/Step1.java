package com.example.kreditbro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class Step1 extends AppCompatActivity {

    private int Gallery_Request_Code = 123;
    Button btn_proceed1;
    ImageView img_pan;
    EditText pannbr;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);

        pannbr = findViewById(R.id.pannumber);

        btn_proceed1 = findViewById(R.id.btn_proceed1);
        img_pan = findViewById(R.id.img_pan);

//        btn_pre = findViewById(R.id.btn_pre);
        btn_proceed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplyKYC.pannumber = pannbr.getText().toString();
                startActivity(new Intent(getApplicationContext(),Step2.class));
            }
        });
//
        img_pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent,Gallery_Request_Code);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(intent,Gallery_Request_Code);


        }
    }
