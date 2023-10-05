package com.example.kreditbro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kreditbro.Fragment.Step1;
import com.example.kreditbro.Fragment.Step2;
import com.example.kreditbro.R;


public class KYC extends Fragment {

    TextView step1,step2,step3,step4;
 Button btn_next;

    public KYC() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_k_y_c, container, false);

        btn_next = view.findViewById(R.id.btn_next);


//        loadFragment(new Step1(),0);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Fragment fragment = new Step2();
               FragmentTransaction transaction = getActivity()
                       .getSupportFragmentManager()
                       .beginTransaction();
               transaction.replace(R.id.fragment_kyc,fragment).commit();


            }
        });


         return view;
    }

//    public void loadFragment(Fragment fragment,int flag){
//        FragmentManager fragmentManager = getChildFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        if (flag==0)
//            fragmentTransaction.add(R.id.fragment_kyc,fragment);
//        else
//            fragmentTransaction.add(R.id.fragment_kyc,fragment);
//        fragmentTransaction.commit();
//    }
}