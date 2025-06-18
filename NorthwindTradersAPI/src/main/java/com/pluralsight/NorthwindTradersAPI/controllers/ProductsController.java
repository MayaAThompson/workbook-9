package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.daos.ProductDao;
import com.pluralsight.NorthwindTradersAPI.daos.SimpleProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    ProductDao productDao = new SimpleProductDao();

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productDao.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public List<Product> getProductById(@PathVariable int productId) {
        return productDao.searchProductById(productId);
    }
}
