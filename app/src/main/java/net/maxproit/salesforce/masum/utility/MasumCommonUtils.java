package net.maxproit.salesforce.masum.utility;

import java.util.Calendar;

public class MasumCommonUtils {


    public static boolean isNullStr(String str){
        boolean isnull=true;
        if (str ==null || str.equals("")) {
            isnull = true;
        }
        else {
            isnull=false;
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

}
