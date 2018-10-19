
package net.maxproit.idlc.model.myprospect.updateProspect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Verification {

    @SerializedName("forcastedDecrease")
    @Expose
    private int forcastedDecrease;
    @SerializedName("forcastedIncrease")
    @Expose
    private int forcastedIncrease;
    @SerializedName("fullTimeEmployees")
    @Expose
    private int fullTimeEmployees;
    @SerializedName("menEmployees")
    @Expose
    private int menEmployees;
    @SerializedName("partTimeEmployees")
    @Expose
    private int partTimeEmployees;
    @SerializedName("succeedTo")
    @Expose
    private String succeedTo;
    @SerializedName("succession")
    @Expose
    private boolean succession;
    @SerializedName("womenEmployees")
    @Expose
    private int womenEmployees;

    public int getForcastedDecrease() {
        return forcastedDecrease;
    }

    public void setForcastedDecrease(int forcastedDecrease) {
        this.forcastedDecrease = forcastedDecrease;
    }

    public Verification withForcastedDecrease(int forcastedDecrease) {
        this.forcastedDecrease = forcastedDecrease;
        return this;
    }

    public int getForcastedIncrease() {
        return forcastedIncrease;
    }

    public void setForcastedIncrease(int forcastedIncrease) {
        this.forcastedIncrease = forcastedIncrease;
    }

    public Verification withForcastedIncrease(int forcastedIncrease) {
        this.forcastedIncrease = forcastedIncrease;
        return this;
    }

    public int getFullTimeEmployees() {
        return fullTimeEmployees;
    }

    public void setFullTimeEmployees(int fullTimeEmployees) {
        this.fullTimeEmployees = fullTimeEmployees;
    }

    public Verification withFullTimeEmployees(int fullTimeEmployees) {
        this.fullTimeEmployees = fullTimeEmployees;
        return this;
    }

    public int getMenEmployees() {
        return menEmployees;
    }

    public void setMenEmployees(int menEmployees) {
        this.menEmployees = menEmployees;
    }

    public Verification withMenEmployees(int menEmployees) {
        this.menEmployees = menEmployees;
        return this;
    }

    public int getPartTimeEmployees() {
        return partTimeEmployees;
    }

    public void setPartTimeEmployees(int partTimeEmployees) {
        this.partTimeEmployees = partTimeEmployees;
    }

    public Verification withPartTimeEmployees(int partTimeEmployees) {
        this.partTimeEmployees = partTimeEmployees;
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

    public int getWomenEmployees() {
        return womenEmployees;
    }

    public void setWomenEmployees(int womenEmployees) {
        this.womenEmployees = womenEmployees;
    }

    public Verification withWomenEmployees(int womenEmployees) {
        this.womenEmployees = womenEmployees;
        return this;
    }

}
