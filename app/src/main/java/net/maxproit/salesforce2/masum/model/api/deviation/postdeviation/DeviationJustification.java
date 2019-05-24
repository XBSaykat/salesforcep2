package net.maxproit.salesforce2.masum.model.api.deviation.postdeviation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Mehedi Hasan on 12/11/2018.
 * mehedipy@gmail.com
 */
public class DeviationJustification {
    @SerializedName("justificationID")
    @Expose
    private Integer justificationID;
    @SerializedName("justification")
    @Expose
    private String justification;

    public Integer getJustificationID() {
        return justificationID;
    }

    public void setJustificationID(Integer justificationID) {
        this.justificationID = justificationID;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

}
