package net.maxproit.salesforce2.model.mylead.approvalresponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan chowdhury on 6/27/18.
 * heyRezwan@gmail.com
 */
public class Data {


    @SerializedName("Status")
    @Expose
    private String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Data withSuccess(String success) {
        this.success = success;
        return this;
    }
}
