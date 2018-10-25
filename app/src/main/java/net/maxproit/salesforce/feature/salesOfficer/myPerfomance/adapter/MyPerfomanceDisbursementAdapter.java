package net.maxproit.salesforce.feature.salesOfficer.myPerfomance.adapter;

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

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.databinding.DisbursementRowBinding;
import net.maxproit.salesforce.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce.model.login.LocalLogin;
import net.maxproit.salesforce.model.myprospect.updateProspect.OleProspect;
import net.maxproit.salesforce.model.salesOfficer.disbursement.Datum;
import net.maxproit.salesforce.network.RestClient;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rezwan Khan chowdhury on 6/29/18.
 * heyRezwan@gmail.com
 */
public class MyPerfomanceDisbursementAdapter extends RecyclerView.Adapter<MyPerfomanceDisbursementAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";


    private AdapterInfo adapterInfo;
    private Context context;
    private List<Datum> list;
    private LayoutInflater layoutInflater;
    LocalLogin localLogin;
    ProgressDialog progressDialog;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param dataList array list containing path of files
     */
    public MyPerfomanceDisbursementAdapter(Context context, List<Datum> dataList) {
        this.adapterInfo = (AdapterInfo) context;
        this.context = context;
        this.list = dataList;
        localLogin = new LocalLogin(context);
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        DisbursementRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.disbursement_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        // holder.binding.setModel(list.get(position));


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

        private final DisbursementRowBinding binding;

        public ViewFilesHolder(final DisbursementRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}