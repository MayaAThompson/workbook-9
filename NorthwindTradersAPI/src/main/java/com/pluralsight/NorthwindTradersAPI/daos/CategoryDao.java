package com.pluralsight.NorthwindTradersAPI.daos;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryDao {

    List<Category> getCategories();

    List<Category> searchCategoryById(int categoryId);
}
