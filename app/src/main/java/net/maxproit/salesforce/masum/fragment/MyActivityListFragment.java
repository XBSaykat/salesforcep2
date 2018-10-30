package net.maxproit.salesforce.masum.fragment;

import android.content.Context;
import android.content.Intent;
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

import net.maxproit.salesforce.masum.adapter.MyVisitPlanListAdapter;
import net.maxproit.salesforce.masum.activity.ActivityDetailsActivity;
import net.maxproit.salesforce.masum.sqlite.AppConstant;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.VisitPlan;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.masum.sqlite.VisitPlanDbController;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyActivityListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyActivityListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyActivityListFragment extends Fragment {


    MyVisitPlanListAdapter myLeadAdapter;
    VisitPlanDbController myDbController;
//    MyLeadDbController myDbController;
    private ImageView backButton, addButton;
    private SearchView searchView;
    private RecyclerView rvMyActivity;
    public static int itemPosition = 0;
    LocalLogin localLogin;
    String username;
    ArrayList<VisitPlan> leadList, filterList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    public MyActivityListFragment() {
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
    public static MyActivityListFragment newInstance(String param1, String param2) {
        MyActivityListFragment fragment = new MyActivityListFragment();
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
        myDbController = new VisitPlanDbController(getContext());
        username = SharedPreferencesEnum.getInstance(getContext()).getString(SharedPreferencesEnum.Key.USER_NAME);

        if (!leadList.isEmpty()) {
            leadList.clear();
        }
        leadList.addAll(myDbController.getAllData());

//        searchView = findViewById(R.id.search_view);
        rvMyActivity = rootView.findViewById(R.id.rv_my_activity);

//        backButton = findViewById(R.id.btn_back);
//        addButton = findViewById(R.id.btn_add);
//        rvMyLead = findViewById(R.id.rvMyLead);





//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                filterList = getFilterData(leadList, query);
//                myLeadAdapter.setFilter(filterList);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                // If remove data on test dataBase it Will be ok
//                // myLeadAdapter.getFilter().filter(newText);
//                filterList = getFilterData(leadList, newText);
//                myLeadAdapter.setFilter(filterList);
//                return true;
//            }
//        });


        myLeadAdapter = new MyVisitPlanListAdapter(getContext(), leadList);
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
            final String phone = model.getClientType().toLowerCase();

            if (uName.contains(searchKey) || phone.contains(searchKey)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

//    private void loadFilterData() {
//        if (!filterList.isEmpty()) {
//            filterList.clear();
//        }
//        filterList.addAll(myLeadAdapter.getDataList());
//    }




    private void initListener() {



        myLeadAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
//                loadFilterData();
                switch (view.getId()) {
                    case R.id.btnApproved:
                        Toast.makeText(getActivity(), "Approved", Toast.LENGTH_SHORT).show();
                        //insert data into prospect
//                          myDbController.updateLeadDataStatus(filterList.get(position).getId(),AppConstant.LEAD_STATUS_PROSPECT);
//                         removeItemFromList(position,AppConstant.LEAD_STATUS_PROSPECT);

                        break;
                    case R.id.btnReject:
                        Toast.makeText(getActivity(), "Rejected", Toast.LENGTH_SHORT).show();
//                         myLeadAdapter.updateLeadDataStatus(filterList.get(position).getId(),AppConstant.LEAD_STATUS_REJECT);
//                        removeItemFromList(position,AppConstant.LEAD_STATUS_REJECT);
                        break;

                    case R.id.cl_visit_plan_item:
                        itemPosition  = position;
                        Intent intentActivityDetails = new Intent(getActivity(), ActivityDetailsActivity.class);

                        intentActivityDetails.putExtra(AppConstant.INTENT_KEY, position);
                        startActivity(intentActivityDetails);
                        Toast.makeText(getActivity(), "item selected", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

    }
    private void removeItemFromList(int position,String status) {
        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == filterList.get(position).getId()) {
                leadList.get(i).setStatus(status);
                leadList.remove(i);
                myLeadAdapter.notifyItemRemoved(position);
                break;

            }
        }
    }

    private void changeItemStatus(int position,String status) {
        for (int i = 0; i < leadList.size(); i++) {
            if (leadList.get(i).getId() == filterList.get(position).getId()) {
                leadList.get(i).setStatus(status);
                myLeadAdapter.notifyDataSetChanged();
                break;

            }
        }
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
}
