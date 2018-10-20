package net.maxproit.idlc.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.maxproit.idlc.model.VisitPlan;

import java.util.ArrayList;

public class VisitPlanDbController {

    private SQLiteDatabase db;
    private Context mContext;

    public VisitPlanDbController(Context context) {
        db = DbHelper.getInstance(context).getWritableDatabase();
        mContext = context;
    }

    public int insertData(String clientType, String mobileNumber, String productType, String area, String purposeOfVisit,
                          String dateOfVisit, String remarks,String status) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.VISIT_PLAN_CLIENT_TYPE, clientType);
        values.put(DbConstants.VISIT_PLAN_MOBILE_NUMBER, mobileNumber);
        values.put(DbConstants.VISIT_PLAN_PRODUCT_TYPE, productType);
        values.put(DbConstants.VISIT_PLAN_AREA, area);
        values.put(DbConstants.VISIT_PLAN_PURPOSE_OF_VISIT, purposeOfVisit);
        values.put(DbConstants.VISIT_PLAN_DATE_OF_VISIT, dateOfVisit);
        values.put(DbConstants.VISIT_PLAN_REMARKS, remarks);
        values.put(DbConstants.LEAD_STATUS, status);


        // Insert the new row, returning the primary key value of the new row
        return (int) db.insert(
                DbConstants.TABLE_VISIT_PLAN,
                DbConstants.COLUMN_NAME_NULLABLE,
                values);
    }


    public void deleteFavoriteItem(int itemId) {
        // Which row to update, based on the ID
        String selection = DbConstants._V_ID + "=?";
        String[] selectionArgs = {String.valueOf(itemId)};

        db.delete(
                DbConstants.TABLE_VISIT_PLAN,
                selection,
                selectionArgs);
    }

    public void deleteFavoriteItemByWord(String itemWord) {
        // Which row to update, based on the ID
        String selection = DbConstants._V_ID + "=?";
        String[] selectionArgs = {String.valueOf(itemWord)};

        db.delete(
                DbConstants.TABLE_VISIT_PLAN,
                selection,
                selectionArgs);
    }

    public void deleteAllFav() {
        db.delete(
                DbConstants.TABLE_VISIT_PLAN,
                null,
                null);
    }

}
