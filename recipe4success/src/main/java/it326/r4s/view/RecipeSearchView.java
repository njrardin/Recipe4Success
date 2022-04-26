package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.RecipeController;
import it326.r4s.controller.RecipeSearchController;

public class RecipeSearchView implements CLI_View{
    
    private RecipeSearchController recipeSearchController;

    public RecipeSearchView(RecipeSearchController recipeSearchController){
        this.recipeSearchController = recipeSearchController;
    }

    public void execute(){
        Scanner scan = ViewUtilities.scan;

        String searchParameter;
        System.out.println("Recipe Search:");
        System.out.println();

        System.out.println("Please input your search term: ");
        searchParameter = scan.nextLine();

        if( !(recipeSearchController.searchFor(searchParameter).isEmpty()) ){
            System.out.println("Unfortunately, no recipes were found.");
        } else {
            // for(recipe: recipes) //TODO: figure this out in a SOLID way
            // RecipeView recipeView = new RecipeView(new RecipeController(recipe));
        }
    }

}
