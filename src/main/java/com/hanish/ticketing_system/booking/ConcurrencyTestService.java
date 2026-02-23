package com.hanish.ticketing_system.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class ConcurrencyTestService {

    private final BookingService bookingService;

    public void runTest(Long ticketId) throws InterruptedException {
        int numOfUsers = 100;

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        CountDownLatch latch = new CountDownLatch(numOfUsers);
        AtomicInteger successCount = new AtomicInteger();
        AtomicInteger failureCount = new AtomicInteger();

        for(int i = 0; i < numOfUsers; i++){
            Long userId = 1L;

            executorService.submit(() -> {
               try {
                   bookingService.purchaseTicket(userId, ticketId);
                   successCount.incrementAndGet();
               } catch (Exception e){
                   failureCount.incrementAndGet();
               } finally {
                   latch.countDown();
               }
            });
        }
        latch.await();

        System.out.println("Success : "+successCount);
        System.out.println("Failed : "+failureCount);

        executorService.shutdown();
    }

}
