package it326.r4s.model;

import it326.r4s.model.UnitConverter.*;

/**
 * The Ingredient object class for the Recipe4Success application
 * 
 * @author Nate Rardin (njrardi@ilstu.edu) and Josh Nepomuceno
 * @date 4/13/22
 */
public class Ingredient {
    // *Instance Variables*\\
    private FoodItem foodItem;
    private double quantity;
    private Unit unit;

    // *Constructor*\\
    /**
     * Creates a Ingredient object with specified foodItem, quantity, and unit.
     * 
     * @param foodItem the foodItem of the Ingredient.
     * @param quantity the quantity of the Ingredient.
     * @param unit     the unit of the Ingredient.
     */
    public Ingredient(FoodItem foodItem, double quantity, Unit unit) {
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Ingredient(String name, double quantity, Unit unit){

        this.foodItem = FoodItem.Pool.getInstance().getFoodItem(name);
        this.quantity = quantity;
        this.unit = unit;
    }

    // *Methods*\\
    /**
     * Changes the unit of the Ingredient object and converts the quantity between
     * units
     * 
     * @param newUnit - Unit enumeration representing the new unit
     * @return a boolean representing the validity of the value.
     */
    public boolean changeUnit(Unit newUnit) {

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
     * 
     * @return the FoodItem object
     */
    public FoodItem getFoodItem() {
        return this.foodItem;
    }

    /**
     * Mutator for the food item associated with the ingredient
     * 
     * @param foodItem - the FoodItem object
     */
    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    /**
     * The quantity of the ingredient (as measured in terms of the Unit)
     * 
     * @return the quantity as a double
     */
    public double getQuantity() {
        return this.quantity;
    }

    /**
     * Mutator for the quantity of the ingredient (as measured in terms of the Unit)
     * 
     * @param quantity
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Accessor for the Unit enumeration of the Ingredient which describes the unit
     * 
     * @return the Unit enumeration object
     */
    public Unit getUnit() {
        return this.unit;
    }

    /**
     * Mutator for the Unit enumeration of the Ingredient which describes the unit
     * 
     * @param unit - a Unit enumeration object
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * An override for the .equals method of java.Object
     * 
     * @param Object an Ingredient object
     * @return a bool indicating if the two ingredients are equal
     */
    @Override
    public boolean equals(Object obj) {
        // Check if the compared object is of correct type
        if (!(obj instanceof Ingredient) || obj == null) {
            return false;
        }
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }
        
        Ingredient other = (Ingredient) obj;
        if (!this.getFoodItem().equals(other.getFoodItem()))
            return false;
        else if (!this.getUnit().equals(other.getUnit()))
            return false;
        else
            return this.getQuantity() == other.getQuantity();
    }

    /**
     * An override for the .toString method of java.obj
     * 
     * @return a string representation of the Ingredient object
     */
    @Override
    public String toString() {
        return this.foodItem.getName() + ": " + String.format("%.2f", this.quantity) + " " + this.unit;
    }
}
