package net.maxproit.salesforce.feature.salesOfficer.parallelprocess.cib.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.databinding.CibNotrequestRowBinding;
import net.maxproit.salesforce.model.cib.notRequestedCIB.NotRequestedCIB;
import net.maxproit.salesforce.model.login.LocalLogin;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class NotRequestCibAdapter extends RecyclerView.Adapter<NotRequestCibAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";
    LocalLogin localLogin;
    private Context context;
    private List<NotRequestedCIB> list;
    private LayoutInflater layoutInflater;
    private String referrenceid;
    public static final String PRPSPECT_INDEX_ID = "PRPSPECT_INDEX_ID";


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param dataList array list containing path of files
     */
    public NotRequestCibAdapter(Context context, List<NotRequestedCIB> dataList, String referrenceid) {
        this.context = context;
        this.list = dataList;
        localLogin = new LocalLogin(context);
        this.referrenceid = referrenceid;

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        CibNotrequestRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.cib_notrequest_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));


        holder.binding.clLeadItem.setOnClickListener(v -> {
            if (list.get(position).isSelect()) {
                holder.binding.clLeadItem.setBackgroundColor(Color.parseColor("#eaeaea"));
                list.get(position).setSelect(false);
            } else {
                holder.binding.clLeadItem.setBackgroundColor(Color.parseColor("#b4fe5d7b"));
                list.get(position).setSelect(true);
            }


        });


//        holder.binding.clLeadItem.setOnClickListener(v -> {
//            Bundle bundle = new Bundle();
//            bundle.putString(CifActivity.KEY_REFERRENCE_ID, referrenceid);
//            bundle.putString(PRPSPECT_INDEX_ID, list.get(position).getProspectIndexID());
//            Intent intent = new Intent(context, CibDialog.class);
//            intent.putExtras(bundle);
//            context.startActivity(intent);
//
//        });


    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public class ViewFilesHolder extends RecyclerView.ViewHolder {

        private final CibNotrequestRowBinding binding;

        public ViewFilesHolder(final CibNotrequestRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}