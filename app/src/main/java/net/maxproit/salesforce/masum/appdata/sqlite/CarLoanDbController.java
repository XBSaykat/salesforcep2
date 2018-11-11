package net.maxproit.salesforce.masum.appdata.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import net.maxproit.salesforce.masum.model.CarLoan;
import net.maxproit.salesforce.masum.model.VisitPlan;

import java.util.ArrayList;

public class CarLoanDbController {
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private Context mContext;

    public CarLoanDbController(Context context) {
        db = DbHelper.getInstance(context).getWritableDatabase();
        mContext = context;
    }

    public CarLoanDbController open() throws SQLException {
        dbHelper = new DbHelper(mContext);
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }


    public int insertData(CarLoan carLoan) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.LEAD_ID_FOR_CAR_LOAN, carLoan.getLeadId());
        values.put(DbConstants.BRAND_NAME, carLoan.getBrandName());
        values.put(DbConstants.MANUFACTURE_YEAR, carLoan.getMenuYear());
        values.put(DbConstants.MANUFACTURE_COUNTRY,carLoan.getMenuCountry() );
        values.put(DbConstants.VEHICLE_TYPE,carLoan.getVehicleType() );
        // Insert the new row, returning the primary key value of the new row
        open();
        int insert= (int) db.insert(DbConstants.TABLE_CAR_LOAN, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int updateData(CarLoan carLoan) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.LEAD_ID_FOR_CAR_LOAN, carLoan.getLeadId());
        values.put(DbConstants.BRAND_NAME, carLoan.getBrandName());
        values.put(DbConstants.MANUFACTURE_YEAR, carLoan.getMenuYear());
        values.put(DbConstants.MANUFACTURE_COUNTRY,carLoan.getMenuCountry() );
        values.put(DbConstants.VEHICLE_TYPE,carLoan.getVehicleType() );
        // Insert the new row, returning the primary key value of the new row
        open();
        int insert= (int) db.update(DbConstants.TABLE_CAR_LOAN,values,DbConstants.LEAD_ID_FOR_CAR_LOAN+ "=" + carLoan.getLeadId(),null);
        close();
        return insert;
    }


    public ArrayList<CarLoan> getData(String leadId) {

        String[] projection = {
                DbConstants.CAR_LOAN_ID,
                DbConstants.LEAD_ID_FOR_CAR_LOAN,
                DbConstants.BRAND_NAME,
                DbConstants.MANUFACTURE_YEAR,
                DbConstants.MANUFACTURE_COUNTRY,
                DbConstants.VEHICLE_TYPE,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.CAR_LOAN_ID + " DESC";
        String WHERE = DbConstants.LEAD_ID_FOR_CAR_LOAN + "=?";
        Cursor c = db.query(
                DbConstants.TABLE_CAR_LOAN,  // The table name to query
                projection,                               // The columns to return
                WHERE,                                // The columns for the WHERE clause
                new String[]{leadId},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchData(c);
    }


    private ArrayList<CarLoan> fetchData(Cursor c) {
        ArrayList<CarLoan> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    int id = c.getInt(c.getColumnIndexOrThrow(DbConstants.CAR_LOAN_ID));
                    int leadID = c.getInt(c.getColumnIndexOrThrow(DbConstants.LEAD_ID_FOR_CAR_LOAN));
                    String brandName = c.getString(c.getColumnIndexOrThrow(DbConstants.BRAND_NAME));
                    String menuYear = c.getString(c.getColumnIndexOrThrow(DbConstants.MANUFACTURE_YEAR));
                    String menuCountry = c.getString(c.getColumnIndexOrThrow(DbConstants.MANUFACTURE_COUNTRY));
                    String vehicleType = c.getString(c.getColumnIndexOrThrow(DbConstants.VEHICLE_TYPE));

                    // wrap up data list and return
                    favDataArray.add(new CarLoan(id,leadID,brandName,menuYear,menuCountry,vehicleType));
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

}
