package com.example.UMG.veterinariaapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

public class DbMascotas extends Dbhelper{

    Context context;

    public DbMascotas(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertaMascota(String nombre, String edad, String telefono){
        long id = 0;
        try{
        Dbhelper dbhelper = new Dbhelper(context);
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre",nombre);
        values.put("edad",edad);
        values.put("telefono",telefono);

        id = db.insert(TABLE_MASCOTAS, null, values);
        }catch(Exception ex){
            ex.toString();
        }
        return id;
    }
}
