package net.maxproit.salesforce.feature.search;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.GsonBuilder;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.common.base.Clicklistener;
import net.maxproit.salesforce.databinding.ActivitySearchUserBinding;
import net.maxproit.salesforce.feature.search.adapter.SearchAdapter;
import net.maxproit.salesforce.model.search.Search;
import net.maxproit.salesforce.model.search.searchlist.SearchDataList;
import net.maxproit.salesforce.model.search.searchlist.SearchList;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.List;

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
        Intent intent = new Intent();
        intent.putExtra(LEAD_INDEX_ID, list.get(i).getIndexID());
        intent.putExtra(CIF_ID, list.get(i).getCIF());
        setResult(Activity.RESULT_OK, intent);
        finish();

    }

    boolean isValid() {
        return binding.getModel().getClientName() != null ||
                binding.getModel().getMobile() != null ||
                binding.getModel().getCif() != null ||
                binding.getModel().getNationalID() != null;
    }
}
