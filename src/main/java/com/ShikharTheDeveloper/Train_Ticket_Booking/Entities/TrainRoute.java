package com.ShikharTheDeveloper.Train_Ticket_Booking.Entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class TrainRoute {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long routeId;
    private String departureStation;
    private String ArrivalStation;
    private double pricePerKM;
    private double distanceKM;

    @OneToMany(mappedBy = "trainRoute")
    private List<Booking> bookings;

    public TrainRoute() {
    }
    public TrainRoute(Long routeId, String departureStation,
                      String arrivalStation, double pricePerKM, double distanceKM) {
        this.routeId = routeId;
        this.departureStation = departureStation;
        ArrivalStation = arrivalStation;
        this.pricePerKM = pricePerKM;
        this.distanceKM = distanceKM;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return ArrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        ArrivalStation = arrivalStation;
    }

    public double getPricePerKM() {
        return pricePerKM;
    }

    public void setPricePerKM(double pricePerKM) {
        this.pricePerKM = pricePerKM;
    }

    public double getDistanceKM() {
        return distanceKM;
    }

    public void setDistanceKM(double distanceKM) {
        this.distanceKM = distanceKM;
    }
}
