package com.hanish.ticketing_system.exception;

public class PaymentFailedException extends RuntimeException{
    public PaymentFailedException(String message){
        super(message);
    }
}
