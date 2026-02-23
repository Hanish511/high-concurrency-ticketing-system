package com.hanish.ticketing_system.booking;

import com.hanish.ticketing_system.booking.dto.BookingResponseDTO;
import com.hanish.ticketing_system.common.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/purchase")
    public BookingResponseDTO purchaseTicket(@RequestParam Long userId, @RequestParam Long ticketId){
        Booking booking = bookingService.purchaseTicket(userId, ticketId);
        return MapperUtil.toBookingDTO(booking);
    }

}
