package com.ShikharTheDeveloper.Train_Ticket_Booking.Controller;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.TrainRoute;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Service.TrainRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class TrainRouteController {

    @Autowired
    private TrainRouteService  trainRouteService;

    @PostMapping("/create/route")
    public TrainRoute createRoute(@RequestBody TrainRoute route) {

        return trainRouteService.createTrainRoute(route);

    }

    @GetMapping("/all")
    public List<TrainRoute> getAllRoutes() {
        return trainRouteService.getAllTrainRoute();

    }

    @GetMapping("/{id}")
    public TrainRoute getRouteById(@PathVariable Long id) {

        return trainRouteService.findTrainRouteById(id);

    }
}
