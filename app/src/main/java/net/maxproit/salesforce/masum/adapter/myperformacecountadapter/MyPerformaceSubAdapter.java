package net.maxproit.salesforce.masum.adapter.myperformacecountadapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.api.performance.Datum;
import net.maxproit.salesforce.masum.model.api.performance.SubItemDetail;
import net.maxproit.salesforce.masum.model.api.performance.SubItemType;
import net.maxproit.salesforce.masum.utility.MasumCommonUtils;

import java.util.ArrayList;

import gun0912.tedbottompicker.GridSpacingItemDecoration;

public class MyPerformaceSubAdapter extends  RecyclerView.Adapter<MyPerformaceSubAdapter.CustomViewHolder> {
    private Context context;
    public ArrayList<SubItemType> leadList;
    public static OnItemClickListener mListener;
    private boolean isChange = false;


    public MyPerformaceSubAdapter(Context context, ArrayList<SubItemType> leadList) {
        this.context = context;
        this.leadList = leadList;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        Context context;
        ArrayList<SubItemType> leadList;
        private TextView tvId, tvName, tvBranch, tvStatus;
        private ConstraintLayout constraintLayoutLeadItem;
        private RecyclerView recyclerView;


        public CustomViewHolder(View itemView, Context context, ArrayList<SubItemType> leadList) {
            super(itemView);
            this.context = context;
            this.leadList = leadList;
            tvId = itemView.findViewById(R.id.sub_head_title);
            tvName = itemView.findViewById(R.id.tv_subhead_value);
            recyclerView = itemView.findViewById(R.id.recycler_detail);

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

        MyPerformaceItemDetailAdapter myPerformaceItemDetailAdapter=new MyPerformaceItemDetailAdapter(context, (ArrayList<SubItemDetail>) leadList.get(position).getSubItemDetails());
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
