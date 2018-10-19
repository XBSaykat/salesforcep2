
package net.maxproit.idlc.model.supervisor.prospects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("Reference")
    @Expose
    private String reference;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Branch")
    @Expose
    private String branch;
    @SerializedName("Product")
    @Expose
    private String product;
    @SerializedName("ApproverPool")
    @Expose
    private String approverPool;
    @SerializedName("CurrentLevel")
    @Expose
    private String currentLevel;
    @SerializedName("ApprovalSetID")
    @Expose
    private String approvalSetID;

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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getApproverPool() {
        return approverPool;
    }

    public void setApproverPool(String approverPool) {
        this.approverPool = approverPool;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(String currentLevel) {
        this.currentLevel = currentLevel;
    }

    public String getApprovalSetID() {
        return approvalSetID;
    }

    public void setApprovalSetID(String approvalSetID) {
        this.approvalSetID = approvalSetID;
    }

}

