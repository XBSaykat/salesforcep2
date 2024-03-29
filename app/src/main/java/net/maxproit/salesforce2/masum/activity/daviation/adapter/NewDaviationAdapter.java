package net.maxproit.salesforce2.masum.activity.daviation.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.databinding.NewDaviationRequestRowBinding;
import net.maxproit.salesforce2.masum.model.api.deviation.postdeviation.DeviationDetail;
import net.maxproit.salesforce2.masum.model.api.deviation.postdeviation.DeviationJustification;
import net.maxproit.salesforce2.model.login.LocalLogin;

import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class NewDaviationAdapter extends RecyclerView.Adapter<NewDaviationAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";
    LocalLogin localLogin;
    private Context context;
    private List<DeviationDetail> list;
    private LayoutInflater layoutInflater;
    private String referrenceid;


    /**
     * Returns adapter instance
     *
     * @param context  the context calling this adapter
     * @param dataList array list containing path of files
     */
    public NewDaviationAdapter(Context context, List<DeviationDetail> dataList, String referrenceid) {
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
        NewDaviationRequestRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.new_daviation_request_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        StringBuilder stringBuilder = new StringBuilder();
        for (DeviationJustification justification : list.get(position).getDeviationJustifications()) {
            stringBuilder.append(justification.getJustification() + ",");
        }

        // need to remove comma
        String str = stringBuilder.toString();
        str = str.replaceAll(",$", "");

        holder.binding.textView28.setText(str);
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

        private final NewDaviationRequestRowBinding binding;

        public ViewFilesHolder(final NewDaviationRequestRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;

        }
    }


}