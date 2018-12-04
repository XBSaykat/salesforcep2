package net.maxproit.salesforce.masum.adapter.adapterplanlist;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.api.myactivity.Datum;
import net.maxproit.salesforce.masum.model.local.VisitPlan;

import java.util.ArrayList;

public class CurrentPLanListAdapter extends RecyclerView.Adapter<CurrentPLanListAdapter.CustomViewHolder>  {
    private Context context;
    public ArrayList<Datum> leadList;
    public static OnItemClickListener mListener;


    public CurrentPLanListAdapter(Context context, ArrayList<Datum> leadList) {
        this.context = context;
        this.leadList = leadList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<Datum> leadList;
        private TextView tvId,tvName,tvBranch,tvStatus;
        private ImageView imgApproved,imgReject;
        private ConstraintLayout clListItem;


        public CustomViewHolder(View itemView, Context context, ArrayList<Datum> leadList) {
            super(itemView);
            this.context = context;
            this.leadList = leadList;
            tvId=itemView.findViewById(R.id.tvId);
            tvName=itemView.findViewById(R.id.tvName);
            tvBranch=itemView.findViewById(R.id.tvBranch);
            tvStatus=itemView.findViewById(R.id.tvStatus);
            clListItem = itemView.findViewById(R.id.cl_visit_plan_item);
            imgApproved=itemView.findViewById(R.id.btnApproved);
            imgReject=itemView.findViewById(R.id.btnReject);

//            imgApproved.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mListener.itemClickListener(v,getLayoutPosition());
//                }
//            });
//
//
//            imgReject.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mListener.itemClickListener(v,getLayoutPosition());
//                }
//            });

            clListItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.itemClickListener(v, getLayoutPosition());
                }
            });
        }

    }


    @Override
    public CurrentPLanListAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_visit_plan, null);
        CurrentPLanListAdapter.CustomViewHolder viewHolder = new CurrentPLanListAdapter.CustomViewHolder(view, context, leadList);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(CurrentPLanListAdapter.CustomViewHolder holder, final int position) {
        holder.tvId.setText(""+leadList.get(position).getActivityJournalID());
        holder.tvName.setText(leadList.get(position).getClientType());
        holder.tvBranch.setText(leadList.get(position).getClientName());
        holder.tvStatus.setText(leadList.get(position).getActivityStatus());

    }

    public void setFilter(ArrayList<Datum> newDataList) {
        leadList =new ArrayList<>();
        leadList.addAll(newDataList);
        notifyDataSetChanged();
    }

    public ArrayList<Datum> getDataList() {
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
