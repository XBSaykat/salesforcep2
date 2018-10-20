package net.maxproit.idlc.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.maxproit.idlc.model.VisitPlan;
import net.maxproit.idlc.model.newlead.MyNewLead;

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


        // Insert the new row, returning the primary key value of the new row
        return (int) db.insert(
                DbConstants.TABLE_VISIT_PLAN,
                DbConstants.COLUMN_NAME_NULLABLE,
                values);
    }

    public ArrayList<VisitPlan> getAllData() {

        String[] projection = {
                DbConstants._V_ID,
                DbConstants.VISIT_PLAN_CLIENT_TYPE,
                DbConstants.VISIT_PLAN_MOBILE_NUMBER,
                DbConstants.VISIT_PLAN_PRODUCT_TYPE,
                DbConstants.VISIT_PLAN_AREA,
                DbConstants.VISIT_PLAN_PURPOSE_OF_VISIT,
                DbConstants.VISIT_PLAN_DATE_OF_VISIT,
                DbConstants.VISIT_PLAN_REMARKS,

        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants._V_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_VISIT_PLAN,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchData(c);
    }


    private ArrayList<VisitPlan> fetchData(Cursor c) {
        ArrayList<VisitPlan> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    int id = c.getInt(c.getColumnIndexOrThrow(DbConstants._V_ID));
                    String clientType = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_CLIENT_TYPE));
                    String mobileNumber = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_MOBILE_NUMBER));
                    String productType = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_PRODUCT_TYPE));
                    String area = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_AREA));
                    String purposeOfVisit = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_PURPOSE_OF_VISIT));
                    String dateOfVisit = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_DATE_OF_VISIT));
                    String remarks = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_REMARKS));



                    // wrap up data list and return
                    favDataArray.add(new VisitPlan(id, clientType, mobileNumber, productType, area, purposeOfVisit, dateOfVisit, remarks,""));
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public void deleteItem(int itemId) {
        // Which row to update, based on the ID
        String selection = DbConstants._L_ID + "=?";
        String[] selectionArgs = {String.valueOf(itemId)};

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
