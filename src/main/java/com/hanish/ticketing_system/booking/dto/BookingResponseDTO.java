package com.hanish.ticketing_system.booking.dto;

public record BookingResponseDTO(
        Long bookingId,
        Long ticketId,
        String seatNumber,
        String status
) {}
