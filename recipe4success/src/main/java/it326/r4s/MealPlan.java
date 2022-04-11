package it326.r4s;

import java.util.Collection;

public class MealPlan extends Entity implements Searchable, Categorizable, Exportable {

    /**
     * Gets the ingredients required for all the recipes in this meal plan.
     * @return the collection of ingredients required.
     */
    public Collection<Ingredient> getAllIngredients() {
        // TODO #11 - implement getAllIngredients (not easy)
        return null;
    }

    @Override
    public Collection<String> getAttributeSearchStrings() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean equals(Object obj){
        // TODO Auto-generated method stub
        return false;
    }
    
}
