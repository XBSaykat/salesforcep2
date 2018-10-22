package net.maxproit.idlc.feature.masum;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.idlc.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PreviousActivitiesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PreviousActivitiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreviousActivitiesFragment extends Fragment {



    private AwesomeSpinner spinnerBranchName, spinnerProfession;
    public static EditText etUserName, etUserOrganization, etDesignattion, etPhone, etAddress;
    public static String profession = null, branchName = null;
    private String[] branchArray={"Mirpur","SegunBagicha","Polton","Dhanmondi","Azimpur"};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    public PreviousActivitiesFragment() {
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
    public static PreviousActivitiesFragment newInstance(String param1, String param2) {
        PreviousActivitiesFragment fragment = new PreviousActivitiesFragment();
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
        rootView = inflater.inflate(R.layout.fragment_my_activities_previous, container, false);
        initView(rootView);
        initListener();
        // Inflate the layout for this fragment
        return rootView;
    }



    private void initListener() {
        spinnerBranchName.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                branchName = s;
            }
        });

        spinnerProfession.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                profession = s;
            }
        });


//        spinnerProfession.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                profession= String.valueOf(position);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });


//        spinnerBranchName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                branchName=branchArray[position];
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

    private void initView(View rootView) {
        spinnerBranchName = rootView.findViewById(R.id.awe_spinner_lead_branch_name);
        spinnerProfession = rootView.findViewById(R.id.awe_spinner_lead_profession);
        etUserName = rootView.findViewById(R.id.et_lead_user_name);
        etUserOrganization = rootView.findViewById(R.id.et_lead_organization);
        etDesignattion = rootView.findViewById(R.id.et_lead_designation);
        etPhone = rootView.findViewById(R.id.et_lead_phone);
        etAddress = rootView.findViewById(R.id.et_lead_address);
        initSpinnerAdapter();
     }

    private void initSpinnerAdapter() {
        ArrayAdapter<CharSequence> branchAdapter=ArrayAdapter.createFromResource(getContext(),
                R.array.branch_name_array,
                android.R.layout.simple_spinner_item);
        spinnerBranchName.setAdapter(branchAdapter, 0);

        ArrayAdapter<CharSequence> professionAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.profession_array,
                android.R.layout.simple_spinner_item);
        spinnerProfession.setAdapter(professionAdapter, 0);
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
