package net.maxproit.idlc.feature.salesOfficer.parallelprocess.cif.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.idlc.R;
import net.maxproit.idlc.databinding.CifNotrequestRowBinding;
import net.maxproit.idlc.model.cif.notRequestedCIF.NotRequestedCif;
import net.maxproit.idlc.model.login.LocalLogin;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class NotRequestCifAdapter extends RecyclerView.Adapter<NotRequestCifAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";
    LocalLogin localLogin;
    private Context context;
    private List<NotRequestedCif> list;
    private LayoutInflater layoutInflater;
    private String referrenceid;
    public static final String PRPSPECT_INDEX_ID = "PRPSPECT_INDEX_ID";
    public static final String PRPSPECT_NAME = "PRPSPECT_NAME";


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param dataList array list containing path of files
     */
    public NotRequestCifAdapter(Context context, List<NotRequestedCif> dataList, String referrenceid) {
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
        CifNotrequestRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.cif_notrequest_row, parent, false);
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
//            bundle.putString(PRPSPECT_NAME, list.get(position).getProspectName());
//            Intent intent = new Intent(context, CifDialog.class);
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

        private final CifNotrequestRowBinding binding;

        public ViewFilesHolder(final CifNotrequestRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}