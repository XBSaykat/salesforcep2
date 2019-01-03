package net.maxproit.salesforce.masum.utility;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.widget.EditText;

import net.maxproit.salesforce.masum.activity.lead.LeadStageActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class MasumCommonUtils {


    public static int dpToPx(int dp,Context mContext) {
        Resources r = mContext.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    public static void statusAlert(String title, String text, Activity activity) {

        android.app.AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new android.app.AlertDialog.Builder(activity, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new android.app.AlertDialog.Builder(activity);
        }
        builder.setTitle(title);
        builder.setMessage(text);

        builder.setPositiveButton("OK", (dialog, which) -> {
            activity.finish();
        });

        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static boolean isNullStr(String str) {
        boolean isnull = true;
        if (str == null || str.equals("") || str.equals("0")) {
            isnull = true;
        } else {
            isnull = false;
        }
        return isnull;
    }

    public static String isNotZero(int amount) {
        String data = null;
        if (amount > 0) {
            data = String.valueOf(amount);
        } else data = "";

        return data;
    }

    public static String isNotZero(float amount) {
        String data = null;
        if (amount > 0) {
            data = String.valueOf(amount);
        } else data = "";

        return data;
    }


    public static String calcutateAge(long date) {
        Calendar dob = Calendar.getInstance();
        dob.setTimeInMillis(date);

        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH) ||
                today.get(Calendar.MONTH) < dob.get(Calendar.MONTH) &&
                        today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)
                || today.get(Calendar.DAY_OF_MONTH) == dob.get(Calendar.DAY_OF_MONTH)) {
            age = age;
        }

        Integer ageInt = new Integer(age);
        String ages = ageInt.toString();

        return ages;
    }


    public static void commaSeperator(EditText et,String number){
        try {


            number = number.contains(",") ? number.replaceAll(",", "") : number;
            Long longVal = Long.parseLong(number);

            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ENGLISH);
            formatter.applyPattern("#,###,###,###");
            String formattedString = formatter.format(longVal);

            et.setText(formattedString);
            et.setSelection(et.getText().length());
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        catch (NullPointerException n){

        }
    }

}
