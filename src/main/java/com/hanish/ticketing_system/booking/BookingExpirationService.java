package com.hanish.ticketing_system.booking;

import com.hanish.ticketing_system.ticket.Ticket;
import com.hanish.ticketing_system.ticket.TicketStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingExpirationService {

    private final BookingRepository bookingRepository;

    @Transactional
    @Scheduled(fixedRate = 60000)
    public void expireBookings(){

        List<Booking> expiredBookings = bookingRepository.findExpiredBookings(LocalDateTime.now());

        for(Booking booking: expiredBookings){
            booking.setStatus(BookingStatus.EXPIRED);

            Ticket ticket = booking.getTicket();
            ticket.setStatus(TicketStatus.AVAILABLE);

            System.out.println("Expired booking: "+ booking.getId());
        }

    }
}
