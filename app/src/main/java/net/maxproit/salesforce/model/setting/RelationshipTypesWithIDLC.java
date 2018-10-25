
package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelationshipTypesWithIDLC {

    @SerializedName("RelationshipType")
    @Expose
    private String relationshipType = "";
    @SerializedName("RelationshipTypeCode")
    @Expose
    private int relationshipTypeCode;

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public RelationshipTypesWithIDLC withRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
        return this;
    }

    public int getRelationshipTypeCode() {
        return relationshipTypeCode;
    }

    public void setRelationshipTypeCode(int relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
    }

    public RelationshipTypesWithIDLC withRelationshipTypeCode(int relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
        return this;
    }

}
