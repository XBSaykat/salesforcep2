package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Mehedi Hasan on 12/11/2018.
 * mehedipy@gmail.com
 */
public class LstDeviationJustification {

    @SerializedName("Justification")
    @Expose
    private String justification;
    @SerializedName("JustificationID")
    @Expose
    private Integer justificationID;

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Integer getJustificationID() {
        return justificationID;
    }

    public void setJustificationID(Integer justificationID) {
        this.justificationID = justificationID;
    }
}