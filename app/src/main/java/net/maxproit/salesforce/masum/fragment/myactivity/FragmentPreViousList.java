package net.maxproit.salesforce.masum.fragment.myactivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.activity.visitplan.MyActivitiesActivity;
import net.maxproit.salesforce.masum.activity.visitplan.VisitPLanDetailsActivity;

import net.maxproit.salesforce.masum.adapter.adapterplanlist.PreviousPlanListAdapter;
import net.maxproit.salesforce.masum.appdata.sqlite.FollowUpDbController;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DateUtils;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.text.ParseException;
import java.util.ArrayList;

public class FragmentPreViousList extends Fragment {


    private PreviousPlanListAdapter myLeadAdapter;
    private VisitPlanDbController myDbController;
    private FollowUpDbController followUpDbController;
    private static MyActivitiesActivity myActivitiesActivity;
    //    MyLeadDbController myDbController;
    private ImageView backButton, addButton;
    private SearchView searchView;
    private RecyclerView rvMyActivity;
    public static int itemPosition = 0;
    LocalLogin localLogin;
    String username;
    private ArrayList<VisitPlan> leadList, filterList,visitPlanList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private FragmentPreViousList.OnFragmentInteractionListener mListener;

    public FragmentPreViousList() {
        // Required empty public constructor
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
    public static FragmentPreViousList newInstance(String param1, String param2) {
        FragmentPreViousList fragment = new FragmentPreViousList();
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

        View rootView = null;
        rootView = inflater.inflate(R.layout.fragment_my_activity_list, container, false);
        leadList = new ArrayList<>();
        filterList = new ArrayList<>();
        visitPlanList = new ArrayList<>();
        myDbController = new VisitPlanDbController(getContext());
        followUpDbController = new FollowUpDbController(getContext());
        username = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.USER_NAME);
        myActivitiesActivity= (MyActivitiesActivity) getActivity();
        if (!leadList.isEmpty()) {
            leadList.clear();
        }
        if (!visitPlanList.isEmpty()){
            visitPlanList.clear();
        }
        if (!myDbController.getAllData().equals(null)){

            leadList.addAll(myDbController.getAllData());

            for (int i=0;i<leadList.size();i++){

                try {
                    if (DateUtils.isPending(leadList.get(i).getDateOfVisit())==1
                            || leadList.get(i).getStatus().equals(AppConstant.VISITED) ||
                            leadList.get(i).getStatus().equals(AppConstant.REJECTED)){
                        visitPlanList.add(leadList.get(i));
                    }
                    else if(followUpDbController.getAllData(leadList.get(i).getId()).size()>0){
                        visitPlanList.add(leadList.get(i));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


        }

        else {
            Toast.makeText(getActivity(), "NO DATA FOUND", Toast.LENGTH_SHORT).show();
        }

//        searchView = findViewById(R.id.search_view);
        rvMyActivity = rootView.findViewById(R.id.rv_my_activity);

//        backButton = findViewById(R.id.btn_back);
//        addButton = findViewById(R.id.btn_add);
//        rvMyLead = findViewById(R.id.rvMyLead);


//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                filterList = getFilterData(followUpList, query);
//                myLeadAdapter.setFilter(filterList);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                // If remove data on test dataBase it Will be ok
//                // myLeadAdapter.getFilter().filter(newText);
//                filterList = getFilterData(followUpList, newText);
//                myLeadAdapter.setFilter(filterList);
//                return true;
//            }
//        });


        myLeadAdapter = new PreviousPlanListAdapter(getActivity(), visitPlanList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvMyActivity.setLayoutManager(mLayoutManager);
        rvMyActivity.setAdapter(myLeadAdapter);
        myLeadAdapter.notifyDataSetChanged();

//        initView(rootView);
        initListener();
        // Inflate the layout for this fragment
        return rootView;


    }


    private ArrayList<VisitPlan> getFilterData(ArrayList<VisitPlan> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<VisitPlan> filteredModelList = new ArrayList<>();
        for (VisitPlan model : models) {
            final String uName = model.getCity().toLowerCase();
            final String type = model.getClientType().toLowerCase();
            final String name = model.getClientName().toLowerCase();
            final String mobile = model.getMobileNumber().toLowerCase();

            if (uName.contains(searchKey) || type.contains(searchKey) || name.contains(searchKey) || mobile.contains(searchKey) ) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
    private void loadFilterData() {
        if (!filterList.isEmpty()) {
            filterList.clear();
        }
        filterList.addAll(myLeadAdapter.getDataList());
    }


    private void initListener() {


        myLeadAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
                loadFilterData();
                switch (view.getId()) {
                    case R.id.cl_visit_plan_item:
                        sentDataToDetail(position);
                        break;

                }
            }
        });



    }

    public void beginSearching(String s){
        filterList= getFilterData(visitPlanList,s);
        myLeadAdapter.setFilter(filterList);
    }

    private void removeItemFromList(int position, String status) {
        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == filterList.get(position).getId()) {
                leadList.get(i).setStatus(status);
                leadList.remove(i);
                myLeadAdapter.notifyItemRemoved(position);
                break;

            }
        }
    }

    private void changeItemStatus(int position, String status) {
        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == filterList.get(position).getId()) {
                leadList.get(i).setStatus(status);
                myLeadAdapter.notifyDataSetChanged();
                break;

            }
        }
    }

    private void sentDataToDetail(int position) {
        VisitPlan visitPlan = new VisitPlan(
                filterList.get(position).getId(),
                filterList.get(position).getJournalId(),
                filterList.get(position).getClientName(),
                filterList.get(position).getClientType(),
                filterList.get(position).getMobileNumber(),
                filterList.get(position).getPoliceStation(),
                filterList.get(position).getProductType(),
                filterList.get(position).getCity(),
                filterList.get(position).getPurposeOfVisit(),
                filterList.get(position).getDateOfVisit(),
                filterList.get(position).getRemarks(),
                filterList.get(position).getStatus(),
                filterList.get(position).getSynStatus());
        ActivityUtils.invokVisitPlanDetail(getActivity(), VisitPLanDetailsActivity.class, visitPlan);
    }


    private void initView(View rootView) {


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

    public interface OnQueryChangeListener {
        void onQueryChange(String s);
    }
}
