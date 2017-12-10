package com.example.josep.mascotascoursera;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.josep.mascotascoursera.DB.ConstantesDB;
import com.example.josep.mascotascoursera.DB.ConstruirDB;
import com.example.josep.mascotascoursera.POJO.InfoMascota;
import com.example.josep.mascotascoursera.R;
import com.example.josep.mascotascoursera.adaptador.MascotaAdaptador;

import java.util.ArrayList;

/**
 * Created by josep on 03/12/2017.
 */

public class FragmentRecyclerView extends Fragment
{
    private ArrayList<InfoMascota>  listaInfo;
    private RecyclerView listaMascota;



    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_recycler_view , container,false);


        ConstruirDB db = new ConstruirDB(getContext());
        for(int i = 1; i <= 2; i++)
            db.insertarMascotas( mascotasAgregar(i) );
        listaInfo = db.obtenerTodosLosContactos();


        listaMascota = (RecyclerView)v.findViewById(R.id.recyMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascota.setLayoutManager(llm);
        MascotaAdaptador adaptador = new MascotaAdaptador(listaInfo , db);
        listaMascota.setAdapter(adaptador);
        ImageView favoritos = (ImageView)getActivity().findViewById(R.id.fav);
        favoritos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                favoritos_cinco(v);
            }
        });
        return v;
    }
    public ContentValues mascotasAgregar(int i)
    {
        /*listaInfo.add(new InfoMascota(R.drawable.mascota1,
        R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        //listaInfo.add(new InfoMascota(R.drawable.mascota2,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota3,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota4,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota5,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota6,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota7,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota8,R.drawable.patamg,R.drawable.pata,"firulais","0",false));*/
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.DB_MASCOTANOMBRE , "FIRULAIS");
        contentValues.put(ConstantesDB.DB_FOTOPERFIL , R.drawable.mascota1);
        contentValues.put(ConstantesDB.DB_FOTOPATA , R.drawable.pata);
        contentValues.put(ConstantesDB.DB_FOTOPATAMG , R.drawable.patamg);


        return contentValues;
    }

    public void favoritos_cinco(View view)
    {

        Intent intent = new Intent(getContext(), MascotasFavoritas.class);
        ArrayList<InfoMascota> aux = new ArrayList<>();
        for(InfoMascota i : listaInfo)
        {

            if(Integer.valueOf(i.getRating()) > 0) aux.add(i);

            if(aux.size() == 5) break;
        }
        intent.putExtra("Favoritos",aux);
        startActivity(intent);

    }
}
