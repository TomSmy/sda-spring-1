package com.wmusial.service.impl;

import com.wmusial.dao.OrderDao;
import com.wmusial.dao.impl.OrderDaoImpl;
import com.wmusial.model.Customer;
import com.wmusial.model.Order;
import com.wmusial.model.Product;
import com.wmusial.service.CustomerService;
import com.wmusial.service.OrderService;
import com.wmusial.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private CustomerService customerService;
    private ProductService productService;


    public OrderServiceImpl(CustomerService customerService, ProductService productService, OrderDao orderDao) {
        this.customerService = customerService;
        this.productService = productService;
       // this.orderDao = new OrderDaoImpl();
        this.orderDao = orderDao;
    }

    @Override
    public void addOrder(Long customerId, Order order) {
        Customer customer = customerService.findById(customerId);
        customer.addOrder(order);
        orderDao.save(order);
    }

    @Override
    public void addProductsToOrder(Long productId, Long orderId) {
        Order order = orderDao.findById(orderId);
        Product product = productService.findById(productId);
        order.addProduct(product);
    }

    @Override
    public void calculateTotal(Long orderId) {
        Order order = orderDao.findById(orderId);
        List<Product> products = order.getProducts();
        BigDecimal total = BigDecimal.ZERO;
        for(Product product : products) {
            total = total.add(product.getPrice());
        }
        order.setTotalPrice(total);
    }

    @Override
    public void startProcessing(Long orderId) {
        Order order = orderDao.findById(orderId);
        order.setStatus(Order.Status.IN_PROGRESS);
    }
}
