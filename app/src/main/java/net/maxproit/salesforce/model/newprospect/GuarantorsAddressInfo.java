package net.maxproit.salesforce.model.newprospect;

public class GuarantorsAddressInfo {
    String addType = "";
    String district = "";
    String upazila = "";
    String areaName = "";
    String village = "";
    String aprName = "";
    String holdNumber = "";
    String roadNumber = "";
    String ownership = "";

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getAddType() {
        return addType;
    }

    public void setAddType(String addType) {
        this.addType = addType;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUpazila() {
        return upazila;
    }

    public void setUpazila(String upazila) {
        this.upazila = upazila;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getAprName() {
        return aprName;
    }

    public void setAprName(String aprName) {
        this.aprName = aprName;
    }

    public String getHoldNumber() {
        return holdNumber;
    }

    public void setHoldNumber(String holdNumber) {
        this.holdNumber = holdNumber;
    }

    public String getRoadNumber() {
        return roadNumber;
    }

    public void setRoadNumber(String roadNumber) {
        this.roadNumber = roadNumber;
    }
}
