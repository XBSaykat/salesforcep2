package net.maxproit.salesforce.masum.appdata;

import android.widget.ArrayAdapter;

import net.maxproit.salesforce.masum.model.local.CoApplicant;

import java.util.ArrayList;

public class AppConstant {

    public static final String NID = "NID";
    public static final String BIRTH_CERTIFICATE = "Birth Certificate with attested picture";
    public static final String PASSPOSRT = "Passport";
    public static final String DRIVING_LICENSE = "Driving License";


    public static final String LEAD_STATUS_NEW = "new lead";
    public static final String STATUS_NEW_PROSPECT = "new prospect";
    public static final String LEAD_STATUS_REJECT = "rejected";

    public static final String INTENT_KEY = "key";
    public static final String PROSPECT_RBM_LIST_DATA_INTENT_KEY = "prospect_rbm_key";
    public static final String CO_APPLICANT_INTENT_KEY = "co_applicant_intent_key";
    public static final String CO_APPLICANT_BUNDLE_KEY = "co_applicant_bundle_key";
    public static final int CO_APPLICANT_REQUEST_CODE = 200;
    public static final String LEAD_INTENT_KEY = "lead_key";


    public static final String LEAD_STATUS_REJECT_FROM_PROSPECT = "rejected_prospect";
    public static final String LEAD_STATUS_PROSPECT_CO_APPLICANT = "co_applicant_prospect";
    public static final String LEAD_STATUS_PROCEED = "process";
    public static final String LEAD_STATUS_New_PLAN = "new plan";
    public static final String STATUS_RBM = "proceed to rbm";

    public static final String STATUS_INTENT_KEY = "status_key";
    public static final String LEAD_ID_FOR_CO_INTENT_KEY = "lead_id_for_co_applicant";
    public static final String CO_APPLICANT_STATUS_INTENT_KEY = "co_applicant_status_key";
    public static final String VISITED = "visited";
    public static final int REQUEST_IMAGE_CAPTURE = 0;
    public static final int REQUEST_ID_CARD_CAPTURE = 1;
    public static final int REQUEST_VCARD_CAPTURE = 2;
    public static final int REQUEST_VCARD_CHOOSE = 3;
    public static final int REQUEST_ID_CARD_CHOOSE = 4;
    public static final int REQUEST_IMAGE_CHOOSE = 5;

    //activity status

    public static final String STATUS_ACTIVITY = "activity";
    public static final String STATUS_ACTIVITY_NEW = "New";
    public static final String STATUS_PREVIOUS_ACTIVITY = "Previous Activity";
    public static final String STATUS_FUTURE_ACTIVITY = "Furture Activity";
    public static final String STATUS_CURRENT_ACTIVITY = "Current Activity";


    // my prospect filteration by status
    public static final String PROSPPECT_STATUS_FILTER_RETURN = "Return";
    public static final String PROSPPECT_STATUS_FILTER_PROCESS = "Process";


    public static final String PRE_DISBURSEMENT = "Pre- Disbursement";
    public static final String POST_DISBURSEMENT = "Post- Disbursement";
    public static final String INDIVIDUAL = "Individual";
    public static final String LEAD_GENERATION = "Lead Generation";
    public static final String FRESH = "Fresh";

    public static final String DHAKA_NORTH = "Dhaka North";
    public static final String DHAKA_SOUTH = "Dhaka South";
    public static final String NARAYANGONJ = "Narayanganj";
    public static final String SELECT_IMAGE_TITLE = "title";

    // number pattern for amounts
    public static final String numberPattern = "#,###,###,###";


    //product type
    public static final String HOME_LOAN = "Home Loan";
    public static final String CAR_LOAN = "Car Loan";
    public static final String PERSONAL_LOAN = "Personal Loan";
    public static final String REJECTED ="complete" ;
    public static final String FOLLOW = "follow";
    public static final String STATUS_RETURN_RBM ="return" ;
    public static final String PERMANENT_ADDRESSS_KEY = "permanent";
    public static final String PRESENT_ADDRESSS_KEY = "present";
    public static final String IS_NETWORK_AVAILABLE = "isNetworkAvailable";
    public static final String SYNC_STATUS_OK ="ok" ;
    public static final String SYNC_STATUS_WAIT ="wait" ;
    public static final String PERMANENT_ADDRESSS_PS_KEY ="per_ps" ;
    public static final String PERMANENT_ADDRESSS_CITY_KEY ="per_city" ;
    public static final String PRESENT_ADDRESSS_PS_KEY ="pre_ps" ;
    public static final String PRESENT_ADDRESSS_CITY_KEY ="ps_city" ;
    public static final String STATUS_ACTIVITY_FOLLOWED ="" ;
    public static final String INTENT_DATA1 = "data1";
    public static final String INTENT_DATA2= "data2";
    public static final String STATUS_ACTIVITY_EMPTY ="" ;
    public static final int SERCH_REQ_CODE = 500;

    public static final int APPROVED = 101;
    public static final String PDF_URL_INTENT_KEY = "pdfurl";

    public static ArrayList<CoApplicant> coAppLicantStaticList=new ArrayList<>();

    // Approval

    public static final String APPROVAL_LEAD ="Lead" ;
    public static final String APPROVAL_PROSPECT ="Prospect" ;
    public static final int APPROVAL_SET_ID_0 = 0 ;
    public static final int APPROVAL_CURRWENT_LEVEL_1 = 1;
    public static final String APPROVAL_STATUS_YES = "Y";
    public static final String APPROVAL_PROSPECT_STATUS_YES = "N";


    public static final String STATUS_ACTIVITY_PROCESS ="Process" ;
    public static final int ACTIVITY_RESULLT_100 = 100 ;
    public static final int ACTIVITY_RESULLT_200 = 200 ;
    public static final int ACTIVITY_RESULLT_300 = 300 ;
    public static final int ACTIVITY_RESULLT_400 = 400 ;


    public static String fromDate=null;
    public static String toDate=null;

}
