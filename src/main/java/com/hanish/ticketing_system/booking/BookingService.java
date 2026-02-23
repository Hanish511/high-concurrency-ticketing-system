package com.hanish.ticketing_system.booking;

import com.hanish.ticketing_system.exception.TicketNotAvailableException;
import com.hanish.ticketing_system.exception.UserNotFoundException;
import com.hanish.ticketing_system.ticket.Ticket;
import com.hanish.ticketing_system.ticket.TicketRepository;
import com.hanish.ticketing_system.ticket.TicketStatus;
import com.hanish.ticketing_system.user.User;
import com.hanish.ticketing_system.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final TicketRepository ticketRepository;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    @Transactional
    public Booking purchaseTicket(Long userId, Long ticketId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        Ticket ticket = ticketRepository.findByIdForUpdate(ticketId)
                .orElseThrow(() -> new TicketNotAvailableException("Ticket not found!"));

        if(ticket.getStatus() != TicketStatus.AVAILABLE){
            throw new TicketNotAvailableException("Ticket already reserved or sold.");
        }

        long confirmedBookings = bookingRepository.countByUserIdAndStatus(userId, BookingStatus.CONFIRMED);
        if(confirmedBookings >= 4){
            throw new TicketNotAvailableException("User ticket limit exceeded");
        }

        ticket.setStatus(TicketStatus.RESERVED);

        Booking booking = Booking.builder()
                .user(user)
                .ticket(ticket)
                .status(BookingStatus.PENDING)
                .reservedAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(1))
                .build();

        bookingRepository.save(booking);
        return booking;
    }
}
