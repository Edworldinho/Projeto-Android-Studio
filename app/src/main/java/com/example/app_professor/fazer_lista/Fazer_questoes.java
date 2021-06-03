package com.example.app_professor.fazer_lista;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_professor.R;
import com.example.app_professor.elaboracao_de_lista.Construtor_database;
import com.example.app_professor.log_aluno.Login_aluno;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fazer_questoes extends AppCompatActivity {

    DatabaseReference database;

    DatabaseReference databaseReference;

    DatabaseReference reference;

    DatabaseReference data;

    DatabaseReference data_aluno;

    RecyclerView recyclerView;

    ArrayList<Construtor_database> list;

    AdapterM adapterM;

    String id_aluno;

    Construtor2 construtor2;

    Construtor_database construtor_database;

    ArrayList<Construtor2> arrayList;

    Questao questao;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fazer_questoes);

        recyclerView = findViewById(R.id.lista_para_prof_corrigir);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        arrayList = new ArrayList<>();

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://appteacher-9edfe.firebaseio.com/Professor/Pedro/Lista");

    }

    @Override
    protected void onStart() {
        super.onStart();

        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    construtor_database = dataSnapshot1.getValue(Construtor_database.class);
                    list.add(construtor_database);

                }

                adapterM = new AdapterM(Fazer_questoes.this, list);


                recyclerView.setAdapter(adapterM);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

                Toast.makeText(Fazer_questoes.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void enviarList() {

        databaseReference = FirebaseDatabase.getInstance().getReference("Alunos");
        reference = databaseReference.child("" + (Login_aluno.logarName));
        data = reference.child("Lista");

        id_aluno = data.push().getKey();
        assert id_aluno != null;

        data_aluno = data.child("" + (id_aluno));

        arrayList.clear();

        for (int o = 1; o <= list.size(); o++){

            construtor2 = new Construtor2(questao);
            arrayList.add(construtor2);
        }

        data_aluno.setValue(arrayList);
    }

    public void onClick(View view) {

        enviarList();
    }
}