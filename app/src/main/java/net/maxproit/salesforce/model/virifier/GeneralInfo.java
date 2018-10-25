package net.maxproit.salesforce.model.virifier;

public class GeneralInfo {
    private String indType = "";
    private String relation = "";
    private String natureBus = "";
    private String appMobile = "";
    private String legStatus = "";
    private String tinNumber = "";
    private String tradNumber = "";
    private String liIssueDate = "";
    private String liExpDate = "";
    private String busSince = "";

    public String getLiExpDate() {
        return liExpDate;
    }

    public void setLiExpDate(String liExpDate) {
        this.liExpDate = liExpDate;
    }

    public String getIndType() {
        return indType;
    }

    public void setIndType(String indType) {
        this.indType = indType;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getNatureBus() {
        return natureBus;
    }

    public void setNatureBus(String natureBus) {
        this.natureBus = natureBus;
    }

    public String getAppMobile() {
        return appMobile;
    }

    public void setAppMobile(String appMobile) {
        this.appMobile = appMobile;
    }

    public String getLegStatus() {
        return legStatus;
    }

    public void setLegStatus(String legStatus) {
        this.legStatus = legStatus;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getTradNumber() {
        return tradNumber;
    }

    public void setTradNumber(String tradNumber) {
        this.tradNumber = tradNumber;
    }

    public String getLiIssueDate() {
        return liIssueDate;
    }

    public void setLiIssueDate(String liIssueDate) {
        this.liIssueDate = liIssueDate;
    }

    public String getBusSince() {
        return busSince;
    }

    public void setBusSince(String busSince) {
        this.busSince = busSince;
    }
}
