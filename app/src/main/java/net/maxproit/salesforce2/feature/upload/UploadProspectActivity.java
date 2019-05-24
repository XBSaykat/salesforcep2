package net.maxproit.salesforce2.feature.upload;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.stfalcon.frescoimageviewer.ImageViewer;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityUploadProspectBinding;

import net.maxproit.salesforce2.masum.appdata.AppConstant;
import net.maxproit.salesforce2.masum.model.api.file.Document;
import net.maxproit.salesforce2.model.uploads.file.FileUploadResponce;
import net.maxproit.salesforce2.util.PdfUtil;

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
    List<Uri> imgList = new ArrayList<>();
    List<String> mPaths;
    String pdfNUmber;
    String uploadFile = "";
    String fileType = "pdf";
    String fileId;
    String prospectId;
    private Uri mCropImageUri;

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
        if (extraDetail != null) {
            Document document = (Document) extraDetail.getSerializable(AppConstant.INTENT_KEY);
            prospectId = document.getLeadReferenceNo();
            fileId = document.getDocCheckListItemID();
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
                uploadFile = pdfUtil.createPdf();


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
        showProgressDialog("File Uploading");


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
/*        new ImagePicker.Builder(getActivity())
                .mode(ImagePicker.Mode.CAMERA)
                .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
                .directory(ImagePicker.Directory.DEFAULT)
                .extension(ImagePicker.Extension.PNG)
                .scale(600, 600)
                .allowMultipleImages(true)
                .enableDebuggingMode(true)
                .build();*/

        CropImage.startPickImageActivity(this);
    }




    @Override
    @SuppressLint("NewApi")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // handle result of pick image chooser
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri imageUri = CropImage.getPickImageResultUri(this, data);
            // For API >= 23 we need to check specifically that we have permissions to read external storage.
            if (CropImage.isReadExternalStoragePermissionsRequired(this, imageUri)) {
                // request permissions and handle the result in onRequestPermissionsResult()
                mCropImageUri = imageUri;
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
            } else {
                // no permissions required or already grunted, can start crop image activity
                startCropImageActivity(imageUri);
            }
        }

        // handle result of CropImageActivity
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {

                imgList.add(result.getUri());

            if (imgList.size() > 0) {
                binding.ivCamera1.setImageURI(imgList.get(0));
                binding.tvImgSize.setText("" + imgList.size());
                binding.btnPdf.setVisibility(View.VISIBLE);


            }
                binding.ivCamera1.setImageURI(result.getUri());
                Toast.makeText(this, "Cropping successful, Sample: " + result.getSampleSize(), Toast.LENGTH_LONG).show();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Toast.makeText(this, "Cropping failed: " + result.getError(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (mCropImageUri != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // required permissions granted, start crop image activity
            startCropImageActivity(mCropImageUri);
        } else {
            Toast.makeText(this, "Cancelling, required permissions are not granted", Toast.LENGTH_LONG).show();
        }
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

/*
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
                Log.d("TAG", ">>> Custom Size =: " + ImageCompress.getReadableFileSize(f.length()));


                imgList.add(lp);


            }
            if (imgList.size() > 0) {
                binding.ivCamera1.setImageURI(Uri.parse(imgList.get(0)));
                binding.tvImgSize.setText("" + imgList.size());
                binding.btnPdf.setVisibility(View.VISIBLE);


            }


        }

    }*/

    private void startCropImageActivity(Uri imageUri) {
        CropImage.activity(imageUri)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setMultiTouchEnabled(true)
                .start(this);
    }


    @Override
    public void getpdf(String path) {
        uploadFile = path;


    }
}

