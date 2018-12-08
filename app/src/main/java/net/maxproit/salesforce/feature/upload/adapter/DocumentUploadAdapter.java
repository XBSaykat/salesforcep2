package net.maxproit.salesforce.feature.upload.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.databinding.DocumentListRowBinding;
import net.maxproit.salesforce.masum.activity.lead.MyLeadActivity;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.masum.adapter.adapter.CoApplicantListAdapter;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.api.file.Document;
import net.maxproit.salesforce.masum.model.local.CoApplicant;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.mylead.Data;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/25/18.
 * heyRezwan@gmail.com
 */
public class DocumentUploadAdapter extends RecyclerView.Adapter<DocumentUploadAdapter.MyViewHolder> {

    ArrayList<Document> coApplicantsList;
    Context context;
    public static OnItemClickListener mListener;

    public DocumentUploadAdapter(Context context, ArrayList<Document> coApplicantsList) {
        this.coApplicantsList = coApplicantsList;
        this.context = context;
    }

    @NonNull
    @Override
    public DocumentUploadAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.document_list_row, null);
        DocumentUploadAdapter.MyViewHolder viewHolder = new DocumentUploadAdapter.MyViewHolder(view, context, coApplicantsList);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull DocumentUploadAdapter.MyViewHolder holder, int position) {
        int i=position+1;
       holder.tvId.setText(""+coApplicantsList.get(position).getDocCheckListItemID());
        holder.tvName.setText(""+coApplicantsList.get(position).getFileName());

    }

    @Override
    public int getItemCount() {
        return coApplicantsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ArrayList<Document> coApplicantsList;
        TextView tvId, tvName;
        Context context;


        public MyViewHolder(View itemView, Context context, ArrayList<Document> coApplicantsList) {
            super(itemView);
            this.context = context;
            this.coApplicantsList = coApplicantsList;
            tvName = itemView.findViewById(R.id.tvName);
            tvId = itemView.findViewById(R.id.tvId);
            itemView.setOnClickListener(view -> {
                    mListener.itemClickListener(view, getLayoutPosition());
                });

        }
    }
    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

}
