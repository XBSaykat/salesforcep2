package net.maxproit.idlc.model.supervisor.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan Chowdhury on 9/27/2018.
 * heyrezwan@gmail.com
 */
public class User {

    @SerializedName("RMName")
    @Expose
    private String rMName;
    @SerializedName("NoOfFile")
    @Expose
    private String noOfFile;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("UserName")
    @Expose
    private String userName;


    @SerializedName("NoOfFollowup")
    @Expose
    private String NoOfFollowup;


    public String getrMName() {
        return rMName;
    }

    public void setrMName(String rMName) {
        this.rMName = rMName;
    }

    public String getNoOfFollowup() {
        return NoOfFollowup;
    }

    public void setNoOfFollowup(String noOfFollowup) {
        NoOfFollowup = noOfFollowup;
    }

    public String getRMName() {
        return rMName;
    }

    public void setRMName(String rMName) {
        this.rMName = rMName;
    }

    public String getNoOfFile() {
        return noOfFile;
    }

    public void setNoOfFile(String noOfFile) {
        this.noOfFile = noOfFile;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
