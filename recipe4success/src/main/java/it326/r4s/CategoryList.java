package it326.r4s;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {

    public static enum CategoryType { RECIPE, FOODITEM }

    private static List<Category> recipeCategories = new ArrayList<Category>();
    private static List<Category> foodCategories = new ArrayList<Category>();

    private CategoryList(CategoryType categoryType) {
        if (categoryType == CategoryType.RECIPE) {
            recipeCategories = new ArrayList<Category>();
        }
        else if (categoryType == CategoryType.FOODITEM) {
            foodCategories = new ArrayList<Category>();
        }
    }

    public static List<Category> getCategories(CategoryType categoryType) {
        if (categoryType == CategoryType.RECIPE) {
            return recipeCategories;
        }
        else if (categoryType == CategoryType.FOODITEM) {
            return foodCategories;
        }
        else return null; // this will never actually happen, just avoiding vs code getting mad at me
    }

    private static Category addCategoryToList(CategoryType categoryType, String name) {
        Category category = new Category(name);
        if (categoryType == CategoryType.RECIPE) {
            recipeCategories.add(category);
        }
        else if (categoryType == CategoryType.FOODITEM) {
            foodCategories.add(category);
        }
        return category;
    }

    public static Category getCategory(CategoryType categoryType, String name) {
        if (categoryType == CategoryType.RECIPE) {
            for (Category category : recipeCategories) {
                if (name == category.getName()) {
                    return category;
                }
            }
            // if category does not exist
            return addCategoryToList(categoryType, name);
        }
        else if (categoryType == CategoryType.FOODITEM) {
            for (Category category : foodCategories) {
                if (name == category.getName()) {
                    return category;
                }
            }
            // if category does not exist
            return addCategoryToList(categoryType, name);
        }
        else return null; // this will never actually happen, just avoiding vs code getting mad at me
    }

    public boolean removeCategory(CategoryType categoryType, String name) {
        if (categoryType == CategoryType.RECIPE) {
            for (Category category : recipeCategories) {
                if (name == category.getName()) {
                    recipeCategories.remove(category);
                    return true;
                }
            }
        }
        else if (categoryType == CategoryType.FOODITEM) {
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
