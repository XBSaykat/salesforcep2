package net.maxproit.salesforce.masum.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import net.maxproit.salesforce.masum.model.VisitPlan;

import java.util.ArrayList;

public class SpinnerDbController {

    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private Context mContext;

    public SpinnerDbController(Context context) {
        db = DbHelper.getInstance(context).getWritableDatabase();
        mContext = context;
    }

    public SpinnerDbController open() throws SQLException {
        dbHelper = new DbHelper(mContext);
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }


    public int insertClientTypeData(String clientTye) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.CLIENT_TYPE, clientTye);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_CLIENT_TYPE, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertPurposeOfVisitData(String purposeOfVisit) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.PURPOSE_OF_VISIT, purposeOfVisit);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_PURPOSE_OF_VISIT, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertCityData(String city) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.CITY, city);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_CITY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertPoliceStationData(String policeStation) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.POLICE_STATION, policeStation);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_POLICE_STATION, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertBranchData(String branch) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.BRANCH, branch);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_BRANCH, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertProfessionData(String profession) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.PROFESSION, profession);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_PROFESSION, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertSourceOfReferenceData(String sourceOfReference) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.SOURCE_OF_REFERENCE, sourceOfReference);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_SOURCE_OF_REFERENCE, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertProductTypeData(String productType) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.PRODUCT_TYPE, productType);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_PRODUCT_TYPE, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertProductSubcategoryData(String productSubcategory) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.PRODUCT_SUBCATEGORY, productSubcategory);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_PRODUCT_SUBCATEGORY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertFollowUpData(String followUp) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.FOLLOW_UP, followUp);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_FOLLOW_UP, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertRemarksData(String remarks) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.REMARKS, remarks);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_REMARKS, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertProductCategoryData(String productCategory) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.PRODUCT_CATEGORY, productCategory);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_PRODUCT_CATEGORY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertProductDetailData(String productDetail) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.PRODUCT_DETAIL, productDetail);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_PRODUCT_DETAIL, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertSegmentData(String segment) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.SEGMENT, segment);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_SEGMENT, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertBirthDistrictData(String birthDistrict) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.BIRTH_DISTRICT, birthDistrict);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_BIRTH_DISTRICT, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertBirthCountryData(String birthCounty) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.BIRTH_COUNTRY, birthCounty);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_BIRTH_COUNTRY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertRelationshipWithApplicantData(String relation) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.RELATIONSHIP_WITH_APPLICANT, relation);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_RELATIONSHIP_WITH_APPLICANT, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertMonthlySalarytData(String monthlySalary) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.MONTHLY_SALARY, monthlySalary);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_MONTHLY_SALARY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertMonthlyRentalIncometData(String monthlyRental) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.MONTHLY_RENTAL_INCOME, monthlyRental);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_MONTHLY_RENTAL_INCOME, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertBrandNameData(String branch) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.BRAND_NAME, branch);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_BRAND_NAME, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertManufacturingYearData(String manufacturingYear) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.MANUFACTURING_YEAR, manufacturingYear);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_MANUFACTURING_YEAR, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertManufacturingCountryData(String manufacturingCountry) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.MANUFACTURING_COUNTRY, manufacturingCountry);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_MANUFACTURING_COUNTRY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertVehicleTypeData(String vehicleType) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.VEHICLE_TYPE, vehicleType);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_VEHICLE_TYPE, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertDhakaNorthData(String northDhaka) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.DHAKA_NORHT_POLICE_STATION, northDhaka);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_DHAKA_NORTH_POLICE_STATION, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertDhakaSouthData(String southDhaka) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.DHAKA_SOUTH_POLICE_STATION, southDhaka);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_DHAKA_SOUTH_POLICE_STATION, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertNarayanganjData(String narayanganj) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.NARAYANGANJ_POLICE_STATION, narayanganj);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_NARAYANGANJ_POLICE_STATION, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertHomeLoanData(String homeloan) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.HOME_LOAN, homeloan);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_HOME_LOAN, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertCarLoanData(String carloan) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.CAR_LOAN, carloan);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_CAR_LOAN, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertPersonalLoanData(String personalloan) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.PERSONAL_LOAN, personalloan);
        open();
        int insert= (int) db.insert(DbConstants.TABLE_PERSONAL_LAON, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }


    public ArrayList<String> getClientTypeData() {

        String[] projection = {
                DbConstants.CLIENT_TYPE,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.CLIENT_TYPE_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_CLIENT_TYPE,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchClientTypeData(c);
    }


    private ArrayList<String> fetchClientTypeData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String clientType = c.getString(c.getColumnIndexOrThrow(DbConstants.CLIENT_TYPE));
                    // wrap up data list and return
                    favDataArray.add(clientType);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getPurposeOfVisitData() {

        String[] projection = {
                DbConstants.PURPOSE_OF_VISIT,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.PURPOSE_OF_VISIT_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_PURPOSE_OF_VISIT,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchPurposeOfVisitData(c);
    }


    private ArrayList<String> fetchPurposeOfVisitData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String purposeOfVisit = c.getString(c.getColumnIndexOrThrow(DbConstants.PURPOSE_OF_VISIT));
                    // wrap up data list and return
                    favDataArray.add(purposeOfVisit);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getCityData() {

        String[] projection = {
                DbConstants.CITY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.CITY_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_CITY,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        return fetchCityData(c);
    }


    private ArrayList<String> fetchCityData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String city = c.getString(c.getColumnIndexOrThrow(DbConstants.CITY));
                    // wrap up data list and return
                    favDataArray.add(city);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getPoliceSationData() {

        String[] projection = {
                DbConstants.POLICE_STATION,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.POLICE_STATION_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_POLICE_STATION,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchPoliceStationData(c);
    }


    private ArrayList<String> fetchPoliceStationData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String policeStation = c.getString(c.getColumnIndexOrThrow(DbConstants.POLICE_STATION));
                    // wrap up data list and return
                    favDataArray.add(policeStation);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getBranchData() {

        String[] projection = {
                DbConstants.BRANCH,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.BRANCH_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_BRANCH,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchBranchData(c);
    }


    private ArrayList<String> fetchBranchData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String branch = c.getString(c.getColumnIndexOrThrow(DbConstants.BRANCH));
                    // wrap up data list and return
                    favDataArray.add(branch);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getProfessionData() {

        String[] projection = {
                DbConstants.PROFESSION,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.PROFESSION_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_PROFESSION,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchProfessionData(c);
    }


    private ArrayList<String> fetchProfessionData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String profession = c.getString(c.getColumnIndexOrThrow(DbConstants.PROFESSION));
                    // wrap up data list and return
                    favDataArray.add(profession);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getSourceOfReferenceData() {

        String[] projection = {
                DbConstants.SOURCE_OF_REFERENCE,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.SOURCE_OF_REFERENCE_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_SOURCE_OF_REFERENCE,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchSourceOfReferenceData(c);
    }


    private ArrayList<String> fetchSourceOfReferenceData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String sourceOfReference = c.getString(c.getColumnIndexOrThrow(DbConstants.SOURCE_OF_REFERENCE));
                    // wrap up data list and return
                    favDataArray.add(sourceOfReference);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getProductTypeData() {

        String[] projection = {
                DbConstants.PRODUCT_TYPE,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.PRODUCT_TYPE_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_PRODUCT_TYPE,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchProductTypeData(c);
    }


    private ArrayList<String> fetchProductTypeData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String productType = c.getString(c.getColumnIndexOrThrow(DbConstants.PRODUCT_TYPE));
                    // wrap up data list and return
                    favDataArray.add(productType);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getProductSubcategoryData() {

        String[] projection = {
                DbConstants.PRODUCT_SUBCATEGORY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.PRODUCT_SUBCATEGORY_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_PRODUCT_SUBCATEGORY,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchProductSubcategoryData(c);
    }


    private ArrayList<String> fetchProductSubcategoryData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String productSubcategory = c.getString(c.getColumnIndexOrThrow(DbConstants.PRODUCT_SUBCATEGORY));
                    // wrap up data list and return
                    favDataArray.add(productSubcategory);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getFollowUpData() {

        String[] projection = {
                DbConstants.FOLLOW_UP,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.FOLLOW_UP_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_FOLLOW_UP,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchFolloUpData(c);
    }


    private ArrayList<String> fetchFolloUpData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String followUp = c.getString(c.getColumnIndexOrThrow(DbConstants.FOLLOW_UP));
                    // wrap up data list and return
                    favDataArray.add(followUp);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getRemarkData() {

        String[] projection = {
                DbConstants.REMARKS,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.REMARKS_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_REMARKS,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchRemarksData(c);
    }


    private ArrayList<String> fetchRemarksData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String remarks = c.getString(c.getColumnIndexOrThrow(DbConstants.REMARKS));
                    // wrap up data list and return
                    favDataArray.add(remarks);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getProductCategoryData() {

        String[] projection = {
                DbConstants.PRODUCT_CATEGORY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.PRODUCT_CATEGORY_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_PRODUCT_CATEGORY,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchProductCategoryData(c);
    }


    private ArrayList<String> fetchProductCategoryData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String productCategory = c.getString(c.getColumnIndexOrThrow(DbConstants.PRODUCT_CATEGORY));
                    // wrap up data list and return
                    favDataArray.add(productCategory);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getProductDetailData() {

        String[] projection = {
                DbConstants.PRODUCT_DETAIL,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.PRODUCT_DETAIL_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_PRODUCT_DETAIL,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchProductDetailData(c);
    }


    private ArrayList<String> fetchProductDetailData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String productDetail = c.getString(c.getColumnIndexOrThrow(DbConstants.PRODUCT_DETAIL));
                    // wrap up data list and return
                    favDataArray.add(productDetail);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getSegmentData() {

        String[] projection = {
                DbConstants.SEGMENT,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.SEGMENT_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_SEGMENT,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchSegmentData(c);
    }


    private ArrayList<String> fetchSegmentData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String segment = c.getString(c.getColumnIndexOrThrow(DbConstants.SEGMENT));
                    // wrap up data list and return
                    favDataArray.add(segment);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getBirthDistrictData() {

        String[] projection = {
                DbConstants.BIRTH_DISTRICT,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.BIRTH_DISTRICT_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_BIRTH_DISTRICT,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchBirthDistrictData(c);
    }


    private ArrayList<String> fetchBirthDistrictData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String birthDistrict = c.getString(c.getColumnIndexOrThrow(DbConstants.BIRTH_DISTRICT));
                    // wrap up data list and return
                    favDataArray.add(birthDistrict);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getBirthCountryData() {

        String[] projection = {
                DbConstants.BIRTH_COUNTRY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.BIRTH_COUNTRY_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_BIRTH_COUNTRY,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchBirthCountryData(c);
    }


    private ArrayList<String> fetchBirthCountryData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String birthCountry = c.getString(c.getColumnIndexOrThrow(DbConstants.BIRTH_COUNTRY));
                    // wrap up data list and return
                    favDataArray.add(birthCountry);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getRelationshipWithApplicantData() {

        String[] projection = {
                DbConstants.RELATIONSHIP_WITH_APPLICANT,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.RELATIONSHIP_WITH_APPLICANT_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_RELATIONSHIP_WITH_APPLICANT,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchRelationshipWithApplicantData(c);
    }


    private ArrayList<String> fetchRelationshipWithApplicantData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String relationshipWithApplicant = c.getString(c.getColumnIndexOrThrow(DbConstants.RELATIONSHIP_WITH_APPLICANT));
                    // wrap up data list and return
                    favDataArray.add(relationshipWithApplicant);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getMonthlySalaryData() {

        String[] projection = {
                DbConstants.MONTHLY_SALARY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.MONTHLY_SALARY_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_MONTHLY_SALARY,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchMonthlySalaryData(c);
    }


    private ArrayList<String> fetchMonthlySalaryData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String monthlySalary = c.getString(c.getColumnIndexOrThrow(DbConstants.MONTHLY_SALARY));
                    // wrap up data list and return
                    favDataArray.add(monthlySalary);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getMonthlyRentalIncomeData() {

        String[] projection = {
                DbConstants.MONTHLY_RENTAL_INCOME,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.MONTHLY_RENTAL_INCOME_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_MONTHLY_RENTAL_INCOME,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchMonthlyRentalIncomeData(c);
    }


    private ArrayList<String> fetchMonthlyRentalIncomeData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String monthlyRentalIncome= c.getString(c.getColumnIndexOrThrow(DbConstants.MONTHLY_RENTAL_INCOME));
                    // wrap up data list and return
                    favDataArray.add(monthlyRentalIncome);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getBrandNameData() {

        String[] projection = {
                DbConstants.BRAND_NAME,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.BRAND_NAME_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_BRAND_NAME,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchBrandNameData(c);
    }


    private ArrayList<String> fetchBrandNameData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String brandName= c.getString(c.getColumnIndexOrThrow(DbConstants.BRAND_NAME));
                    // wrap up data list and return
                    favDataArray.add(brandName);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getManufacturingYearData() {

        String[] projection = {
                DbConstants.MANUFACTURING_YEAR,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.MANUFACTURING_YEAR_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_MANUFACTURING_YEAR,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchManufacturingYearData(c);
    }


    private ArrayList<String> fetchManufacturingYearData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String manufacturingYear= c.getString(c.getColumnIndexOrThrow(DbConstants.MANUFACTURING_YEAR));
                    // wrap up data list and return
                    favDataArray.add(manufacturingYear);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getManufacturingCountryData() {

        String[] projection = {
                DbConstants.MANUFACTURING_COUNTRY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.MANUFACTURING_COUNTRY_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_MANUFACTURING_COUNTRY,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchManufacturingCountryData(c);
    }


    private ArrayList<String> fetchManufacturingCountryData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String manufacturingCountry= c.getString(c.getColumnIndexOrThrow(DbConstants.MANUFACTURING_COUNTRY));
                    // wrap up data list and return
                    favDataArray.add(manufacturingCountry);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getVehicleTypeData() {

        String[] projection = {
                DbConstants.VEHICLE_TYPE,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.VEHICLE_TYPE_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_VEHICLE_TYPE,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchVehicleTypeData(c);
    }


    private ArrayList<String> fetchVehicleTypeData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String vehicleType= c.getString(c.getColumnIndexOrThrow(DbConstants.VEHICLE_TYPE));
                    // wrap up data list and return
                    favDataArray.add(vehicleType);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getDhakaNorthData() {

        String[] projection = {
                DbConstants.DHAKA_NORHT_POLICE_STATION,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.DHAKA_NORHT_POLICE_STATION_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_DHAKA_NORTH_POLICE_STATION,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchDhakaNorthData(c);
    }


    private ArrayList<String> fetchDhakaNorthData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String dhakaNorth= c.getString(c.getColumnIndexOrThrow(DbConstants.DHAKA_NORHT_POLICE_STATION));
                    // wrap up data list and return
                    favDataArray.add(dhakaNorth);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getDhakaSouthData() {

        String[] projection = {
                DbConstants.DHAKA_SOUTH_POLICE_STATION,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.DHAKA_SOUTH_POLICE_STATION_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_DHAKA_SOUTH_POLICE_STATION,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchDhakaSouthData(c);
    }


    private ArrayList<String> fetchDhakaSouthData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String dhakaSouth= c.getString(c.getColumnIndexOrThrow(DbConstants.DHAKA_SOUTH_POLICE_STATION));
                    // wrap up data list and return
                    favDataArray.add(dhakaSouth);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getNarayanganjData() {

        String[] projection = {
                DbConstants.NARAYANGANJ_POLICE_STATION,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.NARAYANGANJ_POLICE_STATION_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_NARAYANGANJ_POLICE_STATION,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchNarayanganjhData(c);
    }


    private ArrayList<String> fetchNarayanganjhData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String naranyanganj= c.getString(c.getColumnIndexOrThrow(DbConstants.NARAYANGANJ_POLICE_STATION));
                    // wrap up data list and return
                    favDataArray.add(naranyanganj);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getHomeLoanData() {

        String[] projection = {
                DbConstants.HOME_LOAN,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.HOME_LOAN_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_HOME_LOAN,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchHomeLoanData(c);
    }


    private ArrayList<String> fetchHomeLoanData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String homeLoan= c.getString(c.getColumnIndexOrThrow(DbConstants.HOME_LOAN));
                    // wrap up data list and return
                    favDataArray.add(homeLoan);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getCarLoanData() {

        String[] projection = {
                DbConstants.CAR_LOAN,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.CAR_LOAN_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_CAR_LOAN,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchCarLoanData(c);
    }


    private ArrayList<String> fetchCarLoanData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String carLoan= c.getString(c.getColumnIndexOrThrow(DbConstants.CAR_LOAN));
                    // wrap up data list and return
                    favDataArray.add(carLoan);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public ArrayList<String> getPersonalLoanData() {

        String[] projection = {
                DbConstants.PERSONAL_LOAN,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.PERSONAL_LOAN_ID + " DESC";

        Cursor c = db.query(
                DbConstants.TABLE_PERSONAL_LAON,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchPersonalLoanData(c);
    }


    private ArrayList<String> fetchPersonalLoanData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String personalLoan= c.getString(c.getColumnIndexOrThrow(DbConstants.PERSONAL_LOAN));
                    // wrap up data list and return
                    favDataArray.add(personalLoan);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

}
