package com.project.storemanagement.Rest;

import com.project.storemanagement.Entity.Product;
import com.project.storemanagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService theProductService){
        this.productService = theProductService;
    }

    @GetMapping("/products")
    public List<Product> findAllProduct(){
        return productService.findAll();
    }

    @GetMapping("/product/{productId}")
    public  Product getProduct(@PathVariable int productId){
        Product productDetails = productService.findById(productId);
        if(productDetails == null){
            throw  new RuntimeException(" product id : "+productId+ " not found");
        }else{
            return productDetails;
        }
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        product.setProductId(0);
       return productService.save(product);
    }

    @PutMapping("/product/{productId}")
    public  Product updateProduct(@RequestBody Product product ){
        return productService.save(product);
    }

    @DeleteMapping("/product/{productId}")
    public  String deleteProduct(@PathVariable int productId) {
        Product theProduct = productService.findById(productId);

        if (theProduct == null) {
            throw new RuntimeException("product not found to delete");
        }
        productService.delete(productId);
        return " the product with id :" + productId + " is deleted";
    }
}
