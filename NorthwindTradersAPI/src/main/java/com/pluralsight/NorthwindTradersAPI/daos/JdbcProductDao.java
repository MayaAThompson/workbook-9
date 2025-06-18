package com.pluralsight.NorthwindTradersAPI.daos;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcProductDao implements ProductDao{



    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> searchProduct(String search) {
        return List.of();
    }

    @Override
    public int deleteProduct(Product product) {
        return 0;
    }

    @Override
    public boolean editProduct(Product product) {
        return false;
    }

    @Override
    public void printProducts(List<Product> products) {

    }

    @Override
    public List<Product> searchProductById(int productId) {
        return List.of();
    }
}
