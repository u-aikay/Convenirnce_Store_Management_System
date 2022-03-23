package com.store.exception;

public class InsufficientFundException extends RuntimeException {
    public InsufficientFundException(String error) {
        super(error);
    }
}
