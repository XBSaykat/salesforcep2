package net.maxproit.idlc.model.cib.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CibRequestDtl {

    @SerializedName("prospectIndexID")
    @Expose
    private int prospectIndexID;

    public CibRequestDtl() {
    }

    public CibRequestDtl(int prospectIndexID) {
        this.prospectIndexID = prospectIndexID;
    }

    public int getProspectIndexID() {
        return prospectIndexID;
    }

    public void setProspectIndexID(int prospectIndexID) {
        this.prospectIndexID = prospectIndexID;
    }

}