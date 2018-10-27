package net.maxproit.salesforce.feature.salesOfficer.newProspect;

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
import net.maxproit.salesforce.databinding.VisitRecordProspectBinding;
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

    NewProspectActivity activity;

    FragmentVisitRecordBinding binding;
    Calendar calendar;
    private LinearLayout parentLinearLayout;
    Context context;
    LocalSetting localSetting;
    List<net.maxproit.salesforce.model.newlead.VisitRecord> vrList = new ArrayList<>();

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
        activity = (NewProspectActivity) getActivity();
        calendar = Calendar.getInstance();
        this.context = context;
        localSetting = new LocalSetting(context);


    }

    @Override
    protected void initFragmentComponents() {
        binding = (FragmentVisitRecordBinding) getBinding();
        parentLinearLayout = binding.parentLinearLayout;
        calendar = Calendar.getInstance();
        viPurposeAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, localSetting.getVisitPurposeTypeStringList());


        if (activity.getNewProspect().getVisitRecords() != null) {
            for (VisitRecord visitRecord : activity.getNewProspect().getVisitRecords()) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                VisitRecordProspectBinding childBinding = DataBindingUtil.inflate(
                        inflater, R.layout.visit_record_prospect, null, false);

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
                    visitRecord.setVisitPurpose(s);

                });


                if (!StringUtils.isEmpty(visitRecord.getVisitPurpose())) {
                    if (CommonUtil.isListItemAvailable(CommonUtil.getListPosition(localSetting.getVisitPurposeTypeStringList(), visitRecord.getVisitPurpose()))) {
                        childBinding.spVisitPurpose.setSelection(CommonUtil.getListPosition(localSetting.getVisitPurposeTypeStringList(), visitRecord.getVisitPurpose()));
                    }
                }


                childBinding.btnCLose.setVisibility(View.GONE);


            }
        }


        binding.addbuton.setOnClickListener(v -> {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            VisitRecordProspectBinding c = DataBindingUtil.inflate(
                    inflater, R.layout.visit_record_prospect, null, false);

            c.setModel(new net.maxproit.salesforce.model.newlead.VisitRecord());

            parentLinearLayout
                    .addView(c.getRoot(), parentLinearLayout.getChildCount() - 1);


            c.MeetingDate.setOnClickListener(view ->
                    CommonUtil.showDatePicker(getContext(), c.MeetingDate, calendar));

            c.FollowupDate.setOnClickListener(view ->
                    CommonUtil.showDatePicker(getContext(), c.FollowupDate, calendar));


            // Remove Layout
            c.btnCLose
                    .setOnClickListener((View view) -> parentLinearLayout.removeView((View) view.getParent()));


            // TODO : - Only Test
            net.maxproit.salesforce.model.newlead.VisitRecord vr = c.getModel();
            c.spVisitPurpose.setAdapter(viPurposeAdapter);
            c.spVisitPurpose.setOnSpinnerItemClickListener((i, s) -> vr.setVisitPurpose(s));


            vr.setMeetingDate(vr.getMeetingDate().isEmpty() ? "" : vr.getMeetingDate() + "T10:50:17.023Z");
            vr.setFollowupDate(vr.getFollowupDate().isEmpty() ? "" : vr.getFollowupDate() + "T10:50:17.023Z");
            vrList.add(vr);


        });

        activity.getNewProspect().setVisitRecords(vrList);


    }


}
