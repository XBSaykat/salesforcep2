package net.maxproit.idlc.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import net.maxproit.idlc.AppConstant;
import net.maxproit.idlc.feature.salesOfficer.myProspect.ProspectStageActivity;
import net.maxproit.idlc.model.newlead.MyNewLead;


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


}
