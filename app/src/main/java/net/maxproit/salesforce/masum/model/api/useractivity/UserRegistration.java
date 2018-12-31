package net.maxproit.salesforce.masum.model.api.useractivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegistration {

    @SerializedName("userLogin")
    @Expose
    private String userLogin;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("imei")
    @Expose
    private String imei;
    @SerializedName("lastUserOTP")
    @Expose
    private String lastUserOTP;

    public UserRegistration(){}

    public UserRegistration(String userLogin, String password, String imei, String lastUserOTP) {
        this.userLogin = userLogin;
        this.password = password;
        this.imei = imei;
        this.lastUserOTP = lastUserOTP;
    }

    public UserRegistration(String userLogin, String password, String lastUserOTP) {
        this.userLogin = userLogin;
        this.password = password;
        this.lastUserOTP = lastUserOTP;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getLastUserOTP() {
        return lastUserOTP;
    }

    public void setLastUserOTP(String lastUserOTP) {
        this.lastUserOTP = lastUserOTP;
    }

}