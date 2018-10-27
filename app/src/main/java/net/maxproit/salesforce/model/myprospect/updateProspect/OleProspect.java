
package net.maxproit.salesforce.model.myprospect.updateProspect;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.maxproit.salesforce.model.newlead.VisitRecord;
import net.maxproit.salesforce.model.newprospect.GeneralInfo;
import net.maxproit.salesforce.model.newprospect.GuarantorsInfo;
import net.maxproit.salesforce.model.newprospect.LoanInfo;
import net.maxproit.salesforce.model.newprospect.NewProspect;
import net.maxproit.salesforce.model.newprospect.ProprietorsInfo;
import net.maxproit.salesforce.model.newprospect.Verification;

import java.util.ArrayList;
import java.util.List;

public class OleProspect {
    private static final String TAG = "OleProspect";

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
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OleProspect withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OleProspect withCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OleProspect withMessage(String message) {
        this.message = message;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public OleProspect withData(Data data) {
        this.data = data;
        return this;
    }

    public NewProspect getNewProspect() {
        NewProspect newProspect = new NewProspect();
        newProspect.setBranch(getData().getBranch());
        newProspect.setCif(getData().getCif());
        newProspect.setClientName(getData().getClientName());
        newProspect.setProduct(getData().getProduct());


        GeneralInfo generalInfo = new GeneralInfo(
                getData().getGeneralInfo().getLoanPurposeTypeCode(),
                getData().getGeneralInfo().getIndustryType(),
                getData().getGeneralInfo().getRelationShip(),
                getData().getGeneralInfo().getNatureOfBusiness(),
                getData().getGeneralInfo().getApplicantMobile(),
                getData().getGeneralInfo().getLegalStatus(),
                getData().getGeneralInfo().getTinNumber(),
                getData().getGeneralInfo().getTradeLicenseNumber(),
                getData().getGeneralInfo().getLicenseIssuedate(),
                getData().getGeneralInfo().getLicenseExpiredate(),
                getData().getGeneralInfo().getCommencementDate(),
                String.valueOf(getData().getGeneralInfo().getIncorporationNumber()),
                String.valueOf(getData().getGeneralInfo().getBusinessSince())
        );
        newProspect.setGeneralInfo(generalInfo);
        Log.d(TAG, "getNewProspect: " + getData().getGeneralInfo().getLicenseIssuedate());

        Verification verification = new Verification(
                getData().getVerification().getMenEmployees(),
                getData().getVerification().getWomenEmployees(),
                getData().getVerification().getFullTimeEmployees(),
                getData().getVerification().getPartTimeEmployees(),
                getData().getVerification().getForcastedIncrease(),
                getData().getVerification().getForcastedDecrease(),
                true,
                getData().getVerification().getSucceedTo()
        );
        newProspect.setVerification(verification);

        LoanInfo loanInfo = new LoanInfo(
                getData().getLoanInfo().getLoanAmount(),
                getData().getLoanInfo().getTemInMonths(),
                getData().getLoanInfo().getFinancing(),
                getData().getLoanInfo().getCashsecurity(),
                getData().getLoanInfo().getCashsecurityrate(),
                getData().getLoanInfo().getNoOfEMI(),
                getData().getLoanInfo().getLoadDeposite(),
                getData().getLoanInfo().getInterestrate(),
                getData().getLoanInfo().getInstalmentAmount(),
                getData().getLoanInfo().getPurposeOfFinancingCode(),
                getData().getLoanInfo().getPurposeOfFinancing(),
                getData().getLoanInfo().getProductCategoryID(),
                getData().getLoanInfo().getProductCategory(),
                getData().getLoanInfo().getInventory(),
                getData().getLoanInfo().getYearlySales()
        );
        newProspect.setLoanInfo(loanInfo);


        List<GuarantorsInfo> gfList = new ArrayList<>();

        for (net.maxproit.salesforce.model.myprospect.updateProspect.GuarantorsInfo gf : getData().getGuarantorsInfo()) {
            GuarantorsInfo guarantorsInfo = new GuarantorsInfo(
                    gf.getGuarantorIndexID(),
                    gf.getGuarantorName(),
                    gf.getFathersName(),
                    gf.getMothersName(),
                    gf.getSpouseName(),
                    gf.getPersonalnetWorth(),
                    gf.getNid(),
                    gf.getOwnership(),
                    gf.getContactId(),
                    gf.getMobilenumberID(),
                    gf.getMobilenumber(),
                    gf.getEmailid(),
                    gf.getEmail(),
                    gf.getFacebookid(),
                    gf.getFacebook(),
                    gf.getRelationShip(),
                    gf.getProfession(),
                    gf.getDob(),
                    gf.getGender(),
                    gf.getMaritalStatus());
            guarantorsInfo.setGuarantorTitle(gf.getGuarantorTitle());
            guarantorsInfo.setFathersTitle(gf.getFathersTitle());
            guarantorsInfo.setMothersTitle(gf.getMothersTitle());
            guarantorsInfo.setSpouseTitle(gf.getSpouseTitle());

            if (gf.getAddresses().size() > 0) {
                List<net.maxproit.salesforce.model.newprospect.Address> adg = new ArrayList<>();

                for (net.maxproit.salesforce.model.myprospect.updateProspect.Address v : getData().getGuarantorsInfo().get(0).getAddresses()) {
                    adg.add(new net.maxproit.salesforce.model.newprospect.Address(
                            v.getAddressID(),
                            v.getAddressType(),
                            v.getArea(),
                            v.getVillage(),
                            v.getHouseName(),
                            v.getAppartmentNo(),
                            v.getFloor(),
                            v.getHoldingNumber(),
                            v.getRoad(),
                            v.getPs(),
                            v.getPremiseOwnershipStatus(),
                            v.getNearestLandMark(),
                            v.getCity()

                    ));

                }
                guarantorsInfo.setAddresses(adg);

            }

            gfList.add(guarantorsInfo);
        }

        newProspect.setGuarantorsInfo(gfList);


        List<ProprietorsInfo> proprietorsInfoList = new ArrayList<>();
        for (net.maxproit.salesforce.model.myprospect.updateProspect.ProprietorsInfo preof : getData().getProprietorsInfo()) {

            ProprietorsInfo proprietorsInfo = new ProprietorsInfo(
                    preof.getProprietorIndexID(),
                    preof.getOwnershipType(),
                    preof.getProprietorName(),
                    preof.getFathersName(),
                    preof.getMothersName(),
                    preof.getSpouseName(),
                    String.valueOf(preof.getPersonalnetWorth()),
                    preof.getNid(),
                    preof.getOwnership(),
                    preof.getOrgownershipID(),
                    preof.getContactId(),
                    preof.getMobilenumberID(),
                    preof.getMobilenumber(),
                    preof.getEmailid(),
                    String.valueOf(preof.getEmail()),
                    preof.getFacebookid(),
                    String.valueOf(preof.getFacebook()),
                    String.valueOf(preof.getRelationShip()),
                    preof.getProfession(),
                    preof.getDob(),
                    preof.getGender(),
                    preof.getMaritalStatus());
            proprietorsInfo.setProprietorTitle(preof.getProprietorTitle());
            proprietorsInfo.setFathersTitle(preof.getFathersTitle());
            proprietorsInfo.setMothersTitle(preof.getMothersTitle());
            proprietorsInfo.setSpouseTitle(preof.getSpouseTitle());

            if (preof.getAddresses().size() > 0) {
                List<net.maxproit.salesforce.model.newprospect.Address> adprop = new ArrayList<>();

                for (net.maxproit.salesforce.model.myprospect.updateProspect.Address v : preof.getAddresses()) {
                    adprop.add(new net.maxproit.salesforce.model.newprospect.Address(
                            v.getAddressID(),
                            v.getAddressType(),
                            v.getArea(),
                            v.getVillage(),
                            v.getHouseName(),
                            v.getAppartmentNo(),
                            v.getFloor(),
                            v.getHoldingNumber(),
                            v.getRoad(),
                            v.getPs(),
                            v.getPremiseOwnershipStatus(),
                            v.getNearestLandMark(),
                            v.getCity()
                    ));


                }
                proprietorsInfo.setAddresses(adprop);

            }


            if (preof.getPersonalAssets().size() > 0) {
                List<net.maxproit.salesforce.model.newprospect.PersonalAssets> personalAssets = new ArrayList<>();

                for (net.maxproit.salesforce.model.myprospect.updateProspect.PersonalAssets v : preof.getPersonalAssets()) {
                    personalAssets.add(new net.maxproit.salesforce.model.newprospect.PersonalAssets(
                            v.getRealStateID(),
                            v.getTypec(),
                            v.getPropertytypec(),
                            v.getPropertySize(),
                            v.getTotal(),
                            v.getLocationNTenureofOwnership()));


                }
                proprietorsInfo.setPersonalAssets(personalAssets);

            }


            proprietorsInfoList.add(proprietorsInfo);

        }

        //
        newProspect.setProprietorsInfo(proprietorsInfoList);


        List<VisitRecord> visitRecords = new ArrayList<>();
        for (net.maxproit.salesforce.model.myprospect.updateProspect.VisitRecord v : getData().getVisitRecords()) {
            visitRecords.add(new VisitRecord(
                    v.getActivityID(),
                    v.getVisitPurpose(),
                    v.getRemarks(),
                    v.getMeetingDate(),
                    v.getFollowupDate()));

        }
        newProspect.setVisitRecords(visitRecords);


        List<net.maxproit.salesforce.model.newprospect.Address> prospectAddress = new ArrayList<>();
        if (getData().getProspectAddresses().size() > 0) {
            for (net.maxproit.salesforce.model.myprospect.updateProspect.ProspectAddress v : getData().getProspectAddresses()) {
                prospectAddress.add(new net.maxproit.salesforce.model.newprospect.Address(
                        v.getAddressID(),
                        v.getAddressType(),
                        v.getArea(),
                        v.getVillage(),
                        v.getAppartmentNo(),
                        v.getFloor(),
                        v.getHoldingNumber(),
                        v.getHouseName(),
                        v.getRoad(),
                        v.getPs(),
                        v.getPremiseOwnershipStatus(),
                        v.getNearestLandMark(),
                        v.getCity()

                ));

            }

        }
        newProspect.setProspectAddresses(prospectAddress);


        return newProspect;

    }
}
