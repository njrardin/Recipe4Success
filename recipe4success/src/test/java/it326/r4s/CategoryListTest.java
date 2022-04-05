package it326.r4s;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class CategoryListTest {
    static CategoryList foodCategories;
    static CategoryList recipeCategories;
    static Category category1;
    static Category category2;
    static Category category3;

    @BeforeClass
    public static void before() {
        foodCategories = new CategoryList(CategoryType.FoodItem);
        recipeCategories = new CategoryList(CategoryType.Recipe);
        category1 = new Category("Vegetable");
        category2 = new Category("Fruit");
        category3 = new Category("Meat");

        foodCategories.addCategoryToList(category1);
        foodCategories.addCategoryToList(category2);
        foodCategories.addCategoryToList(category3);
    }

    @Test
    public void testGetCategory() {
        Category category4 = foodCategories.getCategory("Fruit");
        assertEquals(category2, category4);
        assertEquals(category3, foodCategories.getCategory("Meat"));
    }

    @Test
    public void testGetCategories() {
        List<Category> categories = new ArrayList<Category>();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        assertEquals(categories, foodCategories.getCategories());
    }
}
