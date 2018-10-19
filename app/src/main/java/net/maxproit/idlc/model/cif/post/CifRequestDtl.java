
package net.maxproit.idlc.model.cif.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CifRequestDtl {

    @SerializedName("prospectIndexID")
    @Expose
    private Integer prospectIndexID;
    @SerializedName("name")
    @Expose
    private String name;

    public CifRequestDtl() {
    }

    public CifRequestDtl(Integer prospectIndexID, String name) {
        this.prospectIndexID = prospectIndexID;
        this.name = name;
    }

    public Integer getProspectIndexID() {
        return prospectIndexID;
    }

    public void setProspectIndexID(Integer prospectIndexID) {
        this.prospectIndexID = prospectIndexID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
