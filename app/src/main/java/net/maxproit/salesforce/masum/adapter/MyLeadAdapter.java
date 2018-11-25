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
import net.maxproit.salesforce.masum.model.local.MyNewProspect;

import java.util.ArrayList;

public class MyLeadAdapter  extends RecyclerView.Adapter<MyLeadAdapter.CustomViewHolder>  {
    private Context context;
    public ArrayList<MyNewProspect> leadList;
    public static OnItemClickListener mListener;
    private boolean isChange=false;



    public MyLeadAdapter(Context context, ArrayList<MyNewProspect> leadList) {
        this.context = context;
        this.leadList = leadList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<MyNewProspect> leadList;
        private TextView tvId,tvName,tvBranch,tvStatus;
        private ConstraintLayout constraintLayoutLeadItem;


        public CustomViewHolder(View itemView, Context context, ArrayList<MyNewProspect> leadList) {
            super(itemView);
            this.context = context;
            this.leadList = leadList;
            tvId=itemView.findViewById(R.id.tvId);
            tvName=itemView.findViewById(R.id.tvName);
            tvBranch=itemView.findViewById(R.id.tvBranch);
            tvStatus=itemView.findViewById(R.id.tvStatus);
            constraintLayoutLeadItem = itemView.findViewById(R.id.clLeadItem);


            constraintLayoutLeadItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.itemClickListener(v,getLayoutPosition());
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
        holder.tvId.setText(""+leadList.get(position).getId());
        holder.tvName.setText(leadList.get(position).getUserName());
        holder.tvBranch.setText(leadList.get(position).getBranchName());
        holder.tvStatus.setText(leadList.get(position).getStatus());


    }

    public void setFilter(ArrayList<MyNewProspect> newDataList) {
        leadList =new ArrayList<>();
        leadList.addAll(newDataList);
        notifyDataSetChanged();
    }

    public ArrayList<MyNewProspect> getDataList() {
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
