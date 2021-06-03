package com.example.app_professor.elaboracao_de_lista;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_professor.R;

public class Modelo_elaborar extends AppCompatActivity {

    EditText textperg;
    CheckBox checka;
    EditText textrespa;
    CheckBox checkb;
    EditText textrespb;
    CheckBox checkc;
    EditText textrespc;
    CheckBox checkd;
    EditText textrespd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modelo_elaborar);

        textperg = findViewById(R.id.Pergunta);
        checka = findViewById(R.id.Opção_a);
        textrespa = findViewById(R.id.Texto_a);
        checkb = findViewById(R.id.Opção_b);
        textrespb = findViewById(R.id.Texto_b);
        checkc = findViewById(R.id.Opção_c);
        textrespc = findViewById(R.id.Texto_c);
        checkd = findViewById(R.id.Opção_d);
        textrespd = findViewById(R.id.Texto_d);
    }

}
