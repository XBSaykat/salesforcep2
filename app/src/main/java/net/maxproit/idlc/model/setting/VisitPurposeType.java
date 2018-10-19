
package net.maxproit.idlc.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VisitPurposeType {

    @SerializedName("ActivityType")
    @Expose
    private String activityType;
    @SerializedName("ActivityTypeCode")
    @Expose
    private int activityTypeCode;

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public VisitPurposeType withActivityType(String activityType) {
        this.activityType = activityType;
        return this;
    }

    public int getActivityTypeCode() {
        return activityTypeCode;
    }

    public void setActivityTypeCode(int activityTypeCode) {
        this.activityTypeCode = activityTypeCode;
    }

    public VisitPurposeType withActivityTypeCode(int activityTypeCode) {
        this.activityTypeCode = activityTypeCode;
        return this;
    }

}
