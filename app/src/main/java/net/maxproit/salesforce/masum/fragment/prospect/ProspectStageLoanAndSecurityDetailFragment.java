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
import android.widget.LinearLayout;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.NumberTextWatcher;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.SharedViewModel;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.appdata.sqlite.CarLoanDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.model.local.CarLoan;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;

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

    private OnFragmentInteractionListener mListener;

    private SpinnerDbController spinnerDbController;
    private CarLoanDbController carLoanDbController;

    private List<String> listBrandName=null;
    private List<String> listManufacturingYear=null;
    private List<String> listManufacturingCountry=null;
    private List<String> listvehicleType=null;
    private List<CarLoan> carLoanTypelist =null;
    public static int cardData =0;
    public static EditText etSecurityValue, etLoanRequired, etLoanTerm, etProposedInterest, etFee;
    public static LinearLayout liSecCarLoan;

    AwesomeSpinner spinnerBrand, spinnerYear, spinnerCountry, spinnerVehicleType;
    public static String brandName, year, country, vehicleType;
    ProspectStageActivity prospectStageActivity;


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


        spinnerDbController = new SpinnerDbController(getActivity());
        carLoanDbController = new CarLoanDbController(getActivity());

        listBrandName = new ArrayList<String>();
        listManufacturingYear = new ArrayList<String>();
        listManufacturingCountry = new ArrayList<String>();
        listvehicleType = new ArrayList<String>();
        carLoanTypelist = new ArrayList<>();

        listBrandName.addAll(spinnerDbController.getBrandNameData());
        listManufacturingYear.addAll(spinnerDbController.getManufacturingYearData());
        listManufacturingCountry.addAll(spinnerDbController.getManufacturingCountryData());
        listvehicleType.addAll(spinnerDbController.getVehicleTypeData());

        View view = inflater.inflate(R.layout.fragment_prospect_stage_loan_and_security_detail, container, false);

        final SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        prospectStageActivity= (ProspectStageActivity) getActivity();

        LinearLayout secBrandNameLabel = (LinearLayout) view.findViewById(R.id.brand_name_label);
        LinearLayout secManYearLabel = (LinearLayout) view.findViewById(R.id.manufacturing_year_label);
        LinearLayout secManCountryLabel = (LinearLayout) view.findViewById(R.id.manufacturing_country_label);
        LinearLayout secVehicleTypeLabel = (LinearLayout) view.findViewById(R.id.vehicle_type_label);
        liSecCarLoan = view.findViewById(R.id.li_car_loan_section);







        etSecurityValue = view.findViewById(R.id.input_security_value);
        etLoanRequired = view.findViewById(R.id.input_loan_required);
        etLoanTerm = view.findViewById(R.id.input_loan_term);
        etProposedInterest = view.findViewById(R.id.input_proposed_interest_rate);
        etFee = view.findViewById(R.id.input_fee);

       // etProposedInterest.addTextChangedListener(new NumberTextWatcher(etProposedInterest));
        //etFee.addTextChangedListener(new NumberTextWatcher(etFee));

        spinnerBrand = view.findViewById(R.id.awe_spinner_prospect_stage_brand_name);
        spinnerYear = view.findViewById(R.id.awe_spinner_prospect_stage_manufacturing_year);
        spinnerCountry = view.findViewById(R.id.awe_spinner_prospect_stage_manufacturing_country);
        spinnerVehicleType = view.findViewById(R.id.awe_spinner_prospect_stage_vehicle_type);

        initAdapters();
        initListener();


        commaSeparator();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    private void initListener() {

        spinnerBrand.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                brandName = s;
            }
        });

        spinnerYear.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                year = s;
            }
        });

        spinnerCountry.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                country = s;
            }
        });

        spinnerVehicleType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                vehicleType = s;
            }
        });
    }

    private void initAdapters() {

        ArrayAdapter<String> brandAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listBrandName);
        spinnerBrand.setAdapter(brandAdapter);

        ArrayAdapter<String> manufacturingYearAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listManufacturingYear);
        spinnerYear.setAdapter(manufacturingYearAdapter);

        ArrayAdapter<String> manufacturingCountryAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listManufacturingCountry);
        spinnerCountry.setAdapter(manufacturingCountryAdapter);

        ArrayAdapter<String> vehicleTypeAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listvehicleType);
        spinnerVehicleType.setAdapter(vehicleTypeAdapter);

        if (prospectStageActivity.getDataFromProspect()!=null){

            MyNewProspect myNewLead=prospectStageActivity.getDataFromProspect();

            etSecurityValue.setText(myNewLead.getsValue());
            etLoanRequired.setText(myNewLead.getLoadAmount());
            etProposedInterest.setText(myNewLead.getOrInterest());
            etLoanTerm.setText(myNewLead.getLoanTerm());
            etFee.setText(myNewLead.getOpFee());
            cardData = carLoanDbController.getData(String.valueOf(myNewLead.getId())).size();
            if (cardData >0){
                carLoanTypelist.addAll(carLoanDbController.getData(String.valueOf(myNewLead.getId())));
                try {
                    spinnerBrand.setSelection(brandAdapter.getPosition(carLoanTypelist.get(0).getBrandName()));

                }
                catch (final IllegalStateException ignored) {
                }


                try {
                    spinnerCountry.setSelection(manufacturingCountryAdapter.getPosition(carLoanTypelist.get(0).getMenuCountry()));

                }
                catch (final IllegalStateException ignored) {
                }

                try {
                    spinnerYear.setSelection(manufacturingYearAdapter.getPosition(carLoanTypelist.get(0).getMenuYear()));

                }
                catch (final IllegalStateException ignored) {
                }

                try {
                    spinnerVehicleType.setSelection(vehicleTypeAdapter.getPosition(carLoanTypelist.get(0).getVehicleType()));

                }
                catch (final IllegalStateException ignored) {
                }
            }


          /*  etLoanRequired.setText(myNewLead.getLoanReq());
            etProposedInterest.setText(myNewLead.getPiRate());
            etFee.setText(myNewLead.getProspectFee());*/

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

    public void commaSeparator(){
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etSecurityValue.setText(formattedString);
                    etSecurityValue.setSelection(etSecurityValue.getText().length());
                }catch (NumberFormatException nfe){
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
                try{

                    String originalTentativeLoanAmount = editable.toString();
                    originalTentativeLoanAmount = originalTentativeLoanAmount.contains(",") ? originalTentativeLoanAmount.replaceAll(",", "") : originalTentativeLoanAmount;
                    Long longVal = Long.parseLong(originalTentativeLoanAmount);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longVal);

                    etLoanRequired.setText(formattedString);
                    etLoanRequired.setSelection(etLoanRequired.getText().length());
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
                etLoanRequired.addTextChangedListener(this);
            }
        });
    }
}
