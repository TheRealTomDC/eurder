package com.toms.domain.customer;

public class NotUniqueException extends RuntimeException {
    public NotUniqueException(String exception) {
        super(exception);
    }
}

