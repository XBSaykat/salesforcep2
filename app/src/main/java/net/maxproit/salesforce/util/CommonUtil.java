package net.maxproit.salesforce.util;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.isapanah.awesomespinner.AwesomeSpinner;
import com.whiteelephant.monthpicker.MonthPickerDialog;

import net.maxproit.salesforce.R;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Contains common utilities for the app
 */
public class CommonUtil {
    private static ProgressDialog mProgressDialog;

    /**
     * Shows a progress dialog with title and message and not cancelable
     *
     * @param context Activity reference
     * @param title Title of the Progress dialog
     * @param message ResponseMessage of the Progress dialog
     */
    public static void showProgressDialog(Context context, String title, String message) {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = ProgressDialog.show(context, title, message);
    }

    /**
     * Hides the visible progress dialog
     */
    public static void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    /**
     * Shows a Alert Dialog with title and message and a OK button
     *
     * @param context Activity Reference
     * @param title Title of the Alert Dialog
     * @param message ResponseMessage of Alert Dialog
     */
    public static void showAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Convert a base64 to Bitmap
     *
     * @param base64EncodedImage base64 of the image
     * @return Bitmap of the image
     */
    public static Bitmap getBitmapFromBase64(byte[] base64EncodedImage) {
        return BitmapFactory.decodeByteArray(base64EncodedImage, 0, base64EncodedImage.length);
    }


    /**
     * @param context Activity Reference
     * @param editText EditText Reference
     * @param c Calendar Obj
     */
    public static void showDatePicker(Context context, final EditText editText, Calendar c) {
        DatePickerDialog dpd = new DatePickerDialog(context, R.style.DatePickerDialogTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                mm += 1;
                editText.setText(yy + "-" + (mm) + "-" + dd);

            }
        },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
        dpd.show();


    }

    public static String emptyFieldToZero(String value){
            if (value != null){
            if (value.equals("")) {
                value = "0";
                return value;
            } else {
                return value;
            }
            }
        return value = "0";

    }
    public static void showCurrentDatePicker(Context context, final EditText editText, Calendar c) {
        DatePickerDialog dpd = new DatePickerDialog(context, R.style.DatePickerDialogTheme, (datePicker, yy, mm, dd) -> {

            editText.setText(yy + "-" + (mm + 1) + "-" + dd);

        },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
        dpd.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dpd.show();


    }


    public static void showCurrentDatePickerFollowUp(Context context, final EditText editText, Calendar c) {
        DatePickerDialog dpd = new DatePickerDialog(context, R.style.DatePickerDialogTheme, (datePicker, yy, mm, dd) -> {

            editText.setText(yy + "-" + (mm + 1) + "-" + dd);

        },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));
        //dpd.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        dpd.show();


    }


    public static String theMonth(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }


    public static void showMonthYearPicker(Context context, final EditText editText, Calendar c) {
        MonthPickerDialog.Builder bu = new MonthPickerDialog.Builder(context, new MonthPickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(int selectedMonth, int selectedYear) {
                selectedMonth += 1;
                editText.setText(selectedYear+"-"+selectedMonth);

            }
        },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH));
        bu.build().show();

    }

    public static String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11) {
            month = months[num];
        }
        return month;
    }


    public static String jsonToDate(String jsonDateString) {

        try{
            String timestamp = jsonDateString.split("\\(")[1].split("\\+")[0];
            Date createdOn = new Date(Long.parseLong(timestamp));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(createdOn);
            return formattedDate;
        }catch (Exception e){
            return jsonDateString;
        }

    }




    public static void numberToWord(EditText input, TextView Output) {

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String number = input.getText().toString();
                if (!number.isEmpty()) {
                    // Output.setText(NumberToWordsConverter.convert(Integer.parseInt(number)));
                    Output.setText(NumberToWordsConverter.convert(Integer.parseInt(number.replaceAll(",", ""))));
                } else {
                    Output.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    // double Emi = Math.Ceiling(-PMT((interestRate / 1200), termInMonth, ammount));


    public static double emiCalculator(double interestRate, double termInMonth, double Ammount) {
        // double d =(interestRate/1200) * Ammount * Math.pow((1 + (interestRate/1200)), termInMonth) / (1 - Math.pow((1 + (interestRate/1200)), termInMonth));


        // return Math.ceil(-d);
        return Math.round((Ammount * interestRate / (12 * 100) * Math.pow(1 + interestRate / (12 * 100), termInMonth)) / (Math.pow(1 + interestRate / (12 * 100), termInMonth) - 1));
    }


    public static void editTextPercentCalculation(EditText editText) {
        if (!StringUtils.isEmpty(editText.getText().toString())) {
            if (Double.parseDouble(editText.getText().toString()) > 100) {
                editText.setText(editText.getText().toString().substring(0, 2));
                editText.setSelection(editText.getText().toString().length());
            }
        }
    }


    public static int getListPosition(List<String> list, String s) {
        int r = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(s)) {
                r = i;
            }
        }

        return r;
    }

    public static boolean isListItemAvailable(int i) {
        return i != -1;


    }

    public static void setSpinner(Context c,AwesomeSpinner spinner,List<String> list){
        ArrayAdapter<String>  titleAdapter = new ArrayAdapter<String>(c, android.R.layout.simple_spinner_item, list);
        spinner.setAdapter(titleAdapter);





    }

    public static void bindSpinner(AwesomeSpinner spOwnerTitle, List<String> list, String s) {
        if (!StringUtils.isEmpty(s)) {
            if (CommonUtil.isListItemAvailable(CommonUtil.getListPosition(list,s))) {
                spOwnerTitle.setSelection(CommonUtil.getListPosition(list,s));
            }
        }
    }


}
