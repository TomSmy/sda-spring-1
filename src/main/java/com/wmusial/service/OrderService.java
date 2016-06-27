package com.wmusial.service;

import com.wmusial.model.Order;

public interface OrderService {
    void addOrder(Long customerId, Order order);

    void addProductsToOrder(Long productId, Long orderId);

    void calculateTotal(Long orderId);

    void startProcessing(Long orderId);
}
