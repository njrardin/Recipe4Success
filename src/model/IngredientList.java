package model;
import java.util.Collection;
import java.util.HashSet;

/*
* ADD HEADER HERE
* 
* 
*/

public class IngredientList extends Entity implements Exportable {
    private HashSet<Ingredient> ingredients;

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

    // returns false if toAdd is already in ingredients
    public boolean addIngredients(Collection<Ingredient> toAdd) { return ingredients.addAll(toAdd); }

    // returns false if toRemove is not in ingredients
    public boolean removeIngredient(Ingredient toRemove) { return ingredients.remove(toRemove); }

    // returns false if toRemove is not in ingredients
    public boolean removeIngredients(Collection<Ingredient> toRemove) { return ingredients.removeAll(toRemove); }

    public void clearIngredients() { ingredients.clear(); }

    // getter
    public HashSet<Ingredient> getIngredients() { return this.ingredients; }
}
