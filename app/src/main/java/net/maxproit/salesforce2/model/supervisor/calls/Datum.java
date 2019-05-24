
package net.maxproit.salesforce2.model.supervisor.calls;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("ActivityType")
    @Expose
    private String activityType;
    @SerializedName("ActivityTypeCode")
    @Expose
    private String activityTypeCode;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("ActivityDate")
    @Expose
    private String activityDate;
    @SerializedName("NextDate")
    @Expose
    private String nextDate;
    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("SpecialRecommendation")
    @Expose
    private String specialRecommendation;

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Datum withActivityType(String activityType) {
        this.activityType = activityType;
        return this;
    }

    public String getActivityTypeCode() {
        return activityTypeCode;
    }

    public void setActivityTypeCode(String activityTypeCode) {
        this.activityTypeCode = activityTypeCode;
    }

    public Datum withActivityTypeCode(String activityTypeCode) {
        this.activityTypeCode = activityTypeCode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Datum withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public Datum withActivityDate(String activityDate) {
        this.activityDate = activityDate;
        return this;
    }

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }

    public Datum withNextDate(String nextDate) {
        this.nextDate = nextDate;
        return this;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Datum withUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public String getSpecialRecommendation() {
        return specialRecommendation;
    }

    public void setSpecialRecommendation(String specialRecommendation) {
        this.specialRecommendation = specialRecommendation;
    }

    public Datum withSpecialRecommendation(String specialRecommendation) {
        this.specialRecommendation = specialRecommendation;
        return this;
    }

}
