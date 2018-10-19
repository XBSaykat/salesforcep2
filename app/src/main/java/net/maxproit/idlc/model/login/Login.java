package net.maxproit.idlc.model.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan chowdhury on 6/8/18.
 * heyRezwan@gmail.com
 */
public class Login {
    @SerializedName("userLogin")
    private String userLogin = "";

    @SerializedName("password")
    private String password = "";

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return
                "Response{" +
                        "userLogin = '" + userLogin + '\'' +
                        ",password = '" + password + '\'' +
                        "}";
    }
}
