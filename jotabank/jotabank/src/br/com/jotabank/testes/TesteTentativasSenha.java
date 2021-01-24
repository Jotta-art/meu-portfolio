package br.com.jotabank.testes;

import br.com.jotabank.exceptions.SenhaException;
import br.com.jotabank.exceptions.SistemaException;
import br.com.jotabank.model.ContaCorrente;
import br.com.jotabank.model.Endereco;
import br.com.jotabank.model.Titular;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TesteTentativasSenha {

    @Test
    public void deveReceberUmaSistemaExceptionPorQuantidadeDeTentativasExcedida() {
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

        try {
            assertThrows(SenhaException.class, () -> contaDoJoao.consultarSaldo(123));
        } catch (SistemaException ignored) {
        }
    }
}
