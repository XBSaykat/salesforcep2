package net.maxproit.salesforce2.masum.fragment.prospect.prospectstage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseFragment;
import net.maxproit.salesforce2.masum.activity.prospect.co_applicant.CoApplicantActivity;
import net.maxproit.salesforce2.masum.adapter.adapter.CoApplicantListAdapter;
import net.maxproit.salesforce2.masum.appdata.AppConstant;
import net.maxproit.salesforce2.masum.appdata.sqlite.CoApplicantDBController;
import net.maxproit.salesforce2.masum.model.api.coapplicant.DeleteCoApplicantresponse;
import net.maxproit.salesforce2.masum.model.local.CoApplicant;
import net.maxproit.salesforce2.masum.model.local.MyNewProspect;
import net.maxproit.salesforce2.masum.utility.ActivityUtils;
import net.maxproit.salesforce2.masum.utility.DividerItemDecoration;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProspectStageCoApplicantFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProspectStageCoApplicantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProspectStageCoApplicantFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    boolean isFirst = false;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnCoApplicant;
    private RecyclerView rvCoapplicantList;
    CoApplicantListAdapter coApplicantAdapter;
    private ArrayList<CoApplicant> coApplicantList, filteredList;
    private CoApplicantDBController coApplicantDBController;
    //    private MyNewLead mylead;
    String refId = null;
    int size = 0;
    MyNewProspect mylead = null;
    int leadIdForCoApplicant;

    private OnFragmentInteractionListener mListener;

    public ProspectStageCoApplicantFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProspectStageCoApplicantFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProspectStageCoApplicantFragment newInstance(String param1, String param2) {
        ProspectStageCoApplicantFragment fragment = new ProspectStageCoApplicantFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prospect_stage_co_applicent, container, false);

        btnCoApplicant = view.findViewById(R.id.btn_prospect_stage_co_applicant);
        rvCoapplicantList = view.findViewById(R.id.rv_prospect_stage_co_applicant);
        coApplicantDBController = new CoApplicantDBController(getActivity());
        if (getArguments() != null) {
            MyNewProspect mylead = (MyNewProspect) getArguments().getSerializable(AppConstant.INTENT_KEY);
            if (mylead.getCoApplicantList() != null) {
                AppConstant.coAppLicantStaticList.addAll(mylead.getCoApplicantList());

            }
            refId = mylead.getRefNumber();
            leadIdForCoApplicant = mylead.getId();
            coApplicantList = new ArrayList<>();
            filteredList = new ArrayList<>();
            coApplicantAdapter = new CoApplicantListAdapter(getContext(), coApplicantList);
            initListener(mylead);
        }


        return view;
    }

    @Override
    protected Integer layoutResourceId() {
        return null;
    }

    @Override
    protected void initFragmentComponents() {

    }

    private void loadCoapplicants() {
        if (!coApplicantList.isEmpty()) {
            coApplicantList.clear();
        }
        coApplicantList.addAll(AppConstant.coAppLicantStaticList);
        viewListItems();

        coApplicantAdapter.notifyDataSetChanged();
    }

    private void viewListItems() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvCoapplicantList.setLayoutManager(mLayoutManager);
        rvCoapplicantList.addItemDecoration(new DividerItemDecoration(getActivity(), ((LinearLayoutManager) mLayoutManager).VERTICAL, 16));
        rvCoapplicantList.setAdapter(coApplicantAdapter);


    }

    @Override
    public void onResume() {
        super.onResume();
        loadCoapplicants();
    }

    private void initListener(MyNewProspect myNewLead) {


        btnCoApplicant.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), CoApplicantActivity.class);
            intent.putExtras(getAddress());
            startActivityForResult(intent, 1);
        });

        coApplicantAdapter.setItemClickListener((view, position) -> {
            switch (view.getId()) {
                case R.id.btn_reject:
                    alertDialog(position, myNewLead.getRefNumber());
                    break;
                default:
                    sentDataToCoApplicant(position);
                    break;
            }

        });
    }


    private void alertDialog(int position, String refNumber) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }
        builder.setTitle(getString(R.string.Reject));
        builder.setMessage(getString(R.string.reject_item));
        builder.setNegativeButton(getString(R.string.no), null);
        builder.setPositiveButton(getString(R.string.yes), (dialog, which) -> {
            if (isNetworkAvailable()) {
                int cusId = AppConstant.coAppLicantStaticList.get(position).getCustomerId();
                if (AppConstant.coAppLicantStaticList.get(position).getCustomerId() > 0) {
                    getApiService().deleteCoApplicant(refNumber, cusId).enqueue(new Callback<DeleteCoApplicantresponse>() {
                        @Override
                        public void onResponse(Call<DeleteCoApplicantresponse> call, Response<DeleteCoApplicantresponse> response) {
                            if (response.isSuccessful()) {
                                if (response.body().getCode().equals(getString(R.string.success_code))) {
                                    AppConstant.coAppLicantStaticList.remove(position);
                                    coApplicantList.remove(position);
                                    coApplicantAdapter.notifyDataSetChanged();
                                    showAlertDialog(response.body().getCode(),response.body().getMessage());

                                } else {
                                    showAlertDialog(response.body().getCode(),response.body().getMessage());

                                }

                            } else {
                                showAlertDialog(getString(R.string.error_text),response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<DeleteCoApplicantresponse> call, Throwable t) {
                            showAlertDialog(getString(R.string.error_text),t.getMessage());
                        }
                    });

                } else {
                    AppConstant.coAppLicantStaticList.remove(position);
                    coApplicantList.remove(position);
                    coApplicantAdapter.notifyDataSetChanged();
                }
            }

        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private Bundle getAddress() {
        Bundle bundle = new Bundle();

        bundle.putString(AppConstant.LEAD_ID_FOR_CO_INTENT_KEY, refId);
        bundle.putString(AppConstant.PRESENT_ADDRESSS_KEY, ProspectStageProductAndCustomerDetailsFragment.etPresentAddress.getText().toString());
        bundle.putString(AppConstant.PERMANENT_ADDRESSS_KEY, ProspectStageProductAndCustomerDetailsFragment.etPermanentAddress.getText().toString());
        bundle.putString(AppConstant.PRESENT_ADDRESSS_CITY_KEY, ProspectStageProductAndCustomerDetailsFragment.preCity);
        bundle.putString(AppConstant.PRESENT_ADDRESSS_PS_KEY, ProspectStageProductAndCustomerDetailsFragment.prePoliceStation);
        bundle.putString(AppConstant.PERMANENT_ADDRESSS_CITY_KEY, ProspectStageProductAndCustomerDetailsFragment.perCity);
        bundle.putString(AppConstant.PERMANENT_ADDRESSS_PS_KEY, ProspectStageProductAndCustomerDetailsFragment.perPoliceStation);
        return bundle;

    }

    private void sentDataToCoApplicant(int position) {

        CoApplicant coApplicant = new CoApplicant(coApplicantList.get(position).getId(),
                coApplicantList.get(position).getLeadId(),
                coApplicantList.get(position).getName(),
                coApplicantList.get(position).getDateOfBirth(),
                coApplicantList.get(position).getAge(),
                coApplicantList.get(position).getDistrictOfBirth(),
                coApplicantList.get(position).getCountryOfBirth(),
                String.valueOf(coApplicantList.get(position).getPhotoIdCode()),
                coApplicantList.get(position).getPhotoIdNo(),
                coApplicantList.get(position).getPhotoIdIssueDate(),
                coApplicantList.get(position).geteTin(),
                coApplicantList.get(position).getfName(),
                coApplicantList.get(position).getmName(),
                coApplicantList.get(position).getsName(),
                coApplicantList.get(position).getProfession(),
                coApplicantList.get(position).getExceptionList(),
                coApplicantList.get(position).getCompanyName(),
                coApplicantList.get(position).getDesignation(),
                coApplicantList.get(position).getNoOfYrsInCurrentJob(),
                coApplicantList.get(position).getRelationWithApplicant(),
                coApplicantList.get(position).getPermanentAddress(),
                coApplicantList.get(position).getPresentAddress(),
                coApplicantList.get(position).getMobileNo(),
                coApplicantList.get(position).getMonthSalaryType(),
                coApplicantList.get(position).getMonthSalaryAmount(),
                coApplicantList.get(position).getMonthBusinessIncomeAmount(),
                coApplicantList.get(position).getMonthWareHouseAmount(),
                coApplicantList.get(position).getMonthOfficeSpaceIncomeAmount(),
                coApplicantList.get(position).getMonthSemipakaIncomeAmount(),
                coApplicantList.get(position).getMonthApartmentIncomeAmount(),
                coApplicantList.get(position).getMonthAgricultureIncomeAmount(),
                coApplicantList.get(position).getMonthTuitionIncomeAmount(),
                coApplicantList.get(position).getRemittance(),
                coApplicantList.get(position).getInterestFDRIncomeAmount(),
                coApplicantList.get(position).getMonthFamilyExpenditure(),
                coApplicantList.get(position).getEmiOfOtherLoans()
        );

        coApplicant.setCustomerId(coApplicantList.get(position).getCustomerId());
        coApplicant.setContactId(coApplicantList.get(position).getContactId());
        coApplicant.setMobileNoId(coApplicantList.get(position).getMobileNoId());
        coApplicant.setPresentAddressId(coApplicantList.get(position).getPresentAddressId());
        coApplicant.setPermanentAddressId(coApplicantList.get(position).getPermanentAddressId());
        coApplicant.setPresentAddressCity(coApplicantList.get(position).getPresentAddressCity());
        coApplicant.setPermanentAddressCity(coApplicantList.get(position).getPermanentAddressCity());
        coApplicant.setPresentAddressPS(coApplicantList.get(position).getPresentAddressPS());
        coApplicant.setPermanentAddressPS(coApplicantList.get(position).getPermanentAddressPS());
        coApplicant.setPhotoIdCode(coApplicantList.get(position).getPhotoIdCode());

        coApplicant.setTitleName(coApplicantList.get(position).getTitleName());
        coApplicant.setTitlefName(coApplicantList.get(position).getTitlefName());
        coApplicant.setTitlemName(coApplicantList.get(position).getTitlemName());
        coApplicant.setTitlesName(coApplicantList.get(position).getTitlesName());

        ActivityUtils.invokCoApplicantViewStage(getActivity(), CoApplicantActivity.class, coApplicant, position, getAddress());

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
