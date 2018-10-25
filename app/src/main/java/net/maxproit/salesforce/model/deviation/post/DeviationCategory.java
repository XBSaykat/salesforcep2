
package net.maxproit.salesforce.model.deviation.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviationCategory {

    @SerializedName("deviationCategoryID")
    @Expose
    private int deviationCategoryID;
    @SerializedName("deviationCategory")
    @Expose
    private String deviationCategory;


    public DeviationCategory() {
    }

    public DeviationCategory(int deviationCategoryID, String deviationCategory) {
        this.deviationCategoryID = deviationCategoryID;
        this.deviationCategory = deviationCategory;
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

}
