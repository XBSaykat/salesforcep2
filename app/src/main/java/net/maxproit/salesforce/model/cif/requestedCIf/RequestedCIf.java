
package net.maxproit.salesforce.model.cif.requestedCIf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestedCIf {

    @SerializedName("CIFRequestedFor")
    @Expose
    private String cIFRequestedFor;
    @SerializedName("RequestBy")
    @Expose
    private String requestBy;
    @SerializedName("RequestDate")
    @Expose
    private String requestDate;
    @SerializedName("AssignedTo")
    @Expose
    private String assignedTo;
    @SerializedName("AssignedBy")
    @Expose
    private String assignedBy;
    @SerializedName("RequestTaskStatus")
    @Expose
    private String requestTaskStatus;
    @SerializedName("Remark")
    @Expose
    private String remark;

    public String getCIFRequestedFor() {
        return cIFRequestedFor;
    }

    public void setCIFRequestedFor(String cIFRequestedFor) {
        this.cIFRequestedFor = cIFRequestedFor;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getRequestTaskStatus() {
        return requestTaskStatus;
    }

    public void setRequestTaskStatus(String requestTaskStatus) {
        this.requestTaskStatus = requestTaskStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
