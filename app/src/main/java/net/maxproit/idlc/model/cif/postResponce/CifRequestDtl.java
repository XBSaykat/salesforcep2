
package net.maxproit.idlc.model.cif.postResponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CifRequestDtl {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ProspectIndexID")
    @Expose
    private Integer prospectIndexID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProspectIndexID() {
        return prospectIndexID;
    }

    public void setProspectIndexID(Integer prospectIndexID) {
        this.prospectIndexID = prospectIndexID;
    }

}
