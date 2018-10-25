
package net.maxproit.salesforce.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndustryType {

    @SerializedName("BusinessType")
    @Expose
    private String categoryByProduct;
    @SerializedName("BusinessTypeID")
    @Expose
    private int categoryByProductCode;

    public String getCategoryByProduct() {
        return categoryByProduct;
    }

    public void setCategoryByProduct(String categoryByProduct) {
        this.categoryByProduct = categoryByProduct;
    }

    public IndustryType withCategoryByProduct(String categoryByProduct) {
        this.categoryByProduct = categoryByProduct;
        return this;
    }

    public int getCategoryByProductCode() {
        return categoryByProductCode;
    }

    public void setCategoryByProductCode(int categoryByProductCode) {
        this.categoryByProductCode = categoryByProductCode;
    }

    public IndustryType withCategoryByProductCode(int categoryByProductCode) {
        this.categoryByProductCode = categoryByProductCode;
        return this;
    }

}
