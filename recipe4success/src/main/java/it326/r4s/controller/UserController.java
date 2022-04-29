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
    private static UserController globalUC = null;

    private User theUser;
    private UserView userView;

    //*Constructor*\\
    /**
     * Contructor for R4S's UserController
     * is private because the controller is implemented
     * as a singleton to enforce only a single instance per program run
     * and to provide a global access point for the User and its controller
     * @param theUser - the user associated with the controller
     */
    private UserController(User theUser){
        this.theUser = theUser;
        this.userView = new UserView();
    }

    //*Methods\\
    /**
     * Initializes the global user controller
     * @param theUser - the user with which to assoicate the controller
     * @return the controller
     */
    public static UserController initUserController(User theUser){
        if (globalUC == null){
            globalUC = new UserController(theUser);
        }
        return globalUC;
    }

    /**
     * Static getter for the singleton user controller
     * @return the user controller
     * @throws IllegalStateException - thrown when getter is used without the controller being initialized
     */
    public static UserController getUserController() throws IllegalStateException{
        if (globalUC == null){
            throw new IllegalStateException();
        }
        return globalUC;
    }

    /**
     * Getter for the controller's User
     * @return
     */
    public User getGlobalUser(){
        return theUser;
    }

    /**
     * Getter for the controller's UserView
     * @return
     */
    public UserView getUserView(){
        return userView;
    }

    /**
     * Initializes a RecipeBookController with the user's recipeBook
     * to execute the process of opening that menu of the application
     */
    public void openRecipeBook(){
        RecipeBookController rbController = new RecipeBookController(theUser.getRecipeBook());
        rbController.openRecipeBook();
    }

    /**
     * Initializes a MealPlannerController with the user's mealPlanner
     * to execute the process of opening that menu of the application
     */
    public void openMealPlanner(){
        MealPlannerController mpController = new MealPlannerController(theUser.getMealPlanner());
        mpController.openMealPlanner();
    }

    /**
     * Initializes a PantryController with the user's pantry
     * to execute the process of opening that menu of the application
     */
    public void openPantry(){
        PantryController pantryController = new PantryController(theUser.getPantry());
        pantryController.openPantry();
    }

    /**
     * Initializes a GroceryListController with the user's groceryList
     * to execute the process of opening that menu of the application
     */
    public void accessGroceryList(){
        GroceryListController glController = new GroceryListController(theUser.getGroceryList());
        glController.openGroceryList();
    }
    
}
