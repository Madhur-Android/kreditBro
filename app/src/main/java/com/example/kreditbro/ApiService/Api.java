package com.example.kreditbro.ApiService;

import com.example.kreditbro.Model.DashboardResponse;
import com.example.kreditbro.Model.LoginResponse;
import com.example.kreditbro.Model.OtpResponse;
import com.example.kreditbro.Model.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("registernew")
    Call<SignupResponse> SignUp(
            @Field("mobile") String mobile,
            @Field("email") String email);
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("otp_verification")
    Call<OtpResponse> otp(
            @Field("mobile") String mobile,
            @Field("otp") String otp);

    @FormUrlEncoded
    @POST("dashboard")
    Call<DashboardResponse> dashboard(
            @Field("id") String id);
}
