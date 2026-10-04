package com.example.filmesapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity implements Adapter.OnItemClickListener {

    private ArrayList<Filme> lista;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        lista = FilmesData.getFilmes();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(lista, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Filme f = lista.get(position);

        Intent intent = new Intent(ListaActivity.this, DetalhesActivity.class);
        intent.putExtra("titulo", f.getTitulo());
        intent.putExtra("genero", f.getGenero());
        intent.putExtra("ano", f.getAno());
        intent.putExtra("descricao", f.getDescricao());
        intent.putExtra("imagem", f.getImagem());
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(int position) {
        String titulo = lista.get(position).getTitulo();

        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setMessage("Deseja remover este item?")
                .setNegativeButton("Cancelar", null)
                .setPositiveButton("Remover", (dialog, which) -> {
                    lista.remove(position);
                    adapter.notifyItemRemoved(position);
                    Toast.makeText(ListaActivity.this,
                            titulo + " foi removido da lista.",
                            Toast.LENGTH_SHORT).show();
                })
                .show();
    }
}