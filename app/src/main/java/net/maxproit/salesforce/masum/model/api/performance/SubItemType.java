
package net.maxproit.salesforce.masum.model.api.performance;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubItemType {

    @SerializedName("SubItemDetails")
    @Expose
    private List<SubItemDetail> subItemDetails = null;
    @SerializedName("SubItemType")
    @Expose
    private String subItemType;
    @SerializedName("SubItemTypeCount")
    @Expose
    private Integer subItemTypeCount;

    public List<SubItemDetail> getSubItemDetails() {
        return subItemDetails;
    }

    public void setSubItemDetails(List<SubItemDetail> subItemDetails) {
        this.subItemDetails = subItemDetails;
    }

    public String getSubItemType() {
        return subItemType;
    }

    public void setSubItemType(String subItemType) {
        this.subItemType = subItemType;
    }

    public Integer getSubItemTypeCount() {
        return subItemTypeCount;
    }

    public void setSubItemTypeCount(Integer subItemTypeCount) {
        this.subItemTypeCount = subItemTypeCount;
    }

}
