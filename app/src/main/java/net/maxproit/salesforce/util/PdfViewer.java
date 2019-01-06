package net.maxproit.salesforce.util;

import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;

import net.maxproit.salesforce.R;
import net.maxproit.salesforce.common.base.BaseActivity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfViewer extends BaseActivity {

    private static final String INTENT_KEY = "intent";
    private static final String PDF_URL = "pdfurl";

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
            String pdfUrl = bundle.getString(PDF_URL);
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
