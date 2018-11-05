package net.maxproit.salesforce.masum.appdata.sqlite;

public class SpinnerDbConstant {
    // commons
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String BLOB_TYPE = " blob";
    private static final String COMMA_SEP = ",";
    public static final String COLUMN_NAME_NULLABLE = null;


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
}
