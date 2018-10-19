package net.maxproit.idlc.feature.salesOfficer.newProspect.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.maxproit.idlc.R;
import net.maxproit.idlc.databinding.CibRequestRowBinding;
import net.maxproit.idlc.databinding.ProspectDocumentRowBinding;
import net.maxproit.idlc.feature.salesOfficer.parallelprocess.cif.CifActivity;
import net.maxproit.idlc.feature.upload.UploadProspectActivity;
import net.maxproit.idlc.model.cib.requestedCIB.RequestedCIB;
import net.maxproit.idlc.model.login.LocalLogin;
import net.maxproit.idlc.model.myprospect.documentlist.ProspectDoc;

import java.io.File;
import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class ProspectDocumentAdapter extends RecyclerView.Adapter<ProspectDocumentAdapter.ViewFilesHolder> {
    private static final String TAG = "ProspectDocumentAdapter";
    LocalLogin localLogin;
    private Context context;
    private List<ProspectDoc> list;
    private LayoutInflater layoutInflater;
    public static String FILE_TYPE = "FILE_TYPE";
    public static String FILE_Id = "FILE_ID";
    public static String PROSPECT_Id = "PROSPECT_ID";


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param dataList array list containing path of files
     */
    public ProspectDocumentAdapter(Context context, List<ProspectDoc> dataList) {
        this.context = context;
        this.list = dataList;
        localLogin = new LocalLogin(context);

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ProspectDocumentRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.prospect_document_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        String downloadLInk = list.get(position).getURL();
        if (downloadLInk.isEmpty()) {
            holder.binding.btnDownload.setImageResource(R.drawable.ic_upload);

        }
        holder.binding.btnDownload.setOnClickListener(v -> {

            if (!downloadLInk.isEmpty()) {
                //
                Log.d(TAG, "onBindViewHolder: " + downloadLInk);
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(downloadLInk));
                context.startActivity(intent);

            } else {
                Bundle bundle = new Bundle();
                bundle.putString(FILE_TYPE, list.get(position).getDocCheckListItem());
                bundle.putString(FILE_Id, list.get(position).getDocCheckListItemID());
                bundle.putString(FILE_Id, list.get(position).getDocCheckListItemID());
                bundle.putString(PROSPECT_Id, list.get(position).getLeadReferenceNo());
                Intent intent = new Intent(context, UploadProspectActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
               // context.startActivityForResult()
            }
        });


    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public class ViewFilesHolder extends RecyclerView.ViewHolder {

        private final ProspectDocumentRowBinding binding;

        public ViewFilesHolder(final ProspectDocumentRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}