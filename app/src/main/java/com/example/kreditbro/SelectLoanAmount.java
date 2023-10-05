package com.example.kreditbro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class SelectLoanAmount extends AppCompatActivity {

    SeekBar seekBar;

    private int minAmount = 10000;
    private int maxAmount = 50000;
    private int step = 1000;
    int range = maxAmount-minAmount;


    MaterialButton btn_select;
    TextView tvMinInvestment,tvMaxInvestment,etAmount;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_loan_amount);

        btn_select = findViewById(R.id.btn_select);
        tvMinInvestment = findViewById(R.id.tvMinInvestment);
        tvMaxInvestment = findViewById(R.id.tvMaxInvestment);
        etAmount = findViewById(R.id.etAmount);
        seekBar = findViewById(R.id.seekBar);

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String selectValue = etAmount.getText().toString();
                Intent intent = new Intent(SelectLoanAmount.this,PackageAmountDetails.class);
                intent.putExtra("displayed_value",selectValue);
                startActivity(intent);
            }
        });




seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int value = minAmount+(i*range)/ seekBar.getMax();
        tvMinInvestment.setText(""+i+"\u20B9");

        etAmount.setText(value+"");





    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {



    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});
    }
}