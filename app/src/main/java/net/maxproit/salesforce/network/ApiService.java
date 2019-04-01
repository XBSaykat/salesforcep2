package net.maxproit.salesforce.network;


import net.maxproit.salesforce.masum.model.api.GetExistingCoApplicant;
import net.maxproit.salesforce.masum.model.api.GetLeadIndex;
import net.maxproit.salesforce.masum.model.api.cibcif.CibCifResponse;
import net.maxproit.salesforce.masum.model.api.coapplicant.DeleteCoApplicantresponse;
import net.maxproit.salesforce.masum.model.api.dashboarddetail.GetdashboardDetailData;
import net.maxproit.salesforce.masum.model.api.deviation.deviationlist.DeviationResponse;
import net.maxproit.salesforce.masum.model.api.deviation.deviationresponse.DeviationPostRespose;
import net.maxproit.salesforce.masum.model.api.deviation.postdeviation.PostDeviation;
import net.maxproit.salesforce.masum.model.api.deviation.queryapprovaltierfordeviation.QueryApprovalTier;
import net.maxproit.salesforce.masum.model.api.deviation.querydeviationpropertyresponce.QueryDeviationPropertyResponce;
import net.maxproit.salesforce.masum.model.api.file.GetDocument;
import net.maxproit.salesforce.masum.model.api.followup.FollowUpHistoryApi;
import net.maxproit.salesforce.masum.model.api.gpstracker.GetGpsResponse;
import net.maxproit.salesforce.masum.model.api.lead.MyGetLeadApi;
import net.maxproit.salesforce.masum.model.api.lead.MyLeadByRefApi;
import net.maxproit.salesforce.masum.model.api.lead.MyLeadDataModelApi;
import net.maxproit.salesforce.masum.model.api.lead.MyOldLeadApi;
import net.maxproit.salesforce.masum.model.api.myactivity.CompleteActivity;
import net.maxproit.salesforce.masum.model.api.myactivity.Data;
import net.maxproit.salesforce.masum.model.api.myactivity.MyActivityApi;
import net.maxproit.salesforce.masum.model.api.myactivity.MyActivityGetByJournalIdApi;
import net.maxproit.salesforce.masum.model.api.myactivity.MyActivityGetDataApi;
import net.maxproit.salesforce.masum.model.api.performance.Getperformance;
import net.maxproit.salesforce.masum.model.api.rbm.GetRbmData;
import net.maxproit.salesforce.masum.model.api.useractivity.GenerateOtp;
import net.maxproit.salesforce.masum.model.api.useractivity.UserRegistration;
import net.maxproit.salesforce.masum.model.api.visitPlan.MyVisitPlanApi;
import net.maxproit.salesforce.masum.model.api.visitPlan.MyVisitPlanGetApi;
import net.maxproit.salesforce.masum.model.prospectmodel.OldPostpectResponse;
import net.maxproit.salesforce.masum.model.api.approval.Approval;
import net.maxproit.salesforce.model.appversion.AppVersionResponse;
import net.maxproit.salesforce.model.cib.notRequestedCIB.NotRequestedCIBData;
import net.maxproit.salesforce.model.cib.post.CibPost;
import net.maxproit.salesforce.model.cib.postResponce.CibPostResponce;
import net.maxproit.salesforce.model.cib.requestedCIB.RequestedCIBData;
import net.maxproit.salesforce.model.cif.notRequestedCIF.NotRequestedCifData;
import net.maxproit.salesforce.model.cif.post.CifPost;
import net.maxproit.salesforce.model.cif.postResponce.CifPostResponce;
import net.maxproit.salesforce.model.cif.requestedCIf.RequestedCIfData;
import net.maxproit.salesforce.model.deviation.DeviationEntities;
import net.maxproit.salesforce.model.folowup.FollowupList;
import net.maxproit.salesforce.model.login.Login;
import net.maxproit.salesforce.model.login.LoginResponse;
import net.maxproit.salesforce.model.mylead.MyLeadApproval;
import net.maxproit.salesforce.model.mylead.Mylead;
import net.maxproit.salesforce.model.mylead.approvalresponce.ApprovalResponce;
import net.maxproit.salesforce.model.mylead.updateLead.OldLead;
import net.maxproit.salesforce.model.myprospect.MyProspect;
import net.maxproit.salesforce.model.myprospect.documentlist.ProspectDocList;
import net.maxproit.salesforce.model.myprospect.updateProspect.OleProspect;
import net.maxproit.salesforce.model.myprospect.updatemyprospect.OldProspect;
import net.maxproit.salesforce.model.newlead.NewLead;
import net.maxproit.salesforce.model.newprospect.NewProspect;
import net.maxproit.salesforce.model.newprospect.mynewprosppect.NewProspectUpdate;
import net.maxproit.salesforce.model.salesOfficer.disbursement.Disbursement;
import net.maxproit.salesforce.model.salesOfficer.myPerfomance.MyPerfomance;
import net.maxproit.salesforce.model.sd.DisbursementList;
import net.maxproit.salesforce.model.search.DisbursementSearch;
import net.maxproit.salesforce.model.search.Search;
import net.maxproit.salesforce.model.search.guarantor.SearchGuarantor;
import net.maxproit.salesforce.model.search.proprietor.SearchProprietor;
import net.maxproit.salesforce.model.search.searchlist.SearchList;
import net.maxproit.salesforce.model.search.searchlist.disbursementsearch.DisbursementItemData;
import net.maxproit.salesforce.model.search.searchlist.disbursementsearch.DisbursementSearchResponceList;
import net.maxproit.salesforce.model.setting.GlobalSettings;
import net.maxproit.salesforce.model.supervisor.calls.Calls;
import net.maxproit.salesforce.model.supervisor.dashboard.SupProspect;
import net.maxproit.salesforce.model.supervisor.prospects.Prospects;
import net.maxproit.salesforce.model.supervisor.salesofficers.SalesOfficers;
import net.maxproit.salesforce.model.supervisor.sanctions.Sanctions;
import net.maxproit.salesforce.model.supervisor.user.UseList;
import net.maxproit.salesforce.model.supervisor.visits.Visits;
import net.maxproit.salesforce.model.uploads.file.FileUploadResponce;
import net.maxproit.salesforce.model.virifier.virifierlist.Virifier;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Contains all API call declarations
 */
public interface ApiService {


    @POST("Authenticate")
    Call<LoginResponse> login(@Body Login login);

    @POST("register")
    Call<String>  userRegistration(@Body UserRegistration data);

    @POST("otpsend")
    Call<String> generateOtp(@Body UserRegistration otp);


    @GET("GlobalSettings/AppData/0")
    Call<GlobalSettings> getSetting();

    //activity
    @POST("Activity/Activity")
    Call<MyActivityApi> createActivity(@Body Data data);

    @GET("Activity/api/MyActivity/{userName}/{timestamp}")
    Call<MyActivityGetDataApi> getActivityData(@Path("userName") String userName, @Path("timestamp") String random);

    @GET("Activity/LookupActivity/{ActivityJournalID}/{timestamp}")
    Call<MyActivityGetByJournalIdApi> getActivityByJournalId(@Path("ActivityJournalID") String journalId, @Path("timestamp") String random);

    @POST("Activity/api/CompleteActivity/{ActivityJournalID}")
    Call<CompleteActivity> actionCompleteActivity(@Path("ActivityJournalID") int journalId);

    @POST("Activity/api/ProccedActivity/{ActivityJournalID}/{LeadReferenceNo}")
    Call<CompleteActivity> ActivityProceed(@Path("ActivityJournalID") int journalId, @Path("LeadReferenceNo") String refNo);

    //gollow up api
    @GET("Activity/api/HistoryOfActivity/{ActivityJournalID}/{timestamp}")
    Call<FollowUpHistoryApi> getFollowUpHistory(@Path("ActivityJournalID") int journalId, @Path("timestamp") String random);

    //visit plan
    @POST("VisitPlan/VisitPlan")
    Call<MyVisitPlanApi> createVisitPlan(@Body net.maxproit.salesforce.masum.model.api.visitPlan.Data data);

    @GET("VisitPlan/api/MyVisitPlans/{userName}/{timestamp}")
    Call<MyVisitPlanGetApi> getVisitPlan(@Path("userName") String userName, @Path("timestamp") String random);

    @GET("VisitPlan/LookupVisitPlan/{ActivityJournalID}/{timestamp}")
    Call<MyVisitPlanApi> getVisitPlanByJournalId(@Path("ActivityJournalID") int journalId, @Path("timestamp") String random);

    // lead api interface
    @POST("CdLead/Lead")
    Call<MyOldLeadApi> createMyLead(@Body MyLeadDataModelApi newLead);

    @GET("CdLead/MyLead/{userName}/{timestamp}")
    Call<MyGetLeadApi> getLeadData(@Path("userName") String user, @Path("timestamp") String random);

    @GET("CdLead/Lead/{LeadReferenceNo}/{timestamp}")
    Call<MyLeadByRefApi> getLeadDataByRef(@Path("LeadReferenceNo") String ref, @Path("timestamp") String random);


    @GET("CdLead/LeadPopulate/{LeadIndexID}/{timestamp}")
    Call<GetLeadIndex> getLeadDataByLeadIndex(@Path("LeadIndexID") int LeadIndexID, @Path("timestamp") String random);


    @GET("CdProspect/CoApplicant/customerId/{timestamp}")
    Call<GetExistingCoApplicant> getCoApplicantDataByIndex(@Path("timestamp") String random,@Query("customerId") int LeadIndexID);


    //rbm data
    @GET("CdProspect/ProspectsForAapproval/{userName}/{timestamp}")
    Call<GetRbmData> getRbmData(@Path("userName") String user, @Path("timestamp") String random);

    //rbm data
    @GET("CdProspect/ProspectApprovalData/{ProspectReferenceNo}/{timestamp}")
    Call<OldProspect> getRbmDataByRef(@Path("ProspectReferenceNo") String ref, @Path("timestamp") String random);

    //performace api

    @GET("DashBoard/{userName}/{fromDate}/{toDate}/{timestamp}")
    Call<Getperformance> getPerformanceCountData(@Path("userName") String userName, @Path("fromDate") String fromDate, @Path("toDate") String toDate, @Path("timestamp") String random);

    @GET("MyDashBoardDetail/{ItemType}/{SupItemType}/{userName}/{fromDate}/{toDate}/{timestamp}")
    Call<GetdashboardDetailData> getDashboardDetailDataList(@Path("ItemType") String itemType,@Path("SupItemType") String subItem,@Path("userName") String userName,@Path("fromDate") String fromDate,@Path("toDate") String toDate,@Path("timestamp") String random);


    //delete co aplicant
    @GET("CdProspect/DeleteCoApplicant/{leadReferenceNo}/customerId")
    Call<DeleteCoApplicantresponse> deleteCoApplicant(@Path("leadReferenceNo") String refNo, @Query("customerId") int customerId);


    @POST("CdApproval/proceedprospect")
    Call<ApprovalResponce> myprospectApproval(@Body Approval myLeadApproval);

    @POST("CdApproval/proceedLead")
    Call<ApprovalResponce> myleadApproval(@Body Approval myLeadApproval);

    // Lead Step 4. Get Lead By id
    @GET("Lead/{id}/{random}")
    Call<OldLead> getLeadById(@Path("id") String id, @Path("random") String random);


    @POST("CdApproval/approval")
    Call<ApprovalResponce> supervisorApproval(@Body MyLeadApproval myLeadApproval);


    //----------------------------------

    @GET("ProspectDataForDisbursement/{id}/{random}")
    Call<DisbursementItemData> getDisbursement(@Path("id") String id, @Path("random") String random);

    @POST("FindApprovedProspect")
    Call<DisbursementSearchResponceList> searchDisbursement(@Body DisbursementSearch search);



    /*
     Prospect Api
    */

    // Prospect Stem 1. My Prospect list
    @GET("CdProspect/MyProspect/{user}/{random}")
    Call<MyProspect> getMyProspect(@Path("user") String user, @Path("random") String random);

    @POST("Prospect")
    Call<OleProspect> myProspect(@Body NewProspect newProspect);

    @POST("CdProspect/Prospect")
    Call<OldPostpectResponse> myNewProspect(@Body NewProspectUpdate newProspectUpdate);

// @POST("CdProspect/Prospect")
//    Call<OldPostpectResponse> myNewProspectData(@Body net.maxproit.salesforce.masum.model.prospectmodel.Data newProspectUpdate);


    //gps location


    @POST("GeoLocation")
    Call<GetGpsResponse> sendltdlng(@Body net.maxproit.salesforce.masum.model.api.gpstracker.Data data);

    @GET("Prospect/{id}/{random}")
    Call<OleProspect> getProspect(@Path("id") String id, @Path("random") String random);

    @GET("CdProspect/Prospect/{id}/{random}")
    Call<OldProspect> getNewProspect(@Path("id") String id, @Path("random") String random);

    @POST("proceed")
    Call<ApprovalResponce> myProspectApproval(@Body MyLeadApproval myLeadApproval);

    @GET("SalesOfficer/DashboardInformation/{user}/{random}")
    Call<MyPerfomance> getMyPerfomance(@Path("user") String user, @Path("random") String random);


    @GET("SalesOfficer/Disbursements/{user}/{random}")
    Call<Disbursement> getDisbursements(@Path("user") String user, @Path("random") String random);

    @GET("SalesOfficer/Leads/{user}/{random}")
    Call<Mylead> getSalesOfficerLead(@Path("user") String user, @Path("random") String random);


    @GET("SalesOfficer/Disbursements/{user}/{random}")
    Call<DisbursementList> getSalesOfficerDes(@Path("user") String user, @Path("random") String random);


    @GET("SalesOffice/Calls/{user}")
    Call<Calls> getSalesOfficerCall(@Path("user") String user);

    @GET("SalesOfficer/Followup/{user}/{random}")
    Call<FollowupList> getSalesOfficerFolloUp(@Path("user") String user, @Path("random") String random);

    @GET("SalesOfficer/Prospects/{user}/{random}")
    Call<MyProspect> getSalesOfficerProspect(@Path("user") String user, @Path("random") String random);

    @GET("SalesOffice/SalesOfficers/{user}")
    Call<SalesOfficers> getSalesOfficerSalesOfficer(@Path("user") String user);

    @GET("SalesOfficer/Sanctions/{user}/{random}")
    Call<Sanctions> getSalesOfficerSanctions(@Path("user") String user, @Path("random") String random);

    @GET("SalesOffice/Visits/{user}/{random}")
    Call<Visits> getSalesOfficerVisit(@Path("user") String user, @Path("random") String random);

    @GET("Documentlist/{user}")
    Call<ProspectDocList> getDockList(@Path("user") String user);

    @GET("DocumentlistLead/{user}/{random}")
    Call<ProspectDocList> getLeadDockList(@Path("user") String user, @Path("random") String random);

    @GET("EMICalculation/{interest}/{month}/{amount}")
    Call<String> getInstalmentAmount(@Path("interest") String interest, @Path("month") String month, @Path("amount") String amount);


    /*
     Parallel Request
    */
    // CIF Request
    @GET("CIF/RequestedCIF/{id}/{random}")
    Call<RequestedCIfData> cifRequestById(@Path("id") String id, @Path("random") String random);

    @GET("CIF/NotRequestedCIF/{id}/{random}")
    Call<NotRequestedCifData> cifNewRequestById(@Path("id") String id, @Path("random") String random);

    @POST("CIF/CIFRequest")
    Call<CifPostResponce> cifPost(@Body CifPost cifPost);


    // CIB Request--------------------------------

    @GET("CIB/RequestedCIB/{id}/{random}")
    Call<RequestedCIBData> cibRequestById(@Path("id") String id, @Path("random") String random);


    @GET("CIB/NotRequestedCIB/{id}/{random}")
    Call<NotRequestedCIBData> cibNewRequestById(@Path("id") String id, @Path("random") String random);

    @POST("CIB/RequestCIB")
    Call<CibPostResponce> cibPost(@Body CibPost cibPost);
    // CIB Request--------------------------------


//    @GET("Deviation/{id}/{random}")
//    Call<Daviationlist> daviationRequestById(@Path("id") String id, @Path("random") String random);
//

    @GET("Deviation/{id}/{random}")
    Call<DeviationResponse> daviationRequestById(@Path("id") String id, @Path("random") String random);


    // Deviation Request
//
//@GET("Deviation/{referenceNo}/{timestamp}")
//Call<DeviationEntities> deviationRequestByReferenceNo(@Path("referenceNo") String referenceNo, @Path("random") String random );

    @GET("Deviation/{id}")
    Call<DeviationEntities> deviationRequestById(@Path("id") String id);


//    @GET("DeviationAccHeads/{id}")
//    Call<DevAccountHeadEntities> deviationHeadById(@Path("id") String id);

    @GET("Deviation/DeviationAccHeads/{deviationCatId}/{timestamp}")
    Call<net.maxproit.salesforce.masum.model.api.deviation.deviationaccounthead.DevAccountHeadEntities> deviationHeadById(@Path("deviationCatId") String deviationCatId,
                                                                                                                          @Path("timestamp") String timestamp);

    @POST("Deviation/DeviationRequest")
    Call<DeviationPostRespose> postDeviationData(@Body PostDeviation postDeviation);


    @GET("Deviation/QryApprovalTierForDeviation/{referenceNo}/{riskCategory}/{timestamp}")
    Call<QueryApprovalTier> queryforApprovalTier(@Path("referenceNo") String referenceNo,
                                                 @Path("riskCategory") String riskCategory,
                                                 @Path("timestamp") String timestamp);

    @GET("Deviation/QryDeviationProperty/{refNo}/{timestamp}")
    Call<QueryDeviationPropertyResponce> queryDeviationProperty(@Path("refNo") String refNo, @Path("timestamp") String timestamp);
// Deviation


    // CIF & CIB Request

    @POST("CdCIB/CIBRequest/{referenceNo}/{userName}")
    Call<CibCifResponse> cibRequest(@Path("referenceNo") String referenceNo, @Path("userName") String userName);

    @POST("CdCIF/CIFRequest/{referenceNo}/{userName}")
    Call<CibCifResponse> cifRequest(@Path("referenceNo") String referenceNo, @Path("userName") String userName);



    // CIF & CIB Request



    /*
     Search Api
    */

    // Cif Search
    @POST("CIF")
    Call<SearchList> searchUserInfo(@Body Search search);

    // Get Lead
    @GET("LeadPopulate/{id}/{random}")
    Call<OldLead> getLeadByLeadIndexId(@Path("id") String id, @Path("random") String random);

    @GET("Proprietor/{id}/{random}")
    Call<SearchProprietor> getProprietor(@Path("id") String id, @Path("random") String random);

    @GET("Guarantor/{id}/{random}")
    Call<SearchGuarantor> getGuarantor(@Path("id") String id, @Path("random") String random);




    /*
     Supervisor Api
    */


    // 1. Supervisor Lead
    @GET("SalesOfficer/DashboardInformation/{user}/{random}")
    Call<SupProspect> getSupervisorDashboard(@Path("user") String user, @Path("random") String random);

    @GET("Suppervisor/Leads/{user}/{random}")
    Call<UseList> getSupervisorLead(@Path("user") String user, @Path("random") String random);

    @GET("Suppervisor/Prospects/{user}/ff/{random}")
    Call<UseList> getSupervisorProspect(@Path("user") String user, @Path("random") String random);

    @GET("Suppervisor/Sanctions/{user}/{random}")
    Call<UseList> getSupervisorSanctions(@Path("user") String user, @Path("random") String random);


    @GET("Suppervisor/Disbursements/{user}/{random}")
    Call<UseList> getSupervisorDisbursements(@Path("user") String user, @Path("random") String random);


    @GET("Suppervisor/Followups/{user}/{random}")
    Call<UseList> getSupervisorFup(@Path("user") String user, @Path("random") String random);


    @GET("Suppervisor/Calls/{user}")
    Call<Calls> getSupervisorCall(@Path("user") String user);


    @GET("Prospect/ProspectsForAapproval/{user}/{random}")
    Call<Prospects> getSupervisorProspectForApp(@Path("user") String user, @Path("random") String random);

    @GET("Suppervisor/SalesOfficers/{user}")
    Call<SalesOfficers> getSupervisorSalesOfficer(@Path("user") String user);


    @GET("Suppervisor/Visits/{user}")
    Call<Visits> getSupervisorVisit(@Path("user") String user);


    //Virifier
    @GET("ListOfProspectVarification/{user}'")
    Call<Virifier> getvirifierList(@Path("user") String user);



    @GET("LeadDocumentlist/{user}")
    Call<String> getfileByid(@Path("user") String user);


    @Multipart
    @POST("uploadfile")
    Call<FileUploadResponce> fileUpload(@Part MultipartBody.Part file1);

    //Document
    @GET("Documentlist/{ReferenceNo}/{timestamp}")
    Call<GetDocument> getDocumentList(@Path("ReferenceNo") String refNo, @Path("timestamp") String random);


    // RBM Approval

    @POST("CdApproval/approval")
    Call<ApprovalResponce> approve(@Body Approval approval);

//App version Check
    @GET("GlobalSettings/api/AppVersionDetail/{timestamp}")
    Call<AppVersionResponse> getAppUpdate(@Path("timestamp") String timestamp);
}


