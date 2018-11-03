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
    public static final String TABLE_ATACHMENT= "atachment_table";

    public static final String TABLE_CLIENT_TYPE = "client_type_table";
    public static final String TABLE_PURPOSE_OF_VISIT = "purpose_of_visit_table";
    public static final String TABLE_CITY = "city_table";
    public static final String TABLE_POLICE_STATION = "police_station_table";
    public static final String TABLE_DHAKA_NORTH_POLICE_STATION = "dhaka_north_police_station_table";
    public static final String TABLE_DHAKA_SOUTH_POLICE_STATION = "dhaka_south_police_station_table";
    public static final String TABLE_NARAYANGANJ_POLICE_STATION = "narayanganj_police_station_table";
    public static final String TABLE_HOME_LOAN = "home_loan_table";
    public static final String TABLE_CAR_LOAN = "car_loan_table";
    public static final String TABLE_PERSONAL_LAON = "personal_loan_table";
    public static final String TABLE_BRANCH = "branch_table";
    public static final String TABLE_PROFESSION = "profession_table";
    public static final String TABLE_SOURCE_OF_REFERENCE = "source_of_reference_table";
    public static final String TABLE_PRODUCT_TYPE = "product_type_table";
    public static final String TABLE_PRODUCT_SUBCATEGORY = "product_subcategory_table";
    public static final String TABLE_FOLLOW_UP = "follow_up_table";
    public static final String TABLE_REMARKS = "remarks_table";
    public static final String TABLE_PRODUCT_CATEGORY = "product_category_table";
    public static final String TABLE_PRODUCT_DETAIL = "product_detail_table";
    public static final String TABLE_SEGMENT = "segment_table";
    public static final String TABLE_BIRTH_DISTRICT = "birth_district_table";
    public static final String TABLE_BIRTH_COUNTRY = "birth_country_table";
    public static final String TABLE_RELATIONSHIP_WITH_APPLICANT = "relationship_with_applicant_table";
    public static final String TABLE_MONTHLY_SALARY = "monthly_salary_table";
    public static final String TABLE_MONTHLY_RENTAL_INCOME = "monthly_rental_income_table";
    public static final String TABLE_BRAND_NAME = "brand_name_table";
    public static final String TABLE_MANUFACTURING_YEAR = "manufacturing_year_table";
    public static final String TABLE_MANUFACTURING_COUNTRY = "manufacturing_country_table";
    public static final String TABLE_VEHICLE_TYPE = "vehicle_type_table";

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
    public static final String PROSPECT_AGE = "age";
    public static final String PROSPECT_DOB = "dob";
    public static final String PROSPECT_COB = "cob";
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


    //all Spinner
    public static final String CLIENT_TYPE_ID = "_id";
    public static final String CLIENT_TYPE = "clinet_type";

    public static final String PURPOSE_OF_VISIT_ID = "_id";
    public static final String PURPOSE_OF_VISIT = "purpose_of_visit";

    public static final String CITY_ID = "_id";
    public static final String CITY = "city";

    public static final String POLICE_STATION_ID = "_id";
    public static final String POLICE_STATION = "police_station";


    public static final String DHAKA_NORHT_POLICE_STATION_ID = "_id";
    public static final String DHAKA_NORHT_POLICE_STATION = "dhaka_north_police_station";

    public static final String DHAKA_SOUTH_POLICE_STATION_ID = "_id";
    public static final String DHAKA_SOUTH_POLICE_STATION = "dhaka_south_police_station";

    public static final String NARAYANGANJ_POLICE_STATION_ID = "_id";
    public static final String NARAYANGANJ_POLICE_STATION = "narayanganj_police_station";

    public static final String HOME_LOAN_ID = "_id";
    public static final String HOME_LOAN = "home_loan";

    public static final String CAR_LOAN_ID = "_id";
    public static final String CAR_LOAN = "car_loan";

    public static final String PERSONAL_LOAN_ID = "_id";
    public static final String PERSONAL_LOAN = "personal_loan";


    public static final String BRANCH_ID = "_id";
    public static final String BRANCH = "branch";

    public static final String PROFESSION_ID = "_id";
    public static final String PROFESSION = "profession";

    public static final String SOURCE_OF_REFERENCE_ID = "_id";
    public static final String SOURCE_OF_REFERENCE = "source_of_reference_id";

    public static final String PRODUCT_TYPE_ID = "_id";
    public static final String PRODUCT_TYPE = "product_type_id";

    public static final String PRODUCT_SUBCATEGORY_ID = "_id";
    public static final String PRODUCT_SUBCATEGORY = "product_subcategory";

    public static final String FOLLOW_UP_ID = "_id";
    public static final String FOLLOW_UP = "follow_up";

    public static final String REMARKS_ID = "_id";
    public static final String REMARKS = "remarks";

    public static final String PRODUCT_CATEGORY_ID = "_id";
    public static final String PRODUCT_CATEGORY = "product_category";

    public static final String PRODUCT_DETAIL_ID = "_id";
    public static final String PRODUCT_DETAIL = "product_detail";

    public static final String SEGMENT_ID = "_id";
    public static final String SEGMENT = "segment";

    public static final String BIRTH_DISTRICT_ID = "_id";
    public static final String BIRTH_DISTRICT = "birth_district";

    public static final String BIRTH_COUNTRY_ID = "_id";
    public static final String BIRTH_COUNTRY = "birth_country";

    public static final String RELATIONSHIP_WITH_APPLICANT_ID = "_id";
    public static final String RELATIONSHIP_WITH_APPLICANT = "relationship_with_applicant";

    public static final String MONTHLY_SALARY_ID = "_id";
    public static final String MONTHLY_SALARY = "monthly_salary";

    public static final String MONTHLY_RENTAL_INCOME_ID = "_id";
    public static final String MONTHLY_RENTAL_INCOME = "monthly_rental_income";

    public static final String BRAND_NAME_ID = "_id";
    public static final String BRAND_NAME = "brand_name";

    public static final String MANUFACTURING_YEAR_ID = "_id";
    public static final String MANUFACTURING_YEAR = "manufacturing_year";

    public static final String MANUFACTURING_COUNTRY_ID = "_id";
    public static final String MANUFACTURING_COUNTRY = "manufacturing_country";

    public static final String VEHICLE_TYPE_ID = "_id";
    public static final String VEHICLE_TYPE = "vehicle_type";


    //attachment
    public static final String ATACHMENT_ID="_id";
    public static final String LEAD_ID="lead_id";
    public static final String ATACH_PP="pp";
    public static final String ATACH_ID_CARD="id_card";
    public static final String ATACH_V_CARD="v_card";

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

    // SPINNER TABLES
    public static final String SQL_SPINNER_CLIENT_TYPE =
            "CREATE TABLE " + TABLE_CLIENT_TYPE + " ("+
                    CLIENT_TYPE_ID + " INTEGER PRIMARY KEY,"+
                    CLIENT_TYPE + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_PURPOSE_OF_VISIT =
            "CREATE TABLE " + TABLE_PURPOSE_OF_VISIT +" ("+
                    PURPOSE_OF_VISIT_ID + " INTEGER PRIMARY KEY,"+
                    PURPOSE_OF_VISIT + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_CITY =
            "CREATE TABLE " + TABLE_CITY + " ("+
                    CITY_ID + " INTEGER PRIMARY KEY,"+
                    CITY + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_POLICE_STATION =
            "CREATE TABLE " + TABLE_POLICE_STATION + " ("+
                    POLICE_STATION_ID + " INTEGER PRIMARY KEY,"+
                    POLICE_STATION + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_DHAKA_NORTH_POLICE_STATION =
            "CREATE TABLE " + TABLE_DHAKA_NORTH_POLICE_STATION + " ("+
                    DHAKA_NORHT_POLICE_STATION_ID + " INTEGER PRIMARY KEY,"+
                    DHAKA_NORHT_POLICE_STATION + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_DHAKA_SOUTH_POLICE_STATION =
            "CREATE TABLE " + TABLE_DHAKA_SOUTH_POLICE_STATION + " ("+
                    DHAKA_SOUTH_POLICE_STATION_ID + " INTEGER PRIMARY KEY,"+
                    DHAKA_SOUTH_POLICE_STATION + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_NARAYANGANJ_POLICE_STATION =
            "CREATE TABLE " + TABLE_NARAYANGANJ_POLICE_STATION + " ("+
                    NARAYANGANJ_POLICE_STATION_ID + " INTEGER PRIMARY KEY,"+
                    NARAYANGANJ_POLICE_STATION + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_BRANCH =
            "CREATE TABLE " + TABLE_BRANCH +" ("+
                    BRANCH_ID + " INTEGER PRIMARY KEY,"+
                    BRANCH + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_PROFESSION =
            "CREATE TABLE " + TABLE_PROFESSION +" ("+
                    PROFESSION_ID + " INTEGER PRIMARY KEY,"+
                    PROFESSION + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_SOURCE_OF_REFERENCE =
            "CREATE TABLE " + TABLE_SOURCE_OF_REFERENCE +" ("+
                    SOURCE_OF_REFERENCE_ID + " INTEGER PRIMARY KEY,"+
                    SOURCE_OF_REFERENCE + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_PRODUCT_TYPE =
            "CREATE TABLE " + TABLE_PRODUCT_TYPE +" ("+
                    PRODUCT_TYPE_ID + " INTEGER PRIMARY KEY,"+
                    PRODUCT_TYPE + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_PRODUCT_SUBCATEGORY =
            "CREATE TABLE " + TABLE_PRODUCT_SUBCATEGORY + " ("+
                    PRODUCT_SUBCATEGORY_ID + " INTEGER PRIMARY KEY,"+
                    PRODUCT_SUBCATEGORY + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_FOLLOW_UP =
            "CREATE TABLE " + TABLE_FOLLOW_UP + " ("+
                    FOLLOW_UP_ID + " INTEGER PRIMARY KEY,"+
                    FOLLOW_UP + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_REMARKS =
            "CREATE TABLE " + TABLE_REMARKS +" ("+
                    REMARKS_ID + " INTEGER PRIMARY KEY,"+
                    REMARKS + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_PRODUCT_CATEGORY =
            "CREATE TABLE " + TABLE_PRODUCT_CATEGORY +" ("+
                    PRODUCT_CATEGORY_ID + " INTEGER PRIMARY KEY,"+
                    PRODUCT_CATEGORY + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_PRODUCT_DETAIL =
            "CREATE TABLE " + TABLE_PRODUCT_DETAIL +" ("+
                    PRODUCT_DETAIL_ID + " INTEGER PRIMARY KEY,"+
                    PRODUCT_DETAIL + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_SEGMENT =
            "CREATE TABLE " + TABLE_SEGMENT +" ("+
                    SEGMENT_ID + " INTEGER PRIMARY KEY,"+
                    SEGMENT + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_BIRTH_DISTRICT =
            "CREATE TABLE " + TABLE_BIRTH_DISTRICT +" ("+
                    BIRTH_DISTRICT_ID + " INTEGER PRIMARY KEY,"+
                    BIRTH_DISTRICT + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_BIRTH_COUNTRY =
            "CREATE TABLE " + TABLE_BIRTH_COUNTRY +" ("+
                    BIRTH_COUNTRY_ID + " INTEGER PRIMARY KEY,"+
                    BIRTH_COUNTRY + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_RELATIONSHIP_WITH_APPLICANT =
            "CREATE TABLE " + TABLE_RELATIONSHIP_WITH_APPLICANT + " ("+
                    RELATIONSHIP_WITH_APPLICANT_ID + " INTEGER PRIMARY KEY,"+
                    RELATIONSHIP_WITH_APPLICANT + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_MONTHLY_SALARY =
            "CREATE TABLE " + TABLE_MONTHLY_SALARY +" ("+
                    MONTHLY_SALARY_ID + " INTEGER PRIMARY KEY,"+
                    MONTHLY_SALARY + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_MONTHLY_RENTAL_INCOME =
            "CREATE TABLE " + TABLE_MONTHLY_RENTAL_INCOME +" ("+
                    MONTHLY_RENTAL_INCOME_ID + " INTEGER PRIMARY KEY,"+
                    MONTHLY_RENTAL_INCOME + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_BRAND_NAME =
            "CREATE TABLE " + TABLE_BRAND_NAME +" ("+
                    BRAND_NAME_ID + " INTEGER PRIMARY KEY,"+
                    BRAND_NAME + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_MANUFACTURING_YEAR =
            "CREATE TABLE " + TABLE_MANUFACTURING_YEAR +" ("+
                    MANUFACTURING_YEAR_ID + " INTEGER PRIMARY KEY,"+
                    MANUFACTURING_YEAR + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_MANUFACTURING_COUNTRY =
            "CREATE TABLE " + TABLE_MANUFACTURING_COUNTRY +" ("+
                    MANUFACTURING_COUNTRY_ID + " INTEGER PRIMARY KEY,"+
                    MANUFACTURING_COUNTRY + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_VEHICLE_TYPE =
            "CREATE TABLE " + TABLE_VEHICLE_TYPE +" ("+
                    VEHICLE_TYPE_ID + " INTEGER PRIMARY KEY,"+
                    VEHICLE_TYPE + TEXT_TYPE+ ")";


    public static final String SQL_SPINNER_HOME_LOAN =
            "CREATE TABLE " + TABLE_HOME_LOAN +" ("+
                    HOME_LOAN_ID + " INTEGER PRIMARY KEY,"+
                    HOME_LOAN + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_CAR_LAON =
            "CREATE TABLE " + TABLE_CAR_LOAN +" ("+
                    CAR_LOAN_ID + " INTEGER PRIMARY KEY,"+
                    CAR_LOAN + TEXT_TYPE+ ")";

    public static final String SQL_SPINNER_PERSONAL_LOAN =
            "CREATE TABLE " + TABLE_PERSONAL_LAON +" ("+
                    PERSONAL_LOAN_ID + " INTEGER PRIMARY KEY,"+
                    PERSONAL_LOAN + TEXT_TYPE+ ")";
    //SPINNER TABLES

    public static final String SQL_DELETE_LEAD_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_LEAD;

    public static final String SQL_DELETE_VISIT_PLAN_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_VISIT_PLAN;

    public static final String SQL_DELETE_CLIENT_TYPE =
            "DROP TABLE IF EXISTS " + TABLE_CLIENT_TYPE;

    public static final String SQL_DELETE_PURPOSE_OF_VISIT =
            "DROP TABLE IF EXISTS " + TABLE_PURPOSE_OF_VISIT;

    public static final String SQL_DELETE_CITY =
            "DROP TABLE IF EXISTS " + TABLE_CITY;

    public static final String SQL_DELETE_POLICE_STATION =
            "DROP TABLE IF EXISTS " + TABLE_POLICE_STATION;

    public static final String SQL_DELETE_DHAKA_NORTH_POLICE_STATION =
            "DROP TABLE IF EXISTS " + TABLE_DHAKA_NORTH_POLICE_STATION;

    public static final String SQL_DELETE_DHAKA_SOUTH_POLICE_STATION =
            "DROP TABLE IF EXISTS " + TABLE_DHAKA_SOUTH_POLICE_STATION;

    public static final String SQL_DELETE_NARAYANGANJ_POLICE_STATION =
            "DROP TABLE IF EXISTS " + TABLE_NARAYANGANJ_POLICE_STATION;

    public static final String SQL_DELETE_BRANCH =
            "DROP TABLE IF EXISTS " + TABLE_BRANCH;

    public static final String SQL_DELETE_PROFESSION =
            "DROP TABLE IF EXISTS " + TABLE_PROFESSION;

    public static final String SQL_DELETE_SOURCE_OF_REFERENCE =
            "DROP TABLE IF EXISTS " + TABLE_SOURCE_OF_REFERENCE;

    public static final String SQL_DELETE_PRODUCT_TYPE =
            "DROP TABLE IF EXISTS " + TABLE_PRODUCT_TYPE;

    public static final String SQL_DELETE_PRODUCT_SUBCATEGORY =
            "DROP TABLE IF EXISTS " + TABLE_PRODUCT_SUBCATEGORY;

    public static final String SQL_DELETE_FOLLOW_UP =
            "DROP TABLE IF EXISTS " + TABLE_FOLLOW_UP;

    public static final String SQL_DELETE_REMARKS =
            "DROP TABLE IF EXISTS " + TABLE_REMARKS;

    public static final String SQL_DELETE_PRODUCT_CATEGORY =
            "DROP TABLE IF EXISTS " + TABLE_PRODUCT_CATEGORY;

    public static final String SQL_DELETE_PRODUCT_DETAIL =
            "DROP TABLE IF EXISTS " + TABLE_PRODUCT_DETAIL;

    public static final String SQL_DELETE_SEGMENT =
            "DROP TABLE IF EXISTS " + TABLE_SEGMENT;

    public static final String SQL_DELETE_BIRTH_DISTRICT =
            "DROP TABLE IF EXISTS " + TABLE_BIRTH_DISTRICT;

    public static final String SQL_DELETE_BIRTH_COUNTRY =
            "DROP TABLE IF EXISTS " + TABLE_BIRTH_COUNTRY;

    public static final String SQL_DELETE_RELATIONSHIP_WITH_APPLICANT =
            "DROP TABLE IF EXISTS " + TABLE_RELATIONSHIP_WITH_APPLICANT;

    public static final String SQL_DELETE_MONTHLY_SALARY =
            "DROP TABLE IF EXISTS " + TABLE_MONTHLY_SALARY;

    public static final String SQL_DELETE_MONTHLY_RENTAL_INCOME =
            "DROP TABLE IF EXISTS " + TABLE_MONTHLY_RENTAL_INCOME;

    public static final String SQL_DELETE_BRAND_NAME =
            "DROP TABLE IF EXISTS " + TABLE_BRAND_NAME;

    public static final String SQL_DELETE_MANUFACTURING_YEAR =
            "DROP TABLE IF EXISTS " + TABLE_MANUFACTURING_YEAR;

    public static final String SQL_DELETE_MANUFACTURING_COUNTRY =
            "DROP TABLE IF EXISTS " + TABLE_MANUFACTURING_COUNTRY;

    public static final String SQL_DELETE_VEHICLE_TYPE =
            "DROP TABLE IF EXISTS " + TABLE_VEHICLE_TYPE;

    public static final String SQL_DELETE_HOME_LAON =
            "DROP TABLE IF EXISTS " + TABLE_HOME_LOAN;

    public static final String SQL_DELETE_CAR_LOAN =
            "DROP TABLE IF EXISTS " + TABLE_CAR_LOAN;

    public static final String SQL_DELETE_PERSONAL_LAON =
            "DROP TABLE IF EXISTS " + TABLE_PERSONAL_LAON;


    public static final String SQL_DELETE_ATTACHMENT_LAON =
            "DROP TABLE IF EXISTS " + TABLE_ATACHMENT;



}
