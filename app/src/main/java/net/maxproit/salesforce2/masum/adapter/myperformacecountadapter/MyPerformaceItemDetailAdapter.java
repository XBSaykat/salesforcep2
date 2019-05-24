package net.maxproit.salesforce2.masum.adapter.myperformacecountadapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.masum.listener.OnItemClickListener;
import net.maxproit.salesforce2.masum.model.api.performance.SubItemDetail;

import java.util.ArrayList;

public class MyPerformaceItemDetailAdapter extends  RecyclerView.Adapter<MyPerformaceItemDetailAdapter.CustomViewHolder> {
    private Context context;
    public ArrayList<SubItemDetail> leadList;
    public static OnItemClickListener mListener;
    private boolean isChange = false;


    public MyPerformaceItemDetailAdapter(Context context, ArrayList<SubItemDetail> leadList) {
        this.context = context;
        this.leadList = leadList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<SubItemDetail> leadList;
        private TextView tvId, tvName, tvBranch, tvStatus;
        private ConstraintLayout constraintLayoutLeadItem;


        public CustomViewHolder(View itemView, Context context, ArrayList<SubItemDetail> leadList) {
            super(itemView);
            this.context = context;
            this.leadList = leadList;
            tvId = itemView.findViewById(R.id.item_name);
            tvName = itemView.findViewById(R.id.item_value);

        }

    }


    @Override
    public MyPerformaceItemDetailAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_performance, null);
        MyPerformaceItemDetailAdapter.CustomViewHolder viewHolder = new MyPerformaceItemDetailAdapter.CustomViewHolder(view, context, leadList);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyPerformaceItemDetailAdapter.CustomViewHolder holder, final int position) {
        holder.tvId.setText("" + leadList.get(position).getSubItemDetail()+" : ");
        holder.tvName.setText("" + leadList.get(position).getSubItemDetailCount());


    }



    @Override
    public int getItemCount() {
        return leadList.size();
    }

    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }


}
