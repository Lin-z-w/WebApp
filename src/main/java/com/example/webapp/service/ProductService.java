package com.example.webapp.service;

import com.example.webapp.model.Product;
import com.example.webapp.repository.ProductRepository;
import com.example.webapp.rest.dto.UploadProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.webapp.utils.IDUtils.generateUniqueId;

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

    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.getProductsByCategory(categoryName);
    }

    public void saveProduct(UploadProductRequestDto uploadProductRequestDto) {
        Product product = new Product();
        product.setId(generateUniqueId());
        product.setName(uploadProductRequestDto.getName());
        product.setPrice(uploadProductRequestDto.getPrice());
        product.setCategory(uploadProductRequestDto.getCategory());
        productRepository.saveProduct(product);
    }

//    @Cacheable(value = "categories")
//    public List<String> getAllCategories() {
//        return productRepository.getAllProducts().stream()
//                .map(Product::getCategory)
//                .distinct()
//                .collect(Collectors.toList());
//    }

//    public List<Product> searchProductsByName(String name) {
//        return productRepository.findByNameContaining(name);
//    }
}
