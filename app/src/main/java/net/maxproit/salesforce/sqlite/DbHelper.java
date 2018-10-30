package net.maxproit.salesforce.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Masum on 3/11/2018.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static DbHelper dbHelper = null;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "idlc.db";


    static DbHelper getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new DbHelper(context);
        }
        return dbHelper;
    }

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbConstants.SQL_CREATE_LEAD_ENTRIES);
        db.execSQL(DbConstants.SQL_CREATE_VISIT_ENTRIES);
        db.execSQL(DbConstants.SQL_SPINNER_CLIENT_TYPE);
        db.execSQL(DbConstants.SQL_SPINNER_PURPOSE_OF_VISIT);
        db.execSQL(DbConstants.SQL_SPINNER_CITY);
        db.execSQL(DbConstants.SQL_SPINNER_POLICE_STATION);
        db.execSQL(DbConstants.SQL_SPINNER_BRANCH);
        db.execSQL(DbConstants.SQL_SPINNER_PROFESSION);
        db.execSQL(DbConstants.SQL_SPINNER_SOURCE_OF_REFERENCE);
        db.execSQL(DbConstants.SQL_SPINNER_PRODUCT_TYPE);
        db.execSQL(DbConstants.SQL_SPINNER_PRODUCT_SUBCATEGORY);
        db.execSQL(DbConstants.SQL_SPINNER_FOLLOW_UP);
        db.execSQL(DbConstants.SQL_SPINNER_REMARKS);
        db.execSQL(DbConstants.SQL_SPINNER_PRODUCT_CATEGORY);
        db.execSQL(DbConstants.SQL_SPINNER_PRODUCT_DETAIL);
        db.execSQL(DbConstants.SQL_SPINNER_SEGMENT);
        db.execSQL(DbConstants.SQL_SPINNER_BIRTH_DISTRICT);
        db.execSQL(DbConstants.SQL_SPINNER_BIRTH_COUNTRY);
        db.execSQL(DbConstants.SQL_SPINNER_RELATIONSHIP_WITH_APPLICANT);
        db.execSQL(DbConstants.SQL_SPINNER_MONTHLY_SALARY);
        db.execSQL(DbConstants.SQL_SPINNER_MONTHLY_RENTAL_INCOME);
        db.execSQL(DbConstants.SQL_SPINNER_BRAND_NAME);
        db.execSQL(DbConstants.SQL_SPINNER_MANUFACTURING_YEAR);
        db.execSQL(DbConstants.SQL_SPINNER_MANUFACTURING_COUNTRY);
        db.execSQL(DbConstants.SQL_SPINNER_VEHICLE_TYPE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL(DbConstants.SQL_DELETE_LEAD_ENTRIES);
       db.execSQL(DbConstants.SQL_DELETE_VISIT_PLAN_ENTRIES);
       db.execSQL(DbConstants.SQL_DELETE_CLIENT_TYPE);
       db.execSQL(DbConstants.SQL_DELETE_PURPOSE_OF_VISIT);
       db.execSQL(DbConstants.SQL_DELETE_CITY);
       db.execSQL(DbConstants.SQL_DELETE_POLICE_STATION);
       db.execSQL(DbConstants.SQL_DELETE_BRANCH);
       db.execSQL(DbConstants.SQL_DELETE_PROFESSION);
       db.execSQL(DbConstants.SQL_DELETE_SOURCE_OF_REFERENCE);
       db.execSQL(DbConstants.SQL_DELETE_PRODUCT_TYPE);
       db.execSQL(DbConstants.SQL_DELETE_PRODUCT_SUBCATEGORY);
       db.execSQL(DbConstants.SQL_DELETE_FOLLOW_UP);
       db.execSQL(DbConstants.SQL_DELETE_REMARKS);
       db.execSQL(DbConstants.SQL_DELETE_PRODUCT_CATEGORY);
       db.execSQL(DbConstants.SQL_DELETE_PRODUCT_DETAIL);
       db.execSQL(DbConstants.SQL_DELETE_SEGMENT);
       db.execSQL(DbConstants.SQL_DELETE_BIRTH_DISTRICT);
       db.execSQL(DbConstants.SQL_DELETE_BIRTH_COUNTRY);
       db.execSQL(DbConstants.SQL_DELETE_RELATIONSHIP_WITH_APPLICANT);
       db.execSQL(DbConstants.SQL_DELETE_MONTHLY_SALARY);
       db.execSQL(DbConstants.SQL_DELETE_MONTHLY_RENTAL_INCOME);
       db.execSQL(DbConstants.SQL_DELETE_BRAND_NAME);
       db.execSQL(DbConstants.SQL_DELETE_MANUFACTURING_YEAR);
       db.execSQL(DbConstants.SQL_DELETE_MANUFACTURING_COUNTRY);
       db.execSQL(DbConstants.SQL_DELETE_VEHICLE_TYPE);

        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}