package com.example.kreditbro.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Package {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("package_name")
    @Expose
    private Object packageName;
    @SerializedName("package_description")
    @Expose
    private Object packageDescription;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("loan_document")
    @Expose
    private Integer loanDocument;
    @SerializedName("tenure")
    @Expose
    private String tenure;
    @SerializedName("insurance")
    @Expose
    private Integer insurance;
    @SerializedName("processing_fees")
    @Expose
    private String processingFees;
    @SerializedName("gst")
    @Expose
    private String gst;
    @SerializedName("interest")
    @Expose
    private String interest;
    @SerializedName("emi")
    @Expose
    private String emi;
    @SerializedName("emd_month")
    @Expose
    private String emdMonth;
    @SerializedName("emd_amt")
    @Expose
    private String emdAmt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("package_duration")
    @Expose
    private String packageDuration;
    @SerializedName("processing_fees_per")
    @Expose
    private String processingFeesPer;
    @SerializedName("loan_documents_per")
    @Expose
    private String loanDocumentsPer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getPackageName() {
        return packageName;
    }

    public void setPackageName(Object packageName) {
        this.packageName = packageName;
    }

    public Object getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(Object packageDescription) {
        this.packageDescription = packageDescription;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getLoanDocument() {
        return loanDocument;
    }

    public void setLoanDocument(Integer loanDocument) {
        this.loanDocument = loanDocument;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    public String getProcessingFees() {
        return processingFees;
    }

    public void setProcessingFees(String processingFees) {
        this.processingFees = processingFees;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getEmi() {
        return emi;
    }

    public void setEmi(String emi) {
        this.emi = emi;
    }

    public String getEmdMonth() {
        return emdMonth;
    }

    public void setEmdMonth(String emdMonth) {
        this.emdMonth = emdMonth;
    }

    public String getEmdAmt() {
        return emdAmt;
    }

    public void setEmdAmt(String emdAmt) {
        this.emdAmt = emdAmt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPackageDuration() {
        return packageDuration;
    }

    public void setPackageDuration(String packageDuration) {
        this.packageDuration = packageDuration;
    }

    public String getProcessingFeesPer() {
        return processingFeesPer;
    }

    public void setProcessingFeesPer(String processingFeesPer) {
        this.processingFeesPer = processingFeesPer;
    }

    public String getLoanDocumentsPer() {
        return loanDocumentsPer;
    }

    public void setLoanDocumentsPer(String loanDocumentsPer) {
        this.loanDocumentsPer = loanDocumentsPer;
    }

}
