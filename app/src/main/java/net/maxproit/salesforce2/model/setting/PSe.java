
package net.maxproit.salesforce2.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PSe {

    @SerializedName("CityID")
    @Expose
    private int cityID;
    @SerializedName("PS")
    @Expose
    private String pS;
    @SerializedName("PSID")
    @Expose
    private int pSID;

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public PSe withCityID(int cityID) {
        this.cityID = cityID;
        return this;
    }

    public String getPS() {
        return pS;
    }

    public void setPS(String pS) {
        this.pS = pS;
    }

    public PSe withPS(String pS) {
        this.pS = pS;
        return this;
    }

    public int getPSID() {
        return pSID;
    }

    public void setPSID(int pSID) {
        this.pSID = pSID;
    }

    public PSe withPSID(int pSID) {
        this.pSID = pSID;
        return this;
    }

}
