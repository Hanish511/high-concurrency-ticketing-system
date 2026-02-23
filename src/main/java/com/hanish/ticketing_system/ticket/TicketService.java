package com.hanish.ticketing_system.ticket;

import com.hanish.ticketing_system.ticket.dto.AddEventRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public List<Ticket> getAvailableTickets(){
        return ticketRepository.findByStatus(TicketStatus.AVAILABLE);
    }

    public void createTickets(AddEventRequest request){
        List<Ticket> tickets = new ArrayList<>();

        for(int i = 1; i <= request.numberOfTickets(); i++){
            tickets.add(
                    Ticket.builder()
                            .eventId(request.eventId())
                            .seatNumber(request.eventId()+": A-"+i)
                            .price(request.price())
                            .status(TicketStatus.AVAILABLE)
                            .build()
            );
        }
        ticketRepository.saveAll(tickets);
    }
}
