package net.maxproit.salesforce.feature.salesOfficer.newlead;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseFragment;
import net.maxproit.salesforce.databinding.FragmentVisitRecordBinding;
import net.maxproit.salesforce.databinding.VisitRecordBinding;
import net.maxproit.salesforce.model.newlead.VisitRecord;
import net.maxproit.salesforce.model.setting.LocalSetting;
import net.maxproit.salesforce.util.CommonUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Sadiq Md. Asif on 18-Apr-18.
 * asifsadiqmd@gmail.com
 */

public class VisitRecordFragment extends BaseFragment {
    private static final String TAG = "VisitRecordFragment";
    FragmentVisitRecordBinding binding;
    NewLeadActivity activity;
    Calendar calendar;
    private LinearLayout parentLinearLayout;
    Context context;
    LocalSetting localSetting;
    List<VisitRecord> vrList = new ArrayList<>();

    ArrayAdapter<String> viPurposeAdapter;

    public static VisitRecordFragment newInstance() {
        Bundle args = new Bundle();
        VisitRecordFragment fragment = new VisitRecordFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Integer layoutResourceId() {
        return R.layout.fragment_visit_record;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (NewLeadActivity) getActivity();
        calendar = Calendar.getInstance();
        this.context = context;
        localSetting = new LocalSetting(context);

        viPurposeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getVisitPurposeTypeStringList());



    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentVisitRecordBinding) getBinding();
        parentLinearLayout = binding.parentLinearLayout;


        if (activity.getNewLead().getVisitRecords() != null) {
            for (VisitRecord visitRecord : activity.getNewLead().getVisitRecords()) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                VisitRecordBinding childBinding = DataBindingUtil.inflate(
                        inflater, R.layout.visit_record, null, false);

                visitRecord.setFollowupDate(CommonUtil.jsonToDate(visitRecord.getFollowupDate()));
                visitRecord.setMeetingDate(CommonUtil.jsonToDate(visitRecord.getMeetingDate()));
                childBinding.setModel(visitRecord);

                parentLinearLayout
                        .addView(childBinding.getRoot(), parentLinearLayout.getChildCount() - 1);


                childBinding.MeetingDate.setOnClickListener(view ->
                        CommonUtil.showDatePicker(getContext(), childBinding.MeetingDate, calendar));

                childBinding.FollowupDate.setOnClickListener(view ->
                        CommonUtil.showDatePicker(getContext(), childBinding.FollowupDate, calendar));

                childBinding.spVisitPurpose.setAdapter(viPurposeAdapter);
                childBinding.spVisitPurpose.setOnSpinnerItemClickListener((i, s) -> {

                });

                if (!StringUtils.isEmpty(visitRecord.getVisitPurpose())) {
                    if (CommonUtil.isListItemAvailable(CommonUtil.getListPosition(localSetting.getVisitPurposeTypeStringList(),visitRecord.getVisitPurpose()))) {
                        childBinding.spVisitPurpose.setSelection(CommonUtil.getListPosition(localSetting.getVisitPurposeTypeStringList(),visitRecord.getVisitPurpose()));
                    }
                }


                childBinding.btnCLose.setVisibility(View.GONE);


//                if (!visitRecord.getVisitPurpose().isEmpty()) {
//                    childBinding.spVisitPurpose.setSelection(localSetting.getVisitPurposeTypeStringList().lastIndexOf(visitRecord.getVisitPurpose().isEmpty()));
//                }


            }
        }


        binding.addbuton.setOnClickListener(v -> {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            VisitRecordBinding childBinding = DataBindingUtil.inflate(
                    inflater, R.layout.visit_record, null, false);

            childBinding.setModel(new VisitRecord());

            parentLinearLayout
                    .addView(childBinding.getRoot(), parentLinearLayout.getChildCount() - 1);


            childBinding.MeetingDate.setOnClickListener(view ->
                    CommonUtil.showCurrentDatePicker(getContext(), childBinding.MeetingDate, calendar));

            childBinding.FollowupDate.setOnClickListener(view ->
                    CommonUtil.showDatePicker(getContext(), childBinding.FollowupDate, calendar));
            VisitRecord vr = childBinding.getModel();
            childBinding.spVisitPurpose.setAdapter(viPurposeAdapter);
            childBinding.spVisitPurpose.setOnSpinnerItemClickListener((position, s) -> vr.setVisitPurpose(s));


            // Remove Layout
            childBinding.btnCLose
                    .setOnClickListener((View view) -> parentLinearLayout.removeView((View) view.getParent()));




            vr.setMeetingDate(vr.getMeetingDate().isEmpty() ? "" : vr.getMeetingDate() + "T10:50:17.023Z");
            vr.setFollowupDate(vr.getFollowupDate().isEmpty() ? "" : vr.getFollowupDate() + "T10:50:17.023Z");
            vrList.add(vr);


        });

        activity.getNewLead().setVisitRecords(vrList);


    }


}
