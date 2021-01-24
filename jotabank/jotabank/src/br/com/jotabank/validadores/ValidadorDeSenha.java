package br.com.jotabank.validadores;

import br.com.jotabank.exceptions.SenhaException;
import br.com.jotabank.exceptions.SistemaException;

public class ValidadorDeSenha {

    private int contador = 0;

    public boolean validaSenha(int numero, int senha) {
        if (numero != senha) {
            contador++;
            throw new SistemaException("Senha Incorreta! Tente novamente!");
        }
        if (contador == 4) {
            throw new SenhaException("Quantidade de Tentativas Excedida! Cartão bloqueado!");
        } else {
            return true;
        }
    }
}
