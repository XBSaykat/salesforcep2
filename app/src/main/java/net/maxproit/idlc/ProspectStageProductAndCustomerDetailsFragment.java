package net.maxproit.idlc;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.idlc.feature.salesOfficer.myProspect.ProspectStageActivity;
import net.maxproit.idlc.model.newlead.MyNewLead;

public class ProspectStageProductAndCustomerDetailsFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static ProspectStageActivity prospectStageActivity;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    Spinner productCategory;
//    Spinner productDetail;


    public AwesomeSpinner spinnerProductCat, spinnerProductDetail, spinnerBranchName, spinnerSegment, spinnerDistOfBirth,
            spinnerCountOfBirth, spinnerProfession, spinnerRelationship;

    public static EditText etName, etAge, etPhotoId, etPhotoIdDate, etETin, etFatherName, etMotherName,
                etSpouseName, etCompanyName, etDesignation, etNoYrsInCurrentJob, etPresentAddress,
                etPermanentAddress, etMobileNumber;

    public static String productCat, productDetails, branchName, segment, countOfBirth, districtOfBirth, profession,
            relationship, name, age, photoId, photoIdDate, eTin, fatherName, motherName, spouseName,
            companyName, designation, noYrsInCureentJob, presentAddress, permanentAddress,mobileNumber;


    private SharedViewModel model;

    private OnFragmentInteractionListener mListener;

    public ProspectStageProductAndCustomerDetailsFragment() {
        // Required empty public constructor
    }

    public static ProspectStageProductAndCustomerDetailsFragment newInstance(String param1, String param2) {
        ProspectStageProductAndCustomerDetailsFragment fragment = new ProspectStageProductAndCustomerDetailsFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
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

        View view = inflater.inflate(R.layout.fragment_prospect_stage_product_and_customer_details, container, false);
        prospectStageActivity= (ProspectStageActivity) getActivity();
//        productCategory = (Spinner) view.findViewById(R.id.spinner_product_category);
//        productDetail = (Spinner) view.findViewById(R.id.spinner_product_detail);

//        private EditText etName, etAge, etPhotoId, etPhotoIdDate, etETin, etFatherName, etMotherName,
//                etSpouseName, etCompanyName, etDesignation, etNoYrsInCurrentJob, etPresentAddress,
//                etPermanentAddress, etMobileNumber;


        etName = view.findViewById(R.id.input_name);
        etAge = view.findViewById(R.id.input_age);
        etPhotoId = view.findViewById(R.id.input_valid_photo_id_no);
        etPhotoIdDate = view.findViewById(R.id.input_valid_photo_id_issue_date);
        etETin = view.findViewById(R.id.input_etin);
        etFatherName = view.findViewById(R.id.input_father_name);
        etMotherName = view.findViewById(R.id.input_mother_name);
        etSpouseName = view.findViewById(R.id.input_spouse_name);
        etCompanyName = view.findViewById(R.id.input_company_name);
        etDesignation = view.findViewById(R.id.input_designation);
        etNoYrsInCurrentJob = view.findViewById(R.id.input_current_job_years);
        etPresentAddress = view.findViewById(R.id.input_present_address);
        etPermanentAddress = view.findViewById(R.id.input_permanent_address);
        etMobileNumber = view.findViewById(R.id.input_mobile_no);





        spinnerProductCat = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_product_category);
        spinnerProductDetail = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_product_detail);
        spinnerBranchName = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_branch);
        spinnerSegment = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_segment);
        spinnerDistOfBirth = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_district_of_birth);
        spinnerCountOfBirth = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_country_of_birth);
        spinnerProfession = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_profession);
        spinnerRelationship = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_relation_with_applicant);


        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        initAdapters();
        initListener();
        MyNewLead myNewLead=prospectStageActivity.getDataFromProspect();


//        productCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//
//                ArrayAdapter productDetailAdapter;
//                switch (adapterView.getItemAtPosition(i).toString()){
//                    case "HL" :
//                        productDetailAdapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.hl_array, android.R.layout.simple_spinner_item);
//                        model.setProductCategory("HL");
//                        break;
//                    case "CL":
//                        productDetailAdapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.cl_array, android.R.layout.simple_spinner_item);
//                        model.setProductCategory("CL");
//                        break;
//                    case "PL":
//                        productDetailAdapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.pl_array, android.R.layout.simple_spinner_item);
//                        model.setProductCategory("PL");
//                        break;
//                        default:
//                            productDetailAdapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.hl_array, android.R.layout.simple_spinner_item);
//                            model.setProductCategory("PL");
//                            break;
//                }
//
//                productDetail.setAdapter(productDetailAdapter);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
        // Inflate the layout for this fragment
        return view;
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

    public void initListener() {

        spinnerProductCat.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {

                productCat = s;

                if (s.equals("Home Loan")) {
                    ArrayAdapter<CharSequence> productDetailAdapter = ArrayAdapter.createFromResource(getContext(),
                            R.array.hl_array,
                            android.R.layout.simple_spinner_item);
                    spinnerProductDetail.setAdapter(productDetailAdapter, 0);


                } else if (s.equals("Car Loan")) {
                    ArrayAdapter<CharSequence> productDetailAdapter = ArrayAdapter.createFromResource(getContext(),
                            R.array.cl_array,
                            android.R.layout.simple_spinner_item);
                    spinnerProductDetail.setAdapter(productDetailAdapter, 0);


                } else if (s.equals("Personal Loan")) {
                    ArrayAdapter<CharSequence> productDetailAdapter = ArrayAdapter.createFromResource(getContext(),
                            R.array.pl_array,
                            android.R.layout.simple_spinner_item);
                    spinnerProductDetail.setAdapter(productDetailAdapter, 0);
                }
            }
        });



        spinnerProductDetail.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                productDetails = s;
            }
        });

        spinnerBranchName.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                branchName = s;
            }
        });

        spinnerSegment.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                segment = s;
            }
        });

        spinnerDistOfBirth.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                districtOfBirth = s;
            }
        });

        spinnerCountOfBirth.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                countOfBirth = s;
            }
        });



        spinnerProfession.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                profession = s;
            }
        });

        spinnerRelationship.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                relationship = s;
            }
        });


    }

    public void initAdapters() {


        ArrayAdapter<CharSequence> productCatAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.product_categories_array,
                android.R.layout.simple_spinner_item);
        spinnerProductCat.setAdapter(productCatAdapter, 0);


        ArrayAdapter<CharSequence> branchNameAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.branch_array,
                android.R.layout.simple_spinner_item);
        spinnerBranchName.setAdapter(branchNameAdapter, 0);


        ArrayAdapter<CharSequence> segmentAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.segment_array,
                android.R.layout.simple_spinner_item);
        spinnerSegment.setAdapter(segmentAdapter, 0);

        ArrayAdapter<CharSequence> distOfBirthAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.district_array,
                android.R.layout.simple_spinner_item);
        spinnerDistOfBirth.setAdapter(distOfBirthAdapter, 0);

        ArrayAdapter<CharSequence> countryOfBirthAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.countries,
                android.R.layout.simple_spinner_item);
        spinnerCountOfBirth.setAdapter(countryOfBirthAdapter, 0);

        ArrayAdapter<CharSequence> ProfessionAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.profession_array,
                android.R.layout.simple_spinner_item);
        spinnerProfession.setAdapter(ProfessionAdapter, 0);

        ArrayAdapter<CharSequence> relationshipAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.relationship_array,
                android.R.layout.simple_spinner_item);
        spinnerRelationship.setAdapter(relationshipAdapter, 0);


    }


}
