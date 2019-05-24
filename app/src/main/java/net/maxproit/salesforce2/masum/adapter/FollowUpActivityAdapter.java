package net.maxproit.salesforce2.masum.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.masum.listener.OnItemClickListener;
import net.maxproit.salesforce2.masum.model.api.followup.FollowUpDatum;


import java.util.ArrayList;

public class FollowUpActivityAdapter  extends RecyclerView.Adapter<FollowUpActivityAdapter.CustomViewHolder>  {
    private Context context;
    public ArrayList<FollowUpDatum> followUpList;
    public static OnItemClickListener mListener;




    public FollowUpActivityAdapter(Context context, ArrayList<FollowUpDatum> leadList) {
        this.context = context;
        this.followUpList = leadList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<FollowUpDatum> followUpList;
        private TextView tvDate,tvRemark,tvFollowUpSerial;



        public CustomViewHolder(View itemView, Context context, ArrayList<FollowUpDatum> followUpList) {
            super(itemView);
            this.context = context;
            this.followUpList = followUpList;
            tvDate=itemView.findViewById(R.id.tv_date);
            tvRemark=itemView.findViewById(R.id.tv_remark);
            tvFollowUpSerial=itemView.findViewById(R.id.tv_followUpSerial);


        }

    }


    @Override
    public FollowUpActivityAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_follow_up_activity, null);
        FollowUpActivityAdapter.CustomViewHolder viewHolder = new FollowUpActivityAdapter.CustomViewHolder(view, context, followUpList);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(FollowUpActivityAdapter.CustomViewHolder holder, final int position) {
        holder.tvDate.setText(""+ followUpList.get(position).getFollowupDate());
        holder.tvRemark.setText(""+ followUpList.get(position).getRemarks());
        int s=position+1;
        holder.tvFollowUpSerial.setText(""+s);



    }

    public void setFilter(ArrayList<FollowUpDatum> newDataList) {
        followUpList =new ArrayList<>();
        followUpList.addAll(newDataList);
        notifyDataSetChanged();
    }

    public ArrayList<FollowUpDatum> getDataList() {
        return followUpList;
    }

    @Override
    public int getItemCount() {
        return followUpList.size();
    }

    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }


}
