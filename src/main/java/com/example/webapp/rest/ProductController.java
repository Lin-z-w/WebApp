package com.example.webapp.rest;

import com.example.webapp.mapper.ProductMapper;
import com.example.webapp.model.Product;
import com.example.webapp.rest.api.ProductApi;
import com.example.webapp.rest.dto.ProductDto;
import com.example.webapp.rest.dto.UploadProduct200ResponseDto;
import com.example.webapp.rest.dto.UploadProductRequestDto;
import com.example.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.webapp.mapper.ProductMapper.productToDto;

@RestController
public class ProductController implements ProductApi {
    @Autowired
    CacheManager cacheManager;

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<List<ProductDto>> listProducts() {
        System.out.println("ProductController.listProducts() called");
        List<ProductDto> productDtos = productService.getAllProducts().stream()
                .map(ProductMapper::productToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDtos);
    }

    @Override
    public ResponseEntity<ProductDto> showProductById(@PathVariable String productId) {
        System.out.println("ProductController.showProductById() called with productId: " + productId);
        Product product = productService.getProductById(productId);
        if (product != null) {
            ProductDto productDto = productToDto(product);
            return ResponseEntity.ok(productDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<ProductDto>> showProductsByCategory(String categoryName) {
        System.out.println("ProductController.showProductsByCategory() called with categoryName: " + categoryName);
        List<Product> products = productService.getProductsByCategory(categoryName);
        List<ProductDto> productDtos = products.stream()
                .map(ProductMapper::productToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDtos);
    }

    @Override
    public ResponseEntity<UploadProduct200ResponseDto> uploadProduct(UploadProductRequestDto uploadProductRequestDto) {
        System.out.println("ProductController.uploadProduct() called with uploadProductRequestDto: " + uploadProductRequestDto);
        productService.saveProduct(uploadProductRequestDto);
        UploadProduct200ResponseDto responseDto = new UploadProduct200ResponseDto();
        responseDto.code(1);
        responseDto.data("Product uploaded successfully");
        return ResponseEntity.ok(responseDto);
    }

    @RequestMapping(value = "/clearCache", method = RequestMethod.GET)
    public void clearCache() {
        cacheManager.getCache("product").clear();
    }
}
