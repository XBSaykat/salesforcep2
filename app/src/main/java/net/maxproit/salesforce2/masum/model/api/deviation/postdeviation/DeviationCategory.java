package net.maxproit.salesforce2.masum.model.api.deviation.postdeviation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Mehedi Hasan on 12/11/2018.
 * mehedipy@gmail.com
 */
public class DeviationCategory {
    @SerializedName("deviationCategoryID")
    @Expose
    private Integer deviationCategoryID;
    @SerializedName("deviationCategory")
    @Expose
    private String deviationCategory;

    public Integer getDeviationCategoryID() {
        return deviationCategoryID;
    }

    public void setDeviationCategoryID(Integer deviationCategoryID) {
        this.deviationCategoryID = deviationCategoryID;
    }

    public String getDeviationCategory() {
        return deviationCategory;
    }

    public void setDeviationCategory(String deviationCategory) {
        this.deviationCategory = deviationCategory;
    }
}
