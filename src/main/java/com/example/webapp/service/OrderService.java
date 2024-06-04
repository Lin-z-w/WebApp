package com.example.webapp.service;

import com.example.webapp.model.Order;
import com.example.webapp.model.Product;
import com.example.webapp.model.User;
import com.example.webapp.repository.OrderRepository;
import com.example.webapp.repository.ProductRepository;
import com.example.webapp.repository.UserRepository;
import com.example.webapp.rest.dto.OrderListDto;
import com.example.webapp.rest.dto.OrderListItemsInnerDto;
import com.example.webapp.utils.DateUtils;
import com.example.webapp.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final ProductRepository productRepository;

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    @Autowired
    public OrderService(ProductRepository productRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

//    @CacheEvict(value = "products", allEntries = true)
    @Transactional
    public void createOrder(OrderListDto orderListDto) {
        String username = orderListDto.getUsername();
        User user = userRepository.findByUsername(username);

        // 获取订单中所有商品的信息
        List<String> productIds = orderListDto.getItems().stream()
                .map(OrderListItemsInnerDto::getId)
                .toList();
        List<Product> products = productIds.stream()
                .map(productRepository::getProductById)
                .toList();

        // 检查每个商品的库存是否足够
        for (OrderListItemsInnerDto item : orderListDto.getItems()) {
            Product product = products.stream()
                    .filter(p -> p.getId().equals(item.getId()))
                    .findFirst()
                    .orElse(null);
            if (product == null || product.getStock() < item.getQuantity()) {
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
                product.setStock(product.getStock() - item.getQuantity());
                productRepository.updateProductQuantity(product);
                // 订单创建
                String orderId = IDUtils.generateUniqueId();
                String orderDate = DateUtils.getCurrentDate();
                double totalPrice = item.getQuantity() * product.getPrice();
                Order order = new Order(orderId, username, orderDate, product.getName(), item.getQuantity(), totalPrice, user.getAddress(), user.getPhone(), product.getImg());
                orderRepository.save(order);
                // 更新用户余额
                user.setBalance(user.getBalance() - totalPrice);
                userRepository.updateUserBalance(user);
            }
        }


    }

    public List<Order> getOrderList(String username) {
        return orderRepository.findByUsername(username);
    }
}
