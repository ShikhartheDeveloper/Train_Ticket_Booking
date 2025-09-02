package com.ShikharTheDeveloper.Train_Ticket_Booking.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalDate travelDate;
    private LocalTime travelTime;
    private double totalFare;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private TrainRoute trainRoute;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private CoachType coachType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String pnrNumber;

    public Booking() {
    }

    public Booking(Long bookingId, LocalDate travelDate,
                   LocalTime travelTime, double totalFare, TrainRoute trainRoute,
                   CoachType coachType, Customer customer) {
        this.bookingId = bookingId;
        this.travelDate = travelDate;
        this.travelTime = travelTime;
        this.totalFare = totalFare;
        this.trainRoute = trainRoute;
        this.coachType = coachType;
        this.customer = customer;
    }

    public Long getBookingId() {

        return bookingId;
    }

    public void setBookingId(Long bookingId) {

        this.bookingId = bookingId;
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

    public double getTotalFare() {

        return totalFare;
    }

    public void setTotalFare(double totalFare) {

        this.totalFare = totalFare;
    }

    public TrainRoute getTrainRoute()    {

        return trainRoute;
    }

    public void setTrainRoute(TrainRoute trainRoute) {

        this.trainRoute = trainRoute;
    }

    public CoachType getCoachType() {

        return coachType;
    }

    public void setCoachType(CoachType coachType) {

        this.coachType = coachType;
    }

    public Customer getCustomer() {

        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }
    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }
}
