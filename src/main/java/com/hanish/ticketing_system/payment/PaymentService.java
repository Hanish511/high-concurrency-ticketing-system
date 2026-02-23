package com.hanish.ticketing_system.payment;

import com.hanish.ticketing_system.booking.Booking;
import com.hanish.ticketing_system.booking.BookingRepository;
import com.hanish.ticketing_system.booking.BookingStatus;
import com.hanish.ticketing_system.exception.BookingNotFoundException;
import com.hanish.ticketing_system.exception.PaymentFailedException;
import com.hanish.ticketing_system.ticket.Ticket;
import com.hanish.ticketing_system.ticket.TicketRepository;
import com.hanish.ticketing_system.ticket.TicketStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment processPayment(Long bookingId, boolean paymentSuccess){

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found."));

        Ticket ticket = booking.getTicket();

        if(booking.getStatus() != BookingStatus.PENDING){
            throw new PaymentFailedException("Booking already processed");
        }

        PaymentStatus status = paymentSuccess?PaymentStatus.SUCCESS:PaymentStatus.FAILED;

        Payment payment = Payment.builder()
                .booking(booking)
                .status(status)
                .paymentTime(LocalDateTime.now())
                .build();

        paymentRepository.save(payment);

        if(paymentSuccess){
            booking.setStatus(BookingStatus.CONFIRMED);
            ticket.setStatus(TicketStatus.SOLD);
        }
        else {
            booking.setStatus(BookingStatus.FAILED);
            ticket.setStatus(TicketStatus.AVAILABLE);
        }

        return payment;
    }

}
