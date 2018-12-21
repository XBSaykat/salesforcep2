package net.maxproit.salesforce.masum.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.api.lead.LeadLeastDataFromApi;

import java.util.ArrayList;

public class MyLeadAdapter extends RecyclerView.Adapter<MyLeadAdapter.CustomViewHolder> {
    private Context context;
    public ArrayList<LeadLeastDataFromApi> leadList;
    public static OnItemClickListener mListener;
    private boolean isChange = false;


    public MyLeadAdapter(Context context, ArrayList<LeadLeastDataFromApi> leadList) {
        this.context = context;
        this.leadList = leadList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<LeadLeastDataFromApi> leadList;
        private TextView tvId, tvName, tvBranch, tvStatus;
        private ConstraintLayout constraintLayoutLeadItem;


        public CustomViewHolder(View itemView, Context context, ArrayList<LeadLeastDataFromApi> leadList) {
            super(itemView);
            this.context = context;
            this.leadList = leadList;
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvBranch = itemView.findViewById(R.id.tvBranch);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            constraintLayoutLeadItem = itemView.findViewById(R.id.clLeadItem);


            constraintLayoutLeadItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.itemClickListener(v, getLayoutPosition());
                }
            });
        }

    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_lead, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view, context, leadList);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.tvId.setText("" + leadList.get(position).getReference());
        holder.tvName.setText(leadList.get(position).getName());
        holder.tvBranch.setText(leadList.get(position).getBranch());
        holder.tvStatus.setText(leadList.get(position).getStatus());


    }

    public void setFilter(ArrayList<LeadLeastDataFromApi> newDataList) {
        leadList = new ArrayList<>();
        leadList.addAll(newDataList);
        notifyDataSetChanged();
    }

    public ArrayList<LeadLeastDataFromApi> getDataList() {
        return leadList;
    }

    @Override
    public int getItemCount() {
        return leadList.size();
    }

    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }


}
