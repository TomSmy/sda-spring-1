package com.wmusial.service;

import com.wmusial.model.Product;

public interface ProductService {
    void addProduct(Product product);

    void displayProducts();

    Product findById(Long productId);
}
