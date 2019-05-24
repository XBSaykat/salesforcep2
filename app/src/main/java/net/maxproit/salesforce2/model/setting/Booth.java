
package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Booth {

    @SerializedName("BoothCode")
    @Expose
    private int boothCode;
    @SerializedName("BoothName")
    @Expose
    private String boothName;
    @SerializedName("BranchCode")
    @Expose
    private int branchCode;

    public int getBoothCode() {
        return boothCode;
    }

    public void setBoothCode(int boothCode) {
        this.boothCode = boothCode;
    }

    public Booth withBoothCode(int boothCode) {
        this.boothCode = boothCode;
        return this;
    }

    public String getBoothName() {
        return boothName;
    }

    public void setBoothName(String boothName) {
        this.boothName = boothName;
    }

    public Booth withBoothName(String boothName) {
        this.boothName = boothName;
        return this;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public Booth withBranchCode(int branchCode) {
        this.branchCode = branchCode;
        return this;
    }

}
