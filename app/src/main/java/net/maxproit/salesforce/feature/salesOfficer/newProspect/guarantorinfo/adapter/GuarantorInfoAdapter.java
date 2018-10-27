package net.maxproit.salesforce.feature.salesOfficer.newProspect.guarantorinfo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.databinding.GurantorInfoRowBinding;
import net.maxproit.salesforce.feature.salesOfficer.newProspect.guarantorinfo.AddressFragment;
import net.maxproit.salesforce.feature.salesOfficer.newProspect.guarantorinfo.GuarantorInfoActivity;
import net.maxproit.salesforce.model.newprospect.GuarantorsInfo;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/20/2018.
 * heyrezwan@gmail.com
 */
public class GuarantorInfoAdapter extends RecyclerView.Adapter<GuarantorInfoAdapter.ViewFilesHolder> {
    public static final String GUARANTOR = "GUARANTOR";
    private Context context;
    private List<GuarantorsInfo> list;
    private LayoutInflater layoutInflater;
    AddressFragment addressFragment;
    public static final int REQUEST_UPDATE = 100;


    public GuarantorInfoAdapter(Context context, List<GuarantorsInfo> list) {
        this.context = context;
        this.list = list;

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public GuarantorInfoAdapter.ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        GurantorInfoRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.gurantor_info_row, parent, false);
        return new GuarantorInfoAdapter.ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(GuarantorInfoAdapter.ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        holder.binding.clLeadItem.setOnClickListener(v -> {
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.FTYPE, GUARANTOR);
            Intent intent = new Intent(context, GuarantorInfoActivity.class);
            String date = new GsonBuilder().serializeNulls().create().toJson(list.get(position));
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.GUARANTOR_INFO, date);
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.GUARANTOR_INFO_POSITION, position);
            ((Activity) context).startActivityForResult(intent, REQUEST_UPDATE);
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

    public void setContext(AddressFragment addressFragment) {
        this.addressFragment = addressFragment;

    }


    public class ViewFilesHolder extends RecyclerView.ViewHolder {

        private final GurantorInfoRowBinding binding;

        public ViewFilesHolder(final GurantorInfoRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}
