package br.com.jotabank.testes;

import br.com.jotabank.model.Conta;
import br.com.jotabank.model.ContaCorrente;
import br.com.jotabank.model.Endereco;
import br.com.jotabank.model.Titular;

import java.time.LocalDate;
import java.util.Scanner;

public class TesteContaComDadosDoConsole {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nome = sc.nextLine();
        String cpf = sc.next();
        int idade = sc.nextInt();
        String rua = sc.next();
        int numero = sc.nextInt();
        String cep = sc.next();
        String bairro = sc.next();
        String cidade = sc.next();
        int senha = sc.nextInt();


        Endereco enderecoDoJoao = new Endereco(rua, numero, cep, bairro, cidade);
        Titular joao = new Titular(nome, cpf, idade, enderecoDoJoao);
        Conta contaDoJoao = new ContaCorrente(1, 1, joao, LocalDate.of(2020, 1, 8), LocalDate.of(2030, 1, 8), 123, senha);

        contaDoJoao.depositar(20);

        contaDoJoao.sacar(10, sc.nextInt());

        contaDoJoao.consultarSaldo(sc.nextInt());

        contaDoJoao.consultarExtrato(sc.nextInt());

        System.out.println();

        System.out.println(contaDoJoao.titular.getNome());

        sc.close();
    }
}
