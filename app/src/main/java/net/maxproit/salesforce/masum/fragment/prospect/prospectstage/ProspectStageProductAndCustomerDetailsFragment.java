package net.maxproit.salesforce.masum.fragment.prospect.prospectstage;

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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.SharedViewModel;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
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

public class ProspectStageProductAndCustomerDetailsFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static ProspectStageActivity prospectStageActivity;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LocalSetting localSetting;
    private ArrayAdapter<String> productSubAdapter;

    Calendar myCalendar = Calendar.getInstance();

    private LinearLayout liNid, liPassport, liDrivingLicense, liBirthCertificate;
    private EditText etNid, etPassport, etDrivingLicense, etBirthCertificate;

    private SpinnerDbController spinnerDbController;

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

//    Spinner productCategory;
//    Spinner productDetail;


    private AwesomeSpinner spinnerProductCat, spinnerSub, spinnerBranchName, spinnerSegment, spinnerDistOfBirth,
            spinnerCountOfBirth, spinnerProfession, spinnerRelationship, spinnerValidPhoto, spinnerPreCity, spinnerPrePoliceStation, spinnerPerCity, spinnerPerPoliceStation;
    private LinearLayout liPhotoIdNo;
    private TextView tvPhotoIdNo;

    public static EditText etName, etDob, etAge, etPhotoId, etPhotoIdDate, etETin, etFatherName, etMotherName,
            etSpouseName, etCompanyName, etDesignation, etNoYrsInCurrentJob, etPresentAddress,
            etPermanentAddress, etMobileNumber;
    public EditText etProductCat;
    public static String productCat, productSub, branchName, branchCode = null, segment, countOfBirth, districtOfBirth, profession,
            relationship, name, age, photoIdType, photoId, photoIdDate, eTin, fatherName, motherName, spouseName,
            companyName, designation, noYrsInCureentJob, presentAddress, permanentAddress, mobileNumber, validPhoto, photoType, preCity = "", prePoliceStation = "", perCity = "", perPoliceStation = "";

    public static int productTypeCode = 0, photoIdcode = 0, productSubCatCode = 0;
    private LinearLayout llAddress;

    private RadioGroup rgExList;
    private SharedViewModel model;
    private boolean isFirst = false;
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
        prospectStageActivity = (ProspectStageActivity) getActivity();

        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        localSetting = new LocalSetting(getActivity());
        spinnerPreCity = view.findViewById(R.id.awe_spinner_visit_plan_city);
        spinnerPrePoliceStation = view.findViewById(R.id.awe_spinner_visit_plan_police_station);
        spinnerPerCity = view.findViewById(R.id.awe_spinner_visit_plan_city_per);
        spinnerPerPoliceStation = view.findViewById(R.id.awe_spinner_visit_plan_police_station_per);
        etName = view.findViewById(R.id.input_name);
        etAge = view.findViewById(R.id.input_age);
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
        etDob = view.findViewById(R.id.input_date_of_birth);
        etProductCat = view.findViewById(R.id.et_product_cat);
        tvPhotoIdNo = view.findViewById(R.id.tv_photo_id_no);
        llAddress = (LinearLayout) view.findViewById(R.id.ll_address);


        listCarloan = new ArrayList<String>();
        listHomeloan = new ArrayList<String>();
        listPersonalloan = new ArrayList<String>();
        listValidphoto = new ArrayList<String>();

        listCarloan.addAll(localSetting.getProductSubCategorystring(9));
        listHomeloan.addAll(localSetting.getProductSubCategorystring(8));
        listPersonalloan.addAll(localSetting.getProductSubCategorystring(10));


        spinnerProductCat = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_product_category);
        spinnerSub = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_product_detail);
        spinnerBranchName = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_branch);
        spinnerSegment = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_segment);
        spinnerDistOfBirth = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_district_of_birth);
        spinnerCountOfBirth = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_country_of_birth);
        spinnerProfession = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_profession);
        spinnerRelationship = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_relation_with_applicant);
        spinnerValidPhoto = (AwesomeSpinner) view.findViewById(R.id.awe_spinner_prospect_stage_valid_photo_id_type);

        liPhotoIdNo = view.findViewById(R.id.li_photo_id_no);

        initAdapters();
        initListener();


//        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
//
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear,
//                                  int dayOfMonth) {
//                // TODO Auto-generated method stub
//                myCalendar.set(Calendar.YEAR, year);
//                myCalendar.set(Calendar.MONTH, monthOfYear);
//                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                updateLabel();
//            }
//
//        };

        llAddress.setVisibility(View.GONE);

        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int mYear = calendar.get(Calendar.YEAR);
                int mMonth = calendar.get(Calendar.MONTH);
                int mDay = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialogCalculate = new DatePickerDialog(view.getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        datepickerListner, mYear, mMonth, mDay);
//                datePickerDialogCalculate.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialogCalculate.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialogCalculate.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialogCalculate.show();
            }
        });

//        etDob.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                datePickerDialog(getContext(),etDob);
//            }
//        });

        etPhotoIdDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog(getContext());
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private DatePickerDialog.OnDateSetListener datepickerListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            String myFormat = new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());
            etDob.setText(myFormat);
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

    public void datePickerDialog(Context context) {

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String selectedDate = (dayOfMonth + "." + month + "." + year);
                etPhotoIdDate.getText().clear();
                etPhotoIdDate.setText(selectedDate);
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


//    private void updateLabel() {
//        String myFormat = "dd.mm.yyyy"; //In which you need put here
//        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
//
//        etDob.setText(sdf.format(myCalendar.getTime()));
//        etPhotoIdDate.setText(sdf.format(myCalendar.getTime()));
//    }

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


        spinnerProductCat.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {

                productCat = s;

                if (isFirst) {

                    if (s.equalsIgnoreCase(AppConstant.HOME_LOAN)) {
                        productTypeCode = 8;
                        productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listHomeloan);
                        spinnerSub.setAdapter(productSubAdapter);
                    }
                    if (s.equalsIgnoreCase(AppConstant.CAR_LOAN)) {
                        productTypeCode = 9;
                        productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listCarloan);
                        spinnerSub.setAdapter(productSubAdapter);

                    }
                    if (s.equalsIgnoreCase(AppConstant.PERSONAL_LOAN)) {
                        productTypeCode = 10;
                        productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listPersonalloan);
                        spinnerSub.setAdapter(productSubAdapter);
                    }
                } else isFirst = true;
            }
        });


        spinnerSub.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                productSub = s;
                LongOperationSubCategory longOperationSubCategory = new LongOperationSubCategory();
                longOperationSubCategory.execute(i);
            }
        });

        spinnerBranchName.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                branchName = s;
                LongOperation longOperation = new LongOperation();
                longOperation.execute(i);
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

        spinnerValidPhoto.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                liPhotoIdNo.setVisibility(View.GONE);
                validPhoto = s;
                LongOperationPhotoIDCode longOperationPhotoIDCode = new LongOperationPhotoIDCode();
                longOperationPhotoIDCode.execute(i);
                getphotoIdNumber(s);


            }
        });

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

        etAge.setEnabled(false);

    }

    private void getphotoIdNumber(String type) {

        tvPhotoIdNo.setText("" + type + " No.");
        liPhotoIdNo.setVisibility(View.VISIBLE);
        photoIdType = type;


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

        ArrayAdapter<String> productCat = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getProductCategorystring());
        spinnerProductCat.setAdapter(productCat);

        ArrayAdapter<String> branchNameAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getBranchString());
        spinnerBranchName.setAdapter(branchNameAdapter);

        ArrayAdapter<String> segmentAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getSegmentString());
        spinnerSegment.setAdapter(segmentAdapter);

        ArrayAdapter<String> disBirthAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getCityStringList());
        spinnerDistOfBirth.setAdapter(disBirthAdapter);

        ArrayAdapter<String> disCountryAdater = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getCountryString());
        spinnerCountOfBirth.setAdapter(disCountryAdater);

        ArrayAdapter<String> professionAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getProfessionString());
        spinnerProfession.setAdapter(professionAdapter);

        ArrayAdapter<String> realationAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getIdlcRelationTypeStringList());
        spinnerRelationship.setAdapter(realationAdapter);

        ArrayAdapter<String> validPhotoIdAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, localSetting.getphotoIDTypestring());
        spinnerValidPhoto.setAdapter(validPhotoIdAdapter);

        if (prospectStageActivity.getDataFromProspect() != null) {

            MyNewProspect myNewLead = prospectStageActivity.getDataFromProspect();

            etName.setText(myNewLead.getUserName());
            etPresentAddress.setText(myNewLead.getAddress());
            etPermanentAddress.setText(myNewLead.getpAddress());
            etDesignation.setText(myNewLead.getDesignation());
            etMobileNumber.setText(myNewLead.getPhone());
            etCompanyName.setText(myNewLead.getOrganization());
            etNoYrsInCurrentJob.setText(myNewLead.getCurrentJob());

            etDob.setText(DateUtils.getDateFormateEt(CommonUtil.jsonToDate(myNewLead.getDateOfBirth())));
            if (myNewLead.getDateOfBirth() != null) {
                long timeinMIlis = DateUtils.getDateStringtoTimeInMinlis(DateUtils.getDateFormateEt(myNewLead.getDateOfBirth()));
                etAge.setText(MasumCommonUtils.calcutateAge(timeinMIlis));
            }

            etETin.setText(myNewLead.getEtin());
            etFatherName.setText(myNewLead.getfName());
            etMotherName.setText(myNewLead.getmName());
            etSpouseName.setText(myNewLead.getsName());
            etPhotoIdDate.setText(DateUtils.getDateFormateEt(myNewLead.getpIssueDate()));
            if (!MasumCommonUtils.isNullStr(myNewLead.getDob())) {
                try {
                    spinnerDistOfBirth.setSelection(disBirthAdapter.getPosition(myNewLead.getDob()));

                } catch (final IllegalStateException e) {

                }
            }
            if (!MasumCommonUtils.isNullStr(myNewLead.getCob()))
                try {
                    spinnerCountOfBirth.setSelection(disCountryAdater.getPosition(myNewLead.getCob()));

                } catch (final IllegalStateException e) {

                }
            if (!MasumCommonUtils.isNullStr(myNewLead.getpIDType())) {
                String pIdTypeStr = localSetting.getPhotoIdTypeStrByCode(Integer.parseInt(myNewLead.getpIDType()));

                try {
                    spinnerValidPhoto.setSelection(validPhotoIdAdapter.getPosition(pIdTypeStr));
                    getphotoIdNumber(myNewLead.getpIDType());

                } catch (IllegalStateException er) {

                }
            } else {
                liPhotoIdNo.setVisibility(View.GONE);
            }

            if (!MasumCommonUtils.isNullStr(myNewLead.getSegment())) {
                try {
                    spinnerSegment.setSelection(segmentAdapter.getPosition(myNewLead.getSegment()));

                } catch (IllegalStateException er) {

                }
            }

            getphotoIdNumber(myNewLead.getpIDType());
            etPhotoId.setText(myNewLead.getpIdNumber());
            if (!MasumCommonUtils.isNullStr(myNewLead.getBranchName())) {
                branchCode = localSetting.getBranchCodeByName(myNewLead.getBranchName());
                try {
                    spinnerBranchName.setSelection(branchNameAdapter.getPosition(myNewLead.getBranchName()));

                } catch (final IllegalStateException ignored) {

                }
            }

            if (myNewLead.getBrandName() != null) {

            }
            if (!MasumCommonUtils.isNullStr(myNewLead.getProductType())) {
                try {
                    spinnerProductCat.setSelection(productCat.getPosition(myNewLead.getProductType()));
                } catch (final IllegalStateException ignored) {
                }
                etProductCat.setText(myNewLead.getProductType());
                etProductCat.setVisibility(View.VISIBLE);
            } else {
                spinnerProductCat.setVisibility(View.VISIBLE);
                etProductCat.setVisibility(View.GONE);
            }


            if (!MasumCommonUtils.isNullStr(myNewLead.getProductType())) {
                if (myNewLead.getProductType().equalsIgnoreCase(AppConstant.HOME_LOAN)) {
                    productTypeCode = 8;
                    productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listHomeloan);
                    spinnerSub.setAdapter(productSubAdapter);
                }
                if (myNewLead.getProductType().equalsIgnoreCase(AppConstant.CAR_LOAN)) {
                    productTypeCode = 9;
                    productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listCarloan);
                    spinnerSub.setAdapter(productSubAdapter);

                }
                if (myNewLead.getProductType().equalsIgnoreCase(AppConstant.PERSONAL_LOAN)) {
                    productTypeCode = 10;
                    productSubAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listPersonalloan);
                    spinnerSub.setAdapter(productSubAdapter);
                }

                if (!MasumCommonUtils.isNullStr(myNewLead.getProductSubcategory())) {
                    productSub = myNewLead.getProductSubcategory();
                    try {
                        spinnerSub.setSelection(productSubAdapter.getPosition(myNewLead.getProductSubcategory()));
                    } catch (IllegalStateException e) {

                    }
                }


            }


            if (!MasumCommonUtils.isNullStr(myNewLead.getProfession())) {
                try {
                    spinnerProfession.setSelection(professionAdapter.getPosition(myNewLead.getProfession()));

                } catch (final IllegalStateException ignored) {

                }
            }

            if (!MasumCommonUtils.isNullStr(myNewLead.getApplicant())) {
                try {
                    spinnerRelationship.setSelection(realationAdapter.getPosition(myNewLead.getApplicant()));
                } catch (final IllegalStateException ignored) {

                }
            }

            if (!MasumCommonUtils.isNullStr(myNewLead.getPresAddressCity())) {
                try {
                    spinnerPreCity.setSelection(preCityAdapter.getPosition(myNewLead.getPresAddressCity()));
                } catch (final IllegalStateException ignored) {

                }
            }
            if (!MasumCommonUtils.isNullStr(myNewLead.getPresAddressPs())) {
                try {
                    spinnerPrePoliceStation.setSelection(prePolishStationAdapter.getPosition(myNewLead.getPresAddressPs()));
                } catch (final IllegalStateException ignored) {

                }
            }
            if (!MasumCommonUtils.isNullStr(myNewLead.getPermAddressCity())) {
                try {
                    spinnerPerCity.setSelection(perCityAdapter.getPosition(myNewLead.getPermAddressCity()));
                } catch (final IllegalStateException ignored) {

                }
            }
            if (!MasumCommonUtils.isNullStr(myNewLead.getPermAddressPs())) {
                try {
                    spinnerPerPoliceStation.setSelection(perPolishStationAdapter.getPosition(myNewLead.getPermAddressPs()));
                } catch (final IllegalStateException ignored) {

                }
            }

        }

    }


    private void setDataFromProspect(ArrayAdapter<CharSequence> adapter) {


    }

    private class LongOperation extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... params) {
            branchCode = localSetting.getBranchCode(params[0]);
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

    private class LongOperationSubCategory extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... params) {
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


}
