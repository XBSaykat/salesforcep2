
package net.maxproit.salesforce2.model.cif;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CifRequestDtl {

    boolean isSelected = false;
    @SerializedName("CIFRequestDetailID")
    @Expose
    private int cIFRequestDetailID;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getCIFRequestDetailID() {
        return cIFRequestDetailID;
    }

    public void setCIFRequestDetailID(int cIFRequestDetailID) {
        this.cIFRequestDetailID = cIFRequestDetailID;
    }

    public CifRequestDtl withCIFRequestDetailID(int cIFRequestDetailID) {
        this.cIFRequestDetailID = cIFRequestDetailID;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CifRequestDtl withName(String name) {
        this.name = name;
        return this;
    }

    public int getProspectIndexID() {
        return prospectIndexID;
    }

    public void setProspectIndexID(int prospectIndexID) {
        this.prospectIndexID = prospectIndexID;
    }

    public CifRequestDtl withProspectIndexID(int prospectIndexID) {
        this.prospectIndexID = prospectIndexID;
        return this;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public CifRequestDtl withRelation(String relation) {
        this.relation = relation;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CifRequestDtl withStatus(String status) {
        this.status = status;
        return this;
    }

}
