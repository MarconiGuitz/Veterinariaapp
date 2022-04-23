package com.example.UMG.veterinariaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import  android.widget.ListView;

import android.R.array;



public class DatosMascota extends AppCompatActivity {

    TextView tv_nombre, tv_edad, tv_vacunas;
    ImageView imgMascota;

    Button btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_mascota);

        tv_nombre = findViewById(R.id.tv_nombre);
        tv_edad = findViewById(R.id.tv_edad);
        tv_vacunas = findViewById(R.id.tv_vacunas);
        imgMascota = findViewById(R.id.imgMascota);

        btn_volver = findViewById(R.id.btn_volver);

        String datosVacuna;

        // INICIO - Captura los datos del Bundle
        Bundle bundleDestino = getIntent().getExtras(); //captura todos los datos del MainActivity

        String nombreDestino = bundleDestino.getString("Nombre");
        String edadDestino = bundleDestino.getString("Edad");
        String tipoMascotaDestino = bundleDestino.getString("Mascota");
        String primVacunaDestino = bundleDestino.getString("PrimeraVacuna");
        String segVacunaDestino = bundleDestino.getString("SegundaVacuna");
        // FIN - Captura los datos del Bundle

        datosVacuna = primVacunaDestino + "\n" + segVacunaDestino + "\n";
        if (datosVacuna.length() < 3) {
            datosVacuna = "Tu mascota no tiene ninguna vacuna.";
        }

        // Cambia la imagen según el tipo de mascota
        if (tipoMascotaDestino.equals(getString(R.string.ma_opPerro))) {
            imgMascota.setImageResource(R.drawable.icon_dogbig);
        } else if (tipoMascotaDestino.equals(getString(R.string.ma_opGato))) {
            imgMascota.setImageResource(R.drawable.icon_catbig);
        } else if (tipoMascotaDestino.equals(getString(R.string.ma_opConejo))) {
            imgMascota.setImageResource(R.drawable.icon_rabbitbig);
        }

        tv_nombre.setText("Tu mascota se llama: " + nombreDestino);
        tv_edad.setText("Edad: " + edadDestino);
        tv_vacunas.setText(datosVacuna);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatosMascota.this, MainActivity.class);
                startActivity(intent); // pasa a la otra actividad
            }
        });
    }
}
