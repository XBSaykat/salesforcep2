package net.maxproit.salesforce2.masum.model.api.useractivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerateOtp {

    @SerializedName("userLogin")
    @Expose
    private String userLogin;
    @SerializedName("password")
    @Expose
    private String password;

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

}