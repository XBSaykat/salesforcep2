package net.maxproit.salesforce.masum.fragment.prospect.co_applicant;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.SharedViewModel;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.activity.prospect.co_applicant.CoApplicantActivity;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.fragment.prospect.prospectstage.ProspectStageProductAndCustomerDetailsFragment;
import net.maxproit.salesforce.masum.model.local.CoApplicant;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.model.setting.LocalSetting;
import net.maxproit.salesforce.util.CommonUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CoApplicantProductAndCustomerDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CoApplicantProductAndCustomerDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoApplicantProductAndCustomerDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    LocalSetting localSetting;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static ProspectStageActivity prospectStageActivity;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private LinearLayout liPhotoIdNo, liPassport, liDrivingLicense, liBirthCertificate;
    private EditText etNid, etPassport, etDrivingLicense, etBirthCertificate;
    private RadioGroup rgExList;
    private SpinnerDbController spinnerDbController;
    private MyLeadDbController myLeadDbController;
    private List<String> listProductCategory = null;
    private List<String> listPoroductDetail = null;
    private List<String> listCarloan = null;
    private List<String> listHomeloan = null;
    private List<String> listPersonalloan = null;
    private List<String> listBranch = null;
    private List<String> listSegment = null;
    private List<String> listBirthDistric = null;
    private List<String> listBirthCountry = null;
    private List<String> listProfession = null;
    private List<String> listRelationshipWithApplicant = null;
    private List<String> listValidphoto = null;
    ArrayList<MyNewProspect> prosList;

//    Spinner productCategory;
//    Spinner productDetail;


    private AwesomeSpinner spinnerProductCat, spinnerProductDetail, spinnerBranchName, spinnerSegment, spinnerDistOfBirth,
            spinnerCountOfBirth, spinnerProfession, spinnerRelationship, spinnerValidPhotoType, spinnerPreCity, spinnerPrePoliceStation, spinnerPerCity, spinnerPerPoliceStation;
    private TextView tvPhotoIdNo;
    public static EditText etName, etDateOfBirth, etAge, etPhotoId, etPhotoIdDate, etETin, etFatherName, etMotherName,
            etSpouseName, etCompanyName, etDesignation, etNoYrsInCurrentJob, etPresentAddress,
            etPermanentAddress, etMobileNumber;

    private LinearLayout llAddress;
    private CheckBox cbAddress;


    public static String productCat, productDetails, branchName, segment, countOfBirth, districtOfBirth, profession,
            relationship, name, dateOfBirth, age, photoIdType, photoId, photoIdDate, exList, eTin, fatherName, motherName, spouseName,
            companyName, designation, noYrsInCureentJob, presentAddress, permanentAddress, mobileNumber, validPhoto, preCity = "", prePoliceStation = "", perCity = "", perPoliceStation = "";
    private LinearLayout proCatSec, proDetailSec, branchSec, segmentSec;
    public static int photoIdcode;
    private CoApplicantActivity coApplicantActivity;

    private SharedViewModel model;

    private OnFragmentInteractionListener mListener;

    public CoApplicantProductAndCustomerDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProspectStageCoApplicantProductAndCustomerDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CoApplicantProductAndCustomerDetailsFragment newInstance(String param1, String param2) {
        CoApplicantProductAndCustomerDetailsFragment fragment = new CoApplicantProductAndCustomerDetailsFragment();
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

        localSetting = new LocalSetting(getActivity());
        View view = inflater.inflate(R.layout.fragment_prospect_stage_product_and_customer_details, container, false);
        coApplicantActivity = (CoApplicantActivity) getActivity();
        myLeadDbController = new MyLeadDbController(getActivity());
        etName = view.findViewById(R.id.input_name);
        etAge = view.findViewById(R.id.input_age);
        prosList = new ArrayList<>();
        etDateOfBirth = view.findViewById(R.id.input_date_of_birth);

        etPhotoId = view.findViewById(R.id.et_photo_id_no);
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
        llAddress = (LinearLayout) view.findViewById(R.id.ll_address);
        cbAddress = (CheckBox) view.findViewById(R.id.cb_address);

        tvPhotoIdNo = view.findViewById(R.id.tv_photo_id_no);
        liPhotoIdNo = view.findViewById(R.id.li_photo_id_no);
        liPhotoIdNo.setVisibility(View.GONE);
        llAddress.setVisibility(View.VISIBLE);

        rgExList = view.findViewById(R.id.rg_exlist);
        spinnerDbController = new SpinnerDbController(getActivity());
        listProductCategory = new ArrayList<String>();
        listPoroductDetail = new ArrayList<String>();
        listBranch = new ArrayList<String>();
        listSegment = new ArrayList<String>();
        listBirthDistric = new ArrayList<String>();
        listBirthCountry = new ArrayList<String>();
        listProfession = new ArrayList<String>();
        listRelationshipWithApplicant = new ArrayList<String>();
        listCarloan = new ArrayList<String>();
        listHomeloan = new ArrayList<String>();
        listPersonalloan = new ArrayList<String>();
        listValidphoto = new ArrayList<String>();

        listProductCategory.addAll(spinnerDbController.getProductCategoryData());
        listPoroductDetail.addAll(spinnerDbController.getProductDetailData());
        listCarloan.addAll(spinnerDbController.getCarLoanData());
        listHomeloan.addAll(spinnerDbController.getHomeLoanData());
        listPersonalloan.addAll(spinnerDbController.getPersonalLoanData());
        listBranch.addAll(spinnerDbController.getBranchData());
        listSegment.addAll(spinnerDbController.getSegmentData());
        listProfession.addAll(spinnerDbController.getProfessionData());
        listBirthDistric.addAll(spinnerDbController.getBirthDistrictData());
        listBirthCountry.addAll(spinnerDbController.getBirthCountryData());
        listRelationshipWithApplicant.addAll(spinnerDbController.getRelationshipWithApplicantData());
        listValidphoto.addAll(spinnerDbController.getValidPhotoData());

        spinnerPreCity = view.findViewById(R.id.awe_spinner_visit_plan_city);
        spinnerPrePoliceStation = view.findViewById(R.id.awe_spinner_visit_plan_police_station);
        spinnerPerCity = view.findViewById(R.id.awe_spinner_visit_plan_city_per);
        spinnerPerPoliceStation = view.findViewById(R.id.awe_spinner_visit_plan_police_station_per);
        spinnerDistOfBirth = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_district_of_birth);
        spinnerCountOfBirth = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_country_of_birth);
        spinnerProfession = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_profession);
        spinnerRelationship = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_relation_with_applicant);
        spinnerValidPhotoType = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_valid_photo_id_type);

        proCatSec = view.findViewById(R.id.li_product_cat_sec);
        proDetailSec = view.findViewById(R.id.li_product_detail_sec);
        branchSec = view.findViewById(R.id.li_branch_sec);
        segmentSec = view.findViewById(R.id.li_segment_sec);

        proCatSec.setVisibility(View.GONE);
        proDetailSec.setVisibility(View.GONE);
        branchSec.setVisibility(View.GONE);
        segmentSec.setVisibility(View.GONE);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        initAdapters();
        initListener();
        getExceptionlist();
       /* if (getArguments() != null) {
            presentAddress = getArguments().getString(AppConstant.PRESENT_ADDRESSS_KEY);
            permanentAddress = getArguments().getString(AppConstant.PERMANENT_ADDRESSS_KEY);
        }*/

        presentAddress = coApplicantActivity.pr;
        permanentAddress = coApplicantActivity.pe;
        preCity = coApplicantActivity.preCity;
        prePoliceStation = coApplicantActivity.prePs;
        perCity = coApplicantActivity.perCity;
        perPoliceStation = coApplicantActivity.perPs;

        //  prosList.addAll(myLeadDbController.myNewLeadGetAllData(coApplicantActivity.getLeadId()));
        return view;
    }


    private void getExceptionlist() {
        switch (rgExList.getCheckedRadioButtonId()) {

            case R.id.rb_yes:
                exList = "yes";
                break;
            case R.id.rb_no:
                exList = "no";
                break;
            default:
                exList = "no";
                break;
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

    public void initListener() {
        name = etName.getText().toString();

        etDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int mYear = calendar.get(Calendar.YEAR);
                int mMonth = calendar.get(Calendar.MONTH);
                int mDay = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialogCalculate = new DatePickerDialog(getView().getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        datepickerListner, mYear, mMonth, mDay);
//                datePickerDialogCalculate.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialogCalculate.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialogCalculate.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialogCalculate.show();
            }
        });


//        etDateOfBirth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                datePickerDialog(getContext(), etDateOfBirth);
//            }
//        });


        etPhotoIdDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog(getContext(), etPhotoIdDate);
            }
        });

        etAge.setEnabled(false);


        etMobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String mobileNo = charSequence.toString(), regex = "01[3|5|6|7|8|9][0-9]{8}";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(mobileNo);
                if (!mobileNo.isEmpty() && matcher.matches()) {

                } else {
                    etMobileNumber.setError("You entered invalid mobile no.");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        spinnerPreCity.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                preCity = s;


            }

        });

        spinnerPrePoliceStation.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                prePoliceStation = s;
            }
        });
        spinnerPerCity.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                perCity = s;


            }

        });

        spinnerPerPoliceStation.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                perPoliceStation = s;
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


        spinnerValidPhotoType.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                validPhoto = s;
                LongOperationPhotoIDCode longOperationPhotoIDCode = new LongOperationPhotoIDCode();
                longOperationPhotoIDCode.execute(i);
                getphotoIdNumber(s);
            }
        });


    }

    private void getphotoIdNumber(String type) {

        tvPhotoIdNo.setText("" + type + " No.");
        liPhotoIdNo.setVisibility(View.VISIBLE);
        photoIdType = type;


    }

    private DatePickerDialog.OnDateSetListener datepickerListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            String myFormat = new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());
            etDateOfBirth.setText(myFormat);
            etAge.setText(calcutateAge(calendar.getTimeInMillis()));

        }
    };

    private String calcutateAge(long date) {
        Calendar dob = Calendar.getInstance();
        dob.setTimeInMillis(date);

        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH) ||
                today.get(Calendar.MONTH) < dob.get(Calendar.MONTH) &&
                        today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)
                || today.get(Calendar.DAY_OF_MONTH) == dob.get(Calendar.DAY_OF_MONTH)) {
            age = age;
        }

        Integer ageInt = new Integer(age);
        String ages = ageInt.toString();

        return ages;
    }


    public void initAdapters() {
        ArrayAdapter<String> perPolishStationAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getPseStringList());
        spinnerPerPoliceStation.setAdapter(perPolishStationAdapter);

        ArrayAdapter<String> perCityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getCityStringList());
        spinnerPerCity.setAdapter(perCityAdapter);

        ArrayAdapter<String> prePolishStationAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getPseStringList());
        spinnerPrePoliceStation.setAdapter(perPolishStationAdapter);

        ArrayAdapter<String> preCityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getCityStringList());
        spinnerPreCity.setAdapter(perCityAdapter);

        ArrayAdapter<String> disBirthAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getCityStringList());
        spinnerDistOfBirth.setAdapter(disBirthAdapter);

        ArrayAdapter<String> disCountryAdater = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getCountryString());
        spinnerCountOfBirth.setAdapter(disCountryAdater);

        ArrayAdapter<String> professionAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getProfessionString());
        spinnerProfession.setAdapter(professionAdapter);

        ArrayAdapter<String> realationAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getIdlcRelationTypeStringList());
        spinnerRelationship.setAdapter(realationAdapter);


        ArrayAdapter<String> validPhotoIdAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getphotoIDTypestring());
        spinnerValidPhotoType.setAdapter(validPhotoIdAdapter);

        cbAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cbAddress.isChecked()) {
                    if (presentAddress != null)
                        etPresentAddress.setText(presentAddress);
                    if (permanentAddress != null)
                        etPermanentAddress.setText(permanentAddress);

                    if (!MasumCommonUtils.isNullStr(preCity)) {
                        try {
                            spinnerPreCity.setSelection(preCityAdapter.getPosition(preCity));
                        } catch (final IllegalStateException ignored) {

                        }
                    }
                    if (!MasumCommonUtils.isNullStr(prePoliceStation)) {
                        try {
                            spinnerPrePoliceStation.setSelection(prePolishStationAdapter.getPosition(prePoliceStation));
                        } catch (final IllegalStateException ignored) {

                        }
                    }
                    if (!MasumCommonUtils.isNullStr(perCity)) {
                        try {
                            spinnerPerCity.setSelection(perCityAdapter.getPosition(perCity));
                        } catch (final IllegalStateException ignored) {

                        }
                    }
                    if (!MasumCommonUtils.isNullStr(perPoliceStation)) {
                        try {
                            spinnerPerPoliceStation.setSelection(perPolishStationAdapter.getPosition(perPoliceStation));
                        } catch (final IllegalStateException ignored) {

                        }
                    }
                } else {
                    etPresentAddress.setText("");
                    etPermanentAddress.setText("");
                }

            }
        });

        if (coApplicantActivity.getDataFromApplicant() != null) {
            CoApplicant coApplicant = coApplicantActivity.getDataFromApplicant();
            etName.setText(coApplicant.getName());
            if (!MasumCommonUtils.isNullStr(coApplicant.getDateOfBirth())) {
                if (!DateUtils.isValidFormat(coApplicant.getDateOfBirth())) {
                    etDateOfBirth.setText(DateUtils.getDateFormateEt(CommonUtil.jsonToDate(coApplicant.getDateOfBirth())));
                    long timeinMIlis = DateUtils.getDateStringtoTimeInMinlis(etDateOfBirth.getText().toString());
                    etAge.setText(MasumCommonUtils.calcutateAge(timeinMIlis));
                } else {
                    etDateOfBirth.setText(coApplicant.getDateOfBirth());
                    long timeinMIlis = DateUtils.getDateStringtoTimeInMinlis(coApplicant.getDateOfBirth());
                    etAge.setText(MasumCommonUtils.calcutateAge(timeinMIlis));
                }
            }

            etDesignation.setText(coApplicant.getDesignation());
            etETin.setText(coApplicant.geteTin());
            etFatherName.setText(coApplicant.getfName());
            etMotherName.setText(coApplicant.getmName());
            etSpouseName.setText(coApplicant.getsName());
            if (coApplicant.getPhotoIdIssueDate() != null) {
                etPhotoIdDate.setText(DateUtils.getDateFormateEt(CommonUtil.jsonToDate(coApplicant.getPhotoIdIssueDate())));
            }
            etCompanyName.setText(coApplicant.getCompanyName());
            etPermanentAddress.setText(coApplicant.getPermanentAddress());
            etPresentAddress.setText(coApplicant.getPresentAddress());
            etNoYrsInCurrentJob.setText(coApplicant.getNoOfYrsInCurrentJob());
            etMobileNumber.setText(coApplicant.getMobileNo());
            getphotoIdNumber(coApplicant.getPhotoIdType());
            etPhotoId.setText(coApplicant.getPhotoIdNo());
            if (!MasumCommonUtils.isNullStr(coApplicant.getDistrictOfBirth())) {

                try {
                    spinnerDistOfBirth.setSelection(disBirthAdapter.getPosition(coApplicant.getDistrictOfBirth()));

                } catch (final IllegalStateException e) {

                }
            }
            if (!MasumCommonUtils.isNullStr(coApplicant.getCountryOfBirth())) {
                try {
                    spinnerCountOfBirth.setSelection(disCountryAdater.getPosition(coApplicant.getCountryOfBirth()));

                } catch (final IllegalStateException e) {

                }
            }
            if (!MasumCommonUtils.isNullStr(coApplicant.getPhotoIdType())) {
                String pIdTypeStr = localSetting.getPhotoIdTypeStrByCode(Integer.parseInt(coApplicant.getPhotoIdType()));
                photoIdcode = Integer.parseInt(coApplicant.getPhotoIdType());
                try {
                    spinnerValidPhotoType.setSelection(validPhotoIdAdapter.getPosition(pIdTypeStr));
                    getphotoIdNumber(pIdTypeStr);

                } catch (IllegalStateException er) {

                }
            } else {
                liPhotoIdNo.setVisibility(View.GONE);
            }

            if (!MasumCommonUtils.isNullStr(coApplicant.getProfession())) {
                try {
                    spinnerProfession.setSelection(professionAdapter.getPosition(coApplicant.getProfession()));

                } catch (final IllegalStateException ignored) {

                }
            }

            if (!MasumCommonUtils.isNullStr(coApplicant.getRelationWithApplicant())) {
                try {
                    spinnerRelationship.setSelection(realationAdapter.getPosition(coApplicant.getRelationWithApplicant()));
                } catch (final IllegalStateException ignored) {

                }
            }
            //city android polish station

            if (!MasumCommonUtils.isNullStr(coApplicant.getPresentAddressCity())) {
                try {
                    spinnerPreCity.setSelection(preCityAdapter.getPosition(coApplicant.getPresentAddressCity()));
                } catch (final IllegalStateException ignored) {

                }
            }
            if (!MasumCommonUtils.isNullStr(coApplicant.getPresentAddressPS())) {
                try {
                    spinnerPrePoliceStation.setSelection(prePolishStationAdapter.getPosition(coApplicant.getPresentAddressPS()));
                } catch (final IllegalStateException ignored) {

                }
            }
            if (!MasumCommonUtils.isNullStr(coApplicant.getPermanentAddressCity())) {
                try {
                    spinnerPerCity.setSelection(perCityAdapter.getPosition(coApplicant.getPermanentAddressCity()));
                } catch (final IllegalStateException ignored) {

                }
            }
            if (!MasumCommonUtils.isNullStr(coApplicant.getPermanentAddressPS())) {
                try {
                    spinnerPerPoliceStation.setSelection(perPolishStationAdapter.getPosition(coApplicant.getPermanentAddressPS()));
                } catch (final IllegalStateException ignored) {

                }
            }


        }
    }

    public void datePickerDialog(Context context, EditText et) {

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String selectedDate = (dayOfMonth + "." + month + "." + year);
                et.getText().clear();
                et.setText(selectedDate);
                et.getText().clear();
                et.setText(selectedDate);
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
        dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        dialog.show();

    }

//    private void setDataFromProspect(ArrayAdapter<CharSequence> adapter){
//
//
//    }


    private class LongOperationPhotoIDCode extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... params) {
            photoIdcode = localSetting.getPhotoIdCode(params[0]);
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


}
