package com.ShikharTheDeveloper.Train_Ticket_Booking.Repositories;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
