package net.maxproit.salesforce.masum.appdata.sqlite;

/**
 * Created by Masum on 3/11/2018.
 */

public class DbConstants {

    // commons
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String BLOB_TYPE = " blob";
    private static final String COMMA_SEP = ",";
    public static final String COLUMN_NAME_NULLABLE = null;
    public static final String TABLE_LEAD = "lead_table";
    public static final String TABLE_VISIT_PLAN = "visit_plan_table";
    public static final String TABLE_CO_APPLICANT = "co_applicant_table";
    public static final String TABLE_ATACHMENT= "atachment_table";
    public static final String TABLE_FOLLOWUP_HIS= "table_followup";

    public static final String CO_APPLICANT_ID = "_id";
    public static final String LEAD_ID_FOR_CO = "lead_id";


    //lead table
    public static final String _L_ID = "_id";
    public static final String LEAD_BRANCH_NAME = "branch";
    public static final String LEAD_USER_NAME = "user_name";
    public static final String LEAD_PROFESSION = "profession";
    public static final String LEAD_ORGANIZATION = "organzation";
    public static final String LEAD_DESIGNATION = "designation";
    public static final String LEAD_PHONE = "phone";
    public static final String LEAD_ADDRESS = "address";
    public static final String LEAD_REF = "ref";
    public static final String LEAD_PRODUCT_TYPE = "product";
    public static final String LEAD_PRODUCT_SUBCATEGORY = "subcat";
    public static final String LEAD_AMOUNT = "amount";
    public static final String LEAD_OR_INTEREST = "interest";
    public static final String LEAD_OP_FEE = "op_fee";
    public static final String LEAD_DISBURSEMENT_DATE = "disbursement_date";
    public static final String LEAD_VISIT_DATE = "date";
    public static final String LEAD_FOLLOW_UP = "follow";
    public static final String LEAD_REMARK = "remark";
    public static final String PROSPECT_LOAN_TYPE = "loan_type";
    public static final String PROSPECT_PRODUCT_DETAIL = "p_product_detail";
    public static final String PROSPECT_SEGMENT = "segment";
    public static final String PROSPECT_DATE_OF_BIRTH = "date_of_birth";

    public static final String PROSPECT_AGE = "age";
    public static final String PROSPECT_DOB = "dob";
    public static final String PROSPECT_COB = "cob";
    public static final String PROSPECT_PHOTO_ID_TYPE = "p_id_type";
    public static final String PROSPECT_PHOTO_ID_NUMBER = "p_id_number";
    public static final String PROSPECT_PHOTO_ID_ISSUE_DATE = "issue_date";
    public static final String PROSPECT_ETIN = "etin";
    public static final String PROSPECT_FATHER_NAME = "f_name";
    public static final String PROSPECT_MOTHER_NAME = "m_name";
    public static final String PROSPECT_SPOUSE_NAME= "s_name";
    public static final String PROSPECT_EXCEPTION_LIST = "ex_list";
    public static final String PROSPECT_NOY_CURRENT_JOB = "current_job";
    public static final String PROSPECT_RW_APPLICANT = "applicant";
    public static final String PROSPECT_PERMANENT_ADDRESS= "p_address";
    public static final String PROSPECT_NET_SALARY = "net_salary";
    public static final String PROSPECT_SALARY_AMOUNT = "salary_amount";
    public static final String PROSPECT_RENTAL_INCOME = "rent_income";
    public static final String PROSPECT_RENTAL_INCOME_AMOUNT = "income_amount";

    public static final String PROSPECT_BUSINESS_INCOME_AMOUNT = "b_income_amount";
    public static final String PROSPECT_WAREHOUSE_INCOME = "warehouse_income";
    public static final String PROSPECT_OFFICE_SPACE_INCOME = "office_space_income";
    public static final String PROSPECT_SEMIPAKA_INCOME = "semipaka_income";
    public static final String PROSPECT_APARTMENT_INCOME = "apartment_income";

    public static final String PROSPECT_ACRICULTURAL_INCOME = "ag_income";
    public static final String PROSPECT_TUTION = "tution";
    public static final String PROSPECT_REMITANCE = "remitance";
    public static final String PROSPECT_INTEREST_FDR = "in_fdr";
    public static final String PROSPECT_FAMILY_EXPENSE = "f_expense";
    public static final String PROSPECT_EMI_OTHER= "emi_other";
    public static final String PROSPECT_SECURITY_VALUE= "s_value";
    public static final String PROSPECT_LOAN_REQUIRED = "loan_required";
    public static final String PROSPECT_LOAD_TERM = "loan_term";
    public static final String PROSPECT_PI_RATE = "pi_rate";
    public static final String PROSPECT_FEE = "fee";
    public static final String PROSPECT_MONTHLY_EMI = "monthly_emi";
    public static final String LEAD_STATUS = "status";

    //visit plan
    public static final String _V_ID = "_id";
    public static final String VISIT_PLAN_CLIENT_NAME = "client_name";
    public static final String VISIT_PLAN_CLIENT_TYPE = "client_type";
    public static final String VISIT_PLAN_MOBILE_NUMBER = "mobile_number";
    public static final String VISIT_PLAN_PRODUCT_TYPE = "product_type";
    public static final String VISIT_PLAN_CITY = "city";
    public static final String VISIT_PLAN_POLICE_STATION = "police_station";
    public static final String VISIT_PLAN_PURPOSE_OF_VISIT = "purpose_of_visit";
    public static final String VISIT_PLAN_DATE_OF_VISIT = "date_of_visit";
    public static final String VISIT_PLAN_REMARKS = "remarks";





    //attachment
    public static final String ATACHMENT_ID="_id";
    public static final String LEAD_ID="lead_id";
    public static final String ATACH_PP="pp";
    public static final String ATACH_ID_CARD="id_card";
    public static final String ATACH_V_CARD="v_card";


    //follow up history
    public static final String FOLLOW_UP_HIS_ID="_id";
    public static final String FOLLOW_UP_V_ID="v_id";
    public static final String FOLLOW_UP_HIS_DATE="date";
    public static final String FOLLOW_UP_HIS_REMARK="remark";






    //lead table sql
    public static final String SQL_CREATE_LEAD_ENTRIES =
            "CREATE TABLE " + TABLE_LEAD + " (" +
                    _L_ID + " INTEGER PRIMARY KEY," +
                    LEAD_BRANCH_NAME + TEXT_TYPE + COMMA_SEP +
                    LEAD_PROFESSION + TEXT_TYPE + COMMA_SEP +
                    LEAD_USER_NAME + TEXT_TYPE + COMMA_SEP +
                    LEAD_ORGANIZATION + TEXT_TYPE + COMMA_SEP +
                    LEAD_DESIGNATION + TEXT_TYPE + COMMA_SEP +
                    LEAD_PHONE + TEXT_TYPE + COMMA_SEP +
                    LEAD_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    LEAD_REF + TEXT_TYPE + COMMA_SEP +
                    LEAD_PRODUCT_TYPE + TEXT_TYPE + COMMA_SEP +
                    LEAD_PRODUCT_SUBCATEGORY + TEXT_TYPE + COMMA_SEP +
                    LEAD_AMOUNT + TEXT_TYPE + COMMA_SEP +
                    LEAD_OR_INTEREST + TEXT_TYPE + COMMA_SEP +
                    LEAD_OP_FEE + TEXT_TYPE + COMMA_SEP +
                    LEAD_DISBURSEMENT_DATE + TEXT_TYPE + COMMA_SEP +
                    LEAD_VISIT_DATE + TEXT_TYPE + COMMA_SEP +
                    LEAD_FOLLOW_UP + TEXT_TYPE + COMMA_SEP +
                    LEAD_REMARK + TEXT_TYPE + COMMA_SEP +
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
                    PROSPECT_MONTHLY_EMI + TEXT_TYPE + COMMA_SEP +
                    LEAD_STATUS + TEXT_TYPE + " )";


    public static final String SQL_CREATE_CO_APPLICANT_ENTRIES =
                    "CREATE TABLE " + TABLE_CO_APPLICANT + " (" +
                            CO_APPLICANT_ID + " INTEGER PRIMARY KEY," +
                            LEAD_ID_FOR_CO + TEXT_TYPE + COMMA_SEP +
                            LEAD_USER_NAME + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_SEGMENT + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_DATE_OF_BIRTH + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_AGE + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_DOB + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_COB + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_PHOTO_ID_TYPE + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_PHOTO_ID_NUMBER + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_PHOTO_ID_ISSUE_DATE + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_ETIN + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_FATHER_NAME + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_MOTHER_NAME + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_SPOUSE_NAME + TEXT_TYPE + COMMA_SEP +
                            LEAD_PROFESSION + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_EXCEPTION_LIST + TEXT_TYPE + COMMA_SEP +
                            LEAD_ORGANIZATION + TEXT_TYPE + COMMA_SEP +
                            LEAD_DESIGNATION + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_NOY_CURRENT_JOB + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_RW_APPLICANT + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_PERMANENT_ADDRESS + TEXT_TYPE + COMMA_SEP +
                            LEAD_ADDRESS + TEXT_TYPE + COMMA_SEP +
                            LEAD_PHONE + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_NET_SALARY + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_SALARY_AMOUNT + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_BUSINESS_INCOME_AMOUNT + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_WAREHOUSE_INCOME + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_OFFICE_SPACE_INCOME + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_SEMIPAKA_INCOME + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_APARTMENT_INCOME + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_ACRICULTURAL_INCOME + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_TUTION + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_REMITANCE + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_INTEREST_FDR + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_FAMILY_EXPENSE + TEXT_TYPE + COMMA_SEP +
                            PROSPECT_EMI_OTHER + TEXT_TYPE + COMMA_SEP +


                            " )";


    //visit table sql
    public static final String SQL_CREATE_VISIT_ENTRIES =
            "CREATE TABLE " + TABLE_VISIT_PLAN + " (" +
                    _L_ID + " INTEGER PRIMARY KEY," +
                    VISIT_PLAN_CLIENT_NAME + TEXT_TYPE + COMMA_SEP +
                    VISIT_PLAN_CLIENT_TYPE + TEXT_TYPE + COMMA_SEP +
                    VISIT_PLAN_MOBILE_NUMBER + TEXT_TYPE + COMMA_SEP +
                    VISIT_PLAN_PRODUCT_TYPE + TEXT_TYPE + COMMA_SEP +
                    VISIT_PLAN_CITY + TEXT_TYPE + COMMA_SEP +
                    VISIT_PLAN_POLICE_STATION + TEXT_TYPE + COMMA_SEP +
                    VISIT_PLAN_PURPOSE_OF_VISIT + TEXT_TYPE + COMMA_SEP +
                    VISIT_PLAN_DATE_OF_VISIT + TEXT_TYPE + COMMA_SEP +
                    VISIT_PLAN_REMARKS + TEXT_TYPE + COMMA_SEP +
                    LEAD_STATUS + TEXT_TYPE + " )";

    //attachment table sql
    public static final String SQL_CREATE_ATTACHMENT_ENTRIES =
            "CREATE TABLE " + TABLE_ATACHMENT + " (" +
                    ATACHMENT_ID + " INTEGER PRIMARY KEY," +
                    LEAD_ID + INTEGER_TYPE + COMMA_SEP +
                    ATACH_PP + BLOB_TYPE + COMMA_SEP +
                    ATACH_ID_CARD + BLOB_TYPE + COMMA_SEP +
                    ATACH_V_CARD + BLOB_TYPE +" )";


    //create followup table history

    //attachment table sql
    public static final String SQL_CREATE_FOLLOWUP_HIS_ENTRIES =
            "CREATE TABLE " + TABLE_FOLLOWUP_HIS + " (" +
                    FOLLOW_UP_HIS_ID + " INTEGER PRIMARY KEY," +
                    FOLLOW_UP_V_ID + INTEGER_TYPE + COMMA_SEP +
                    FOLLOW_UP_HIS_DATE + TEXT_TYPE + COMMA_SEP +
                    FOLLOW_UP_HIS_REMARK + TEXT_TYPE+" )";




    //SPINNER TABLES

    public static final String SQL_DELETE_LEAD_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_LEAD;

    public static final String SQL_DELETE_VISIT_PLAN_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_VISIT_PLAN;

    public static final String SQL_DELETE_CO_APPLICANT_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_CO_APPLICANT;




    public static final String SQL_DELETE_ATTACHMENT_LAON =
            "DROP TABLE IF EXISTS " + TABLE_ATACHMENT;

    public static final String SQL_DELETE_FOLLOWUP_HIS =
            "DROP TABLE IF EXISTS " + TABLE_FOLLOWUP_HIS;



}
