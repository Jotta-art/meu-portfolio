package br.com.jotabank.model;

import java.time.LocalDate;

/**
 * Classe que representa uma Conta Corente no jotabank.
 *
 * @author joaopedro
 * @version 1.1
 */

public class ContaCorrente extends Conta {

    public ContaCorrente(int agencia, int numero, Titular titular, LocalDate dataDeCadastro, LocalDate dataDeValidade, int codigoDeSeguranca, int senha) {
        super(agencia, numero, titular, dataDeCadastro, dataDeValidade, codigoDeSeguranca, senha);
    }

    @Override
    public boolean sacar(int valor, int tentativaDeSenha) {
        return super.sacar(valor + 1, tentativaDeSenha);
    }

    @Override
    public void transferir(int valor, Conta conta, int tentativaDeSenha) {
        if (sacar(valor, tentativaDeSenha)) {
            conta.depositar(valor);
            super.extrato.add("Transferência -" + valor);
        }
    }
}
