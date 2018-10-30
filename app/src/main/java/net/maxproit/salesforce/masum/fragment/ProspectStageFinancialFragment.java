package net.maxproit.salesforce.masum.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.SharedViewModel;
import net.maxproit.salesforce.feature.salesOfficer.myProspect.ProspectStageActivity;
import net.maxproit.salesforce.masum.model.MyNewLead;


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

    public static EditText etMonthlySalaryAmount, etMonthlyBusinessIncome,etMonthlyRentalAmount,
                    etAgriculturalIncome, etPracticeConsultancyTuition, etRemittance, etInterestIncome,
                    etMonthlyFamilyExpenditure, etEMIOfOtherLoans;
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
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_prospect_stage_financial, container, false);
        prospectStageActivity= (ProspectStageActivity) getActivity();

        etMonthlySalaryAmount = view.findViewById(R.id.input_monthly_net_salary_amount);
        etMonthlyBusinessIncome = view.findViewById(R.id.input_monthly_business_income);
        etMonthlyRentalAmount = view.findViewById(R.id.input_monthly_rental_income_amount);
        etAgriculturalIncome = view.findViewById(R.id.input_agricultural_income);
        etPracticeConsultancyTuition = view.findViewById(R.id.input_practice_consultancy_tution);
        etRemittance = view.findViewById(R.id.input_remittance);
        etInterestIncome = view.findViewById(R.id.input_interest_income);
        etMonthlyFamilyExpenditure = view.findViewById(R.id.input_total_monthly_family_expenditure);
        etEMIOfOtherLoans = view.findViewById(R.id.input_emi_of_other_loans);


        spinnerMonthlyNetSalary = view.findViewById(R.id.awe_spinner_prospect_stage_monthly_net_salary);
        spinnerRentalIncome = view.findViewById(R.id.awe_spinner_prospect_stage_monthly_rental_income);

        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        initAdapters();
        initListener();


        if (prospectStageActivity.getDataFromProspect()!=null){

            MyNewLead myNewLead=prospectStageActivity.getDataFromProspect();

//            etMonthlySalaryAmount.setText(myNewLead.get);
//            etPresentAddress.setText(myNewLead.getAddress());
//            etDesignation.setText(myNewLead.getDesignation());
//            etMobileNumber.setText(myNewLead.getPhone());
//            etPresentAddress.setText(myNewLead.getAddress());
        }

        return view;
    }

    private void initListener() {

        spinnerMonthlyNetSalary.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                monthlyNetSalary = s;
            }
        });

        spinnerRentalIncome.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                rentalIncome = s;
            }
        });
    }

    private void initAdapters() {
        ArrayAdapter<CharSequence> monthlyNetSalaryAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.monthly_net_salary_array,
                android.R.layout.simple_spinner_item);
        spinnerMonthlyNetSalary.setAdapter(monthlyNetSalaryAdapter, 0);

        ArrayAdapter<CharSequence> monthlyRentalIncomeAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.monthly_rental_income,
                android.R.layout.simple_spinner_item);
        spinnerRentalIncome.setAdapter(monthlyRentalIncomeAdapter, 0);


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
}
