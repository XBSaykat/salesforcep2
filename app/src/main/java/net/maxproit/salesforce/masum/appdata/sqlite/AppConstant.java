package net.maxproit.salesforce.masum.appdata.sqlite;

public class AppConstant {


//    public static  String _L_ID ;
//    public static  String LEAD_BRANCH_NAME;
//    public static  String LEAD_USER_NAME;
//    public static  String LEAD_PROFESSION ;
//    public static  String LEAD_ORGANIZATION ;
//    public static  String LEAD_DESIGNATION ;
//    public static  String LEAD_PHONE;
//    public static  String LEAD_ADDRESS;
//    public static  String LEAD_REF ;
//    public static  String LEAD_PRODUCT_TYPE ;
//    public static  String LEAD_PRODUCT_SUBCATEGORY;
//    public static  String LEAD_AMOUNT ;
//    public static  String LEAD_OR_INTEREST ;
//    public static  String LEAD_OP_FEE ;
//    public static  String LEAD_VISIT_DATE;
//    public static  String LEAD_FOLLOW_UP ;
//    public static  String LEAD_REMARK ;

    public static final String  LEAD_STATUS_NEW="new_lead";
    public static final String LEAD_STATUS_PROSPECT="new_prospect";
    public static final String LEAD_STATUS_REJECT ="rejected" ;

    public static final String INTENT_KEY ="key" ;
    public static final String CO_APPLICANT_INTENT_KEY ="co_applicant_intent_key" ;
    public static final String CO_APPLICANT_BUNDLE_KEY ="co_applicant_bundle_key" ;
    public static final int CO_APPLICANT_REQUEST_CODE = 200 ;
    public static final String LEAD_INTENT_KEY ="lead_key" ;




    public static final String LEAD_STATUS_REJECT_FROM_PROSPECT = "rejected_prospect";
    public static final String LEAD_STATUS_PROSPECT_CO_APPLICANT = "co_applicant_prospect";
    public static final String LEAD_STATUS_PROCEED = "process";
    public static final String LEAD_STATUS_New_PLAN = "new plan";

    public static final String STATUS_INTENT_KEY ="status_key" ;
    public static final String CO_APPLICANT_STATUS_INTENT_KEY ="co_applicant_status_key" ;
    public static final String VISITED = "visited";
    public static final int REQUEST_IMAGE_CAPTURE =0 ;
    public static final int REQUEST_ID_CARD_CAPTURE =1 ;
    public static final int REQUEST_VCARD_CAPTURE = 2;
    public static final String STATUS_ACTIVITY ="activity" ;
}
