package com.example.UMG.veterinariaapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.UMG.veterinariaapp.db.Dbhelper;


public class MainActivity extends AppCompatActivity {

    //Atributos
    EditText edt_nombre, edt_edad;
    RadioButton rb_perro, rb_gato, rb_conejo;
    CheckBox chk_primVacuna, chk_segVacuna;
    Button btn_entrar;
    Button btn_Crear;
    FloatingActionButton agregar;

    String nombre, edad, tipoMascota, primeraVacuna, segundaVacuna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setear los valores
     //   btn_Crear = findViewById(R.id.btn_db);
        edt_nombre = findViewById(R.id.edt_nombre);
        edt_edad = findViewById(R.id.edt_edad);
        rb_perro = findViewById(R.id.rb_perro);
        rb_gato = findViewById(R.id.rb_gato);
        rb_conejo = findViewById(R.id.rb_conejo);
        chk_primVacuna = findViewById(R.id.chk_primeraVacuna);
        chk_segVacuna = findViewById(R.id.chk_segundaVacuna);
        btn_entrar = findViewById(R.id.btn_ingresar);
        agregar = (FloatingActionButton)findViewById(R.id.agregar);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),NuevoActivity.class);
                startActivity(i);
            }
        });

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = edt_nombre.getText().toString();
                edad = edt_edad.getText().toString();
                if (rb_perro.isChecked()) {
                    //tipoMascota.equals(R.string.ma_opPerro);
                    tipoMascota = "Perro";
                } else if (rb_gato.isChecked()) {
                    tipoMascota = "Gato";
                } else if (rb_conejo.isChecked()) {
                    tipoMascota = "Conejo";
                }

                if (nombre.equals("")) {
                    Toast.makeText(MainActivity.this, "Ingrese Nombre", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edad.equals("")) {
                    Toast.makeText(MainActivity.this, "Ingrese Edad", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (chk_primVacuna.isChecked()) {
                    primeraVacuna = chk_primVacuna.getText().toString();
                } else {
                    primeraVacuna = "";
                }

                if (chk_segVacuna.isChecked()) {
                    segundaVacuna = chk_segVacuna.getText().toString();
                } else {
                    segundaVacuna = "";
                }

                // INICIO - pasar a otra Actividad o pantalla
                Bundle bundle = new Bundle();
                bundle.putString("Nombre", nombre);
                bundle.putString("Edad", edad);
                bundle.putString("Mascota", tipoMascota);
                bundle.putString("PrimeraVacuna", primeraVacuna);
                bundle.putString("SegundaVacuna", segundaVacuna);

                Intent intent = new Intent(MainActivity.this, DatosMascota.class);
                intent.putExtras(bundle); //pasa todo los datos
                startActivity(intent); // pasa a la otra actividad
                // FIN - pasar a otra Actividad o pantalla
            }



        });
       /* btn_Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dbhelper dbHelper = new Dbhelper(MainActivity.this);
                SQLiteDatabase db= dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "ERRRO AL CREAR BASE DE DATOS ", Toast.LENGTH_LONG).show();
                }
            }
        });*/

    }

}
