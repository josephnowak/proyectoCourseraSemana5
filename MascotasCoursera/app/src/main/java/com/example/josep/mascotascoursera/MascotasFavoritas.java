package com.example.josep.mascotascoursera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.josep.mascotascoursera.POJO.InfoMascota;
import com.example.josep.mascotascoursera.adaptador.MascotaAdaptador;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<InfoMascota> listaFavoritos;
    RecyclerView listaMascota;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        Toolbar miToolbar = (Toolbar)findViewById(R.id.toolAtras);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //pasa un array por un intent
        listaFavoritos = (ArrayList<InfoMascota>) getIntent().getSerializableExtra("Favoritos");
        listaMascota = (RecyclerView)findViewById(R.id.recyMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascota.setLayoutManager(llm);
        MascotaAdaptador adaptador = new MascotaAdaptador(listaFavoritos,null);
        listaMascota.setAdapter(adaptador);

    }
}
