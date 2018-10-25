package net.maxproit.salesforce;

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


public class LeadStageLoanDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AwesomeSpinner spinnerRef,spinnerProductType,spinnerSubCategory;
    public static EditText etLoadAmount,etFee,etInterest;
    public static int ref=0,subCategory=0,productType=0;

    private OnFragmentInteractionListener mListener;

    public LeadStageLoanDetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LeadStageLoanDetailFragment newInstance(String param1, String param2) {
        LeadStageLoanDetailFragment fragment = new LeadStageLoanDetailFragment();
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
        //Inflate the layout for this fragment
        View rootView=null;
        rootView=inflater.inflate(R.layout.fragment_lead_stage_loan_detail, container, false);
        initView(rootView);
        initListener();
        return rootView;
    }

    private void initListener() {

        spinnerRef.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                ref = i;
            }
        });
        spinnerProductType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                productType = i;
            }
        });
        spinnerSubCategory.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                subCategory = i;
            }
        });
//        spinnerRef.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                ref= position;
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        spinnerSubCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                subCategory=position;
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        spinnerProductType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                productType= position;
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    }

    private void initView(View rootView) {
        spinnerRef=rootView.findViewById(R.id.awe_spinner_lead_reference);
        spinnerProductType=rootView.findViewById(R.id.awe_spinner_lead_product_type);
        spinnerSubCategory=rootView.findViewById(R.id.awe_spinner_lead_product_sub_type);
        etLoadAmount=rootView.findViewById(R.id.et_load_amount);
        etInterest=rootView.findViewById(R.id.et_interest);
        etFee=rootView.findViewById(R.id.et_fee);

        initSpinnerAdapter();
    }

    private void initSpinnerAdapter() {
        ArrayAdapter<CharSequence> refAdapter = ArrayAdapter.createFromResource(getContext(), R.array.source_of_reference_array, android.R.layout.simple_spinner_item);
        spinnerRef.setAdapter(refAdapter, 0);

        ArrayAdapter<CharSequence> productTypeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.product_type_array, android.R.layout.simple_spinner_item);
        spinnerProductType.setAdapter(productTypeAdapter, 0);

        ArrayAdapter<CharSequence> productSubAdapter = ArrayAdapter.createFromResource(getContext(), R.array.product_categories_array, android.R.layout.simple_spinner_item);
        spinnerSubCategory.setAdapter(productSubAdapter, 0);
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
