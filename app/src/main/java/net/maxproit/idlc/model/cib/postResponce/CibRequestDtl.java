
package net.maxproit.idlc.model.cib.postResponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CibRequestDtl {

    @SerializedName("ProspectIndexID")
    @Expose
    private Integer prospectIndexID;

    public Integer getProspectIndexID() {
        return prospectIndexID;
    }

    public void setProspectIndexID(Integer prospectIndexID) {
        this.prospectIndexID = prospectIndexID;
    }

}
