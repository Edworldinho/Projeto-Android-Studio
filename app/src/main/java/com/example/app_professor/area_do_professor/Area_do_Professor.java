package com.example.app_professor.area_do_professor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.app_professor.elaboracao_de_lista.Elaboracao_de_questoes;
import com.example.app_professor.log_professor.Logar;
import com.example.app_professor.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Area_do_Professor extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerViewListasProf;
    private RecyclerView.Adapter adapter;

    private List<Construtor> construtors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_do_professor);

        recyclerViewListasProf = findViewById(R.id.listas_prof);
        recyclerViewListasProf.setHasFixedSize(true);
        recyclerViewListasProf.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.fazer_listas).setOnClickListener(this);

        construtors = new ArrayList<>();

        for (int i = 0; i <= 0; i++){

            Construtor construtor = new Construtor(

                    "Lista " + (i+1)
            );

            construtors.add(construtor);
        }

        adapter = new Adaptador(construtors, this);
        recyclerViewListasProf.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuLogout) {
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(this, Logar.class));
        }

        return true;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.fazer_listas) {
            startActivity(new Intent(this, Elaboracao_de_questoes.class));
        }
    }
}
