package com.example.kreditbro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kreditbro.R;
import com.example.kreditbro.response.Banner;
import com.example.kreditbro.response.Package;

import java.util.List;

public class Loan_package_adapter extends RecyclerView.Adapter<Loan_package_adapter.ViewHolder>{

    private Context context;
    private final List<Package> packagesList;

    public Loan_package_adapter(Context context, List<Package> packagesList) {
        this.context = context;
        this.packagesList = packagesList;
    }

    @NonNull
    @Override
    public Loan_package_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.loan_package_cart, parent, false);
        return new Loan_package_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Loan_package_adapter.ViewHolder holder, int position) {
        Package packages = packagesList.get(position);
        holder.loan_amt.setText(packages.getAmount());
        holder.period.setText("Tenure : "+ packages.getTenure() + " months");

    }

    @Override
    public int getItemCount() {
        return packagesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView loan_amt, period;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            loan_amt = itemView.findViewById(R.id.loan_amt);
            period = itemView.findViewById(R.id.period);
        }
    }
}
