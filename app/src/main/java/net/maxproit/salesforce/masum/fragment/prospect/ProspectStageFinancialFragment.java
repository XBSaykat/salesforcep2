package net.maxproit.salesforce.masum.fragment.prospect;

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

import net.maxproit.salesforce.NumberToWords;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.SharedViewModel;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.model.MyNewLead;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.model.MyNewProspect;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ProspectStageFinancialFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static ProspectStageActivity prospectStageActivity;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private SpinnerDbController spinnerDbController;

    private List<String> listMonthlySalary=null;
    private List<String> listMonthlyRentalSalary=null;

    public static EditText etMonthlySalaryAmount, etMonthlyBusinessIncome,
                    etAgriculturalIncome, etPracticeConsultancyTuition, etRemittance, etInterestIncome,
                    etMonthlyFamilyExpenditure, etEMIOfOtherLoans, etApartmentIncomeAmount, etSemipakaIncome,
                    etOfficeSpaceIncome, etWarehouseIncome;
    AwesomeSpinner spinnerMonthlyNetSalary, spinnerRentalIncome;
    public static String monthlyNetSalary, rentalIncome;
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

        listMonthlySalary = new ArrayList<String>();
        listMonthlyRentalSalary = new ArrayList<String>();

        listMonthlySalary.addAll(spinnerDbController.getMonthlySalaryData());
        listMonthlyRentalSalary.addAll(spinnerDbController.getMonthlyRentalIncomeData());

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_prospect_stage_financial, container, false);
        prospectStageActivity= (ProspectStageActivity) getActivity();

        etMonthlySalaryAmount = view.findViewById(R.id.input_monthly_net_salary_amount);
        etMonthlyBusinessIncome = view.findViewById(R.id.input_monthly_business_income);
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
        initListener();


        if (prospectStageActivity.getDataFromProspect()!=null){

            MyNewProspect myNewLead=prospectStageActivity.getDataFromProspect();

//            etMonthlySalaryAmount.setText(myNewLead.get);
//            etPresentAddress.setText(myNewLead.getAddress());
//            etDesignation.setText(myNewLead.getDesignation());
//            etMobileNumber.setText(myNewLead.getPhone());
//            etPresentAddress.setText(myNewLead.getAddress());
        }

        commaSeparator();

        return view;
    }

    private void initListener() {

        spinnerMonthlyNetSalary.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                monthlyNetSalary = s;
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

        ArrayAdapter<String> monthlySalary=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listMonthlySalary);
        spinnerMonthlyNetSalary.setAdapter(monthlySalary);
//        ArrayAdapter<CharSequence> monthlyNetSalaryAdapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.monthly_net_salary_array,
//                android.R.layout.simple_spinner_item);
//        spinnerMonthlyNetSalary.setAdapter(monthlyNetSalaryAdapter, 0);


//        ArrayAdapter<String> rentalIncome=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listMonthlyRentalSalary);
//        spinnerRentalIncome.setAdapter(rentalIncome);

//        ArrayAdapter<CharSequence> monthlyRentalIncomeAdapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.monthly_rental_income,
//                android.R.layout.simple_spinner_item);
//        spinnerRentalIncome.setAdapter(monthlyRentalIncomeAdapter, 0);


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

    public void commaSeparator(){
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etMonthlySalaryAmount.setText(formattedString);
                    etMonthlySalaryAmount.setSelection(etMonthlySalaryAmount.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etMonthlyBusinessIncome.setText(formattedString);
                    etMonthlyBusinessIncome.setSelection(etMonthlyBusinessIncome.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etApartmentIncomeAmount.setText(formattedString);
                    etApartmentIncomeAmount.setSelection(etApartmentIncomeAmount.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etSemipakaIncome.setText(formattedString);
                    etSemipakaIncome.setSelection(etSemipakaIncome.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etOfficeSpaceIncome.setText(formattedString);
                    etOfficeSpaceIncome.setSelection(etOfficeSpaceIncome.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etWarehouseIncome.setText(formattedString);
                    etWarehouseIncome.setSelection(etWarehouseIncome.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etAgriculturalIncome.setText(formattedString);
                    etAgriculturalIncome.setSelection(etAgriculturalIncome.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etPracticeConsultancyTuition.setText(formattedString);
                    etPracticeConsultancyTuition.setSelection(etPracticeConsultancyTuition.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etRemittance.setText(formattedString);
                    etRemittance.setSelection(etRemittance.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etInterestIncome.setText(formattedString);
                    etInterestIncome.setSelection(etInterestIncome.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etMonthlyFamilyExpenditure.setText(formattedString);
                    etMonthlyFamilyExpenditure.setSelection(etMonthlyFamilyExpenditure.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etEMIOfOtherLoans.setText(formattedString);
                    etEMIOfOtherLoans.setSelection(etEMIOfOtherLoans.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
                etEMIOfOtherLoans.addTextChangedListener(this);
            }
        });
    }

}
