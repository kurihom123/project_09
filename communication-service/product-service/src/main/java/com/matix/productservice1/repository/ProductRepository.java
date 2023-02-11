package com.matix.productservice1.repository;

import com.matix.productservice1.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}