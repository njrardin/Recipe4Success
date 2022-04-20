package it326.r4s;

import it326.r4s.UnitConverter.*;

/**
 * The Ingredient object class for the Recipe4Success application
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/13/22
 */
public class Ingredient {
    private FoodItem foodItem;
    private double quantity;
    private Unit unit;

    public Ingredient(FoodItem foodItem, double quantity, Unit unit){
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.unit = unit;
    }

    /**
     * Changes the unit of the Ingredient object and converts the quantity between units
     * @param newUnit - Unit enumeration representing the new unit
     * @return a boolean representing the validity of the value. 
     */
    public boolean changeUnit(Unit newUnit){

        try {
            double convertedValue = UnitConverter.convertUnit(this.unit, this.quantity, newUnit);
            this.unit = newUnit;
            this.quantity = convertedValue;
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Accessor for the food item associated with the ingredient
     * @return the FoodItem object
     */
    public FoodItem getFoodItem() {
        return this.foodItem;
    }

    /**
     * Mutator for the food item associated with the ingredient
     * @param foodItem - the FoodItem object
     */
    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    /**
     * The quantity of the ingredient (as measured in terms of the Unit)
     * @return the quantity as a double
     */
    public double getQuantity() {
        return this.quantity;
    }

    /**
     * Mutator for the quantity of the ingredient (as measured in terms of the Unit)
     * @param quantity
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Accessor for the Unit enumeration of the Ingredient which describes the unit
     * @return the Unit enumeration object
     */
    public Unit getUnit() {
        return this.unit;
    }

    /**
     * Mutator for the Unit enumeration of the Ingredient which describes the unit
     * @param unit - a Unit enumeration object
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * An override for the .equals method of java.Object
     * @param Object - an object
     * @return a bool indicating if the two ingredients are equal
     */
    @Override
    public boolean equals(Object obj) {
        Ingredient other = (Ingredient) obj;
        if (!this.getFoodItem().equals(other.getFoodItem())) return false;
        else if (!this.getUnit().equals(other.getUnit())) return false;
        else return this.getQuantity() == other.getQuantity();
    }
    
}
