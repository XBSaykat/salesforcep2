package net.maxproit.idlc.feature.salesOfficer.newProspect.ownersinfo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.idlc.R;
import net.maxproit.idlc.databinding.GurantorInfoAddressRowBinding;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.AddressFragment;
import net.maxproit.idlc.model.newprospect.Address;

import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/20/2018.
 * heyrezwan@gmail.com
 */
public class OwnersInfoAdressAdapter extends RecyclerView.Adapter<OwnersInfoAdressAdapter.ViewFilesHolder> {

    private Context context;
    private List<Address> list;
    private LayoutInflater layoutInflater;
    AddressFragment addressFragment;



    public OwnersInfoAdressAdapter(Context context, List<Address> list ) {
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
        holder.binding.clLeadItem.setOnClickListener(v -> addressFragment.viewClick(position));



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

        private final GurantorInfoAddressRowBinding binding;

        public ViewFilesHolder(final GurantorInfoAddressRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}
