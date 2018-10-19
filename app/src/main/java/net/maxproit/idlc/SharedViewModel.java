package net.maxproit.idlc;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<String> selectedProductCategory = new MutableLiveData<String>();

    public void setProductCategory(String productCategory) {
        selectedProductCategory.setValue(productCategory);
    }

    public LiveData<String> getProductCategory() {
        return selectedProductCategory;
    }
}
