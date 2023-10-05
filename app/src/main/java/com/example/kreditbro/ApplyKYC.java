package com.example.kreditbro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kreditbro.Fragment.Step2;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ApplyKYC extends AppCompatActivity {
Button btn_proceed;
EditText edt_dob;
Spinner spinner,spin_ner;
String[] gender = {"Male","Female"};
String[] occupation = {"Occupation","Employee","Self-Employee","Business"};

int year;
int month;
int day;
EditText firstname,lastname,middlename,email,address,pincode,monthlysalary,relname,relnumber,relname1,relnumber1;
public static String name,eml,add,pincde,monthlysal,relName,relNumber,relName1,relNumber1,pannumber,adharnumber,dob,occu,genderdata;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_kyc);

        idFind();

        btn_proceed = findViewById(R.id.btn_proceed);
        spinner = findViewById(R.id.spinner);
        spin_ner = findViewById(R.id.spin_ner);
        edt_dob = findViewById(R.id.edt_dob);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        edt_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog dialog = new DatePickerDialog(ApplyKYC.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        month = month+1;

                        String dates = i2+"/"+i1+"/"+i;
                        edt_dob.setText(dates);
                        dob = dates;


                    }
                },year,month,day);

                dialog.show();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,gender);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,occupation);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_ner.setAdapter(arrayAdapter);





        btn_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = firstname.getText().toString();
                add = address.getText().toString();
                eml = email.getText().toString();
                relName = relname.getText().toString();
                relNumber = relnumber.getText().toString();
                relNumber1 = relnumber1.getText().toString();
                relName1 = relname1.getText().toString();
                pincde = pincode.getText().toString();
                monthlysal = monthlysalary.getText().toString();
              startActivity(new Intent(ApplyKYC.this,Step1.class));
            }
        });
    }

    private void idFind() {
        firstname = findViewById(R.id.name);
        lastname = findViewById(R.id.lastname);
        middlename = findViewById(R.id.middle);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        relname = findViewById(R.id.relativename);
        relnumber = findViewById(R.id.relativenumber);
        relname1 = findViewById(R.id.relativename1);
        relnumber1 = findViewById(R.id.relativenumber1);
        pincode = findViewById(R.id.pincode);
        monthlysalary = findViewById(R.id.salary);
    }


    public void Verifyadd(View view) {

    }
}