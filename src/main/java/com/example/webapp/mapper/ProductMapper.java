package com.example.webapp.mapper;

import com.example.webapp.rest.dto.ProductDto;
import com.example.webapp.model.Product;

public class ProductMapper {

    public static ProductDto productToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory());
        productDto.setQuantity(product.getQuantity());
        productDto.setName(product.getName());
        productDto.setStock(product.getStock());
        productDto.setImg(product.getImg());
        return productDto;
    }

    public static Product dtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setQuantity(productDto.getQuantity());
        product.setName(productDto.getName());
        product.setStock(productDto.getStock());
        product.setImg(productDto.getImg());
        return product;
    }
}
