package net.maxproit.idlc.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBufferResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rezwan Khan Chowdhury on 7/29/2018.
 * heyrezwan@gmail.com
 */
public class GoogleLandMark {
    private PlaceDetectionClient placeDetectionClient;
    private ProgressDialog progressDialog;
    private Context context;

    Place place;

    public interface Place {
        void landmark(List<String> list);
    }

    public GoogleLandMark(Context context, Place place) {
        this.context = context;
        this.place = place;
        placeDetectionClient = Places.getPlaceDetectionClient(context);
        progressDialog = new ProgressDialog(context);
    }

    @SuppressLint("MissingPermission")
    public void run() {

        final List<String> list = new ArrayList<>();
        if (isLocationEnabled()) {
            progressDialog.setTitle("Finding Location....");
            progressDialog.show();

            try {
                Task<PlaceLikelihoodBufferResponse> placeResult = placeDetectionClient.
                        getCurrentPlace(null);
                placeResult.addOnCompleteListener(new OnCompleteListener<PlaceLikelihoodBufferResponse>() {
                    @Override
                    public void onComplete(@NonNull Task<PlaceLikelihoodBufferResponse> task) {

                        progressDialog.cancel();


                        try {

                            List<com.google.android.gms.location.places.Place> placesList = new ArrayList<com.google.android.gms.location.places.Place>();

                            PlaceLikelihoodBufferResponse likelyPlaces = task.getResult();
                            for (PlaceLikelihood placeLikelihood : likelyPlaces) {
                                placesList.add(placeLikelihood.getPlace().freeze());
                                list.add(placeLikelihood.getPlace().freeze().getName() + "");
                            }
                            likelyPlaces.release();

                            place.landmark(list);
                        }catch (Exception e){
                            Toast.makeText(context, "Google map Api error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            } catch (Exception ignored) {

            }


        } else {


            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(context);
            }
            builder.setTitle("Warning ")
                    .setMessage("Please Enable your location service .")

                    .setNegativeButton("Cancel", null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();



        }


    }

    public boolean isLocationAccessPermitted() {
        return ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    public boolean isLocationEnabled() {
        String le = Context.LOCATION_SERVICE;
        LocationManager locationManager = locationManager = (LocationManager) context.getSystemService(le);
        return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }
}
