package net.maxproit.idlc.feature.salesOfficer.newProspect;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.FragmentProspectDocumentsBinding;
import net.maxproit.idlc.feature.salesOfficer.newProspect.adapter.ProspectDocumentAdapter;
import net.maxproit.idlc.model.myprospect.documentlist.ProspectDoc;
import net.maxproit.idlc.model.myprospect.documentlist.ProspectDocList;
import net.maxproit.idlc.network.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sadiq Md. Asif on 18-Apr-18.
 * asifsadiqmd@gmail.com
 */

public class DocumentFragment extends BaseFragment {
    private static final String TAG = "DocumentFragment";

    FragmentProspectDocumentsBinding binding;
    NewProspectActivity activity;
    private List<ProspectDoc> cifList;
    ProgressDialog progressDialog;
    Context context;
    public static String KEY_REFERRENCE_ID;

    ProspectDocumentAdapter adapter;

    public static DocumentFragment newInstance() {
        Bundle args = new Bundle();
        DocumentFragment fragment = new DocumentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_prospect_documents;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        activity = (NewProspectActivity) getActivity();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentProspectDocumentsBinding) getBinding();
        KEY_REFERRENCE_ID = activity.oleProspect.getData().getProspectReferenceNo();
        Log.d(TAG, "initFragmentComponents: " + KEY_REFERRENCE_ID);

        cifList = new ArrayList<>();
        binding.doc1.setOnClickListener(v -> {
            getCibData();
            setupCifAdapter();

        });


    }

    private void getCibData() {
        progressDialog.show();
        RestClient.getInstance().callRetrofit().getDockList(KEY_REFERRENCE_ID).enqueue(new Callback<ProspectDocList>() {
            @Override
            public void onResponse(Call<ProspectDocList> call, Response<ProspectDocList> response) {
                progressDialog.cancel();

                if (response.isSuccessful()) {

                    cifList.clear();
                    cifList = response.body().getData();
                    setupCifAdapter();
                } else {
                    showToast("Try again!");
                }
            }

            @Override
            public void onFailure(Call<ProspectDocList> call, Throwable t) {
                progressDialog.cancel();
                showToast("Failed");
            }
        });
    }

    private void setupCifAdapter() {
        adapter = new ProspectDocumentAdapter(context, cifList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        binding.rvDocument.setLayoutManager(mLayoutManager);
        binding.rvDocument.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
