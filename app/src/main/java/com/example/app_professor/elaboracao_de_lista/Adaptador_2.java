package com.example.app_professor.elaboracao_de_lista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_professor.R;

import java.util.List;

public class Adaptador_2 extends RecyclerView.Adapter<Adaptador_2.ViewHolder> {

    private List<Construtor_2> construtor_2s;
    private Context context;

    public EditText perg;
    public CheckBox a;
    public EditText texta;
    public CheckBox b;
    public EditText textb;
    public CheckBox c;
    public EditText textc;
    public CheckBox d;
    public EditText textd;

    Adaptador_2(List<Construtor_2> construtor_2s, Context context) {
        this.construtor_2s = construtor_2s;
        this.context = context;
    }

    @NonNull
    @Override
    public Adaptador_2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.modelo_elaborar, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador_2.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return construtor_2s.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemview) {
            super(itemview);

            for (int j = 0; j <= 0; j++) {

                perg = itemview.findViewById(R.id.Pergunta);

                a = itemview.findViewById(R.id.Opção_a);

                texta = itemview.findViewById(R.id.Texto_a);

                b = itemview.findViewById(R.id.Opção_b);

                textb = itemview.findViewById(R.id.Texto_b);

                c = itemview.findViewById(R.id.Opção_c);

                textc = itemview.findViewById(R.id.Texto_c);

                d = itemview.findViewById(R.id.Opção_d);

                textd = itemview.findViewById(R.id.Texto_d);

            }

        }

    }

}
