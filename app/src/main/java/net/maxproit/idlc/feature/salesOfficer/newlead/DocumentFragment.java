package net.maxproit.idlc.feature.salesOfficer.newlead;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.maxproit.idlc.R;
import net.maxproit.idlc.common.base.BaseFragment;
import net.maxproit.idlc.databinding.FragmentDocumentsBinding;
import net.maxproit.idlc.feature.salesOfficer.newProspect.adapter.ProspectDocumentAdapter;
import net.maxproit.idlc.feature.upload.UploadActivity;
import net.maxproit.idlc.model.myprospect.documentlist.ProspectDoc;
import net.maxproit.idlc.model.myprospect.documentlist.ProspectDocList;
import net.maxproit.idlc.network.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sadiq Md. Asif on 18-Apr-18.
 * asifsadiqmd@gmail.com
 */

public class DocumentFragment extends BaseFragment {

    FragmentDocumentsBinding binding;
    NewLeadActivity activity;
    Context context;
    public static final int RESULT_DOC1 = 999;
    public static final int RESULT_DOC2 = 991;
    ProgressDialog progressDialog;
    ProspectDocumentAdapter adapter;
    private List<ProspectDoc> cifList;

    public static DocumentFragment newInstance() {
        Bundle args = new Bundle();
        DocumentFragment fragment = new DocumentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_documents;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (NewLeadActivity) getActivity();
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentDocumentsBinding) getBinding();
        cifList = new ArrayList<>();

        if (activity.root.equals("update")) {
            binding.doc1.setVisibility(View.GONE);
            binding.doc2.setVisibility(View.GONE);
            binding.add.setVisibility(View.GONE);
            binding.list.setVisibility(View.VISIBLE);

        }

        binding.list.setOnClickListener(v -> {

            getCibData();

        });


        binding.clLeadItem.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), UploadActivity.class);
            intent.putExtra("pdf", "pdf1");
            startActivityForResult(intent, RESULT_DOC1);

        });

        binding.clLeadItem2.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), UploadActivity.class);
            intent.putExtra("pdf", "pdf2");
            startActivityForResult(intent, RESULT_DOC2);
        });


        binding.doc1.setOnClickListener(v -> {

            binding.clLeadItem.setVisibility(View.VISIBLE);
            binding.clLeadItem2.setVisibility(View.VISIBLE);


        });

        binding.doc2.setOnClickListener(v -> {



        });


    }

    private void getCibData() {

        progressDialog.show();
        RestClient.getInstance().callRetrofit().getLeadDockList(activity.oldLead.getData().getLeadReferenceNo(), UUID.randomUUID().toString()).enqueue(new Callback<ProspectDocList>() {
            @Override
            public void onResponse(Call<ProspectDocList> call, Response<ProspectDocList> response) {
                progressDialog.cancel();

                if (response.isSuccessful()) {

                    cifList.clear();
                    cifList = response.body().getData();
                    setAdapter();
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

    private void setAdapter() {
        adapter = new ProspectDocumentAdapter(context, cifList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        binding.rvDocument.setLayoutManager(mLayoutManager);
        binding.rvDocument.setAdapter(adapter);
    }


}
