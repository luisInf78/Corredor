package com.example.luis.examenextra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListadosCorredores extends AppCompatActivity {
    RecyclerView recyclerViewCorredores;
    AdaptadorCorredores adaptadorCorredores;
    RecyclerView.LayoutManager manager;
    ArrayList<Corredor> listaCorredor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listados_corredores);

        Corredor c1 = new Corredor(1,"Manuel","Lopez Lerma", "manuel@corredor.net","555555555","555555555G","manuel123","1234","Runner");
        Corredor c2 = new Corredor(2,"Patricia","Scott", "patricia@corredor.net","666666666","555555555G","manuel123","1234","Bici");
        Corredor c3 = new Corredor(3,"Benito","Cannondale", "benito@corredor.net","777777777","555555555G","manuel123","1234","Runner");
        Corredor c4 = new Corredor(4,"Fernando","Tyr", "fernando@corredor.net","888888888","555555555G","manuel123","1234","Triatlon");
        Corredor c5 = new Corredor(5,"Lucia","Taymory", "lucia@corredor.net","888888888","555555555G","manuel123","1234","Bici");

        listaCorredor = new ArrayList<Corredor>();
        listaCorredor.add(c1);
        listaCorredor.add(c2);
        listaCorredor.add(c3);
        listaCorredor.add(c4);
        listaCorredor.add(c5);

        recyclerViewCorredores = (RecyclerView)findViewById(R.id.rvCorredores);
        manager = new LinearLayoutManager(this);
        recyclerViewCorredores.setLayoutManager(manager);
        adaptadorCorredores = new AdaptadorCorredores(this,listaCorredor);
        recyclerViewCorredores.setAdapter(adaptadorCorredores);


    }
}
