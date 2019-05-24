package net.maxproit.salesforce2.masum.adapter.myperformacecountadapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.databinding.MyPerfomanceDesRowBinding;
import net.maxproit.salesforce2.databinding.SearchRowBinding;
import net.maxproit.salesforce2.masum.listener.OnItemClickListener;
import net.maxproit.salesforce2.masum.model.api.performance.Datum;
import net.maxproit.salesforce2.masum.model.api.performance.SubItemType;
import net.maxproit.salesforce2.masum.utility.MasumCommonUtils;

import java.util.ArrayList;

import gun0912.tedbottompicker.GridSpacingItemDecoration;

public class MyPerformanceItemAdapter extends  RecyclerView.Adapter<MyPerformanceItemAdapter.CustomViewHolder> {
private Context context;
public ArrayList<Datum> leadList;
public static OnItemClickListener mListener;
private boolean isChange = false;


public MyPerformanceItemAdapter(Context context, ArrayList<Datum> leadList) {
        this.context = context;
        this.leadList = leadList;
        }


class CustomViewHolder extends RecyclerView.ViewHolder {

    Context context;
    ArrayList<Datum> leadList;
    private TextView tvId, tvName, tvBranch, tvStatus;
    private ConstraintLayout constraintLayoutLeadItem;
    RecyclerView recyclerView;


    public CustomViewHolder(View itemView, Context context, ArrayList<Datum> leadList) {
        super(itemView);
        this.context = context;
        this.leadList = leadList;
        tvId = itemView.findViewById(R.id.btn_performace_head);
        recyclerView = itemView.findViewById(R.id.recycleView_subhead);

    }

}


    @Override
    public MyPerformanceItemAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_peroformace_head, null);
        MyPerformanceItemAdapter.CustomViewHolder viewHolder = new MyPerformanceItemAdapter.CustomViewHolder(view, context, leadList);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyPerformanceItemAdapter.CustomViewHolder holder, final int position) {
        holder.tvId.setText("" + leadList.get(position).getItemType());
        MyPerformaceSubAdapter myPerformaceSubAdapter=new MyPerformaceSubAdapter(context, (ArrayList<SubItemType>) leadList.get(position).getSubItemTypes(),leadList.get(position).getItemType());

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context,2);
        holder.recyclerView.setLayoutManager(mLayoutManager);
        holder.recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, MasumCommonUtils.dpToPx(10, context), true));
        holder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        holder.recyclerView.setAdapter(myPerformaceSubAdapter);
        myPerformaceSubAdapter.notifyDataSetChanged();

    }



    @Override
    public int getItemCount() {
        return leadList.size();
    }

    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }


}
