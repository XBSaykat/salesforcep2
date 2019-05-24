
package net.maxproit.salesforce2.model.newprospect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VisitRecord {

    @SerializedName("activityID")
    @Expose
    private int activityID;
    @SerializedName("visitPurpose")
    @Expose
    private String visitPurpose;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("meetingDate")
    @Expose
    private String meetingDate;
    @SerializedName("followupDate")
    @Expose
    private String followupDate;

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public VisitRecord withActivityID(int activityID) {
        this.activityID = activityID;
        return this;
    }

    public String getVisitPurpose() {
        return visitPurpose;
    }

    public void setVisitPurpose(String visitPurpose) {
        this.visitPurpose = visitPurpose;
    }

    public VisitRecord withVisitPurpose(String visitPurpose) {
        this.visitPurpose = visitPurpose;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public VisitRecord withRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public VisitRecord withMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
        return this;
    }

    public String getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(String followupDate) {
        this.followupDate = followupDate;
    }

    public VisitRecord withFollowupDate(String followupDate) {
        this.followupDate = followupDate;
        return this;
    }

}
