package it326.r4s;

import java.util.ArrayList;
import java.util.List;

/**
 * A categoryList class of the Recipes4Success application.
 * Handles most category-related tasks for both recipe and fooditem types.
 * 
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
public class CategoryPool {

    // * Instance Variables*\\
    public static enum CategoryType {
        RECIPE, FOODITEM
    }

    private static List<Category> recipeCategories = new ArrayList<Category>();
    private static List<Category> foodCategories = new ArrayList<Category>();

    // * Constructor *\\
    /**
     * Creates a CategoryPool object with a specified categoryType.
     * accessed only by the instance variables above, thus being private.
     * Only two objects to be created, one for recipe categories and one for
     * fooditem categories.
     */
    private CategoryPool(CategoryType categoryType) {
        if (categoryType == CategoryType.RECIPE) {
            recipeCategories = new ArrayList<Category>();
        } else if (categoryType == CategoryType.FOODITEM) {
            foodCategories = new ArrayList<Category>();
        }
    }

    // * Methods *\\
    /**
     * Takes categorytype to determine if recipe or fooditem category and
     * Gets the categories.
     * 
     * @param categoryType a list of categories (either recipe or fooditem).
     * @return a list of category.
     */
    public static List<Category> getCategories(CategoryType categoryType) {
        if (categoryType == CategoryType.RECIPE) {
            return recipeCategories;
        } else if (categoryType == CategoryType.FOODITEM) {
            return foodCategories;
        } else
            return null; // this will never actually happen, just avoiding vs code getting mad at me
    }

    /**
     * private method used only to abstract the logic to add a category to a list.
     * 
     * @param categoryType used to determine it's recipe or fooditem.
     * @param name         a new category name.
     * @return the category.
     */
    private static Category addCategoryToList(CategoryType categoryType, String name) {
        Category category = new Category(name);
        if (categoryType == CategoryType.RECIPE) {
            recipeCategories.add(category);
        } else if (categoryType == CategoryType.FOODITEM) {
            foodCategories.add(category);
        }
        return category;
    }

    /**
     * Gets the category object with a specified name.
     * NOTE-- will create a category if it does not already exist (so it's kind of
     * an "adder" method too).
     * 
     * @param categoryType used to determine it's a recipe or fooditem category.
     * @param name         a specified name used to search categories.
     * @return a category
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
        } else if (categoryType == CategoryType.FOODITEM) {
            for (Category category : foodCategories) {
                if (name == category.getName()) {
                    return category;
                }
            }
            // if category does not exist
            return addCategoryToList(categoryType, name);
        } else
            return null; // this will never actually happen, just avoiding vs code getting mad at me
    }

    /**
     * Removes a category from a list
     * 
     * @param categoryType used to determine it's a recipe or fooditem category.
     * @param name         a specified name used to search categories.
     * @return false if category does not exist, return true when a category is
     *         successfully remove from a list.
     */
    public boolean removeCategory(CategoryType categoryType, String name) {
        if (categoryType == CategoryType.RECIPE) {
            for (Category category : recipeCategories) {
                if (name == category.getName()) {
                    recipeCategories.remove(category);
                    return true;
                }
            }
        } else if (categoryType == CategoryType.FOODITEM) {
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
