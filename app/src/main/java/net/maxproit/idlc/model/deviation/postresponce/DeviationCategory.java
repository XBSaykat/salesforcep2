
package net.maxproit.idlc.model.deviation.postresponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviationCategory {

    @SerializedName("DeviationCategory")
    @Expose
    private String deviationCategory;
    @SerializedName("DeviationCategoryID")
    @Expose
    private Integer deviationCategoryID;

    public String getDeviationCategory() {
        return deviationCategory;
    }

    public void setDeviationCategory(String deviationCategory) {
        this.deviationCategory = deviationCategory;
    }

    public Integer getDeviationCategoryID() {
        return deviationCategoryID;
    }

    public void setDeviationCategoryID(Integer deviationCategoryID) {
        this.deviationCategoryID = deviationCategoryID;
    }

}
