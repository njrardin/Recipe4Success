package it326.r4s.controller;

import java.util.ArrayList;
import java.util.Collection;

import it326.r4s.model.Recipe;
import it326.r4s.model.RecipeSearch;
import it326.r4s.view.RecipeSearchView;
/**
 * Controller for R4S RecipeSearch
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeSearchController implements Controller{

    private RecipeSearch recipeSearch;
    private RecipeSearchView recipeSearchView;

    public RecipeSearchController(Collection<Recipe> recipes){
        this.recipeSearch = new RecipeSearch(recipes);
        this.recipeSearchView = new RecipeSearchView(this);
    }

    public void executeView(){

    }

    public Collection<Recipe> searchFor(String searchQuery){
        ArrayList<Recipe> returnRecipes;
        returnRecipes = recipeSearch.searchFor(searchQuery);
        return returnRecipes;
    }
}
