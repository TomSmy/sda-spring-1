package com.wmusial.dao.impl;

import com.wmusial.config.DatabaseConfig;
import com.wmusial.dao.CustomerDao;
import com.wmusial.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Repository
public class CustomerDaoImpl implements CustomerDao {

    private DatabaseConfig databaseConfig;
    private List<Customer> customers;


    public CustomerDaoImpl(DatabaseConfig databaseConfig) {
        this.databaseConfig =  databaseConfig;
       // this.databaseConfig = new DatabaseConfig();
        this.customers = new ArrayList<>();
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return  customer;
            }
        }
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public void delete(Long id) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getId().equals(id)) {
                iterator.remove();
            }
        }
    }
}
