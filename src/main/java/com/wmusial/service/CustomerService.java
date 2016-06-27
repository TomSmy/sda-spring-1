package com.wmusial.service;

import com.wmusial.model.Customer;

public interface CustomerService {

    void register(Customer customer);

    Customer findById(Long customerId);

    void displayCustomers();
}
