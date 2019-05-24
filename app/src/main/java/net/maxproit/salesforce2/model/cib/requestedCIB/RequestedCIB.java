
package net.maxproit.salesforce2.model.cib.requestedCIB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestedCIB {

    @SerializedName("CIBRequestedFor")
    @Expose
    private String cIBRequestedFor;
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

    public String getCIBRequestedFor() {
        return cIBRequestedFor;
    }

    public void setCIBRequestedFor(String cIBRequestedFor) {
        this.cIBRequestedFor = cIBRequestedFor;
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
