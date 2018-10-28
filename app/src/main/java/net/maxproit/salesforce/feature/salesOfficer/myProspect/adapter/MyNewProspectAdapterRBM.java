package net.maxproit.salesforce.feature.salesOfficer.myProspect.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.listener.OnItemClickListener;
import net.maxproit.salesforce.model.MyNewProspect;

import java.util.ArrayList;

public class MyNewProspectAdapterRBM extends RecyclerView.Adapter<MyNewProspectAdapterRBM.ViewHolder> {


    private Context context;
    public ArrayList<MyNewProspect> prospectList;
    public static OnItemClickListener mListener;

    public MyNewProspectAdapterRBM(Context context, ArrayList<MyNewProspect> prospectList) {
        this.context = context;
        this.prospectList = prospectList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.prospect_list_item_rbm, null);
        MyNewProspectAdapterRBM.ViewHolder viewHolder = new MyNewProspectAdapterRBM.ViewHolder(view, context, prospectList);


        return viewHolder;



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvName.setText(""+ prospectList.get(position).getUserName());
        holder.tvId.setText(""+ prospectList.get(position).getId());


    }

    @Override
    public int getItemCount() {
        return prospectList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        Context context;
        public ArrayList<MyNewProspect> myNewProspectArrayList;
        private TextView tvId,tvName;
        private ConstraintLayout clItem;

        public ViewHolder(View itemView, Context context, ArrayList<MyNewProspect> myNewProspectArrayList) {
            super(itemView);
            this.context = context;
            this.myNewProspectArrayList = myNewProspectArrayList;
            tvId = itemView.findViewById(R.id.tv_ref_id);
            tvName = itemView.findViewById(R.id.tv_name);
            clItem = itemView.findViewById(R.id.cl_prospect_item);

            clItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.itemClickListener(v, getLayoutPosition());
                }
            });

        }
    }
    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

}
