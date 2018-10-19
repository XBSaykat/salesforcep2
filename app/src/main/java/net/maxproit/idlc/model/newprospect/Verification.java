
package net.maxproit.idlc.model.newprospect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Verification {

    @SerializedName("menEmployees")
    @Expose
    private int menEmployees;
    @SerializedName("womenEmployees")
    @Expose
    private int womenEmployees;
    @SerializedName("fullTimeEmployees")
    @Expose
    private int fullTimeEmployees;
    @SerializedName("partTimeEmployees")
    @Expose
    private int partTimeEmployees;
    @SerializedName("forcastedIncrease")
    @Expose
    private int forcastedIncrease;
    @SerializedName("forcastedDecrease")
    @Expose
    private int forcastedDecrease;
    @SerializedName("succession")
    @Expose
    private boolean succession;
    @SerializedName("succeedTo")
    @Expose
    private String succeedTo = "";

    public Verification() {
    }

    public Verification(int menEmployees, int womenEmployees, int fullTimeEmployees, int partTimeEmployees, int forcastedIncrease, int forcastedDecrease, boolean succession, String succeedTo) {
        this.menEmployees = menEmployees;
        this.womenEmployees = womenEmployees;
        this.fullTimeEmployees = fullTimeEmployees;
        this.partTimeEmployees = partTimeEmployees;
        this.forcastedIncrease = forcastedIncrease;
        this.forcastedDecrease = forcastedDecrease;
        this.succession = succession;
        this.succeedTo = succeedTo;
    }

    public String getMenEmployees() {
        return Integer.toString(menEmployees);
    }

    public void setMenEmployees(String menEmployees) {
        this.menEmployees = stringToInt(menEmployees);
    }

    public Verification withMenEmployees(int menEmployees) {
        this.menEmployees = menEmployees;
        return this;
    }

    public String getWomenEmployees() {
        return Integer.toString(womenEmployees);
    }

    public void setWomenEmployees(String womenEmployees) {
        this.womenEmployees = stringToInt(womenEmployees);
    }

    public Verification withWomenEmployees(String womenEmployees) {
        this.womenEmployees = stringToInt(womenEmployees);
        return this;
    }

    public String getFullTimeEmployees() {
        return Integer.toString(fullTimeEmployees);
    }

    public void setFullTimeEmployees(String fullTimeEmployees) {
        this.fullTimeEmployees = stringToInt(fullTimeEmployees);
    }

    public Verification withFullTimeEmployees(int fullTimeEmployees) {
        this.fullTimeEmployees = fullTimeEmployees;
        return this;
    }

    public String getPartTimeEmployees() {
        return Integer.toString(partTimeEmployees);
    }

    public void setPartTimeEmployees(String partTimeEmployees) {
        this.partTimeEmployees = stringToInt(partTimeEmployees);
    }

    public Verification withPartTimeEmployees(String partTimeEmployees) {
        this.partTimeEmployees = stringToInt(partTimeEmployees);
        return this;
    }

    public String getForcastedIncrease() {
        return Integer.toString(forcastedIncrease);
    }

    public void setForcastedIncrease(String forcastedIncrease) {
        this.forcastedIncrease = stringToInt(forcastedIncrease);
    }

    public Verification withForcastedIncrease(String forcastedIncrease) {
        this.forcastedIncrease = stringToInt(forcastedIncrease);
        return this;
    }

    public String getForcastedDecrease() {
        return Integer.toString(forcastedDecrease);
    }

    public void setForcastedDecrease(String forcastedDecrease) {
        this.forcastedDecrease = stringToInt(forcastedDecrease);
    }

    public Verification withForcastedDecrease(String forcastedDecrease) {
        this.forcastedDecrease = stringToInt(forcastedDecrease);
        return this;
    }

    public boolean isSuccession() {
        return succession;
    }

    public void setSuccession(boolean succession) {
        this.succession = succession;
    }

    public Verification withSuccession(boolean succession) {
        this.succession = succession;
        return this;
    }

    public String getSucceedTo() {
        return succeedTo;
    }

    public void setSucceedTo(String succeedTo) {
        this.succeedTo = succeedTo;
    }

    public Verification withSucceedTo(String succeedTo) {
        this.succeedTo = succeedTo;
        return this;
    }

    public int stringToInt(String inventory) {
        try {
            return Integer.parseInt(inventory);

        } catch (NumberFormatException ex) {
            return 0;
        }


    }

}
