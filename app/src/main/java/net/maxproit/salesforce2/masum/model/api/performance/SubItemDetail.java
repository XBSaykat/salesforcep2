
package net.maxproit.salesforce2.masum.model.api.performance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubItemDetail {

    @SerializedName("SubItemDetail")
    @Expose
    private String subItemDetail;
    @SerializedName("SubItemDetailCount")
    @Expose
    private Integer subItemDetailCount;

    public String getSubItemDetail() {
        return subItemDetail;
    }

    public void setSubItemDetail(String subItemDetail) {
        this.subItemDetail = subItemDetail;
    }

    public Integer getSubItemDetailCount() {
        return subItemDetailCount;
    }

    public void setSubItemDetailCount(Integer subItemDetailCount) {
        this.subItemDetailCount = subItemDetailCount;
    }

}
