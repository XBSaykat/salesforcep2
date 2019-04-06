package net.maxproit.salesforce.masum.appdata.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

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
        values.put(SpinnerDbConstant.CLIENT_TYPE, clientTye);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_CLIENT_TYPE, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertPurposeOfVisitData(String purposeOfVisit) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.PURPOSE_OF_VISIT, purposeOfVisit);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_PURPOSE_OF_VISIT, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertCityData(String city) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.CITY, city);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_CITY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertPoliceStationData(String policeStation) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.POLICE_STATION, policeStation);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_POLICE_STATION, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertBranchData(String branch) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.BRANCH, branch);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_BRANCH, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertProfessionData(String profession) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.PROFESSION, profession);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_PROFESSION, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertSourceOfReferenceData(String sourceOfReference) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.SOURCE_OF_REFERENCE, sourceOfReference);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_SOURCE_OF_REFERENCE, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertProductTypeData(String productType) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.PRODUCT_TYPE, productType);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_PRODUCT_TYPE, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertProductSubcategoryData(String productSubcategory) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.PRODUCT_SUBCATEGORY, productSubcategory);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_PRODUCT_SUBCATEGORY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertFollowUpData(String followUp) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.FOLLOW_UP, followUp);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_FOLLOW_UP, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertRemarksData(String remarks) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.REMARKS, remarks);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_REMARKS, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertProductCategoryData(String productCategory) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.PRODUCT_CATEGORY, productCategory);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_PRODUCT_CATEGORY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertProductDetailData(String productDetail) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.PRODUCT_DETAIL, productDetail);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_PRODUCT_DETAIL, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertSegmentData(String segment) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.SEGMENT, segment);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_SEGMENT, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertBirthDistrictData(String birthDistrict) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.BIRTH_DISTRICT, birthDistrict);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_BIRTH_DISTRICT, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertBirthCountryData(String birthCounty) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.BIRTH_COUNTRY, birthCounty);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_BIRTH_COUNTRY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertRelationshipWithApplicantData(String relation) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.RELATIONSHIP_WITH_APPLICANT, relation);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_RELATIONSHIP_WITH_APPLICANT, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertMonthlySalarytData(String monthlySalary) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.MONTHLY_SALARY, monthlySalary);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_MONTHLY_SALARY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertMonthlyRentalIncometData(String monthlyRental) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.MONTHLY_RENTAL_INCOME, monthlyRental);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_MONTHLY_RENTAL_INCOME, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertBrandNameData(String branch) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.BRAND_NAME, branch);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_BRAND_NAME, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertManufacturingYearData(String manufacturingYear) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.MANUFACTURING_YEAR, manufacturingYear);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_MANUFACTURING_YEAR, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertManufacturingCountryData(String manufacturingCountry) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.MANUFACTURING_COUNTRY, manufacturingCountry);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_MANUFACTURING_COUNTRY, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertVehicleTypeData(String vehicleType) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.VEHICLE_TYPE, vehicleType);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_VEHICLE_TYPE, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertDhakaNorthData(String northDhaka) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.DHAKA_NORHT_POLICE_STATION, northDhaka);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_DHAKA_NORTH_POLICE_STATION, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertDhakaSouthData(String southDhaka) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.DHAKA_SOUTH_POLICE_STATION, southDhaka);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_DHAKA_SOUTH_POLICE_STATION, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertNarayanganjData(String narayanganj) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.NARAYANGANJ_POLICE_STATION, narayanganj);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_NARAYANGANJ_POLICE_STATION, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertHomeLoanData(String homeloan) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.HOME_LOAN, homeloan);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_HOME_LOAN, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertCarLoanData(String carloan) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.CAR_LOAN, carloan);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_CAR_LOAN, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }

    public int insertPersonalLoanData(String personalloan) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.PERSONAL_LOAN, personalloan);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_PERSONAL_LAON, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }


    public int insertValidPhotoData(String personalloan) {

        ContentValues values = new ContentValues();
        values.put(SpinnerDbConstant.VALID_PHOTO, personalloan);
        open();
        int insert= (int) db.insert(SpinnerDbConstant.TABLE_VALID_PHOTO, DbConstants.COLUMN_NAME_NULLABLE, values);
        close();
        return insert;
    }


    public ArrayList<String> getClientTypeData() {

        String[] projection = {
                SpinnerDbConstant.CLIENT_TYPE,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.CLIENT_TYPE_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_CLIENT_TYPE,  // The table name to query
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
                    String clientType = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.CLIENT_TYPE));
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
                SpinnerDbConstant.PURPOSE_OF_VISIT,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.PURPOSE_OF_VISIT_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_PURPOSE_OF_VISIT,  // The table name to query
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
                    String purposeOfVisit = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.PURPOSE_OF_VISIT));
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
                SpinnerDbConstant.CITY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.CITY_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_CITY,  // The table name to query
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
                    String city = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.CITY));
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
                SpinnerDbConstant.POLICE_STATION,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.POLICE_STATION_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_POLICE_STATION,  // The table name to query
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
                    String policeStation = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.POLICE_STATION));
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
                SpinnerDbConstant.BRANCH,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.BRANCH_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_BRANCH,  // The table name to query
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
                    String branch = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.BRANCH));
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
                SpinnerDbConstant.PROFESSION,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.PROFESSION_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_PROFESSION,  // The table name to query
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
                    String profession = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.PROFESSION));
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
                SpinnerDbConstant.SOURCE_OF_REFERENCE,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.SOURCE_OF_REFERENCE_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_SOURCE_OF_REFERENCE,  // The table name to query
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
                    String sourceOfReference = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.SOURCE_OF_REFERENCE));
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
                SpinnerDbConstant.PRODUCT_TYPE,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.PRODUCT_TYPE_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_PRODUCT_TYPE,  // The table name to query
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
                    String productType = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.PRODUCT_TYPE));
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
                SpinnerDbConstant.PRODUCT_SUBCATEGORY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.PRODUCT_SUBCATEGORY_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_PRODUCT_SUBCATEGORY,  // The table name to query
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
                    String productSubcategory = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.PRODUCT_SUBCATEGORY));
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
                SpinnerDbConstant.FOLLOW_UP,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.FOLLOW_UP_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_FOLLOW_UP,  // The table name to query
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
                    String followUp = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.FOLLOW_UP));
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
                SpinnerDbConstant.REMARKS,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.REMARKS_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_REMARKS,  // The table name to query
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
                    String remarks = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.REMARKS));
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
                SpinnerDbConstant.PRODUCT_CATEGORY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.PRODUCT_CATEGORY_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_PRODUCT_CATEGORY,  // The table name to query
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
                    String productCategory = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.PRODUCT_CATEGORY));
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
                SpinnerDbConstant.PRODUCT_DETAIL,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.PRODUCT_DETAIL_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_PRODUCT_DETAIL,  // The table name to query
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
                    String productDetail = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.PRODUCT_DETAIL));
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
                SpinnerDbConstant.SEGMENT,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.SEGMENT_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_SEGMENT,  // The table name to query
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
                    String segment = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.SEGMENT));
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
                SpinnerDbConstant.BIRTH_DISTRICT,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.BIRTH_DISTRICT_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_BIRTH_DISTRICT,  // The table name to query
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
                    String birthDistrict = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.BIRTH_DISTRICT));
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
                SpinnerDbConstant.BIRTH_COUNTRY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.BIRTH_COUNTRY_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_BIRTH_COUNTRY,  // The table name to query
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
                    String birthCountry = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.BIRTH_COUNTRY));
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
                SpinnerDbConstant.RELATIONSHIP_WITH_APPLICANT,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.RELATIONSHIP_WITH_APPLICANT_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_RELATIONSHIP_WITH_APPLICANT,  // The table name to query
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
                    String relationshipWithApplicant = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.RELATIONSHIP_WITH_APPLICANT));
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
                SpinnerDbConstant.MONTHLY_SALARY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.MONTHLY_SALARY_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_MONTHLY_SALARY,  // The table name to query
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
                    String monthlySalary = c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.MONTHLY_SALARY));
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
                SpinnerDbConstant.MONTHLY_RENTAL_INCOME,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.MONTHLY_RENTAL_INCOME_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_MONTHLY_RENTAL_INCOME,  // The table name to query
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
                    String monthlyRentalIncome= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.MONTHLY_RENTAL_INCOME));
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
                SpinnerDbConstant.BRAND_NAME,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.BRAND_NAME_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_BRAND_NAME,  // The table name to query
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
                    String brandName= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.BRAND_NAME));
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
                SpinnerDbConstant.MANUFACTURING_YEAR,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.MANUFACTURING_YEAR_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_MANUFACTURING_YEAR,  // The table name to query
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
                    String manufacturingYear= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.MANUFACTURING_YEAR));
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
                SpinnerDbConstant.MANUFACTURING_COUNTRY,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.MANUFACTURING_COUNTRY_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_MANUFACTURING_COUNTRY,  // The table name to query
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
                    String manufacturingCountry= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.MANUFACTURING_COUNTRY));
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
                SpinnerDbConstant.VEHICLE_TYPE,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.VEHICLE_TYPE_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_VEHICLE_TYPE,  // The table name to query
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
                    String vehicleType= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.VEHICLE_TYPE));
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
                SpinnerDbConstant.DHAKA_NORHT_POLICE_STATION,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.DHAKA_NORHT_POLICE_STATION_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_DHAKA_NORTH_POLICE_STATION,  // The table name to query
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
                    String dhakaNorth= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.DHAKA_NORHT_POLICE_STATION));
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
                SpinnerDbConstant.DHAKA_SOUTH_POLICE_STATION,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.DHAKA_SOUTH_POLICE_STATION_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_DHAKA_SOUTH_POLICE_STATION,  // The table name to query
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
                    String dhakaSouth= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.DHAKA_SOUTH_POLICE_STATION));
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
                SpinnerDbConstant.NARAYANGANJ_POLICE_STATION,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.NARAYANGANJ_POLICE_STATION_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_NARAYANGANJ_POLICE_STATION,  // The table name to query
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
                    String naranyanganj= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.NARAYANGANJ_POLICE_STATION));
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
                SpinnerDbConstant.HOME_LOAN,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.HOME_LOAN_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_HOME_LOAN,  // The table name to query
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
                    String homeLoan= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.HOME_LOAN));
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
                SpinnerDbConstant.CAR_LOAN,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.CAR_LOAN_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_CAR_LOAN,  // The table name to query
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
                    String carLoan= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.CAR_LOAN));
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
                SpinnerDbConstant.PERSONAL_LOAN,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.PERSONAL_LOAN_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_PERSONAL_LAON,  // The table name to query
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
                    String personalLoan= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.PERSONAL_LOAN));
                    // wrap up data list and return
                    favDataArray.add(personalLoan);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }







    public ArrayList<String> getValidPhotoData() {

        String[] projection = {
                SpinnerDbConstant.VALID_PHOTO,
        };
        // How you want the results sorted in the resulting Cursor
        String sortOrder = SpinnerDbConstant.VALID_PHOTO_ID + " DESC";

        Cursor c = db.query(
                SpinnerDbConstant.TABLE_VALID_PHOTO,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchValidPhotoData(c);
    }


    private ArrayList<String> fetchValidPhotoData(Cursor c) {
        ArrayList<String> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    String validPhoto= c.getString(c.getColumnIndexOrThrow(SpinnerDbConstant.VALID_PHOTO));
                    // wrap up data list and return
                    favDataArray.add(validPhoto);
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

}
