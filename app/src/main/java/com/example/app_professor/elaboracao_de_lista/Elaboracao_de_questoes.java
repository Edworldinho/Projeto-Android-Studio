package com.example.app_professor.elaboracao_de_lista;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.app_professor.R;
import com.example.app_professor.log_professor.Logar;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class Elaboracao_de_questoes extends Modelo_elaborar {

    private RecyclerView recyclerView;

    Construtor_2 construtor_2;

    Adaptador_2 adaptador_2;

    private List<Construtor_2> construtor2s;

    public static DatabaseReference databaseReference;

    public static DatabaseReference newdatabaseReference;

    public String perg;
    public String resp1;
    public String resp2;
    public String resp3;
    public String resp4;
    public boolean aa;
    public boolean bb;
    public boolean cc;
    public boolean dd;

    public String stringPergunta;
    public Boolean booleanA;
    public String stringA;
    public Boolean booleanB;
    public String stringB;
    public Boolean booleanC;
    public String stringC;
    public Boolean booleanD;
    public String stringD;

    public Construtor_database construtor_database;


    public static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elaboracao_de_questoes);

        recyclerView = findViewById(R.id.lista_de_questao_a_fazer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        construtor2s = new ArrayList<>();
    }

    private void addQuestao(){

        construtor2s.clear();

        for (int j=0; j<=0; j++){

            perg = textperg.getText().toString();

            aa = Boolean.parseBoolean(checka.getClass().toString());
            resp1 = textrespa.getText().toString();

            bb = Boolean.parseBoolean(checkb.getClass().toString());
            resp2 = textrespb.getText().toString();

            cc = Boolean.parseBoolean(checkc.getClass().toString());
            resp3 = textrespc.getText().toString();

            dd = Boolean.parseBoolean(checkd.getClass().toString());
            resp4 = textrespd.getText().toString();

            construtor_2 = new Construtor_2(perg, aa, resp1, bb, resp2, cc, resp3, dd, resp4);

            construtor2s.add(construtor_2);

            adaptador_2 = new Adaptador_2(construtor2s, this);
            recyclerView.setAdapter(adaptador_2);
        }
    }

    private void enviarAll(){

        databaseReference = Logar.firebaseDatabase.child("Lista");

        for (int k = 0; k<=0; k++){

            id = databaseReference.push().getKey();

            stringPergunta = adaptador_2.perg.getText().toString().trim();

            booleanA = Boolean.parseBoolean(adaptador_2.a.getClass().toString());
            stringA = adaptador_2.texta.getText().toString().trim();

            booleanB = Boolean.parseBoolean(adaptador_2.b.getClass().toString());
            stringB = adaptador_2.textb.getText().toString().trim();

            booleanC = Boolean.parseBoolean(adaptador_2.c.getClass().toString());
            stringC = adaptador_2.textc.getText().toString().trim();

            booleanD = Boolean.parseBoolean(adaptador_2.d.getClass().toString());
            stringD = adaptador_2.textd.getText().toString().trim();

            if (adaptador_2.a.isChecked()){
                booleanA = true;
            }

            else if (adaptador_2.b.isChecked()){
                booleanB = true;
            }

            else if (adaptador_2.c.isChecked()){
                booleanC = true;
            }

            else if (adaptador_2.d.isChecked()){
                booleanD = true;
            }
        }

        construtor_database = new Construtor_database(stringPergunta, booleanA, stringA, booleanB, stringB, booleanC, stringC, booleanD, stringD);

        newdatabaseReference = databaseReference.child("" + (id));

        assert id != null;
        newdatabaseReference.setValue(construtor_database);
    }

    public void enviarp(View view){

        addQuestao();
    }

    public void enviarAluno(View view){

        enviarAll();
    }
}
