package net.maxproit.salesforce.masum.fragment.lead;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.NumberTextWatcher;
import net.maxproit.salesforce.NumberToWords;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.model.MyNewProspect;
import net.maxproit.salesforce.masum.model.VisitPlan;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.model.MyNewLead;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.utility.DateUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class LeadStageLoanDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    Calendar myCalendar = Calendar.getInstance();

    TextView tvTentativeNumberToWord;

    //TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<MyNewLead> myNewLeadArrayList;
    private MyLeadDbController myLeadDbController;
    private SpinnerDbController spinnerDbController;
    private ArrayAdapter<String> productSubAdapter;
    private List<String> listSourceReference = null;
    private List<String> listProductType = null;
    private List<String> listProductSubCategory = null;
    private List<String> listCarloan = null;
    private List<String> listHomeloan = null;
    private List<String> listPersonalloan = null;

    private AwesomeSpinner spinnerRef, spinnerProductType, spinnerSubCategory;
    public static EditText etLoadAmount, etFee, etInterest, etDisbursementDate;
    public static int ref = 0;
    public static String productType = null;
    public static String subCategory = null;

//    <item>Home Loan</item>
//    <item>Car Loan</item>
//    <item>Personal Loan</item>

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
        View rootView = null;
        rootView = inflater.inflate(R.layout.fragment_lead_stage_loan_detail, container, false);
        initVariable();
        initView(rootView);
        initListener();
        return rootView;
    }

    private void initVariable() {
        spinnerDbController = new SpinnerDbController(getActivity());
        listSourceReference = new ArrayList<String>();
        listProductType = new ArrayList<String>();
        listProductSubCategory = new ArrayList<String>();
        listCarloan = new ArrayList<String>();
        listHomeloan = new ArrayList<String>();
        listPersonalloan = new ArrayList<String>();
        listSourceReference.addAll(spinnerDbController.getSourceOfReferenceData());
        listProductType.addAll(spinnerDbController.getProductTypeData());
        listProductSubCategory.addAll(spinnerDbController.getProductSubcategoryData());
        listHomeloan.addAll(spinnerDbController.getHomeLoanData());
        listCarloan.addAll(spinnerDbController.getCarLoanData());
        listPersonalloan.addAll(spinnerDbController.getPersonalLoanData());
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
//                productType = i;
                productType = s;

                if (s.equals(AppConstant.HOME_LOAN)) {
//                    ArrayAdapter<CharSequence> productSubAdapter = ArrayAdapter.createFromResource(getContext(),
//                            R.array.hl_array, android.R.layout.simple_spinner_item);
//                    spinnerSubCategory.setAdapter(productSubAdapter, 0);
                    productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listHomeloan);
                    spinnerSubCategory.setAdapter(productSubAdapter);

                }
                if (s.equals(AppConstant.CAR_LOAN)) {
//                    ArrayAdapter<CharSequence> productSubAdapter = ArrayAdapter.createFromResource(getContext(),
//                            R.array.cl_array, android.R.layout.simple_spinner_item);
//                    spinnerSubCategory.setAdapter(productSubAdapter, 0);
                    productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listCarloan);
                    spinnerSubCategory.setAdapter(productSubAdapter);

                }
                if (s.equals(AppConstant.PERSONAL_LOAN)) {
//                    ArrayAdapter<CharSequence> productSubAdapter = ArrayAdapter.createFromResource(getContext(),
//                            R.array.pl_array, android.R.layout.simple_spinner_item);
//                    spinnerSubCategory.setAdapter(productSubAdapter, 0);
                    productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listPersonalloan);
                    spinnerSubCategory.setAdapter(productSubAdapter);

                }

            }
        });
        spinnerSubCategory.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                subCategory = s;
            }
        });


    }

    private void initView(View rootView) {


        etDisbursementDate = rootView.findViewById(R.id.et_disbursement_date);
        spinnerRef = rootView.findViewById(R.id.awe_spinner_lead_reference);
        spinnerProductType = rootView.findViewById(R.id.awe_spinner_lead_product_type);
        spinnerSubCategory = rootView.findViewById(R.id.awe_spinner_lead_product_sub_type);
        etLoadAmount = rootView.findViewById(R.id.et_load_amount);
        etInterest = rootView.findViewById(R.id.et_interest);
        etFee = rootView.findViewById(R.id.et_fee);
        etDisbursementDate.setText(DateUtils.getDateString());

        tvTentativeNumberToWord = (TextView) rootView.findViewById(R.id.tv_tentative_number_to_word);
        if (tvTentativeNumberToWord != null) {
            tvTentativeNumberToWord.setText("");
        }


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        etDisbursementDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                datePickerDialog(getContext());
            }
        });


        etLoadAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                etLoadAmount.removeTextChangedListener(this);
                try {

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etLoadAmount.setText(formattedString);
                    etLoadAmount.setSelection(etLoadAmount.getText().length());
                    tvTentativeNumberToWord.setText(formattedString.isEmpty() ? "" : NumberToWords.convert(longVal));
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                etLoadAmount.addTextChangedListener(this);
            }
        });

        etInterest.addTextChangedListener(new NumberTextWatcher(etInterest));
        etFee.addTextChangedListener(new NumberTextWatcher(etFee));
        initSpinnerAdapter();
    }

    public void datePickerDialog(Context context) {

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String selectedDate = (dayOfMonth + "." + month + "." + year);
                etDisbursementDate.getText().clear();
                etDisbursementDate.setText(selectedDate);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(context,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                listener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    private void updateLabel() {
        String myFormat = "dd-mm-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDisbursementDate.setText(sdf.format(myCalendar.getTime()));
    }

    private void initSpinnerAdapter() {
//        ArrayAdapter<CharSequence> refAdapter = ArrayAdapter.createFromResource(getContext(), R.array.source_of_reference_array, android.R.layout.simple_spinner_item);
//        spinnerRef.setAdapter(refAdapter, 0);

        ArrayAdapter<String> sourceReferenceAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listSourceReference);
        spinnerRef.setAdapter(sourceReferenceAdapter);

        ArrayAdapter<String> productTypeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listProductType);
        spinnerProductType.setAdapter(productTypeAdapter);

//        ArrayAdapter<CharSequence> productTypeAdapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.product_categories_array, android.R.layout.simple_spinner_item);
//        spinnerProductType.setAdapter(productTypeAdapter, 0);
        if (getArguments() != null) {
            int status = getArguments().getInt(AppConstant.STATUS_INTENT_KEY);

            if (status == 0) {
                VisitPlan visitPlan = (VisitPlan) getArguments().getSerializable(AppConstant.INTENT_KEY);
                if (visitPlan != null) {

                }
            } else {
                MyNewProspect myNewLead = (MyNewProspect) getArguments().getSerializable(AppConstant.INTENT_KEY);
                if (myNewLead != null) {
                    try {
                        spinnerRef.setSelection(sourceReferenceAdapter.getPosition(myNewLead.getLoanReq()));
                        spinnerProductType.setSelection(productTypeAdapter.getPosition(myNewLead.getProductType()));

                        if (myNewLead.getProductType().equals(AppConstant.HOME_LOAN)) {
                            productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listHomeloan);
                            spinnerSubCategory.setAdapter(productSubAdapter);
                        } else if (myNewLead.getProductType().equals(AppConstant.CAR_LOAN)) {
                            productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listCarloan);
                            spinnerSubCategory.setAdapter(productSubAdapter);

                        } else if (myNewLead.getProductType().equals(AppConstant.PERSONAL_LOAN)) {
                            productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listPersonalloan);
                            spinnerSubCategory.setAdapter(productSubAdapter);

                        }

                        spinnerSubCategory.setSelection(productSubAdapter.
                                getPosition(myNewLead.getProductSubcategory()));
                    } catch (final IllegalStateException ignored) {
                    } catch (NullPointerException e) {

                    }
                    etLoadAmount.setText(myNewLead.getLoadAmount());
                    etInterest.setText(myNewLead.getOrInterest());
                    etDisbursementDate.setText(myNewLead.getDisDate());
                    etFee.setText(myNewLead.getOpFee());
                }
            }
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

}
