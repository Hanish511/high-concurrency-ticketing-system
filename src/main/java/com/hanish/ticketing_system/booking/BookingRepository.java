package com.hanish.ticketing_system.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("""
            SELECT b FROM Booking b
            WHERE b.status = 'PENDING'
            AND b.expiresAt <= :time
            """)
    List<Booking> findExpiredBookings(LocalDateTime time);

    long countByUserIdAndStatus(Long userId, BookingStatus status);

}
