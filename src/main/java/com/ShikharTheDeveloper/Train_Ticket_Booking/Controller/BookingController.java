package com.ShikharTheDeveloper.Train_Ticket_Booking.Controller;

import com.ShikharTheDeveloper.Train_Ticket_Booking.DTO.BookingRequest;
import com.ShikharTheDeveloper.Train_Ticket_Booking.DTO.ResponseDto;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.Booking;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Service.BookingService;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @Autowired
    private PDFService pdfService;

    @PostMapping("/create/ticket")
    public ResponseEntity<ResponseDto> createBooking(@RequestBody BookingRequest bookingRequest) {
        Booking booking = bookingService.createBooking(
                bookingRequest.getCustomerId(),
                bookingRequest.getRouteId(),
                bookingRequest.getCoachId(),
                bookingRequest.getTravelDate(),
                bookingRequest.getTravelTime()
        );


        ResponseDto response = new ResponseDto(
                "Ticket booked successfully!",
                booking.getPnrNumber(),
                booking.getTravelDate(),
                booking.getTravelTime()
        );

        return ResponseEntity.ok(response);
    }

        @GetMapping("/{id}")
        public Booking getBooking (@PathVariable Long id){

            return bookingService.getBookingById(id);
        }

        @GetMapping("/customer/{customerId}")
        public List<Booking> getBookingsByCustomer (@PathVariable Long customerId){
            return bookingService.getBookingsByCustomer(customerId);
        }

    // 🆕 Download Ticket as PDF
    @GetMapping("/download/{pnr}")
    public ResponseEntity<byte[]> downloadTicket(@PathVariable String pnr) throws IOException {
        Booking booking = bookingService.getBookingByPnr(pnr); // 👈 Service se booking nikaalo

        ByteArrayInputStream pdfStream = pdfService.generateTicketPdf(booking);

        byte[] pdfBytes = pdfStream.readAllBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=ticket-" + pnr + ".pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }



    }
