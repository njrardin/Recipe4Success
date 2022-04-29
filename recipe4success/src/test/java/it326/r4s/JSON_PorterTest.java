package it326.r4s;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.BeforeClass;
import org.junit.Test;

import it326.r4s.model.Exporter;
import it326.r4s.model.Importer;
import it326.r4s.model.JSON_Porter;
import it326.r4s.model.Meal;
import it326.r4s.model.MealPlan;
import it326.r4s.model.Recipe;
import it326.r4s.model.User;

/**
 * A testing file for the JSON_Porter class.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/20/22
 */
public class JSON_PorterTest {
    private static final String EXPORT_FILENAME = "exportUserTest.json";
    private static Importer<User> importer;
    private static Exporter<User> exporter;
    private static User user;

    @BeforeClass
    public static void setup() {
        importer = JSON_Porter.of(User.class);
        exporter = JSON_Porter.of(User.class);

        // TODO maybe make this user object have more stuff. I was just lazy.
        user = new User("Alex");

        Recipe friedRice = new Recipe.RecipeBuilder("Fried Rice")
            .setDescription("Some delicious fried rice.")
            .setServingSize(2)
            .build();
        Recipe omelette = new Recipe.RecipeBuilder("Omelette")
            .setDescription("That one good looking omelette.")
            .setServingSize(1)
            .build();
        user.getRecipeBook().addRecipe(friedRice);
        user.getRecipeBook().addRecipe(omelette);

        MealPlan breakfast = new MealPlan("Breakfast");
        breakfast.addMeal(new Meal(friedRice, 4));
        breakfast.addMeal(new Meal(omelette, 2));
        user.getMealPlanner().addMealPlan(breakfast);
    }

    /**
     * Tests that the User object is successfully exported to a JSON file and then read back into an identical User object.
     */
    @Test
    public void testImportAndExportFromUser() {
        try {
            Path path = Path.of(EXPORT_FILENAME);
            
            // Export the User object.
            exporter.exportTo(user, EXPORT_FILENAME);
            assertTrue(Files.exists(path));

            // Import the User object back from the JSON file and delete the file.
            User importedUser = importer.importFrom(EXPORT_FILENAME);
            Files.delete(path);
            assertNotNull(importedUser);
            assertTrue(importedUser.equals(user));
        } catch (Exception e) {
            // If any exception is thrown, then the test fails.
            fail();
        }
    }
}