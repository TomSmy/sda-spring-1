package com.wmusial.dao.impl;

import com.wmusial.config.DatabaseConfig;
import com.wmusial.dao.ProductDao;
import com.wmusial.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private DatabaseConfig databaseConfig;
    private List<Product> products = new ArrayList<>();

    public ProductDaoImpl(DatabaseConfig databaseConfig) {

        //this.databaseConfig = new DatabaseConfig();
        this.databaseConfig = databaseConfig;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        for(Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(id)) {
                iterator.remove();
            }
        }
    }
}
