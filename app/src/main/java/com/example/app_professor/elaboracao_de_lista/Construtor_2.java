package com.example.app_professor.elaboracao_de_lista;

public class Construtor_2 {

    private String pergunta;
    private Boolean op_a;
    private String let_a;
    private Boolean op_b;
    private String let_b;
    private Boolean op_c;
    private String let_c;
    private Boolean op_d;
    private String let_d;

    public Construtor_2(){

    }

    public Construtor_2(String pergunta, Boolean op_a, String let_a, Boolean op_b, String let_b, Boolean op_c, String let_c, Boolean op_d, String let_d) {
        this.pergunta = pergunta;
        this.op_a = op_a;
        this.let_a = let_a;
        this.op_b = op_b;
        this.let_b = let_b;
        this.op_c = op_c;
        this.let_c = let_c;
        this.op_d = op_d;
        this.let_d = let_d;
    }


    public String getPergunta() {
        return pergunta;
    }

    public Boolean getOp_a() {
        return op_a;
    }

    public String getLet_a() {
        return let_a;
    }

    public Boolean getOp_b() {
        return op_b;
    }

    public String getLet_b() {
        return let_b;
    }

    public Boolean getOp_c() {
        return op_c;
    }

    public String getLet_c() {
        return let_c;
    }

    public Boolean getOp_d() {
        return op_d;
    }

    public String getLet_d() {
        return let_d;
    }

}
