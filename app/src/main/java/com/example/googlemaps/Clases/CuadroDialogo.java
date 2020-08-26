package com.example.googlemaps.Clases;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.googlemaps.R;

public class CuadroDialogo {

    public interface FinalizoCuadroDialogo
    {
        void ResultadoCuadroDialogo(String nombre);
    }
    private FinalizoCuadroDialogo interfaz;

    public CuadroDialogo(Context context, FinalizoCuadroDialogo actividad){
        interfaz=actividad;
        final Dialog dialogo=new Dialog(context);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);
        dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogo.setContentView(R.layout.cuadro_dialogo);

        final EditText nombre=(EditText)dialogo.findViewById(R.id.txtnombre);
        Button aceptar=(Button)dialogo.findViewById(R.id.btnguardar);
        Button cancelar=(Button)dialogo.findViewById(R.id.btncancelar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.ResultadoCuadroDialogo(nombre.getText().toString());
                dialogo.dismiss();
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.ResultadoCuadroDialogo(nombre.getText().toString());
                dialogo.dismiss();
            }
        });
        dialogo.show();
    }
}
