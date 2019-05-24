package net.maxproit.salesforce2.feature.upload.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.databinding.DocumentListRowBinding;
import net.maxproit.salesforce2.masum.listener.OnItemClickListener;
import net.maxproit.salesforce2.masum.model.api.file.Document;

import java.util.ArrayList;

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
        int i = position + 1;
        holder.tvId.setText("" + coApplicantsList.get(position).getLeadReferenceNo());
        holder.tvName.setText("" + coApplicantsList.get(position).getDocCheckListItem());
        if (!coApplicantsList.get(position).getURL().equals("")) {
            holder.imgView.setVisibility(View.VISIBLE);
        } else {
            holder.imgView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return coApplicantsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ArrayList<Document> coApplicantsList;
        TextView tvId, tvName;
        ImageView imgView, btnUpload;
        Context context;


        public MyViewHolder(View itemView, Context context, ArrayList<Document> coApplicantsList) {
            super(itemView);
            this.context = context;
            this.coApplicantsList = coApplicantsList;
            tvName = itemView.findViewById(R.id.tvName);
            tvId = itemView.findViewById(R.id.tvId);
            imgView = itemView.findViewById(R.id.btn_view);
            btnUpload = itemView.findViewById(R.id.btn_upload);
            itemView.setOnClickListener(view -> {
                mListener.itemClickListener(view, getLayoutPosition());
            });

            imgView.setOnClickListener(view -> {
                mListener.itemClickListener(view, getLayoutPosition());

            });

            btnUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.itemClickListener(v, getLayoutPosition());
                }
            });

        }
    }

    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

}
