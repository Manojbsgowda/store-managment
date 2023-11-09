package com.project.storemanagement.Service;

import com.project.storemanagement.DAO.CustomerDAO;
import com.project.storemanagement.DAO.CustomerRepository;
import com.project.storemanagement.Entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSeriveImpl implements CustomerService {

    // private CustomerDAO customerDAO;

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerSeriveImpl(CustomerRepository theCustomerRepository) {
        this.customerRepository = theCustomerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        Customer customerDetails = null;
        if (result.isPresent()) {
            customerDetails = result.get();
        } else {
            throw new RuntimeException(" customer id not present");
        }

        return customerDetails;
    }

    @Transactional
    @Override
    public Customer save(Customer theCustomer) {
        return customerRepository.save(theCustomer);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }
}
