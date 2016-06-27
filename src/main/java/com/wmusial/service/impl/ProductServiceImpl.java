package com.wmusial.service.impl;

import com.wmusial.dao.ProductDao;
import com.wmusial.dao.impl.ProductDaoImpl;
import com.wmusial.model.Product;
import com.wmusial.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {

        //this.productDao = new ProductDaoImpl();
        this.productDao = productDao;
    }

    @Override
    public void addProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void displayProducts() {
        List<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public Product findById(Long productId) {
        return productDao.findById(productId);
    }
}
