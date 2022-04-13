package it326.r4s;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import me.xdrop.fuzzywuzzy.*; 

/**
 * An implementation of the CollectionSearch interface. Searches through collections of Recipe objects for various parameters
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/13/22
 * @dependency depends on the me.xdrop.fuzzywuzzy library for fuzzy string searches
 */
public class RecipeSearch implements CollectionSearch<Recipe> {

    private Collection<Recipe> recipes;

    public RecipeSearch(Collection<Recipe> recipes){
        this.recipes = recipes;
    }

    /**
     * Searches for a String and returns an ArrayList of any Recipes fufilling one of the following search criteria
     * 1) Name has a FuzzySearch partial ratio > 75
     * 2) Description FuzzySearch partial ratio > 75
     * @see https://github.com/xdrop/fuzzywuzzy
     * @param searchString - the string to objects search for
     * @return a collection of objects which are considered to fit the search critera given the searchString
     */
    @Override
    public ArrayList<Recipe> searchFor(String searchString) {
        ArrayList<Recipe> itemsThatPassed = new ArrayList<Recipe>();
        searchString = searchString.toLowerCase();

        for (Recipe recipe: recipes){
            if(FuzzySearch.partialRatio(searchString, recipe.getName().toLowerCase()) > 75){
                itemsThatPassed.add(recipe);
            }
            else if(FuzzySearch.partialRatio(searchString, recipe.getDescription().toLowerCase()) > 75){
                itemsThatPassed.add(recipe);
            }
        }
        return itemsThatPassed;
    }

    /**
     * Searches for a Category object and returns an ArrayList of Recipes that are tagged with that category
     * @param category - the category to search for
     * @return a collection of objects which are considered to fit the search critera given the searchString
     */
    public ArrayList<Recipe> searchFor(Category category){
        ArrayList<Recipe> itemsThatPassed = new ArrayList<Recipe>();

        for (Recipe recipe: recipes){
            if(recipe.getCategories().contains(category)){
                itemsThatPassed.add(recipe);
            }
        }
        return itemsThatPassed;
    }

    /**
     * Searches for a list of Category objects and returns an ArrayList of Recipes that are tagged with that category
     * @param category - the category to search for
     * @return a collection of objects which are considered to fit the search critera given the searchString
     */
    public ArrayList<Recipe> searchFor(Collection<Category> categoryList){
        ArrayList<Recipe> itemsThatPassed = new ArrayList<Recipe>();

        for (Recipe recipe: recipes){
            if( !(CollectionUtils.intersection(recipe.getCategories(), categoryList).isEmpty())){
                itemsThatPassed.add(recipe);
            }
        }
        return itemsThatPassed;
    }
}
