package net.maxproit.salesforce.masum.fragment.prospect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.activity.prospect.co_applicant.CoApplicantActivity;
import net.maxproit.salesforce.masum.adapter.adapter.CoApplicantListAdapter;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.CoApplicantDBController;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.local.CoApplicant;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DividerItemDecoration;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProspectStageCoApplicantFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProspectStageCoApplicantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProspectStageCoApplicantFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnCoApplicant;
    private RecyclerView rvCoapplicantList;
    CoApplicantListAdapter coApplicantAdapter;
    private ArrayList<CoApplicant> coApplicantList, filteredList;
    private CoApplicantDBController coApplicantDBController;
//    private MyNewLead mylead;


    private static ProspectStageActivity prospectStageActivity;
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
        prospectStageActivity = (ProspectStageActivity) getActivity();
        btnCoApplicant = view.findViewById(R.id.btn_prospect_stage_co_applicant);
        rvCoapplicantList = view.findViewById(R.id.rv_prospect_stage_co_applicant);
        coApplicantDBController = new CoApplicantDBController(getActivity());

        MyNewLead mylead = prospectStageActivity.getDataFromProspect();
        leadIdForCoApplicant = mylead.getId();
        coApplicantList = new ArrayList<>();
        filteredList = new ArrayList<>();
        coApplicantAdapter = new CoApplicantListAdapter(getContext(), coApplicantList);
        initListener(mylead);
        return view;
    }

    private void loadCoapplicants() {
        if (!coApplicantList.isEmpty()) {
            coApplicantList.clear();
        }

        coApplicantList.addAll(coApplicantDBController.getAllData(leadIdForCoApplicant));
        viewListItems();
        if (coApplicantList.size()>0){
            Collections.reverse(coApplicantList);

        }
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

    private void initListener(MyNewLead myNewLead) {


        btnCoApplicant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), CoApplicantActivity.class);
                intent.putExtra(AppConstant.LEAD_ID_FOR_CO_INTENT_KEY, leadIdForCoApplicant);
                startActivityForResult(intent, 1);

            }
        });

        coApplicantAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
               sentDataToCoApplicant(position);

            }
        });
    }

    private void sentDataToCoApplicant(int position) {

        CoApplicant coApplicant=new CoApplicant(coApplicantList.get(position).getId(),
        coApplicantList.get(position).getLeadId(),
        coApplicantList.get(position).getName(),
        coApplicantList.get(position).getDateOfBirth(),
        coApplicantList.get(position).getAge(),
        coApplicantList.get(position).getDistrictOfBirth(),
        coApplicantList.get(position).getCountryOfBirth(),
        coApplicantList.get(position).getPhotoIdType(),
        coApplicantList.get(position).getPhotoIdNo(),
        coApplicantList.get(position).getPhotoIdIssueDate(),
        coApplicantList.get(position).geteTin(),
        coApplicantList.get(position).getfName(),
        coApplicantList.get(position).getmName(),
        coApplicantList.get(position).getsName(),
        coApplicantList.get(position).getProfession(),
        coApplicantList.get(position).getExList(),
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

        ActivityUtils.invokCoApplicantViewStage(getActivity(),CoApplicantActivity.class,coApplicant);

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
