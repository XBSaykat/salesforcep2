package net.maxproit.salesforce2.feature.salesOfficer.parallelprocess.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.databinding.DisbursementRowBinding;
import net.maxproit.salesforce2.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce2.model.login.LocalLogin;
import net.maxproit.salesforce2.model.salesOfficer.disbursement.Datum;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class DeviationAdapter extends RecyclerView.Adapter<DeviationAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";
    LocalLogin localLogin;
    private AdapterInfo adapterInfo;
    private Context context;
    private List<Datum> list;
    private LayoutInflater layoutInflater;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param dataList array list containing path of files
     */
    public DeviationAdapter(Context context, List<Datum> dataList) {
        this.adapterInfo = (AdapterInfo) context;
        this.context = context;
        this.list = dataList;
        localLogin = new LocalLogin(context);

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        DisbursementRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.disbursement_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        // holder.binding.setModel(list.get(position));


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

        private final DisbursementRowBinding binding;

        public ViewFilesHolder(final DisbursementRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}