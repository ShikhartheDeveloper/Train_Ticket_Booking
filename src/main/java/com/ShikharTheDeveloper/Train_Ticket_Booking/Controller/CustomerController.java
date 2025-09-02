package com.ShikharTheDeveloper.Train_Ticket_Booking.Controller;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.Customer;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add/user")
    public Customer createCustomer(@RequestBody Customer customer){

        return customerService.createCustomer(customer);

    }

    @GetMapping("/all")
    public List<Customer> getAllCustomer(){

        return customerService.getAllCustomer();

    }


    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable long id){

        return customerService.getCustomerById(id);

    }


}
