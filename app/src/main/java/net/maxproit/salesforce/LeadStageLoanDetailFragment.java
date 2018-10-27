package net.maxproit.salesforce;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.util.NumberToWordsConverter;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class LeadStageLoanDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText edittext;
    Calendar myCalendar = Calendar.getInstance();

    TextView tvTentativeNumberToWord;

    //TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AwesomeSpinner spinnerRef,spinnerProductType,spinnerSubCategory;
    public static EditText etLoadAmount,etFee,etInterest;
    public static int ref=0;
    public static String productType = null;
    public static String subCategory = null;
    public static final String HOME_LOAN = "Home Loan";
    public static final String CAR_LOAN = "Car Loan";
    public static final String PERSONAL_LOAN = "Personal Loan";


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
//                productType = i;
                productType = s;

                if(s.equals(HOME_LOAN)){
                    ArrayAdapter<CharSequence> productSubAdapter = ArrayAdapter.createFromResource(getContext(),
                            R.array.hl_array, android.R.layout.simple_spinner_item);
                    spinnerSubCategory.setAdapter(productSubAdapter, 0);

                }
                if(s.equals(CAR_LOAN)){
                    ArrayAdapter<CharSequence> productSubAdapter = ArrayAdapter.createFromResource(getContext(),
                            R.array.cl_array, android.R.layout.simple_spinner_item);
                    spinnerSubCategory.setAdapter(productSubAdapter, 0);

                }
                if(s.equals(PERSONAL_LOAN)){
                    ArrayAdapter<CharSequence> productSubAdapter = ArrayAdapter.createFromResource(getContext(),
                            R.array.pl_array, android.R.layout.simple_spinner_item);
                    spinnerSubCategory.setAdapter(productSubAdapter, 0);

                }

            }
        });
        spinnerSubCategory.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                subCategory = s;
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


        tvTentativeNumberToWord = (TextView) rootView.findViewById(R.id.tv_tentative_number_to_word);
        if(tvTentativeNumberToWord != null){
            tvTentativeNumberToWord.setText("");
        }


        edittext= (EditText) rootView.findViewById(R.id.et_disbursement_date);
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

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etLoadAmount.setText(formattedString);
                    etLoadAmount.setSelection(etLoadAmount.getText().length());
                    tvTentativeNumberToWord.setText(formattedString.isEmpty()? "" : NumberToWords.convert(longVal));
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
                etLoadAmount.addTextChangedListener(this);
            }
        });

        initSpinnerAdapter();
    }

    private void updateLabel() {
        String myFormat = "dd-mm-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }

    private void initSpinnerAdapter() {
        ArrayAdapter<CharSequence> refAdapter = ArrayAdapter.createFromResource(getContext(), R.array.source_of_reference_array, android.R.layout.simple_spinner_item);
        spinnerRef.setAdapter(refAdapter, 0);

        ArrayAdapter<CharSequence> productTypeAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.product_categories_array, android.R.layout.simple_spinner_item);
        spinnerProductType.setAdapter(productTypeAdapter, 0);


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
