package net.maxproit.salesforce.model.deviation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 7/8/18.
 * heyRezwan@gmail.com
 */
public class Deviation {


    @SerializedName("DeviationSetID")
    @Expose
    private int deviationSetID;
    @SerializedName("MakerName")
    @Expose
    private Object makerName;
    @SerializedName("ProspectReferenceNo")
    @Expose
    private Object prospectReferenceNo;
    @SerializedName("Remark")
    @Expose
    private Object remark;
    @SerializedName("deviationDetails")
    @Expose
    private List<Object> deviationDetails = null;

    public int getDeviationSetID() {
        return deviationSetID;
    }

    public void setDeviationSetID(int deviationSetID) {
        this.deviationSetID = deviationSetID;
    }

    public Object getMakerName() {
        return makerName;
    }

    public void setMakerName(Object makerName) {
        this.makerName = makerName;
    }

    public Object getProspectReferenceNo() {
        return prospectReferenceNo;
    }

    public void setProspectReferenceNo(Object prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public List<Object> getDeviationDetails() {
        return deviationDetails;
    }

    public void setDeviationDetails(List<Object> deviationDetails) {
        this.deviationDetails = deviationDetails;
    }
}
