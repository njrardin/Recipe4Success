package it326.r4s;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A basic user of the Recipes4Success application.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/5/22
 */
public class User {
    //* Instance Variables *\\
    private String name;
    private GroceryList groceryList;
    private Pantry pantry;
    private MealPlanner mealPlanner;
    private RecipeBook recipeBook;
    private int activeMealPlanIndex;

    //* Constructors *\\
    /**
     * Creates a default user object.
     */
    private User() {
        name = "";
        groceryList = new GroceryList();
        pantry = new Pantry();
        mealPlanner = new MealPlanner();
        recipeBook = new RecipeBook();
        activeMealPlanIndex = -1;
    }

    /**
     * Creates a user object with a specified name. 
     * @param name the name of the user.
     */
    public User(String name) {
        this();
        setName(name);
    }

    //* Methods *\\
    /**
     * Attempts to add a meal plan to the user's collection.
     * @param mealPlan the meal plan to be added.
     * @return True if the meal plan was added, false otherwise.
     */
    public boolean addMealPlan(MealPlan mealPlan) {
        return mealPlanner.addMealPlan(mealPlan);
    }

    /**
     * Attempts to remove a meal plan from the user's collection.
     * @param mealPlan the meal plan to be removed.
     * @return True if the meal plan was removed, false otherwise.
     */
    public boolean removeMealPlan(MealPlan mealPlan) {
        return mealPlanner.removeMealPlan(mealPlan);
    }

    /**
     * Attempts to add a recipe to the user's collection.
     * @param recipe the recipe to be added.
     * @return True if the recipe was added, false otherwise.
     */
    public boolean addRecipe(Recipe recipe) {
        return recipeBook.addRecipe(recipe);
    }

    /**
     * Attempts to remove a recipe from the user's collection.
     * @param recipe the recipe to be removed.
     * @return True if the recipe was removed, false otherwise.
     */
    public boolean removeRecipe(Recipe recipe) {
        return recipeBook.removeRecipe(recipe);        
    }

    /**
     * Attempts to move the ingredients from the user's grocery list to the pantry.
     * @return True if all ingredients were moved, false otherwise.
     */
    public boolean moveGroceryListToPantry() {
        // TODO #11 - decide if pantry and grocery list should extend ingredient list.
        // Add all of the ingredients from the grocery list to the pantry.
        boolean result = pantry.getIngredientList().addIngredients(groceryList.getIngredientList().getIngredients());

        // Clear the grocery list's ingredients.
        groceryList.getIngredientList().clearIngredients();

        return result;
    }

    /**
     * Gets all the recipes that can be made with the ingredients in the user's pantry.
     * @return The collection of makeable recipes.
     */
    public Collection<Recipe> getMakeableRecipes() {
        Collection<Recipe> makeable = new ArrayList<Recipe>();
        Collection<Recipe> recipes = recipeBook.getRecipes();
        // Add each recipe in the user's collection that can be made with ingredients in the pantry.
        for (Recipe recipe : recipes) {
            if (pantry.getIngredientList().containsIngredients(recipe.getIngredientList().getIngredients())) {
                makeable.add(recipe);
            }
        }

        return makeable;
    }

    /**
     * Attempts to add the ingredients required for a meal plan to the user's grocery list.
     * @param mealPlan the meal plan to be added to the grocery list.
     * @return True if all ingredients were added, false otherwise.
     */
    public boolean addMealPlanToGroceryList(MealPlan mealPlan) {
        return groceryList.getIngredientList().addIngredients(mealPlan.getAllIngredients());
    }

    //* Getters and Setters *\\
    /**
     * Gets the user's name.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Sets the user's name.
     * @param name the new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user's grocery list object.
     */
    public GroceryList getGroceryList() {
        return this.groceryList;
    }

    /**
     * Sets the user's grocery list object.
     * @param groceryList the new grocery list.
     */
    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    /**
     * Gets the user's pantry object.
     */
    public Pantry getPantry() {
        return this.pantry;
    }

    /**
     * Sets the user's pantry object.
     * @param pantry the new pantry.
     */
    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }

    /**
     * Gets the user's collection of meal plans.
     */
    public Collection<MealPlan> getMealPlans() {
        return mealPlanner.getMealPlans();
    }

    /**
     * Sets the user's collection of meal plans.
     * @param mealPlans the new collection of meals.
     */
    public void setMealPlans(Collection<MealPlan> mealPlans) {
        this.mealPlanner.setMealPlans(mealPlans);
    }

    /**
     * Gets the user's collection of recipes.
     */
    public Collection<Recipe> getRecipes() {
        return this.recipeBook.getRecipes();
    }

    /**
     * Sets the user's collection of recipes.
     * @param recipes the new collection of recipes.
     */
    public void setRecipes(Collection<Recipe> recipes) {
        this.recipeBook.setRecipes(recipes);
    }

    /**
     * Gets the user's active meal plan index.
     */
    public int getActiveMealPlanIndex() {
        return this.activeMealPlanIndex;
    }

    /**
     * Sets the user's active meal plan index.
     * @param index the new active meal plan index.
     * @return True if within bounds, false otherwise.
     */
    public boolean setActiveMealPlanIndex(int index) {
        return mealPlanner.setActiveMealPlanIndex(index);
    }

    /**
    private String name;
    private GroceryList groceryList;
    private Pantry pantry;
    private Collection<MealPlan> mealPlans;
    private Collection<Recipe> recipes;
    private int activeMealPlanIndex;
     */
    @Override
    public boolean equals(Object obj) {

        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }
        // Check if the compared object is of correct type
        if (!(obj instanceof User)) {
            return false;
        }

        User otherUser = (User) obj;
        return this.name.equals(otherUser.getName());
    }
}