package com.example.webapp.rest;

import com.example.webapp.rest.api.CategoriesApi;
import com.example.webapp.rest.dto.CategoryDto;
import com.example.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoriesController implements CategoriesApi {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<String> categories = productService.getAllCategories();
        List<CategoryDto> categoryDtoList = categories.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        System.out.println("listCategories() called");
        return ResponseEntity.ok(categoryDtoList);
    }

    private CategoryDto convertToDto(String category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category); // 这里先将类别名称作为ID
        categoryDto.setName(category);
        return categoryDto;
    }
}
