package com.hanish.ticketing_system.booking;

import com.hanish.ticketing_system.ticket.Ticket;
import com.hanish.ticketing_system.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Ticket ticket;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime reservedAt;
    private LocalDateTime expiresAt;

}
