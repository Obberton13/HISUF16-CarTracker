package com.example.myapplication;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.java.lang.IllegalStateException: MyLocation layer not enabled
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Location loc;
        // Add a marker in Sydney and move the camera
        LatLng ames = new LatLng(42.0308, -93.6319);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ames));



        /*loc = mMap.getMyLocation();
        LatLng curloc = new LatLng(loc.getLatitude(), loc.getLongitude());
        mMap.addMarker(new MarkerOptions().position(curloc).title("Your car is here."));*/
    }

    public void dropPin(View view) {
        LatLng ames = new LatLng(42.0308, -93.6319);
        mMap.addMarker(new MarkerOptions().position(ames).title("Your car is here."));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ames));

    }
    public void clearPins(View view){
        mMap.clear();
    }

}
