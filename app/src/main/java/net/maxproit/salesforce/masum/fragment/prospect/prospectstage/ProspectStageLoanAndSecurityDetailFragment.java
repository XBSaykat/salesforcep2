package net.maxproit.salesforce.masum.fragment.prospect.prospectstage;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.SharedViewModel;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.CarLoanDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.model.local.CarLoan;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.model.setting.LocalSetting;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProspectStageLoanAndSecurityDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LocalSetting localSetting;


    private OnFragmentInteractionListener mListener;


    private List<String> listBrandName = null;
    private List<String> listManufacturingYear = null;
    private List<String> listManufacturingCountry = null;
    private List<String> listvehicleType = null;
    private List<CarLoan> carLoanTypelist = null;
    public static EditText etSecurityValue, etLoanRequired, etLoanTerm, etProposedInterest, etFee, etYear, etCountry;
    public static LinearLayout liSecCarLoan;
    public static int assetId = 0, manufactureNameID = 0;
    private AwesomeSpinner spinnerBrand, spinnerVehicleType;
    public static String brandName, year, country, vehicleType;
    private ProspectStageActivity prospectStageActivity;
    private ArrayList<String> manufactureList;


    public ProspectStageLoanAndSecurityDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProspectStageLoanAndSecurityDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProspectStageLoanAndSecurityDetailFragment newInstance(String param1, String param2) {
        ProspectStageLoanAndSecurityDetailFragment fragment = new ProspectStageLoanAndSecurityDetailFragment();
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

        initVariable();
        View view = inflater.inflate(R.layout.fragment_prospect_stage_loan_and_security_detail, container, false);
        initView(view);
        commaSeparator();
        return view;
    }

    private void initView(View view) {

        liSecCarLoan = view.findViewById(R.id.li_car_loan_section);
        etSecurityValue = view.findViewById(R.id.input_security_value);
        etLoanRequired = view.findViewById(R.id.input_loan_required);
        etLoanTerm = view.findViewById(R.id.input_loan_term);
        etProposedInterest = view.findViewById(R.id.input_proposed_interest_rate);
        etFee = view.findViewById(R.id.input_fee);
        spinnerBrand = view.findViewById(R.id.awe_spinner_prospect_stage_brand_name);
        etYear = view.findViewById(R.id.awe_spinner_prospect_stage_manufacturing_year);
        etCountry = view.findViewById(R.id.awe_spinner_prospect_stage_manufacturing_country);
        spinnerVehicleType = view.findViewById(R.id.awe_spinner_prospect_stage_vehicle_type);

        initAdapters();
    }

    private void initVariable() {
        localSetting = new LocalSetting(getActivity());
        listBrandName = new ArrayList<String>();
        listManufacturingYear = new ArrayList<String>();
        listManufacturingCountry = new ArrayList<String>();
        listvehicleType = new ArrayList<String>();
        manufactureList=new ArrayList<>();
        carLoanTypelist = new ArrayList<>();
        final SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        prospectStageActivity = (ProspectStageActivity) getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    private void initAdapters() {

        ArrayAdapter<String> brandAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, manufactureList);
        spinnerBrand.setAdapter(brandAdapter);

        ArrayAdapter<String> vehicleTypeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getAssetTypeStringList());
        spinnerVehicleType.setAdapter(vehicleTypeAdapter);
        initListener(brandAdapter);
        if (prospectStageActivity.getDataFromProspect() != null) {

            MyNewProspect myNewLead = prospectStageActivity.getDataFromProspect();

            etSecurityValue.setText(myNewLead.getsValue());
            etLoanRequired.setText(myNewLead.getLoanReq());
            etProposedInterest.setText(myNewLead.getOrInterest());
            etLoanTerm.setText(myNewLead.getLoanTerm());
            etFee.setText(myNewLead.getOpFee());

            if (myNewLead.getProductType().equalsIgnoreCase(AppConstant.CAR_LOAN)) {
                liSecCarLoan.setVisibility(View.VISIBLE);


                if (!MasumCommonUtils.isNullStr(myNewLead.getAssetType())) {
                    try {
                        spinnerVehicleType.setSelection(vehicleTypeAdapter.getPosition(myNewLead.getAssetType()));

                    } catch (final IllegalStateException ignored) {
                    }
                    if (!manufactureList.isEmpty()){
                        manufactureList.clear();
                    }

                    assetId = localSetting.getAssetCode(spinnerVehicleType.getSelectedItemPosition());
                    manufactureList.addAll(localSetting.getManufactureNameString(assetId)) ;
                    brandAdapter.notifyDataSetChanged();


                    if (!MasumCommonUtils.isNullStr(myNewLead.getManufacturingName())) {
                        try {
                            spinnerBrand.setSelection(brandAdapter.getPosition(myNewLead.getManufacturingName()));

                        } catch (final IllegalStateException ignored) {
                        }

                        LongOperationManuId longOperationManuId = new LongOperationManuId();
                        longOperationManuId.execute(myNewLead.getManufacturingName());
                    }

                }
                etCountry.setText(myNewLead.getManufacturingCountry());
                etYear.setText(myNewLead.getManufacturingYear());
            }

        }

    }

    private void initListener(ArrayAdapter<String> brandAdapter) {

        spinnerBrand.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                brandName = s;
                LongOperationManuId longOperationManuId = new LongOperationManuId();
                longOperationManuId.execute(s);
            }
        });


        spinnerVehicleType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                vehicleType = s;
                if (!manufactureList.isEmpty()){
                    manufactureList.clear();
                }
                assetId = localSetting.getAssetCode(i);
                manufactureList.addAll(localSetting.getManufactureNameString(assetId));

                brandAdapter.notifyDataSetChanged();


              /*  LongOperationAssetID longOperationAssetID = new LongOperationAssetID();
                longOperationAssetID.execute(i);*/
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

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void commaSeparator() {
        etSecurityValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etSecurityValue.removeTextChangedListener(this);
                try {

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern(AppConstant.numberPattern);
                    String formattedString = formatter.format(longVal);

                    etSecurityValue.setText(formattedString);
                    etSecurityValue.setSelection(etSecurityValue.getText().length());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                etSecurityValue.addTextChangedListener(this);
            }
        });

        etLoanRequired.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                etLoanRequired.removeTextChangedListener(this);
                try {

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern(AppConstant.numberPattern);
                    String formattedString = formatter.format(longVal);
                    etLoanRequired.setText(formattedString);
                    etLoanRequired.setSelection(etLoanRequired.getText().length());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                etLoanRequired.addTextChangedListener(this);
            }
        });


    }

    private class LongOperationAssetID extends AsyncTask<Integer, Void, String> {
        @Override
        protected String doInBackground(Integer... params) {

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

    private class LongOperationManuId extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            manufactureNameID = localSetting.getManuCode(params[0]);
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


    private interface isDataReturn{

    }
}
