package net.maxproit.salesforce.masum.appdata.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import net.maxproit.salesforce.masum.model.CoApplicant;
import net.maxproit.salesforce.masum.model.MyNewProspect;

import java.util.ArrayList;

public class CoApplicantDBController {

    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private Context mContext;


    public CoApplicantDBController(Context context) {
        db = DbHelper.getInstance(context).getWritableDatabase();
        mContext = context;
    }

    public CoApplicantDBController open() throws SQLException {
        dbHelper = new DbHelper(mContext);
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    public int insertData(CoApplicant coApplicant) {
        ContentValues values = new ContentValues();

        values.put(DbConstants.LEAD_ID_FOR_CO, coApplicant.getLeadId());
        values.put(DbConstants.LEAD_USER_NAME, coApplicant.getName());
        values.put(DbConstants.PROSPECT_SEGMENT, coApplicant.getSegment());
        values.put(DbConstants.PROSPECT_DATE_OF_BIRTH, coApplicant.getDateOfBirth());
        values.put(DbConstants.PROSPECT_AGE, coApplicant.getAge());
        values.put(DbConstants.PROSPECT_DOB, coApplicant.getDistrictOfBirth());
        values.put(DbConstants.PROSPECT_COB, coApplicant.getCountryOfBirth());
        values.put(DbConstants.PROSPECT_PHOTO_ID_TYPE, coApplicant.getPhotoIdType());
        values.put(DbConstants.PROSPECT_PHOTO_ID_NUMBER, coApplicant.getPhotoIdNo());
        values.put(DbConstants.PROSPECT_PHOTO_ID_ISSUE_DATE, coApplicant.getPhotoIdIssueDate());
        values.put(DbConstants.PROSPECT_ETIN, coApplicant.geteTin());
        values.put(DbConstants.PROSPECT_FATHER_NAME,coApplicant.getfName());
        values.put(DbConstants.PROSPECT_MOTHER_NAME, coApplicant.getmName());
        values.put(DbConstants.PROSPECT_SPOUSE_NAME, coApplicant.getsName());
        values.put(DbConstants.LEAD_PROFESSION, coApplicant.getProfession());
        values.put(DbConstants.PROSPECT_EXCEPTION_LIST, coApplicant.getExList());
        values.put(DbConstants.LEAD_ORGANIZATION, coApplicant.getCompanyName());
        values.put(DbConstants.LEAD_DESIGNATION, coApplicant.getDesignation());
        values.put(DbConstants.PROSPECT_NOY_CURRENT_JOB, coApplicant.getNoOfYrsInCurrentJob());
        values.put(DbConstants.PROSPECT_RW_APPLICANT, coApplicant.getRelationWithApplicant());
        values.put(DbConstants.PROSPECT_PERMANENT_ADDRESS, coApplicant.getPermanentAddress());
        values.put(DbConstants.LEAD_ADDRESS, coApplicant.getPresentAddress());
        values.put(DbConstants.LEAD_PHONE, coApplicant.getMobileNo());
        values.put(DbConstants.PROSPECT_NET_SALARY, coApplicant.getMonthSalaryType());
        values.put(DbConstants.PROSPECT_SALARY_AMOUNT, coApplicant.getMonthSalaryAmount());
        values.put(DbConstants.PROSPECT_BUSINESS_INCOME_AMOUNT, coApplicant.getMonthBusinessIncomeAmount());
        values.put(DbConstants.PROSPECT_WAREHOUSE_INCOME, coApplicant.getMonthWareHouseAmount());
        values.put(DbConstants.PROSPECT_OFFICE_SPACE_INCOME, coApplicant.getMonthOfficeSpaceIncomeAmount());
        values.put(DbConstants.PROSPECT_SEMIPAKA_INCOME, coApplicant.getMonthSemipakaIncomeAmount());
        values.put(DbConstants.PROSPECT_APARTMENT_INCOME, coApplicant.getMonthApartmentIncomeAmount());
        values.put(DbConstants.PROSPECT_ACRICULTURAL_INCOME, coApplicant.getMonthAgricultureIncomeAmount());
        values.put(DbConstants.PROSPECT_TUTION, coApplicant.getMonthTuitionIncomeAmount());
        values.put(DbConstants.PROSPECT_REMITANCE, coApplicant.getRemittance());
        values.put(DbConstants.PROSPECT_INTEREST_FDR, coApplicant.getInterestFDRIncomeAmount());
        values.put(DbConstants.PROSPECT_FAMILY_EXPENSE, coApplicant.getMonthFamilyExpenditure());
        values.put(DbConstants.PROSPECT_EMI_OTHER, coApplicant.getEmiOfOtherLoans());

        open();
         int insert=(int) db.insert(
                DbConstants.TABLE_CO_APPLICANT,
                DbConstants.COLUMN_NAME_NULLABLE,
                values);
        close();
       return insert;

    }

/*
    public int updateLeadDataStatus(int id, String status) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.LEAD_STATUS, status);
        return db.update(DbConstants.TABLE_CO_APPLICANT, values, DbConstants.CO_APPLICANT_ID + "=" + id, null);


    }*/


    public ArrayList<CoApplicant> getAllData() {

        String[] projection = {
                DbConstants.CO_APPLICANT_ID,
                DbConstants.LEAD_ID_FOR_CO,
                DbConstants.PROSPECT_SEGMENT,
                DbConstants.LEAD_USER_NAME,
                DbConstants.PROSPECT_DATE_OF_BIRTH,
                DbConstants.PROSPECT_AGE,
                DbConstants.PROSPECT_DOB,
                DbConstants.PROSPECT_COB,
                DbConstants.PROSPECT_PHOTO_ID_TYPE,
                DbConstants.PROSPECT_PHOTO_ID_NUMBER,
                DbConstants.PROSPECT_PHOTO_ID_ISSUE_DATE,
                DbConstants.PROSPECT_ETIN,
                DbConstants.PROSPECT_FATHER_NAME,
                DbConstants.PROSPECT_MOTHER_NAME,
                DbConstants.PROSPECT_SPOUSE_NAME,
                DbConstants.LEAD_PROFESSION,
                DbConstants.PROSPECT_EXCEPTION_LIST,
                DbConstants.LEAD_ORGANIZATION,
                DbConstants.LEAD_DESIGNATION,
                DbConstants.PROSPECT_NOY_CURRENT_JOB,
                DbConstants.PROSPECT_RW_APPLICANT,
                DbConstants.PROSPECT_PERMANENT_ADDRESS,
                DbConstants.LEAD_ADDRESS,
                DbConstants.LEAD_PHONE,
                DbConstants.PROSPECT_NET_SALARY,
                DbConstants.PROSPECT_SALARY_AMOUNT,
                DbConstants.PROSPECT_BUSINESS_INCOME_AMOUNT,
                DbConstants.PROSPECT_WAREHOUSE_INCOME,
                DbConstants.PROSPECT_OFFICE_SPACE_INCOME,
                DbConstants.PROSPECT_SEMIPAKA_INCOME,
                DbConstants.PROSPECT_APARTMENT_INCOME,
                DbConstants.PROSPECT_ACRICULTURAL_INCOME,
                DbConstants.PROSPECT_TUTION,
                DbConstants.PROSPECT_REMITANCE,
                DbConstants.PROSPECT_INTEREST_FDR,
                DbConstants.PROSPECT_FAMILY_EXPENSE,
                DbConstants.PROSPECT_EMI_OTHER,


        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants.CO_APPLICANT_ID + " DESC";
        String WHERE = DbConstants.LEAD_STATUS + "=?";
        Cursor c = db.query(
                DbConstants.TABLE_CO_APPLICANT,  // The table name to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return coApplicantsFetchData(c);
    }




    private ArrayList<CoApplicant> coApplicantsFetchData(Cursor c) {
        ArrayList<CoApplicant> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    int id = c.getInt(c.getColumnIndexOrThrow(DbConstants.CO_APPLICANT_ID));
                    int lead_id = c.getInt(c.getColumnIndexOrThrow(DbConstants.LEAD_ID_FOR_CO));
                    String segment = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_SEGMENT));
                    String userName = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_USER_NAME));
                    String dateOfBirth = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_DATE_OF_BIRTH));
                    String age = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_AGE));
                    String dob = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_DOB));
                    String cob = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_COB));
                    String pIdType = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_PHOTO_ID_TYPE));
                    String pIdNumber = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_PHOTO_ID_NUMBER));
                    String pIssueDate = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_PHOTO_ID_ISSUE_DATE));
                    String etin = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_ETIN));
                    String fName = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_FATHER_NAME));
                    String mName = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_MOTHER_NAME));
                    String sName = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_SPOUSE_NAME));
                    String profession = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_PROFESSION));
                    String exList = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_EXCEPTION_LIST));
                    String organization = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_ORGANIZATION));
                    String designation = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_DESIGNATION));
                    String noYrsInCurJob = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_NOY_CURRENT_JOB));
                    String relationWithApplicant = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_RW_APPLICANT));
                    String permanentAddress = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_PERMANENT_ADDRESS));
                    String address = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_ADDRESS));
                    String phone = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_PHONE));
                    String netSalary = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_NET_SALARY));
                    String salaryAmount = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_SALARY_AMOUNT));
                    String businessIncome = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_BUSINESS_INCOME_AMOUNT));
                    String wareHouseIncome = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_WAREHOUSE_INCOME));
                    String officeSpaceIncome = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_OFFICE_SPACE_INCOME));
                    String semipakaIncome = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_SEMIPAKA_INCOME));
                    String apartmentIncome = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_APARTMENT_INCOME));
                    String ag_Income = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_ACRICULTURAL_INCOME));
                    String tuition = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_TUTION));
                    String remitance = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_REMITANCE));
                    String inFdr = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_INTEREST_FDR));
                    String fExpense = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_FAMILY_EXPENSE));
                    String emiOther = c.getString(c.getColumnIndexOrThrow(DbConstants.PROSPECT_EMI_OTHER));


                    // wrap up data list and return
                    favDataArray.add(new CoApplicant(id, lead_id, segment, userName, dateOfBirth,
                            age, dob, cob, pIdType, pIdNumber, pIssueDate, etin, fName,
                            mName, sName, profession, exList, organization, designation,
                            noYrsInCurJob, relationWithApplicant, permanentAddress, address,
                            phone, netSalary, salaryAmount, businessIncome, wareHouseIncome,
                            officeSpaceIncome, semipakaIncome, apartmentIncome, ag_Income,
                            tuition, remitance, inFdr, fExpense, emiOther
                           ));
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public void deleteFavoriteItem(int itemId) {
        // Which row to update, based on the ID
        String selection = DbConstants.CO_APPLICANT_ID + "=?";
        String[] selectionArgs = {String.valueOf(itemId)};

        db.delete(
                DbConstants.TABLE_CO_APPLICANT,
                selection,
                selectionArgs);
    }

    public void deleteAllFav() {
        db.delete(
                DbConstants.TABLE_CO_APPLICANT,
                null,
                null);
    }
}
