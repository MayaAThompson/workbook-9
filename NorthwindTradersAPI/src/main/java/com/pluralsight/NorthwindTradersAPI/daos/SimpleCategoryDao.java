package com.pluralsight.NorthwindTradersAPI.daos;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleCategoryDao {

    private List<Category> categories;

    @Autowired
    public SimpleCategoryDao() {
        this.categories = new ArrayList<>();
        this.categories.add(new Category(1, "Sports"));
        this.categories.add(new Category(2, "Camping"));
        this.categories.add(new Category(3, "Apparel"));
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public List<Category> searchCategoryById(int categoryId) {
        List<Category> matches = new ArrayList<>();
        for (Category category : this.categories) {
            if (category.getCategoryId() == categoryId)
                matches.add(category);
        }
        return matches;
    }
}
