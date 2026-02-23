package com.hanish.ticketing_system.common;

import com.hanish.ticketing_system.booking.Booking;
import com.hanish.ticketing_system.booking.dto.BookingResponseDTO;
import com.hanish.ticketing_system.payment.Payment;
import com.hanish.ticketing_system.payment.dto.PaymentResponseDTO;
import com.hanish.ticketing_system.ticket.Ticket;
import com.hanish.ticketing_system.ticket.dto.TicketResponseDTO;

public class MapperUtil {

    public static BookingResponseDTO toBookingDTO(Booking booking){
        return new BookingResponseDTO(
                booking.getId(),
                booking.getTicket().getId(),
                booking.getTicket().getSeatNumber(),
                booking.getStatus().name()
        );
    }

    public static TicketResponseDTO toTicketDTO(Ticket ticket){
        return new TicketResponseDTO(
                ticket.getId(),
                ticket.getSeatNumber(),
                ticket.getStatus().name(),
                ticket.getPrice()
        );
    }

    public static PaymentResponseDTO toPaymentDTO(Payment payment){
        return new PaymentResponseDTO(
                payment.getId(),
                payment.getBooking().getId(),
                payment.getStatus().name(),
                payment.getPaymentTime()
        );
    }
}
