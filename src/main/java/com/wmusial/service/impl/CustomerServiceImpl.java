package com.wmusial.service.impl;

import com.wmusial.dao.CustomerDao;
import com.wmusial.dao.impl.CustomerDaoImpl;
import com.wmusial.model.Customer;
import com.wmusial.service.CustomerService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {

        //this.customerDao = new CustomerDaoImpl();
        this.customerDao = customerDao;
    }

    @Override
    public void register(Customer customer) {
        customerDao.save(customer);
        System.out.println("Dodano klienta: " + customer.getFirstName() + " " + customer.getLastName());
    }

    @Override
    public Customer findById(Long customerId) {
        return customerDao.findById(customerId);
    }

    @Override
    public void displayCustomers() {
        List<Customer> customers = customerDao.findAll();

        for(Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
