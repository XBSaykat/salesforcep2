package net.maxproit.salesforce.masum.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import net.maxproit.salesforce.ProspectViewRbm;
import net.maxproit.salesforce.masum.activity.lead.LeadStageActivity;
import net.maxproit.salesforce.masum.model.local.CoApplicant;
import net.maxproit.salesforce.masum.model.local.MyNewLead;
import net.maxproit.salesforce.masum.model.local.MyNewProspect;
import net.maxproit.salesforce.masum.model.local.VisitPlan;
import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.activity.prospect.ProspectStageActivity;


public class ActivityUtils {

    private static ActivityUtils sActivityUtils = null;

    public static ActivityUtils getInstance() {
        if (sActivityUtils == null) {
            sActivityUtils = new ActivityUtils();
        }
        return sActivityUtils;
    }
    public void invokeActivity(Activity activity, Class<?> tClass, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }

    public void invokFromPerformance(Activity activity, Class<?> tClass,int status){
        Bundle bundle = new Bundle();
        Intent intent = new Intent(activity, tClass);
        bundle.putInt(AppConstant.STATUS_INTENT_KEY, status);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void invokRefNumber(Activity activity, Class<?> tClass,String ref){
        Bundle bundle = new Bundle();
        Intent intent = new Intent(activity, tClass);
        bundle.putString(AppConstant.INTENT_KEY, ref);
        bundle.putInt(AppConstant.STATUS_INTENT_KEY, 1);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void invokLeadDetailForProspectStage(Activity activity, MyNewProspect myNewLead){
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstant.INTENT_KEY, myNewLead);
        bundle.putInt(AppConstant.STATUS_INTENT_KEY, 1);
        Intent intent = new Intent(activity, ProspectStageActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void invokLeadDetailForLeadStage(Activity activity, MyNewLead myNewLead){
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstant.INTENT_KEY, myNewLead);
        bundle.putInt(AppConstant.STATUS_INTENT_KEY, 1);
        Intent intent = new Intent(activity, LeadStageActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }


    public static void invokProspectRbmViewStage(Activity activity, MyNewProspect myNewLead){
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstant.INTENT_KEY, myNewLead);

        Intent intent = new Intent(activity,ProspectViewRbm.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void invokCoApplicantViewStage(Activity activity,Class<?> tClass, CoApplicant coApplicant){
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstant.INTENT_KEY, coApplicant);

        Intent intent = new Intent(activity,tClass);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }


    public static void invokVisitPlanDetail(Activity activity,Class<?> tClass, VisitPlan visitPlan){
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstant.INTENT_KEY, visitPlan);
        bundle.putInt(AppConstant.STATUS_INTENT_KEY, 0);
        Intent intent = new Intent(activity, tClass);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void toaster(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}