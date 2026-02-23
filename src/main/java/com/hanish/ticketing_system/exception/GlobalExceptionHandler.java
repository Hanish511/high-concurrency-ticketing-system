package com.hanish.ticketing_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUser(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "error", ex.getMessage(),
                        "time", LocalDateTime.now()
                ));
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<?> handleBooking(BookingNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "error", ex.getMessage(),
                        "time", LocalDateTime.now()
                ));
    }

    @ExceptionHandler(TicketNotAvailableException.class)
    public ResponseEntity<?> handleTicket(TicketNotAvailableException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", ex.getMessage(),
                        "time", LocalDateTime.now()
                ));
    }

    @ExceptionHandler(PaymentFailedException.class)
    public ResponseEntity<?> handlePayment(PaymentFailedException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", ex.getMessage(),
                        "time", LocalDateTime.now()
                ));
    }

}
