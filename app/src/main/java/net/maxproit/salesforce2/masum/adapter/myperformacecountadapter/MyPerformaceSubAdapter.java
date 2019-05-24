package net.maxproit.salesforce2.masum.adapter.myperformacecountadapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.masum.activity.myperformance.MyPerformanceAllListActivity;
import net.maxproit.salesforce2.masum.listener.OnItemClickListener;
import net.maxproit.salesforce2.masum.model.api.performance.SubItemDetail;
import net.maxproit.salesforce2.masum.model.api.performance.SubItemType;
import net.maxproit.salesforce2.masum.utility.ActivityUtils;

import java.util.ArrayList;

public class MyPerformaceSubAdapter extends RecyclerView.Adapter<MyPerformaceSubAdapter.CustomViewHolder> {
    private Context context;
    public ArrayList<SubItemType> leadList;
    public static OnItemClickListener mListener;
    private boolean isChange = false;
    private String itemType = null;


    public MyPerformaceSubAdapter(Context context, ArrayList<SubItemType> leadList, String itemType) {
        this.context = context;
        this.leadList = leadList;
        this.itemType = itemType;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<SubItemType> leadList;
        private TextView tvId, tvName, tvHead, tvStatus;
        private ConstraintLayout constraintLayoutLeadItem;
        private RecyclerView recyclerView;


        public CustomViewHolder(View itemView, Context context, ArrayList<SubItemType> leadList) {
            super(itemView);
            this.context = context;
            this.leadList = leadList;
            tvId = itemView.findViewById(R.id.sub_head_title);
            tvName = itemView.findViewById(R.id.tv_subhead_value);
            tvHead = itemView.findViewById(R.id.tv_head_item_for_sub);
            recyclerView = itemView.findViewById(R.id.recycler_detail);
            itemView.setOnClickListener(view -> {
                Toast.makeText(context, tvHead.getText().toString()+" "+tvId.getText().toString(), Toast.LENGTH_SHORT).show();
                ActivityUtils.getInstance().invokeActivity(context,MyPerformanceAllListActivity.class,tvHead.getText().toString(),tvId.getText().toString());
            });


        }

    }


    @Override
    public MyPerformaceSubAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_performancesubhead, null);
        MyPerformaceSubAdapter.CustomViewHolder viewHolder = new MyPerformaceSubAdapter.CustomViewHolder(view, context, leadList);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyPerformaceSubAdapter.CustomViewHolder holder, final int position) {
        holder.tvId.setText("" + leadList.get(position).getSubItemType());
        holder.tvName.setText("" + leadList.get(position).getSubItemTypeCount());

        holder.tvHead.setText("" + itemType);

        MyPerformaceItemDetailAdapter myPerformaceItemDetailAdapter = new MyPerformaceItemDetailAdapter(context, (ArrayList<SubItemDetail>) leadList.get(position).getSubItemDetails());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(mLayoutManager);
        holder.recyclerView.setAdapter(myPerformaceItemDetailAdapter);
        myPerformaceItemDetailAdapter.notifyDataSetChanged();

    }


    @Override
    public int getItemCount() {
        return leadList.size();
    }

    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }


}
