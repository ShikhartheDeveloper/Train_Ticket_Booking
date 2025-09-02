package com.ShikharTheDeveloper.Train_Ticket_Booking.Repositories;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByCustomer_Id(Long customerId);
    Optional<Booking> findByPnrNumber(String pnrNumber);
}
