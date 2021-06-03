package com.example.app_professor.log_professor;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.app_professor.R;
import com.example.app_professor.area_do_professor.Area_do_Professor;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.Objects;

public class Inscrever_se extends AppCompatActivity implements View.OnClickListener {

    EditText inscreverNome, inscreverEmail, inscreverSenha;
    ProgressBar progress;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscrever_se);

        inscreverNome = findViewById(R.id.nome_logar);
        inscreverEmail = findViewById(R.id.email_logar);
        inscreverSenha = findViewById(R.id.senha_logar);
        progress = findViewById(R.id.progress);


        firebaseAuth = FirebaseAuth.getInstance();

        findViewById(R.id.enviar_lista_ao_prof).setOnClickListener(this);
        findViewById(R.id.ja_cadastro).setOnClickListener(this);
    }

    private void registrar(){

        String inscreverName = inscreverNome.getText().toString().trim();
        String inscreverMail = inscreverEmail.getText().toString().trim();
        String inscreverPass = inscreverSenha.getText().toString().trim();

        if (inscreverName.isEmpty()){

            inscreverNome.setError("É necessário um nome.");
            inscreverNome.requestFocus();
            return;
        }

        if (inscreverMail.isEmpty()){

            inscreverEmail.setError("É necessário um email.");
            inscreverEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(inscreverMail).matches()){

            inscreverEmail.setError("Entre com um email valido.");
            inscreverEmail.requestFocus();
            return;
        }

        if (inscreverPass.isEmpty()){

            inscreverSenha.setError("É necessária uma senha.");
            inscreverSenha.requestFocus();
            return;
        }

        if (inscreverPass.length() < 8){

            inscreverSenha.setError("A senha deve conter 8 digitos.");
            inscreverSenha.requestFocus();
            return;
        }

        progress.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(inscreverMail,inscreverPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progress.setVisibility(View.GONE);
                if (task.isSuccessful()){

                    Intent intent = new Intent(Inscrever_se.this, Area_do_Professor.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {

                    if (task.getException() instanceof FirebaseAuthUserCollisionException){

                        Toast.makeText(getApplicationContext(), "Você já se registrou", Toast.LENGTH_SHORT).show();
                    }

                    else {

                        Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.enviar_lista_ao_prof:

                registrar();

                break;

            case R.id.ja_cadastro:

                startActivity(new Intent(Inscrever_se.this, Logar.class));

                break;

        }
    }
}
