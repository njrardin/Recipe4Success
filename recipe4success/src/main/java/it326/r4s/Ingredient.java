package it326.r4s;

import it326.r4s.UnitConverter.*;

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
     * 
     * @param newUnit
     * @return - A boolean representing the validity of the value. 
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

    public FoodItem getFoodItem() {
        return this.foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return this.unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        Ingredient other = (Ingredient) obj;
        if (!this.getFoodItem().equals(other.getFoodItem())) return false;
        else if (!this.getUnit().equals(other.getUnit())) return false;
        else return this.getQuantity() == other.getQuantity();
    }
    
}
