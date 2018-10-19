package net.maxproit.idlc.feature.supervisor.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.idlc.R;
import net.maxproit.idlc.databinding.SupervisorFollowRowBinding;
import net.maxproit.idlc.feature.salesOfficer.myPerfomance.MyPerfomancFollowUpCallsActivity;
import net.maxproit.idlc.feature.salesOfficer.myPerfomance.MyPerfomanceLeadActivity;
import net.maxproit.idlc.model.login.LocalLogin;
import net.maxproit.idlc.model.supervisor.user.User;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class SupervisorFupAdapter extends RecyclerView.Adapter<SupervisorFupAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";


    private AdapterInfo adapterInfo;
    private Context context;
    private List<User> list;
    private LayoutInflater layoutInflater;
    LocalLogin localLogin;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param dataList array list containing path of files
     */
    public SupervisorFupAdapter(Context context, List<User> dataList) {
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
        SupervisorFollowRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.supervisor_follow_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        holder.binding.clLeadItem.setOnClickListener(v -> {
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.USER_NAME_PER,list.get(position).getUserName());

            context.startActivity(new Intent(context, MyPerfomancFollowUpCallsActivity.class));
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

        private final SupervisorFollowRowBinding binding;

        public ViewFilesHolder(final SupervisorFollowRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}