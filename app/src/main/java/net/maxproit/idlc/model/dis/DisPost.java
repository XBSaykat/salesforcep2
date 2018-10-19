package net.maxproit.idlc.model.dis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rezwan Khan Chowdhury on 10/3/2018.
 * heyrezwan@gmail.com
 */
public class DisPost {
    @SerializedName("prospectReferenceNo")
    @Expose
    private String prospectReferenceNo;
    @SerializedName("disbursement")
    @Expose
    private Disbursement disbursement;

    public String getProspectReferenceNo() {
        return prospectReferenceNo;
    }

    public void setProspectReferenceNo(String prospectReferenceNo) {
        this.prospectReferenceNo = prospectReferenceNo;
    }

    public Disbursement getDisbursement() {
        return disbursement;
    }

    public void setDisbursement(Disbursement disbursement) {
        this.disbursement = disbursement;
    }
}
