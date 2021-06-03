package com.example.app_professor.area_do_aluno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_professor.R;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder>{

    private List<Construtor> construtors;
    private Context context;

    Adaptador(List<Construtor> construtors, Context context) {
        this.construtors = construtors;
        this.context = context;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.modelo_item_recycler_aluno, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {

        final Construtor construtor = construtors.get(position);
        holder.lista_item_aluno.setText(construtor.getItem_lista_aluno());
    }

    @Override
    public int getItemCount() {
        return construtors.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{

        TextView lista_item_aluno;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            lista_item_aluno = itemView.findViewById(R.id.lista_do_aluno);
        }
    }
}
