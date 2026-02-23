package com.hanish.ticketing_system.ticket.dto;

public record TicketResponseDTO(
        Long id,
        String seatNumber,
        String status,
        Double price
) {}
