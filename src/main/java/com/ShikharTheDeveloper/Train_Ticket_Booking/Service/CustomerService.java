package com.ShikharTheDeveloper.Train_Ticket_Booking.Service;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.Customer;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow();
    }
}
