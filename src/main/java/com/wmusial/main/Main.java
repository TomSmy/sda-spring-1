package com.wmusial.main;

import com.wmusial.config.AppConfig;
import com.wmusial.model.Customer;
import com.wmusial.model.Order;
import com.wmusial.model.Product;
import com.wmusial.service.CustomerService;
import com.wmusial.service.OrderService;
import com.wmusial.service.ProductService;
import com.wmusial.service.impl.CustomerServiceImpl;
import com.wmusial.service.impl.OrderServiceImpl;
import com.wmusial.service.impl.ProductServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        //obiekt springowy
        //ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        ProductService productService = applicationContext.getBean("productService", ProductService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        // create some products
        productService.addProduct(new Product(1L, "TV Sony", new BigDecimal("1540.2")));
        productService.addProduct(new Product(2L, "Apple Mac Book Pro", new BigDecimal("5560.2")));
        productService.addProduct(new Product(3L, "Samsung Galaxy S7", new BigDecimal("3240.2")));

        // show products
        productService.displayProducts();

        // register new customer
        customerService.register(new Customer(1L, "Jan", "Kowalski", "kowal@onet.pl"));

        // show customers
        customerService.displayCustomers();

        // create new order
        orderService.addOrder(1L, new Order(1L));

        // add some products to order
        orderService.addProductsToOrder(1L, 1L);
        orderService.addProductsToOrder(3L, 1L);

        // calculate order total
        orderService.calculateTotal(1L);

        // start order processing
        orderService.startProcessing(1L);

        // show orders for customer 1L
        Customer customer = customerService.findById(1L);
        customer.displayOrders();

    }
}
