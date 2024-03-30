package com.hypersrot.assignment.demo.service;

import com.hypersrot.assignment.demo.entity.Product;
import com.hypersrot.assignment.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    void saveTheProduct(Product p) {
        this.productRepository.save(p);
    }


}
