package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.MealPlanSearchController;

public class MealPlanSearchView {
    
    private MealPlanSearchController mpsController;

    public MealPlanSearchView(MealPlanSearchController mpsController){
        this.mpsController = mpsController;
    }

    //*Methods*\\
    /**
     * Prompts the user to provide a search query input
     * @return - the search query as a String
     */
    public String getSearchQuery() {
        Scanner scan = ViewUtilities.scan;
        String input = "";
        do{
            System.out.println("Please enter the term to search the recipes for:");
            input = scan.nextLine().toLowerCase();
        } while (input == "");

        return input;
    }
}
