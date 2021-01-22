package br.com.jotabank.testes;

import br.com.jotabank.Exceptions.SeguroException;
import br.com.jotabank.exceptions.SistemaException;
import br.com.jotabank.model.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.time.LocalDate;
import java.util.List;

public class TestaBauDeContas {

    @Test
    public void deveReceberVariasContas() {

        Bau bauDeContas = new Bau();

        List<ContaPoupanca> listaDeContas = bauDeContas.getBauDeContas();

        Endereco enderecoDoJoao = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        Titular joao = new Titular("João Pedro", "12345678900", 18, enderecoDoJoao);
        ContaPoupanca contaDoJoao = new ContaPoupanca(1, 1, joao, LocalDate.of(2020, 1, 8), LocalDate.of(2030, 1, 8), 123, 1234);

        Endereco enderecoDoMario = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        Titular mario = new Titular("João Pedro", "12345678908", 18, enderecoDoMario);
        ContaPoupanca contaDoMario = new ContaPoupanca(1, 1, mario, LocalDate.of(2020, 1, 8), LocalDate.of(2030, 1, 8), 123, 1234);

        bauDeContas.adicionarConta(contaDoJoao);
        bauDeContas.adicionarConta(contaDoMario);

        assertEquals(2, listaDeContas.size());
    }

    @Test
    @RepeatedTest(5)
    public void deveReceberAMesmaContaDuasVezes() {

        Bau bauDeContas = new Bau();

        List<ContaPoupanca> listaDeContas = bauDeContas.getBauDeContas();

        Endereco enderecoDoJoao = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        Titular joao = new Titular("João Pedro", "12345678900", 18, enderecoDoJoao);
        ContaPoupanca contaDoJoao = new ContaPoupanca(1, 1, joao, LocalDate.of(2020, 1, 8), LocalDate.of(2030, 1, 8), 123, 1234);

        assertThrows(SistemaException.class, () -> {
            Endereco enderecoDoMario = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
            Titular mario = new Titular("João Pedro", "12345678908", 18, enderecoDoMario);
            ContaPoupanca contaDoMario = new ContaPoupanca(1, 1, mario, LocalDate.of(2020, 1, 8), LocalDate.of(2030, 1, 8), 123, 1234);
        });
    }
}
