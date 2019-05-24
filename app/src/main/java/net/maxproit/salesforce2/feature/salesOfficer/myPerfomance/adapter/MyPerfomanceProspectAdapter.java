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
import net.maxproit.salesforce2.databinding.MyPerfomanceProspectRowBinding;
import net.maxproit.salesforce2.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.salesforce2.model.login.LocalLogin;
import net.maxproit.salesforce2.model.myprospect.MyProspect;
import net.maxproit.salesforce2.model.myprospect.updateProspect.OleProspect;
import net.maxproit.salesforce2.network.RestClient;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rezwan Khan chowdhury on 6/25/18.
 * heyRezwan@gmail.com
 */
public class MyPerfomanceProspectAdapter extends RecyclerView.Adapter<MyPerfomanceProspectAdapter.ViewFilesHolder> {
    private static final String TAG = "MyProspectAdapter";
    public String USER_NAME;
    LocalLogin localLogin;
    private AdapterInfo adapterInfo;
    private Context context;
    private MyProspect myProspect;
    private LayoutInflater layoutInflater;
    private boolean isPerformance;
    ProgressDialog progressDialog;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param myProspect array list containing path of files
     */
    public MyPerfomanceProspectAdapter(Context context, MyProspect myProspect, boolean isPerformance) {
        this.adapterInfo = (AdapterInfo) context;
        this.context = context;
        this.myProspect = myProspect;
        localLogin = new LocalLogin(context);
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        USER_NAME = SharedPreferencesEnum.getInstance(context).getString(SharedPreferencesEnum.Key.USER_NAME);

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.isPerformance = isPerformance;
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        MyPerfomanceProspectRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.my_perfomance_prospect_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(myProspect.getData().get(position));

        // ID: myProspect.getData().get(position).getReference()

        holder.binding.clMyProspectItem.setOnClickListener(v -> {
            newProspect(myProspect.getData().get(position).getReference(),position);
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
        return myProspect.getData() == null ? 0 : myProspect.getData().size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public class ViewFilesHolder extends RecyclerView.ViewHolder {

        private final MyPerfomanceProspectRowBinding binding;

        public ViewFilesHolder(final MyPerfomanceProspectRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


}