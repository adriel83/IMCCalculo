package com.example.calculoimc;


import java.util.Date;
//TODO:Gravar e ler data de cadastro
public class Pessoa {
    private double altura;
    private double peso;
    private double imc;
    private double pesoIdeal;
    private int idade;
    private String nome;
    private String uuid;
    private String dataCadastro;
    private String genero;

    public String toString(){
        return "Nome: " + nome +
                ", Idade:" + idade +
                ", IMC:" + imc +
                ", Data:'" + dataCadastro ;
    }

    public Pessoa(){

    }

    Pessoa(String uuid, String nome, double peso, int idade, double altura, double imc, String dataCadastro, double pesoIdeal, String genero){
        this.uuid = uuid;
        this.nome = nome;
        this.imc = imc;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.dataCadastro = dataCadastro;
        this.pesoIdeal = pesoIdeal;
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
