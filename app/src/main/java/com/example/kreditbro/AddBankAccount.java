package com.example.kreditbro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class AddBankAccount extends AppCompatActivity {

    MaterialButton btn_addBAnk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank_account);

        btn_addBAnk = findViewById(R.id.btn_addBAnk);
        btn_addBAnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),E_MandateRegistration.class));
            }
        });
    }
}