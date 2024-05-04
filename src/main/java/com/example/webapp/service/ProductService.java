package com.example.webapp.service;

import com.example.webapp.model.Product;
import com.example.webapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "products")
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    @Cacheable(value = "categories")
    public List<String> getAllCategories() {
        return productRepository.getAllProducts().stream()
                .map(Product::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }
}
