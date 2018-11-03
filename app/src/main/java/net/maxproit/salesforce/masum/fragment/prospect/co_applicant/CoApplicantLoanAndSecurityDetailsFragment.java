package net.maxproit.salesforce.masum.fragment.prospect.co_applicant;

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
import android.widget.LinearLayout;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.SharedViewModel;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CoApplicantLoanAndSecurityDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CoApplicantLoanAndSecurityDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoApplicantLoanAndSecurityDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private SpinnerDbController spinnerDbController;

    private List<String> listBrandName=null;
    private List<String> listManufacturingYear=null;
    private List<String> listManufacturingCountry=null;
    private List<String> listvehicleType=null;

    public static EditText etSecurityValue, etLoanRequired, etLoanTerm, etProposedInterest, etFee, etCalculatedEMI;

    AwesomeSpinner spinnerBrand, spinnerYear, spinnerCountry, spinnerVehicleType;
    public static String brandName, year, country, vehicleType;
    ProspectStageActivity prospectStageActivity;
    private OnFragmentInteractionListener mListener;

    public CoApplicantLoanAndSecurityDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CoApplicantLoanAndSecurityDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CoApplicantLoanAndSecurityDetailsFragment newInstance(String param1, String param2) {
        CoApplicantLoanAndSecurityDetailsFragment fragment = new CoApplicantLoanAndSecurityDetailsFragment();
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
        // Inflate the layout for this fragment




        View view = inflater.inflate(R.layout.fragment_co_applicant_loan_and_security_details, container, false);


        listBrandName = new ArrayList<String>();
        listManufacturingYear = new ArrayList<String>();
        listManufacturingCountry = new ArrayList<String>();
        listvehicleType = new ArrayList<String>();

        listBrandName.addAll(spinnerDbController.getBrandNameData());
        listManufacturingYear.addAll(spinnerDbController.getManufacturingYearData());
        listManufacturingCountry.addAll(spinnerDbController.getManufacturingCountryData());
        listvehicleType.addAll(spinnerDbController.getVehicleTypeData());


        LinearLayout secBrandNameLabel = (LinearLayout) view.findViewById(R.id.brand_name_label);
        LinearLayout secManYearLabel = (LinearLayout) view.findViewById(R.id.manufacturing_year_label);
        LinearLayout secManCountryLabel = (LinearLayout) view.findViewById(R.id.manufacturing_country_label);
        LinearLayout secVehicleTypeLabel = (LinearLayout) view.findViewById(R.id.vehicle_type_label);




        etSecurityValue = view.findViewById(R.id.et_co_applicant_security_value);
        etLoanRequired = view.findViewById(R.id.et_co_applicant_loan_required);
        etLoanTerm = view.findViewById(R.id.et_co_applicant_loan_term);
        etProposedInterest = view.findViewById(R.id.et_co_applicant_proposed_interest_rate);
        etFee = view.findViewById(R.id.et_co_applicant_fee);


        spinnerBrand = view.findViewById(R.id.awe_spinner_co_applicant_brand_name);
        spinnerYear = view.findViewById(R.id.awe_spinner_co_applicant_manufacturing_year);
        spinnerCountry = view.findViewById(R.id.awe_spinner_co_applicant_manufacturing_country);
        spinnerVehicleType = view.findViewById(R.id.awe_spinner_co_applicant_vehicle_type);

        initAdapters();
        initListener();
        return view;


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

        ArrayAdapter<String> brand=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listBrandName);
        spinnerBrand.setAdapter(brand);

//        ArrayAdapter<CharSequence> BrandAdapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.car_brands,
//                android.R.layout.simple_spinner_item);
//        spinnerBrand.setAdapter(BrandAdapter, 0);

        ArrayAdapter<String> manufacturingYear=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listManufacturingYear);
        spinnerYear.setAdapter(manufacturingYear);
//        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.years,
//                android.R.layout.simple_spinner_item);
//        spinnerYear.setAdapter(yearAdapter, 0);

//        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.countries,
//                android.R.layout.simple_spinner_item);
//        spinnerCountry.setAdapter(countryAdapter, 0);

        ArrayAdapter<String> manufacturingCountry=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listManufacturingCountry);
        spinnerCountry.setAdapter(manufacturingCountry);

//        ArrayAdapter<CharSequence> vehicleAdapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.vehicle_types,
//                android.R.layout.simple_spinner_item);
//        spinnerVehicleType.setAdapter(vehicleAdapter, 0);


        ArrayAdapter<String> vehicleType=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listvehicleType);
        spinnerVehicleType.setAdapter(vehicleType);


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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
