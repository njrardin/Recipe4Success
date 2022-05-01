package it326.r4s.view;


import it326.r4s.controller.MealPlanSearchController;
import it326.r4s.view.utilities.InputAccess;

public class MealPlanSearchView {
    
    //*Constructor*\\
    /**
     * Constructor for R4S's MealPlanSearchView
     */
    public MealPlanSearchView(MealPlanSearchController mpsController){}

    //*Methods*\\
    /**
     * Prompts the user to provide a search query input
     * @return - the search query as a String
     */
    public String getSearchQuery() {
        InputAccess inputAccess = new InputAccess();
        String input = "";
        do{
            System.out.print("Please enter the term to search the meal plans for: ");
            input = inputAccess.getInputLine().toLowerCase();
        } while (input == "");

        return input;
    }
}
