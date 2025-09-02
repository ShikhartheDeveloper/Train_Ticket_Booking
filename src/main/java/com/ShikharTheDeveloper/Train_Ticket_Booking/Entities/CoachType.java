package com.ShikharTheDeveloper.Train_Ticket_Booking.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CoachType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coachId;

    private String coachName;
    private double priceMultiplier;

    @OneToMany(mappedBy = "coachType")
    private List<Booking> bookings;

    public CoachType() {
    }

    public CoachType(Long coachId, String coachName, double priceMultiplier) {
        this.coachId = coachId;
        this.coachName = coachName;
        this.priceMultiplier = priceMultiplier;
    }

    public Long getCoachId() {

        return coachId;
    }

    public void setCoachId(Long coachId) {

        this.coachId = coachId;
    }

    public String getCoachName() {

        return coachName;
    }

    public void setCoachName(String coachName) {

        this.coachName = coachName;
    }

    public double getPriceMultiplier() {

        return priceMultiplier;
    }

    public void setPriceMultiplier(double priceMultiplier) {

        this.priceMultiplier = priceMultiplier;
    }
}
