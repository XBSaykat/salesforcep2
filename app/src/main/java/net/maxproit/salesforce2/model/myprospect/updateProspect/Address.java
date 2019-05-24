
package net.maxproit.salesforce2.model.myprospect.updateProspect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("AddressID")
    @Expose
    private int addressID;
    @SerializedName("AddressType")
    @Expose
    private String addressType;
    @SerializedName("AppartmentNo")
    @Expose
    private String appartmentNo;
    @SerializedName("Area")
    @Expose
    private String area;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("Floor")
    @Expose
    private String floor;
    @SerializedName("HoldingNumber")
    @Expose
    private String holdingNumber;
    @SerializedName("HouseName")
    @Expose
    private String houseName;
    @SerializedName("NearestLandMark")
    @Expose
    private String nearestLandMark;
    @SerializedName("PremiseOwnershipStatus")
    @Expose
    private String premiseOwnershipStatus;
    @SerializedName("Ps")
    @Expose
    private String ps;
    @SerializedName("Road")
    @Expose
    private String road;
    @SerializedName("Village")
    @Expose
    private String village;

    public Address() {
    }

    public Address(int addressID, String addressType, String appartmentNo, String area, String city, String floor, String holdingNumber, String houseName, String nearestLandMark, String premiseOwnershipStatus, String ps, String road, String village) {
        this.addressID = addressID;
        this.addressType = addressType;
        this.appartmentNo = appartmentNo;
        this.area = area;
        this.city = city;
        this.floor = floor;
        this.holdingNumber = holdingNumber;
        this.houseName = houseName;
        this.nearestLandMark = nearestLandMark;
        this.premiseOwnershipStatus = premiseOwnershipStatus;
        this.ps = ps;
        this.road = road;
        this.village = village;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public Address withAddressID(int addressID) {
        this.addressID = addressID;
        return this;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Address withAddressType(String addressType) {
        this.addressType = addressType;
        return this;
    }

    public String getAppartmentNo() {
        return appartmentNo;
    }

    public void setAppartmentNo(String appartmentNo) {
        this.appartmentNo = appartmentNo;
    }

    public Address withAppartmentNo(String appartmentNo) {
        this.appartmentNo = appartmentNo;
        return this;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Address withArea(String area) {
        this.area = area;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Address withFloor(String floor) {
        this.floor = floor;
        return this;
    }

    public String getHoldingNumber() {
        return holdingNumber;
    }

    public void setHoldingNumber(String holdingNumber) {
        this.holdingNumber = holdingNumber;
    }

    public Address withHoldingNumber(String holdingNumber) {
        this.holdingNumber = holdingNumber;
        return this;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Address withHouseName(String houseName) {
        this.houseName = houseName;
        return this;
    }

    public String getNearestLandMark() {
        return nearestLandMark;
    }

    public void setNearestLandMark(String nearestLandMark) {
        this.nearestLandMark = nearestLandMark;
    }

    public Address withNearestLandMark(String nearestLandMark) {
        this.nearestLandMark = nearestLandMark;
        return this;
    }

    public String getPremiseOwnershipStatus() {
        return premiseOwnershipStatus;
    }

    public void setPremiseOwnershipStatus(String premiseOwnershipStatus) {
        this.premiseOwnershipStatus = premiseOwnershipStatus;
    }

    public Address withPremiseOwnershipStatus(String premiseOwnershipStatus) {
        this.premiseOwnershipStatus = premiseOwnershipStatus;
        return this;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public Address withPs(String ps) {
        this.ps = ps;
        return this;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public Address withRoad(String road) {
        this.road = road;
        return this;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Address withVillage(String village) {
        this.village = village;
        return this;
    }

}
