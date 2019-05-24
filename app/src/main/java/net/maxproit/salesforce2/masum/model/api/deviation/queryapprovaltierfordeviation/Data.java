package net.maxproit.salesforce2.masum.model.api.deviation.queryapprovaltierfordeviation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Md. Mehedi Hasan on 12/11/2018.
 * mehedipy@gmail.com
 */
public class Data {
    @SerializedName("ApprovalTier")
    @Expose
    private String approvalTier;

    public String getApprovalTier() {
        return approvalTier;
    }

    public void setApprovalTier(String approvalTier) {
        this.approvalTier = approvalTier;
    }
}
