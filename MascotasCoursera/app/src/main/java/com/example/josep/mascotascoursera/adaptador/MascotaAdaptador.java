package com.example.josep.mascotascoursera.adaptador;

import android.database.sqlite.SQLiteDatabase;
import android.icu.text.IDNA;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josep.mascotascoursera.DB.ConstruirDB;
import com.example.josep.mascotascoursera.POJO.InfoMascota;
import com.example.josep.mascotascoursera.R;

import java.util.ArrayList;

/**
 * Created by josep on 25/11/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>
{
    ArrayList<InfoMascota> listaInfo;
    ConstruirDB db;
    public MascotaAdaptador(ArrayList<InfoMascota> listaInfo , ConstruirDB db)
    {
        this.db = db;
        this.listaInfo = listaInfo;
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota , parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position)
    {
        final InfoMascota infoMascota = listaInfo.get(position);
        holder.imgMascota.setImageResource(infoMascota.getFoto());
        holder.patamg.setImageResource(infoMascota.getPatamg());
        holder.pata.setImageResource(infoMascota.getPata());
        holder.nombre.setText(infoMascota.getNombre());
        holder.numRating.setText(infoMascota.getRating());
        holder.pata.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int cont;
                cont = Integer.parseInt( infoMascota.getRating()) + 1;
                holder.pata.setImageResource(R.drawable.patamg);
                infoMascota.setA(true);
                infoMascota.setRating(String.valueOf(cont));
                holder.numRating.setText(String.valueOf(cont));
                if(db != null)
                    db.insertarLike(infoMascota);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return listaInfo.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgMascota , pata , patamg;
        private TextView numRating , nombre;
        public MascotaViewHolder(View itemView)
        {
            super(itemView);
            imgMascota = (ImageView)itemView.findViewById(R.id.fotoMascota);
            patamg = (ImageView)itemView.findViewById(R.id.patamg);
            pata = (ImageView)itemView.findViewById(R.id.pata);
            numRating = (TextView)itemView.findViewById(R.id.numRatings);
            nombre = (TextView)itemView.findViewById(R.id.nombre);
        }
    }

}
