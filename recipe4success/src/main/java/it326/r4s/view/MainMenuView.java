package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.MainMenuController;
import it326.r4s.view.utilities.DisplayUtils;
import it326.r4s.view.utilities.InputAccess;
/**
 * View for R4S MainMenu
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class MainMenuView implements R4SMenu{
    
    //*Instance Variables\\
    public MainMenuController mmController;

    //*Constructor\\
    /**
     * Constructor for R4S's Main Menu View
     * @param mmController - the view's controller
     */
    public MainMenuView(MainMenuController mmController){
        this.mmController = mmController;
    }

    //*Methods*\\
    /**
     * Allows the user to select one of a series of options
     * @return an int representing the selected option
     */
    public int getMenuOptionSelection(){
        String title = "Main Menu";
        String prompt = "What would you like to do?";
        String[] options = {
            "Open my RecipeBook:\t\t(search, edit, or create new tasty recipes!)",
            "Open my MealPlanner:\t\t(organize your recipes into comprehensive meal plans)",
            "Open my Pantry:\t\t(organize your recipes into comprehensive meal plans.)",
            "Access my grocery list:\t(view and edit your current grocery list.)",
            "Exit Application"
        };
        InputAccess input = new InputAccess();
        return input.getOptionSelection(title, prompt, options);
    }

}
