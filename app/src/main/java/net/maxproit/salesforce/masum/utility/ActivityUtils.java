package net.maxproit.salesforce.masum.utility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import net.maxproit.salesforce.masum.activity.ActivityDetailsActivity;
import net.maxproit.salesforce.masum.model.VisitPlan;
import net.maxproit.salesforce.masum.sqlite.AppConstant;
import net.maxproit.salesforce.feature.salesOfficer.myProspect.ProspectStageActivity;
import net.maxproit.salesforce.masum.model.MyNewLead;


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

    public static void invokLeadDetailForProspectStage(Activity activity, MyNewLead myNewLead){
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstant.INTENT_KEY, myNewLead);
        Intent intent = new Intent(activity, ProspectStageActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }


    public static void invokVisitPlanDetail(Activity activity, VisitPlan visitPlan){
        Bundle bundle = new Bundle();
        bundle.putSerializable(AppConstant.INTENT_KEY, visitPlan);
        Intent intent = new Intent(activity, ActivityDetailsActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }


}
