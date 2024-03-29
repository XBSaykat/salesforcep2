package net.maxproit.salesforce2.masum.fragment.myactivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseFragment;
import net.maxproit.salesforce2.masum.activity.visitplan.MyActivitiesActivity;
import net.maxproit.salesforce2.masum.activity.visitplan.VisitPLanDetailsActivity;
import net.maxproit.salesforce2.masum.adapter.activity.MyVisitPlanListAdapter;
import net.maxproit.salesforce2.masum.appdata.AppConstant;
import net.maxproit.salesforce2.masum.listener.OnItemClickListener;
import net.maxproit.salesforce2.masum.model.api.myactivity.Data;
import net.maxproit.salesforce2.masum.model.api.myactivity.Datum;
import net.maxproit.salesforce2.masum.model.api.myactivity.MyActivityGetByJournalIdApi;
import net.maxproit.salesforce2.masum.model.api.myactivity.MyActivityGetDataApi;
import net.maxproit.salesforce2.masum.model.local.VisitPlan;
import net.maxproit.salesforce2.masum.appdata.sqlite.VisitPlanDbController;
import net.maxproit.salesforce2.masum.utility.ActivityUtils;
import net.maxproit.salesforce2.masum.utility.DateUtils;
import net.maxproit.salesforce2.model.login.LocalLogin;
import net.maxproit.salesforce2.util.CommonUtil;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentUpComingList extends BaseFragment {


    private MyVisitPlanListAdapter myLeadAdapter;
    private VisitPlanDbController myDbController;
    //    MyLeadDbController myDbController;
    private ImageView backButton, addButton;
    private SearchView searchView;
    private RecyclerView rvMyActivity;
    public static int itemPosition = 0;
    private static MyActivitiesActivity myActivitiesActivity;
    LocalLogin localLogin;
    String username;
    private ArrayList<VisitPlan> leadList, filterList, visitPlanList;
    private ArrayList<Datum> visitPlanApiList, visitPlanFilterApiList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private FragmentUpComingList.OnFragmentInteractionListener mListener;

    public FragmentUpComingList() {
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
    public static FragmentUpComingList newInstance(String param1, String param2) {
        FragmentUpComingList fragment = new FragmentUpComingList();
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
        visitPlanApiList = new ArrayList<>();
        visitPlanFilterApiList = new ArrayList<>();
        myDbController = new VisitPlanDbController(getContext());
        username = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.USER_NAME);
        myActivitiesActivity = (MyActivitiesActivity) getActivity();

        rvMyActivity = rootView.findViewById(R.id.rv_my_activity);
        myLeadAdapter = new MyVisitPlanListAdapter(getActivity(), visitPlanApiList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvMyActivity.setLayoutManager(mLayoutManager);
        rvMyActivity.setAdapter(myLeadAdapter);

//        initView(rootView);
        initListener();
        // Inflate the layout for this fragment

        return rootView;


    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    @Override
    protected Integer layoutResourceId() {
        return null;
    }

    @Override
    protected void initFragmentComponents() {

    }

    private void getData() {
        if (isNetworkAvailable()) {
            String random = UUID.randomUUID().toString();
            //int journalId, String clientName, String clientType,
            // String mobileNumber, String prePoliceStation, String productType, String preCity, String purposeOfVisit,
            // String dateOfVisit, String remarks, String status ,String synStatus
            if (!leadList.isEmpty()) {
                leadList.clear();
            }
            if (!visitPlanList.isEmpty()) {
                visitPlanList.clear();
            }
            getApiService().getActivityData(username, random).enqueue(new Callback<MyActivityGetDataApi>() {
                @Override
                public void onResponse(Call<MyActivityGetDataApi> call, Response<MyActivityGetDataApi> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {
                            for (int i = 0; i < response.body().getData().size(); i++) {
                                if (response.body().getData().get(i).getActivityType().equalsIgnoreCase(AppConstant.STATUS_FUTURE_ACTIVITY)) {
                                    visitPlanApiList.add(response.body().getData().get(i));
                                }
                            }
                            myLeadAdapter.notifyDataSetChanged();

                        } else if (response.body().getCode().equals("404")) {
                            showEmptyView();
                        }
                    } else {
                        showAlertDialog(getString(R.string.error_text) + " " + response.code(), response.message());
                    }

                }

                @Override
                public void onFailure(Call<MyActivityGetDataApi> call, Throwable t) {
                    showAlertDialog(getString(R.string.error_text), t.getMessage());

                }
            });
        } else {

            if (myDbController.getAllData().size() > 0) {
                leadList.addAll(myDbController.getPlanData());
                MyActivityGetDataApi myVisitPlanGetApi = new MyActivityGetDataApi();
                for (int i = 0; i < leadList.size(); i++) {
                    try {
                        if (DateUtils.isPending(leadList.get(i).getDateOfVisit()) == 2) {
                            visitPlanList.add(leadList.get(i));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                visitPlanApiList.addAll(myVisitPlanGetApi.getVisitPlanList(visitPlanList));
                myLeadAdapter.notifyDataSetChanged();
            }

        }
    }

    private ArrayList<Datum> getFilterData(ArrayList<Datum> models, CharSequence searchKey) {
        searchKey = searchKey.toString().toLowerCase();

        final ArrayList<Datum> filteredModelList = new ArrayList<>();
        for (Datum model : models) {
            final String uName = model.getActivityJournalID().toLowerCase();
            final String type = model.getClientType().toLowerCase();
            final String name = model.getClientName().toLowerCase();

            if (uName.contains(searchKey) || type.contains(searchKey) || name.contains(searchKey)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    private void loadFilterData() {
        if (!visitPlanFilterApiList.isEmpty()) {
            visitPlanFilterApiList.clear();
        }
        visitPlanFilterApiList.addAll(myLeadAdapter.getDataList());
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

    public void beginSearching(String s) {
        visitPlanFilterApiList = getFilterData(visitPlanApiList, s);
        myLeadAdapter.setFilter(visitPlanFilterApiList);
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
        if (isNetworkAvailable()) {
            String journalId = visitPlanFilterApiList.get(position).getActivityJournalID();
            String random = UUID.randomUUID().toString();
            getApiService().getActivityByJournalId(journalId, random).enqueue(new Callback<MyActivityGetByJournalIdApi>() {
                @Override
                public void onResponse(Call<MyActivityGetByJournalIdApi> call, Response<MyActivityGetByJournalIdApi> response) {
                    Data data = response.body().getData();
                    String followupDate = null;
                    String activityDate = null;
                    if (data.getFollowupDate() != null) {
                        followupDate = CommonUtil.jsonToDate(data.getFollowupDate());
                    }
                    if (data.getActivityDate() != null) {
                        activityDate = CommonUtil.jsonToDate(data.getActivityDate());
                    }
                    VisitPlan visitPlan = new VisitPlan(data.getActivityJournalID(), data.getCustomerName()
                            , data.getClientType(), data.getMobileNo(), data.getPs(),
                            data.getProductType(), data.getCity(), data.getVisitPurposeType(),
                            activityDate, data.getRemarks(), data.getActivityStatus(), followupDate, data.getFollowupRemarks());

                    ActivityUtils.invokVisitPlanDetail(getActivity(), VisitPLanDetailsActivity.class, visitPlan);

                }

                @Override
                public void onFailure(Call<MyActivityGetByJournalIdApi> call, Throwable t) {
                    showAlertDialog("Error", t.getMessage());

                }
            });
        } else {
            int id = visitPlanFilterApiList.get(position).getId();
            VisitPlan visitPlan = myDbController.getAllData(id).get(0);
            ActivityUtils.invokVisitPlanDetail(getActivity(), VisitPLanDetailsActivity.class, visitPlan);
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

    public interface OnQueryChangeListener {
        void onQueryChange(String s);
    }
}
