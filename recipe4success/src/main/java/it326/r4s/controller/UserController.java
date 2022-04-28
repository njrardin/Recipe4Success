package it326.r4s.controller;

import it326.r4s.model.User;
import it326.r4s.view.UserView;
/**
 * Controller for R4S User
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class UserController {
    
    private static UserController globalUC = null;

    private User theUser;
    private UserView userView;

    private UserController(User theUser){
        this.theUser = theUser;
        this.userView = new UserView();
    }

    public static UserController initUserController(User theUser){
        if (globalUC == null){
            globalUC = new UserController(theUser);
        }
        return globalUC;
    }

    public static UserController getUserController() throws IllegalStateException{
        if (globalUC == null){
            throw new IllegalStateException();
        }
        return globalUC;
    }

    public User getGlobalUser(){
        return theUser;
    }

    public UserView getUserView(){
        return userView;
    }

    public void openRecipeBook(){
        RecipeBookController rbController = new RecipeBookController(theUser.getRecipeBook());
        rbController.openRecipeBook();
    }

    public void openMealPlanner(){
        MealPlannerController mpController = new MealPlannerController(theUser.getMealPlanner());
        mpController.openMealPlanner();
    }

    public void openPantry(){
        PantryController pantryController = new PantryController(theUser.getPantry());
        pantryController.openPantry();
    }

    public void accessGroceryList(){
        GroceryListController glController = new GroceryListController(theUser.getGroceryList());
        glController.openGroceryList();
    }
    
}
