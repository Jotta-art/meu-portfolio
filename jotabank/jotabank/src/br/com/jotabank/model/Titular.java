package br.com.jotabank.model;

public class Titular {
    private final String nome;
    private final String cpf;
    private final int dataDeNascimento;
    private final Endereco endereco;

    public Titular(String nome, String cpf, int idade, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = idade;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public int getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }
}
