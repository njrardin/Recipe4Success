package it326.r4s;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import it326.r4s.model.Category;

public class CategoryPoolTest {
    static Category.Pool pool = Category.Pool.getInstance();

    @BeforeClass
    public static void before() {
        pool.getCategory(Category.Type.FOODITEM, "Vegetable");
        pool.getCategory(Category.Type.FOODITEM, "Fruit");
        pool.getCategory(Category.Type.FOODITEM, "Meat");
    }

    @Test
    public void testGetCategory() {
        Category category = pool.getCategory(Category.Type.FOODITEM, "Fruit");
        assertEquals("Fruit", category.getName());
    }
}
