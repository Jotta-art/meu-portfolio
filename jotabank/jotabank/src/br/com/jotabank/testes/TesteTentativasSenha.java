package br.com.jotabank.testes;

import br.com.jotabank.exceptions.SistemaException;
import br.com.jotabank.model.ContaCorrente;
import br.com.jotabank.model.Endereco;
import br.com.jotabank.model.Titular;

import java.time.LocalDate;

public class TesteTentativasSenha {
    public static void main(String[] args) {
        Endereco enderecoDoJoao = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        Titular joao = new Titular("João Pedro", "12345678900", 18, enderecoDoJoao);
        ContaCorrente contaDoJoao = new ContaCorrente(1, 1, joao, LocalDate.of(2020, 01, 8), LocalDate.of(2030, 01, 8), 123, 1234);

        try {
            contaDoJoao.consultarSaldo(123);
        } catch (SistemaException ignored) {
        }

        try {
            contaDoJoao.consultarSaldo(123);
        } catch (SistemaException ignored) {
        }

        try {
            contaDoJoao.consultarSaldo(123);
        } catch (SistemaException ignored) {
        }

        contaDoJoao.consultarSaldo(123);
    }
}
