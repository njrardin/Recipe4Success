package it326.r4s;

import java.util.ArrayList;
import java.util.List;

/**
 * A categoryList class of the Recipes4Success application.
 * Handles most category-related tasks for both recipe and fooditem types.
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
public class CategoryPool {

    public static enum CategoryType { RECIPE, FOODITEM }

    private static List<Category> recipeCategories = new ArrayList<Category>();
    private static List<Category> foodCategories = new ArrayList<Category>();

    /**
     * Constructor - accessed only by the instance variables above, thus being private.
     * Only two objects to be created, one for recipe categories and one for fooditem categories.
     */
    private CategoryPool(CategoryType categoryType) {
        if (categoryType == CategoryType.RECIPE) {
            recipeCategories = new ArrayList<Category>();
        }
        else if (categoryType == CategoryType.FOODITEM) {
            foodCategories = new ArrayList<Category>();
        }
    }
    /**
     * Returns a list of categories (either recipe or fooditem)
     * Takes categorytype to determine if recipe or fooditem category
     */
    public static List<Category> getCategories(CategoryType categoryType) {
        if (categoryType == CategoryType.RECIPE) {
            return recipeCategories;
        }
        else if (categoryType == CategoryType.FOODITEM) {
            return foodCategories;
        }
        else return null; // this will never actually happen, just avoiding vs code getting mad at me
    }

    /**
     * private method used only to abstract the logic to add a category to a list (and return the category)
     * Takes categorytype to determine if recipe or fooditem category and string name to instantiate a category
     */
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

    /**
     * "getter" used to return a category object of a particular name
     * NOTE-- will create a category if it does not already exist (so it's kind of an "adder" method too)
     * Takes categorytype to determine if recipe or fooditem category, and string name to search for categories with
     */
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

    /**
     * Basic method to remove a category from a list
     * Takes categorytype to determine if recipe or fooditem category, and name to identify category to remove
     * Returns false if category does not exist (otherwise true)
     */
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
