package net.maxproit.salesforce2.masum.model.local;

import java.io.Serializable;

public class MyPerformanceModel implements Serializable {

    private String title,value;

    public MyPerformanceModel(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
