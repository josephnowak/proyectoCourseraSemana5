package com.example.josep.mascotascoursera.DB;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.IDNA;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.josep.mascotascoursera.POJO.InfoMascota;

import java.util.ArrayList;

/**
 * Created by josep on 09/12/2017.
 */

public class ConstruirDB extends SQLiteOpenHelper
{
    private Context context;
    public ConstruirDB(Context context)
    {
        super(context, ConstantesDB.DB_NAME, null, ConstantesDB.DB_VERSION);
        this.context = context;
    }
    public boolean creada()
    {
        return this.getDatabaseName() == ConstantesDB.DB_NAME;
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String queryCrear = "CREATE TABLE " + ConstantesDB.DB_NOMBRETABLAMASCOTA +
                "(" +
                ConstantesDB.DB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.DB_FOTOPERFIL + " INTEGER, " +
                ConstantesDB.DB_FOTOPATA + " INTEGER, " +
                ConstantesDB.DB_FOTOPATAMG + " INTEGER, " +
                ConstantesDB.DB_MASCOTANOMBRE + " TEXT " +
                ")";
        db.execSQL(queryCrear);


        queryCrear = "CREATE TABLE " + ConstantesDB.DB_NOMBRETABLALIKES +
                "(" +
                ConstantesDB.DB_NUMEROLIKE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.DB_IDGUSTADO + " INTEGER, " +
                ConstantesDB.DB_RATING + " TEXT " +

                ")";
        db.execSQL(queryCrear);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        String a = "DROP TABLE IF EXIST ";
        db.execSQL(a + ConstantesDB.DB_NOMBRETABLAMASCOTA);
        db.execSQL(a + ConstantesDB.DB_NOMBRETABLALIKES);
        onCreate(db);
    }
    public ArrayList<InfoMascota> obtenerTodosLosContactos()
    {
        ArrayList<InfoMascota> contactos = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesDB.DB_NOMBRETABLAMASCOTA;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query , null );

        while(registros.moveToNext())
        {

            contactos.add(new InfoMascota(
                    registros.getInt(0) ,
                    registros.getInt(1) ,
                    registros.getInt(2) ,
                    registros.getInt(3) ,
                    registros.getString(4),
                    "0",
                    true
                    ));

        }
        db.close();
        return contactos;
    }
    public void insertarMascotas(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.DB_NOMBRETABLAMASCOTA , null , contentValues);
        db.close();
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void insertarLike(InfoMascota a)
    {
        int like = 0;
        ContentValues contentValues = new ContentValues();
        String query = "SELECT COUNT (" + ConstantesDB.DB_RATING + ") " +
                " FROM " + ConstantesDB.DB_NOMBRETABLALIKES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext())
            like = Integer.valueOf(registros.getString(0));


        contentValues.put(ConstantesDB.DB_IDGUSTADO , a.getId());
        contentValues.put(ConstantesDB.DB_RATING , String.valueOf(like + 1));
        db.insert(ConstantesDB.DB_NOMBRETABLALIKES , null , contentValues);
        db.close();
    }

}
