package net.maxproit.salesforce.feature.upload;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.stfalcon.frescoimageviewer.ImageViewer;

import net.alhazmy13.mediapicker.Image.ImagePicker;
import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;
import net.maxproit.salesforce.databinding.ActivityUploadProspectBinding;

import net.maxproit.salesforce.masum.appdata.AppConstant;
import net.maxproit.salesforce.masum.model.api.file.Document;
import net.maxproit.salesforce.model.uploads.file.FileUploadResponce;
import net.maxproit.salesforce.util.PdfUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UploadProspectActivity extends BaseActivity implements Documentinfo {
    private static final String TAG = "UploadActivity";
    ActivityUploadProspectBinding binding;
    List<String> imgList = new ArrayList<>();
    List<String> mPaths;
    String pdfNUmber;
    String uploadFile = "";
    String fileType="pdf";
    String fileId;
    String prospectId;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_upload_prospect;

    }

    @Override
    protected void initComponents() {
        binding = (ActivityUploadProspectBinding) getBinding();
        setSupportActionBar(binding.toolbar);
        getIntentData();


        pdfNUmber = getIntent().getStringExtra("pdf");
        Bundle extraDetail = getIntent().getExtras();
        if (extraDetail !=null){
            Document document= (Document) extraDetail.getSerializable(AppConstant.INTENT_KEY);
            prospectId=document.getLeadReferenceNo();
            fileId=document.getDocCheckListItemID();
        }




        //Create/Open folder
        File folder = getOrCreatePdfDirectory();

        // Because of using Emulator
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        binding.ibCamera1.setOnClickListener(v -> getMultipleImage());


        binding.ivCamera1.setOnClickListener(v -> {
            if (imgList.size() > 0) {
                new ImageViewer.Builder(getActivity(), imgList)
                        .show();

            }

        });

        binding.btnPdf.setOnClickListener(v -> {
            if (imgList != null) {
                PdfUtil pdfUtil = new PdfUtil(imgList, getContext());
              uploadFile= pdfUtil.createPdf();


            }


        });

        binding.upload.setOnClickListener(v -> {
            if (!uploadFile.isEmpty()) {

                fileUpload();

            } else {
                showToast("Pdf not create");
            }
        });

    }

    private void fileUpload() {
        String fileName = fileType + "_" + prospectId + "_" + fileId + ".pdf";
        //File f= new File("/storage/emulated/0/PDFfilesIDLC_2018:07:06_15:15:27.pdf");
        File pdffile = new File(uploadFile);
        showProgressDialog("File Unloaded");


        getApiService().fileUpload(getFile(pdffile, "file", fileName)).enqueue(new Callback<FileUploadResponce>() {
            @Override
            public void onResponse(Call<FileUploadResponce> call, Response<FileUploadResponce> response) {
                hideProgressDialog();

                if (response.isSuccessful()) {

                    showToast("File upload successfully");
                    Log.d(TAG, "Pdf Upload Responce: " + toJson(response.body()));
                    finish();
                } else {
                    showToast("Try Again! ");
                }

            }

            @Override
            public void onFailure(Call<FileUploadResponce> call, Throwable t) {
                showToast("File upload failed");
                hideProgressDialog();


            }
        });

    }

    @NonNull
    private MultipartBody.Part getFile(File file, String fild, String fileName) {

        if (file != null) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
            return MultipartBody.Part.createFormData(fild, fileName, requestBody);
        }
        return null;

    }

    private void getMultipleImage() {
        new ImagePicker.Builder(getActivity())
                .mode(ImagePicker.Mode.CAMERA)
                .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
                .directory(ImagePicker.Directory.DEFAULT)
                .extension(ImagePicker.Extension.PNG)
                .scale(600, 600)
                .allowMultipleImages(true)
                .enableDebuggingMode(true)
                .build();
    }

    @Override
    protected void getIntentData() {


    }

    private File getOrCreatePdfDirectory() {
        File folder = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + getString(R.string.pdf_dir));
        if (!folder.exists()) {
            folder.mkdir();
        }
        return folder;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ImagePicker.IMAGE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {

            mPaths = (List<String>) data.getSerializableExtra(ImagePicker.EXTRA_IMAGE_PATH);
            //Your Code
            for (String lp : mPaths) {
                //  imgList.add("file://"+lp);


                // File Compress Type 1 Bsic
                // compressedImageFile = ImageCompress.compress(this,new File(lp));


                // File Compress Type 2 Castom
                File f = ImageCompress.customCompressImage(this, new File(lp));

                Log.d("TAG", ">>> Real Size =: " + ImageCompress.getReadableFileSize(new File(lp).length()));
                Log.d("TAG", ">>: " + f.getPath());
                Log.d("TAG", ">>> Castom Size =: " + ImageCompress.getReadableFileSize(f.length()));

                //  imgList.add("file://"+f.getPath());
                imgList.add(lp);


            }
            if (imgList.size() > 0) {
                binding.ivCamera1.setImageURI(Uri.parse(imgList.get(0)));
                binding.tvImgSize.setText("" + imgList.size());
                binding.btnPdf.setVisibility(View.VISIBLE);


            }


        }

    }


    @Override
    public void getpdf(String path) {
        uploadFile = path;


    }
}

