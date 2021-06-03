package com.example.app_professor.elaboracao_de_lista;

public class Construtor_database {

    private String pppp;

    private Boolean acheck;
    private String atext;

    private Boolean bcheck;
    private String btext;

    private Boolean ccheck;
    private String ctext;

    private Boolean dcheck;
    private String dtext;

    Construtor_database(){

    }

    Construtor_database(String pppp, Boolean acheck, String atext, Boolean bcheck, String btext, Boolean ccheck, String ctext, Boolean dcheck, String dtext) {

        this.pppp = pppp;
        this.acheck = acheck;
        this.atext = atext;
        this.bcheck = bcheck;
        this.btext = btext;
        this.ccheck = ccheck;
        this.ctext = ctext;
        this.dcheck = dcheck;
        this.dtext = dtext;
    }

    public String getPppp() {
        return pppp;
    }
    public void setPppp(String pppp){
        this.pppp = pppp;
    }



    public Boolean getAcheck() {
        return acheck;
    }
    public void setAcheck(Boolean acheck){
        this.acheck = acheck;
    }



    public String getAtext() {
        return atext;
    }
    public void setAtext(String atext){
        this.atext = atext;
    }



    public Boolean getBcheck() {
        return bcheck;
    }
    public void setBcheck(Boolean bcheck){
        this.bcheck = bcheck;
    }



    public String getBtext() {
        return btext;
    }
    public void setBtext(String btext){
        this.btext = btext;
    }



    public Boolean getCcheck() {
        return ccheck;
    }
    public void setCcheck(Boolean ccheck){
        this.ccheck = ccheck;
    }



    public String getCtext() {
        return ctext;
    }
    public void setCtext(String ctext){
        this.ctext = ctext;
    }



    public Boolean getDcheck() {
        return dcheck;
    }
    public void setDcheck(Boolean dcheck){
        this.dcheck = dcheck;
    }



    public String getDtext() {
        return dtext;
    }
    public void setDtext(String dtext){
        this.dtext = dtext;
    }
}
