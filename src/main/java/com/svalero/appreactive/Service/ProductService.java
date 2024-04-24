package com.svalero.appreactive.Service;

import com.svalero.appreactive.Domain.Product;
import com.svalero.appreactive.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }

    public Mono<Product> updateProduct(String id, Product product) {
        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setPrice(product.getPrice());
                    return productRepository.save(existingProduct);
                });
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }
}
