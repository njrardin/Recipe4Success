package it326.r4s;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class CategoryListTest {
    static Category category1;
    static Category category2;
    static Category category3;

    @BeforeClass
    public static void before() {
        category1 = new Category("Vegetable");
        category2 = new Category("Fruit");
        category3 = new Category("Meat");

        CategoryList.addCategoryToList(CategoryType.FoodItem, category1);
        CategoryList.addCategoryToList(CategoryType.FoodItem, category2);
        CategoryList.addCategoryToList(CategoryType.FoodItem, category3);
    }

    @Test
    public void testGetCategory() {
        Category category4 = CategoryList.getCategory(CategoryType.FoodItem, "Fruit");
        assertEquals(category2, category4);
        assertEquals(category3, CategoryList.getCategory(CategoryType.FoodItem, "Meat"));
    }

    @Test
    public void testGetCategories() {
        List<Category> categories = new ArrayList<Category>();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        assertEquals(categories, CategoryList.getCategories(CategoryType.FoodItem));
    }
}
