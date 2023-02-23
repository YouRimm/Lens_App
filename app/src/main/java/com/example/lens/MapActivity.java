package com.example.lens;

import android.app.Activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import android.widget.Spinner;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.fragment.app.FragmentActivity;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private Spinner spinner_region, spinner_name;
    private GoogleMap gMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        spinner_region = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter Adapter_region = ArrayAdapter.createFromResource(
                this, R.array.region, android.R.layout.simple_spinner_dropdown_item);

        Adapter_region.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_region.setAdapter(Adapter_region);

        spinner_name = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter Adapter_name = ArrayAdapter.createFromResource(
                this, R.array.name, android.R.layout.simple_spinner_dropdown_item);

        Adapter_name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_name.setAdapter(Adapter_name);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }//onCreate

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        oneMarker(); //마커 여러개하면 manyMarker
    }

    public void oneMarker() {
        //위치설정. 위도 경도 사용  37.38722779417257, 127.12462693910516 으뜸 안경점 위치
        LatLng location1 = new LatLng(37.38722779417257, 127.12462693910516);

        //위치 속성
        MarkerOptions makerOptions = new MarkerOptions();
        makerOptions
                .position(location1)
                .title("으뜸안경점")
                .snippet("031-705-6505")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .alpha(3f);//투명도

        // 마커를 생성한다.
        gMap.addMarker(makerOptions).showInfoWindow();

        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location1, 17)); //지도확대

    }//OnMarker
}