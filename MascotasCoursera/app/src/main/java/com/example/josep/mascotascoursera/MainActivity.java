package com.example.josep.mascotascoursera;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import com.example.josep.mascotascoursera.POJO.InfoMascota;
import com.example.josep.mascotascoursera.adaptador.PageAdapter;
import com.example.josep.mascotascoursera.fragments.PerfilMascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.miToolbar);
        if(toolbar!=null)
            setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.Tab);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        setUpViewPager();

    }
    private ArrayList<Fragment> agregarFragments()
    {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentRecyclerView());
        fragments.add(new PerfilMascota());
        return fragments;
    }
    private void setUpViewPager()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.pata);
        tabLayout.getTabAt(1).setIcon(R.drawable.patamg);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu , menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.contacto:
                formularioMensaje();
                break;
            case R.id.about:
                informacionProgramador();
                break;
        }

        return true;
    }
    public void formularioMensaje()
    {
        Intent i = new Intent(this,FormularioMensaje.class);
        startActivity(i);
    }
    public void informacionProgramador()
    {
        Intent i = new Intent(this , InformacionProgramador.class);
        startActivity(i);
    }

}
