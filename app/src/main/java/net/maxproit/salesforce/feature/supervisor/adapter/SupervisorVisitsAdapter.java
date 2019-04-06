package net.maxproit.salesforce.feature.supervisor.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.databinding.SupervisorVisitsRowBinding;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.supervisor.visits.Datum;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class SupervisorVisitsAdapter extends RecyclerView.Adapter<SupervisorVisitsAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";


    private AdapterInfo adapterInfo;
    private Context context;
    private List<Datum> list;
    private LayoutInflater layoutInflater;
    LocalLogin localLogin;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param dataList array list containing path of files
     */
    public SupervisorVisitsAdapter(Context context, List<Datum> dataList) {
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
        SupervisorVisitsRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.supervisor_visits_row, parent, false);
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

        private final SupervisorVisitsRowBinding binding;

        public ViewFilesHolder(final SupervisorVisitsRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}