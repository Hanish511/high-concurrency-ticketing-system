package com.hanish.ticketing_system.ticket.dto;

public record AddEventRequest(
        Long eventId,
        int numberOfTickets,
        double price
) {
}
