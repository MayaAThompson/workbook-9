package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    ProductDao dao;

    @Autowired
    public ProductService(ProductDao dao) {
        this.dao = dao;
    }

    public void addProduct(Product product) {
        this.dao.addProduct(product);
    }

    public List<Product> getProducts() {
        return this.dao.getAllProducts();
    }

    public void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
