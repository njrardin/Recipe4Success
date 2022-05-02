package it326.r4s.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A class that saves and loads user objects.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/30/22
 */
public class UserManager extends InstanceManager<User> {
    private static final String userFileName = "User.json";
    private String userDirectory;
    private Importer<User> importer;
    private Exporter<User> exporter;
    private Category.Pool categoryPool;
    private FoodItem.Pool foodItemPool;

    /**
     * Constructs a default user manager.
     */
    public UserManager() {
        userDirectory = InstanceManager.getParentDirectory() + userFileName;
        importer = ImporterProducer.getImporter(ImporterProducer.Type.JSON, User.class);
        exporter = ExporterProducer.getExporter(ExporterProducer.Type.JSON, User.class);
        foodItemPool = FoodItem.Pool.getInstance();
        categoryPool = Category.Pool.getInstance();
    }

    /**
     * Loads a user object.
     */
    @Override
    public User load() {
        User user = null;

        // Try to load the user.
        try {
            user = importer.importFrom(userDirectory);
            rebuildUserReferences(user);
        } catch (Exception e) {}

        return user;
    }

    /**
     * Saves a user object.
     */
    @Override
    public void save(User portable) throws Exception {
        exporter.exportTo(portable, userDirectory);    
    }

    /**
     * Gets the file name to save and load user objects to/from.
     * @return the file name.
     */
    public static String getUserFileName() {
        return userFileName;
    }

    /**
     * Rebuilds all the user's references.
     * @param user the user object to rebuild.
     */
    private void rebuildUserReferences(User user) {
        rebuildRecipeCategories(user);
        rebuildRecipeIngredients(user);
        rebuildPantryIngredients(user);
        rebuildGroceryListIngredients(user);
        rebuildMeals(user);
    }

    /**
     * Rebuilds the user's recipe category references.
     * @param user the user object to rebuild.
     */
    private void rebuildRecipeCategories(User user) {
        for (Recipe recipe : user.getRecipeBook().getRecipes()) {
            Collection<Category> categories = new ArrayList<>(recipe.getCategories());
            recipe.clearCategories();
            for (Category category : categories) {
                recipe.addCategory(categoryPool.getCategory(Category.Type.RECIPE, category.getName()));
            }
        }
    }

    /**
     * Rebuilds the user's recipe ingredient references.
     * @param user the user object to rebuild.
     */
    private void rebuildRecipeIngredients(User user) {
        for (Recipe recipe : user.getRecipeBook().getRecipes()) {
            for (Ingredient ingredient : recipe.getIngredientList().getIngredients()) {
                ingredient.setFoodItem(foodItemPool.getFoodItem(ingredient.getFoodItem().getName()));
            }
        }
    }

    /**
     * Rebuilds the user's pantry ingredient references.
     * @param user the user object to rebuild.
     */
    private void rebuildPantryIngredients(User user) {
        for (Ingredient ingredient : user.getPantry().getIngredientList().getIngredients()) {
            ingredient.setFoodItem(foodItemPool.getFoodItem(ingredient.getFoodItem().getName()));
        }
    }

    /**
     * Rebuilds the user's grocery list ingredient references.
     * @param user the user object to rebuild.
     */
    private void rebuildGroceryListIngredients(User user) {
        for (Ingredient ingredient : user.getGroceryList().getIngredientList().getIngredients()) {
            ingredient.setFoodItem(foodItemPool.getFoodItem(ingredient.getFoodItem().getName()));
        }
    }

    /**
     * Rebuilds the user's meal references.
     * @param user the user object to rebuild.
     */
    private void rebuildMeals(User user) {
        for (MealPlan mealPlan : user.getMealPlanner().getMealPlans()) {
            for (Meal meal : mealPlan.getMeals()) {
                for (Recipe recipe : user.getRecipeBook().getRecipes()) {
                    if (meal.getRecipe().getName().equals(recipe.getName())) {
                        meal.setRecipe(recipe);
                    }
                }
            }
        }
    }
}
