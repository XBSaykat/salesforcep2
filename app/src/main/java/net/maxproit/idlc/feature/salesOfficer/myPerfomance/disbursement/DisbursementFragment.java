package net.maxproit.idlc.feature.salesOfficer.myPerfomance.disbursement;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.FragmentBasicInfoBinding;
import net.maxproit.idlc.databinding.FragmentDisbursementBinding;
import net.maxproit.idlc.util.CommonUtil;

import java.util.Calendar;

/**
 * Created by Rezwan Khan Chowdhury on 8/6/2018.
 * heyrezwan@gmail.com
 */
public class DisbursementFragment extends BaseFragment {
    FragmentDisbursementBinding binding;

    public static DisbursementFragment newInstance() {
        Bundle args = new Bundle();
        DisbursementFragment fragment = new DisbursementFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_disbursement;
    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentDisbursementBinding) getBinding();
        binding.btnAdd.setOnClickListener(v -> {
            addDis();
        });

    }

    private void addDis() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dis_row, null);
        dialogBuilder.setView(dialogView);

        EditText date = (EditText) dialogView.findViewById(R.id.et1);
        EditText amount = (EditText) dialogView.findViewById(R.id.etAmount);
        EditText cif = (EditText) dialogView.findViewById(R.id.etCif);
        EditText name = (EditText) dialogView.findViewById(R.id.etName);
        EditText note = (EditText) dialogView.findViewById(R.id.etNote);
        TextView submit = (EditText) dialogView.findViewById(R.id.submit);

      //  date.setOnClickListener(v -> CommonUtil.showDatePicker(getContext(), date, Calendar.getInstance()));

        submit.setOnClickListener(v -> {

        });
      //  editText.setText("test label");
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setTitle("Disbursement");
        alertDialog.show();
    }
}
