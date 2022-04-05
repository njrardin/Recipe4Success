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
    private Collection<MealPlan> mealPlans;
    private Collection<Recipe> recipes;
    private int activeMealPlanIndex;

    //* Constructors *\\
    /**
     * Creates a default user object.
     */
    private User() {
        name = "";
        groceryList = new GroceryList();
        pantry = new Pantry();
        mealPlans = new ArrayList<MealPlan>();
        recipes = new ArrayList<Recipe>();
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
        // TODO implement addMealPlan
        return false;
    }

    /**
     * Attempts to remove a meal plan from the user's collection.
     * @param mealPlan the meal plan to be removed.
     * @return True if the meal plan was removed, false otherwise.
     */
    public boolean removeMealPlan(MealPlan mealPlan) {
        // TODO implement removeMealPlan
        return false;
    }

    /**
     * Attempts to add a recipe to the user's collection.
     * @param recipe the recipe to be added.
     * @return True if the recipe was added, false otherwise.
     */
    public boolean addRecipe(Recipe recipe) {
        // TODO implement addRecipe
        return false;
    }

    /**
     * Attempts to remove a recipe from the user's collection.
     * @param recipe the recipe to be removed.
     * @return True if the recipe was removed, false otherwise.
     */
    public boolean removeRecipe(Recipe recipe) {
        // TODO implement removeRecipe
        return false;        
    }

    /**
     * Attempts to move the ingredients from the user's grocery list to the pantry.
     * @return True if all ingredients were moved, false otherwise.
     */
    public boolean moveGroceryListToPantry() {
        // TODO implement moveGroceryListToPantry
        return false;
    }

    /**
     * Gets all the recipes that can be made with the ingredients in the user's pantry.
     * @return The collection of makeable recipes.
     */
    public Collection<Recipe> getMakeableRecipes() {
        // TODO implement getMakeableRecipes
        return null;
    }

    /**
     * Attempts to add the ingredients required for a meal plan to the user's grocery list.
     * @param mealPlan the meal plan to be added to the grocery list.
     * @return True if all ingredients were added, false otherwise.
     */
    public boolean addMealPlanToGroceryList(MealPlan mealPlan) {
        // TODO implement addMealPlanToGroceryList
        return false;
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
        return this.mealPlans;
    }

    /**
     * Sets the user's collection of meal plans.
     * @param mealPlans the new collection of meals.
     */
    public void setMealPlans(Collection<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
    }

    /**
     * Gets the user's collection of recipes.
     */
    public Collection<Recipe> getRecipes() {
        return this.recipes;
    }

    /**
     * Sets the user's collection of recipes.
     * @param recipes the new collection of recipes.
     */
    public void setRecipes(Collection<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * Gets the user's active meal plan index.
     */
    public int getActiveMealPlanIndex() {
        return this.activeMealPlanIndex;
    }

    /**
     * Gets the user's active meal plan index.
     * @param activeMealPlanIndex the new active meal plan index.
     */
    public void setActiveMealPlanIndex(int activeMealPlanIndex) {
        this.activeMealPlanIndex = activeMealPlanIndex;
    }
}