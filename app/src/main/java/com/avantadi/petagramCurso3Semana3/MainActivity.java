package com.avantadi.petagramCurso3Semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.avantadi.petagramCurso3Semana3.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;

    private RecyclerView RecyclerViewListaMacotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociación XML a RecyclerView
        RecyclerViewListaMacotas = (RecyclerView) findViewById(R.id.rvMascotas);

        //LayoutManagwer: LinearLayoutManager
        LinearLayoutManager LayoutManagwerMascotas = new LinearLayoutManager(this);
        LayoutManagwerMascotas.setOrientation(LinearLayoutManager.VERTICAL);

        //asociación LayoutManagwer a RecyclerView
        RecyclerViewListaMacotas.setLayoutManager(LayoutManagwerMascotas);

        //inicializar ArrayList mascotas
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.icons8_cat_100,"Minino",1));
        mascotas.add(new Mascota(R.drawable.icons8_dog_100,"Gorky",3));
        mascotas.add(new Mascota(R.drawable.icons8_clown_fish_100,"Nemo",2));
        mascotas.add(new Mascota(R.drawable.icons8_german_shepherd_100,"Fritz",4));
        mascotas.add(new Mascota(R.drawable.icons8_horse_100,"Adelantado",2));
        mascotas.add(new Mascota(R.drawable.icons8_rabbit_100,"Rabitt",3));

        //Adaptador
        MascotaAdaptador adaptadorMascotas = new MascotaAdaptador(mascotas);

        //asociación Adaptador a RecyclerView
        RecyclerViewListaMacotas.setAdapter(adaptadorMascotas);

    }
    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.mimenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            // intent SegundaActividad
            Intent intento = new Intent(this,SegundaActividad.class);
            startActivity(intento);
        }
        return super.onOptionsItemSelected(item);
}
}