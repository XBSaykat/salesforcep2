package net.maxproit.salesforce.masum.fragment.prospect.prospectstage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseFragment;
import net.maxproit.salesforce.feature.upload.UploadActivity;
import net.maxproit.salesforce.feature.upload.UploadProspectActivity;
import net.maxproit.salesforce.feature.upload.adapter.DocumentUploadAdapter;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;
import net.maxproit.salesforce.masum.adapter.adapter.MyNewProspectAdapter;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.appdata.sqlite.AttachmentDbController;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.api.file.Document;
import net.maxproit.salesforce.masum.model.api.file.GetDocument;
import net.maxproit.salesforce.masum.model.local.Attachment;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.utility.ActivityUtils;
import net.maxproit.salesforce.masum.utility.DividerItemDecoration;
import net.maxproit.salesforce.masum.utility.ImageUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PropectStageAttachmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PropectStageAttachmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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
    private ProspectStageActivity prospectStageActivity;
    private ArrayList<Document> docList;
    public static ImageView imgAtach, imgIdCard, imgVisitingCard;
    private Button btnImgCap, btnIDCardCap, btnVCardCap, btnChoosePP, btnChooseId, btnChooseVCard;
    private OnFragmentInteractionListener mListener;
    private TextView tvID, tvPhoto, tvVCard;
    private Uri filePathUri = null;
    RecyclerView recyclerView;
    AttachmentDbController attachmentDbController;
    ArrayList<Attachment> attachmentArrayList;
    public static Bitmap attachPp = null, attachIdcard = null, attachvCard = null;
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
        prospectStageActivity = (ProspectStageActivity) getActivity();
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

        documentUploadAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClickListener(View view, int position) {
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
            }
        });
    }

    private void sentDataToDetail(int position) {

        if (getDoc(position).getURL() == null || getDoc(position).getURL().equals("")) {
            ActivityUtils.invokDoc(getActivity(), UploadProspectActivity.class, getDoc(position));
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getDoc(position).getURL()));
            getContext().startActivity(intent);
        }
    }

    private void initIntentData() {
        if (prospectStageActivity.getDataFromProspect() != null) {
            MyNewLead myNewLead = prospectStageActivity.getDataFromProspect();
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

                            showAlertDialog("Error", response.body().getMessage());

                        }
                    } else {
                        showAlertDialog("Error", response.message());

                    }

                }

                @Override
                public void onFailure(Call<GetDocument> call, Throwable t) {
                    showAlertDialog("Error", t.getMessage());

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
