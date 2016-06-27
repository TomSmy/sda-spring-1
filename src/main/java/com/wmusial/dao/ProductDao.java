package com.wmusial.dao;

import com.wmusial.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void delete(Long id);
}
