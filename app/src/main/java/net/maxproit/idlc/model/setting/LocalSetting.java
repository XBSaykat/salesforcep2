package net.maxproit.idlc.model.setting;

import android.content.Context;

import com.google.gson.GsonBuilder;

import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/21/18.
 * heyRezwan@gmail.com
 */
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

    public List<AddressType> getAddressType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getAddressTypes();
        }
        return new ArrayList<>();

    }

    public List<String> getAddressTypeStringList() {
        List<String> list = new ArrayList<>();
        for (AddressType in : getAddressType()) {
            list.add(in.getAddressType());
        }
        return list;

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



    public List<PropertyType> getPropertyType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getPropertyTypes();
        }
        return new ArrayList<>();

    }



    public List<Product> getPropertyCategory() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getProducts();
        }
        return new ArrayList<>();

    }


    public List<String> getPropertyCategoryString() {
        List<String> list = new ArrayList<>();
        for (Product in : getPropertyCategory()) {
            list.add(in.getProductName());
        }
        return list;

    }

//    Title list

    public List<Profession> ProfessionObj() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getProfession();
        }
        return new ArrayList<>();

    }


    public List<String> Profession() {
        List<String> list = new ArrayList<>();
        for (Profession in : ProfessionObj()) {
            list.add(in.getOccupationTypeName());
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


    public List<RelationshipTypesWithIDLC> getIdlcRelationType() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getRelationshipTypesWithIDLC();
        }
        return new ArrayList<>();

    }

    public List<String> getIdlcRelationTypeStringList() {
        List<String> list = new ArrayList<>();
        for (RelationshipTypesWithIDLC in : getIdlcRelationType()) {
            list.add(in.getRelationshipType());
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



    public List<PSe> getPse() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getPSes();
        }
        return new ArrayList<>();

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
            list.add(in.getActivityType());
        }
        return list;

    }


    public List<DeviationCategory> getDeviationCategory() {
        if (getLocalSetting() != null) {
            return getLocalSetting().getData().getDeviationCategories();
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
}
