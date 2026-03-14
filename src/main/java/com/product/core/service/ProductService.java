package com.product.core.service;

import com.product.core.model.Product;
import com.product.core.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product updateQuantity(Long id, int newQuantity) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            Product product = optional.get();
            product.setQuantity(newQuantity);
            return productRepository.save(product);
        }
        throw new RuntimeException("Produit introuvable avec l'id : " + id);
    }

    public long countLowStockProducts() {
        return productRepository.findAll().stream()
                .filter(p -> p.getQuantity() <= 5)
                .count();
    }
}
