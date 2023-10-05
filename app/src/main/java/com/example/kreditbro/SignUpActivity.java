package com.example.kreditbro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kreditbro.ApiService.Api;
import com.example.kreditbro.ApiService.RetrofitService;
import com.example.kreditbro.Model.OtpResponse;
import com.example.kreditbro.Model.SignupResponse;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    EditText mobile, email;
    String mobile_no, email_id;
    MaterialButton btn_register;
    Api retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mobile = findViewById(R.id.edt_number);
        email = findViewById(R.id.edt_email);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(v -> {
            if (mobile.getText().toString().isEmpty()) {
                mobile.setError("Enter Mobile Number");
            } else {
                if (mobile.length() == 10) {
                    mobile_no = mobile.getText().toString();
                    if (email.getText().toString().isEmpty()) {
                        email.setError("Enter Email id");
                    } else {
                        email_id = email.getText().toString();
                        Signup(mobile_no, email_id);
                    }
                } else {
                    mobile.setError("Enter Correct Number");
                }
            }
        });

    }

    private void Signup(String mobile_no, String email_id) {
        retrofitInterface = RetrofitService.getRetrofit().create(Api.class);
        Call<SignupResponse> call = retrofitInterface.SignUp(mobile_no, email_id);
        call.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                Toast.makeText(SignUpActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Error Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
