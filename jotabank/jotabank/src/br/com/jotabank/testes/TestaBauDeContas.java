package br.com.jotabank.testes;

import br.com.jotabank.exceptions.SistemaException;
import br.com.jotabank.model.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.time.LocalDate;
import java.util.List;

public class TestaBauDeContas {

    Bau bauDeContas;
    List<ContaPoupanca> listaDeContas;
    Endereco enderecoDoJoao;
    Titular joao;
    ContaPoupanca contaDoJoao;

    Endereco enderecoDoMario;
    Titular mario;
    ContaPoupanca contaDoMario;

    @BeforeEach
    public void criaConta() {
        bauDeContas = new Bau();

        listaDeContas = bauDeContas.getBauDeContas();

        enderecoDoJoao = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        joao = new Titular("João Pedro", "12345678900", 18, enderecoDoJoao);
        contaDoJoao = new ContaPoupanca(1, 1, joao, LocalDate.of(2020, 1, 8), LocalDate.of(2030, 1, 8), 123, 1234);

        enderecoDoMario = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        mario = new Titular("João Pedro", "12345678908", 18, enderecoDoMario);
        contaDoMario = new ContaPoupanca(1, 1, mario, LocalDate.of(2020, 1, 8), LocalDate.of(2030, 1, 8), 123, 1234);

    }

    @Test
    public void deveReceberVariasContas() {
        criaConta();

        bauDeContas.adicionarConta(contaDoJoao);
        bauDeContas.adicionarConta(contaDoMario);

        assertEquals(2, listaDeContas.size());
    }

    @RepeatedTest(10)
    public void deveReceberAMesmaContaDuasVezes() {
        assertThrows(SistemaException.class, this::criaConta);
    }
}
