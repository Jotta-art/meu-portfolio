package br.com.jotabank.testes;

import br.com.jotabank.model.Conta;
import br.com.jotabank.model.ContaCorrente;
import br.com.jotabank.model.Endereco;
import br.com.jotabank.model.Titular;

import java.time.LocalDate;

public class TesteConta {
    public static void main(String[] args) {
        Endereco enderecoDoJoao = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        Titular joao = new Titular("João Pedro", "12345678900", 18, enderecoDoJoao);
        Conta contaDoJoao = new ContaCorrente(1, 1, joao, LocalDate.of(2020, 1, 8), LocalDate.of(2030, 1, 8), 123, 1234);

        contaDoJoao.depositar(20);

        contaDoJoao.sacar(10, 1234);

        contaDoJoao.depositar(200);

        contaDoJoao.consultarSaldo(1234);

        contaDoJoao.depositar(500);

        contaDoJoao.consultarSaldo(1234);

        Endereco enderecoDaMaria = new Endereco("Rua Carlos", 5, "08646347", "Vila Ana Maria", "Vila Prudente");
        Titular maria = new Titular("Maria das Dores", "07965312355", 34, enderecoDaMaria);
        Conta contaDaMaria = new ContaCorrente(1, 2, maria, LocalDate.of(2020, 01, 8), LocalDate.of(2035, 01, 8), 123, 4567);


        contaDoJoao.transferir(100, contaDaMaria, 1234);

        contaDoJoao.consultarSaldo(1234);

        contaDaMaria.consultarSaldo(4567);

        System.out.println();
        contaDoJoao.consultarExtrato(1234);

    }
}

