package net.maxproit.salesforce.masum.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.appdata.sqlite.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.MyLeadDbController;
import net.maxproit.salesforce.masum.model.MyNewLead;
import net.maxproit.salesforce.masum.appdata.sqlite.SpinnerDbController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LeadStageVisitRecordFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LeadStageVisitRecordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeadStageVisitRecordFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private AwesomeSpinner spinnerFollowUp, spinnerRemarks;
    public static String followUp = null, visitDate = null, remark = null;
    public  EditText etVisitDate, etRemark;
    private LinearLayout followDateLayout, etRemarksLayout, spRemarksLayout;
    private ArrayList<MyNewLead> myNewLeadArrayList;
    private MyLeadDbController myLeadDbController;
    private SpinnerDbController spinnerDbController;

    private List<String> listfollowUp=null;
    private List<String> listRemark=null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public LeadStageVisitRecordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeadStageVisitRecordFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeadStageVisitRecordFragment newInstance(String param1, String param2) {
        LeadStageVisitRecordFragment fragment = new LeadStageVisitRecordFragment();
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
        View rootView=null;
        rootView=inflater.inflate(R.layout.fragment_lead_stage_visit_record, container, false);
        initView(rootView);
        initListener();
        return rootView;
        // Inflate the layout for this fragment
    }

    private void initView(View rootView) {

        spinnerDbController =new SpinnerDbController(getActivity());

        listfollowUp = new ArrayList<String>();
        listRemark = new ArrayList<String>();

        listfollowUp.addAll(spinnerDbController.getFollowUpData());
        listRemark.addAll(spinnerDbController.getRemarkData());

        spinnerFollowUp=rootView.findViewById(R.id.awe_spinner_lead_follow_up);
        spinnerRemarks=rootView.findViewById(R.id.sp_remarks);
        followDateLayout = rootView.findViewById(R.id.follow_date_layout);
        followDateLayout.setVisibility(View.GONE);
        etVisitDate=rootView.findViewById(R.id.dtpVisitDT);
        etRemark=rootView.findViewById(R.id.input_remarks);
        remark = etRemark.getText().toString();

        etRemarksLayout = rootView.findViewById(R.id.et_remarks_layout);
        spRemarksLayout = rootView.findViewById(R.id.sp_remarks_layout);
        spRemarksLayout.setVisibility(View.GONE);

        initSpinnerAdapter();
    }

    private void initSpinnerAdapter() {
//        ArrayAdapter<CharSequence> decisionAdapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.decision_array,
//                android.R.layout.simple_spinner_dropdown_item);
//        spinnerFollowUp.setAdapter(decisionAdapter, 0);

        ArrayAdapter<String> followUp=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listfollowUp);
        spinnerFollowUp.setAdapter(followUp);

        ArrayAdapter<String> remark=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listRemark);
        spinnerRemarks.setAdapter(remark);

//        ArrayAdapter<CharSequence> remarksAdapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.remarks_arr,
//                android.R.layout.simple_spinner_dropdown_item);
//        spinnerRemarks.setAdapter(remarksAdapter, 0);

    }


    private void initListener(){

        if (getArguments() != null){
            int position = getArguments().getInt(AppConstant.LEAD_INTENT_KEY);
            myLeadDbController = new MyLeadDbController(getActivity());
            myNewLeadArrayList = new ArrayList<>();
            myNewLeadArrayList.addAll(myLeadDbController.getAllData());

            etVisitDate.setText(myNewLeadArrayList.get(position).getVisitDate());
            etRemark.setText(myNewLeadArrayList.get(position).getRemark());


        }

        spinnerFollowUp.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                followUp = s;

                if (s.equals("Yes")){
                    followDateLayout.setVisibility(View.VISIBLE);
                    etRemarksLayout.setVisibility(View.VISIBLE);
                    spRemarksLayout.setVisibility(View.GONE);
                }
                else {
                    followDateLayout.setVisibility(View.GONE);
                    etRemarksLayout.setVisibility(View.GONE);
                    spRemarksLayout.setVisibility(View.VISIBLE);
                }

            }

        });

        spinnerRemarks.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
            }

        });

//        spinnerFollowUp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                followUp= String.valueOf(position);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        etVisitDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog();
            }
        });
    }



    public void datePickerDialog(){

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String selectedDate = (dayOfMonth +"/"+ month +"/"+ year);
                etVisitDate.getText().clear();
                 etVisitDate.setText(selectedDate);
                visitDate = etVisitDate.getText().toString();
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                listener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

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
