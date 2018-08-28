package ru.anna.mytestpr.exceptions;

public class BusinessException extends RuntimeException {

    public BusinessException(String msg) {
        super(msg);
    }
}
