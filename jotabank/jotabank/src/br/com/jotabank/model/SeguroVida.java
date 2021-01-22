package br.com.jotabank.model;

import br.com.jotabank.Exceptions.SeguroException;

public class SeguroVida {
    private Titular titular;
    private String dependente;

    public void definirDependente(String dependente) {
        this.dependente = dependente;
    }

    public String getDependente() {
        return dependente;
    }

    public boolean provaDeVida(boolean clienteEstaVivo) {
        final int valor = 200;
        if (clienteEstaVivo) {
            System.out.println("Pague o seguro! Valor: " + valor);
            return true;
        } else {
            System.out.println("O prêmio do seguro será pago para o/a " + this.dependente);
            return false;
        }
    }

    public void pagarSeguro(int valor) {
        final int valorSeguro = 200;
        if (valor != valorSeguro) throw new SeguroException("Valor Incorreto!");
        else if (provaDeVida(false)) throw new SeguroException("Titular morto!");
        else System.out.println("Pagamento Realizado!");
    }
}
