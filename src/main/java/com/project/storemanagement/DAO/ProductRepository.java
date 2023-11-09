package com.project.storemanagement.DAO;

import com.project.storemanagement.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
