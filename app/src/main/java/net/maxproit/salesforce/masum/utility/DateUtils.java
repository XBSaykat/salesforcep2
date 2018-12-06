package net.maxproit.salesforce.masum.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {


    public static  long getStringtoDate( String date){
        SimpleDateFormat sdfStr = new SimpleDateFormat("dd.MM.yyyy");
        Date newDate=null;
        try {
             newDate = sdfStr.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate.getTime();
    }

    public static String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        String strDate = sdf.format(date);
        return strDate;
    }

    public static String getDateStringSqLite() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String strDate = sdf.format(date);
        return strDate;
    }


    public static String getDateFormateForSqlite(String date) {
        SimpleDateFormat sdfStr = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = null;
        try {
            Date newDate = sdfStr.parse(date);
            strDate = sdf.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return strDate;
    }

    public static String jsonToDate(String jsonDateString) {

        try {
            String timestamp = jsonDateString.split("\\(")[1].split("\\+")[0];
            Date createdOn = new Date(Long.parseLong(timestamp));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(createdOn);
            return formattedDate;
        } catch (Exception e) {
            return jsonDateString;
        }

    }

    public static String getDateFormateEt(String date) {
        SimpleDateFormat sdfStr = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = null;
        try {
            Date newDate = sdf.parse(date);
            strDate = sdfStr.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

        return strDate;
    }


    public static int isPending(String dateString) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;

        int status = 0;
        try {
            date1 = sdf.parse(dateString);
            Date d = new Date();
            String currentDate = sdf.format(d);
            date2 = sdf.parse(currentDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date1.compareTo(date2) > 0) {
            status = 2;
        } else if (date1.compareTo(date2) < 0) {
            status = 1;
        } else if (date1.compareTo(date2) == 0) {
            status = 0;
        }
        return status;
    }

    public static String afterAMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(date);
        return strDate;
    }

    public static String beforeAMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(date);
        return strDate;
    }

}
