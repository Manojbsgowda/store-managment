package com.project.storemanagement.Service;

import com.project.storemanagement.Entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int theId);

    Customer save(Customer theCustomer);

    void deleteById(int theId);
}
