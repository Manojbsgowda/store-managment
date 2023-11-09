package com.project.storemanagement.Rest;

import com.project.storemanagement.DAO.CustomerDAO;
import com.project.storemanagement.Entity.Customer;
import com.project.storemanagement.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService theCustomerService) {
        this.customerService = theCustomerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    // add mapping for GET /customer/{customerId}
    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer theCustomer = customerService.findById(customerId);
        if (theCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }
        return theCustomer;
    }

    // add mapping for POST /customer - add  a customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {
        // also just in case they pass an id in JSON ... set it to 0

        // this is to force a save of new item ... instead of update
        theCustomer.setCustomer_id(0);
        Customer dbCustomer = customerService.save(theCustomer);
        return dbCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {
        return customerService.save(theCustomer);
    }

    @DeleteMapping("/customer/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer tempCustomer = customerService.findById(customerId);

        if (tempCustomer == null) {
            throw new RuntimeException("customer id not found - " + tempCustomer);
        }
        customerService.deleteById(customerId);
        return " deleted customer id - " + tempCustomer;
    }
}
