package com.example.app_professor.log_aluno;

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
import com.example.app_professor.area_do_aluno.Area_aluno;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Login_aluno extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth auth;
    EditText logarNome, logarEmail, logarSenha;
    ProgressBar progressBar;
    public static String logarName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_aluno);

        auth = FirebaseAuth.getInstance();

        logarNome = findViewById(R.id.nome_logar);
        logarEmail = findViewById(R.id.email_logar);
        logarSenha = findViewById(R.id.senha_logar);

        progressBar = findViewById(R.id.progressbar);

        findViewById(R.id.logar).setOnClickListener(this);
        findViewById(R.id.cadastro).setOnClickListener(this);
    }

    public void login(){

        logarName = logarNome.getText().toString().trim();
        String logarMail = logarEmail.getText().toString().trim();
        String logarPass = logarSenha.getText().toString().trim();

        if (logarName.isEmpty()){

            logarNome.setError("É necessário um nome.");
            logarNome.requestFocus();
            return;
        }

        if (logarMail.isEmpty()){

            logarEmail.setError("É necessário um email.");
            logarEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(logarMail).matches()){

            logarEmail.setError("Entre com um email valido.");
            logarEmail.requestFocus();
            return;
        }

        if (logarPass.isEmpty()){

            logarSenha.setError("É necessária uma senha.");
            logarSenha.requestFocus();
            return;
        }

        if (logarPass.length() < 8){

            logarSenha.setError("A senha deve conter 8 digitos.");
            logarSenha.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        auth.signInWithEmailAndPassword(logarMail, logarPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful()){

                    Intent it = new Intent(Login_aluno.this, Area_aluno.class);
                    it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(it);
                }

                else {

                    Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.logar:

                login();

                break;

            case R.id.cadastro:

                startActivity(new Intent(this, Inscrever_aluno.class));
                break;
        }
    }
}
