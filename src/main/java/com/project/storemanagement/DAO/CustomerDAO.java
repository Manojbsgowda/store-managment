package com.project.storemanagement.DAO;

import com.project.storemanagement.Entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAll();

    Customer findById(int theId);

    Customer save(Customer theCustomer);

    void  deleteById(int theId);
}
