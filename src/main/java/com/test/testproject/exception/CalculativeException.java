package com.test.testproject.exception;

public class CalculativeException extends ArithmeticException {
    public CalculativeException(String message) {
        super("ERROR Code - 1002 :"+message);
    }
}
