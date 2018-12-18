package net.maxproit.salesforce.model.setting;

import android.content.Context;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;

public class LocalSetting {
    private Context context;

    public LocalSetting(Context context) {
        this.context = context;
    }

    private GlobalSettings getLocalSetting() {
        String setting = SharedPreferencesEnum.getInstance(context).getString(SharedPreferencesEnum.Key.SETTING);
        if (!setting.isEmpty()) {
            return new GsonBuilder().serializeNulls().create().fromJson(setting, GlobalSettings.class);
        } else
            return null;

    }

    public List<IndustryType> getIndType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getIndustryTypes();
        }
        return new ArrayList<>();

    }

    public List<String> getIndTypeStringList() {
        List<String> list = new ArrayList<>();
        for (IndustryType in : getIndType()) {
            list.add(in.getCategoryByProduct());
        }
        return list;

    }

    public List<SourceOfReference> getSourceOfRef() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getSourceOfReference();
        }
        return new ArrayList<>();

    }

    public List<String> getSourceOfRefString() {
        List<String> list = new ArrayList<>();
        for (SourceOfReference in : getSourceOfRef()) {
            list.add(in.getSourceOfReference());
        }
        return list;

    }


    public List<PremisesOwnershipType> getPurposeOfFinance() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getPremisesOwnershipTypes();
        }
        return new ArrayList<>();

    }


    public List<String> getPurposeOfFinanceStringList() {
        List<String> list = new ArrayList<>();
        for (PremisesOwnershipType in : getPurposeOfFinance()) {
            list.add(in.getPremisesOwnershipType());
        }
        return list;

    }

    public List<AssetType> getAsset() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getAssetTypes();
        }
        return new ArrayList<>();

    }

    public List<String> getAssetTypeStringList() {
        List<String> list = new ArrayList<>();
        for (AssetType in : getAsset()) {
            list.add(in.getAssetType());
        }
        return list;

    }


    public int getAssetCode(int position) {
        int code = 0;
        for (int i = 0; i < getAsset().size(); i++) {
            if (i == position) {
                code = getAsset().get(i).getAssetTypeCode();
                break;
            }
        }
        return code;
    }


    public List<ManufacturerName> getManufactureName() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getManufacturerNames();
        }
        return new ArrayList<>();

    }

    public List<String> getManufactureNameString() {
        List<String> list = new ArrayList<>();
        for (ManufacturerName in : getManufactureName()) {
            list.add(in.getManufacturerName());
        }
        return list;

    }


    public int getManuCode(int position) {
        int code = 0;
        for (int i = 0; i < getManufactureName().size(); i++) {
            if (i == position) {
                code = getManufactureName().get(i).getManufacturerNameId();
                break;
            }
        }
        return code;
    }


    public List<RealStateType> getRealStateType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getRealStateTypes();
        }
        return new ArrayList<>();

    }


    public List<String> getRealStateTypeString() {
        List<String> list = new ArrayList<>();
        for (RealStateType in : getRealStateType()) {
            list.add(in.getRealStateType());
        }
        return list;

    }

    public List<ClientType> getClientType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getClientType();
        }
        return new ArrayList<>();

    }


    public List<String> getClientTypeString() {
        List<String> list = new ArrayList<>();
        for (ClientType in : getClientType()) {
            list.add(in.getClientType());
        }
        return list;

    }


    public List<Segment> getSegment() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getSegments();
        }
        return new ArrayList<>();

    }


    public List<String> getSegmentString() {
        List<String> list = new ArrayList<>();
        for (Segment in : getSegment()) {
            list.add(in.getSegment());
        }
        return list;

    }


    public List<Country> getCountry() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getCountries();
        }
        return new ArrayList<>();

    }


    public List<String> getCountryString() {
        List<String> list = new ArrayList<>();
        for (Country in : getCountry()) {
            list.add(in.getCountry());
        }
        return list;

    }


    public List<PropertyType> getPropertyType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getPropertyTypes();
        }
        return new ArrayList<>();

    }


    public List<Product> getProductCategory() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getProducts();
        }
        return new ArrayList<>();

    }


    public List<String> getProductCategorystring() {
        List<String> list = new ArrayList<>();
        for (Product in : getProductCategory()) {
            list.add(in.getProductName());
        }
        return list;
    }


    public int getProductCode(int position) {
        int code = 0;
        for (int i = 0; i < getProductCategory().size(); i++) {
            if (i == position) {
                code = getProductCategory().get(i).getProductCode();
                break;
            }
        }
        return code;
    }


    public List<PhotoIdType> getPhotoIDType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getPhotoIdType();
        }
        return new ArrayList<>();

    }


    public List<String> getphotoIDTypestring() {
        List<String> list = new ArrayList<>();
        for (PhotoIdType in : getPhotoIDType()) {
            list.add(in.getIdentityType());
        }
        return list;
    }


    public int getPhotoIdCode(int position) {
        int code = 0;
        for (int i = 0; i < getPhotoIDType().size(); i++) {
            if (i == position) {
                code = getPhotoIDType().get(i).getIdentityTypeCode();
                break;
            }
        }
        return code;
    }

    public String getPhotoIdTypeStrByCode(int position) {
        String code = null;

        for (PhotoIdType in : getPhotoIDType()) {
            if (in.getIdentityTypeCode() == position) {
                code = in.getIdentityType();
                break;
            }


        }

        return code;
    }

    public List<ProductSubCategory> getProductSubCategory() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getProductSubCategory();
        }
        return new ArrayList<>();

    }


    public List<String> getProductSubCategorystring(int code) {
        List<String> list = new ArrayList<>();
        for (ProductSubCategory in : getProductSubCategory()) {
            if (in.getProductID() == code)
                list.add(in.getLoanPurposeType());
        }
        return list;
    }

    public int getSubCatCode(String data) {
        int code = 0;
        for (ProductSubCategory in : getProductSubCategory()) {
            if (in.getLoanPurposeType().equalsIgnoreCase(data)) {
                code = in.getLoanPurposeTypeCode();
                break;
            }
        }
        return code;
    }


    public List<Branch> getBranch() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getBranches();
        }
        return new ArrayList<>();

    }


    public List<String> getBranchString() {
        List<String> list = new ArrayList<>();
        for (Branch in : getBranch()) {
            list.add(in.getBranch());
        }
        return list;

    }

    public String getBranchCodeByName(String branchName) {
        String code = null;
        for (Branch in : getBranch()) {

            if (in.getBranch().equalsIgnoreCase(branchName)) {
                code = in.getBranchCode();
                break;
            }
        }
        return code;
    }

    public String getBranchCode(int position) {
        String code = null;
        for (int i = 0; i < getBranch().size(); i++) {
            if (i == position) {
                code = getBranch().get(i).getBranchCode();
                break;
            }
        }
        return code;
    }

//    Title list

    public List<Profession> professionObj() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getProfession();
        }
        return new ArrayList<>();

    }


    public List<String> getProfessionString() {
        List<String> list = new ArrayList<>();
        for (Profession in : professionObj()) {
            list.add(in.getProfessionType());
        }
        return list;

    }


    public List<Title> getAllTitleObj() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getTitles();
        }
        return new ArrayList<>();

    }

    public List<String> getAllTitle() {
        List<String> list = new ArrayList<>();
        for (Title in : getAllTitleObj()) {
            list.add(in.getTitleName());
        }
        return list;

    }


    public List<RelationshipTypes> getIdlcRelationType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getRelationshipTypes();
        }
        return new ArrayList<>();

    }

    public List<String> getIdlcRelationTypeStringList() {
        List<String> list = new ArrayList<>();
        for (RelationshipTypes in : getIdlcRelationType()) {
            list.add(in.getRelationshipType());
        }
        return list;
    }


    public List<NetSalaryType> getnetSalaryType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getNetSalaryTypes();
        }
        return new ArrayList<>();

    }

    public List<String> getnetSalaryTypeStringList() {
        List<String> list = new ArrayList<>();
        for (NetSalaryType in : getnetSalaryType()) {
            list.add(in.getNetSalaryType());
        }
        return list;
    }


    public List<City> getCity() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getCities();
        }
        return new ArrayList<>();

    }


    public List<String> getCityStringList() {
        List<String> list = new ArrayList<>();
        for (City in : getCity()) {
            list.add(in.getCity());
        }
        return list;

    }

    public List<String> getpsListByCityCode(String position) {
        int code = 0;
        List<String> list = new ArrayList<>();
        for (City in : getCity()) {
            if (in.getCity().equalsIgnoreCase(position)) {
                code = in.getCityID();
                list.addAll(getPseStringList(code));
                break;
            }
        }
        return list;
    }

    public List<String> getpsListByCityCode(int position) {
        int code = 0;
        List<String> list = new ArrayList<>();
        for (City in : getCity()) {
            if (code == position) {
                code = in.getCityID();
                list.addAll(getPseStringList(code));
                break;
            }
        }
        return list;
    }


    public List<PSe> getPse() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getPSes();
        }
        return new ArrayList<>();

    }

    public List<String> getPseStringList(int cityCode) {
        List<String> list = new ArrayList<>();
        for (PSe in : getPse()) {
            if (in.getCityID() == cityCode)
                list.add(in.getPS());
        }
        return list;

    }

    public List<String> getPseStringList() {
        List<String> list = new ArrayList<>();
        for (PSe in : getPse()) {
            list.add(in.getPS());
        }
        return list;

    }


    public List<BusinessType> getBusinessType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getBusinessTypes();
        }
        return new ArrayList<>();

    }


    public List<VisitPurposeType> getVisitPurposeType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getVisitPurposeType();
        }
        return new ArrayList<>();

    }


    public List<String> getVisitPurposeTypeStringList() {
        List<String> list = new ArrayList<>();
        for (VisitPurposeType in : getVisitPurposeType()) {
            list.add(in.getVisitPurposeType());
        }
        return list;

    }


    public List<DeviationCategory> getDeviationCategory() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getDeviationCategories();
        }
        return new ArrayList<>();

    }

    public List<LstDeviationJustification> getLstDeviationJustification() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getLstDeviationJustifications();
        }
        return new ArrayList<>();

    }

    public List<LegalStatusType> getLegalStatusType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getLegalStatusType();
        }
        return new ArrayList<>();

    }


    public List<String> getLegalStatusTypeStringList() {
        List<String> list = new ArrayList<>();
        for (LegalStatusType in : getLegalStatusType()) {
            list.add(in.getLegalStatusTypeName());
        }
        return list;

    }


    public List<OrgOwnershipType> getOrgOwnershipType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getOrgOwnershipTypes();
        }
        return new ArrayList<>();

    }


    public List<String> getOrgOwnershipTypeStringList() {
        List<String> list = new ArrayList<>();
        for (OrgOwnershipType in : getOrgOwnershipType()) {
            list.add(in.getOrgOwnershipType());
        }
        return list;

    }

    public int getCityCode(int position) {
        int code = 0;
        for (int i = 0; i < getCity().size(); i++) {
            if (i == position) {
                code = getCity().get(i).getCityID();
                break;
            }
        }
        return code;
    }


}
