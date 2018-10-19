
package net.maxproit.idlc.model.deviation.postresponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviationHead {

    @SerializedName("DevAccountHeadCode")
    @Expose
    private Integer devAccountHeadCode;
    @SerializedName("DevAccountHeadName")
    @Expose
    private String devAccountHeadName;

    public Integer getDevAccountHeadCode() {
        return devAccountHeadCode;
    }

    public void setDevAccountHeadCode(Integer devAccountHeadCode) {
        this.devAccountHeadCode = devAccountHeadCode;
    }

    public String getDevAccountHeadName() {
        return devAccountHeadName;
    }

    public void setDevAccountHeadName(String devAccountHeadName) {
        this.devAccountHeadName = devAccountHeadName;
    }

}
