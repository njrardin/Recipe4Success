package it326.r4s.controller;

import it326.r4s.model.User;
import it326.r4s.view.UserView;
/**
 * Controller for R4S User
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class UserController {
    
    //*Instance Variables*\\
    private User user;
    private UserView userView;

    private GroceryListController groceryListController;
    private PantryController pantryController;
    private MealPlannerController mealPlannerController;
    private RecipeBookController recipeBookController;

    //*Constructor*\\
    /**
     * Contructor for R4S's UserController
     * is private because the controller is implemented
     * as a singleton to enforce only a single instance per program run
     * and to provide a global access point for the User and its controller
     * @param theUser - the user associated with the controller
     */
    public UserController(User theUser){
        this.user = theUser;
        this.groceryListController = new GroceryListController(user.getGroceryList(), this);
        this.pantryController = new PantryController(user.getPantry(), this);
        this.mealPlannerController = new MealPlannerController(user.getMealPlanner(), this);
        this.recipeBookController = new RecipeBookController(user.getRecipeBook(), this);
    }

    //*Methods\\
    /**
     * Getter for the UserController's User
     * @return the User object
     */
    public User getUser(){
        return user;
    }

    /**
     * Getter for the UserController's UserView
     * @return the UserView object
     */
    public UserView getUserView(){
        return userView;
    }
    
    /**
     * Getter for the UserController's UserView
     * @return the UserView object
     */
    public GroceryListController getGroceryListController(){
        return this.groceryListController;
    }

    /**
     * Getter for the UserController's GroceryListController
     * @return the PantryController object
     */
    public PantryController getPantryController(){
        return this.pantryController;
    }

    /**
     * Getter for the UserController's MealPlannerController
     * @return the MealPlannerController object
     */
    public MealPlannerController getMealPlannerController(){
        return this.mealPlannerController;
    }

    /**
     * Getter for the UserController's RecipeBookController
     * @return the RecipeBookController object
     */
    public RecipeBookController getRecipeBookController(){
        return this.recipeBookController;
    }

    /**
     * Initializes a RecipeBookController with the user's recipeBook
     * to execute the process of opening that menu of the application
     */
    public void openRecipeBook(){
        recipeBookController.openRecipeBook();
    }

    /**
     * Initializes a MealPlannerController with the user's mealPlanner
     * to execute the process of opening that menu of the application
     */
    public void openMealPlanner(){
        mealPlannerController.openMealPlanner();
    }

    /**
     * Initializes a PantryController with the user's pantry
     * to execute the process of opening that menu of the application
     */
    public void openPantry(){
        pantryController.openPantry();
    }

    /**
     * Initializes a GroceryListController with the user's groceryList
     * to execute the process of opening that menu of the application
     */
    public void accessGroceryList(){
        groceryListController.openGroceryList();
    }
    
}
