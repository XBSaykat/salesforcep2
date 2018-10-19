
package net.maxproit.idlc.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Branch {

    @SerializedName("Branch")
    @Expose
    private String branch;
    @SerializedName("BranchCode")
    @Expose
    private String branchCode;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Branch withBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Branch withBranchCode(String branchCode) {
        this.branchCode = branchCode;
        return this;
    }

}
