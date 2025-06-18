package com.pluralsight.NorthwindTradersAPI.daos;

import com.pluralsight.NorthwindTradersAPI.models.Product;
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

    List<Product> searchProductById(int productId);
}
