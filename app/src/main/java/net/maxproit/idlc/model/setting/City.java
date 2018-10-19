
package net.maxproit.idlc.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("CityID")
    @Expose
    private int cityID;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public City withCity(String city) {
        this.city = city;
        return this;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public City withCityID(int cityID) {
        this.cityID = cityID;
        return this;
    }

}
