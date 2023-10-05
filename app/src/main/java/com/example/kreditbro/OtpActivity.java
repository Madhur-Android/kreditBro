package com.example.kreditbro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.example.kreditbro.Model.OtpResponse;
import com.google.android.material.button.MaterialButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OtpActivity extends AppCompatActivity {

    EditText edt_OTP;
    TextView verify;
    String otp, number, getOTP;
    Api retrofitInterface;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        edt_OTP = findViewById(R.id.edt_OTP);
        verify = findViewById(R.id.verify);

        number = getIntent().getStringExtra("number");
        getOTP = String.valueOf(getIntent().getIntExtra("otp", 0));

        edt_OTP.setText(getOTP);

        verify.setOnClickListener(v -> {
            if (edt_OTP.getText().toString().isEmpty()) {
                edt_OTP.setError("Enter Mobile Number");
            } else {
                otp = edt_OTP.getText().toString();
                verifyOTP(otp, number);
            }
        });

    }

    private void verifyOTP(String otp, String number) {
        retrofitInterface = RetrofitService.getRetrofit().create(Api.class);
        Call<OtpResponse> call = retrofitInterface.otp(number, otp);
        call.enqueue(new Callback<OtpResponse>() {
            @Override
            public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {
                Toast.makeText(OtpActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(OtpActivity.this, HomeActivity.class);
                int id = response.body().getUser().getId();
                i.putExtra("id", id);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<OtpResponse> call, Throwable t) {
                Toast.makeText(OtpActivity.this, "Error try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

}