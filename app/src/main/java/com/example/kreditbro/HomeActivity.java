package com.example.kreditbro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.example.kreditbro.Adapter.ImageSliderAdapter;
import com.example.kreditbro.Adapter.Loan_package_adapter;
import com.example.kreditbro.ApiService.Api;
import com.example.kreditbro.ApiService.RetrofitService;
import com.example.kreditbro.Model.DashboardResponse;
import com.example.kreditbro.response.Banner;
import com.example.kreditbro.response.Package;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    String user_id;
    LinearLayout apply_kyc;
//    CardView card_1, card_2, card_3, card_4;
    Api retrofitInterface;
    private List<Banner> bannerList;
    private List<Package> packagesList;
    ImageSliderAdapter adapter;
    TextView user_name;
    ViewPager2 viewPager2;
    private Handler autoScrollHandler = new Handler();
    private int currentPage = 0;
    private static final long AUTO_SCROLL_DELAY = 3000;
    RecyclerView rv_home;
    Loan_package_adapter loan_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //  Toast.makeText(getApplicationContext(), MainActivity.User_id, Toast.LENGTH_SHORT).show();

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        apply_kyc = findViewById(R.id.apply_kyc);
        rv_home = findViewById(R.id.rv_home);
//        card_1 = findViewById(R.id.card_1);
//        card_2 = findViewById(R.id.card_2);
//        card_3 = findViewById(R.id.card_3);
//        card_4 = findViewById(R.id.card_4);
        viewPager2 = findViewById(R.id.viewPager);

        View headerView = navigationView.getHeaderView(0); // Get the header view
        user_name = headerView.findViewById(R.id.user_name);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_home.setLayoutManager(linearLayoutManager);

        user_id = String.valueOf(getIntent().getIntExtra("id", 0));

        dashboard(user_id);

        setSupportActionBar(toolbar);

//        card_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                alertBox();
//            }
//        });
//
//        card_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                alertBox();
//            }
//        });
//
//        card_3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                alertBox();
//            }
//        });
//
//        card_4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                alertBox();
//            }
//        });

        apply_kyc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ApplyKYC.class));
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment()).commit();
        }


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.dashboard:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Dashboard()).commit();
                        break;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Profile()).commit();
                        break;
                    case R.id.kyc:
                        startActivity(new Intent(getApplicationContext(), ApplyKYC.class));
//                     getSupportFragmentManager().beginTransaction().replace(R.id.container,new KYC()).commit();
                        break;
                    case R.id.bankaccount:
                        startActivity(new Intent(getApplicationContext(), AddBankAccount.class));
                        break;
                    case R.id.logout:
                        finish();
                        Toast.makeText(HomeActivity.this, "Successfully Logout", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private final Runnable autoScrollRunnable = new Runnable() {
        @Override
        public void run() {
            if (currentPage == adapter.getItemCount() - 1) {
                currentPage = 0;
            } else {
                currentPage++;
            }
            viewPager2.setCurrentItem(currentPage, true);
            autoScrollHandler.postDelayed(this, AUTO_SCROLL_DELAY);
        }
    };

    // Start auto-scrolling when the activity or fragment is resumed
    @Override
    protected void onResume() {
        super.onResume();
        startAutoScroll();
    }

    // Stop auto-scrolling when the activity or fragment is paused
    @Override
    protected void onPause() {
        super.onPause();
        stopAutoScroll();
    }

    // Start auto-scrolling
    private void startAutoScroll() {
        autoScrollHandler.postDelayed(autoScrollRunnable, AUTO_SCROLL_DELAY);
    }

    // Stop auto-scrolling
    private void stopAutoScroll() {
        autoScrollHandler.removeCallbacks(autoScrollRunnable);
    }
    private void dashboard(String user_id) {
        retrofitInterface = RetrofitService.getRetrofit().create(Api.class);
        Call<DashboardResponse> call = retrofitInterface.dashboard(user_id);
        call.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {
                bannerList = response.body().getBanner();
                adapter = new ImageSliderAdapter(HomeActivity.this, bannerList);
                viewPager2.setAdapter(adapter);

                packagesList = response.body().getPackages();
                loan_adapter = new Loan_package_adapter(HomeActivity.this, packagesList);
                rv_home.setAdapter(loan_adapter);
                loan_adapter.notifyDataSetChanged();

                if(response.body().getUser().getName() == null){
                    user_name.setText("User Name");
                } else {
                    user_name.setText(String.valueOf(response.body().getUser().getName()));
                }
            }

            @Override
            public void onFailure(Call<DashboardResponse> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Error try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void alertBox() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("");
        alert.setMessage("KYC Not Completed please Complete KYC");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(HomeActivity.this, ApplyKYC.class));
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.show();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}