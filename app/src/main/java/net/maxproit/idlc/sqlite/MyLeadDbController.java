package net.maxproit.idlc.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.maxproit.idlc.AppConstant;
import net.maxproit.idlc.model.MyNewProspect;
import net.maxproit.idlc.model.newlead.MyNewLead;


import java.util.ArrayList;

public class MyLeadDbController {

    private SQLiteDatabase db;
    private Context mContext;

    public MyLeadDbController(Context context) {
        db = DbHelper.getInstance(context).getWritableDatabase();
        mContext = context;
    }

    public int insertLeadData(String branchName, String uName, String profession, String organization, String designation,
                              String phone, String address, String ref, String product, String subCat, String amount, String
                                  interest, String fee, String date, String follow, String remark) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.LEAD_BRANCH_NAME, branchName);
        values.put(DbConstants.LEAD_USER_NAME, uName);
        values.put(DbConstants.LEAD_PROFESSION, profession);
        values.put(DbConstants.LEAD_ORGANIZATION, organization);
        values.put(DbConstants.LEAD_DESIGNATION, designation);
        values.put(DbConstants.LEAD_PHONE, phone);
        values.put(DbConstants.LEAD_ADDRESS, address);
        values.put(DbConstants.LEAD_REF, ref);
        values.put(DbConstants.LEAD_PRODUCT_TYPE, product);
        values.put(DbConstants.LEAD_PRODUCT_SUBCATEGORY, subCat);
        values.put(DbConstants.LEAD_AMOUNT, amount);
        values.put(DbConstants.LEAD_OR_INTEREST, interest);
        values.put(DbConstants.LEAD_OP_FEE, fee);
        values.put(DbConstants.LEAD_VISIT_DATE, date);
        values.put(DbConstants.LEAD_FOLLOW_UP, follow);
        values.put(DbConstants.LEAD_REMARK, remark);
        values.put(DbConstants.LEAD_STATUS, AppConstant.LEAD_STATUS_NEW);

        // Insert the new row, returning the primary key value of the new row
        return (int) db.insert(
                DbConstants.TABLE_LEAD,
                DbConstants.COLUMN_NAME_NULLABLE,
                values);
    }
/*
    PROSPECT_LOAN_TYPE + TEXT_TYPE + COMMA_SEP +
    PROSPECT_PRODUCT_DETAIL + TEXT_TYPE + COMMA_SEP +
    PROSPECT_SEGMENT + TEXT_TYPE + COMMA_SEP +
    PROSPECT_AGE + TEXT_TYPE + COMMA_SEP +
    PROSPECT_DOB + TEXT_TYPE + COMMA_SEP +
    PROSPECT_COB + TEXT_TYPE + COMMA_SEP +
    PROSPECT_PHOTO_ID_NUMBER + TEXT_TYPE + COMMA_SEP +
    PROSPECT_PHOTO_ID_ISSUE_DATE + TEXT_TYPE + COMMA_SEP +
    PROSPECT_ETIN + TEXT_TYPE + COMMA_SEP +
    PROSPECT_FATHER_NAME + TEXT_TYPE + COMMA_SEP +
    PROSPECT_MOTHER_NAME + TEXT_TYPE + COMMA_SEP +
    PROSPECT_SPOUSE_NAME + TEXT_TYPE + COMMA_SEP +
    PROSPECT_EXCEPTION_LIST + TEXT_TYPE + COMMA_SEP +
    PROSPECT_NOY_CURRENT_JOB + TEXT_TYPE + COMMA_SEP +
    PROSPECT_RW_APPLICANT + TEXT_TYPE + COMMA_SEP +
    PROSPECT_PERMANENT_ADDRESS + TEXT_TYPE + COMMA_SEP +
    PROSPECT_NET_SALARY + TEXT_TYPE + COMMA_SEP +
    PROSPECT_SALARY_AMOUNT + TEXT_TYPE + COMMA_SEP +
    PROSPECT_RENTAL_INCOME + TEXT_TYPE + COMMA_SEP +
    PROSPECT_RENTAL_INCOME_AMOUNT + TEXT_TYPE + COMMA_SEP +
    PROSPECT_ACRICULTURAL_INCOME + TEXT_TYPE + COMMA_SEP +
    PROSPECT_TUTION + TEXT_TYPE + COMMA_SEP +
    PROSPECT_REMITANCE + TEXT_TYPE + COMMA_SEP +
    PROSPECT_INTEREST_FDR + TEXT_TYPE + COMMA_SEP +
    PROSPECT_FAMILY_EXPENSE + TEXT_TYPE + COMMA_SEP +
    PROSPECT_EMI_OTHER + TEXT_TYPE + COMMA_SEP +
    PROSPECT_SECURITY_VALUE + TEXT_TYPE + COMMA_SEP +
    PROSPECT_LOAN_REQUIRED + TEXT_TYPE + COMMA_SEP +
    PROSPECT_LOAD_TERM + TEXT_TYPE + COMMA_SEP +
    PROSPECT_PI_RATE + TEXT_TYPE + COMMA_SEP +
    PROSPECT_FEE + TEXT_TYPE + COMMA_SEP +
    PROSPECT_MONTHLY_EMI + TEXT_TYPE + COMMA_SEP +*/

    public int upDateProspectData(MyNewProspect myProspect,int id){
        ContentValues values = new ContentValues();
        values.put(DbConstants.LEAD_BRANCH_NAME, myProspect.getBranchName());
        values.put(DbConstants.LEAD_USER_NAME, myProspect.getUserName());
        values.put(DbConstants.LEAD_PROFESSION, myProspect.getProfession());
        values.put(DbConstants.LEAD_ORGANIZATION, myProspect.getOrganization());
        values.put(DbConstants.LEAD_DESIGNATION, myProspect.getDesignation());
        values.put(DbConstants.LEAD_PHONE, myProspect.getPhone());
        values.put(DbConstants.LEAD_ADDRESS, myProspect.getAddress());
        values.put(DbConstants.LEAD_REF, myProspect.getSourceRef());
        values.put(DbConstants.LEAD_PRODUCT_TYPE, myProspect.getProductType());
        values.put(DbConstants.LEAD_PRODUCT_SUBCATEGORY, myProspect.getProductSubcategory());
        values.put(DbConstants.LEAD_AMOUNT, myProspect.getLoanAmount());
        values.put(DbConstants.LEAD_OR_INTEREST, myProspect.getOrInterest());
        values.put(DbConstants.LEAD_OP_FEE, myProspect.getOpFee());
        values.put(DbConstants.LEAD_VISIT_DATE, myProspect.getVisitDate());
        values.put(DbConstants.LEAD_FOLLOW_UP, myProspect.getFollowUp());
        values.put(DbConstants.LEAD_REMARK, myProspect.getRemark());
        values.put(DbConstants.PROSPECT_LOAN_TYPE, myProspect.getpLoanType());
        values.put(DbConstants.PROSPECT_PRODUCT_DETAIL, myProspect.getProductDetail());
        values.put(DbConstants.PROSPECT_SEGMENT, myProspect.getSegment());
        values.put(DbConstants.PROSPECT_AGE, myProspect.getAge());
        values.put(DbConstants.PROSPECT_DOB, myProspect.getDob());
        values.put(DbConstants.PROSPECT_COB, myProspect.getCob());
        values.put(DbConstants.PROSPECT_PHOTO_ID_NUMBER, myProspect.getpIdNumber());
        values.put(DbConstants.PROSPECT_PHOTO_ID_ISSUE_DATE, myProspect.getpIssueDate());
        values.put(DbConstants.PROSPECT_ETIN, myProspect.getEtin());
        values.put(DbConstants.PROSPECT_FATHER_NAME, myProspect.getfName());
        values.put(DbConstants.PROSPECT_MOTHER_NAME, myProspect.getmName());
        values.put(DbConstants.PROSPECT_SPOUSE_NAME, myProspect.getsName());
        values.put(DbConstants.PROSPECT_EXCEPTION_LIST, myProspect.getExList());
        values.put(DbConstants.PROSPECT_NOY_CURRENT_JOB, myProspect.getCurrentJob());
        values.put(DbConstants.PROSPECT_RW_APPLICANT, myProspect.getApplicant());
        values.put(DbConstants.PROSPECT_PERMANENT_ADDRESS, myProspect.getpAddress());
        values.put(DbConstants.PROSPECT_NET_SALARY, myProspect.getNetSalary());
        values.put(DbConstants.PROSPECT_SALARY_AMOUNT, myProspect.getSalaryAmount());
        values.put(DbConstants.PROSPECT_RENTAL_INCOME, myProspect.getRentIncome());
        values.put(DbConstants.PROSPECT_RENTAL_INCOME_AMOUNT, myProspect.getRentIncomeAmount());
        values.put(DbConstants.PROSPECT_ACRICULTURAL_INCOME, myProspect.getAg_Income());
        values.put(DbConstants.PROSPECT_TUTION, myProspect.getTution());
        values.put(DbConstants.PROSPECT_REMITANCE, myProspect.getRemitance());
        values.put(DbConstants.PROSPECT_INTEREST_FDR, myProspect.getInFdr());
        values.put(DbConstants.PROSPECT_FAMILY_EXPENSE, myProspect.getfExpense());
        values.put(DbConstants.PROSPECT_EMI_OTHER, myProspect.getEmiOther());
        values.put(DbConstants.PROSPECT_SECURITY_VALUE, myProspect.getsValue());
        values.put(DbConstants.PROSPECT_LOAN_REQUIRED, myProspect.getLoanReq());
        values.put(DbConstants.PROSPECT_LOAD_TERM, myProspect.getLoanTerm());
        values.put(DbConstants.PROSPECT_PI_RATE, myProspect.getPiRate());
        values.put(DbConstants.PROSPECT_FEE, myProspect.getFee());
        values.put(DbConstants.PROSPECT_MONTHLY_EMI, myProspect.getMonthlyEmi());
        values.put(DbConstants.LEAD_STATUS, AppConstant.LEAD_STATUS_PROSPECT);

        return db.update(DbConstants.TABLE_LEAD, values, DbConstants._L_ID+"="+id, null);

    }

    public int insertProspectData(MyNewProspect myProspect){
        ContentValues values = new ContentValues();
        values.put(DbConstants.LEAD_BRANCH_NAME, myProspect.getBranchName());
        values.put(DbConstants.LEAD_USER_NAME, myProspect.getUserName());
        values.put(DbConstants.LEAD_PROFESSION, myProspect.getProfession());
        values.put(DbConstants.LEAD_ORGANIZATION, myProspect.getOrganization());
        values.put(DbConstants.LEAD_DESIGNATION, myProspect.getDesignation());
        values.put(DbConstants.LEAD_PHONE, myProspect.getPhone());
        values.put(DbConstants.LEAD_ADDRESS, myProspect.getAddress());
        values.put(DbConstants.LEAD_REF, myProspect.getSourceRef());
        values.put(DbConstants.LEAD_PRODUCT_TYPE, myProspect.getProductType());
        values.put(DbConstants.LEAD_PRODUCT_SUBCATEGORY, myProspect.getProductSubcategory());
        values.put(DbConstants.LEAD_AMOUNT, myProspect.getLoanAmount());
        values.put(DbConstants.LEAD_OR_INTEREST, myProspect.getOrInterest());
        values.put(DbConstants.LEAD_OP_FEE, myProspect.getOpFee());
        values.put(DbConstants.LEAD_VISIT_DATE, myProspect.getVisitDate());
        values.put(DbConstants.LEAD_FOLLOW_UP, myProspect.getFollowUp());
        values.put(DbConstants.LEAD_REMARK, myProspect.getRemark());
        values.put(DbConstants.PROSPECT_LOAN_TYPE, myProspect.getpLoanType());
        values.put(DbConstants.PROSPECT_PRODUCT_DETAIL, myProspect.getProductDetail());
        values.put(DbConstants.PROSPECT_SEGMENT, myProspect.getSegment());
        values.put(DbConstants.PROSPECT_AGE, myProspect.getAge());
        values.put(DbConstants.PROSPECT_DOB, myProspect.getDob());
        values.put(DbConstants.PROSPECT_COB, myProspect.getCob());
        values.put(DbConstants.PROSPECT_PHOTO_ID_NUMBER, myProspect.getpIdNumber());
        values.put(DbConstants.PROSPECT_PHOTO_ID_ISSUE_DATE, myProspect.getpIssueDate());
        values.put(DbConstants.PROSPECT_ETIN, myProspect.getEtin());
        values.put(DbConstants.PROSPECT_FATHER_NAME, myProspect.getfName());
        values.put(DbConstants.PROSPECT_MOTHER_NAME, myProspect.getmName());
        values.put(DbConstants.PROSPECT_SPOUSE_NAME, myProspect.getsName());
        values.put(DbConstants.PROSPECT_EXCEPTION_LIST, myProspect.getExList());
        values.put(DbConstants.PROSPECT_NOY_CURRENT_JOB, myProspect.getCurrentJob());
        values.put(DbConstants.PROSPECT_RW_APPLICANT, myProspect.getApplicant());
        values.put(DbConstants.PROSPECT_PERMANENT_ADDRESS, myProspect.getpAddress());
        values.put(DbConstants.PROSPECT_NET_SALARY, myProspect.getNetSalary());
        values.put(DbConstants.PROSPECT_SALARY_AMOUNT, myProspect.getSalaryAmount());
        values.put(DbConstants.PROSPECT_RENTAL_INCOME, myProspect.getRentIncome());
        values.put(DbConstants.PROSPECT_RENTAL_INCOME_AMOUNT, myProspect.getRentIncomeAmount());
        values.put(DbConstants.PROSPECT_ACRICULTURAL_INCOME, myProspect.getAg_Income());
        values.put(DbConstants.PROSPECT_TUTION, myProspect.getTution());
        values.put(DbConstants.PROSPECT_REMITANCE, myProspect.getRemitance());
        values.put(DbConstants.PROSPECT_INTEREST_FDR, myProspect.getInFdr());
        values.put(DbConstants.PROSPECT_FAMILY_EXPENSE, myProspect.getfExpense());
        values.put(DbConstants.PROSPECT_EMI_OTHER, myProspect.getEmiOther());
        values.put(DbConstants.PROSPECT_SECURITY_VALUE, myProspect.getsValue());
        values.put(DbConstants.PROSPECT_LOAN_REQUIRED, myProspect.getLoanReq());
        values.put(DbConstants.PROSPECT_LOAD_TERM, myProspect.getLoanTerm());
        values.put(DbConstants.PROSPECT_PI_RATE, myProspect.getPiRate());
        values.put(DbConstants.PROSPECT_FEE, myProspect.getFee());
        values.put(DbConstants.PROSPECT_MONTHLY_EMI, myProspect.getMonthlyEmi());
        values.put(DbConstants.LEAD_STATUS, myProspect.getStatus());

        return (int) db.insert(
                DbConstants.TABLE_LEAD,
                DbConstants.COLUMN_NAME_NULLABLE,
                values);
    }


    public int updateLeadDataStatus(int id,String status) {

        ContentValues values = new ContentValues();
        values.put(DbConstants.LEAD_STATUS, status);


       return db.update(DbConstants.TABLE_LEAD, values, DbConstants._L_ID+"="+id, null);


    }



    public ArrayList<MyNewLead> getProspectData() {

        String[] projection = {
                DbConstants._L_ID,
                DbConstants.LEAD_BRANCH_NAME,
                DbConstants.LEAD_USER_NAME,
                DbConstants.LEAD_PROFESSION,
                DbConstants.LEAD_ORGANIZATION,
                DbConstants.LEAD_DESIGNATION,
                DbConstants.LEAD_PHONE,
                DbConstants.LEAD_ADDRESS,
                DbConstants.LEAD_REF,
                DbConstants.LEAD_PRODUCT_TYPE,
                DbConstants.LEAD_PRODUCT_SUBCATEGORY,
                DbConstants.LEAD_AMOUNT,
                DbConstants.LEAD_OR_INTEREST,
                DbConstants.LEAD_OP_FEE,
                DbConstants.LEAD_VISIT_DATE,
                DbConstants.LEAD_FOLLOW_UP,
                DbConstants.LEAD_REMARK,
                DbConstants.LEAD_STATUS,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants._L_ID + " DESC";
        String WHERE =DbConstants.LEAD_STATUS+"=?";
        Cursor c = db.query(
                DbConstants.TABLE_LEAD,  // The table name to query
                projection,                               // The columns to return
                WHERE,                                // The columns for the WHERE clause
                new String[] { AppConstant.LEAD_STATUS_PROSPECT},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchData(c);
    }



    public ArrayList<MyNewLead> getAllData() {

        String[] projection = {
                DbConstants._L_ID,
                DbConstants.LEAD_BRANCH_NAME,
                DbConstants.LEAD_USER_NAME,
                DbConstants.LEAD_PROFESSION,
                DbConstants.LEAD_ORGANIZATION,
                DbConstants.LEAD_DESIGNATION,
                DbConstants.LEAD_PHONE,
                DbConstants.LEAD_ADDRESS,
                DbConstants.LEAD_REF,
                DbConstants.LEAD_PRODUCT_TYPE,
                DbConstants.LEAD_PRODUCT_SUBCATEGORY,
                DbConstants.LEAD_AMOUNT,
                DbConstants.LEAD_OR_INTEREST,
                DbConstants.LEAD_OP_FEE,
                DbConstants.LEAD_VISIT_DATE,
                DbConstants.LEAD_FOLLOW_UP,
                DbConstants.LEAD_REMARK,
                DbConstants.LEAD_STATUS,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = DbConstants._L_ID + " DESC";
        String WHERE =DbConstants.LEAD_STATUS+"=?";
        Cursor c = db.query(
                DbConstants.TABLE_LEAD,  // The table name to query
                projection,                               // The columns to return
                WHERE,                                // The columns for the WHERE clause
                new String[] { AppConstant.LEAD_STATUS_NEW },                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        return fetchData(c);
    }


    private ArrayList<MyNewLead> fetchData(Cursor c) {
        ArrayList<MyNewLead> favDataArray = new ArrayList<>();

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    // get  the  data into array,or class variable
                    int id = c.getInt(c.getColumnIndexOrThrow(DbConstants._L_ID));
                    String branchName = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_BRANCH_NAME));
                    String userName = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_USER_NAME));
                    String profession = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_PROFESSION));
                    String organization = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_ORGANIZATION));
                    String designation = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_DESIGNATION));
                    String phone = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_PHONE));
                    String address = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_ADDRESS));
                    String ref = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_REF));
                    String productType = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_PRODUCT_TYPE));
                    String subCategory = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_PRODUCT_SUBCATEGORY));
                    String amount = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_AMOUNT));
                    String interest = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_OR_INTEREST));
                    String fee = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_OP_FEE));
                    String visitDate = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_VISIT_DATE));
                    String followUp = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_FOLLOW_UP));
                    String remark = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_REMARK));
                    String status = c.getString(c.getColumnIndexOrThrow(DbConstants.LEAD_STATUS));



                    // wrap up data list and return
                    favDataArray.add(new MyNewLead(id,branchName, userName, profession, organization, designation, phone,address,ref
                            ,productType,subCategory,amount,interest,fee,visitDate,followUp,remark,status));
                } while (c.moveToNext());
            }
            c.close();
        }
        return favDataArray;
    }

    public void deleteFavoriteItem(int itemId) {
        // Which row to update, based on the ID
        String selection = DbConstants._L_ID + "=?";
        String[] selectionArgs = {String.valueOf(itemId)};

        db.delete(
                DbConstants.TABLE_LEAD,
                selection,
                selectionArgs);
    }

    public void deleteAllFav() {
        db.delete(
                DbConstants.TABLE_LEAD,
                null,
                null);
    }
}
