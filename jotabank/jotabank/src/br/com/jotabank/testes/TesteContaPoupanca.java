package br.com.jotabank.testes;

import br.com.jotabank.model.*;

import java.time.LocalDate;

public class TesteContaPoupanca {
    public static void main(String[] args) {
        Endereco enderecoDaMaria = new Endereco("Rua Carlos", 5, "08646347", "Vila Ana Maria", "Vila Prudente");
        Titular maria = new Titular("Maria das Dores", "07965312355", 34, enderecoDaMaria);
        ContaPoupanca contaDaMaria = new ContaPoupanca(1, 2, maria, LocalDate.of(2020, 01, 8), LocalDate.of(2035, 01, 8), 123, 4567);

        contaDaMaria.guardar(200);

        contaDaMaria.consultarPoupanca(4567);

        Endereco enderecoDoJoao = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        Titular joao = new Titular("João Pedro", "12345678900", 18, enderecoDoJoao);
        Conta contaDoJoao = new ContaCorrente(1, 1, joao, LocalDate.of(2020, 01, 8), LocalDate.of(2030, 01, 8), 123, 1234);

        contaDaMaria.transferir(200, contaDoJoao, 1234);

    }
}
