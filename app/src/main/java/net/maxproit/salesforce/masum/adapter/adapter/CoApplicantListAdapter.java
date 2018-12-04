package net.maxproit.salesforce.masum.adapter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.masum.listener.OnItemClickListener;
import net.maxproit.salesforce.masum.model.local.CoApplicant;

import java.util.ArrayList;

/**
 * Created by Rezwan Khan Chowdhury on 11/8/2018.
 * heyrezwan@gmail.com
 */
public class CoApplicantListAdapter extends RecyclerView.Adapter<CoApplicantListAdapter.MyViewHolder> {

    ArrayList<CoApplicant> coApplicantsList;
    Context context;
    public static OnItemClickListener mListener;

    public CoApplicantListAdapter(Context context, ArrayList<CoApplicant> coApplicantsList) {
        this.coApplicantsList = coApplicantsList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.coapplicant_list_view_row, null);
        CoApplicantListAdapter.MyViewHolder viewHolder = new CoApplicantListAdapter.MyViewHolder(view, context, coApplicantsList);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int i=position+1;
        holder.tvName.setText(coApplicantsList.get(position).getName());
        holder.tvNumber.setText("Co-Applicant "+i+"");

    }

    @Override
    public int getItemCount() {
        return coApplicantsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ArrayList<CoApplicant> coApplicantsList;
        TextView tvName, tvNumber;
        Context context;


        public MyViewHolder(View itemView, Context context, ArrayList<CoApplicant> coApplicantsList) {
            super(itemView);
            this.context = context;
            this.coApplicantsList = coApplicantsList;
            tvName = itemView.findViewById(R.id.tv_co_applicant_listview_name);
            tvNumber = itemView.findViewById(R.id.tv_co_number);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.itemClickListener(view, getLayoutPosition());
                }
            });

        }
    }
    public void setItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

}
