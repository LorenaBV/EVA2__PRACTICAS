package com.example.usuario.eva2_7_activity_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {
    EditText edtTxtDatos;
    Intent inResu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        edtTxtDatos=(EditText)findViewById(R.id.edtTxtDatos);
        inResu=getIntent();

    }

    public void onClick2(View v ){
       String sCade = edtTxtDatos.getText().toString();
        inResu.putExtra("MIS_DATOS",sCade);
        setResult(Activity.RESULT_OK,inResu);
        finish();


    }
}
