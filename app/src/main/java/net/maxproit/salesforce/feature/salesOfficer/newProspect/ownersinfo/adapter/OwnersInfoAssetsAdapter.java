package net.maxproit.salesforce.feature.salesOfficer.newProspect.ownersinfo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.databinding.OwnersAssetsRowBinding;
import net.maxproit.salesforce.feature.salesOfficer.newProspect.guarantorinfo.AddressFragment;
import net.maxproit.salesforce.feature.salesOfficer.newProspect.ownersinfo.PersonalAssetsActivity;
import net.maxproit.salesforce.model.newprospect.PersonalAssets;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/20/2018.
 * heyrezwan@gmail.com
 */
public class OwnersInfoAssetsAdapter extends RecyclerView.Adapter<OwnersInfoAssetsAdapter.ViewFilesHolder> {

    private Context context;
    private List<PersonalAssets> list;
    private LayoutInflater layoutInflater;
    AddressFragment addressFragment;
    public static final int REQUEST_UPDATE = 100;
    public static final String PERSONAL_ASSETS ="PERSONAL_ASSETS";


    public OwnersInfoAssetsAdapter(Context context, List<PersonalAssets> list) {
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
        OwnersAssetsRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.owners_assets_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        //holder.binding.tvId.setText(list.get(position).getPropertytype().getPropertyType());
        holder.binding.clLeadItem.setOnClickListener(v -> {
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.FTYPE,PERSONAL_ASSETS);
            Intent intent = new Intent(context, PersonalAssetsActivity.class);
            String date = new GsonBuilder().serializeNulls().create().toJson(list.get(position));
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.PERSONAL_ASSETS,date);
            SharedPreferencesEnum.getInstance().put(SharedPreferencesEnum.Key.PERSONAL_ASSETS_POSITION,position);
            //context.startActivity(intent);

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
        this.addressFragment = addressFragment;

    }


    public class ViewFilesHolder extends RecyclerView.ViewHolder {

        private final OwnersAssetsRowBinding binding;

        public ViewFilesHolder(final OwnersAssetsRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}
