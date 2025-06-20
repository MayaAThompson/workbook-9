package com.pluralsight.NorthwindTradersSpringBoot.daos;

import com.pluralsight.NorthwindTradersSpringBoot.dtos.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDao {

    boolean addProduct(Product product);

    List<Product> getAllProducts();

    List<Product> searchProduct(String search);

    int deleteProduct(Product product);

    boolean editProduct(Product product);

    void printProducts(List<Product> products);
}
