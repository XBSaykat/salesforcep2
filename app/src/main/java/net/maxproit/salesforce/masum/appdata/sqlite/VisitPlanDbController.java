package net.maxproit.salesforce.masum.appdata.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import net.maxproit.salesforce.masum.model.VisitPlan;

import java.util.ArrayList;

public class VisitPlanDbController {
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private Context mContext;

    public VisitPlanDbController(Context context) {
        db = DbHelper.getInstance(context).getWritableDatabase();
        mContext = context;
    }

    public VisitPlanDbController open() throws SQLException {
        dbHelper = new DbHelper(mContext);
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    public int insertData(String clientName, String clientType, String mobileNumber, String productType, String city, String policeStation, String purposeOfVisit,
                          String dateOfVisit, String remarks) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.VISIT_PLAN_CLIENT_NAME, clientName);
        values.put(DbConstants.VISIT_PLAN_CLIENT_TYPE, clientType);
        values.put(DbConstants.VISIT_PLAN_MOBILE_NUMBER, mobileNumber);
        values.put(DbConstants.VISIT_PLAN_PRODUCT_TYPE, productType);
        values.put(DbConstants.VISIT_PLAN_CITY, city);
        values.put(DbConstants.VISIT_PLAN_POLICE_STATION, policeStation);
        values.put(DbConstants.VISIT_PLAN_PURPOSE_OF_VISIT,purposeOfVisit);
        values.put(DbConstants.VISIT_PLAN_DATE_OF_VISIT, dateOfVisit);
        values.put(DbConstants.VISIT_PLAN_REMARKS,remarks);
        values.put(DbConstants.LEAD_STATUS, AppConstant.LEAD_STATUS_New_PLAN);
        // Insert the new row, returning the primary key value of the new row
        open();
        int insert= (int) db.insert(DbConstants.TABLE_VISIT_PLAN, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;


    }

    public int updateVisitPlanDataStatus(int id, String status) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.LEAD_STATUS, status);
        return db.update(DbConstants.TABLE_VISIT_PLAN, values, DbConstants._V_ID + "=" + id, null);


    }


    public ArrayList<VisitPlan> getUpComingData(String visitDate) {

        String[] projection = {
                DbConstants._V_ID,
                DbConstants.VISIT_PLAN_CLIENT_NAME,
                DbConstants.VISIT_PLAN_CLIENT_TYPE,
                DbConstants.VISIT_PLAN_MOBILE_NUMBER,
                DbConstants.VISIT_PLAN_PRODUCT_TYPE,
                DbConstants.VISIT_PLAN_CITY,
                DbConstants.VISIT_PLAN_POLICE_STATION,
                DbConstants.VISIT_PLAN_PURPOSE_OF_VISIT,
                DbConstants.VISIT_PLAN_DATE_OF_VISIT,
                DbConstants.VISIT_PLAN_REMARKS,
                DbConstants.LEAD_STATUS,

        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants._V_ID + " DESC";
        String WHERE = DbConstants.VISIT_PLAN_DATE_OF_VISIT + ">?";
        Cursor c = db.query(
                DbConstants.TABLE_VISIT_PLAN,  // The table name to query
                projection,                               // The columns to return
                WHERE,                                // The columns for the WHERE clause
                new String[]{visitDate},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchData(c);
    }

    public ArrayList<VisitPlan> getPreviousData(String visitDate) {

        String[] projection = {
                DbConstants._V_ID,
                DbConstants.VISIT_PLAN_CLIENT_NAME,
                DbConstants.VISIT_PLAN_CLIENT_TYPE,
                DbConstants.VISIT_PLAN_MOBILE_NUMBER,
                DbConstants.VISIT_PLAN_PRODUCT_TYPE,
                DbConstants.VISIT_PLAN_CITY,
                DbConstants.VISIT_PLAN_POLICE_STATION,
                DbConstants.VISIT_PLAN_PURPOSE_OF_VISIT,
                DbConstants.VISIT_PLAN_DATE_OF_VISIT,
                DbConstants.VISIT_PLAN_REMARKS,
                DbConstants.LEAD_STATUS,

        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants._V_ID + " DESC";
        String WHERE = DbConstants.VISIT_PLAN_DATE_OF_VISIT + "<?";
        Cursor c = db.query(
                DbConstants.TABLE_VISIT_PLAN,  // The table name to query
                projection,                               // The columns to return
                WHERE,                                // The columns for the WHERE clause
                new String[]{visitDate},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchData(c);
    }



    public ArrayList<VisitPlan> getCurrentData(String visitDate) {

        String[] projection = {
                DbConstants._V_ID,
                DbConstants.VISIT_PLAN_CLIENT_NAME,
                DbConstants.VISIT_PLAN_CLIENT_TYPE,
                DbConstants.VISIT_PLAN_MOBILE_NUMBER,
                DbConstants.VISIT_PLAN_PRODUCT_TYPE,
                DbConstants.VISIT_PLAN_CITY,
                DbConstants.VISIT_PLAN_POLICE_STATION,
                DbConstants.VISIT_PLAN_PURPOSE_OF_VISIT,
                DbConstants.VISIT_PLAN_DATE_OF_VISIT,
                DbConstants.VISIT_PLAN_REMARKS,
                DbConstants.LEAD_STATUS,

        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants._V_ID + " DESC";
        String WHERE = DbConstants.VISIT_PLAN_DATE_OF_VISIT + "=?";
        Cursor c = db.query(
                DbConstants.TABLE_VISIT_PLAN,  // The table name to query
                projection,                               // The columns to return
                WHERE,                                // The columns for the WHERE clause
                new String[]{visitDate},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchData(c);
    }


    public ArrayList<VisitPlan> getAllData() {

        String[] projection = {
                DbConstants._V_ID,
                DbConstants.VISIT_PLAN_CLIENT_NAME,
                DbConstants.VISIT_PLAN_CLIENT_TYPE,
                DbConstants.VISIT_PLAN_MOBILE_NUMBER,
                DbConstants.VISIT_PLAN_PRODUCT_TYPE,
                DbConstants.VISIT_PLAN_CITY,
                DbConstants.VISIT_PLAN_POLICE_STATION,
                DbConstants.VISIT_PLAN_PURPOSE_OF_VISIT,
                DbConstants.VISIT_PLAN_DATE_OF_VISIT,
                DbConstants.VISIT_PLAN_REMARKS,
                DbConstants.LEAD_STATUS,

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
                    String clientName = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_CLIENT_NAME));
                    String clientType = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_CLIENT_TYPE));
                    String mobileNumber = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_MOBILE_NUMBER));
                    String productType = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_PRODUCT_TYPE));
                    String city = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_CITY));
                    String policeStation = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_POLICE_STATION));
                    String purposeOfVisit = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_PURPOSE_OF_VISIT));
                    String dateOfVisit = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_DATE_OF_VISIT));
                    String remarks = c.getString(c.getColumnIndexOrThrow(DbConstants.VISIT_PLAN_REMARKS));
                    String status = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_STATUS));



                    // wrap up data list and return
                    favDataArray.add(new VisitPlan(id, clientName, clientType, mobileNumber, productType, city, policeStation, purposeOfVisit, dateOfVisit, remarks,status));
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


