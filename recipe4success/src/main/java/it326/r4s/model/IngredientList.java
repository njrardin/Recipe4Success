package it326.r4s.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Class used to manage, maintain, and access a collection of ingredients
 * 
 * @author Josh Nepomuceno
 * @date 04/06/2022
 */

public class IngredientList extends Entity {
    // *Instance Variable*\\
    private ArrayList<Ingredient> ingredients;

    // *Constructors*\\
    /**
     * Creates a default IngredientList object.
     */
    public IngredientList() {
        super();
        this.ingredients = new ArrayList<Ingredient>();
    }

    /**
     * Creates a IngredientList object with a specified collection of ingredients.
     * 
     * @param ingredients a collection of ingredients.
     */
    public IngredientList(Collection<Ingredient> ingredients) {
        super();
        this.ingredients = new ArrayList<Ingredient>(ingredients);
    }

    // *methods*\\
    /**
     * Attempts to add an ingredient to the IngredientList.
     * 
     * @param toAdd an ingredient to be added to the IngredientList.
     * @return true if toAdd is already in ingredients, false otherwise.
     */
    public boolean addIngredient(Ingredient toAdd) { //TODO: this is just straight up bad. Rework the model if needed but seriously
        for (Ingredient ingredient : this.ingredients) {
            if (ingredient.getFoodItem().equals(toAdd.getFoodItem())) {
                if (!ingredient.getUnit().equals(toAdd.getUnit()))
                    try{
                        UnitConverter.convertUnit(ingredient.getUnit(), ingredient.getQuantity(), toAdd.getUnit());
                    } catch (Exception e) {
                        //do nothing
                    }
                ingredient.setQuantity(ingredient.getQuantity() + toAdd.getQuantity());
                return true;
            }
        }
        this.ingredients.add(toAdd);
        return false;
    }

    /**
     * Attempts to add an collection of ingredients to the IngredientList.
     * 
     * @param toAdd a collection of ingredients to be added to the IngredietnList.
     * @return true if any Ingredient in toAdd is already in ingredients,false
     *         otherwise.
     */
    public boolean addIngredients(Collection<Ingredient> toAdd) {
        boolean flag = true;
        for (Ingredient ingredientToAdd : toAdd) {
            if (!this.addIngredient(ingredientToAdd))
                flag = false;
        }
        return flag;
    }

    /**
     * Attempts to remove an ingredient from the IngredientList.
     * 
     * @param toRemove a ingredient to be remove from the IngredientList.
     * @return false if toRemove is not in ingredients, true otherwise.
     */
    public boolean removeIngredient(Ingredient toRemove) {
        return ingredients.remove(toRemove);
    }

    /**
     * Attempts to remove a collection of ingredients from the IngredientList.
     * 
     * @param toRemove a collection of ingredients to be removed from the
     *                 IngredientList.
     * @return false if toRemove is not in the IngredientList, true otherwise.
     */
    public boolean removeIngredients(Collection<Ingredient> toRemove) {
        return ingredients.removeAll(toRemove);
    }

    /**
     * Attempts to remove all ingredients from the IngredientList.
     */
    public void clearIngredients() {
        ingredients.clear();
    }

    /**
     * Checks whether this ingredient list contains all the ingredients of another
     * collection.
     * 
     * @param ingredients the collection of ingredients to be compared against.
     * @return True if this ingredient list contains all the ingredients (quantities
     *         of this list must be larger) of the collection, false otherwise.
     */
    public boolean containsIngredients(Collection<Ingredient> otherIngredients) {
        if (this.ingredients.containsAll(otherIngredients))
            return true;
        else {
            for (Ingredient ingredient : otherIngredients) {
                for (Ingredient otherIngredient : this.ingredients) {
                    if (!ingredient.equals(otherIngredient)) {
                        if (ingredient.getQuantity() > otherIngredient.getQuantity())
                            return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Gets all ingredients in the IngredientList.
     * 
     * @return a collection of ingredients.
     */
    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    /**
     * An override for the .equals method of java.obj.
     * 
     * @param obj an IngredientList object.
     *            private Collection<Ingredient> ingredients;
     * @return true if two IngredientLIst object are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        // Check if the compared object is of correct type
        if (!(obj instanceof IngredientList) || obj == null){
            return false;
        }
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }

        IngredientList otherIngredientList = (IngredientList) obj;
        Collection<Ingredient> otherCollection = otherIngredientList.getIngredients();
        return this.containsIngredients(otherCollection) && this.ingredients.size() == otherCollection.size();
    }

    /**
     * An override for the .toString method of java.obj.
     * 
     * @return a string representation of the Ingredient object.
     */
    @Override
    public String toString() {
        String result = "List of Ingredients:\n";
        for (Ingredient ingredient : this.ingredients) {
            result += " -\t" + ingredient.toString();
        }
        return result;
    }

    /**
     * Empties the ingredient list
     */
    public void makeEmpty() {
        ingredients = new ArrayList<Ingredient>();
    }

    /**
     * Re-organizes the ingredient list by placing 
     * the "toMove" ingredient after the "moveAfter" ingredient
     * @param toMove
     * @param moveAfter
     */
    public boolean reoganizeIngredients(Ingredient toMove, Ingredient moveAfter) {
        if( ! ingredients.contains(moveAfter)){
            return false;
        }
        ArrayList<Ingredient> newList = new ArrayList<Ingredient>();
        for(Ingredient ingredient : ingredients){
            if(ingredient.equals(toMove)){
                continue;
            }
            newList.add(ingredient);
            if(ingredient.equals(moveAfter)){
                newList.add(toMove);
            }
        }
        ingredients = newList;
        return true;
    }
}
