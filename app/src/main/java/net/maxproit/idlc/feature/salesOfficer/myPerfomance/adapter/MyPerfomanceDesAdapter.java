package net.maxproit.idlc.feature.salesOfficer.myPerfomance.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import net.maxproit.idlc.R;
import net.maxproit.idlc.databinding.MyPerfomanceDesRowBinding;
import net.maxproit.idlc.databinding.MyPerfomanceLeadRowBinding;
import net.maxproit.idlc.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.idlc.model.login.LocalLogin;
import net.maxproit.idlc.model.mylead.Data;
import net.maxproit.idlc.model.myprospect.updateProspect.OleProspect;
import net.maxproit.idlc.model.sd.Disbursement;
import net.maxproit.idlc.network.RestClient;
import net.maxproit.idlc.util.SharedPreferencesEnum;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rezwan Khan chowdhury on 6/25/18.
 * heyRezwan@gmail.com
 */
public class MyPerfomanceDesAdapter extends RecyclerView.Adapter<MyPerfomanceDesAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";
    public String USER_NAME;
    LocalLogin localLogin;
    private AdapterInfo adapterInfo;
    private Context context;
    private List<Disbursement> list;
    private LayoutInflater layoutInflater;
    ProgressDialog progressDialog;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param feedItems array list containing path of files
     */
    public MyPerfomanceDesAdapter(Context context, List<Disbursement> feedItems) {
        this.context = context;
        this.adapterInfo = (AdapterInfo) context;
        this.list = feedItems;
        localLogin = new LocalLogin(context);
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        USER_NAME = SharedPreferencesEnum.getInstance(context).getString(SharedPreferencesEnum.Key.USER_NAME);

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        MyPerfomanceDesRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.my_perfomance_des_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));

        // ID:list.get(position).getReference()
        holder.binding.clLeadItem.setOnClickListener(v -> {
            newProspect(list.get(position).getReference(),position);
        });

    }
    private void newProspect(String reference, int position) {
        progressDialog.show();

        String random = UUID.randomUUID().toString();
        RestClient.getInstance().callRetrofit().getProspect(reference, random).enqueue(new Callback<OleProspect>() {
            @Override
            public void onResponse(Call<OleProspect> call, Response<OleProspect> response) {
                progressDialog.cancel();
                if (response.isSuccessful()) {
                    String en = new GsonBuilder().serializeNulls().create().toJson(response.body());

                    Bundle bundle = new Bundle();
                    bundle.putString("ROOT", "new");
                    bundle.putString("DATA", en);
//                    bundle.putString(ApprovalSetID, list.get(position).getApprovalSetID());
//                    bundle.putString(CurrentLevel, list.get(position).getCurrentLevel());
                    Log.d(TAG, "onResponse: " + en);

                    adapterInfo.startActivity(false, bundle);
                } else Toast.makeText(context, "NO data found", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<OleProspect> call, Throwable t) {
                progressDialog.cancel();
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();

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

        private final MyPerfomanceDesRowBinding binding;

        public ViewFilesHolder(final MyPerfomanceDesRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}