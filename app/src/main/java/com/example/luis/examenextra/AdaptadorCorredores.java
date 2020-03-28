package com.example.luis.examenextra;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorCorredores extends RecyclerView.Adapter {

    ArrayList<Corredor> listaCorredores = null;
    Context contexto;

    public AdaptadorCorredores(Context contexto, ArrayList<Corredor> listado){

        this.contexto = contexto;
        this.listaCorredores = listado;


    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View vistaCorredor = LayoutInflater.from(contexto).inflate(R.layout.item_corredor,null);

        //vistaCorredor.setOnClickListener(this);
        return new Holder(vistaCorredor);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Corredor corredor = listaCorredores.get(position);
        Holder nuevoHolder = (Holder)holder;
        nuevoHolder.txtNombre.setText(corredor.getNombre());
        nuevoHolder.txtApellidos.setText(corredor.getApellidos());
        nuevoHolder.txtEmail.setText(corredor.getEmail());
        nuevoHolder.txtId.setText(String.valueOf(corredor.getId()));
        nuevoHolder.txtCategoria.setText(corredor.getCategoria());
    }

    @Override
    public int getItemCount() {
        return listaCorredores.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView txtNombre;
        TextView txtApellidos;
        TextView txtEmail;
        TextView txtId;
        TextView txtCategoria;


        public Holder(View itemView) {
            super(itemView);
            txtNombre = (TextView)itemView.findViewById(R.id.txtNombre);
            txtApellidos = (TextView)itemView.findViewById(R.id.txtApellidos);
            txtEmail = (TextView)itemView.findViewById(R.id.txtEmail);
            txtId = (TextView)itemView.findViewById(R.id.txtId);
            txtCategoria = (TextView)itemView.findViewById(R.id.txtCategoria);
        }
    }
}
