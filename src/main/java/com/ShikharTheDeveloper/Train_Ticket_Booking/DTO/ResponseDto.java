package com.ShikharTheDeveloper.Train_Ticket_Booking.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ResponseDto {

    private String message;
    private String pnrNumber;
    private LocalDate localDate;
    private LocalTime localTime;

    public ResponseDto() {

    }

    public ResponseDto(String message, String pnrNumber, LocalDate localDate, LocalTime localTime) {
        this.message = message;
        this.pnrNumber = pnrNumber;
        this.localDate = localDate;
        this.localTime = localTime;
    }

    public String getMessage() {

        return message;

    }

    public String getPnrNumber() {

        return pnrNumber;

    }

    public LocalDate getLocalDate() {

        return localDate;

    }

    public LocalTime getLocalTime() {

        return localTime;

    }
}
