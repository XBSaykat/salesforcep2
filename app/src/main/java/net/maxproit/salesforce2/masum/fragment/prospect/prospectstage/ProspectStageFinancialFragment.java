package net.maxproit.salesforce2.masum.fragment.prospect.prospectstage;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.SharedViewModel;
import net.maxproit.salesforce2.masum.appdata.AppConstant;
import net.maxproit.salesforce2.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce2.masum.model.local.MyNewProspect;
import net.maxproit.salesforce2.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce2.model.setting.LocalSetting;

import java.util.ArrayList;
import java.util.List;


public class ProspectStageFinancialFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private LocalSetting localSetting;
    private SpinnerDbController spinnerDbController;

    private List<String> listMonthlySalary = null;
    private List<String> listMonthlyRentalSalary = null;

    public static EditText etMonthlySalaryAmount, etMonthlyBusinessIncome, etMonthlyWarehouseAmount,
            etMonthlyOfficeSpaceAmount, etMonthlySemipakaAmount, etMonthlyApartmentAmount,
            etAgriculturalIncome, etPracticeConsultancyTuition, etRemittance, etInterestIncome,
            etMonthlyFamilyExpenditure, etEMIOfOtherLoans, etApartmentIncomeAmount, etSemipakaIncome,
            etOfficeSpaceIncome, etWarehouseIncome;
    AwesomeSpinner spinnerMonthlyNetSalary;
    public static String monthlyNetSalaryType, rentalIncome;
    private SharedViewModel model;

    public ProspectStageFinancialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProspectStageFinancialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProspectStageFinancialFragment newInstance(String param1, String param2) {
        ProspectStageFinancialFragment fragment = new ProspectStageFinancialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        spinnerDbController = new SpinnerDbController(getActivity());
        localSetting = new LocalSetting(getActivity());
        listMonthlySalary = new ArrayList<String>();
        listMonthlyRentalSalary = new ArrayList<String>();

        listMonthlySalary.addAll(spinnerDbController.getMonthlySalaryData());
        listMonthlyRentalSalary.addAll(spinnerDbController.getMonthlyRentalIncomeData());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prospect_stage_financial, container, false);


        etMonthlySalaryAmount = view.findViewById(R.id.input_monthly_net_salary_amount);
        etMonthlyBusinessIncome = view.findViewById(R.id.input_monthly_business_income);
        etMonthlyWarehouseAmount = view.findViewById(R.id.input_warehouse_income_amount);
        etMonthlyOfficeSpaceAmount = view.findViewById(R.id.input_office_space_income_amount);
        etMonthlySemipakaAmount = view.findViewById(R.id.input_semipaka_income_amount);
        etMonthlyApartmentAmount = view.findViewById(R.id.input_apartment_income_amount);
//
        etAgriculturalIncome = view.findViewById(R.id.input_agricultural_income);
        etPracticeConsultancyTuition = view.findViewById(R.id.input_practice_consultancy_tution);
        etRemittance = view.findViewById(R.id.input_remittance);
        etInterestIncome = view.findViewById(R.id.input_interest_income);
        etMonthlyFamilyExpenditure = view.findViewById(R.id.input_total_monthly_family_expenditure);
        etEMIOfOtherLoans = view.findViewById(R.id.input_emi_of_other_loans);
        etApartmentIncomeAmount = view.findViewById(R.id.input_apartment_income_amount);
        etSemipakaIncome = view.findViewById(R.id.input_semipaka_income_amount);
        etOfficeSpaceIncome = view.findViewById(R.id.input_office_space_income_amount);
        etWarehouseIncome = view.findViewById(R.id.input_warehouse_income_amount);


        spinnerMonthlyNetSalary = view.findViewById(R.id.awe_spinner_prospect_stage_monthly_net_salary);
        // spinnerRentalIncome = view.findViewById(R.id.awe_spinner_prospect_stage_monthly_rental_income);

        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        initAdapters();



        commaSeparator();

        return view;
    }

    private void initListener() {

        spinnerMonthlyNetSalary.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                monthlyNetSalaryType = s;
            }
        });

//        spinnerRentalIncome.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
//            @Override
//            public void onItemSelected(int i, String s) {
//                rentalIncome = s;
//            }
//        });
    }

    private void initAdapters() {

        ArrayAdapter<String> monthlySalaryAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getnetSalaryTypeStringList());
        spinnerMonthlyNetSalary.setAdapter(monthlySalaryAdapter);
        initListener();

        if (getArguments() != null) {

            MyNewProspect myNewLead = (MyNewProspect) getArguments().getSerializable(AppConstant.INTENT_KEY);
            if (!MasumCommonUtils.isNullStr(myNewLead.getNetSalary())) {
                try {
                    spinnerMonthlyNetSalary.setSelection(monthlySalaryAdapter.getPosition(myNewLead.getNetSalary()));
                } catch (final IllegalStateException ignored) {
                }
            }

            MasumCommonUtils.commaSeperator(etMonthlySalaryAmount,myNewLead.getSalaryAmount());

            //etMonthlySalaryAmount.setText(myNewLead.getSalaryAmount());
            MasumCommonUtils.commaSeperator(etMonthlyBusinessIncome,myNewLead.getBusinessIncomeAmount());
            MasumCommonUtils.commaSeperator(etApartmentIncomeAmount,myNewLead.getApartmentAmount());
            MasumCommonUtils.commaSeperator(etSemipakaIncome,myNewLead.getSemipakaIncome());
            MasumCommonUtils.commaSeperator(etOfficeSpaceIncome,myNewLead.getOfficeSpaceINcome());
            MasumCommonUtils.commaSeperator(etWarehouseIncome,myNewLead.getWireHouseINcome());
            MasumCommonUtils.commaSeperator(etAgriculturalIncome,myNewLead.getAg_Income());
            MasumCommonUtils.commaSeperator(etPracticeConsultancyTuition,myNewLead.getTution());
            MasumCommonUtils.commaSeperator(etRemittance,myNewLead.getRemitance());
            MasumCommonUtils.commaSeperator(etInterestIncome,myNewLead.getInFdr());
            MasumCommonUtils.commaSeperator(etMonthlyFamilyExpenditure,myNewLead.getfExpense());
            MasumCommonUtils.commaSeperator(etEMIOfOtherLoans,myNewLead.getEmiOther());
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void commaSeparator() {
        etMonthlySalaryAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etMonthlySalaryAmount.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etMonthlySalaryAmount,editable.toString());

                etMonthlySalaryAmount.addTextChangedListener(this);
            }
        });

        etMonthlyBusinessIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etMonthlyBusinessIncome.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etMonthlyBusinessIncome,editable.toString());

                etMonthlyBusinessIncome.addTextChangedListener(this);
            }
        });

        etApartmentIncomeAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etApartmentIncomeAmount.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etApartmentIncomeAmount,editable.toString());
                etApartmentIncomeAmount.addTextChangedListener(this);
            }
        });

        etSemipakaIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etSemipakaIncome.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etSemipakaIncome,editable.toString());
                etSemipakaIncome.addTextChangedListener(this);
            }
        });

        etOfficeSpaceIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etOfficeSpaceIncome.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etOfficeSpaceIncome,editable.toString());

                etOfficeSpaceIncome.addTextChangedListener(this);
            }
        });

        etWarehouseIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etWarehouseIncome.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etWarehouseIncome,editable.toString());

                etWarehouseIncome.addTextChangedListener(this);
            }
        });

        etAgriculturalIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etAgriculturalIncome.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etAgriculturalIncome,editable.toString());
                etAgriculturalIncome.addTextChangedListener(this);
            }
        });

        etPracticeConsultancyTuition.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etPracticeConsultancyTuition.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etPracticeConsultancyTuition,editable.toString());
                etPracticeConsultancyTuition.addTextChangedListener(this);
            }
        });

        etRemittance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etRemittance.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etRemittance,editable.toString());

                etRemittance.addTextChangedListener(this);
            }
        });

        etInterestIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etInterestIncome.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etInterestIncome,editable.toString());

                etInterestIncome.addTextChangedListener(this);
            }
        });

        etMonthlyFamilyExpenditure.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etMonthlyFamilyExpenditure.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etMonthlyFamilyExpenditure,editable.toString());

                etMonthlyFamilyExpenditure.addTextChangedListener(this);
            }
        });

        etEMIOfOtherLoans.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etEMIOfOtherLoans.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etEMIOfOtherLoans,editable.toString());

                etEMIOfOtherLoans.addTextChangedListener(this);
            }
        });
    }

}
