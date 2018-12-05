
package net.maxproit.salesforce.model.setting;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("PSes")
    @Expose
    private List<PSe> pSes = null;
    @SerializedName("addressTypes")
    @Expose
    private List<AddressType> addressTypes = null;
    @SerializedName("assetTypes")
    @Expose
    private List<AssetType> assetTypes = null;
    @SerializedName("booths")
    @Expose
    private List<Booth> booths = null;
    @SerializedName("branches")
    @Expose
    private List<Branch> branches = null;
    @SerializedName("businessTypes")
    @Expose
    private List<BusinessType> businessTypes = null;
    @SerializedName("cities")
    @Expose
    private List<City> cities = null;
    @SerializedName("deviationCategories")
    @Expose
    private List<DeviationCategory> deviationCategories = null;
    @SerializedName("deviationTypes")
    @Expose
    private List<DeviationType> deviationTypes = null;
    @SerializedName("industryTypes")
    @Expose
    private List<IndustryType> industryTypes = null;
    @SerializedName("legalStatusType")
    @Expose
    private List<LegalStatusType> legalStatusType = null;
    @SerializedName("orgOwnershipTypes")
    @Expose
    private List<OrgOwnershipType> orgOwnershipTypes = null;
    @SerializedName("premisesOwnershipTypes")
    @Expose
    private List<PremisesOwnershipType> premisesOwnershipTypes = null;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("propertyTypes")
    @Expose
    private List<PropertyType> propertyTypes = null;
    @SerializedName("realStateTypes")
    @Expose
    private List<RealStateType> realStateTypes = null;
    @SerializedName("relationshipTypesWithIDLC")
    @Expose
    private List<RelationshipTypesWithIDLC> relationshipTypesWithIDLC = null;
    @SerializedName("titles")
    @Expose
    private List<Title> titles = null;
    @SerializedName("version")
    @Expose
    private Object version;
    @SerializedName("visitPurposeType")
    @Expose
    private List<VisitPurposeType> visitPurposeType = null;

    @SerializedName("photoIdType")
    @Expose
    private List<PhotoIdType> photoIdType = null;

    @SerializedName("clientType")
    @Expose
    private List<ClientType> clientType = null;

    public List<ClientType> getClientType() {
        return clientType;
    }

    public void setClientType(List<ClientType> clientType) {
        this.clientType = clientType;
    }

    @SerializedName("profession")
    @Expose
    private List<Profession> profession = null;

    public List<Profession> getProfession() {
        return profession;
    }

    public void setProfession(List<Profession> profession) {
        this.profession = profession;
    }

    public List<PSe> getpSes() {
        return pSes;
    }

    public void setpSes(List<PSe> pSes) {
        this.pSes = pSes;
    }

    public List<PhotoIdType> getPhotoIdType() {
        return photoIdType;
    }

    public void setPhotoIdType(List<PhotoIdType> photoIdType) {
        this.photoIdType = photoIdType;
    }

    @SerializedName("productSubCategory")
    @Expose
    private List<ProductSubCategory> productSubCategory = null;

    public List<ProductSubCategory> getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(List<ProductSubCategory> productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    @SerializedName("sourceOfReference")
    @Expose
    private List<SourceOfReference> sourceOfReference = null;

    public List<SourceOfReference> getSourceOfReference() {
        return sourceOfReference;
    }

    public void setSourceOfReference(List<SourceOfReference> sourceOfReference) {
        this.sourceOfReference = sourceOfReference;
    }

    public List<PSe> getPSes() {
        return pSes;
    }

    public void setPSes(List<PSe> pSes) {
        this.pSes = pSes;
    }

    public List<AddressType> getAddressTypes() {
        return addressTypes;
    }

    public void setAddressTypes(List<AddressType> addressTypes) {
        this.addressTypes = addressTypes;
    }

    public List<AssetType> getAssetTypes() {
        return assetTypes;
    }

    public void setAssetTypes(List<AssetType> assetTypes) {
        this.assetTypes = assetTypes;
    }

    public List<Booth> getBooths() {
        return booths;
    }

    public void setBooths(List<Booth> booths) {
        this.booths = booths;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public List<BusinessType> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<BusinessType> businessTypes) {
        this.businessTypes = businessTypes;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<DeviationCategory> getDeviationCategories() {
        return deviationCategories;
    }

    public void setDeviationCategories(List<DeviationCategory> deviationCategories) {
        this.deviationCategories = deviationCategories;
    }

    public List<DeviationType> getDeviationTypes() {
        return deviationTypes;
    }

    public void setDeviationTypes(List<DeviationType> deviationTypes) {
        this.deviationTypes = deviationTypes;
    }

    public List<IndustryType> getIndustryTypes() {
        return industryTypes;
    }

    public void setIndustryTypes(List<IndustryType> industryTypes) {
        this.industryTypes = industryTypes;
    }

    public List<LegalStatusType> getLegalStatusType() {
        return legalStatusType;
    }

    public void setLegalStatusType(List<LegalStatusType> legalStatusType) {
        this.legalStatusType = legalStatusType;
    }

    public List<OrgOwnershipType> getOrgOwnershipTypes() {
        return orgOwnershipTypes;
    }

    public void setOrgOwnershipTypes(List<OrgOwnershipType> orgOwnershipTypes) {
        this.orgOwnershipTypes = orgOwnershipTypes;
    }

    public List<PremisesOwnershipType> getPremisesOwnershipTypes() {
        return premisesOwnershipTypes;
    }

    public void setPremisesOwnershipTypes(List<PremisesOwnershipType> premisesOwnershipTypes) {
        this.premisesOwnershipTypes = premisesOwnershipTypes;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<PropertyType> getPropertyTypes() {
        return propertyTypes;
    }

    public void setPropertyTypes(List<PropertyType> propertyTypes) {
        this.propertyTypes = propertyTypes;
    }

    public List<RealStateType> getRealStateTypes() {
        return realStateTypes;
    }

    public void setRealStateTypes(List<RealStateType> realStateTypes) {
        this.realStateTypes = realStateTypes;
    }

    public List<RelationshipTypesWithIDLC> getRelationshipTypesWithIDLC() {
        return relationshipTypesWithIDLC;
    }

    public void setRelationshipTypesWithIDLC(List<RelationshipTypesWithIDLC> relationshipTypesWithIDLC) {
        this.relationshipTypesWithIDLC = relationshipTypesWithIDLC;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public Object getVersion() {
        return version;
    }

    public void setVersion(Object version) {
        this.version = version;
    }

    public List<VisitPurposeType> getVisitPurposeType() {
        return visitPurposeType;
    }

    public void setVisitPurposeType(List<VisitPurposeType> visitPurposeType) {
        this.visitPurposeType = visitPurposeType;
    }

}
