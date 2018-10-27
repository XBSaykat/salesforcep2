package net.maxproit.salesforce.model.virifier;

public class CreditInformation {
    GeneralInfo generalInfo;
    EmployeesInfo employeesInfo;
    VisitRecord visitRecord;
    ImageUpload imageUpload;


    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public EmployeesInfo getEmployeesInfo() {
        return employeesInfo;
    }

    public void setEmployeesInfo(EmployeesInfo employeesInfo) {
        this.employeesInfo = employeesInfo;
    }

    public VisitRecord getVisitRecord() {
        return visitRecord;
    }

    public void setVisitRecord(VisitRecord visitRecord) {
        this.visitRecord = visitRecord;
    }

    public ImageUpload getImageUpload() {
        return imageUpload;
    }

    public void setImageUpload(ImageUpload imageUpload) {
        this.imageUpload = imageUpload;
    }
}
