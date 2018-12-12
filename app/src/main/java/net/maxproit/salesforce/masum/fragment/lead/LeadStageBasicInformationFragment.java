package net.maxproit.salesforce.masum.fragment.lead;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseFragment;
import net.maxproit.salesforce.feature.search.SearchUserActivity;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce.model.setting.LocalSetting;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LeadStageBasicInformationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LeadStageBasicInformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeadStageBasicInformationFragment extends BaseFragment {


    private MyLeadDbController myLeadDbController;
    private ArrayList<MyNewLead> myNewLeadArrayList;
    private AwesomeSpinner spinnerBranchName, spinnerProfession, spinnerCity, spinnerPoliceStation;
    public static EditText etUserName, etUserOrganization, etDesignattion, etPhone, etAddress;
    public static String profession = "", branchName = "", branchCode = "", city = "", policeStation = "";
    private List<String> listPs = null;
    private List<String> listProfessionArray = null;
    private SpinnerDbController spinnerDbController;
    public CheckBox cbExist;
    public TextView etChif;
    public LinearLayout liChif;
    private LocalSetting mLocalSettting;
    private ArrayAdapter<String> polishStationAdapter;
    public static final int SERCH_CODE = 500;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    public LeadStageBasicInformationFragment() {
        // Required empty public constructor
        Log.e("crash", "basic");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeadStageBasicInformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeadStageBasicInformationFragment newInstance(String param1, String param2) {
        LeadStageBasicInformationFragment fragment = new LeadStageBasicInformationFragment();
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
        mLocalSettting = new LocalSetting(getActivity());
        listPs = new ArrayList<>();
        View rootView = null;
        rootView = inflater.inflate(R.layout.fragment_lead_stage_basic_information, container, false);
        initView(rootView);
        initListener();
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    protected Integer layoutResourceId() {
        return null;
    }

    @Override
    protected void initFragmentComponents() {

    }


    private void initListener() {

        spinnerBranchName.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                branchName = s;
                LongOperation longOperation = new LongOperation();
                longOperation.execute(i);
            }
        });

        spinnerProfession.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                profession = s;
            }
        });

        spinnerCity.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                city = s;
                if (!listPs.isEmpty())
                    listPs.clear();
                listPs.addAll(mLocalSettting.getpsListByCityCode(i));
                polishStationAdapter.notifyDataSetChanged();
            }

        });

        spinnerPoliceStation.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                policeStation = s;
            }
        });

    }

    private void initView(View rootView) {

        spinnerDbController = new SpinnerDbController(getActivity());
        spinnerCity = rootView.findViewById(R.id.awe_spinner_visit_plan_city);
        spinnerPoliceStation = rootView.findViewById(R.id.awe_spinner_visit_plan_police_station);
        spinnerBranchName = rootView.findViewById(R.id.awe_spinner_lead_branch_name);
        spinnerProfession = rootView.findViewById(R.id.awe_spinner_lead_profession);
        etUserName = rootView.findViewById(R.id.et_lead_user_name);
        etUserOrganization = rootView.findViewById(R.id.et_lead_organization);
        etDesignattion = rootView.findViewById(R.id.et_lead_designation);
        etPhone = rootView.findViewById(R.id.et_lead_phone);
        etAddress = rootView.findViewById(R.id.et_lead_address);

        cbExist = rootView.findViewById(R.id.cb_exist);
        etChif = rootView.findViewById(R.id.etChif);
        liChif = rootView.findViewById(R.id.liChif);

        cbExist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    liChif.setVisibility(View.VISIBLE);
                } else {
                    liChif.setVisibility(View.GONE);
                }
            }
        });

        etChif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getContext(), SearchUserActivity.class), SERCH_CODE);
            }
        });


//        if (!LeadStageActivity.visitPlan.getClientName().equals(null)) {
//            etUserName.setText(LeadStageActivity.visitPlan.getMobileNumber());
//            etPhone.setText(LeadStageActivity.visitPlan.getPoliceStation());
//        }

        etPhone.addTextChangedListener(new TextWatcher() {
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
                    etPhone.setError("You entered invalid mobile no.");
                }


//                Toast.makeText(getContext(), charSequence.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        initSpinnerAdapter();

    }


    private void initSpinnerAdapter() {

        ArrayAdapter<String> branchAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, mLocalSettting.getBranchString());
        spinnerBranchName.setAdapter(branchAdapter);

        ArrayAdapter<String> professionAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, mLocalSettting.getProfessionString());
        spinnerProfession.setAdapter(professionAdapter);

        polishStationAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listPs);
        spinnerPoliceStation.setAdapter(polishStationAdapter);

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, mLocalSettting.getCityStringList());
        spinnerCity.setAdapter(cityAdapter);
        if (getArguments() != null) {
            int status = getArguments().getInt(AppConstant.STATUS_INTENT_KEY);

            if (status == 0) {
                VisitPlan visitPlan = (VisitPlan) getArguments().getSerializable(AppConstant.INTENT_KEY);
                if (visitPlan != null) {
                    etUserName.setText(visitPlan.getClientName());
                    etPhone.setText(visitPlan.getMobileNumber());
                    if (!MasumCommonUtils.isNullStr(visitPlan.getCity())) {
                        try {
                            spinnerCity.setSelection(cityAdapter.getPosition(visitPlan.getCity()));
                        } catch (IllegalStateException i) {

                        }


                        if (!listPs.isEmpty())
                            listPs.clear();
                        listPs.addAll(mLocalSettting.getpsListByCityCode(spinnerCity.getSelectedItemPosition()));
                        polishStationAdapter.notifyDataSetChanged();
                    }

                    try {
                        spinnerPoliceStation.setSelection(polishStationAdapter.getPosition(visitPlan.getPoliceStation()));
                    } catch (IllegalStateException i) {

                    }
                }
            } else {
                initLoader();
                MyNewLead myNewLead = (MyNewLead) getArguments().getSerializable(AppConstant.INTENT_KEY);
                if (myNewLead != null) {
                    etUserName.setText(myNewLead.getUserName());
                    etPhone.setText(myNewLead.getPhone());
                    etAddress.setText(myNewLead.getAddress());
                    etUserOrganization.setText(myNewLead.getOrganization());
                    etDesignattion.setText(myNewLead.getDesignation());
                    if (!MasumCommonUtils.isNullStr(myNewLead.getBranchName())) {
                        try {
                            spinnerBranchName.setSelection(branchAdapter.getPosition(myNewLead.getBranchName()));
                        } catch (final IllegalStateException ignored) {
                        } catch (NullPointerException e) {
                        }
                    }
                    if (!MasumCommonUtils.isNullStr(myNewLead.getProfession())) {
                        try {
                            spinnerProfession.setSelection(professionAdapter.getPosition(myNewLead.getProfession()));
                        } catch (final IllegalStateException ignored) {
                        }
                    }

                    if (!MasumCommonUtils.isNullStr(myNewLead.getCity())) {
                        try {
                            spinnerCity.setSelection(cityAdapter.getPosition(myNewLead.getCity()));
                        } catch (final IllegalStateException ignored) {
                        }


                        if (!listPs.isEmpty())
                            listPs.clear();
                        listPs.addAll(mLocalSettting.getpsListByCityCode(spinnerCity.getSelectedItemPosition()));
                        polishStationAdapter.notifyDataSetChanged();
                    }

                    if (!MasumCommonUtils.isNullStr(myNewLead.getPs())) {
                        try {
                            spinnerPoliceStation.setSelection(polishStationAdapter.getPosition(myNewLead.getPs()));
                        } catch (final IllegalStateException ignored) {
                        }
                    }


                }
                hideLoader();


            }

        }

//        ArrayAdapter<String> professionAdapter = new ArrayAdapter.createFromResource(getContext(),
//                R.array.profession_array,
//                android.R.layout.simple_spinner_item);
//        spinnerProfession.setAdapter(professionAdapter, 0);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    private void getDataFromServer(String ref) {
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

    private class LongOperation extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... params) {
            branchCode = mLocalSettting.getBranchCode(params[0]);
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
