
package net.maxproit.idlc.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviationCategory {

    @SerializedName("DeviationCategory")
    @Expose
    private String deviationCategory;
    @SerializedName("DeviationCategoryID")
    @Expose
    private int deviationCategoryID;

    public String getDeviationCategory() {
        return deviationCategory;
    }

    public void setDeviationCategory(String deviationCategory) {
        this.deviationCategory = deviationCategory;
    }

    public DeviationCategory withDeviationCategory(String deviationCategory) {
        this.deviationCategory = deviationCategory;
        return this;
    }

    public int getDeviationCategoryID() {
        return deviationCategoryID;
    }

    public void setDeviationCategoryID(int deviationCategoryID) {
        this.deviationCategoryID = deviationCategoryID;
    }

    public DeviationCategory withDeviationCategoryID(int deviationCategoryID) {
        this.deviationCategoryID = deviationCategoryID;
        return this;
    }

}
