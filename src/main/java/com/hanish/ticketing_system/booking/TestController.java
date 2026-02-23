package com.hanish.ticketing_system.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final ConcurrencyTestService concurrencyTestService;

    @PostMapping("/concurrency")
    public String testConcurrency(@RequestParam Long ticketId) throws InterruptedException {
        concurrencyTestService.runTest(ticketId);
        return "Concurrency test completed. Check logs.";
    }
}
