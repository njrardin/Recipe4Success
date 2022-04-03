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
    
}
