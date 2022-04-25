package it326.r4s;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import it326.r4s.CategoryPool.CategoryType;

public class CategoryPoolTest {

    @BeforeClass
    public static void before() {
        CategoryPool.getCategory(CategoryType.FOODITEM, "Vegetable");
        CategoryPool.getCategory(CategoryType.FOODITEM, "Fruit");
        CategoryPool.getCategory(CategoryType.FOODITEM, "Meat");
    }

    @Test
    public void testGetCategory() {
        Category category = CategoryPool.getCategory(CategoryType.FOODITEM, "Fruit");
        assertEquals("Fruit", category.getName());
    }

    @Test
    public void testGetCategories() {
        List<Category> categories = CategoryPool.getCategories(CategoryType.FOODITEM);
        assertEquals(categories.get(0).getName(), "Vegetable");
        assertEquals(categories.get(1).getName(), "Fruit");
        assertEquals(categories.get(2).getName(), "Meat");
    }
}
