package com.example.webapp.rest;

import com.example.webapp.rest.api.CategoriesApi;
import com.example.webapp.rest.dto.ProductDto;
import com.example.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CategoriesController implements CategoriesApi {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<List<ProductDto>> showProductsByCategory(String categoryName) {
        return CategoriesApi.super.showProductsByCategory(categoryName);
    }
}
