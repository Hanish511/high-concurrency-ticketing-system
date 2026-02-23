package com.hanish.ticketing_system.ticket;

import com.hanish.ticketing_system.common.MapperUtil;
import com.hanish.ticketing_system.ticket.dto.AddEventRequest;
import com.hanish.ticketing_system.ticket.dto.TicketResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/available")
    public List<TicketResponseDTO> getAvailableTickets(){
        return ticketService.getAvailableTickets()
                .stream()
                .map(MapperUtil::toTicketDTO)
                .toList();
    }

    @PostMapping("/create")
    public String createTickets(@RequestBody AddEventRequest request){
        ticketService.createTickets(request);
        return "Tickets created successfully";
    }
}
