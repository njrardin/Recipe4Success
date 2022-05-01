package it326.r4s.controller;

import java.util.Scanner;

import it326.r4s.model.User;
import it326.r4s.view.MainMenuView;
import it326.r4s.view.utilities.DisplayUtils;
/**
 * Controller for R4S MainMenu
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class MainMenuController {
    
    //*Instance Variables*\\
    private UserController userController;
    private MainMenuView mainMenuView;

    //*Constructor*\\
    /**
     * Constructor for R4S's Main Menu controller
     * @param userController - a userController object associated with the application user
     */
    public MainMenuController(UserController userController){
        this.userController = userController;
        this.mainMenuView = new MainMenuView(this);
    }

    //*Methods*\\
    /**
     * Launches the main menu view to get a user option selection
     * and takes the appropriate action
     */
    public void launchMainMenu(){        
        while(true){
            int option = mainMenuView.getMenuOptionSelection();
            switch (option) {
                case 1:
                    userController.openRecipeBook();
                    break;
                case 2:
                    userController.openMealPlanner();
                    break;
                case 3:
                    userController.openPantry();
                    break;
                case 4:
                    userController.accessGroceryList();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

}
