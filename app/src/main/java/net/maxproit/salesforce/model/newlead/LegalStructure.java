package net.maxproit.salesforce.model.newlead;

public class LegalStructure {
    String legStr = "";
    String orgName = "";
    String offAddress = "";
    String storeAddress = "";
    String reg = "";

    public String getLegStr() {
        return legStr;
    }

    public void setLegStr(String legStr) {
        this.legStr = legStr;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOffAddress() {
        return offAddress;
    }

    public void setOffAddress(String offAddress) {
        this.offAddress = offAddress;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }
}
