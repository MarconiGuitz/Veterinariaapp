package com.example.UMG.veterinariaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.UMG.veterinariaapp.db.DbMascotas;

public class NuevoActivity extends AppCompatActivity {
    EditText txtNombre, txtEdad, txtTelefono;
    Button btnGuardar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtEdad = findViewById(R.id.txtEdad);
        txtTelefono = findViewById(R.id.txtTelefono);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbMascotas dbmascota = new DbMascotas(NuevoActivity.this);
               long id = dbmascota.insertaMascota(txtNombre.getText().toString(),txtEdad.getText().toString(),txtTelefono.getText().toString());

               if(id >0){
                   Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                   limpiar();
               }else{
                   Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR EL REGISTRO",Toast.LENGTH_LONG).show();

               }
            }
        });
    }
    private void limpiar(){
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
    }
}