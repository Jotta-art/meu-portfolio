package br.com.jotabank.testes;

import br.com.jotabank.exceptions.SaldoException;
import br.com.jotabank.exceptions.SistemaException;
import br.com.jotabank.model.Conta;
import br.com.jotabank.model.ContaCorrente;
import br.com.jotabank.model.Endereco;
import br.com.jotabank.model.Titular;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TesteConta {

    Endereco enderecoDoJoao;
    Titular joao;
    Conta contaDoJoao;

    Endereco enderecoDaMaria;
    Titular maria;
    Conta contaDaMaria;

    public void criaContas() {
        enderecoDoJoao = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        joao = new Titular("João Pedro", "12345678900", 18, enderecoDoJoao);
        contaDoJoao = new ContaCorrente(1, 1, joao, LocalDate.of(2020, 1, 8), LocalDate.of(2030, 1, 8), 123, 1234);

        enderecoDaMaria = new Endereco("Rua Carlos", 5, "08646347", "Vila Ana Maria", "Vila Prudente");
        maria = new Titular("Maria das Dores", "07965312355", 34, enderecoDaMaria);
        contaDaMaria = new ContaCorrente(1, 2, maria, LocalDate.of(2020, 1, 8), LocalDate.of(2035, 1, 8), 123, 4567);

        contaDoJoao.depositar(200);
    }

    @Test
    public void deveDepositar() {
        criaContas();

        assertEquals(200, contaDoJoao.consultarSaldo(1234));
    }

    @Test
    public void deveSacar() {
        criaContas();

        contaDoJoao.sacar(99, 1234);

        assertEquals(100, contaDoJoao.consultarSaldo(1234));
    }

    @Test
    public void deveReceberUmaSaldoExceptionPorValorInvalidoAoTentarSacar() {
        criaContas();

        assertThrows(SaldoException.class, () -> contaDoJoao.sacar(200, 1234));
    }

    @Test
    public void deveReceberUmaSistemaExceptionPorSenhaInvalidaAoTentarSacar() {
        criaContas();

        assertThrows(SistemaException.class, () -> contaDoJoao.sacar(99, 1235));
    }

    @Test
    public void deveConsultarOSaldo() {
        criaContas();

        int saldo = contaDoJoao.consultarSaldo(1234);

        assertEquals(200, saldo);
    }

    @Test
    public void deveReceberUmaSistemaExceptionPorSenhaInvalidaAoTentarConsultarOSaldo() {
        criaContas();

        assertThrows(SistemaException.class, () -> contaDoJoao.consultarSaldo(1235));
    }

    @Test
    public void deveTransferir() {
        criaContas();

        contaDoJoao.transferir(100, contaDaMaria, 1234);

        int saldo = contaDaMaria.consultarSaldo(4567);

        assertEquals(100, saldo);
    }

    @Test
    public void deveReceberUmaSaldoExceptionPorValorInvalidoAoTentarTransferir() {
        criaContas();

        assertThrows(SaldoException.class, () -> contaDoJoao.transferir(300, contaDaMaria, 1234));
    }

    @Test
    public void deveReceberUmaSistemaExceptionPorSenhaInvalidaAoTentarTransferir() {
        criaContas();

        assertThrows(SistemaException.class, () -> contaDoJoao.transferir(100, contaDaMaria, 1235));
    }

    @Test
    public void deveConsultarExtrato() {
        criaContas();

        contaDoJoao.sacar(100, 1234);
        boolean extrato = contaDoJoao.consultarExtrato(1234);

        assertTrue(extrato);
    }

    @Test
    public void deveReceberUmaSistemaExceptionPorSenhaInvalidaAoTentarConsultarExtrato() {
        criaContas();

        contaDoJoao.sacar(100, 1234);

        assertThrows(SistemaException.class, () -> contaDoJoao.consultarExtrato(1235));
    }
}