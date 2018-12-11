package net.maxproit.salesforce.masum.model.api.Deviation.deviationaccounthead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Mehedi Hasan on 12/11/2018.
 * mehedipy@gmail.com
 */
public class Data {
    @SerializedName("DevAccountHeadCode")
    @Expose
    private Integer devAccountHeadCode;
    @SerializedName("DevAccountHeadName")
    @Expose
    private String devAccountHeadName;
    @SerializedName("RiskCategory")
    @Expose
    private String riskCategory;

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

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }
}
