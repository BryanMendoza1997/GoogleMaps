package com.example.googlemaps.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.googlemaps.Clases.CuadroDialogo;
import com.example.googlemaps.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Mapa extends Fragment implements OnMapReadyCallback, CuadroDialogo.FinalizoCuadroDialogo {

    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View vista;
    private MapView mapView;
    private GoogleMap Gmap;
    private Context context;
    LatLng sydney;

    public Mapa() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista= inflater.inflate(R.layout.fragment_mapa, container, false);
       context=vista.getContext();
        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView=(MapView) vista.findViewById(R.id.map);
        if(mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Gmap = googleMap;
        Gmap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Gmap.getUiSettings().setZoomControlsEnabled(true);
        sydney = new LatLng(-1.0126570103935393, -79.46909832802605);
        Gmap.setMinZoomPreference(15);
        Gmap.setMaxZoomPreference(20);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(17).bearing(5).build();
        Gmap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        //Evento al dar click
        Gmap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                sydney=latLng;
                new CuadroDialogo(context,Mapa.this);

            }
        });
    }

    @Override
    public void ResultadoCuadroDialogo(String nombre) {
        if(nombre.length()>0) {

            Gmap.addMarker(new MarkerOptions().position(sydney).title(nombre).draggable(true));

        }
    }
}