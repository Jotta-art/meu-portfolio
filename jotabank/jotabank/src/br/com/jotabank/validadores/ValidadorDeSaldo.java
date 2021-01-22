package br.com.jotabank.validadores;

import br.com.jotabank.exceptions.SaldoException;

public class ValidadorDeSaldo {

    public boolean validaSaldo(int valor, int saldo) {
        if (valor > saldo) throw new SaldoException("Saldo Insuficiente!");
        else {
            return true;
        }
    }
}
