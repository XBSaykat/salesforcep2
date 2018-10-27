package net.maxproit.salesforce.feature.upload.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.databinding.DocumentListRowBinding;
import net.maxproit.salesforce.feature.salesOfficer.mylead.MyLeadActivity;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.mylead.Data;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/25/18.
 * heyRezwan@gmail.com
 */
public class DocumentUploadAdapter extends RecyclerView.Adapter<DocumentUploadAdapter.ViewFilesHolder> {

    public String USER_NAME;
    MyLeadActivity activity;
    LocalLogin localLogin;
    private AdapterInfo adapterInfo;
    private Context context;
    private List<Data> list;
    private LayoutInflater layoutInflater;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param feedItems array list containing path of files
     */
    public DocumentUploadAdapter(Context context, List<Data> feedItems) {
        this.adapterInfo = (AdapterInfo) context;
        this.activity = (MyLeadActivity) context;
        this.context = context;
        this.list = feedItems;
        localLogin = new LocalLogin(context);
        USER_NAME = SharedPreferencesEnum.getInstance(context).getString(SharedPreferencesEnum.Key.USER_NAME);

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        DocumentListRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.document_list_row, parent, false);
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

        private final DocumentListRowBinding binding;

        public ViewFilesHolder(final DocumentListRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}