
package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviationType {

    @SerializedName("DeviationType")
    @Expose
    private String deviationType;
    @SerializedName("DeviationTypeCode")
    @Expose
    private int deviationTypeCode;

    public String getDeviationType() {
        return deviationType;
    }

    public void setDeviationType(String deviationType) {
        this.deviationType = deviationType;
    }

    public DeviationType withDeviationType(String deviationType) {
        this.deviationType = deviationType;
        return this;
    }

    public int getDeviationTypeCode() {
        return deviationTypeCode;
    }

    public void setDeviationTypeCode(int deviationTypeCode) {
        this.deviationTypeCode = deviationTypeCode;
    }

    public DeviationType withDeviationTypeCode(int deviationTypeCode) {
        this.deviationTypeCode = deviationTypeCode;
        return this;
    }

}
