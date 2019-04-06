package net.maxproit.salesforce;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;

import com.isapanah.awesomespinner.AwesomeSpinner;

import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityMyPerformancePhaseTwoBinding;
import net.maxproit.salesforce.masum.adapter.myperformacecountadapter.MyPerformanceItemAdapter;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.model.api.performance.Datum;
import net.maxproit.salesforce.masum.model.api.performance.Getperformance;
import net.maxproit.salesforce.util.CommonUtil;
import net.maxproit.salesforce.util.SharedPreferencesEnum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPerformancePhaseTwo extends BaseActivity {


    private ActivityMyPerformancePhaseTwoBinding mBinding;
    private MyPerformanceItemAdapter myLeadAdapter;
    private Calendar calendar;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_my_performance_phase_two;
    }

    @Override
    protected void initComponents() {
        mBinding = (ActivityMyPerformancePhaseTwoBinding) getBinding();
        calendar = Calendar.getInstance();

        filterData();
        initListener();
    }

    @Override
    protected void getIntentData() {

    }


    private void callApi(String fromDate, String toDate) {

        AppConstant.fromDate=fromDate;
        AppConstant.toDate=toDate;

        if (isNetworkAvailable()) {
            String username = SharedPreferencesEnum.getInstance(getApplicationContext()).getString(SharedPreferencesEnum.Key.USER_NAME);
            String random = UUID.randomUUID().toString();
            showProgressDialog();
            getApiService().getPerformanceCountData(username, fromDate, toDate, random).enqueue(new Callback<Getperformance>() {
                @Override
                public void onResponse(Call<Getperformance> call, Response<Getperformance> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals("200")) {
                            myLeadAdapter = new MyPerformanceItemAdapter(MyPerformancePhaseTwo.this, (ArrayList<Datum>) response.body().getData());
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            mBinding.recycleViewMyPerformace.setLayoutManager(mLayoutManager);
                            mBinding.recycleViewMyPerformace.setAdapter(myLeadAdapter);
                            myLeadAdapter.notifyDataSetChanged();
                            hideProgressDialog();
                        } else {
                            showAlertDialog(response.body().getStatus(), response.body().getMessage());
                            hideProgressDialog();
                        }
                    } else {
                        showAlertDialog(getString(R.string.error_text), response.errorBody().toString());
                        hideProgressDialog();

                    }
                }


                @Override
                public void onFailure(Call<Getperformance> call, Throwable t) {
                    showAlertDialog(getString(R.string.error_text), t.getMessage());
                    hideProgressDialog();
                }
            });
        } else {
            showAlertDialog(getString(R.string.error_text), getString(R.string.internet_not_available));
        }
    }

    private void initListener() {
        mBinding.btnBack.setOnClickListener(view -> {
            MyPerformancePhaseTwo.super.onBackPressed();
            finish();
        });


    }

    private void filterData() {

        ArrayAdapter<String> filterAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.filter_date_array));
        mBinding.spFilter.setAdapter(filterAdapter);
        mBinding.spFilter.setSelection(1);
        mBinding.spFilter.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {

                String fromDate, toDate;

                switch (i) {

                    case 0:
                        dateFilterLayoutVisible(false);
                        fromDate = CommonUtil.currentDate(calendar);
                        toDate = CommonUtil.currentDate(calendar);
                        callApi(fromDate, toDate);
                        break;

                    case 1:
                        dateFilterLayoutVisible(false);
                        fromDate = CommonUtil.getFirstDayOfCurrentMonth(calendar);
                        toDate = CommonUtil.currentDate(calendar);
                        callApi(fromDate, toDate);
                        break;

                    case 2:
                        dateFilterLayoutVisible(false);
                        fromDate = CommonUtil.getFirstDayOfCurrentYear(calendar);
                        toDate = CommonUtil.currentDate(calendar);
                        callApi(fromDate, toDate);
                        break;

                    case 3:
                        selectDateRange();
                        break;

                    default:
                        dateFilterLayoutVisible(false);
                        fromDate = CommonUtil.getFirstDayOfCurrentMonth(calendar);
                        toDate = CommonUtil.currentDate(calendar);
                        callApi(fromDate, toDate);
                        break;
                }
            }
        });


    }

    void dateFilterLayoutVisible(boolean visibility) {
        if (visibility) {
            mBinding.dateFilterLayout.setVisibility(View.VISIBLE);
        } else
            mBinding.dateFilterLayout.setVisibility(View.GONE);
    }

    private void selectDateRange() {

        dateFilterLayoutVisible(true);

        mBinding.etDateFrom.setOnClickListener(v -> {
            CommonUtil.showDatePicker(getContext(), mBinding.etDateFrom, calendar);
        });
        mBinding.etDateTo.setOnClickListener(v -> {
            CommonUtil.showDatePicker(getContext(), mBinding.etDateTo, calendar);
        });


        mBinding.btnFilter.setOnClickListener(v -> {
            if ((!TextUtils.isEmpty(mBinding.etDateFrom.getText())) && ((!TextUtils.isEmpty(mBinding.etDateTo.getText())))) {

                callApi(mBinding.etDateFrom.getText().toString(), mBinding.etDateTo.getText().toString());
            } else {
                showToast("please select both dates");
            }

        });
    }



}
