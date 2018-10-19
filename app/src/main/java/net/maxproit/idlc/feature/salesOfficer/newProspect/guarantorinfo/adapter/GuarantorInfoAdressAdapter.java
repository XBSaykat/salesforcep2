package net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.GsonBuilder;

import net.maxproit.idlc.R;
import net.maxproit.idlc.databinding.GurantorInfoAddressRowBinding;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.AddressFragment;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.GuarantorAddressActivity;
import net.maxproit.idlc.model.newprospect.Address;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/20/2018.
 * heyrezwan@gmail.com
 */
public class GuarantorInfoAdressAdapter extends RecyclerView.Adapter<GuarantorInfoAdressAdapter.ViewFilesHolder> {

    private Context context;
    private List<Address> list;
    private LayoutInflater layoutInflater;
    AddressFragment addressFragment;
    public static final int REQUEST_UPDATE = 100;
    public static final String ADDRESS = "ADDRESS";


    public GuarantorInfoAdressAdapter(Context context, List<Address> list) {
        this.context = context;
        this.list = list;

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        GurantorInfoAddressRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.gurantor_info_address_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        holder.binding.clLeadItem.setOnClickListener(v -> {
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.FTYPE, ADDRESS);
            Intent intent = new Intent(context, GuarantorAddressActivity.class);
            String date = new GsonBuilder().serializeNulls().create().toJson(list.get(position));
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.ADDRESS, date);
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.ADDRESS_POSITION, position);
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

        private final GurantorInfoAddressRowBinding binding;

        public ViewFilesHolder(final GurantorInfoAddressRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}
