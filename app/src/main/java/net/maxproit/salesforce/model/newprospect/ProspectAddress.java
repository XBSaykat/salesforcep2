
package net.maxproit.salesforce.model.newprospect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProspectAddress {

    @SerializedName("addressID")
    @Expose
    private int addressID;
    @SerializedName("addressType")
    @Expose
    private String addressType;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("village")
    @Expose
    private String village;
    @SerializedName("houseName")
    @Expose
    private String houseName;
    @SerializedName("appartmentNo")
    @Expose
    private String appartmentNo;
    @SerializedName("floor")
    @Expose
    private String floor;
    @SerializedName("holdingNumber")
    @Expose
    private String holdingNumber;
    @SerializedName("road")
    @Expose
    private String road;
    @SerializedName("ps")
    @Expose
    private String ps;
    @SerializedName("premiseOwnershipStatus")
    @Expose
    private String premiseOwnershipStatus;
    @SerializedName("nearestLandMark")
    @Expose
    private String nearestLandMark;
    @SerializedName("preCity")
    @Expose
    private String city;

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public ProspectAddress withAddressID(int addressID) {
        this.addressID = addressID;
        return this;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public ProspectAddress withAddressType(String addressType) {
        this.addressType = addressType;
        return this;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public ProspectAddress withArea(String area) {
        this.area = area;
        return this;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public ProspectAddress withVillage(String village) {
        this.village = village;
        return this;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public ProspectAddress withHouseName(String houseName) {
        this.houseName = houseName;
        return this;
    }

    public String getAppartmentNo() {
        return appartmentNo;
    }

    public void setAppartmentNo(String appartmentNo) {
        this.appartmentNo = appartmentNo;
    }

    public ProspectAddress withAppartmentNo(String appartmentNo) {
        this.appartmentNo = appartmentNo;
        return this;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public ProspectAddress withFloor(String floor) {
        this.floor = floor;
        return this;
    }

    public String getHoldingNumber() {
        return holdingNumber;
    }

    public void setHoldingNumber(String holdingNumber) {
        this.holdingNumber = holdingNumber;
    }

    public ProspectAddress withHoldingNumber(String holdingNumber) {
        this.holdingNumber = holdingNumber;
        return this;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public ProspectAddress withRoad(String road) {
        this.road = road;
        return this;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public ProspectAddress withPs(String ps) {
        this.ps = ps;
        return this;
    }

    public String getPremiseOwnershipStatus() {
        return premiseOwnershipStatus;
    }

    public void setPremiseOwnershipStatus(String premiseOwnershipStatus) {
        this.premiseOwnershipStatus = premiseOwnershipStatus;
    }

    public ProspectAddress withPremiseOwnershipStatus(String premiseOwnershipStatus) {
        this.premiseOwnershipStatus = premiseOwnershipStatus;
        return this;
    }

    public String getNearestLandMark() {
        return nearestLandMark;
    }

    public void setNearestLandMark(String nearestLandMark) {
        this.nearestLandMark = nearestLandMark;
    }

    public ProspectAddress withNearestLandMark(String nearestLandMark) {
        this.nearestLandMark = nearestLandMark;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ProspectAddress withCity(String city) {
        this.city = city;
        return this;
    }

}
