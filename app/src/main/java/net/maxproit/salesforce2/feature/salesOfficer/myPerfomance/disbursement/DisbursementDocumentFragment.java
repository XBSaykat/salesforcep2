package net.maxproit.salesforce2.feature.salesOfficer.myPerfomance.disbursement;

import android.content.Context;
import android.os.Bundle;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseFragment;

/**
 * Created by Rezwan Khan Chowdhury on 8/6/2018.
 * heyrezwan@gmail.com
 */
public class DisbursementDocumentFragment extends BaseFragment {


    public static DisbursementDocumentFragment newInstance() {
        Bundle args = new Bundle();
        DisbursementDocumentFragment fragment = new DisbursementDocumentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_disbursement_document;
    }

    @Override
    protected void initFragmentComponents() {

    }
}
