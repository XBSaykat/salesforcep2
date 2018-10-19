package net.maxproit.idlc.feature.search.adapter;

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
import net.maxproit.idlc.databinding.SearchRowBinding;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.AddressFragment;
import net.maxproit.idlc.feature.salesOfficer.newProspect.guarantorinfo.GuarantorInfoActivity;
import net.maxproit.idlc.feature.search.SearchUserActivity;
import net.maxproit.idlc.model.newprospect.GuarantorsInfo;
import net.maxproit.idlc.model.search.searchlist.SearchDataList;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/20/2018.
 * heyrezwan@gmail.com
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewFilesHolder> {
    private Context context;
    private SearchUserActivity activity;
    private List<SearchDataList> list;
    private LayoutInflater layoutInflater;
    public static final int REQUEST_UPDATE = 100;


    public SearchAdapter(Context context, List<SearchDataList> list) {
        this.context = context;
        this.activity = (SearchUserActivity)context;
        this.list = list;

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public SearchAdapter.ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        SearchRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.search_row, parent, false);
        return new SearchAdapter.ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(SearchAdapter.ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        holder.binding.item.setOnClickListener(v -> {
            activity.viewClick(position);

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

        private final SearchRowBinding binding;

        public ViewFilesHolder(final SearchRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}
