package it326.r4s;

import java.util.ArrayList;
import java.util.List;

enum CategoryType { Recipe, FoodItem }

public class CategoryList {
    private static List<Category> recipeCategories = new ArrayList<Category>();
    private static List<Category> foodCategories = new ArrayList<Category>();

    private CategoryList(CategoryType categoryType) {
        if (categoryType == CategoryType.Recipe) {
            recipeCategories = new ArrayList<Category>();
        }
        else if (categoryType == CategoryType.FoodItem) {
            foodCategories = new ArrayList<Category>();
        }
    }

    public static List<Category> getCategories(CategoryType categoryType) {
        if (categoryType == CategoryType.Recipe) {
            return recipeCategories;
        }
        else if (categoryType == CategoryType.FoodItem) {
            return foodCategories;
        }
        else return null; // this will never actually happen, just avoiding vs code getting mad at me
    }

    public static void addCategoryToList(CategoryType categoryType, Category category) {
        if (categoryType == CategoryType.Recipe) {
            recipeCategories.add(category);
        }
        else if (categoryType == CategoryType.FoodItem) {
            foodCategories.add(category);
        }
    }

    public static Category getCategory(CategoryType categoryType, String name) {
        if (categoryType == CategoryType.Recipe) {
            for (Category category : recipeCategories) {
                if (name == category.getName()) {
                    return category;
                }
            }
            // if category does not exist
            Category category = new Category(name);
            addCategoryToList(categoryType, category);
            return category;
        }
        else if (categoryType == CategoryType.FoodItem) {
            for (Category category : foodCategories) {
                if (name == category.getName()) {
                    return category;
                }
            }
            // if category does not exist
            Category category = new Category(name);
            addCategoryToList(categoryType, category);
            return category;
        }
        else return null; // this will never actually happen, just avoiding vs code getting mad at me
    }

    public boolean removeCategory(CategoryType categoryType, String name) {
        if (categoryType == CategoryType.Recipe) {
            for (Category category : recipeCategories) {
                if (name == category.getName()) {
                    recipeCategories.remove(category);
                    return true;
                }
            }
        }
        else if (categoryType == CategoryType.FoodItem) {
            for (Category category : foodCategories) {
                if (name == category.getName()) {
                    foodCategories.remove(category);
                    return true;
                }
            }
        }
        return false;
    }
}
