package com.hanish.ticketing_system.payment.dto;

import java.time.LocalDateTime;

public record PaymentResponseDTO(
        Long paymentId,
        Long bookingId,
        String status,
        LocalDateTime paymentTime
) {}
