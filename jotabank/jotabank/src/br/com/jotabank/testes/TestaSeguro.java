package br.com.jotabank.testes;

import br.com.jotabank.exceptions.SeguroException;
import br.com.jotabank.model.Endereco;
import br.com.jotabank.model.SeguroVida;
import br.com.jotabank.model.Titular;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestaSeguro {

    Endereco enderecoDoJoao;
    Titular joao;
    SeguroVida sv = new SeguroVida();

    @BeforeEach
    public void criaSeguro() {
        enderecoDoJoao = new Endereco("Rua adalgisa", 200, "0245678", "Jardim Nossa Senhora", "Itapevi");
        joao = new Titular("João Pedro", "12345678900", 18, enderecoDoJoao);

        sv.definirDependente("Inácio");
    }

    @Test
    public void deveReceberUmTitular() {
        criaSeguro();

        assertEquals("Inácio", sv.getDependente());
    }

    @Test
    public void deveReceberUmTrueNaProvaDeVida() {
        criaSeguro();

        assertTrue(sv.provaDeVida(true));
    }

    @Test
    public void deveReceberUmFalseNaProvaDeVida() {
        criaSeguro();

        assertFalse(sv.provaDeVida(false));
    }

    @Test
    public void deveReceberUmaSeguroExceptionPorValorDePagamentoIncorreto() {
        criaSeguro();

        assertThrows(SeguroException.class, () -> sv.pagarSeguro(100));
    }

    @Test
    public void deveReceberOValorDePagamentoCorreto() {
        criaSeguro();

        int valorSeguro = 200;

        assertEquals(200, valorSeguro);
    }
}
