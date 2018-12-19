
package net.maxproit.salesforce.masum.model.api.performance;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("ItemType")
    @Expose
    private String itemType;
    @SerializedName("SubItemTypes")
    @Expose
    private List<SubItemType> subItemTypes = null;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public List<SubItemType> getSubItemTypes() {
        return subItemTypes;
    }

    public void setSubItemTypes(List<SubItemType> subItemTypes) {
        this.subItemTypes = subItemTypes;
    }

}
