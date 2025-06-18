package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.daos.SimpleCategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    SimpleCategoryDao categoryDao = new SimpleCategoryDao();

    @GetMapping("/categories")
    public List<Category> getCategories() {
       return categoryDao.getCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public List<Category> getCategoryById(@PathVariable int categoryId) {
        return categoryDao.searchCategoryById(categoryId);
    }
}
