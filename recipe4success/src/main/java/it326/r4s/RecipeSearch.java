package it326.r4s;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import me.xdrop.fuzzywuzzy.*; 

public class RecipeSearch implements CollectionSearch<Recipe> {

    private Collection<Recipe> recipes;

    public RecipeSearch(Collection<Recipe> recipes){
        this.recipes = recipes;
    }

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

    public ArrayList<Recipe> searchFor(Category category){
        ArrayList<Recipe> itemsThatPassed = new ArrayList<Recipe>();

        for (Recipe recipe: recipes){
            if(recipe.getCategories().contains(category)){
                itemsThatPassed.add(recipe);
            }
        }
        return itemsThatPassed;
    }

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
