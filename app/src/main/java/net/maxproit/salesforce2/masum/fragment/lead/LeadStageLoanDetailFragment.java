package net.maxproit.salesforce2.masum.fragment.lead;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce2.NumberTextWatcher;
import net.maxproit.salesforce2.R;

import net.maxproit.salesforce2.common.base.BaseFragment;
import net.maxproit.salesforce2.masum.appdata.AppConstant;
import net.maxproit.salesforce2.masum.appdata.sqlite.MyLeadDbController;

import net.maxproit.salesforce2.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce2.masum.model.api.myactivity.Data;
import net.maxproit.salesforce2.masum.model.local.MyNewLead;
import net.maxproit.salesforce2.masum.model.local.MyNewProspect;
import net.maxproit.salesforce2.masum.model.local.VisitPlan;
import net.maxproit.salesforce2.masum.utility.DateUtils;
import net.maxproit.salesforce2.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce2.model.setting.LocalSetting;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class LeadStageLoanDetailFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    Calendar myCalendar = Calendar.getInstance();

    TextView tvTentativeNumberToWord;
    boolean isFirst = false;
    //TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<MyNewProspect> myNewLeadArrayList;
    private MyLeadDbController myLeadDbController;
    private SpinnerDbController spinnerDbController;
    private ArrayAdapter<String> productSubAdapter;
    private List<String> listSourceReference = null;
    private List<String> listProductType = null;
    private List<String> listProductSubCategory = null;
    private List<String> listCarloan = null;
    private List<String> listHomeloan = null;
    private List<String> listPersonalloan = null;
    private LocalSetting localSetting;
    public static int productTypeCode = 0, productSubCatCode = 0;
    public static AwesomeSpinner spinnerRef, spinnerProductType, spinnerSubCategory;
    public static EditText etLoanAmount, etFee, etInterest, etDisbursementDate, etRemark;
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
        Log.e("crash", "loan");
        View rootView = null;
        rootView = inflater.inflate(R.layout.fragment_lead_stage_loan_detail, container, false);
        initVariable();
        initView(rootView);
        initListener();
        return rootView;
    }

    @Override
    protected Integer layoutResourceId() {
        return null;
    }

    @Override
    protected void initFragmentComponents() {

    }

    private void initVariable() {
        localSetting = new LocalSetting(getActivity());
        spinnerDbController = new SpinnerDbController(getActivity());
        listSourceReference = new ArrayList<String>();
        listProductType = new ArrayList<String>();
        listProductSubCategory = new ArrayList<String>();
        listCarloan = new ArrayList<String>();
        listHomeloan = new ArrayList<String>();
        listPersonalloan = new ArrayList<String>();
        listSourceReference.addAll(spinnerDbController.getSourceOfReferenceData());
        listHomeloan.addAll(localSetting.getProductSubCategorystring(8));
        listCarloan.addAll(localSetting.getProductSubCategorystring(9));
        listPersonalloan.addAll(localSetting.getProductSubCategorystring(10));

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
                MyNewLead myNewLead = null;
                if (getArguments() != null) {
                    int status = getArguments().getInt(AppConstant.STATUS_INTENT_KEY);
                    if (status == 1) {
                        myNewLead = (MyNewLead) getArguments().getSerializable(AppConstant.INTENT_KEY);
                    }
                }
                if (myNewLead == null) {
                    isFirst = true;
                }
                if (isFirst) {
                    productType = s;
                    LongOperation longOperation = new LongOperation();
                    longOperation.execute(i);
                    if (s.equalsIgnoreCase(AppConstant.HOME_LOAN)) {
                        productTypeCode = 8;
                        productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listHomeloan);
                        spinnerSubCategory.setAdapter(productSubAdapter);
                    }
                    if (s.equalsIgnoreCase(AppConstant.CAR_LOAN)) {
                        productTypeCode = 9;
                        productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listCarloan);
                        spinnerSubCategory.setAdapter(productSubAdapter);

                    }
                    if (s.equalsIgnoreCase(AppConstant.PERSONAL_LOAN)) {
                        productTypeCode = 10;
                        productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listPersonalloan);
                        spinnerSubCategory.setAdapter(productSubAdapter);
                    }
                } else {
                    isFirst = true;
                }

            }
        });

        spinnerSubCategory.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                subCategory = s;
                LongOperationSubCategory longOperationSubCategory = new LongOperationSubCategory();
                longOperationSubCategory.execute(s);
            }
        });


    }

    private void initView(View rootView) {

        etRemark = rootView.findViewById(R.id.input_remarks);
        etDisbursementDate = rootView.findViewById(R.id.et_disbursement_date);
        spinnerRef = rootView.findViewById(R.id.awe_spinner_lead_reference);
        spinnerProductType = rootView.findViewById(R.id.awe_spinner_lead_product_type);
        spinnerSubCategory = rootView.findViewById(R.id.awe_spinner_lead_product_sub_type);
        etLoanAmount = rootView.findViewById(R.id.et_load_amount);
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


        etLoanAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                etLoanAmount.removeTextChangedListener(this);
                MasumCommonUtils.commaSeperator(etLoanAmount, editable.toString());

                etLoanAmount.addTextChangedListener(this);
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
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dialog.show();

    }

    private void updateLabel() {
        String myFormat = "dd-mm-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDisbursementDate.setText(sdf.format(myCalendar.getTime()));
    }

    private void initSpinnerAdapter() {
        ArrayAdapter<String> sourceReferenceAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getSourceOfRefString());
        spinnerRef.setAdapter(sourceReferenceAdapter);

        ArrayAdapter<String> productTypeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getProductCategorystring());
        spinnerProductType.setAdapter(productTypeAdapter);

        if (getArguments() != null) {
            int status = getArguments().getInt(AppConstant.STATUS_INTENT_KEY);

            if (status == 0) {
                VisitPlan visitPlan = (VisitPlan) getArguments().getSerializable(AppConstant.INTENT_KEY);
                if (visitPlan != null) {
                    if (visitPlan.getProductType() != null) {
                        try {
                            spinnerProductType.setSelection(productTypeAdapter.getPosition(visitPlan.getProductType()));
                        } catch (final IllegalStateException e) {

                        }
                    }

                }
            } else if (status == 2) {
                Data visitPlan = (Data) getArguments().getSerializable(AppConstant.INTENT_KEY);
                if (visitPlan != null) {
                    if (visitPlan.getProductType() != null) {
                        try {
                            spinnerProductType.setSelection(productTypeAdapter.getPosition(visitPlan.getProductType()));
                        } catch (final IllegalStateException e) {

                        }
                    }

                }
            } else {
                MyNewLead myNewLead = (MyNewLead) getArguments().getSerializable(AppConstant.INTENT_KEY);
                if (myNewLead != null) {
                    MasumCommonUtils.commaSeperator(etLoanAmount, myNewLead.getLoanAmount());
                    etInterest.setText("" + myNewLead.getOrInterest());
                    etDisbursementDate.setText(DateUtils.getDateFormateEt(myNewLead.getDisDate()));
                    etFee.setText("" + myNewLead.getOpFee());
                    etRemark.setText(myNewLead.getRemark());
                    productSubCatCode = myNewLead.getSubCode();

                    if (!MasumCommonUtils.isNullStr(myNewLead.getSourceRef()))
                        try {
                            spinnerRef.setSelection(sourceReferenceAdapter.getPosition(myNewLead.getSourceRef()));
                        } catch (IllegalStateException ignored) {
                        } catch (NullPointerException e) {

                        }
                    if (!MasumCommonUtils.isNullStr(myNewLead.getProductType())) {
                        try {
                            spinnerProductType.setSelection(productTypeAdapter.getPosition(myNewLead.getProductType()));
                        } catch (IllegalStateException ignored) {

                        }

                        if (myNewLead.getProductType().equalsIgnoreCase(AppConstant.HOME_LOAN)) {
                            productTypeCode = 8;
                            productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listHomeloan);
                            spinnerSubCategory.setAdapter(productSubAdapter);
                        } else if (myNewLead.getProductType().equalsIgnoreCase(AppConstant.CAR_LOAN)) {
                            productTypeCode = 9;
                            productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listCarloan);
                            spinnerSubCategory.setAdapter(productSubAdapter);
                        } else if (myNewLead.getProductType().equalsIgnoreCase(AppConstant.PERSONAL_LOAN)) {
                            productTypeCode = 10;
                            productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listPersonalloan);
                            spinnerSubCategory.setAdapter(productSubAdapter);

                        }
                        if (!MasumCommonUtils.isNullStr(myNewLead.getProductSubcategory())) {

                            try {
                                spinnerSubCategory.setSelection(productSubAdapter.
                                        getPosition(myNewLead.getProductSubcategory()));
                            } catch (IllegalStateException ignored) {
                            } catch (NullPointerException e) {

                            }

                        }
                    }

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

    private class LongOperation extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... params) {
            productTypeCode = localSetting.getProductCode(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // txt.setText(result);
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }


    private class LongOperationSubCategory extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            productSubCatCode = localSetting.getSubCatCode(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // txt.setText(result);
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
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
