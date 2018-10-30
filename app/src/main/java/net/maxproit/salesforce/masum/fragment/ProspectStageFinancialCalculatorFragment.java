package net.maxproit.salesforce.masum.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.maxproit.salesforce.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProspectStageFinancialCalculatorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProspectStageFinancialCalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProspectStageFinancialCalculatorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static EditText etCalculatedGrossIncome;
    public static Button btnCalculate;

    private OnFragmentInteractionListener mListener;

    public ProspectStageFinancialCalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProspectStageFinancialCalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProspectStageFinancialCalculatorFragment newInstance(String param1, String param2) {
        ProspectStageFinancialCalculatorFragment fragment = new ProspectStageFinancialCalculatorFragment();
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
        View view = inflater.inflate(R.layout.fragment_prospect_stage_financial_calculator,
                container, false);
        etCalculatedGrossIncome = view.findViewById(R.id.et_prospect_stage_calculated_gross_income);
        btnCalculate = view.findViewById(R.id.btn_prospect_stage_financial_calculator);

        initListener();

        return view;
    }

    private void initListener() {

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                financialCalculate();


            }

            private void financialCalculate() {

                int monthlySalary, monthlyRentalIncome, monthlyBusinessIncome, agriculturalIncome, monthlyExpanse;


                if (ProspectStageFinancialFragment
                        .etMonthlySalaryAmount != null &&
                        ProspectStageFinancialFragment
                                .etMonthlyBusinessIncome != null &&
                        ProspectStageFinancialFragment
                                .etMonthlyRentalAmount != null &&
                        ProspectStageFinancialFragment
                                .etAgriculturalIncome != null &&
                        ProspectStageFinancialFragment
                                .etMonthlyFamilyExpenditure != null){



                    if(ProspectStageFinancialFragment
                            .etMonthlySalaryAmount.getText().toString().equals("")){
                        monthlySalary = 0;
                    }else{
                        monthlySalary = Integer.valueOf(ProspectStageFinancialFragment
                                .etMonthlySalaryAmount.getText().toString());
                    }

                    if(ProspectStageFinancialFragment
                            .etMonthlyBusinessIncome.getText().toString().equals("")){
                        monthlyBusinessIncome = 0;
                    }else{
                        monthlyBusinessIncome = Integer.valueOf(ProspectStageFinancialFragment
                                .etMonthlyBusinessIncome.getText().toString());
                    }


                    if(ProspectStageFinancialFragment
                            .etAgriculturalIncome.getText().toString().equals("")){
                        agriculturalIncome = 0;
                    }else{
                        agriculturalIncome = Integer.valueOf(ProspectStageFinancialFragment
                                .etAgriculturalIncome.getText().toString());
                    }

                    if(ProspectStageFinancialFragment
                            .etMonthlyRentalAmount.getText().toString().equals("")){
                        monthlyRentalIncome = 0;
                    }else{
                        monthlyRentalIncome = Integer.valueOf(ProspectStageFinancialFragment
                                .etMonthlyRentalAmount.getText().toString());
                    }

                    if(ProspectStageFinancialFragment
                            .etMonthlyFamilyExpenditure.getText().toString().equals("")){
                        monthlyExpanse = 0;
                    }else{
                        monthlyExpanse = Integer.valueOf(ProspectStageFinancialFragment
                                .etMonthlyFamilyExpenditure.getText().toString());
                    }

//                    int monthlyBusinessIncome = Integer.valueOf(ProspectStageFinancialFragment
//                            .etMonthlyBusinessIncome.getText().toString());
//                    int monthlyRentalIncome = Integer.valueOf(ProspectStageFinancialFragment
//                            .etMonthlyRentalAmount.getText().toString());
//                    int agriculturalIncome = Integer.valueOf(ProspectStageFinancialFragment
//                            .etAgriculturalIncome.getText().toString());
//                    int monthlyExpanse = Integer.valueOf(ProspectStageFinancialFragment
//                            .etMonthlyFamilyExpenditure.getText().toString());


                    int calculatedMonthlySavings = (monthlySalary +
                            monthlyBusinessIncome +
                            monthlyRentalIncome +
                            agriculturalIncome) - monthlyExpanse;

                    etCalculatedGrossIncome.setText(String.valueOf(calculatedMonthlySavings));
                }else{
                    Toast.makeText(getActivity(), "Fields empty", Toast.LENGTH_SHORT).show();

                }









            }
        });

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
