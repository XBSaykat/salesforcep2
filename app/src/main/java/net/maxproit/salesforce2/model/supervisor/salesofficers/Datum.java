
package net.maxproit.salesforce2.model.supervisor.salesofficers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("RMCode")
    @Expose
    private String rMCode;
    @SerializedName("RMName")
    @Expose
    private String rMName;

    public String getRMCode() {
        return rMCode;
    }

    public void setRMCode(String rMCode) {
        this.rMCode = rMCode;
    }

    public Datum withRMCode(String rMCode) {
        this.rMCode = rMCode;
        return this;
    }

    public String getRMName() {
        return rMName;
    }

    public void setRMName(String rMName) {
        this.rMName = rMName;
    }

    public Datum withRMName(String rMName) {
        this.rMName = rMName;
        return this;
    }

}
