package net.maxproit.salesforce.masum.model.api.Deviation.postdeviation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Mehedi Hasan on 12/11/2018.
 * mehedipy@gmail.com
 */
public class DeviationHead {
    @SerializedName("devAccountHeadName")
    @Expose
    private String devAccountHeadName;
    @SerializedName("devAccountHeadCode")
    @Expose
    private Integer devAccountHeadCode;
    @SerializedName("riskCategory")
    @Expose
    private String riskCategory;

    public String getDevAccountHeadName() {
        return devAccountHeadName;
    }

    public void setDevAccountHeadName(String devAccountHeadName) {
        this.devAccountHeadName = devAccountHeadName;
    }

    public Integer getDevAccountHeadCode() {
        return devAccountHeadCode;
    }

    public void setDevAccountHeadCode(Integer devAccountHeadCode) {
        this.devAccountHeadCode = devAccountHeadCode;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }
}
