package net.maxproit.salesforce2.util;

import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.common.base.BaseActivity;
import net.maxproit.salesforce2.masum.appdata.AppConstant;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfViewer extends BaseActivity {




    WebView webView;
    PDFView pdfView;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_pdf_viewer;
    }

    @Override
    protected void initComponents() {
        pdfView = (PDFView) findViewById(R.id.pdfViewer);
        getIntentData();
    }

    @Override
    protected void getIntentData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String pdfUrl = bundle.getString(AppConstant.PDF_URL_INTENT_KEY);
            new RetrievePdf().execute(pdfUrl);
        }
    }

    class RetrievePdf extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException ex) {
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }
    }

}
