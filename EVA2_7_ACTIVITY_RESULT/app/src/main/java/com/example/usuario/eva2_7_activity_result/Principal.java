package com.example.usuario.eva2_7_activity_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
  private final int MIS_DATOS=1000;
    TextView txtVwMostrar;
    Intent inRegresarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwMostrar= (TextView)findViewById(R.id.txtVwMostrar);
        inRegresarDatos = new Intent(this, Secundaria.class);
    }

    public void onClick(View v ){
        startActivityForResult(inRegresarDatos, MIS_DATOS);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MIS_DATOS){
            if(resultCode== Activity.RESULT_OK){

                txtVwMostrar.setText(data.getStringExtra("MIS_DATOS"));
            }

        }
    }
}


