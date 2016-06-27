package com.wmusial.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    public enum Status {NEW, IN_PROGRESS, COMPLETED, CANCELLED}

    private Long id;
    private Date createdDate;
    private BigDecimal totalPrice;
    private Status status;
    private List<Product> products;
    private Customer customer;

    public Order(Long id) {
        this.createdDate = new Date();
        this.status = Status.NEW;
        this.totalPrice = BigDecimal.ZERO;
        this.id = id;
        this.products = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", products=" + products +
                '}';
    }
}
