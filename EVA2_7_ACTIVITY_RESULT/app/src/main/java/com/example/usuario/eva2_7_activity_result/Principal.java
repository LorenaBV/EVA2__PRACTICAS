package com.example.usuario.eva2_7_activity_result;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
  private final int MIS_DATOS=1000;
    private final int MIS_CONTACTOS=2000;
    TextView txtVwMostrar;
    Intent inRegresarDatos;
    Intent inRegresarContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwMostrar= (TextView)findViewById(R.id.txtVwMostrar);
        inRegresarDatos = new Intent(this, Secundaria.class);
        Uri uriContacto = android.provider.ContactsContract.Contacts.CONTENT_URI;
        inRegresarContacto = new Intent(Intent.ACTION_PICK, uriContacto);


    }

    public void onClickContacto(View v){
        startActivityForResult(inRegresarContacto,MIS_CONTACTOS);


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

        }else if (requestCode== MIS_CONTACTOS){
            if(resultCode== Activity.RESULT_OK){

                    //recuperar datos
                  // Toast.makeText(this, data.getDataString(), Toast.LENGTH_LONG).show();
                    String sCont= data.getDataString();

                    Intent inEditarContacto = new Intent(Intent.ACTION_EDIT, Uri.parse(sCont));
                    startActivity(inEditarContacto);
                }
            }

        }
    }


