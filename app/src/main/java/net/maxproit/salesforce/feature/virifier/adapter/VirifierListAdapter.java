package net.maxproit.salesforce.feature.virifier.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.databinding.VirifierListRowBinding;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.myprospect.updateProspect.OleProspect;
import net.maxproit.salesforce.model.virifier.virifierlist.Datum;
import net.maxproit.salesforce.network.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rezwan Khan chowdhury on 6/25/18.
 * heyRezwan@gmail.com
 */
public class VirifierListAdapter extends RecyclerView.Adapter<VirifierListAdapter.ViewFilesHolder> {
    private static final String TAG = "VirifierListAdapter";
    public static final String VERRIFIER = "verrifier";


    private AdapterInfo adapterInfo;
    private Context context;
    private List<Datum> list;
    private LayoutInflater layoutInflater;
    LocalLogin localLogin;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param feedItems array list containing path of files
     */
    public VirifierListAdapter(Context context, List<Datum> feedItems) {
        this.adapterInfo = (AdapterInfo) context;
        this.context = context;
        this.list = feedItems;
        localLogin = new LocalLogin(context);

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        VirifierListRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.virifier_list_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        holder.binding.clLeadItem.setOnClickListener(v -> {

            adapterInfo.adSuccess(list.get(position).getLeadReferenceNo());
        });


    }


    private void prospectAction(String id, String y) {
        adapterInfo.adShowProgressDialog();

        RestClient.getInstance().callRetrofit().getProspect(id, "jjj").enqueue(new Callback<OleProspect>() {
            @Override
            public void onResponse(Call<OleProspect> call, Response<OleProspect> response) {
                adapterInfo.adHideProgressDialog();
                if (response.isSuccessful()) {
                    String en = new GsonBuilder().serializeNulls().create().toJson(response.body());
                    Log.d(TAG, "MYProspect: " + en);

                    Bundle bundle = new Bundle();
                    bundle.putString("ROOT", y);
                    bundle.putString("DATA", en);

                    adapterInfo.startActivity(false, bundle, 200);
                } else Toast.makeText(context, "Responce Failed", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<OleProspect> call, Throwable t) {
                adapterInfo.adHideProgressDialog();
                Toast.makeText(context, "Responce Failed", Toast.LENGTH_SHORT).show();

            }
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

        private final VirifierListRowBinding binding;

        public ViewFilesHolder(final VirifierListRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}