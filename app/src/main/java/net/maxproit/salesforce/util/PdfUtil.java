package net.maxproit.salesforce.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.feature.upload.Documentinfo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Rezwan Khan chowdhury on 6/5/18.
 * heyRezwan@gmail.com
 */
public class PdfUtil {
    private static final String TAG = "PdfUtil";
    Documentinfo documentinfo;

    List<Uri> imgList;
    Context context;
    String path;
    Image image;

    public PdfUtil(List<Uri> imgList, Context context) {
        this.imgList = imgList;
        this.context = context;
        this.documentinfo = (Documentinfo) context;
    }

    public String createPdf() {
        new CreatingPdf().execute();
        return path;
    }


    public class CreatingPdf extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            CommonUtil.showProgressDialog(context, "Document Scan", "Pdf creating...");

        }

        @Override
        protected String doInBackground(String... params) {
            path = Environment.getExternalStorageDirectory().getAbsolutePath() +
                    context.getString(R.string.pdf_dir);

            File folder = new File(path);
            if (!folder.exists()) {
                boolean success = folder.mkdir();
                if (!success) {
                    Toast.makeText(context, "Error on creating application folder", Toast.LENGTH_SHORT).show();
                    return null;
                }
            }

            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd_HH:mm:ss");
            String strDate = sdf.format(c.getTime());

            path = path + "IDLC_" + strDate + context.getString(R.string.pdf_ext);
            Document document = new Document(PageSize.A4, 38, 38, 50, 38);
            Rectangle documentRect = document.getPageSize();

            try {
                PdfWriter.getInstance(document, new FileOutputStream(path));
                document.open();

                for (Uri mg : imgList) {
                    Bitmap bmp = MediaStore.Images.Media.getBitmap(
                            context.getContentResolver(), mg);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bmp.compress(Bitmap.CompressFormat.PNG, 80, stream);


                    image = Image.getInstance(String.valueOf(mg));

                   /*

                   if (bmp.getWidth() > documentRect.getWidth()
                            || bmp.getHeight() > documentRect.getHeight()) {
                        //bitmap is larger than page,so set bitmap's size similar to the whole page
                        image.scaleAbsolute(documentRect.getWidth(), documentRect.getHeight());
                    } else {
                        //bitmap is smaller than page, so add bitmap simply.
                        //[note: if you want to fill page by stretching image,
                        // you may set size similar to page as above]
                        image.scaleAbsolute(bmp.getWidth(), bmp.getHeight());
                    }


                    image.setAbsolutePosition(
                            (documentRect.getWidth() - image.getScaledWidth()) / 2,
                            (documentRect.getHeight() - image.getScaledHeight()) / 2);

                            */


                    float dw = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
                    float dh = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
                    image.scaleAbsolute(dw, dh);

                  

                   /* image.setBorder(Image.BOX);
                    image.setBorderWidth(15);*/

                    document.add(image);
                    document.newPage();

                }

                document.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            document.close();
            imgList.clear();

            return path;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            CommonUtil.hideProgressDialog();

            documentinfo.getpdf(s);
            Toast.makeText(context, "pdf created successfully", Toast.LENGTH_SHORT).show();



        }
    }


}
