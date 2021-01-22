package br.com.jotabank.model;

import br.com.jotabank.exceptions.SistemaException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bau {

    List<ContaPoupanca> bauDeContas = new ArrayList<>();

    public void adicionarConta(ContaPoupanca cp) {
        bauDeContas.add(cp);
    }

    public void compare(ContaPoupanca contaPoupanca) {
        List<String> listaDeCpfs = bauDeContas.stream().map(cp -> cp.titular.getCpf()).collect(Collectors.toList());
        if (listaDeCpfs.contains(contaPoupanca.titular.getCpf()))
            throw new SistemaException("Já existe uma conta poupança neste CPF!");
    }

    public List<ContaPoupanca> getBauDeContas() {
        return bauDeContas;
    }

}
