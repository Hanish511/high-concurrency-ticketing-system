package com.hanish.ticketing_system.ticket;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long eventId;
    private String seatNumber;
    private Double price;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Version
    private Long version;
}
