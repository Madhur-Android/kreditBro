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
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Step2 extends AppCompatActivity {
    Button btn_proceed2;
ImageView img_aadharfront,img_aadharback,img_selfie;
    TextView Txt_Front,Txt_back,Txt_selfie;
    EditText adhar;

    private static final int GALLERY_REQUEST_CODE_FRONT = 10;
    private static final int GALLERY_REQUEST_CODE_BACK = 11;
    private static final int GALLERY_REQUEST_CODE_SELFIE = 12;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        adhar = findViewById(R.id.adharnumber);
        btn_proceed2 =findViewById(R.id.btn_proceed2);
        Txt_Front =findViewById(R.id.Txt_Front);
        Txt_back =findViewById(R.id.Txt_back);
        Txt_selfie =findViewById(R.id.Txt_selfie);
        img_aadharfront =findViewById(R.id.img_aadharfront);
        img_aadharback =findViewById(R.id.img_aadharback);
        img_selfie =findViewById(R.id.img_selfie);

        btn_proceed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(),Step3.class));

            }
        });

        img_aadharfront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,GALLERY_REQUEST_CODE_FRONT);
            }
        });
        img_aadharback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,GALLERY_REQUEST_CODE_BACK);
            }
        });
        img_selfie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,GALLERY_REQUEST_CODE_SELFIE);
            }
        });


    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == GALLERY_REQUEST_CODE_FRONT ||
                    requestCode == GALLERY_REQUEST_CODE_BACK ||
                    requestCode == GALLERY_REQUEST_CODE_SELFIE) {
                Uri selectedImageUri = data.getData();
                if (requestCode == GALLERY_REQUEST_CODE_FRONT) {
                    img_aadharfront.setImageURI(selectedImageUri);
                } else if (requestCode == GALLERY_REQUEST_CODE_BACK) {
                    img_aadharback.setImageURI(selectedImageUri);
                } else if (requestCode == GALLERY_REQUEST_CODE_SELFIE) {
                    img_selfie.setImageURI(selectedImageUri);
                }
            }
        }
    }


}