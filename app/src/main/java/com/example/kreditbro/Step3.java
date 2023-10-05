package com.example.kreditbro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Step3 extends AppCompatActivity {
    ImageView img_Esign,img_Epdf;
    TextView Txt_eSign,Txt_bnkState;
    Button btn_submit;
    RadioGroup radioGroup;
    RadioButton radio_yes,radio_no;
    LinearLayout lin_epdf;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);


        img_Esign = findViewById(R.id.img_Esign);
        img_Epdf = findViewById(R.id.img_Epdf);
        btn_submit = findViewById(R.id.btn_submit);
        radio_yes = findViewById(R.id.radio_yes);
        radio_no = findViewById(R.id.radio_no);
        lin_epdf = findViewById(R.id.lin_epdf);




        img_Esign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent,10);
            }
        });
        img_Epdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent,11);
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DocumentRecieved.class));

            }
        });

radio_yes.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (radio_yes.isChecked()){
            lin_epdf.setVisibility(View.VISIBLE);
        }

    }
});

radio_no.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (radio_no.isChecked()){
            lin_epdf.setVisibility(View.GONE);
        }


    }
});
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 10:
                if (resultCode == RESULT_OK){
                    String path = data.getData().getPath();
                    Txt_eSign.setText(path);

                }
                break;

            case 11:
                if (resultCode==RESULT_OK){
                    String path = data.getData().getPath();
                    Txt_bnkState.setText(path);
                }

break;




        }
    }

}