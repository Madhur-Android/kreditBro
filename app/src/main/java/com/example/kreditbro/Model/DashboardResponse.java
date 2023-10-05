package com.example.kreditbro.Model;

import com.example.kreditbro.response.Banner;
import com.example.kreditbro.response.DashboardUser;
import com.example.kreditbro.response.LoanInfo;
import com.example.kreditbro.response.Package;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DashboardResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("user")
    @Expose
    private DashboardUser user;
    @SerializedName("banner")
    @Expose
    private List<Banner> banner;
    @SerializedName("packages")
    @Expose
    private List<Package> packages;
    @SerializedName("custom_packages")
    @Expose
    private List<Object> customPackages;
    @SerializedName("assigned_package")
    @Expose
    private Integer assignedPackage;
    @SerializedName("assigned_custom")
    @Expose
    private Integer assignedCustom;
    @SerializedName("loan_info")
    @Expose
    private LoanInfo loanInfo;
    @SerializedName("kyc")
    @Expose
    private String kyc;
    @SerializedName("kyc_reason")
    @Expose
    private String kycReason;
    @SerializedName("notification_count")
    @Expose
    private Integer notificationCount;
    @SerializedName("enc_id")
    @Expose
    private String encId;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public DashboardUser getUser() {
        return user;
    }

    public void setUser(DashboardUser user) {
        this.user = user;
    }

    public List<Banner> getBanner() {
        return banner;
    }

    public void setBanner(List<Banner> banner) {
        this.banner = banner;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public List<Object> getCustomPackages() {
        return customPackages;
    }

    public void setCustomPackages(List<Object> customPackages) {
        this.customPackages = customPackages;
    }

    public Integer getAssignedPackage() {
        return assignedPackage;
    }

    public void setAssignedPackage(Integer assignedPackage) {
        this.assignedPackage = assignedPackage;
    }

    public Integer getAssignedCustom() {
        return assignedCustom;
    }

    public void setAssignedCustom(Integer assignedCustom) {
        this.assignedCustom = assignedCustom;
    }

    public LoanInfo getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(LoanInfo loanInfo) {
        this.loanInfo = loanInfo;
    }

    public String getKyc() {
        return kyc;
    }

    public void setKyc(String kyc) {
        this.kyc = kyc;
    }

    public String getKycReason() {
        return kycReason;
    }

    public void setKycReason(String kycReason) {
        this.kycReason = kycReason;
    }

    public Integer getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(Integer notificationCount) {
        this.notificationCount = notificationCount;
    }

    public String getEncId() {
        return encId;
    }

    public void setEncId(String encId) {
        this.encId = encId;
    }
}
