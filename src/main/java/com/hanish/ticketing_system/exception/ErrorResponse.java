package com.hanish.ticketing_system.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        String error,
        int status,
        LocalDateTime time
) {}
