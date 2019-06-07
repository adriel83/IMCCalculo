package com.example.calculoimc;

import java.util.UUID;

public class Pessoa {
    private double altura;
    private double peso;
    private double imc;
    private String nome;
    private int idade;
    private String uuid;

    public String toString(){
        return "Nome: '" + nome + '\'' +
                ", idade:'" + idade + '\''+
                ", imc:'" + imc + '\'';
    }

    public Pessoa(){

    }

    public Pessoa(String uuid, String nome, String peso, String idade, String altura, String imc){
        this.uuid = uuid;
        this.nome = nome;
        this.imc = Double.parseDouble(imc);
        this.peso = Double.parseDouble(peso);
        this.altura = Double.parseDouble(altura);
        this.idade = Integer.parseInt(idade);
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

    public void setImc(double imc) {
        imc = (double) Math.round(imc * 100) / 100;
        this.imc = imc;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
