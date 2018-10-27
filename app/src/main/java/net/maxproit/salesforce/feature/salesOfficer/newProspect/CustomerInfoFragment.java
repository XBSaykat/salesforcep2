package net.maxproit.salesforce.feature.salesOfficer.newProspect;

import android.content.Context;
import android.os.Bundle;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseFragment;
import net.maxproit.salesforce.databinding.FragmentCustomerInfoBinding;


public class CustomerInfoFragment extends BaseFragment {

    FragmentCustomerInfoBinding binding;
    NewProspectActivity activity;

    public static CustomerInfoFragment newInstance() {
        Bundle args = new Bundle();
        CustomerInfoFragment fragment = new CustomerInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_customer_info;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (NewProspectActivity) getActivity();
    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentCustomerInfoBinding) getBinding();
        // binding.setModel(activity.getNewProspect().getCustomerInfo());

    }


}
