package br.com.jotabank.testes;

import br.com.jotabank.exceptions.ContaPoupancaException;
import br.com.jotabank.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteContaPoupanca {
    @Test
    public void deveGuardarODinheiroNaPoupanca() {
        Endereco enderecoDaMaria = new Endereco("Rua Carlos", 5, "08646347", "Vila Ana Maria", "Vila Prudente");
        Titular maria = new Titular("Maria das Dores", "07965312355", 34, enderecoDaMaria);
        ContaPoupanca contaDaMaria = new ContaPoupanca(1, 2, maria, LocalDate.of(2020, 1, 8), LocalDate.of(2035, 1, 8), 123, 4567);

        contaDaMaria.guardar(200);

        assertTrue(contaDaMaria.consultarPoupanca(4567));
    }

    @Test
    public void deveReceberUma() {
        Endereco enderecoDaMaria = new Endereco("Rua Carlos", 5, "08646347", "Vila Ana Maria", "Vila Prudente");
        Titular maria = new Titular("Maria das Dores", "0796531235", 34, enderecoDaMaria);
        ContaPoupanca contaDaMaria = new ContaPoupanca(1, 2, maria, LocalDate.of(2020, 1, 8), LocalDate.of(2035, 1, 8), 123, 4567);

        Endereco enderecoDoJoao = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        Titular joao = new Titular("João Pedro", "12345678900", 18, enderecoDoJoao);
        Conta contaDoJoao = new ContaCorrente(1, 1, joao, LocalDate.of(2020, 1, 8), LocalDate.of(2030, 1, 8), 123, 1234);

        assertThrows(ContaPoupancaException.class, () -> contaDaMaria.transferir(200, contaDoJoao, 1234));

    }
}
