package com.ShikharTheDeveloper.Train_Ticket_Booking.Service;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.Booking;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.CoachType;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.Customer;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.TrainRoute;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Repositories.BookingRepository;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Repositories.CoachTypeRepository;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Repositories.CustomerRepository;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Repositories.TrainRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CoachTypeRepository coachTypeRepository;
    @Autowired
    private TrainRouteRepository trainRouteRepository;

    public Booking createBooking(Long customerId, Long routeId, Long coachId,
                                 LocalDate travelDate, LocalTime travelTime){
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        TrainRoute route = trainRouteRepository.findById(routeId).orElseThrow();
        CoachType coach = coachTypeRepository.findById(coachId).orElseThrow();

        double baseFare = route.getDistanceKM() * route.getPricePerKM();
        double totalFare = baseFare * coach.getPriceMultiplier();

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setTrainRoute(route);
        booking.setCoachType(coach);
        booking.setTravelDate(travelDate);
        booking.setTravelTime(travelTime);
        booking.setTotalFare(totalFare);

        String generatedPnr = "PNR"+ System.currentTimeMillis();
        booking.setPnrNumber(generatedPnr);

        return bookingRepository.save(booking);


    }
    public List<Booking> getBookingsByCustomer(Long customerId) {
        return bookingRepository.findByCustomer_Id(customerId);
    }

    public Booking getBookingById(Long bookingId) {

        return bookingRepository.findById(bookingId).orElseThrow();
    }

    public Booking getBookingByPnr(String pnr) {
        return bookingRepository.findByPnrNumber(pnr)
                .orElseThrow(() -> new RuntimeException("Booking not found for PNR: " + pnr));
    }


}
