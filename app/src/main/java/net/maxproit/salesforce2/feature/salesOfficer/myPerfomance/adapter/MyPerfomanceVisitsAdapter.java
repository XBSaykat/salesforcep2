package net.maxproit.salesforce2.feature.salesOfficer.myPerfomance.adapter;

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

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.databinding.SupervisorVisitsRowBinding;
import net.maxproit.salesforce2.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce2.model.login.LocalLogin;
import net.maxproit.salesforce2.model.myprospect.updateProspect.OleProspect;
import net.maxproit.salesforce2.model.supervisor.visits.Datum;
import net.maxproit.salesforce2.network.RestClient;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class MyPerfomanceVisitsAdapter extends RecyclerView.Adapter<MyPerfomanceVisitsAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";
    LocalLogin localLogin;
    private AdapterInfo adapterInfo;
    private Context context;
    private List<Datum> list;
    private LayoutInflater layoutInflater;
    ProgressDialog progressDialog;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param dataList array list containing path of files
     */
    public MyPerfomanceVisitsAdapter(Context context, List<Datum> dataList) {
        this.adapterInfo = (AdapterInfo) context;
        this.context = context;
        this.list = dataList;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        localLogin = new LocalLogin(context);

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        SupervisorVisitsRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.supervisor_visits_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));


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

        private final SupervisorVisitsRowBinding binding;

        public ViewFilesHolder(final SupervisorVisitsRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}