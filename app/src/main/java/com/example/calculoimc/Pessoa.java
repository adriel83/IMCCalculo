package com.example.calculoimc;


import java.util.Date;
//TODO:Gravar e ler data de cadastro
public class Pessoa {
    private double altura;
    private double peso;
    private double imc;
    private String nome;
    private int idade;
    private String uuid;
    private Date dataCadastro;

    public String toString(){
        return "Nome: " + nome +
                ", Idade:" + idade +
                ", IMC:" + imc +
                ", Data:'" + dataCadastro ;
    }

    public Pessoa(){

    }

    Pessoa(String uuid, String nome, String peso, String idade, String altura, String imc, long dataCadastro){
        this.uuid = uuid;
        this.nome = nome;
        this.imc = Double.parseDouble(imc);
        this.peso = Double.parseDouble(peso);
        this.altura = Double.parseDouble(altura);
        this.idade = Integer.parseInt(idade);

//        this.dataCadastro.
        ;
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

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
