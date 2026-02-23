package com.hanish.ticketing_system.exception;

public class TicketNotAvailableException extends RuntimeException{
    public TicketNotAvailableException(String message){
        super(message);
    }
}
