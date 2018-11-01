package net.maxproit.salesforce.masum.adapter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.MyNewProspect;

import java.util.ArrayList;

public class MyNewProspectAdapter  extends RecyclerView.Adapter<MyNewProspectAdapter.CustomViewHolder>  {
    private Context context;
    public ArrayList<MyNewProspect> leadList;
    public static OnItemClickListener mListener;



    public MyNewProspectAdapter(Context context, ArrayList<MyNewProspect> leadList) {
        this.context = context;
        this.leadList = leadList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<MyNewProspect> leadList;
        private TextView tvId,tvName,tvBranch,tvStatus;


        public CustomViewHolder(View itemView, Context context, ArrayList<MyNewProspect> leadList) {
            super(itemView);
            this.context = context;
            this.leadList = leadList;
            tvId=itemView.findViewById(R.id.tvId);
            tvName=itemView.findViewById(R.id.tvName);
            tvBranch=itemView.findViewById(R.id.tvBranch);
            tvStatus=itemView.findViewById(R.id.tvStatus);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.itemClickListener(view,getLayoutPosition());
                }
            });
        }

    }


    @Override
    public MyNewProspectAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_lead, null);
        MyNewProspectAdapter.CustomViewHolder viewHolder = new MyNewProspectAdapter.CustomViewHolder(view, context, leadList);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyNewProspectAdapter.CustomViewHolder holder, final int position) {
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
