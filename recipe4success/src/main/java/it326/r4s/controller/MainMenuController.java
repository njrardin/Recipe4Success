package it326.r4s.controller;

import it326.r4s.model.User;
import it326.r4s.view.MainMenuView;

public class MainMenuController {
    
    private User user;
    private MainMenuView mainMenuView;

    public MainMenuController(User user){
        this.user = user;
        this.mainMenuView = new MainMenuView(this);
    }

    public void executeView(){
        mainMenuView.execute();
    }

    public void openRecipeBook(){
        RecipeBookController rbController = new RecipeBookController(user.getRecipeBook());
        rbController.executeView();
    }

    public void openMealPlanner(){
        MealPlannerController mpController = new MealPlannerController(user.getMealPlanner());
        mpController.executeView();
    }

    public void openPantry(){
        PantryController pantryController = new PantryController(user.getPantry());
        pantryController.executeView();
    }

    public void accessGroceryList(){
        GroceryListController glController = new GroceryListController(user.getGroceryList());
        glController.executeView();
    }
}
