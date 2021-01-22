package br.com.jotabank.model;

import java.math.BigInteger;

public class Endereco {
    private String rua;
    private int numero;
    private String cep;
    private String bairro;
    private String cidade;

    public Endereco(String rua, int numero, String cep, String bairro, String cidade) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }
}
