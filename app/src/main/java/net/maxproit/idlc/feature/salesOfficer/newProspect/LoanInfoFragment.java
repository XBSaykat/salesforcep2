package net.maxproit.idlc.feature.salesOfficer.newProspect;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.FragmentLoanInfoBinding;
import net.maxproit.idlc.model.newprospect.LoanInfo;
import net.maxproit.idlc.model.setting.LocalSetting;
import net.maxproit.idlc.network.RestClient;
import net.maxproit.idlc.util.CommonUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoanInfoFragment extends BaseFragment {
    LocalSetting localSetting;
    FragmentLoanInfoBinding binding;
    ArrayAdapter<String> purFinAdapter;
    ArrayAdapter<String> productCategoryAdapter;

    NewProspectActivity activity;
    private Context context;
    ProgressDialog progressDialog;
    LoanInfo loanInfo;
    private static final String TAG = "LoanInfoFragment";

    public static LoanInfoFragment newInstance() {
        Bundle args = new Bundle();
        LoanInfoFragment fragment = new LoanInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_loan_info;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        activity = (NewProspectActivity) getActivity();
        localSetting = new LocalSetting(context);
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");


    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentLoanInfoBinding) getBinding();

        loanInfo = activity.getNewProspect().getLoanInfo();
        binding.setModel(loanInfo);


        cleanInstallment(binding.etProposedLoanAmount);
        cleanInstallment(binding.etTermInMonths);
        cleanInstallment(binding.etInterestRate);


        titleView();


        binding.ld.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {

                    if (!StringUtils.isEmpty(binding.etInstalmentAmount.getText().toString())) {
                        String in = binding.etInstalmentAmount.getText().toString();
                        in = in.replace(",","");
                        String l =binding.getModel().getNoOfEMI();
                        l =l.replace(",","");
                        Log.d(TAG, "onTextChanged: "+in +"gggg"+l);
                        binding.loadDeposite.setText("" + Double.parseDouble(in) * Double.parseDouble(l));
                    }

                }catch (Exception e){
                    Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
                }





            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.etInterestRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CommonUtil.editTextPercentCalculation(binding.etInterestRate);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        TextWatcher inAmountWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (
                        !StringUtils.isEmpty(binding.etProposedLoanAmount.getText().toString()) &&
                                !StringUtils.isEmpty(binding.etTermInMonths.getText().toString()) &&
                                !StringUtils.isEmpty(binding.etInterestRate.getText().toString())) {


                    double inAmount = CommonUtil.emiCalculator(
                            Double.parseDouble(binding.etInterestRate.getText().toString()),
                            Double.parseDouble(binding.etTermInMonths.getText().toString()),
                            Double.parseDouble(binding.etProposedLoanAmount.getText().toString()));

                    binding.etInstalmentAmount.setText("" + inAmount);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        binding.etProposedLoanAmount.addTextChangedListener(inAmountWatcher);
        binding.etTermInMonths.addTextChangedListener(inAmountWatcher);
        binding.etInterestRate.addTextChangedListener(inAmountWatcher);

        binding.etInstalmentAmount.setOnClickListener(v -> {

            if (
                    !binding.getModel().getInterestrate().equals("0") &&
                            !binding.getModel().getTemInMonths().equals("0") &&
                            !binding.getModel().getLoanAmount().equals("0")) {

                progressDialog.show();
                RestClient.getInstance().callRetrofit().getInstalmentAmount(binding.getModel().getInterestrate(), binding.getModel().getTemInMonths(), binding.getModel().getLoanAmount()).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        progressDialog.cancel();
                        if (response.isSuccessful()) {
                            binding.etInstalmentAmount.setText(response.body());
                        }

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        progressDialog.cancel();

                    }
                });

            }


        });


        if (!loanInfo.getPurposeOfFinancing().isEmpty()) {

            //"Fixed Asset", "Working Capital"

            if (loanInfo.getPurposeOfFinancing().equals("Fixed Asset")) {
                binding.spPurFin.setSelection(1);
            }else if (loanInfo.getPurposeOfFinancing().equals("Working Capital")) {
               binding.spPurFin.setSelection(2);
            }

           // binding.spPurFin.setSelection(localSetting.getPurposeOfFinanceStringList().lastIndexOf(activity.getNewProspect().getLoanInfo().getPurposeOfFinancing()));
        }


        activity.getNewProspect().setLoanInfo(binding.getModel());
        activity.disableEnableControls(!activity.isApproval(), binding.basicInfoLead);
        CommonUtil.numberToWord(binding.etProposedLoanAmount, binding.tvProposedLoanAmount);


        //  purFinAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getPurposeOfFinanceStringList());
        purFinAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, Arrays.asList("Fixed Asset", "Working Capital"));
        binding.spPurFin.setAdapter(purFinAdapter);
        binding.spPurFin.setOnSpinnerItemClickListener((i, s) -> loanInfo.setPurposeOfFinancing(s));

        productCategoryAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getPropertyCategoryString());
        binding.spProductCategory.setAdapter(productCategoryAdapter);
        binding.spProductCategory.setOnSpinnerItemClickListener((i, s) ->loanInfo.setProductCategory(s));


        if (!StringUtils.isEmpty(loanInfo.getProductCategory())) {
            if (CommonUtil.isListItemAvailable(CommonUtil.getListPosition(localSetting.getPropertyCategoryString(),loanInfo.getProductCategory()))) {
                binding.spProductCategory.setSelection(CommonUtil.getListPosition(localSetting.getPropertyCategoryString(),loanInfo.getProductCategory()));
            }
        }






    }

    private void titleView() {

    }

    private void cleanInstallment(EditText e) {
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                binding.etInstalmentAmount.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


}
