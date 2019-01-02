package net.maxproit.salesforce.masum.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.api.dashboarddetail.DashBoardDetailModel;

import java.util.ArrayList;

public class MyPerformanceDetailsDataAdapter extends RecyclerView.Adapter<MyPerformanceDetailsDataAdapter.CustomViewHolder>  {
    private Context context;
    public ArrayList<DashBoardDetailModel> leadList;
    public static OnItemClickListener mListener;



    public MyPerformanceDetailsDataAdapter(Context context, ArrayList<DashBoardDetailModel> leadList) {
        this.context = context;
        this.leadList = leadList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<DashBoardDetailModel> leadList;
        private TextView tvId,tvName,tvBranch,tvStatus;


        public CustomViewHolder(View itemView, Context context, ArrayList<DashBoardDetailModel> leadList) {
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
    public MyPerformanceDetailsDataAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_performance_details_list, null);
        MyPerformanceDetailsDataAdapter.CustomViewHolder viewHolder = new MyPerformanceDetailsDataAdapter.CustomViewHolder(view, context, leadList);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyPerformanceDetailsDataAdapter.CustomViewHolder holder, final int position) {
        holder.tvId.setText(""+leadList.get(position).getID());
        holder.tvName.setText(leadList.get(position).getClientName());
    }
    public void setFilter(ArrayList<DashBoardDetailModel> newDataList) {
        leadList =new ArrayList<>();
        leadList.addAll(newDataList);
        notifyDataSetChanged();
    }

    public ArrayList<DashBoardDetailModel> getDataList() {
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
