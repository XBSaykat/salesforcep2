
package net.maxproit.idlc.model.cib;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CibRequestDtl {

    @SerializedName("CIBRequestID")
    @Expose
    private int cIBRequestID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ProspectIndexID")
    @Expose
    private int prospectIndexID;
    @SerializedName("Relation")
    @Expose
    private String relation;
    @SerializedName("Status")
    @Expose
    private String status;
    private boolean selected;

    public int getCIBRequestID() {
        return cIBRequestID;
    }

    public void setCIBRequestID(int cIBRequestID) {
        this.cIBRequestID = cIBRequestID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProspectIndexID() {
        return prospectIndexID;
    }

    public void setProspectIndexID(int prospectIndexID) {
        this.prospectIndexID = prospectIndexID;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
