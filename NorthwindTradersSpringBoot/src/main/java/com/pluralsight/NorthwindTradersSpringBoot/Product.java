package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Product {

    private int productId;
    private String name;
    private String category;
    private double price;

    public Product(int productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static List<Product> parseProductsFromResultSet(ResultSet results) throws SQLException {
        List<Product> matches = new ArrayList<>();
        while (results.next()) {
            int productId = results.getInt("ProductID");
            String productName = results.getString("ProductName");
            String category = results.getString("CategoryName");
            double unitPrice = results.getDouble("UnitPrice");

            Product product = new Product(productId, productName, category, unitPrice);
            matches.add(product);
        }
        return matches;
    }

    @Override
    public String toString() {
        return "\nProduct ID: " + this.productId +
                "\nProduct Name: " + this.name +
                "\nCategory: " + this.category +
                "\nPrice: $" + this.price;
    }
}
