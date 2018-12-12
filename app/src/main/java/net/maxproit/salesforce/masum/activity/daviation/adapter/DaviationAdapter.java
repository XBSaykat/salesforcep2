package net.maxproit.salesforce.masum.activity.daviation.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.databinding.DaviationRequestRowBinding;
import net.maxproit.salesforce.masum.model.api.deviation.deviationlist.DeviationList;
import net.maxproit.salesforce.model.login.LocalLogin;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class DaviationAdapter extends RecyclerView.Adapter<DaviationAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";
    LocalLogin localLogin;
    private Context context;
    private List<DeviationList> list;
    private LayoutInflater layoutInflater;
    private String referrenceid;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param dataList array list containing path of files
     */
    public DaviationAdapter(Context context, List<DeviationList> dataList, String referrenceid) {
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
        DaviationRequestRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.daviation_request_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));


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

        private final DaviationRequestRowBinding binding;

        public ViewFilesHolder(final DaviationRequestRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}