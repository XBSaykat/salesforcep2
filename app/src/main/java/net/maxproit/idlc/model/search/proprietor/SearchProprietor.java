package net.maxproit.idlc.model.search.proprietor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.idlc.model.myprospect.updateProspect.ProprietorsInfo;
import net.maxproit.idlc.model.newprospect.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/29/2018.
 * heyrezwan@gmail.com
 */
public class SearchProprietor {

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
    private ProprietorsInfo data;

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

    public net.maxproit.idlc.model.newprospect.ProprietorsInfo getData() {

        net.maxproit.idlc.model.newprospect.ProprietorsInfo proprietorsInfo = new net.maxproit.idlc.model.newprospect.ProprietorsInfo(
                data.getProprietorIndexID(),
                data.getOwnershipType(),
                data.getProprietorName(),
                data.getFathersName(),
                data.getMothersName(),
                data.getSpouseName(),
                String.valueOf(data.getPersonalnetWorth()),
                data.getNid(),
                data.getOwnership(),
                data.getOrgownershipID(),
                data.getContactId(),
                data.getMobilenumberID(),
                data.getMobilenumber(),
                data.getEmailid(),
                String.valueOf(data.getEmail()),
                data.getFacebookid(),
                String.valueOf(data.getFacebook()),
                String.valueOf(data.getRelationShip()),
                data.getProfession(),
                data.getDob(),
                data.getGender(),
                data.getMaritalStatus()
        );

        if (data.getAddresses().size() > 0) {
            List<Address> adprop = new ArrayList<>();

            for (net.maxproit.idlc.model.myprospect.updateProspect.Address v : data.getAddresses()) {
                adprop.add(new net.maxproit.idlc.model.newprospect.Address(
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
                        v.getVillage()));


            }
            proprietorsInfo.setAddresses(adprop);

        }


        if (data.getPersonalAssets().size() > 0) {
            List<net.maxproit.idlc.model.newprospect.PersonalAssets> personalAssets = new ArrayList<>();

            for (net.maxproit.idlc.model.myprospect.updateProspect.PersonalAssets v : data.getPersonalAssets()) {
                personalAssets.add(new net.maxproit.idlc.model.newprospect.PersonalAssets(
                        v.getRealStateID(),
                        v.getTypec(),
                        v.getPropertytypec(),
                        v.getPropertySize(),
                        v.getTotal(),
                        v.getLocationNTenureofOwnership()));


            }
            proprietorsInfo.setPersonalAssets(personalAssets);

        }


        return proprietorsInfo;
    }

    public void setData(ProprietorsInfo data) {
        this.data = data;
    }
}
