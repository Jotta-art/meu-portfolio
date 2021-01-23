package br.com.jotabank.model;

import br.com.jotabank.exceptions.ContaPoupancaException;
import br.com.jotabank.exceptions.SistemaException;
import br.com.jotabank.validadores.ValidadorDeSenha;

import java.time.LocalDate;

/**
 * Classe que representa uma Conta Poupança no jotabank.
 *
 * @author joaopedro
 * @version 1.1
 */

public class ContaPoupanca extends Conta {
    private int poupanca;

    private static final Bau bau = new Bau();

    private final ValidadorDeSenha validadorDeSenha = new ValidadorDeSenha();

    public ContaPoupanca(int agencia, int numero, Titular titular, LocalDate dataDeCadastro, LocalDate dataDeValidade, int codigoDeSegurança, int senha) {
        super(agencia, numero, titular, dataDeCadastro, dataDeValidade, codigoDeSegurança, senha);

        bau.compare(this);
        bau.adicionarConta(this);
    }

    @Override
    public void transferir(int valor, Conta conta, int tentativaDeSenha) {
        throw new ContaPoupancaException("Esta conta não está habilitada para fazer esse tipo de operação!");
    }

    public void guardar(int valor) {
        this.poupanca += valor;
    }


    public boolean consultarPoupanca(int tentativaDeSenha) {
        if (validadorDeSenha.validaSenha(tentativaDeSenha, super.senha)) {
            System.out.println("Valor na poupança = " + this.poupanca);
            return true;
        }
        return false;
    }

}
