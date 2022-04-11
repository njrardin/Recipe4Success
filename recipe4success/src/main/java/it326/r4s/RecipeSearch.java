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
        for (Recipe recipe: recipes){
            if(recipe.getName().toLowerCase().contains(searchString.toLowerCase())){
                itemsThatPassed.add(recipe);
            }
            else if(recipe.getDescription().toLowerCase().contains(searchString.toLowerCase())){
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
