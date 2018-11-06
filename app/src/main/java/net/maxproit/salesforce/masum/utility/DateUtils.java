package net.maxproit.salesforce.masum.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {


    public static String getDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date=new Date();
        String strDate=sdf.format(date);
        return strDate;
    }


    public static int isPending(String dateString) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
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
        }
        else if (date1.compareTo(date2) == 0) {
            status = 0;
        }
        return status;
    }

    public static String afterAMonth(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String strDate=sdf.format(date);
        return strDate;
    }

    public static String beforeAMonth(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String strDate=sdf.format(date);
        return strDate;
    }

}
