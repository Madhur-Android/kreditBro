package com.example.kreditbro.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpUser {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("dob")
    @Expose
    private Object dob;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("pincode")
    @Expose
    private Object pincode;
    @SerializedName("user_type")
    @Expose
    private Object userType;
    @SerializedName("officeaddress")
    @Expose
    private Object officeaddress;
    @SerializedName("currentaddress")
    @Expose
    private Object currentaddress;
    @SerializedName("relativeNumberName")
    @Expose
    private Object relativeNumberName;
    @SerializedName("relativenumber")
    @Expose
    private Object relativenumber;
    @SerializedName("relativeNumberTwoName")
    @Expose
    private Object relativeNumberTwoName;
    @SerializedName("relativenumbertwo")
    @Expose
    private Object relativenumbertwo;
    @SerializedName("monthlysalary")
    @Expose
    private Object monthlysalary;
    @SerializedName("referal_code")
    @Expose
    private Object referalCode;
    @SerializedName("fcm_token")
    @Expose
    private Object fcmToken;
    @SerializedName("pan")
    @Expose
    private Object pan;
    @SerializedName("pan_name")
    @Expose
    private Object panName;
    @SerializedName("pan_image")
    @Expose
    private Object panImage;
    @SerializedName("adhar")
    @Expose
    private Object adhar;
    @SerializedName("adhar_name")
    @Expose
    private Object adharName;
    @SerializedName("adhar_front_image")
    @Expose
    private Object adharFrontImage;
    @SerializedName("adhar_back_image")
    @Expose
    private Object adharBackImage;
    @SerializedName("selfie_image")
    @Expose
    private Object selfieImage;
    @SerializedName("sign_image")
    @Expose
    private Object signImage;
    @SerializedName("bank_statement")
    @Expose
    private Object bankStatement;
    @SerializedName("kyc_approval")
    @Expose
    private String kycApproval;
    @SerializedName("kyc_reason")
    @Expose
    private Object kycReason;
    @SerializedName("login_otp")
    @Expose
    private String loginOtp;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("contacts")
    @Expose
    private Object contacts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getDob() {
        return dob;
    }

    public void setDob(Object dob) {
        this.dob = dob;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getPincode() {
        return pincode;
    }

    public void setPincode(Object pincode) {
        this.pincode = pincode;
    }

    public Object getUserType() {
        return userType;
    }

    public void setUserType(Object userType) {
        this.userType = userType;
    }

    public Object getOfficeaddress() {
        return officeaddress;
    }

    public void setOfficeaddress(Object officeaddress) {
        this.officeaddress = officeaddress;
    }

    public Object getCurrentaddress() {
        return currentaddress;
    }

    public void setCurrentaddress(Object currentaddress) {
        this.currentaddress = currentaddress;
    }

    public Object getRelativeNumberName() {
        return relativeNumberName;
    }

    public void setRelativeNumberName(Object relativeNumberName) {
        this.relativeNumberName = relativeNumberName;
    }

    public Object getRelativenumber() {
        return relativenumber;
    }

    public void setRelativenumber(Object relativenumber) {
        this.relativenumber = relativenumber;
    }

    public Object getRelativeNumberTwoName() {
        return relativeNumberTwoName;
    }

    public void setRelativeNumberTwoName(Object relativeNumberTwoName) {
        this.relativeNumberTwoName = relativeNumberTwoName;
    }

    public Object getRelativenumbertwo() {
        return relativenumbertwo;
    }

    public void setRelativenumbertwo(Object relativenumbertwo) {
        this.relativenumbertwo = relativenumbertwo;
    }

    public Object getMonthlysalary() {
        return monthlysalary;
    }

    public void setMonthlysalary(Object monthlysalary) {
        this.monthlysalary = monthlysalary;
    }

    public Object getReferalCode() {
        return referalCode;
    }

    public void setReferalCode(Object referalCode) {
        this.referalCode = referalCode;
    }

    public Object getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(Object fcmToken) {
        this.fcmToken = fcmToken;
    }

    public Object getPan() {
        return pan;
    }

    public void setPan(Object pan) {
        this.pan = pan;
    }

    public Object getPanName() {
        return panName;
    }

    public void setPanName(Object panName) {
        this.panName = panName;
    }

    public Object getPanImage() {
        return panImage;
    }

    public void setPanImage(Object panImage) {
        this.panImage = panImage;
    }

    public Object getAdhar() {
        return adhar;
    }

    public void setAdhar(Object adhar) {
        this.adhar = adhar;
    }

    public Object getAdharName() {
        return adharName;
    }

    public void setAdharName(Object adharName) {
        this.adharName = adharName;
    }

    public Object getAdharFrontImage() {
        return adharFrontImage;
    }

    public void setAdharFrontImage(Object adharFrontImage) {
        this.adharFrontImage = adharFrontImage;
    }

    public Object getAdharBackImage() {
        return adharBackImage;
    }

    public void setAdharBackImage(Object adharBackImage) {
        this.adharBackImage = adharBackImage;
    }

    public Object getSelfieImage() {
        return selfieImage;
    }

    public void setSelfieImage(Object selfieImage) {
        this.selfieImage = selfieImage;
    }

    public Object getSignImage() {
        return signImage;
    }

    public void setSignImage(Object signImage) {
        this.signImage = signImage;
    }

    public Object getBankStatement() {
        return bankStatement;
    }

    public void setBankStatement(Object bankStatement) {
        this.bankStatement = bankStatement;
    }

    public String getKycApproval() {
        return kycApproval;
    }

    public void setKycApproval(String kycApproval) {
        this.kycApproval = kycApproval;
    }

    public Object getKycReason() {
        return kycReason;
    }

    public void setKycReason(Object kycReason) {
        this.kycReason = kycReason;
    }

    public String getLoginOtp() {
        return loginOtp;
    }

    public void setLoginOtp(String loginOtp) {
        this.loginOtp = loginOtp;
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

    public Object getContacts() {
        return contacts;
    }

    public void setContacts(Object contacts) {
        this.contacts = contacts;
    }
}
