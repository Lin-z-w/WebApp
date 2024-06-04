package com.example.webapp.service;

import com.example.webapp.model.Product;
import com.example.webapp.repository.ProductRepository;
import com.example.webapp.rest.dto.OrderDto;
import com.example.webapp.rest.dto.OrderListDto;
import com.example.webapp.rest.dto.OrderListItemsInnerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final ProductRepository productRepository;

    @Autowired
    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @CacheEvict(value = "products", allEntries = true)
    @Transactional
    public void createOrder(OrderListDto orderListDto) {

        // 获取订单中所有商品的信息
        List<String> productIds = orderListDto.getItems().stream()
                .map(OrderListItemsInnerDto::getId)
                .collect(Collectors.toList());
        List<Product> products = productRepository.getProductByIds(productIds);

        // 检查每个商品的库存是否足够
        for (OrderListItemsInnerDto item : orderListDto.getItems()) {
            Product product = products.stream()
                    .filter(p -> p.getId().equals(item.getId()))
                    .findFirst()
                    .orElse(null);
            if (product == null || product.getQuantity() < item.getQuantity()) {
                throw new IllegalArgumentException("Product with ID " + item.getId() + " does not have enough stock.");
            }
        }

        // 如果所有商品库存足够，则逐个减少库存量
        for (OrderListItemsInnerDto item : orderListDto.getItems()) {
            Product product = products.stream()
                    .filter(p -> p.getId().equals(item.getId()))
                    .findFirst()
                    .orElse(null);
            if (product != null) {
                product.setQuantity(product.getQuantity() - item.getQuantity());
                productRepository.updateProductQuantity(product);
            }
        }

        // 在此处实现订单创建的逻辑，可能涉及到数据库的插入操作等

    }

}
