package com.ShikharTheDeveloper.Train_Ticket_Booking.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingRequest {

    private Long customerId;
    private Long routeId;
    private Long coachId;
    private LocalDate travelDate;
    private LocalTime travelTime;


    // Getters and setters
    public Long getCustomerId() {

        return customerId;
    }
    public void setCustomerId(Long customerId) {


        this.customerId = customerId;
    }
    public Long getRouteId() {

        return routeId;
    }
    public void setRouteId(Long routeId) {

        this.routeId = routeId;
    }
    public Long getCoachId() {

        return coachId;
    }
    public void setCoachId(Long coachId) {

        this.coachId = coachId;
    }

    public LocalDate getTravelDate() {

        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {

        this.travelDate = travelDate;
    }

    public LocalTime getTravelTime() {

        return travelTime;
    }

    public void setTravelTime(LocalTime travelTime) {

        this.travelTime = travelTime;
    }
}
