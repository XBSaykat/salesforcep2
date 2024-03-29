package net.maxproit.salesforce2.masum.fragment.prospect.prospectstage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseFragment;

import net.maxproit.salesforce2.feature.upload.UploadProspectActivity;
import net.maxproit.salesforce2.feature.upload.adapter.DocumentUploadAdapter;
import net.maxproit.salesforce2.masum.appdata.AppConstant;
import net.maxproit.salesforce2.masum.model.api.file.Document;
import net.maxproit.salesforce2.masum.model.api.file.GetDocument;
import net.maxproit.salesforce2.masum.model.local.MyNewLead;
import net.maxproit.salesforce2.masum.utility.ActivityUtils;
import net.maxproit.salesforce2.masum.utility.DividerItemDecoration;
import net.maxproit.salesforce2.util.PdfViewer;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropectStageAttachmentFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private DocumentUploadAdapter documentUploadAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView btnDoc;
    private ArrayList<Document> docList;
    private OnFragmentInteractionListener mListener;

    RecyclerView recyclerView;
    Context context;

    public PropectStageAttachmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PropectStageAttachmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropectStageAttachmentFragment newInstance(String param1, String param2) {
        PropectStageAttachmentFragment fragment = new PropectStageAttachmentFragment();
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
        context = getContext();
        Log.e("crash", "attach");
        View rootView = inflater.inflate(R.layout.fragment_lead_stage_attachment, container, false);
        docList = new ArrayList<>();
        initView(rootView);
        initListener();

        return rootView;
    }

    private void initView(View rootView) {
        btnDoc = rootView.findViewById(R.id.btndoc1);
        recyclerView = rootView.findViewById(R.id.recycleView);
        documentUploadAdapter = new DocumentUploadAdapter(getActivity(), docList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), ((LinearLayoutManager) mLayoutManager).VERTICAL, 16));

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(documentUploadAdapter);

    }

    @Override
    protected Integer layoutResourceId() {
        return null;
    }

    @Override
    protected void initFragmentComponents() {

    }

    @Override
    public void onResume() {
        super.onResume();
        initIntentData();
    }

    private void initListener() {
        btnDoc.setOnClickListener(view -> {
            ActivityUtils.getInstance().invokeActivity(getActivity(), UploadProspectActivity.class, false);
        });

        documentUploadAdapter.setItemClickListener((view, position) -> {
                switch (view.getId()) {
                    case R.id.btn_view:
                        sentDataToDetail(position);
                        break;
                    case R.id.btn_upload:
                        ActivityUtils.invokDoc(getActivity(), UploadProspectActivity.class, getDoc(position));
                        break;

                    default:
                        sentDataToDetail(position);
                        break;
                }

        });
    }

    private void sentDataToDetail(int position) {

        if (getDoc(position).getURL() == null || getDoc(position).getURL().equals("")) {
            ActivityUtils.invokDoc(getActivity(), UploadProspectActivity.class, getDoc(position));
        } else {
           /* Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getDoc(position).getURL()));
            getContext().startActivity(intent);*/
            Bundle bundle = new Bundle();
            bundle.putString(AppConstant.PDF_URL_INTENT_KEY, getDoc(position).getURL());
            Intent target = new Intent(getActivity(), PdfViewer.class);
            target.putExtras(bundle);
            try {
                startActivity(target);
            } catch (ActivityNotFoundException e) {
                // Instruct the user to install a PDF reader here, or something
            }
        }
    }

    private void initIntentData() {
        if (getArguments() != null) {
            MyNewLead myNewLead = (MyNewLead) getArguments().getSerializable(AppConstant.INTENT_KEY);
            if (!docList.isEmpty())
                docList.clear();
            callApi(myNewLead);

        }
    }


    private Document getDoc(int position) {
        Document document = new Document();
        document.setDocCheckListID(docList.get(position).getDocCheckListID());
        document.setLeadReferenceNo(docList.get(position).getLeadReferenceNo());
        document.setDocCheckListItem(docList.get(position).getDocCheckListItem());
        document.setFileName(docList.get(position).getFileName());
        document.setURL(docList.get(position).getURL());
        document.setDocCheckListItemID(docList.get(position).getDocCheckListItemID());
        return document;
    }


    private void callApi(MyNewLead myNewLead) {
        if (isNetworkAvailable()) {
            String refNo = myNewLead.getRefNumber();
            String random = UUID.randomUUID().toString();
            getApiService().getDocumentList(refNo, random).enqueue(new Callback<GetDocument>() {
                @Override
                public void onResponse(Call<GetDocument> call, Response<GetDocument> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {
                            if (response.body().getData() != null) {
                                docList.addAll(response.body().getData());
                                documentUploadAdapter.notifyDataSetChanged();
                            }

                        } else {
                            showAlertDialog(getString(R.string.error_text), response.body().getMessage());
                        }
                    } else {
                        showAlertDialog(getString(R.string.error_text) + " " + response.code(), response.message());

                    }

                }

                @Override
                public void onFailure(Call<GetDocument> call, Throwable t) {
                    showAlertDialog(getString(R.string.error_text), t.getMessage());

                }
            });
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
}
