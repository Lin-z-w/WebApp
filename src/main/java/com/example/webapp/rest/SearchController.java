package com.example.webapp.rest;

import com.example.webapp.mapper.ProductMapper;
import com.example.webapp.model.Product;
import com.example.webapp.rest.api.SearchApi;
import com.example.webapp.rest.dto.ProductDto;
import com.example.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController implements SearchApi {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<List<ProductDto>> searchProductsByKeyword(String keyword) {
        System.out.println("Searching for products with keyword: " + keyword);
        List<Product> products = productService.searchProductsByName(keyword);
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(ProductMapper.productToDto(product));
        }
        return ResponseEntity.ok(productDtos);
    }
}


