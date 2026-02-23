package com.hanish.ticketing_system.payment;

import com.hanish.ticketing_system.common.MapperUtil;
import com.hanish.ticketing_system.payment.dto.PaymentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/process")
    public PaymentResponseDTO processPayment(@RequestParam Long bookingId, @RequestParam boolean success){
        Payment payment = paymentService.processPayment(bookingId, success);
        return MapperUtil.toPaymentDTO(payment);
    }

}
