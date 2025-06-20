package com.pluralsight.NorthwindTradersSpringBoot.daos;

import com.pluralsight.NorthwindTradersSpringBoot.dtos.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

//@Component
public class SimpleProductDao implements ProductDao{

    private List<Product> products;

    @Autowired
    public SimpleProductDao() {
        products = new ArrayList<>();
        products.add(new Product(1, "Basketball", "Sports", 12.99));
        products.add(new Product(2, "Tent", "Camping", 35.95));
        products.add(new Product(3, "Northwind T-Shirt", "Apparel", 14.99));
    }

    @Override
    public boolean addProduct(Product product) {
        return this.products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.products;
    }

    @Override
    public List<Product> searchProduct(String search) {
        List<Product> matches = null;
        for (Product product : this.products) {
            if (product.getName().toLowerCase().contains(search.toLowerCase()))
                matches.add(product);
        }
        return matches;
    }

    @Override
    public int deleteProduct(Product product) {
        if (this.products.remove(product))
            return 1;
        else
            return 0;
    }

    @Override
    public boolean editProduct(Product product) {
        return false;
    }

    public void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
