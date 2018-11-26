package net.maxproit.salesforce.masum.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LeadLeastDataFromApi implements Serializable {

@SerializedName("Reference")
@Expose
private String reference;
@SerializedName("Name")
@Expose
private String name;
@SerializedName("Branch")
@Expose
private String branch;
@SerializedName("Address")
@Expose
private String address;
@SerializedName("ApprovalSetID")
@Expose
private String approvalSetID;
@SerializedName("CurrentLevel")
@Expose
private String currentLevel;
@SerializedName("Status")
@Expose
private String status;
@SerializedName("Remark")
@Expose
private String remark;

public String getReference() {
return reference;
}

public void setReference(String reference) {
this.reference = reference;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getBranch() {
return branch;
}

public void setBranch(String branch) {
this.branch = branch;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getApprovalSetID() {
return approvalSetID;
}

public void setApprovalSetID(String approvalSetID) {
this.approvalSetID = approvalSetID;
}

public String getCurrentLevel() {
return currentLevel;
}

public void setCurrentLevel(String currentLevel) {
this.currentLevel = currentLevel;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getRemark() {
return remark;
}

public void setRemark(String remark) {
this.remark = remark;
}

}