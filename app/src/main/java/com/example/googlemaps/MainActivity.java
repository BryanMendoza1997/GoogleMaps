package com.example.googlemaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

import com.example.googlemaps.Fragment.Mapa;

public class MainActivity extends AppCompatActivity {

    Fragment current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            current=new Mapa();
            cambiar(current);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mapaO:
                current=new Mapa();
                break;

        }
        cambiar(current);
        return super.onOptionsItemSelected(item);
    }
    private void cambiar(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();

    }
}