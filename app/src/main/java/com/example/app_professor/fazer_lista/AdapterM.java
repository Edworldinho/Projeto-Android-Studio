package com.example.app_professor.fazer_lista;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.app_professor.R;
import com.example.app_professor.elaboracao_de_lista.Construtor_database;

import java.util.ArrayList;

public class AdapterM extends RecyclerView.Adapter<AdapterM.MyViewHolder> {

    Context context;
    ArrayList<Construtor_database> construtor_databases;


    public TextView textView_Pergunta, textView_Texto_a, textView_Texto_b, textView_Texto_c, textView_Texto_d;

    public CheckBox textView_Opcao_a, textView_Opcao_b, textView_Opcao_c, textView_Opcao_d;

    public Boolean textView_Op_a;
    public Boolean textView_Op_b;
    public Boolean textView_Op_c;
    public Boolean textView_Op_d;

    public AdapterM(){

        textView_Op_a = false;
        textView_Op_b = false;
        textView_Op_c = false;
        textView_Op_d = false;
    }

    public AdapterM(Context c, ArrayList<Construtor_database> construtor_databases1){

        context = c;
        construtor_databases = construtor_databases1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder( View itemView) {
            super(itemView);

            textView_Pergunta = itemView.findViewById(R.id.textView_Pergunta);

            textView_Opcao_a = itemView.findViewById(R.id.textView_Opção_a);
            textView_Texto_a = itemView.findViewById(R.id.textView_Texto_a);

            textView_Opcao_b = itemView.findViewById(R.id.textView_Opção_b);
            textView_Texto_b = itemView.findViewById(R.id.textView_Texto_b);

            textView_Opcao_c = itemView.findViewById(R.id.textView_Opção_c);
            textView_Texto_c = itemView.findViewById(R.id.textView_Texto_c);

            textView_Opcao_d = itemView.findViewById(R.id.textView_Opção_d);
            textView_Texto_d = itemView.findViewById(R.id.textView_Texto_d);
        }
    }



    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.modelo_fazer, parent, false));
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        textView_Pergunta.setText(construtor_databases.get(position).getPppp());

        textView_Texto_a.setText(construtor_databases.get(position).getAtext());

        textView_Texto_b.setText(construtor_databases.get(position).getBtext());

        textView_Texto_c.setText(construtor_databases.get(position).getCtext());

        textView_Texto_d.setText(construtor_databases.get(position).getDtext());
    }

    @Override
    public int getItemCount() {
        return construtor_databases.size();
    }

}