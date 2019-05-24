package net.maxproit.salesforce2.feature.salesOfficer.myPerfomance.disbursement.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.databinding.DisSearchRowBinding;
import net.maxproit.salesforce2.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce2.model.login.LocalLogin;
import net.maxproit.salesforce2.model.search.searchlist.disbursementsearch.DisbursementSearchResponce;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class DisbursementSearchAdapter extends RecyclerView.Adapter<DisbursementSearchAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";
    LocalLogin localLogin;
    private AdapterInfo adapterInfo;
    private Context context;
    private List<DisbursementSearchResponce> list;
    private LayoutInflater layoutInflater;
    ProgressDialog progressDialog;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param dataList array list containing path of files
     */
    public DisbursementSearchAdapter(Context context, List<DisbursementSearchResponce> dataList) {
        this.adapterInfo = (AdapterInfo) context;
        this.context = context;
        this.list = dataList;
        localLogin = new LocalLogin(context);
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        DisSearchRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.dis_search_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        holder.binding.clMyProspectItem.setOnClickListener(v -> {
            adapterInfo.adSuccess(list.get(position).getProspectReferenceNo());
        });



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

        private final DisSearchRowBinding binding;

        public ViewFilesHolder(final DisSearchRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}