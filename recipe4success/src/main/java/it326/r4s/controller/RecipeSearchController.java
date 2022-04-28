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

    private RecipeSearch recipeSearch;
    private RecipeSearchView recipeSearchView;

    public RecipeSearchController(Collection<Recipe> recipes){
        this.recipeSearch = new RecipeSearch(recipes);
        this.recipeSearchView = new RecipeSearchView(this);
    }

    public RecipeSearch getRecipeSearch(){
        return recipeSearch;
    }

    public RecipeSearchView getRecipeSearchView(){
        return recipeSearchView;
    }

    public ArrayList<Recipe> searchFor(String searchQuery) {
        return new ArrayList<Recipe>( CollectionUtils.union(recipeSearch.searchFor(searchQuery), recipeSearch.searchFor(new Category(searchQuery))) );

    }
}
