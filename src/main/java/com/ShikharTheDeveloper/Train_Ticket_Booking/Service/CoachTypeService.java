package com.ShikharTheDeveloper.Train_Ticket_Booking.Service;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.CoachType;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Repositories.CoachTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachTypeService {

    @Autowired
    private CoachTypeRepository coachTypeRepository;

    public CoachType createCoachType(CoachType coachType){

        return coachTypeRepository.save(coachType);
    }

    public List<CoachType> getAllCoachType(){

        return coachTypeRepository.findAll();
    }

    public CoachType getCoachTypeById(Long id){

        return coachTypeRepository.findById(id).orElseThrow();
    }

}
