package com.wmusial.dao;

import com.wmusial.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> findAll();
    Customer findById(Long id);
    Customer save(Customer customer);
    void delete(Long id);

}
