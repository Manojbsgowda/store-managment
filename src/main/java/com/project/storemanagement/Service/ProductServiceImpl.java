package com.project.storemanagement.Service;

import com.project.storemanagement.DAO.ProductRepository;
import com.project.storemanagement.Entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
       // invoke the repository
       // inject with constructor injection
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository theProductRepository) {
        this.productRepository = theProductRepository;
    }

    @Override
    public List<Product> findAll() {

        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {

        Optional<Product> result = productRepository.findById(id);
        Product theProduct = null;
        if (result.isPresent()) {
            theProduct = result.get();
        } else {
            throw new RuntimeException("product id :" + id + " not found");
        }
        return theProduct;
    }


    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
