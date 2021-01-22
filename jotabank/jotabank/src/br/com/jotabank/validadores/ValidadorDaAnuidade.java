package br.com.jotabank.validadores;

import br.com.jotabank.exceptions.ContaCorrenteException;

public class ValidadorDaAnuidade {

    public void verificaValor(int valor) {
        int valorDaAnuidade = 200;
        if (valor != valorDaAnuidade) throw new ContaCorrenteException("Valor Incorreto!");
        else System.out.println("Anuidade Debitada!");
    }
}
