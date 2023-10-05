package com.example.kreditbro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

public class PackageAssigned extends AppCompatActivity {

    ImageView img_celebrate,img_complete;
    MaterialButton btn_process;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_assigned);

        img_celebrate = findViewById(R.id.img_celebrate);
        img_complete = findViewById(R.id.img_complete);
        btn_process = findViewById(R.id.btn_process);


        Glide.with(this).asGif().load(R.drawable.giphy2).into(img_celebrate);
        Glide.with(this).asGif().load(R.drawable.giphy3).into(img_complete);

btn_process.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(),SelectLoanAmount.class));
    }
});

    }
}