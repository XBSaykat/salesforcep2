package net.maxproit.salesforce.network;

/**
 * Created by Rezwan Khan Chowdhury on 4/12/18.
 */


import net.maxproit.salesforce.masum.model.api.MyGetLeadApi;
import net.maxproit.salesforce.masum.model.api.MyLeadByRefApi;
import net.maxproit.salesforce.masum.model.api.MyLeadDataModelApi;
import net.maxproit.salesforce.masum.model.api.MyOldLeadApi;
import net.maxproit.salesforce.model.cib.notRequestedCIB.NotRequestedCIBData;
import net.maxproit.salesforce.model.cib.post.CibPost;
import net.maxproit.salesforce.model.cib.postResponce.CibPostResponce;
import net.maxproit.salesforce.model.cib.requestedCIB.RequestedCIBData;
import net.maxproit.salesforce.model.cif.notRequestedCIF.NotRequestedCifData;
import net.maxproit.salesforce.model.cif.post.CifPost;
import net.maxproit.salesforce.model.cif.postResponce.CifPostResponce;
import net.maxproit.salesforce.model.cif.requestedCIf.RequestedCIfData;
import net.maxproit.salesforce.model.deviation.DeviationEntities;
import net.maxproit.salesforce.model.deviation.getlist.Daviationlist;
import net.maxproit.salesforce.model.deviation.head.DevAccountHeadEntities;
import net.maxproit.salesforce.model.deviation.post.DeviationPost;
import net.maxproit.salesforce.model.deviation.postresponce.DaviationPostResponce;
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
import net.maxproit.salesforce.model.newlead.NewLead;
import net.maxproit.salesforce.model.newprospect.NewProspect;
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
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Contains all API call declarations
 */
public interface ApiService {


    @POST("Authenticate")
    Call<LoginResponse> login(@Body Login login);


    @GET("GlobalSettings/AppData/1")
    Call<GlobalSettings> getSetting();


    @POST("CdLead/Lead")
    Call<MyOldLeadApi> createMyLead(@Body MyLeadDataModelApi newLead);

    @GET("CdLead/MyLead/{userName}/{timestamp}")
    Call<MyGetLeadApi> getLeadData(@Path("userName") String user, @Path("timestamp") String random);

    @GET("CdLead/Lead/{LeadReferenceNo}/{timestamp}")
    Call<MyLeadByRefApi> getLeadDataByRef(@Path("LeadReferenceNo") String ref, @Path("timestamp") String random);

    /*
     Lead Api
    */

    // Lead Step 1. Create new Lead
    @POST("lead")
    Call<OldLead> createNewLead(@Body NewLead newLead);

    // Lead Step 2. My lead
    @GET("MyLead/{user}/{random}")
    Call<Mylead> getMyLead(@Path("user") String user, @Path("random") String random);

    // Lead Step 3. Lead Approval
    @POST("proceedLead")
    Call<ApprovalResponce> myleadApproval(@Body MyLeadApproval myLeadApproval);

    // Lead Step 4. Get Lead By id
    @GET("Lead/{id}/{random}")
    Call<OldLead> getLeadById(@Path("id") String id, @Path("random") String random);


    @POST("approval")
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
    @GET("MyProspect/{user}/{random}")
    Call<MyProspect> getMyProspect(@Path("user") String user, @Path("random") String random);

    @POST("Prospect")
    Call<OleProspect> myProspect(@Body NewProspect newProspect);


    @GET("Prospect/{id}/{random}")
    Call<OleProspect> getProspect(@Path("id") String id, @Path("random") String random);

    @POST("proceed")
    Call<ApprovalResponce> myProspectApproval(@Body MyLeadApproval myLeadApproval);

    @GET("SalesOfficer/DashboardInformation/{user}/{random}")
    Call<MyPerfomance> getMyPerfomance(@Path("user") String user,@Path("random") String random);


    @GET("SalesOfficer/Disbursements/{user}/{random}")
    Call<Disbursement> getDisbursements(@Path("user") String user,@Path("random") String random);

    @GET("SalesOfficer/Leads/{user}/{random}")
    Call<Mylead> getSalesOfficerLead(@Path("user") String user,@Path("random") String random);



    @GET("SalesOfficer/Disbursements/{user}/{random}")
    Call<DisbursementList> getSalesOfficerDes(@Path("user") String user, @Path("random") String random);


    @GET("SalesOffice/Calls/{user}")
    Call<Calls> getSalesOfficerCall(@Path("user") String user);

    @GET("SalesOfficer/Followup/{user}/{random}")
    Call<FollowupList> getSalesOfficerFolloUp(@Path("user") String user, @Path("random") String random);

    @GET("SalesOfficer/Prospects/{user}/{random}")
    Call<MyProspect> getSalesOfficerProspect(@Path("user") String user,@Path("random") String random);

    @GET("SalesOffice/SalesOfficers/{user}")
    Call<SalesOfficers> getSalesOfficerSalesOfficer(@Path("user") String user);

    @GET("SalesOfficer/Sanctions/{user}/{random}")
    Call<Sanctions> getSalesOfficerSanctions(@Path("user") String user,@Path("random") String random);

    @GET("SalesOffice/Visits/{user}/{random}")
    Call<Visits> getSalesOfficerVisit(@Path("user") String user,@Path("random") String random);

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


    @GET("Deviation/{id}/{random}")
    Call<Daviationlist> daviationRequestById(@Path("id") String id, @Path("random") String random);


    // Deviation Request
    @GET("Deviation/{id}")
    Call<DeviationEntities> deviationRequestById(@Path("id") String id);


    @GET("DeviationAccHeads/{id}")
    Call<DevAccountHeadEntities> deviationHeadById(@Path("id") String id);


    @POST("Deviation/DeviationRequest")
    Call<DaviationPostResponce> deviationPost(@Body DeviationPost deviationPost);





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


    @Multipart
    @POST("uploadfile")
    Call<FileUploadResponce> fileUpload(@Part MultipartBody.Part file1);


    @GET("LeadDocumentlist/{user}")
    Call<String> getfileByid(@Path("user") String user);


}
