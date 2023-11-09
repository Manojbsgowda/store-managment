package com.project.storemanagement.DAO;

import com.project.storemanagement.Entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerImpl implements CustomerDAO{
    //define field for entity manager
    // set up constructor injection

    private EntityManager entityManager;

    @Autowired
    public  CustomerImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public List<Customer> findAll() {

        //create a query
        // exeucte and get result from query
        //return results
        TypedQuery<Customer> theQuery = entityManager.createQuery("from Customer",Customer.class);
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    public Customer findById(int theId) {
        // get customer
        Customer theCustomer = entityManager.find(Customer.class,theId);
        // return customer based on id
        return theCustomer;
    }

    @Override
    public Customer save(Customer theCustomer) {
        Customer dbCustomer = entityManager.merge(theCustomer);
        return dbCustomer;
    }

    @Override
    public void deleteById(int theId) {
        //find based on id
        Customer theCustomer = entityManager.find(Customer.class,theId);
        // delete
        entityManager.remove(theCustomer);

    }
}
