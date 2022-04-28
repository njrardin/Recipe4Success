package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.RecipeSearchController;
/**
 * View for R4S RecipeSearch
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeSearchView {
    
    private RecipeSearchController recipeSearchController;

    public RecipeSearchView(RecipeSearchController recipeSearchController){
        this.recipeSearchController = recipeSearchController;
    }

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
