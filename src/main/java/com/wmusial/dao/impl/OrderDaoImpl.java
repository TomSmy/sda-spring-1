package com.wmusial.dao.impl;

import com.wmusial.config.DatabaseConfig;
import com.wmusial.dao.OrderDao;
import com.wmusial.model.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private DatabaseConfig databaseConfig;
    private List<Order> orders = new ArrayList<>();

    public OrderDaoImpl(DatabaseConfig databaseConfig) {

        //this.databaseConfig = new DatabaseConfig();
        this.databaseConfig = databaseConfig;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public Order findById(Long id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public void delete(Long id) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getId().equals(id)) {
                iterator.remove();
            }
        }
    }
}
