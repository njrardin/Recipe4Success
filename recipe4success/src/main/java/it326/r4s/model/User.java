package it326.r4s.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A basic user of the Recipes4Success application.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/5/22
 */
public class User implements Portable {
    //* Instance Variables *\\
    private String name;
    private GroceryList groceryList;
    private Pantry pantry;
    private MealPlanner mealPlanner;
    private RecipeBook recipeBook;

    //* Constructors *\\
    /**
     * Creates a default user object.
     */
    private User() {
        this.name = "";
        groceryList = new GroceryList();
        pantry = new Pantry();
        mealPlanner = new MealPlanner();
        recipeBook = new RecipeBook();
    }

    /**
     * Creates a user object with a specified name. 
     * @param name the name of the user.
     */
    public User(String name) {
        this();
        this.name = name;
    }

    //* Methods *\\
    /**
     * Attempts to move the ingredients from the user's grocery list to the pantry.
     * @return True if all ingredients were moved, false otherwise.
     */
    public boolean moveGroceryListToPantry() {
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
        return groceryList.addIngredients(mealPlan.getAllIngredients());
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

    public MealPlanner getMealPlanner(){
        return this.mealPlanner;
    }

    public void setMealPlanner(MealPlanner mealPlanner){
        this.mealPlanner = mealPlanner;
    }
    public RecipeBook getRecipeBook(){
        return this.recipeBook;
    }
    public void setRecipeBook(RecipeBook recipeBook){
        this.recipeBook = recipeBook;
    }

    /**
     * Override toString which returns the user's name
     * @return a String of the user's name
     */
    @Override
    public String toString(){
        return this.name;
    }
    
    @Override
    public boolean equals(Object obj) {
        // Check if the compared object is of correct type
        if (!(obj instanceof User)) {
            return false;
        }

        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }

        User otherUser = (User) obj;
        return this.name.equals(otherUser.getName());
    }
}