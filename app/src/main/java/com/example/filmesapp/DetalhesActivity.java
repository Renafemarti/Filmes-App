package com.example.filmesapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        String titulo = getIntent().getStringExtra("titulo");
        String genero = getIntent().getStringExtra("genero");
        String ano = getIntent().getStringExtra("ano");
        String descricao = getIntent().getStringExtra("descricao");
        String imagem = getIntent().getStringExtra("imagem");

        ImageView imgDetalhe = findViewById(R.id.imgDetalhe);
        TextView txtTitulo = findViewById(R.id.txtTituloDetalhe);
        TextView txtAno = findViewById(R.id.txtAnoDetalhe);
        TextView txtDescricao = findViewById(R.id.txtDescricaoDetalhe);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        txtTitulo.setText(titulo);
        txtAno.setText(ano + " · " + genero);
        txtDescricao.setText(descricao);

        Glide.with(this)
                .load(imagem)
                .into(imgDetalhe);

        btnVoltar.setOnClickListener(v -> finish());
    }
}