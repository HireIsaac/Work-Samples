package com.example.isaaclohnes.project1;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
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
     * Manipulates the map once available.
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

        // Add a marker in Sydney and move the camera
        LatLng area51 = new LatLng(37.237000, -115.806999);
        LatLng leith = new LatLng(55.975500, -3.166500);
        LatLng atlantis= new LatLng(35.525848, 22.084986);
        LatLng elDorado = new LatLng(-20.170290, -65.303815);

        Circle circle = mMap.addCircle(new CircleOptions()
                .center(leith)
                .radius(804672)
                .strokeColor(Color.RED)
                .fillColor(0x220000FF));
        Circle circle2 = mMap.addCircle(new CircleOptions()
                .center(leith)
                .radius(1609344)
                .strokeColor(Color.BLUE)
                .fillColor(0x220000FF));

        mMap.addMarker(new MarkerOptions().position(area51).title("Area 51"));
        mMap.addMarker(new MarkerOptions().position(atlantis).title("Atlantis"));
        mMap.addMarker(new MarkerOptions().position(elDorado).title("El Dorado, lost city of gold"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(leith));
    }
}
