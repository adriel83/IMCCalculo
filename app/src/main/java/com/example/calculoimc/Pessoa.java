package com.example.calculoimc;


import java.util.Date;
//TODO:Gravar e ler data de cadastro
public class Pessoa {
    private double altura;
    private double peso;
    private double imc;
    private double pesoIdeal;
    private String nome;
    private int idade;
    private String uuid;
    private String dataCadastro;
    private SimpleDateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public String toString(){
        return "Nome: " + nome +
                ", Idade:" + idade +
                ", IMC:" + imc +
                ", Data:'" + dataCadastro ;
    }

    public Pessoa(){

    }

    Pessoa(String uuid, String nome, double peso, int idade, double altura, double imc, long dataCadastro, double pesoIdeal){
        this.uuid = uuid;
        this.nome = nome;
        this.imc = imc;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.dataCadastro = dtFormat.format(dataCadastro);
        this.pesoIdeal = pesoIdeal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) { this.imc = imc; }

    public String getUuid() {
        return uuid;
    }

    public double getPesoIdeal() { return pesoIdeal; }

    public void setPesoIdeal(double pesoIdeal) { this.pesoIdeal = pesoIdeal; }

    public String getDataCadastro() { return dataCadastro; }

    public void setDataCadastro(String dataCadastro) { this.dataCadastro = dataCadastro; }

    public void setUuid(String uuid) { this.uuid = uuid; }
}
