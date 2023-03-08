package com.example.myproyectito;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Website extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        getSupportActionBar().hide();

        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
         mMap = googleMap;
         this.mMap.setOnMapClickListener(this);
         this.mMap.setOnMapLongClickListener(this);

        LatLng Plan = new LatLng(25.636989097628586,-100.3589199485876);
        mMap.addMarker(new MarkerOptions().position(Plan).title("Planetario Alfa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Plan));

    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {

        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);

        mMap.clear();
        LatLng Batiz = new LatLng(latLng.latitude,latLng.longitude);
        mMap.addMarker(new MarkerOptions().position(Batiz).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Batiz));

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {

        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);

        mMap.clear();
        LatLng Batiz = new LatLng(latLng.latitude,latLng.longitude);
        mMap.addMarker(new MarkerOptions().position(Batiz).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Batiz));

    }
}