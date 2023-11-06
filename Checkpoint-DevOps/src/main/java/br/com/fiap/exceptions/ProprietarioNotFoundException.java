package br.com.fiap.exceptions;

public class ProprietarioNotFoundException extends RuntimeException {
    public ProprietarioNotFoundException(String message) {
        super(message);
    }
}
