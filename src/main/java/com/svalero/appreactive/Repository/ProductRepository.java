package com.svalero.appreactive.Repository;

import com.svalero.appreactive.Domain.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
