package net.maxproit.salesforce.masum.model.api.myactivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("ActivityJournalID")
    @Expose
    private String activityJournalID;
    @SerializedName("ClientType")
    @Expose
    private String clientType;
    @SerializedName("ClientName")
    @Expose
    private String clientName;
    @SerializedName("ActivityStatus")
    @Expose
    private String activityStatus;
    @SerializedName("MakerName")
    @Expose
    private String makerName;
    @SerializedName("ActivityType")
    @Expose
    private String activityType;

    public String getActivityJournalID() {
        return activityJournalID;
    }

    public void setActivityJournalID(String activityJournalID) {
        this.activityJournalID = activityJournalID;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

}

