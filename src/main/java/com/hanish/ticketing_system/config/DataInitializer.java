//For populating database with initial set of data



//package com.hanish.ticketing_system.config;
//
//import com.hanish.ticketing_system.ticket.Ticket;
//import com.hanish.ticketing_system.ticket.TicketRepository;
//import com.hanish.ticketing_system.ticket.TicketStatus;
//import com.hanish.ticketing_system.user.User;
//import com.hanish.ticketing_system.user.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class DataInitializer implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final TicketRepository ticketRepository;
//
//    @Override
//    public void run(String... args){
//
//        if(ticketRepository.count() == 0) {
//            List<Ticket> tickets = new ArrayList<>();
//
//            for(int i = 1; i <= 50; i++){
//                tickets.add(
//                        Ticket.builder()
//                                .eventId(1L)
//                                .seatNumber("A-"+i)
//                                .price(1000.0)
//                                .status(TicketStatus.AVAILABLE)
//                                .build()
//                );
//            }
//
//            ticketRepository.saveAll(tickets);
//            System.out.println("50 tickets created.");
//        }
//
//        if(userRepository.count() == 0){
//            userRepository.save(
//                    User.builder()
//                            .name("Jimmy")
//                            .email("jim@gmail.com")
//                            .build()
//            );
//            System.out.println("1 user created.");
//        }
//    }
//
//}
