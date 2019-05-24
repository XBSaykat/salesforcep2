package net.maxproit.salesforce2.feature.upload;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.MenuItem;

import com.stfalcon.frescoimageviewer.ImageViewer;

import net.alhazmy13.mediapicker.Image.ImagePicker;
import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.databinding.ActivityUploadBinding;
import net.maxproit.salesforce2.util.PdfUtil;
import net.maxproit.salesforce2.util.SharedPreferencesEnum;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UploadActivity extends BaseActivity implements Documentinfo {
    private static final String TAG = "UploadActivity";
    ActivityUploadBinding binding;
    List<Uri> imgList = new ArrayList<>();
    List<String> mPaths;
    String pdfNUmber;


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_upload;

    }

    @Override
    protected void initComponents() {
        binding = (ActivityUploadBinding) getBinding();
        setSupportActionBar(binding.toolbar);


        pdfNUmber = getIntent().getStringExtra("pdf");


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
                pdfUtil.createPdf();


            }


        });

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
               // imgList.add(lp);


            }
         /*   if (imgList.size() > 0) {
                binding.ivCamera1.setImageURI(Uri.parse(imgList.get(0)));
                binding.tvImgSize.setText("" + imgList.size());
                binding.btnPdf.setVisibility(View.VISIBLE);


            }*/


        }

    }


    @Override
    public void getpdf(String path) {


      /*  localCash().put(SharedPreferencesEnum.Key.LEADPDF1, path);
        finish();*/


        Log.d(TAG, "getpdf: "+ path);
        if (!path.isEmpty()) {
            if (pdfNUmber!=null) {
                if (pdfNUmber.equals("pdf1")) {
                    localCash().put(SharedPreferencesEnum.Key.LEADPDF1 ,path);
                    Log.d(TAG, "getpdf: "+ path);

                    Intent intent = new Intent();
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }else if (pdfNUmber.equals("pdf2")){
                    localCash().put(SharedPreferencesEnum.Key.LEADPDF2 ,path);
                    Intent intent = new Intent();
                    setResult(Activity.RESULT_OK, intent);
                    finish();

                }
            }


        }else finish();
    }
}
