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
import net.maxproit.salesforce.masum.model.FollowUpActivity;


import java.util.ArrayList;

public class FollowUpActivityAdapter  extends RecyclerView.Adapter<FollowUpActivityAdapter.CustomViewHolder>  {
    private Context context;
    public ArrayList<FollowUpActivity> followUpList;
    public static OnItemClickListener mListener;




    public FollowUpActivityAdapter(Context context, ArrayList<FollowUpActivity> leadList) {
        this.context = context;
        this.followUpList = leadList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<FollowUpActivity> followUpList;
        private TextView tvDate,tvRemark,tvFollowUpSerial;



        public CustomViewHolder(View itemView, Context context, ArrayList<FollowUpActivity> followUpList) {
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
        holder.tvDate.setText(""+ followUpList.get(position).getFollowUpdate());
        holder.tvRemark.setText(""+ followUpList.get(position).getRemark());
        int s=position+1;
        holder.tvFollowUpSerial.setText(""+s);



    }

    public void setFilter(ArrayList<FollowUpActivity> newDataList) {
        followUpList =new ArrayList<>();
        followUpList.addAll(newDataList);
        notifyDataSetChanged();
    }

    public ArrayList<FollowUpActivity> getDataList() {
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
