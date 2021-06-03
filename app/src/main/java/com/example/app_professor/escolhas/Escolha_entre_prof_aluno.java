package com.example.app_professor.escolhas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_professor.R;
import com.example.app_professor.log_aluno.Login_aluno;
import com.example.app_professor.log_professor.Logar;

public class Escolha_entre_prof_aluno extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escolha_entre_prof_aluno);

        findViewById(R.id.Professor).setOnClickListener(this);
        findViewById(R.id.Aluno).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.Professor:

                startActivity(new Intent(this, Logar.class));

                break;

            case R.id.Aluno:

                startActivity(new Intent(this, Login_aluno.class));

                break;
        }
    }
}
