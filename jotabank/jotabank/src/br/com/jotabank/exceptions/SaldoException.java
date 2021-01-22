package br.com.jotabank.exceptions;

public class SaldoException extends RuntimeException {
    public SaldoException(String msg) {
        super(msg);
    }
}
