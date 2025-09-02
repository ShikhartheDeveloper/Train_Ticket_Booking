package com.ShikharTheDeveloper.Train_Ticket_Booking.Repositories;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.TrainRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRouteRepository extends JpaRepository<TrainRoute,Long> {
}
