package net.maxproit.idlc.feature.salesOfficer.newProspect.ownersinfo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.GsonBuilder;

import net.maxproit.idlc.R;
import net.maxproit.idlc.databinding.GurantorInfoRowBinding;
import net.maxproit.idlc.databinding.OwnerInfoRowBinding;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.AddressFragment;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.GuarantorInfoActivity;
import net.maxproit.idlc.feature.salesOfficer.newProspect.ownersinfo.OwnersInfoActivity;
import net.maxproit.idlc.model.newprospect.GuarantorsInfo;
import net.maxproit.idlc.model.newprospect.ProprietorsInfo;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/20/2018.
 * heyrezwan@gmail.com
 */
public class OwnerInfoAdapter extends RecyclerView.Adapter<OwnerInfoAdapter.ViewFilesHolder> {
    public static final String OWNER = "OWNER";
    private Context context;
    private List<ProprietorsInfo> list;
    private LayoutInflater layoutInflater;
    AddressFragment addressFragment;
    public static final int REQUEST_UPDATE = 100;



    public OwnerInfoAdapter(Context context, List<ProprietorsInfo> list ) {
        this.context = context;
        this.list = list;

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public OwnerInfoAdapter.ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        OwnerInfoRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.owner_info_row, parent, false);
        return new OwnerInfoAdapter.ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(OwnerInfoAdapter.ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        holder.binding.clLeadItem.setOnClickListener(v ->{
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.FTYPE,OWNER);
            Intent intent = new Intent(context, OwnersInfoActivity.class);
            String date = new GsonBuilder().serializeNulls().create().toJson(list.get(position));
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.OWNERS_INFO,date);
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.OWNERS_INFO_POSITION,position);
            ((Activity) context).startActivityForResult(intent,REQUEST_UPDATE);


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
        this.addressFragment =addressFragment;

    }


    public class ViewFilesHolder extends RecyclerView.ViewHolder {

        private final OwnerInfoRowBinding binding;

        public ViewFilesHolder(final OwnerInfoRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}
