package it326.r4s;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import it326.r4s.model.Category;
import it326.r4s.model.CategoryList;
import it326.r4s.model.CategoryList.CategoryType;

public class CategoryListTest {

    @BeforeClass
    public static void before() {
        CategoryList.getCategory(CategoryType.FOODITEM, "Vegetable");
        CategoryList.getCategory(CategoryType.FOODITEM, "Fruit");
        CategoryList.getCategory(CategoryType.FOODITEM, "Meat");
    }

    @Test
    public void testGetCategory() {
        Category category = CategoryList.getCategory(CategoryType.FOODITEM, "Fruit");
        assertEquals("Fruit", category.getName());
    }

    @Test
    public void testGetCategories() {
        List<Category> categories = CategoryList.getCategories(CategoryType.FOODITEM);
        assertEquals(categories.get(0).getName(), "Vegetable");
        assertEquals(categories.get(1).getName(), "Fruit");
        assertEquals(categories.get(2).getName(), "Meat");
    }
}
