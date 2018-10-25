package net.maxproit.salesforce.model.search.guarantor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.model.myprospect.updateProspect.GuarantorsInfo;
import net.maxproit.salesforce.model.newprospect.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/29/2018.
 * heyrezwan@gmail.com
 */
public class SearchGuarantor {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private GuarantorsInfo data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public net.maxproit.salesforce.model.newprospect.GuarantorsInfo getData() {

        net.maxproit.salesforce.model.newprospect.GuarantorsInfo guarantorsInfo = new net.maxproit.salesforce.model.newprospect.GuarantorsInfo(
                data.getGuarantorIndexID(),
                data.getGuarantorName(),
                data.getFathersName(),
                data.getMothersName(),
                data.getSpouseName(),
                data.getPersonalnetWorth(),
                data.getNid(),
                data.getOwnership(),
                data.getContactId(),
                data.getMobilenumberID(),
                data.getMobilenumber(),
                data.getEmailid(),
                data.getEmail(),
                data.getFacebookid(),
                data.getFacebook(),
                data.getRelationShip(),
                data.getProfession(),
                data.getDob(),
                data.getGender(),
                data.getMaritalStatus()

        );

        if (data.getAddresses().size() > 0) {
            List<Address> adg = new ArrayList<>();

            for (net.maxproit.salesforce.model.myprospect.updateProspect.Address v : data.getAddresses()) {
                adg.add(new net.maxproit.salesforce.model.newprospect.Address(
                        v.getAddressID(),
                        v.getAddressType(),
                        v.getAppartmentNo(),
                        v.getArea(),
                        v.getCity(),
                        v.getFloor(),
                        v.getHoldingNumber(),
                        v.getHouseName(),
                        v.getNearestLandMark(),
                        v.getPremiseOwnershipStatus(),
                        v.getPs(),
                        v.getRoad(),
                        v.getVillage()

                ));

            }
            guarantorsInfo.setAddresses(adg);

        }


        return guarantorsInfo;
    }

    public void setData(GuarantorsInfo data) {
        this.data = data;
    }
}
