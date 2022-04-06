package it326.r4s;
import java.util.Collection;
import java.util.HashSet;

/*
* ADD HEADER HERE
* 
* 
*/

public class IngredientList extends Entity implements Exportable {
    private Collection<Ingredient> ingredients;

    // constructors
    public IngredientList() {
        super();
        this.ingredients = new HashSet<Ingredient>();
    }

    public IngredientList(Collection<Ingredient> ingredients) {
        super();
        this.ingredients = new HashSet<Ingredient>(ingredients);
    }

    // methods
    
    // returns false if toAdd is already in ingredients
    public boolean addIngredient(Ingredient toAdd) { return ingredients.add(toAdd); }
    // TODO add logic for combining ingredient objects together (can't just call add())

    // returns false if toAdd is already in ingredients
    public boolean addIngredients(Collection<Ingredient> toAdd) { return ingredients.addAll(toAdd); }
    // TODO add logic for combining ingredient objects together (can't just call addAll())

    // returns false if toRemove is not in ingredients
    public boolean removeIngredient(Ingredient toRemove) { return ingredients.remove(toRemove); }

    // returns false if toRemove is not in ingredients
    public boolean removeIngredients(Collection<Ingredient> toRemove) { return ingredients.removeAll(toRemove); }

    public void clearIngredients() { ingredients.clear(); }

    /**
     * Checks whether this ingredient list contains all the ingredients of another collection.
     * @param ingredients the collection of ingredients to be compared against.
     * @return True if this ingredient list contains all the ingredients (quantities of this list must be larger) of the collection, false otherwise.
     */
    public boolean containsIngredients(Collection<Ingredient> ingredients) {
        // TODO implement containsIngredients (can't just call containsAll(), need to compare the fooditem, quantity, and unit). Feel free to make submethods in other classes.
        return false;
    }

    // getter
    public Collection<Ingredient> getIngredients() { return this.ingredients; }

    
}
