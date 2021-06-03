package com.example.app_professor.area_do_aluno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_professor.R;
import com.example.app_professor.fazer_lista.Fazer_questoes;

import java.util.ArrayList;
import java.util.List;

public class Area_aluno extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerViewListasAluno;
    private RecyclerView.Adapter adapter;

    private List<Construtor> construtors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_aluno);

        recyclerViewListasAluno = findViewById(R.id.listas_aluno);
        recyclerViewListasAluno.setHasFixedSize(true);
        recyclerViewListasAluno.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.fazer_listas).setOnClickListener(this);

        construtors = new ArrayList<>();

        for (int i = 0; i <= 0; i++){

            Construtor construtor = new Construtor(

                    "Lista " + (i+1)

            );

            construtors.add(construtor);
        }

        adapter = new Adaptador(construtors, this);
        recyclerViewListasAluno.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.fazer_listas) {
            startActivity(new Intent(this, Fazer_questoes.class));
        }
    }
}
