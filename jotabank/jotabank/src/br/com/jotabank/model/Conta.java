package br.com.jotabank.model;

import br.com.jotabank.validadores.ValidadorDeSaldo;
import br.com.jotabank.validadores.ValidadorDeSenha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe que representa uma Conta no jotabank.
 *
 * @author joaopedro
 * @version 1.1
 */

public abstract class Conta {

    private static final Long serialVersionUID = 2L;

    private int saldo;
    private final int agencia;
    private final int numero;
    public Titular titular;
    private final LocalDate dataDeCadastro;
    private final LocalDate dataDeValidade;
    private final int codigoDeSegurança;

    protected List<String> extrato = new ArrayList<>();
    protected int senha;

    private ValidadorDeSenha validadorDeSenha = new ValidadorDeSenha();
    private ValidadorDeSaldo validadorDeSaldo = new ValidadorDeSaldo();

    public Conta(int agencia, int numero, Titular titular, LocalDate dataDeCadastro, LocalDate dataDeValidade, int codigoDeSegurança, int senha) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.dataDeCadastro = dataDeCadastro;
        this.dataDeValidade = dataDeValidade;
        this.codigoDeSegurança = codigoDeSegurança;
        this.senha = senha;
    }

    public boolean sacar(int valor, int tentativaDeSenha) {

//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("qual é a senha?");
//
//        int senha = sc.nextInt();
//
//        sc.close();

        if (validadorDeSenha.validaSenha(tentativaDeSenha, this.senha) && validadorDeSaldo.validaSaldo(valor, this.saldo)) {
            this.saldo -= valor;
            System.out.println("Operação Realizada!");
            extrato.add("Saque -" + valor);

            return true;
        }
        return false;
    }

    public void depositar(int valor) {
        this.saldo += valor;
        extrato.add("Depósito +" + valor);
        System.out.println("Depósito Realizado!");
    }

    public void consultarSaldo(int tentativaDeSenha) {
        if (validadorDeSenha.validaSenha(tentativaDeSenha, this.senha)) {
            System.out.println("Saldo = " + this.saldo);
        }
    }

    public abstract void transferir(int valor, Conta conta, int senha);

    public void consultarExtrato(int tentativaDeSenha) {
        if (validadorDeSenha.validaSenha(tentativaDeSenha, this.senha)) {
            System.out.println();
            System.out.println("Extrato:");
            extrato.forEach(System.out::println);
        }
    }
}
