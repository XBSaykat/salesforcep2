package net.maxproit.idlc.feature.salesOfficer.myProspect.adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import net.maxproit.idlc.R;
import net.maxproit.idlc.databinding.MyProspectRowBinding;
import net.maxproit.idlc.feature.supervisor.adapter.AdapterInfo;
import net.maxproit.idlc.model.login.LocalLogin;
import net.maxproit.idlc.model.mylead.MyLeadApproval;
import net.maxproit.idlc.model.mylead.approvalresponce.ApprovalResponce;
import net.maxproit.idlc.model.myprospect.Data;
import net.maxproit.idlc.model.myprospect.MyProspect;
import net.maxproit.idlc.model.myprospect.updateProspect.OleProspect;
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
public class MyProspectAdapter extends RecyclerView.Adapter<MyProspectAdapter.ViewFilesHolder> {
    private static final String TAG = "MyProspectAdapter";


    private AdapterInfo adapterInfo;
    private Context context;
    private MyProspect myProspect;
    private LayoutInflater layoutInflater;
    private boolean isPerformance;
    LocalLogin localLogin;
    public static final String APPROVED = "N";
    public static final String REJECT = "C";
    public static final String TYPE = "prospect";
    public String USER_NAME;
    List<Data> list, filterList;
    ProgressDialog progressDialog;
    private ApprovalFilterProspect filter;


    /**
     * Returns adapter instance
     *
     * @param context the context calling this adapter
     * @param myProspect array list containing path of files
     */
    public MyProspectAdapter(Context context, MyProspect myProspect, boolean isPerformance) {
        this.adapterInfo = (AdapterInfo) context;
        this.context = context;
        this.myProspect = myProspect;
        this.filterList = myProspect.getData();
        this.list = myProspect.getData();
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
        MyProspectRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.my_prospect_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        holder.binding.clMyProspectItem.setOnClickListener(v ->
        {
           /* if (!isPerformance) {
                shoDialog(myProspect.getData().get(position).getReference());
            }*/

            newProspect(myProspect.getData().get(position).getReference());

        });

        holder.binding.btnApproved.setOnClickListener(v -> {
            approv(myProspect.getData().get(position).getReference());
        });
        holder.binding.btnReject.setOnClickListener(v -> {
            reject(myProspect.getData().get(position).getReference());

        });


    }


    private void reject(String id) {
        if (!id.isEmpty()) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(context);
            }
            builder.setTitle("Reject Prospect");
            builder.setMessage("Are you sure you want to reject this prospect?");
            builder.setIcon(R.drawable.ic_reject);
            builder.setNegativeButton("NO", null);
            builder.setPositiveButton("Yes", (DialogInterface dialog, int which) ->
                    callApproval(id, REJECT));
            AlertDialog dialog = builder.create();
            dialog.show();
        } else Toast.makeText(context, "Id is empty", Toast.LENGTH_SHORT).show();

    }

    private void approv(String id) {
        if (!id.isEmpty()) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(context);
            }
            builder.setTitle("Proceed Prospect");
            builder.setMessage("Are you sure you want to proceed this prospect?");
            builder.setIcon(R.drawable.ic_approved);
            builder.setNegativeButton("No", null);
            builder.setPositiveButton("Yes", (dialog, which) ->
                    callApproval(id, APPROVED));
            AlertDialog dialog = builder.create();
            dialog.show();
        } else Toast.makeText(context, "Id is empty", Toast.LENGTH_SHORT).show();
    }

    private void callApproval(String id, String type) {
        progressDialog.show();
        MyLeadApproval approval = new MyLeadApproval();
        approval.setApprovalType(TYPE);
        approval.setReferenceNo(id);
        approval.setApprovalSetID(0);
        approval.setCurrentLevel(1);
        approval.setStatus(type);
        approval.setRemark("");
        approval.setUser(USER_NAME);
        approval.setBranch(localLogin.getBranch());
        approval.setSpApprovalReqId(0);



        RestClient.getInstance().callRetrofit().myProspectApproval(approval).enqueue(new Callback<ApprovalResponce>() {
            @Override
            public void onResponse(Call<ApprovalResponce> call, Response<ApprovalResponce> response) {
                progressDialog.cancel();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        adapterInfo.adSuccess("ok");

                        if (type.equals(APPROVED)) {

                            Toast.makeText(context, "Approved", Toast.LENGTH_SHORT).show();

                        } else Toast.makeText(context, "Reject", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(context, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(context, "Responce failed", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<ApprovalResponce> call, Throwable t) {
                progressDialog.cancel();
                Toast.makeText(context, "Responce failed", Toast.LENGTH_SHORT).show();


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

    private void newProspect(String id) {
        progressDialog.show();

        String random = UUID.randomUUID().toString();
        RestClient.getInstance().callRetrofit().getProspect(id, random).enqueue(new Callback<OleProspect>() {
            @Override
            public void onResponse(Call<OleProspect> call, Response<OleProspect> response) {
                progressDialog.cancel();
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        String en = new GsonBuilder().serializeNulls().create().toJson(response.body());
                        Bundle bundle = new Bundle();
                        bundle.putString("ROOT", "new");
                        bundle.putString("DATA", en);
                        adapterInfo.startActivity(false, bundle);
                    } else
                        Toast.makeText(context, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                } else Toast.makeText(context, "NO data found", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<OleProspect> call, Throwable t) {
                progressDialog.cancel();
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public class ViewFilesHolder extends RecyclerView.ViewHolder {

        private final MyProspectRowBinding binding;

        public ViewFilesHolder(final MyProspectRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }

    //RETURN FILTER OBJ
    public Filter getFilter() {
        if (filter == null) {
            filter = new ApprovalFilterProspect(filterList, this);
        }

        return filter;
    }


    public void showErrorDialog(String message) {

    }


}