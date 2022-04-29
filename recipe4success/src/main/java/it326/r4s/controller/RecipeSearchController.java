package it326.r4s.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

import it326.r4s.model.Category;
import it326.r4s.model.Recipe;
import it326.r4s.model.RecipeSearch;
import it326.r4s.view.RecipeSearchView;
/**
 * Controller for R4S RecipeSearch
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeSearchController {

    //*Instance Variables*\\
    private RecipeSearch recipeSearch;
    private RecipeSearchView recipeSearchView;

    //*Constructor*\\
    /**
     * Constructor for R4S's RecipeSearchController
     * @param recipes - the recipes with which to set up the controller
     */
    public RecipeSearchController(Collection<Recipe> recipes){
        this.recipeSearch = new RecipeSearch(recipes);
        this.recipeSearchView = new RecipeSearchView(this);
    }

    //*Methods\\
    /**
     * Getter for the controller's RecipeSearch
     * @return the recipeSearch object
     */
    public RecipeSearch getRecipeSearch(){
        return recipeSearch;
    }

    /**
     * Getter for the controller's RecipeSearchView
     * @return the recipeSearchView object
     */
    public RecipeSearchView getRecipeSearchView(){
        return recipeSearchView;
    }

    /**
     * Searches through the recipeSearch object's recipes attributes and categories using the searchQuery
     * @param searchQuery - the string to search for
     * @return an ArrayList of recipes that match the query
     */
    public ArrayList<Recipe> searchFor(String searchQuery) {
        return new ArrayList<Recipe>( CollectionUtils.union(recipeSearch.searchFor(searchQuery), recipeSearch.searchFor(new Category(searchQuery))) );

    }
}
