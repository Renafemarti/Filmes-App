package com.example.filmesapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Button btnVerFilmes = findViewById(R.id.btnVerFilmes);
        btnVerFilmes.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListaActivity.class);
            startActivity(intent);
        });
    }
}