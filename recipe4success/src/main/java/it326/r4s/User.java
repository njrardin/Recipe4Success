/**
 * @file Specifies a basic user object.
 * @author Alex Smith (alsmi14@ilstu.edu)
 * @date 4/5/22
 */

package it326.r4s;

import java.util.ArrayList;
import java.util.Collection;

public class User {
    /** Instance Variables **/
    private String name;
    private GroceryList groceryList;
    private Pantry pantry;
    private Collection<MealPlan> mealPlans;
    private Collection<Recipe> recipes;
    private int activeMealPlanIndex;

    /** Constructors **/
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

    /** Methods **/
    public boolean addMealPlan(MealPlan mealPlan) {

    }

    public boolean removeMealPlan(MealPlan mealPlan) {
        
    }

    public boolean addRecipe(Recipe recipe) {
        
    }

    public boolean removeRecipe(Recipe recipe) {
        
    }

    public boolean moveGroceryListToPantry() {

    }

    public Collection<Recipe> getMakeableRecipes() {

    }

    public addMealPlanToGroceryList(MealPlan mealPlan) {

    }


    /** Getters and Setters **/
    public String getName() {
        return this.name;
    }
    
    /**
     * Name setter.
     * @param name the new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    public GroceryList getGroceryList() {
        return this.groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public Pantry getPantry() {
        return this.pantry;
    }

    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }

    public Collection<MealPlan> getMealPlans() {
        return this.mealPlans;
    }

    public void setMealPlans(Collection<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
    }

    public Collection<Recipe> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(Collection<Recipe> recipes) {
        this.recipes = recipes;
    }

    public int getActiveMealPlanIndex() {
        return this.activeMealPlanIndex;
    }

    public void setActiveMealPlanIndex(int activeMealPlanIndex) {
        this.activeMealPlanIndex = activeMealPlanIndex;
    }

}