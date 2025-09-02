package com.ShikharTheDeveloper.Train_Ticket_Booking.Service;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.TrainRoute;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Repositories.TrainRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainRouteService {

    @Autowired
    private TrainRouteRepository trainRouteRepository;

    public TrainRoute createTrainRoute(TrainRoute  trainRoute){
        return trainRouteRepository.save(trainRoute);
    }

    public List<TrainRoute> getAllTrainRoute(){
        return trainRouteRepository.findAll();
    }

    public TrainRoute findTrainRouteById(Long id){
        return trainRouteRepository.findById(id).orElseThrow();
    }

}
