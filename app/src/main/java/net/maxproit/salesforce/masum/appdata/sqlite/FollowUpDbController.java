package net.maxproit.salesforce.masum.appdata.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import net.maxproit.salesforce.masum.model.FollowUpActivity;
import net.maxproit.salesforce.masum.model.VisitPlan;
import net.maxproit.salesforce.masum.utility.DateUtils;

import java.util.ArrayList;

public class FollowUpDbController {

    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private Context mContext;

    public FollowUpDbController(Context context) {
        db = DbHelper.getInstance(context).getWritableDatabase();
        mContext = context;
    }

    public FollowUpDbController open() throws SQLException {
        dbHelper = new DbHelper(mContext);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public int insertData(int vID, String date, String remark) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.FOLLOW_UP_V_ID, vID);
        values.put(DbConstants.FOLLOW_UP_HIS_DATE, DateUtils.getDateFormateForSqlite(date));
        values.put(DbConstants.FOLLOW_UP_HIS_REMARK, remark);
        // Insert the new row, returning the primary key value of the new row
        //open();
        int insert = (int) db.insert(DbConstants.TABLE_FOLLOWUP_HIS, DbConstants.COLUMN_NAME_NULLABLE, values);
        //close();
        return insert;


    }


    public ArrayList<FollowUpActivity> getAllData(int id) {
        String[] projection = {
                DbConstants.FOLLOW_UP_HIS_ID,
                DbConstants.FOLLOW_UP_V_ID,
                DbConstants.FOLLOW_UP_HIS_DATE,
                DbConstants.FOLLOW_UP_HIS_REMARK,

        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.FOLLOW_UP_HIS_ID + " DESC";
        String WHERE = DbConstants.FOLLOW_UP_V_ID + "=?";
        Cursor c = db.query(
                DbConstants.TABLE_FOLLOWUP_HIS,  // The table name to query
                projection,                               // The columns to return
                WHERE,                                // The columns for the WHERE clause
                new String[]{String.valueOf(id)},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchData(c);
    }


    private ArrayList<FollowUpActivity> fetchData(Cursor c) {
        ArrayList<FollowUpActivity> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    int id = c.getInt(c.getColumnIndexOrThrow(DbConstants.FOLLOW_UP_HIS_ID));
                    int fPlanId = c.getInt(c.getColumnIndexOrThrow(DbConstants.FOLLOW_UP_V_ID));
                    String date = c.getString(c.getColumnIndexOrThrow(DbConstants.FOLLOW_UP_HIS_DATE));
                    String remark = c.getString(c.getColumnIndexOrThrow(DbConstants.FOLLOW_UP_HIS_REMARK));

                    favDataArray.add(new FollowUpActivity(id, fPlanId, date, remark));
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }
}
