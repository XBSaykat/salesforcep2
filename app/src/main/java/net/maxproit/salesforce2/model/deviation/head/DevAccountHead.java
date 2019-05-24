package net.maxproit.salesforce2.model.deviation.head;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan chowdhury on 7/8/18.
 * heyRezwan@gmail.com
 */
public class DevAccountHead {
    @SerializedName("DevAccountHeadCode")
    @Expose
    private int devAccountHeadCode;
    @SerializedName("DevAccountHeadName")
    @Expose
    private String devAccountHeadName;

    public int getDevAccountHeadCode() {
        return devAccountHeadCode;
    }

    public void setDevAccountHeadCode(int devAccountHeadCode) {
        this.devAccountHeadCode = devAccountHeadCode;
    }

    public String getDevAccountHeadName() {
        return devAccountHeadName;
    }

    public void setDevAccountHeadName(String devAccountHeadName) {
        this.devAccountHeadName = devAccountHeadName;
    }
}
