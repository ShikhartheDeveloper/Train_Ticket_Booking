package com.ShikharTheDeveloper.Train_Ticket_Booking.Controller;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.CoachType;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Service.CoachTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
public class CoachTypeController {

    @Autowired
    private CoachTypeService coachTypeService;

    @PostMapping("/create/coach")
    public CoachType createCoach(@RequestBody CoachType coach) {

        return coachTypeService.createCoachType(coach);
    }

    @GetMapping("/all")
    public List<CoachType> getAllCoaches() {

        return coachTypeService.getAllCoachType();

    }

    @GetMapping("/{id}")
    public CoachType getCoachById(@PathVariable Long id) {

        return coachTypeService.getCoachTypeById(id);

    }



}
