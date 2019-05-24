
package net.maxproit.salesforce2.model.deviation.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviationHead {

    @SerializedName("devAccountHeadName")
    @Expose
    private String devAccountHeadName;
    @SerializedName("devAccountHeadCode")
    @Expose
    private int devAccountHeadCode;


    public DeviationHead() {
    }

    public DeviationHead(String devAccountHeadName, int devAccountHeadCode) {
        this.devAccountHeadName = devAccountHeadName;
        this.devAccountHeadCode = devAccountHeadCode;
    }

    public String getDevAccountHeadName() {
        return devAccountHeadName;
    }

    public void setDevAccountHeadName(String devAccountHeadName) {
        this.devAccountHeadName = devAccountHeadName;
    }

    public DeviationHead withDevAccountHeadName(String devAccountHeadName) {
        this.devAccountHeadName = devAccountHeadName;
        return this;
    }

    public int getDevAccountHeadCode() {
        return devAccountHeadCode;
    }

    public void setDevAccountHeadCode(int devAccountHeadCode) {
        this.devAccountHeadCode = devAccountHeadCode;
    }

    public DeviationHead withDevAccountHeadCode(int devAccountHeadCode) {
        this.devAccountHeadCode = devAccountHeadCode;
        return this;
    }

}
