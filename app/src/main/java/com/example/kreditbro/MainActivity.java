package com.example.kreditbro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kreditbro.MobileLoan.AadharLoan;
import com.example.kreditbro.MobileLoan.BusinessLoan;
import com.example.kreditbro.MobileLoan.HomeLoan;
import com.example.kreditbro.MobileLoan.LoanBank;
import com.example.kreditbro.MobileLoan.PersonalLoan;
import com.example.kreditbro.MobileLoan.StudentLoan;

public class MainActivity extends AppCompatActivity {

    LinearLayout personalLoan,studentLoan,homeLoan,businessLoan,bankLoan,aadharLoan;
    ImageView img_logOut;
    public static String User_id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personalLoan = findViewById(R.id.personalLoan);
        studentLoan = findViewById(R.id.studentLoan);
        homeLoan = findViewById(R.id.homeLoan);
        businessLoan = findViewById(R.id.businessLoan);
        bankLoan = findViewById(R.id.bankLoan);
        aadharLoan = findViewById(R.id.aadharLoan);
        img_logOut = findViewById(R.id.img_logOut);

        personalLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PersonalLoan.class));
            }
        });
        studentLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), StudentLoan.class));
            }
        });
        homeLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomeLoan.class));
            }
        });
        businessLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BusinessLoan.class));
            }
        });
        bankLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoanBank.class));
            }
        });
        aadharLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AadharLoan.class));
            }
        });

        img_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}