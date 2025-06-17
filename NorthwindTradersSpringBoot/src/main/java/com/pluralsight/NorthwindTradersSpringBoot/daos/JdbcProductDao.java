package com.pluralsight.NorthwindTradersSpringBoot.daos;

import com.pluralsight.NorthwindTradersSpringBoot.dtos.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao{

    private List<Product> products;
    private DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.products = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public boolean addProduct(Product product) {
        return products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            Connection connection = dataSource.getConnection();
            String sql = """
                        SELECT products.ProductID, products.ProductName, products.UnitPrice, categories.CategoryName
                        FROM products
                        JOIN categories
                        WHERE products.CategoryID = categories.CategoryID;""";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                int productId = results.getInt("ProductID");
                String productName = results.getString("ProductName");
                String category = results.getString("CategoryName");
                double unitPrice = results.getDouble("UnitPrice");

                Product product = new Product(productId, productName, category, unitPrice);
                this.products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.products;
    }

    @Override
    public List<Product> searchProduct(String search) {
        List<Product> matches;
        try {
            Connection connection = dataSource.getConnection();
            String sql = """
                    SELECT *
                    FROM products
                    WHERE ProductName like ?""";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, search);
            ResultSet results = statement.getResultSet();
            matches = Product.parseProductsFromResultSet(results);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return matches;
    }

    @Override
    public int deleteProduct(Product product) {
        try {
            Connection connection = dataSource.getConnection();
            String sql = """
                            DELETE
                            FROM products
                            WHERE ProductID = ?""";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, product.getProductId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean editProduct(Product product) {
        return false;
    }

    @Override
    public void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
