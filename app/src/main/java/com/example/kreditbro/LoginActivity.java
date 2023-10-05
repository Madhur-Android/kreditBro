package com.example.kreditbro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kreditbro.ApiService.Api;
import com.example.kreditbro.ApiService.RetrofitService;
import com.example.kreditbro.Model.LoginResponse;
import com.google.android.material.button.MaterialButton;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edt_mobileNo;
    MaterialButton btn_login;
    TextView txt_signUp;
    String mobile_no;
    Api retrofitInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_mobileNo = findViewById(R.id.edt_mobileNo);
        btn_login = findViewById(R.id.btn_login);
        txt_signUp = findViewById(R.id.txt_signUp);

        txt_signUp.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(i);
        });

        btn_login.setOnClickListener(v -> {
            if(edt_mobileNo.getText().toString().isEmpty()){
                edt_mobileNo.setError("Enter Mobile Number");
            } else {
                if(edt_mobileNo.length() == 10){
                    mobile_no = edt_mobileNo.getText().toString();
                    login(mobile_no);
                } else {
                    edt_mobileNo.setError("Enter Correct Number");
                }
            }
        });
    }

    private void login(String mobile_no) {
        retrofitInterface = RetrofitService.getRetrofit().create(Api.class);
        Call<LoginResponse> call = retrofitInterface.login(mobile_no);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Toast.makeText(LoginActivity.this, "Otp Sent", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginActivity.this, OtpActivity.class);
                i.putExtra("number", response.body().getUser().getMobile());
                int otp = response.body().getOtp();
                i.putExtra("otp", otp);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error try again", Toast.LENGTH_SHORT).show();
            }
        });

//        Toast.makeText(this, "hiiiiiiiiiii", Toast.LENGTH_SHORT).show();
    }

}