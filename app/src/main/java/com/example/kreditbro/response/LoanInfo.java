package com.example.kreditbro.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoanInfo {
    @SerializedName("loan_id")
    @Expose
    private String loanId;
    @SerializedName("loan_type")
    @Expose
    private String loanType;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tenure")
    @Expose
    private String tenure;
    @SerializedName("emi_due")
    @Expose
    private String emiDue;
    @SerializedName("current_status")
    @Expose
    private String currentStatus;
    @SerializedName("enach")
    @Expose
    private String enach;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getEmiDue() {
        return emiDue;
    }

    public void setEmiDue(String emiDue) {
        this.emiDue = emiDue;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getEnach() {
        return enach;
    }

    public void setEnach(String enach) {
        this.enach = enach;
    }

}
