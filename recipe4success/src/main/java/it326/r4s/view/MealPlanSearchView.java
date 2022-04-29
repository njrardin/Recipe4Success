package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.MealPlanSearchController;

public class MealPlanSearchView {
    
    //*Instance variable*\\
    private MealPlanSearchController mpsController;

    //*Constructor*\\
    /**
     * Constructor for R4S's MealPlanSearchView
     * @param mpsController
     */
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
            System.out.println("Please enter the term to search the meal plans for:");
            input = scan.nextLine().toLowerCase();
        } while (input == "");

        return input;
    }
}
