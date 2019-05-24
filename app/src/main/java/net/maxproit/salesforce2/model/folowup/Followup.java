package net.maxproit.salesforce2.model.folowup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan Chowdhury on 9/27/2018.
 * heyrezwan@gmail.com
 */
public class Followup {



    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("CIF")
    @Expose
    private String cIF;
    @SerializedName("FollowupDate")
    @Expose
    private String followupDate;
    @SerializedName("LastMeetingDate")
    @Expose
    private String lastMeetingDate;
    @SerializedName("Remarks")
    @Expose
    private String remarks;
    @SerializedName("ActivityType")
    @Expose
    private String activityType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCIF() {
        return cIF;
    }

    public void setCIF(String cIF) {
        this.cIF = cIF;
    }

    public String getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(String followupDate) {
        this.followupDate = followupDate;
    }

    public String getLastMeetingDate() {
        return lastMeetingDate;
    }

    public void setLastMeetingDate(String lastMeetingDate) {
        this.lastMeetingDate = lastMeetingDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }
}
