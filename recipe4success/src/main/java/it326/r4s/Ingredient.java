package it326.r4s;

import it326.r4s.UnitConverter.*;

public class Ingredient {
    private FoodItem foodItem;
    private double quantity;
    private Unit unit;

    public boolean changeUnit(Unit newUnit){
        double returnValue = UnitConverter.convertUnit(this.unit, this.quantity, newUnit);

        if(returnValue == -1){
            return false;
        }
        else{
            this.unit = newUnit;
            this.quantity = returnValue;
            return true;
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
    
}
