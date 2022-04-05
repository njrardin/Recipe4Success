package it326.r4s;

import java.util.*;

enum CategoryType {
    Recipe, FoodItem
}

public class CategoryList {
    private List<Category> recipeCategories;
    private List<Category> foodCategories;
    private CategoryType categoryType;

    public CategoryList(CategoryType categoryType) {
        if (categoryType == CategoryType.Recipe) {
            this.recipeCategories = new ArrayList<Category>();
            this.categoryType = categoryType;
        }
        else if (categoryType == CategoryType.FoodItem) {
            this.foodCategories = new ArrayList<Category>();
            this.categoryType = categoryType;
        }
    }

    public List<Category> getCategories() {
        if (this.categoryType == CategoryType.Recipe) {
            return this.recipeCategories;
        }
        else if (this.categoryType == CategoryType.FoodItem) {
            return this.foodCategories;
        }
        else return null; // this will never actually happen, just avoiding vs code getting mad at me
    }

    public void addCategoryToList(Category category) {
        if (this.categoryType == CategoryType.Recipe) {
            this.recipeCategories.add(category);
        }
        else if (this.categoryType == CategoryType.FoodItem) {
            this.foodCategories.add(category);
        }
    }

    public Category getCategory(String name) {
        if (this.categoryType == CategoryType.Recipe) {
            for (Category category : this.recipeCategories) {
                if (name == category.getName()) {
                    return category;
                }
            }
            // if category does not exist
            Category category = new Category(name);
            addCategoryToList(category);
            return category;
        }
        else if (this.categoryType == CategoryType.FoodItem) {
            for (Category category : this.foodCategories) {
                if (name == category.getName()) {
                    return category;
                }
            }
            // if category does not exist
            Category category = new Category(name);
            addCategoryToList(category);
            return category;
        }
        else return null; // this will never actually happen, just avoiding vs code getting mad at me
    }

    public boolean removeCategory(String name) {
        if (this.categoryType == CategoryType.Recipe) {
            for (Category category : this.recipeCategories) {
                if (name == category.getName()) {
                    this.recipeCategories.remove(category);
                    return true;
                }
            }
        }
        else if (this.categoryType == CategoryType.FoodItem) {
            for (Category category : this.foodCategories) {
                if (name == category.getName()) {
                    this.foodCategories.remove(category);
                    return true;
                }
            }
        }
        return false;
    }
    
}
