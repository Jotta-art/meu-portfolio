package br.com.jotabank.exceptions;

public class SistemaException extends RuntimeException {
    public SistemaException(String msg) {
        super(msg);
    }
}
