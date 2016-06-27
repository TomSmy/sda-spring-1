package com.wmusial.dao;

import com.wmusial.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAll();
    Order findById(Long id);
    Order save(Order order);
    void delete(Long id);
}
