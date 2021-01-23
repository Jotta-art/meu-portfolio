package br.com.jotabank.model;

import br.com.jotabank.exceptions.SistemaException;
import br.com.jotabank.validadores.ValidadorDeSaldo;
import br.com.jotabank.validadores.ValidadorDeSenha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma Conta no jotabank.
 *
 * @author joaopedro
 * @version 1.1
 */

public abstract class Conta {

    private int saldo;
    public Titular titular;

    protected List<String> extrato = new ArrayList<>();
    protected int senha;

    private final ValidadorDeSenha validadorDeSenha = new ValidadorDeSenha();
    private final ValidadorDeSaldo validadorDeSaldo = new ValidadorDeSaldo();

    public Conta(int agencia, int numero, Titular titular, LocalDate dataDeCadastro, LocalDate dataDeValidade, int codigoDeSeguranca, int senha) {
        this.titular = titular;
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

    public int consultarSaldo(int tentativaDeSenha) {
        if (validadorDeSenha.validaSenha(tentativaDeSenha, this.senha)) {
            System.out.println("Saldo = " + this.saldo);
            return this.saldo;
        }
        throw new SistemaException("Senha incorreta!");
    }

    public abstract void transferir(int valor, Conta conta, int senha);

    public boolean consultarExtrato(int tentativaDeSenha) {
        if (validadorDeSenha.validaSenha(tentativaDeSenha, this.senha)) {
            System.out.println();
            System.out.println("Extrato:");
            extrato.forEach(System.out::println);
            return true;
        }
        return false;
    }
}