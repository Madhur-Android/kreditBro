package com.example.kreditbro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class PackageAmountDetails extends AppCompatActivity {

    MaterialButton btn_apply;
    TextView txt_loanAmt,txt_12Months,txt_bankTrans,txt_charges,tv_total_interest,tv_fees_charge,tv_monthly_emi;

double amountValue= 50000;
int loanTenureMonths = 12;
double annualInterest = 16.0;
double bankTransferCharge =4.0;

double monthlyInterestRate = (annualInterest / 12) / 100;
double emi =  ((amountValue * monthlyInterestRate * Math.pow(1+monthlyInterestRate,loanTenureMonths))
        /(Math.pow(1+monthlyInterestRate,loanTenureMonths)-1));

double totalInterest = (emi*loanTenureMonths)-amountValue;
double bankTransfer = (bankTransferCharge/100)*amountValue;
double totalValue = amountValue + totalInterest + bankTransfer;
double tv = amountValue-bankTransfer;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_amount_details);

        btn_apply = findViewById(R.id.btn_apply);
        txt_loanAmt = findViewById(R.id.txt_loanAmt);
        txt_12Months = findViewById(R.id.txt_12Months);
        txt_bankTrans = findViewById(R.id.txt_bankTrans);
        txt_charges = findViewById(R.id.txt_charges);
        tv_total_interest = findViewById(R.id.tv_total_interest);
        tv_fees_charge = findViewById(R.id.tv_fees_charge);
        tv_monthly_emi = findViewById(R.id.tv_monthly_emi);

        Intent intent = getIntent();
        String loanValue = intent.getStringExtra("displayed_value");
        txt_loanAmt.setText("Rs."+loanValue);


        tv_monthly_emi.setText(""+ emi);
        tv_total_interest.setText(""+ totalInterest);
       txt_bankTrans.setText("Rs."+ tv);
        txt_charges.setText(""+ bankTransfer);
        tv_fees_charge.setText(""+ bankTransfer);

        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddBankAccount.class));
            }
        });



    }
   private TextWatcher loanDetailsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void calculateLoanDetails(){
         String loanAmount = txt_loanAmt.getText().toString();
         String loanTenure = txt_12Months.getText().toString();




    }
}