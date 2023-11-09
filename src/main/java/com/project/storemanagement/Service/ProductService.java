package com.project.storemanagement.Service;

import com.project.storemanagement.Entity.Product;

import java.util.List;

public interface ProductService {

    // find all product
    // find by id product
    // save product
    // delete product

    List<Product> findAll();

    Product findById(int id);

    Product save(Product product);

    void delete(int id);

}
