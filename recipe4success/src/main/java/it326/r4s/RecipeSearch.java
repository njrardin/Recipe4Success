package it326.r4s;

import java.util.ArrayList;
import java.util.Collection;

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
            if(FuzzySearch.partialRatio(recipe.getName().toLowerCase(), searchString) > 92){
                itemsThatPassed.add(recipe);
            }
            else if(FuzzySearch.partialRatio(recipe.getDescription().toLowerCase(), searchString) > 92){
                itemsThatPassed.add(recipe);
            }
        }
        return itemsThatPassed;
    }

    @Override
    public ArrayList<Recipe> searchFor(Collection<String> searchStrings) {
        // TODO Auto-generated method stub
        return null;
    }
}
