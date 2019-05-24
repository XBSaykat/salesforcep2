package net.maxproit.salesforce2.feature.search;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.common.base.Clicklistener;
import net.maxproit.salesforce2.databinding.ActivitySearchUserBinding;
import net.maxproit.salesforce2.feature.search.adapter.SearchAdapter;
import net.maxproit.salesforce2.masum.appdata.AppConstant;
import net.maxproit.salesforce2.masum.model.api.GetExistingCoApplicant;
import net.maxproit.salesforce2.masum.model.api.GetLeadIndex;
import net.maxproit.salesforce2.masum.model.local.CoApplicant;
import net.maxproit.salesforce2.masum.model.local.MyNewLead;
import net.maxproit.salesforce2.masum.utility.MasumCommonUtils;
import net.maxproit.salesforce2.model.search.Search;
import net.maxproit.salesforce2.model.search.searchlist.SearchDataList;
import net.maxproit.salesforce2.model.search.searchlist.SearchList;
import net.maxproit.salesforce2.util.CommonUtil;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchUserActivity extends BaseActivity implements Clicklistener {
    ActivitySearchUserBinding binding;
    private static final String TAG = "SearchUserActivity";
    public static final String LEAD_INDEX_ID = "LEAD_INDEX_ID";
    public static final String CIF_ID = "CIF_ID";
    SearchAdapter adapter;
    private List<SearchDataList> list = new ArrayList<>();


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_search_user;
    }

    @Override
    protected void initComponents() {
        binding = (ActivitySearchUserBinding) getBinding();
        binding.setModel(new Search());


        binding.btnSearch.setOnClickListener(v -> {
            String en = new GsonBuilder().serializeNulls().create().toJson(binding.getModel());
            if (isValid()) {
                if (isNetworkAvailable()) {
                    showProgressDialog();
                    String source = localCash().getString(SharedPreferencesEnum.Key.SEARCH_TYPE);
                    Search search = binding.getModel();
                    search.setSource(source);

                    getApiService().searchUserInfo(search).enqueue(new Callback<SearchList>() {
                        @Override
                        public void onResponse(Call<SearchList> call, Response<SearchList> response) {
                            hideProgressDialog();
                            if (response.isSuccessful()) {
                                binding.mainSearchView.setVisibility(View.GONE);
                                binding.listSearchView.setVisibility(View.VISIBLE);

                                list = response.body().getData();
                                setAdapter();
                            } else showAlertDialog("Oops!", "Try Again");
                        }

                        @Override
                        public void onFailure(Call<SearchList> call, Throwable t) {
                            hideProgressDialog();
                            showAlertDialog("Oops!", "Failed Try Again");

                        }
                    });
                } else showToast("Network not available!");
            } else showToast("Search is Empty !");


        });

    }

    private void setAdapter() {
        adapter = new SearchAdapter(SearchUserActivity.this, list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        binding.rv.setLayoutManager(mLayoutManager);
        binding.rv.setAdapter(adapter);
    }

    @Override
    protected void getIntentData() {

    }


    @Override
    public void viewClick(int i) {
        String random = UUID.randomUUID().toString();
        int id = Integer.parseInt(list.get(i).getIndexID());
        if (localCash().getString(SharedPreferencesEnum.Key.SEARCH_TYPE).equalsIgnoreCase("lead")) {
            getApiService().getLeadDataByLeadIndex(id, random).enqueue(new Callback<GetLeadIndex>() {
                @Override
                public void onResponse(Call<GetLeadIndex> call, Response<GetLeadIndex> response) {
                    if (response.body().getCode().equals("200")) {
                        if (response.body().getData() != null) {
                            net.maxproit.salesforce2.masum.model.api.Data data = response.body().getData();
                            String disDate = CommonUtil.jsonToDate(data.getDisbursementDate());
                            String followUpDate = CommonUtil.jsonToDate(data.getFollowUpDate());
                            String loanAmount = MasumCommonUtils.isNotZero(data.getLoanAmount());
                            String interestRate = MasumCommonUtils.isNotZero(data.getOfferedInterestRate());
                            String opfee = MasumCommonUtils.isNotZero(data.getOfferedProcessFee());
                            MyNewLead myNewLead = new MyNewLead(data.getUserName(), data.getLeadReferenceNo(), data.getCustomerId(), data.getMobileNumberId(), data.getAddressId(),
                                    data.getVisitId(), data.getBranchCode(), data.getProductId(), data.getProductSubCategoryId(), 0, data.getBranchName(), data.getCustomerName(), data.getProfession(), data.getOrganization(),
                                    data.getDesignation(), data.getMobileNumber(), data.getAddress(), data.getSourceOfReference(), data.getProduct(),
                                    data.getProductSubCategory(), loanAmount, interestRate, opfee, disDate,
                                    followUpDate, data.getFollowUp(), data.getRemark(), data.getStatus(), "");
                            myNewLead.setPs(data.getPs());
                            myNewLead.setCity(data.getCity());

                            Bundle bundle = new Bundle();
                            bundle.putSerializable(AppConstant.INTENT_KEY, myNewLead);
                            Intent returnIntent = new Intent();
                            returnIntent.putExtras(bundle);
                            setResult(RESULT_OK, returnIntent);
                            Log.e("activity_data", "search:" + myNewLead.getUserName());

                            finish();
                            hideProgressDialog();
                        }
                    }
                }

                @Override
                public void onFailure(Call<GetLeadIndex> call, Throwable t) {

                }
            });
        }else {

            getApiService().getCoApplicantDataByIndex(random,id).enqueue(new Callback<GetExistingCoApplicant>() {
                @Override
                public void onResponse(Call<GetExistingCoApplicant> call, Response<GetExistingCoApplicant> response) {
                    if (response.body().getCode().equals(getString(R.string.success_code))){
                        CoApplicant coApplicant=new CoApplicant();
                        coApplicant.setcoApplicantDatafromServer(response.body().getData());
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(AppConstant.INTENT_KEY, coApplicant);
                        Intent returnIntent = new Intent();
                        returnIntent.putExtras(bundle);
                        setResult(RESULT_OK, returnIntent);
                        finish();

                    }
                    else {
                        Log.e("","");
                    }
                }

                @Override
                public void onFailure(Call<GetExistingCoApplicant> call, Throwable t) {
                    Log.e("","");
                }
            });




        }
/*        Intent intent = new Intent();
        intent.putExtra(LEAD_INDEX_ID, list.get(i).getIndexID());
        intent.putExtra(CIF_ID, list.get(i).getCIF());
        setResult(Activity.RESULT_OK, intent);
        finish();*/

    }

    boolean isValid() {
        return binding.getModel().getClientName() != null ||
                binding.getModel().getMobile() != null ||
                binding.getModel().getCif() != null ||
                binding.getModel().getNationalID() != null;
    }
}
