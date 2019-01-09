package net.maxproit.salesforce.masum.utility;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.maxproit.salesforce.util.CommonUtil;

public class MapUtils implements LocationListener {
    Activity context;
    LocationManager locationManager;

    public MapUtils(Activity context) {
        this.context=context;
    }

    public void getLatLong(){

        if (ContextCompat.checkSelfPermission(context.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context.getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(context, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }
        getLocation();
        gpsChecker();

    }

    void getLocation() {
        try {
            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
//        CommonUtil.showAlertDialog(context, "GEO","Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());
        Toast.makeText(context, "Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude(), Toast.LENGTH_SHORT).show();
        try {
//            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
//            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
//            locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0));

//            CommonUtil.showAlertDialog(context, "GEO","Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());
            Toast.makeText(context, "Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude(), Toast.LENGTH_SHORT).show();
//            Geocoder geocoder;
//            List<Address> addresses;
//            geocoder = new Geocoder(this, Locale.getDefault());
//
//            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
//
//            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
//            String city = addresses.get(0).getLocality();
//            String state = addresses.get(0).getAdminArea();
//            String country = addresses.get(0).getCountryName();
//            String postalCode = addresses.get(0).getPostalCode();
//            String knownName = addresses.get(0).getFeatureName();
//
//            locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude()+"\n"+address+" "+city+" "+ state+ " "+ country+ " "+ postalCode+ " "+ knownName);

        }catch(Exception e)
        {

        }

    }

    @Override
    public void onProviderDisabled(String provider) {
//        Toast.makeText(MainActivity.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    public void gpsChecker(){
        LocationManager lm = (LocationManager) context.getSystemService( Context.LOCATION_SERVICE );
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch(Exception ex) {}

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch(Exception ex) {}

        if(!gps_enabled && !network_enabled) {
            // notify user
//            Toast.makeText(context, "LOCATION IS DISABLE", Toast.LENGTH_SHORT).show();
            CommonUtil.showAlertDialog(context,"LOCATION","Please turn on LOCATION");
        }
    }
}
