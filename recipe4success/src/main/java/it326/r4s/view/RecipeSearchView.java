package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.RecipeSearchController;
import it326.r4s.view.utilities.DisplayUtils;
import it326.r4s.view.utilities.InputAccess;
/**
 * View for R4S RecipeSearch
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeSearchView {
    
    //*Instance Variables*\\
    private RecipeSearchController recipeSearchController;

    //*Constructor*\\
    /**
     * Constructor for R4S's RecipeSearchView
     * @param recipeSearchController - the RecipeSearchView's controller
     */
    public RecipeSearchView(RecipeSearchController recipeSearchController){
        this.recipeSearchController = recipeSearchController;
    }

    //*Methods*\\
    /**
     * Prompts the user to provide a search query input
     * @return - the search query as a String
     */
    public String getSearchQuery() {
        InputAccess inputAccess = new InputAccess();
        String response = "";
        do{
            System.out.println("Please enter the term to search the recipes for:");
            response = inputAccess.getInputLine().toLowerCase();
        } while (response == "");

        return response;
    }
}
