package com.pluralsight.NorthwindTradersAPI.daos;

import com.pluralsight.NorthwindTradersAPI.models.Category;

import java.util.List;

public class JdbcCategoryDao implements CategoryDao{



    @Override
    public List<Category> getCategories() {
        return List.of();
    }

    @Override
    public List<Category> searchCategoryById(int categoryId) {
        return List.of();
    }
}
