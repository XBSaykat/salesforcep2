package net.maxproit.salesforce.masum.model;

public class CarLoan {
    private int id,leadId;
    private String brandName,menuYear,menuCountry,vehicleType;

    public CarLoan(int id, int leadId, String brandName, String menuYear, String menuCountry, String vehicleType) {
        this.id = id;
        this.leadId = leadId;
        this.brandName = brandName;
        this.menuYear = menuYear;
        this.menuCountry = menuCountry;
        this.vehicleType = vehicleType;
    }

    public CarLoan(int leadId, String brandName, String menuYear, String menuCountry, String vehicleType) {
        this.leadId = leadId;
        this.brandName = brandName;
        this.menuYear = menuYear;
        this.menuCountry = menuCountry;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public int getLeadId() {
        return leadId;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getMenuYear() {
        return menuYear;
    }

    public String getMenuCountry() {
        return menuCountry;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
